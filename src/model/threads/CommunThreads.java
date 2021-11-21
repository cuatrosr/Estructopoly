package model.threads;

import java.io.IOException;

import javafx.application.Platform;
import model.objects.Board;
import model.objects.CommunSquare;
import ui.ApoTwoPolyGUI;

public class CommunThreads extends Thread {

    private Board board;
    private ApoTwoPolyGUI gui;

    public CommunThreads(Board board, ApoTwoPolyGUI gui) {
        this.board = board;
        this.gui = gui;

    }

    @Override
    public void run() {

        CommunSquare temp = board.getCommunSquare().bSearchCommunSquare(board.getPlayers().get(board.getTurn()).getPosition());

        if (temp != null) {

            Platform.runLater(new Thread() {
                @Override
                public void run() {

                    try {
                        gui.actionCommunSquare(temp);

                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }

            });

        }

    }

}
