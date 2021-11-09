package threads;

import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import objects.Board;
import objects.Properties;
import objects.PublicServices;
import objects.Token;
import objects.Train;
import ui.ApoTwoPolyGUI;

public class DealThreads extends Thread{

    private Board board;
    private int moneyBidder;
    private int moneyPurchaser;
    private ObservableList<Properties> propertiesBidder;
    private ObservableList<Properties> propertiesPurchaser;
    private String auxPurchaser;
    private ApoTwoPolyGUI gui;

 

    public DealThreads(Board board, int moneyBidder, int moneyPurchaser, ObservableList<Properties> propertiesBidder, ObservableList<Properties> propertiesPurchaser, String auxPurchaser, ApoTwoPolyGUI gui) {
        this.board = board;
        this.moneyBidder = moneyBidder;
        this.moneyPurchaser = moneyPurchaser;
        this.propertiesBidder = propertiesBidder;
        this.propertiesPurchaser = propertiesPurchaser;
        this.auxPurchaser = auxPurchaser;
        this.gui = gui;
    }


    @Override
    public void run(){

        int index = -1;
        Token player = board.getPlayers().get(board.getTurn());

        for(int i = 0; i < board.getPlayers().size(); i++){
            if(board.getPlayers().get(i).getNameToken().equals(auxPurchaser)){
                index = i;
                break;

            }

        }

        for(Properties pr :  propertiesPurchaser){

            if(pr.getId() == 1){
                for(int i = board.getPlayers().get(index).getProperties().size() - 1; i >= 0; i--){

                    if(board.getPlayers().get(index).getProperties().get(i).getName().equals(pr.getName())){
                        board.getPlayers().get(index).getProperties().remove(i);
                        pr.setOwner(player);
                        player.getProperties().add(pr);
                        break;

                    }

                }

            }else if(pr.getId() == 2){
                for(int i = board.getPlayers().get(index).getTrains().size() - 1; i >= 0; i--){

                    if(board.getPlayers().get(index).getTrains().get(i).getName().equals(pr.getName())){
                        board.getPlayers().get(index).getTrains().remove(i);
                        pr.setOwner(player);
                        player.getTrains().add(new Train(pr));
                        break;

                    }

                }

            }else{
                for(int i = board.getPlayers().get(index).getPublicServices().size() - 1; i >= 0; i--){

                    if(board.getPlayers().get(index).getPublicServices().get(i).getName().equals(pr.getName())){
                        board.getPlayers().get(index).getPublicServices().remove(i);
                        pr.setOwner(player);
                        player.getPublicServices().add(new PublicServices(pr));
                        break;

                    }

                }

            }

        }

        for(Properties pr :  propertiesBidder){

            if(pr.getId() == 1){
                for(int i = player.getProperties().size() - 1; i >= 0; i--){

                    if(player.getProperties().get(i).getName().equals(pr.getName())){
                        player.getProperties().remove(i);
                        pr.setOwner(board.getPlayers().get(index));
                        board.getPlayers().get(index).getProperties().add(pr);
                        break;

                    }

                }

            }else if(pr.getId() == 2){
                for(int i = player.getTrains().size() - 1; i >= 0; i--){

                    if(player.getTrains().get(i).getName().equals(pr.getName())){
                        player.getTrains().remove(i);
                        pr.setOwner(board.getPlayers().get(index));
                        board.getPlayers().get(index).getTrains().add(new Train(pr));
                        break;

                    }

                }

            }else{
                for(int i = player.getPublicServices().size() - 1; i >= 0; i--){

                    if(player.getPublicServices().get(i).getName().equals(pr.getName())){
                        player.getPublicServices().remove(i);
                        pr.setOwner(board.getPlayers().get(index));
                        board.getPlayers().get(index).getPublicServices().add(new PublicServices(pr));
                        break;

                    }

                }

            }

        }

        player.setMoney(player.getMoney() - moneyBidder);
        player.setMoney(player.getMoney() + moneyPurchaser);

        board.getPlayers().get(index).setMoney(board.getPlayers().get(index).getMoney() - moneyPurchaser);
        board.getPlayers().get(index).setMoney(board.getPlayers().get(index).getMoney() + moneyBidder);

        Platform.runLater(() -> {
            try {
                gui.setBoard(board);

            } catch (IOException e) {
                e.printStackTrace();

            }
           
        });
  

    }

   
}
