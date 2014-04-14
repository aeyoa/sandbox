package ru.ifmo.enf.kogan.sandbox;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

/**
 * Created by arsenykogan on 26/03/14.
 */
public class RobotTest {
    public static void main(String[] args) throws AWTException, InterruptedException {

        final Sequencer sequencer = new Sequencer(300);
        final String[] patterns = {
                "*--- *-*- *--- *---",
                "---- ---- ---- --**",
        };
        final int[] keys = {
                VK_E,
                VK_R
        };

        sequencer.multiPlay(patterns, keys);
    }

    public static class Sequencer {

        static Robot robot;
        static int temp;

        public Sequencer(final int temp) throws AWTException {
            this.temp = temp;
            robot = new Robot();
        }

        public static void multiPlay(final String[] patterns, final int[] keys) throws InterruptedException {
            final String[] cleanPatterns = new String[patterns.length];
            for (int i = 0; i < patterns.length; i++) {
                cleanPatterns[i] = patterns[i].replace(" ", "");
            }
            int pos = 0;
            while (true) {
                for (int i = 0; i < cleanPatterns.length; i++) {
                    if (cleanPatterns[i].charAt(pos) == '*') {
                        robot.keyPress(keys[i]);
                        robot.keyRelease(keys[i]);
                    }
                }
                Thread.sleep((long) temp);
                pos++;
                pos = pos % 16;
            }
        }
    }

}
