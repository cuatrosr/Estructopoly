package model.threads;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import ui.ApoTwoPolyGUI;

public class PanesOrderingThreads extends Thread {

    private Pane paneBoat;
    private Pane paneBox;
    private Pane paneCar;
    private Pane paneCat;
    private Pane paneDog;
    private Pane paneHat;
    private Pane paneHole;
    private Pane paneShoes;
    private ApoTwoPolyGUI gui;

    public PanesOrderingThreads(Pane paneBoat, Pane paneBox, Pane paneCar, Pane paneCat, Pane paneDog, Pane paneHat, Pane paneHole, Pane paneShoes, ApoTwoPolyGUI gui) {
        this.paneBoat = paneBoat;
        this.paneBox = paneBox;
        this.paneCar = paneCar;
        this.paneCat = paneCat;
        this.paneDog = paneDog;
        this.paneHat = paneHat;
        this.paneHole = paneHole;
        this.paneShoes = paneShoes;
        this.gui = gui;
    }

    @Override
    public void run() {

        ArrayList<Pane> panes = new ArrayList<>();
        panes.add(paneBoat);
        panes.add(paneBox);
        panes.add(paneCar);
        panes.add(paneCat);
        panes.add(paneDog);
        panes.add(paneHat);
        panes.add(paneHole);
        panes.add(paneShoes);

        Pane auxPane = new Pane();
        int pos;

        //ordenamiento inverso por insercion
        for (int i = 0; i < panes.size(); i++) {
            pos = i;
            auxPane = panes.get(i);

            while ((pos > 0) && (panes.get(pos - 1).getOpacity() < auxPane.getOpacity()) && (panes.get(pos - 1).getOpacity() != auxPane.getOpacity())) {
                panes.set(pos, panes.get(pos - 1));
                pos--;

            }

            panes.set(pos, auxPane);

        }

        Platform.runLater(new Thread() {
            @Override
            public void run() {

                gui.playerOrdering(panes);

            }

        });

    }

}
