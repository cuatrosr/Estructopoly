package objects;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import interface_class.Move;

public class Token extends Player implements Move{
    
	private static final long serialVersionUID = -7576993220422954011L;
	private ImageView token;
    private int id;

    public Token(int money, ImageView token, String nameToken, int id) {
        super(money, nameToken);
        this.token = token;
        this.id = id;
        
    }

    public Token(int money,  String nameToken, int numProperties, String namePlayer) {
        super(money, nameToken, numProperties, namePlayer);
    
    }

    public Token(ImageView token){
        super();
        this.token = token;
    }


    public Token() {
    }

    public ImageView getToken() {
        return this.token;
    }

    public void setToken(ImageView token) {
        this.token = token;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public ImageView moveUp(KeyCode event){

        double x = token.getLayoutX();
        double y = token.getLayoutY();

        if(event == KeyCode.A && x - PIXEL >= 22){
            x = x - PIXEL;
        }

        if(event == KeyCode.D && x + PIXEL <= 953){
            x = x + PIXEL;
        }

        if(event == KeyCode.W && y - PIXEL >= 16){
            y = y - PIXEL;
        }

        if(event == KeyCode.S && y + PIXEL <= 936){
            y = y + PIXEL;
        }

        token.setLayoutX(x);
        token.setLayoutY(y);

        return token;
        

    }



    
}
