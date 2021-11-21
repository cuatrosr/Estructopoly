package model.interface_class;

import java.io.IOException;

import model.objects.Board;
import ui.ApoTwoPolyGUI;

public interface Cards {

    abstract Board action(Board board, ApoTwoPolyGUI gui) throws IOException;

    abstract Board setMoney(Board board, int aux, ApoTwoPolyGUI gui) throws IOException;

}
