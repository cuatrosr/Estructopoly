package model.objects;

public class PublicServices extends Properties {

    public PublicServices(String property, int costProperty, int numSquare, int typeSquare, int mortgage, String imageView, String name) {
        super(property, costProperty, numSquare, typeSquare, mortgage, imageView, name);
    }

    public PublicServices(Properties pr) {
        super(pr.getProperty(), pr.getCostProperty(), pr.getNumSquare(), pr.getTypeSquare(), pr.getMortgage(), pr.getImageView(), pr.getName());
    }

    public PublicServices() {
    }

    public void action() {

    }

    @Override
    public PublicServices propeties(Board board, int index) {
        return board.getPublicServicesSquare().get(index);
    }

}
