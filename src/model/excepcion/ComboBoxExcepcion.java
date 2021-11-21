package model.excepcion;

import javafx.scene.control.ComboBox;

public class ComboBoxExcepcion extends Exception {

    public static final long serialVersionUID = 10L;
    private final String TITLE = "Excepcion: ";

    public ComboBoxExcepcion(String mss) {
        super(mss);
    }

    public ComboBoxExcepcion() {

    }

    public void validateComboBox(ComboBox<String> box) throws ComboBoxExcepcion {

        if (box.valueProperty().get() == null) {
            throw new ComboBoxExcepcion(TITLE + "The value of the ComboBox is null");

        }

    }

}
