import processing.core.PApplet;
import processing.core.PImage;

import java.util.Arrays;

/**
 * Created by arsenykogan on 19/10/14.
 */
public class Order extends PApplet {

    private PImage image;
    private int[] pixels;
    int index = 0;
    private int number;

    @Override
    public void setup() {
        hint(ENABLE_RETINA_PIXELS);
        frameRate(60);
        image = loadImage("perfect-order/src/resources/lute-player.jpg");
        size(image.width, image.height);
        pixels = image.pixels;
    }

    /*@Override
    public void draw() {
        if (index < pixels.length) {
            for (int n = 0; n < 1; n++) {
                int maxIndex = 0;
                for (int i = index; i < pixels.length; i++) {
                    if (getCriteria(pixels[maxIndex]) < getCriteria(pixels[i])) {
                        maxIndex = i;
                    }
                }
                swapPixels(index,maxIndex);
                index++;
            }
        }

        displayPixels(pixels);
    }*/

    public void draw() {
        if (index < height) {
            Arrays.sort(pixels, index * width, index * width + width - 1);
            displayPixels(pixels);
            index++;
        } else {

        }
    }


    public void displayPixels(final int[] pixels) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                set(i, j, pixels[width * j + i]);
            }
        }
    }

    private void swapPixels(final int first, final int second) {
        int temp = pixels[first];
        pixels[first] = pixels[second];
        pixels[second] = temp;
    }

    private double getCriteria(final int color) {
        return (color);
    }


}
