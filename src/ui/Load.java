package ui;

import model.objects.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Load {

    private ObjectOutputStream oos;
    private Board board;

    public Load() {
    }

    public void escribir() throws IOException, ClassNotFoundException {

        Jail jail = new Jail(0);

        oos = new ObjectOutputStream(new FileOutputStream("data\\Data.txt"));
        oos.writeObject(board);
        oos.close();



    }

}
