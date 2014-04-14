package ru.ifmo.enf.kogan.sandbox.guesser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by arsenykogan on 14/04/14.
 */
public class Guesser {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        boolean guessed = true;
        while (guessed) {
            int trueOrFalse = RANDOM.nextInt(2);
            String s = bufferRead.readLine();
            if (s.equals(trueOrFalse + "")) {
                score++;
            } else {
                guessed = false;
                System.out.println("You guessed " + score + " times");
            }
        }
    }
}
