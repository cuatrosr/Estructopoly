package model.threads;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.objects.Board;
import model.objects.Properties;
import ui.ApoTwoPolyGUI;

public class PropertiesThreads extends Thread {

    private ApoTwoPolyGUI gui;
    private Board board;
    private int index = 0;
    private Properties propertie;
    private boolean typeSearch;

    public PropertiesThreads(Board board, ApoTwoPolyGUI gui, boolean typeSearch) {
        this.board = board;
        this.gui = gui;
        this.typeSearch = typeSearch;

    }

    @Override
    public void run() {

        propertie = new Properties();

        for (Properties square : board.getPropertiesSquare().toArray()) {

            if (square.getNumSquare() == board.getPlayers().get(board.getTurn()).getPosition()) {

                Platform.runLater(() -> {

                    try {

                        if (typeSearch) {

                            gui.actionProperties(propertie.propeties(board, index));

                        } else {

                            if (board.getPlayers().get(board.getTurn()).getMoney() >= square.getCostProperty()) {
                                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - square.getCostProperty());
                                square.setOwner(board.getPlayers().get(board.getTurn()));
                                board.getPlayers().get(board.getTurn()).getProperties().add(square);

                                ArrayList<Properties> arrayPropetie = board.getPlayers().get(board.getTurn()).getProperties().toArray();

                                //Selection Sort
                                for (int i = 0; i < arrayPropetie.size() - 1; i++) {

                                    int min = i;

                                    for (int j = i + 1; j < arrayPropetie.size(); j++) {
                                        if (arrayPropetie.get(j).getFamily() < arrayPropetie.get(min).getFamily()) {
                                            min = j;

                                        }
                                    }

                                    if (i != min) {
                                        Properties aux = arrayPropetie.get(i);
                                        arrayPropetie.set(i, arrayPropetie.get(min));
                                        arrayPropetie.set(min, aux);

                                    }

                                }

                                board.getPlayers().get(board.getTurn()).getProperties().arrayToMeList(arrayPropetie);
                                board.getPlayers().get(board.getTurn()).getProperties().setSize(arrayPropetie.size());

                                gui.setBoard(board);
                                gui.mainLeave(new ActionEvent());

                            } else {
                                alert("Mala Suerte", "No cuentas con el dinero necesario para la compra");

                            }

                        }

                    } catch (IOException e) {
                        e.printStackTrace();

                    }

                }
                );

                break;

            }

            index++;
        }

    }

    private void alert(String title, String mss) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mss);
        alert.showAndWait();

    }

}
