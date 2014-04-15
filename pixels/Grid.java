import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by arsenykogan on 15/04/14.
 */
public class Grid extends PApplet {

    int pdfSize = 1600;
    int count = 16;
    int gridSize = pdfSize / count;
    boolean pixelsAdded = false;
    PImage img;


    public void setup() {
        img = loadImage("kroll.jpg");
        size(pdfSize, pdfSize, PDF, "pixels/output.pdf");
    }

    public void draw() {
        background(255);
        //  addPixels();
        addGrid();
        addNumbers();
        exit();
    }

    void addGrid() {
        stroke(0);
        strokeWeight(0.5f);
        int xy = 0;
        while (xy <= pdfSize) {
            line(xy, 0, xy, pdfSize);
            line(0, xy, pdfSize, xy);
            xy += pdfSize / count;
        }
    }

    void addNumbers() {
        textFont(createFont("Courier New", 10));
        textAlign(CENTER, CENTER);
        fill(0);

        int number = 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                String numberString = nf(number, 3);
                int x = i * gridSize + gridSize / 2;
                int y = j * gridSize + gridSize / 2;
                if (pixelsAdded) {
                    if (brightness(img.get(j, i)) > 255 / 2) {
                        fill(0); // Black on bright
                    } else {
                        fill(255); // White on dark
                    }
                }

                if (number == 256) {
                    textSize(5);
                    text("Help Mario\nto save Princess", y, x);
                } else {
                    text(numberString, y, x);
                }
                number++;
            }
        }
    }

    void addPixels() {
        pixelsAdded = true;
        noStroke();
        int number = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                String numberString = nf(number, 3);
                int x = i * gridSize;
                int y = j * gridSize;
                fill(img.pixels[number]);
                rect(y, x, gridSize, gridSize);
                number++;
            }
        }
    }


}
