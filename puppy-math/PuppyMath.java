import processing.core.PApplet;

import java.awt.*;
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
        size(size, size, PDF, "puppy-math/resources/prizes-4.pdf");
        background(new Color(255, 255, 235).getRGB());
        addGrid();
//        addPrizes("Тапочки");
//        addPrizes("Лавровое \nдерево");
//        addPrizes("Поездка \nв Прагу и Вену");
        addPrizes("Путеводители");

        exit();
    }


    private void addGrid() {
        stroke(50);
        strokeWeight(1f);
        int xy = 0;
        while (xy <= size) {
            line(xy, 0, xy, size);
            line(0, xy, size, xy);
            xy += size / count;
        }
    }

    private void addPrizes(final String magicPresent) {
        textFont(createFont("BebasNeue-Thin", 50));
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
                int shift = 60;
                fill(new Color(255, 190, 41).getRGB());
                noStroke();
                rectMode(CENTER);
                rect(y, x - shift, 80, 80, 25);
                fill(0);
//                textFont(createFont("BebasNeueRegular", 50));
                text(presents.get(index++), y, x + shift);
//                textFont(createFont("BebasNeueRegular", 50));
                text(text, y, x - shift);
            }
        }
    }

}
