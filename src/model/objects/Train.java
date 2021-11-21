package model.objects;

public class Train extends Properties {

    public Train(String property, int costProperty, int rentalProperty, int numSquare, int typeSquare, int mortgage, String imageView, String name) {
        super(property, costProperty, rentalProperty, numSquare, typeSquare, mortgage, imageView, name);
    }

    public Train(Properties pr) {
        super(pr.getProperty(), pr.getCostProperty(), pr.getRentalProperty(), pr.getNumSquare(), pr.getTypeSquare(), pr.getMortgage(), pr.getImageView(), pr.getName());
    }

    public Train() {
    }

    @Override
    public Train propeties(Board board, int index) {
        return board.getTrainSquare().get(index);
    }

}
