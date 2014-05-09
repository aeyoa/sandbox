import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by arsenykogan on 08/05/14.
 */
public class Dots extends PApplet {

    private int pdfWidth;
    private int pdfHeight;
    private int scale = 100; // Also a cell size
    private int[] threshold = new int[]{230, 150, 70};
    private PImage img;

    public void setup() {
        // Load image
        img = loadImage("resources/dots-2.jpg");
        pdfHeight = img.height * scale;
        pdfWidth = img.width * scale;
        background(255);

        // Output PDF file
        size(pdfWidth, pdfHeight, PDF, "happy-dots/resources/dots.pdf");

        // Draw dots
        drawDots();
//        drawNumbers(150);
//        drawCircles();

        exit();
    }

    private void drawDots() {

        /* Preparing ellipse for drawing */
        ellipseMode(CENTER);
        fill(0);
        noStroke();


        img.loadPixels();
        int index = 0;
        int count = 0;
        for (int pixel : img.pixels) {
            int radius = getDotSize(brightness(pixel));
            if (radius > 0) {
                System.out.println(index + " : " + radius);
                count++;
            }
            int radiusScale = 30;
            ellipse((index % img.width) * scale + scale / 2,
                    (index / img.width) * scale + scale / 2,
                    radius * radiusScale, radius * radiusScale);
            index++;
        }
        System.out.println(count);
    }

    private void drawCircles() {

        /* Preparing circle for drawing */
        ellipseMode(CENTER);
        noFill();
        stroke(150);
        strokeWeight(0.5f);

        int index = 0;
        for (int pixel : img.pixels) {
            for (int i = 1; i < 4; i++) {
                int radiusScale = 30;
                ellipse((index % img.width) * scale + scale / 2,
                        (index / img.width) * scale + scale / 2,
                        i * radiusScale, i * radiusScale);
            }
            index++;
        }
    }

    private void drawNumbers(final int color) {

        /* Preparing font */
        textFont(createFont("MuseoSans-500", 10));
        textAlign(CENTER, CENTER);
        fill(color);

        img.loadPixels();
        int index = 0;
        for (int pixel : img.pixels) {
            text(index + "", (index % img.width) * scale + scale / 2, (index / img.width) * scale + scale / 2 - 1);
            index++;
        }
    }

    private int getDotSize(float brightness) {
        int size = 0;
        for (int t : threshold) {
            if (brightness < t) {
                size++;
            }
        }
        return size;
    }
}
