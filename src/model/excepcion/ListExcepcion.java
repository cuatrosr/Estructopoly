package model.excepcion;

public class ListExcepcion extends Exception {

    public static final long serialVersionUID = 10L;
    private final String TITLE = "Excepcion: ";

    public ListExcepcion(String mss) {
        super(mss);
    }

    public ListExcepcion() {

    }

    public void validateList(String name) throws ListExcepcion {

        if (name == null) {
            throw new ListExcepcion(TITLE + "la lista se encuentra vacia");

        }

    }

}
