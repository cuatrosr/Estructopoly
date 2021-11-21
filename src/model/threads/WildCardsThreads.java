package model.threads;

import java.io.IOException;
import javafx.application.Platform;
import model.objects.Board;
import model.objects.WildCards;
import ui.ApoTwoPolyGUI;

public class WildCardsThreads extends Thread {

    private Board board;
    private ApoTwoPolyGUI gui;
    private int index = 0;
    private WildCards wildCards;

    public WildCardsThreads(Board board, ApoTwoPolyGUI gui) {
        this.board = board;
        this.gui = gui;

    }

    @Override
    public void run() {

        wildCards = new WildCards();

        int card = (int) (Math.random() * 14) + 1;

        for (WildCards square : board.getWildCardsSquare().toArray()) {
            if (square.getNumSquare() == board.getPlayers().get(board.getTurn()).getPosition()) {

                if (board.getWildCardsSquare().get(index).isTypeWildCards()) {

                    Platform.runLater(new Thread() {
                        @Override
                        public void run() {

                            try {
                                gui.actionCommunityCard(wildCards.communityService(board, card));
                                gui.setBoard(wildCards.communityService(board, card).action(board, gui));

                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        }

                    });

                } else {

                    Platform.runLater(new Thread() {
                        @Override
                        public void run() {

                            try {
                                gui.actionFortuneCard(wildCards.fortuneCard(board, card));
                                gui.setBoard(wildCards.fortuneCard(board, card).action(board, gui));

                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        }

                    });

                }

                break;
            }

            index++;
        }

    }

}
