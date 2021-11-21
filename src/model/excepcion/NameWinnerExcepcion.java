package model.excepcion;

public class NameWinnerExcepcion extends Exception {

    public static final long serialVersionUID = 10L;
    private final String TITLE = "Excepcion: ";

    public NameWinnerExcepcion(String mss) {
        super(mss);
    }

    public NameWinnerExcepcion() {

    }

    public void validateNameWinner(String name) throws NameWinnerExcepcion {

        if (name.equals("")) {
            throw new NameWinnerExcepcion(TITLE + "el nombre del ganador esta vacio");

        }

        if (name.length() < 3) {
            throw new NameWinnerExcepcion(TITLE + "el nombre del ganador es demasiado corto");

        }

    }

}
