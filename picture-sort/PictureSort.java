import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

/**
 * Created by arsenykogan on 15/05/14.
 */
public class PictureSort extends PApplet {

    private PImage image;
    private PImage sortedImage;
    private String filename = "me.jpg";

    public void setup() {
        image = loadImage("resources/" + filename);
        final PixelSort pixelSort = new PixelSort(this);
        final List<PixelSort.PixelHue> pixels = pixelSort.sort(image);

        sortedImage = createImage(image.width, image.height, RGB);
        sortedImage.loadPixels();
        for (int i = 0; i < sortedImage.pixels.length; i++) {
            sortedImage.pixels[i] = pixels.get(i).getColor();
        }

        size(image.width, image.height);
        image(sortedImage, 0, 0);
        save("picture-sort/resources/" + filename.replace(".", "-result."));
        noLoop();
    }
}
