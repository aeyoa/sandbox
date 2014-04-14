package ru.ifmo.enf.kogan.sandbox.guesser;

import javax.swing.*;

/**
 * Created by arsenykogan on 14/04/14.
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final GuesserUI guesserUI = new GuesserUI();
                guesserUI.setVisible(true);
            }
        });
    }
}
