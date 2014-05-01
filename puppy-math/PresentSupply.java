import java.util.*;

/**
 * Created by arsenykogan on 01/05/14.
 */
public class PresentSupply {

    private final int numberOfCells = 100;
    private List<String> real = Arrays.asList(
            "Тапочки",
            "Лавровое \nдерево",
            "Поездка \nв Прагу и Вену");
    private List<String> fake = Arrays.asList(
            "Клетчатая \nрубашка",
            "Новая \nBMW",
            "Поездка \nв Зимбабве",
            "Неделя в домике \nв Финляндии",
            "Купание \nс дельфинами",
            "iPhone 5S",
            "Встреча с Геной \nШушкевичем",
            "Коньки",
            "Абонемент \nв спортзал",
            "Кругосветное \nпутешествие",
            "Скутер",
            "Поездка \nв Лондон",
            "Надувная \nлодка",
            "Спутниковая \nтарелка",
            "Швейцарские \nчасы",
            "Прогулка \nна вертолете",
            "Посудомоечная \nмашина");

    private Random random = new Random(10);

    public List<Integer> getMultiples(final int base, final int max) {
        final List<Integer> mults = new ArrayList<Integer>();
        Integer mult = base;
        while (mult <= max) {
            mults.add(mult);
            mult += base;
        }
        Collections.shuffle(mults, random);
        return mults;
    }

    public List<Integer> getAllButMultiples(final int base, final int max) {
        final List<Integer> all = new ArrayList<Integer>();
        final List<Integer> mults = getMultiples(base, max);
        for (int i = 0; i < 100; i++) {
            if (!mults.contains(i)) {
                all.add(i);
            }
        }
        Collections.shuffle(all, random);
        return all;
    }

    public List<String> getUnsortedPresents() {

        /* Create shuffled list from 0 to 99. */
        final List<Integer> shuffledList = new ArrayList<Integer>() {
            {
                for (int i = 0; i < numberOfCells; i++) {
                    add(i);
                }
            }
        };
        Collections.shuffle(shuffledList, random);

        /* Initialize empty String list with 100 cells. */
        final List<String> presents = Arrays.asList(new String[numberOfCells]);

        /* Set first 9 * 3 elements to REAL presents. */
        int index = 0;
        for (int i = 0; i < real.size(); i++) {
            for (int j = 0; j < 9; j++) {
                presents.set(shuffledList.get(index++), real.get(i));
            }
        }
        /* Add some random presents to fill the list. */
        while (index < numberOfCells) {
            presents.set(shuffledList.get(index++), fake.get(random.nextInt(fake.size())));
        }

        return presents;

    }
}
