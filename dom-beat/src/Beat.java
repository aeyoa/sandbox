import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by arsenykogan on 30/10/14.
 */
public class Beat extends PApplet {

    private PImage image;
    private PImage newImage;
    private int w = 38;


    @Override
    public void setup() {
        image = loadImage("dom-beat/src/resources/db-8360.jpg");
        newImage = createImage(image.width / 2, image.height, RGB);
        newImage.loadPixels();
        final int[] pixels = image.pixels;
        int index = 0;
        for (int i = 0; i < pixels.length; i++) {
            int col = i % image.width;
            if (col % (w * 2) < w) {
                newImage.pixels[index++] = pixels[i];
            }
        }
        newImage.save("dom-beat/src/resources/final.jpg");
        exit();
    }

    public void draw() {
    }
}
