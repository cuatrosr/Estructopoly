package threads;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import objects.Board;
import objects.Train;
import ui.ApoTwoPolyGUI;

public class TrainThreads extends Thread{

    private ApoTwoPolyGUI gui;
    private Board board;
    private int index = 0;
    private Train propertie;
    private boolean typeSearch;
    

    public TrainThreads(Board board,  ApoTwoPolyGUI gui, boolean typeSearch) {
        this.board = board;
        this.gui = gui;
        this.typeSearch = typeSearch;

    }

    @Override
    public void run(){

        propertie = new Train();

        for(Train square : board.getTrainSquare().toArray()){
            
            if(square.getNumSquare() == board.getPlayers().get(board.getTurn()).getPosition()){

                Platform.runLater(new Thread(){
                    @Override
                    public void run() {

                        try {

                            if(typeSearch){
                                gui.actionProperties(propertie.propeties(board, index));

                            }else{

                                if (board.getPlayers().get(board.getTurn()).getMoney() >= square.getCostProperty()) {
                                    board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - square.getCostProperty());
                                    square.setOwner(board.getPlayers().get(board.getTurn()));
                                    board.getPlayers().get(board.getTurn()).getTrains().add(square);

                                    gui.setBoard(board);
                                    gui.mainLeave(new ActionEvent());
                                       
                                }else{
                                    alert("Mala Suerte", "No cuentas con el dinero necesario para la compra");
                        
                                }

                            }
                            

                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                    }
        
                });

                break;
                
            }

            index++;
        }

        
    }

    private void alert(String title, String mss){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mss);
        alert.showAndWait();
        
    }
    
}
