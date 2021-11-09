package objects;

import java.io.IOException;

import javafx.application.Platform;
import ui.ApoTwoPolyGUI;

public class CommunityServiceCards extends WildCards{
    
	private static final long serialVersionUID = 7550310221349172151L;
	private String card;
    private int idAction;

    public CommunityServiceCards(String card, int typeAction) {
        this.card = card;
        this.idAction = typeAction;
    }

    public CommunityServiceCards() {}


    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getIdAction() {
        return this.idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }
   
    @Override
    public Board action(Board board, ApoTwoPolyGUI gui) throws IOException{

        int aux = 0;

        switch(idAction){
            case 1:
                board.getPlayers().get(board.getTurn()).setEspecialCards(true);
                break;
            
            case 2:
                board = setMoney(board, -100, gui);
                //hacer que si no le alcanza F
                break;
            
            case 3:
                board = setMoney(board, -150, gui);
                //hacer que si no le alcanza F
                break;
            
            case 4:

                for(Token player : board.getPlayers().toArray()){
                    player.setMoney(player.getMoney() - 50);
                    aux++;

                }

                board = setMoney(board, 50*(aux), gui);
            
                break;
            
            case 5:
                board = setMoney(board, 200, gui);
                break;
            
            case 6:
                board = setMoney(board, 10, gui);
                break;

            case 7:
                board = setMoney(board, 100, gui);
                break;

            case 8:
                board.getPlayers().get(board.getTurn()).setPosition(0);
                board = setMoney(board, 200, gui);
                board.getPlayers().get(board.getTurn()).setJail(true);
                break;

            case 9:
                board = setMoney(board, -100, gui);
                //ver si puede pagar
                break;

            case 10:

                aux = 0;

                for(Properties propertie : board.getPlayers().get(board.getTurn()).getProperties().toArray()){
                    aux += propertie.getHouses()*25;
                    aux += (propertie.getHotel())? 100 : 0;
                
                }
            
                board = setMoney(board,  aux, gui);
                break;

            case 11:
                if(board.getPlayers().get(board.getTurn()).getEspecialCards()){
                    board.getPlayers().get(board.getTurn()).setEspecialCards(false);
                    
                }else{ 
                    board.getPlayers().get(board.getTurn()).setPosition(10);
                    board.getPlayers().get(board.getTurn()).setPenalty(3);
                    board.getPlayers().get(board.getTurn()).setJail(true);
                    board.getCommunSquare().get(2).getJail().add(board.getPlayers().get(board.getTurn()));

                }
               
                break;

            case 12:
                board = setMoney(board,  -20, gui);
                //ver si puede pagar
                break;

            case 13:

                for(Token player : board.getPlayers().toArray()){
                    player.setMoney(player.getMoney() + 50);
                    aux++;

                }

                board = setMoney(board, -50*(aux), gui);
                //ver si puede pagar
                break;

            case 14:
                board = setMoney(board, -50, gui);
                //ver si puede pagar
            break;


        }
        
        return board;

    }

    @Override
    public Board setMoney(Board board, int aux, ApoTwoPolyGUI gui) throws IOException{
        if(aux < 0 && board.getPlayers().get(board.getTurn()).getMoney() < (aux)*(-1)){

            Platform.runLater(new Thread(){
                @Override
                public void run() {

                    try {
                        gui.bankruptcy((aux)*(-1), null);

                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
    
            });

            return gui.getBoard();

        }else{
            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() + aux);
            return board;
            
        }

       

        
    }

    

}
