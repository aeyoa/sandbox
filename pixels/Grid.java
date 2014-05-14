import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

/**
 * Created by arsenykogan on 15/04/14.
 */
public class Grid extends PApplet {

    private int count;
    private int gridSize = 100; // Cell size is always 100px
    private int pdfSize;
    private boolean pixelsAdded = false;
    private PImage img;
    private List<PixelSort.PixelHue> sortedPixels;

    public void setup() {
        // Load image
        img = loadImage("resources/nad-20.jpg");
        // Get width from this image to set up the cells count
        count = img.width;
        // Calculate pdf size
        pdfSize = count * gridSize;

        final String pdfName = "nad-20";
        /* Only one method on one run. */
//        drawEmptyGrid(pdfName);
//        drawPixelGrid(pdfName);
        drawTextPixelGrid(pdfName);
    }

    public void draw() {
    }

    public void drawEmptyGrid(final String name) {
        background(255);
        // Output PDF file
        size(pdfSize, pdfSize, PDF, "pixels/resources/" + name + "-grid.pdf");
        sortPixels(false);
        addGrid();
        addNumbers();
        exit();
    }

    public void drawPixelGrid(final String name) {
        // Output PDF file
        size(pdfSize, pdfSize, PDF, "pixels/resources/" + name + "-pixels.pdf");
        sortPixels(true);
        addGrid();
        addPixels();
        addNumbers();
        exit();
    }

    public void drawTextPixelGrid(final String name) {
        // Output PDF file
        size(pdfSize, pdfSize, PDF, "pixels/resources/" + name + "-test.pdf");
        sortPixels(false);
        addGrid();
        addPixels();
        addNumbers();
        exit();
    }

    /* Paints a grid on the image */
    private void addGrid() {
        stroke(0);
        strokeWeight(0.5f);
        int xy = 0;
        while (xy <= pdfSize) {
            line(xy, 0, xy, pdfSize);
            line(0, xy, pdfSize, xy);
            xy += pdfSize / count;
        }
    }

    /* Paints a colored cells from.
    * Gets colors from sorted array of pixels. */
    private void addPixels() {
        pixelsAdded = true;
        noStroke();
        int number = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int x = i * gridSize;
                int y = j * gridSize;
                fill(img.pixels[number]);
                rect(y, x, gridSize, gridSize);
                number++;
            }
        }
    }

    /* Adds number to each cell
    * that correspond the index in the sorted array of pixels. */
    private void addNumbers() {
        textFont(createFont("Courier New", 10));
        textAlign(CENTER, CENTER);
        fill(0);

        int number = 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
//                String numberString = nf(number, 3);
                String numberString = nf(sortedPixels.get(i * count + j).getIndex(), 3);
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
                    text("Iconic", y, x);
                } else {
                    text(numberString, y, x);
                }
                number++;
            }
        }
    }

    /* Sort pixels of the image */
    private void sortPixels(final boolean doSort) {
        sortedPixels = new PixelSort(this).sort(img);
        if (doSort) {
            img.loadPixels();
            int pixelIndex = 0;
            for (PixelSort.PixelHue sortedPixel : sortedPixels) {
                img.pixels[pixelIndex++] = sortedPixel.getColor();
            }
            img.updatePixels();
        } else {
            int unsortedImagePixelIndex = 1;
            for (PixelSort.PixelHue sortedPixel : sortedPixels) {
                sortedPixel.setIndex(unsortedImagePixelIndex++);
            }
        }

    }


}
