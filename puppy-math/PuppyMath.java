import processing.core.PApplet;

import java.util.Iterator;
import java.util.List;

/**
 * Created by arsenykogan on 15/04/14.
 */
public class PuppyMath extends PApplet {

    private final int size = 3000;
    private final int count = 10;
    private final int cellSize = size / count;


    public void setup() {
        size(size, size, PDF, "puppy-math/resources/prizes-1.pdf");
        background(255);
        addGrid();
        addPrizes("Тапочки");

        exit();
    }


    private void addGrid() {
        stroke(0);
        strokeWeight(3f);
        int xy = 0;
        while (xy <= size) {
            line(xy, 0, xy, size);
            line(0, xy, size, xy);
            xy += size / count;
        }
    }

    private void addPrizes(final String magicPresent) {
        textFont(createFont("BebasNeueRegular", 40));
        textAlign(CENTER, CENTER);
        fill(0);

        final PresentSupply presentSupply = new PresentSupply();
        final List<String> presents = presentSupply.getUnsortedPresents();
        final Iterator<Integer> magicNumbers = presentSupply.getMultiples(9, 81).iterator();
        final Iterator<Integer> allNumbers = presentSupply.getAllButMultiples(9, 81).iterator();

        int index = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int x = i * cellSize + cellSize / 2;
                int y = j * cellSize + cellSize / 2;

                String text;
                if (presents.get(index).equals(magicPresent)) {
                    text = magicNumbers.next().toString();
                } else {
                    text = allNumbers.next().toString();
                }
                int shift = 50;
                fill(68, 240, 255);
                noStroke();
                rectMode(CENTER);
                rect(y, x - shift, 70, 70);
                fill(0);
                text(presents.get(index++), y, x + shift);
                text(text, y, x - shift);
            }
        }
    }

}
