import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by arsenykogan on 14/04/14.
 */
public class Parser {

    private final String[] splitters = {"+", "-", "*", "/", "(", ")"};
    private final String[] operators = {"+", "-", "*", "/"};
    private final HashMap<String, Integer> operationsPriorities = new HashMap<String, Integer>() {
        {
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
        }
    };

    public double parse(final String in) {

        final String input = in + "*";
        final List<String> entries = new ArrayList<>();

        /* Split input into entries. */
        String entry = "";
        for (int i = 0; i < input.length() - 1; i++) {
            entry += input.charAt(i);
            if (Arrays.asList(splitters).contains(input.charAt(i + 1) + "") ||
                    Arrays.asList(splitters).contains(input.charAt(i) + "")) {
                entries.add(entry);
                entry = "";
            }
        }
        /* Create the list of operations priorities. */
        Integer[] priorities = new Integer[entries.size()];
        for (int i = 0; i < priorities.length; i++) {
            priorities[i] = 0;
        }
        int priority = 0;
        int pos = 0;
        for (String s : entries) {
            if (s.equals("(")) {
                priority++;
            }
            if (s.equals(")")) {
                priority--;
            }
            if (Arrays.asList(operators).contains(s)) {
                priorities[pos] = priority + operationsPriorities.get(s);
            }
            pos++;
        }

        /* Calculate values. */
        final List<Integer> prioritiesList = new ArrayList<>();
        for (Integer integer : priorities) {
            prioritiesList.add(integer);
        }
        while (entries.size() > 1) {
//            entries.forEach(System.out::println);
//            System.out.println();
//            prioritiesList.forEach(System.out::println);
//            System.out.println();
            int max = -1;
            int maxPos = -1;

            for (int i = 0; i < prioritiesList.size(); i++) {
                if (prioritiesList.get(i) > max) {
                    max = prioritiesList.get(i);
                    maxPos = i;
                }
            }
            if (merge(entries, maxPos)) {
                prioritiesList.remove(maxPos + 2);
                prioritiesList.remove(maxPos + 1);
                prioritiesList.set(maxPos, -1);
                prioritiesList.remove(maxPos - 1);
                prioritiesList.remove(maxPos - 2);
            } else {
                prioritiesList.remove(maxPos + 1);
                prioritiesList.set(maxPos, -1);
                prioritiesList.remove(maxPos - 1);
            }
        }

        return Double.parseDouble(entries.get(0));
    }

    private boolean merge(final List<String> entries, final int pos) {
        final String op = entries.get(pos);
        final double left = Double.parseDouble(entries.get(pos - 1));
        final double right = Double.parseDouble(entries.get(pos + 1));
        double result;

        if (op.equals("+")) {
            result = left + right;
        } else if (op.equals("-")) {
            result = left - right;
        } else if (op.equals("*")) {
            result = left * right;
        } else if (op.equals("/")) {
            result = left / right;
        } else {
            result = 0;
        }

        entries.set(pos, result + "");
        entries.remove(pos + 1);
        entries.remove(pos - 1);
        return removeBraces(entries, pos - 1);
    }

    private boolean removeBraces(final List<String> entries, final int pos) {
        if (pos > 0 && pos < entries.size() - 1 &&
                entries.get(pos - 1).equals("(") && entries.get(pos + 1).equals(")")) {
            entries.remove(pos + 1);
            entries.remove(pos - 1);
            return true;
        }
        return false;
    }
}
