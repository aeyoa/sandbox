package ru.ifmo.enf.kogan.sandbox.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arsenykogan on 14/04/14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            final BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(new Parser().parse(bufferRead.readLine()));
        }
    }
}
