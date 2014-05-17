import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by arsenykogan on 18/04/14.
 */
public class PixelSort {

    final PApplet applet;

    public PixelSort(final PApplet applet) {
        this.applet = applet;
    }

    public List<PixelHue> sort(final PImage image) {
        image.loadPixels();
        final List<PixelHue> pixels = new ArrayList<>();
        int index = 1;
        for (int pixel : image.pixels) {
            pixels.add(new PixelHue(pixel, index++));
        }
        Collections.sort(pixels);

        final int rowLength = image.width;
        for (int i = 0; i < image.height; i++) {
            Collections.sort(pixels.subList(rowLength * i, rowLength * i + rowLength), new Comparator<PixelHue>() {
                @Override
                public int compare(final PixelHue o1, final PixelHue o2) {
                    if (getColorFactor(o1.getColor()) > getColorFactor(o2.getColor())) {
                        return 1;
                    }
                    if (getColorFactor(o1.getColor()) == getColorFactor(o2.getColor())) {
                        return 0;
                    }
                    return -1;
                }

                private float getColorFactor(final int color) {
                    return applet.hue(color);
                }
            });
        }
        return pixels;
    }

    public class PixelHue implements Comparable<PixelHue> {

        private final int color;
        private int index;

        public PixelHue(final int color, final int index) {
            this.color = color;
            this.index = index;
        }

        public int getColor() {
            return color;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(final int index) {
            this.index = index;
        }

        @Override
        public int compareTo(final PixelHue o) {

            if (getColorFactor(color) > getColorFactor(o.getColor())) {
                return 1;
            }
            if (getColorFactor(color) == getColorFactor(o.getColor())) {
                return 0;
            }
            return -1;
        }

        private float getColorFactor(final int color) {
            return 1 - applet.brightness(color);
//            return applet.hue(color);
        }
    }
}
