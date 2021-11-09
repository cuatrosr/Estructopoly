package data_structure;

import java.io.Serializable;
import java.util.ArrayList;

import interface_class.bSearch;
import objects.CommunSquare;
import objects.Token;

public class MeLinkedLists<E> implements Serializable, bSearch {

	private static final long serialVersionUID = 4L;
	private Node<E> head;
    private Node<E> tail;
    private int size; 

    public MeLinkedLists() {
        head = null;
        size = 0;
        tail = null;
    }

	public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return (head == null)? true: false;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(E e) {
        
        if (head == null) {
            head = new Node<E>(e);
            tail = head;

        }else{
          add(e, tail, 0);

        }

        size += 1;
    }
    
    private void add(E e, Node<E> temp, int vali) {
    
        if(vali == 0){
            temp.setNext(new Node<E>(e));
            temp.getNext().setPrevious(temp);
            tail = temp.getNext();
            vali += 1;
        }
    	
        if(temp.getPrevious() != null && vali == 1){
            add(e, temp.getPrevious(), vali);
           
        }else{
            head = temp;
        }

    }

    public int indexOf(E e){
        return indexOf(e, head, 0);
    }

    private int indexOf(E e, Node<E> temp, int contador){
        if(e.equals(temp.getItem())){
            return contador;

        }else{
            return indexOf(e, temp.getNext(), contador + 1);

        }
    }

    @Override
    public Token bSearchToken(int index){

        int init = 0;
        int fin = size - 1;
        int mid = 0;
        ArrayList<Token> array = toArrayToken();

        while(init <= fin){

            mid = (init + fin) / 2;

            if(array.get(mid).getId() == index + 1){
                break;

            }else if(array.get(mid).getId() > index + 1){
                fin = mid - 1;

            }else{

                init = mid + 1;
            }


        }

        return array.get(mid);
        

    }

    @Override
    public CommunSquare bSearchCommunSquare(int index){

        int mid = 0;
        CommunSquare temp = null;
        ArrayList<CommunSquare> array = toArrayCommunSquare();
        int init = 0;
        int fin = size - 1;

        while(init <= fin){

            mid = (init + fin) / 2;

            if(array.get(mid).getNumSquare() == index){
                temp = array.get(mid);
                break;

            }else if(array.get(mid).getNumSquare() > index){
                fin = mid - 1;

            }else if(array.get(mid).getNumSquare() < index){
                init = mid + 1;

            }


        }

        return temp;
        

    }

    public E get(int index){
       
        return get(index, head);

    }
    
    private E get(int index, Node<E> temp){

        if(index == 0){
            return temp.getItem();

        }else{
            return get(index - 1, temp.getNext());

        }
       
    }

    public Node<E> getNode(int index){
       
        return getNode(index, head);

    }
    
    private Node<E> getNode(int index, Node<E> temp){

        if(index == 0){
            return temp;

        }else{
            return getNode(index - 1, temp.getNext());

        }

    }

    public void remove(int index){
        if(index == 0){
            head = head.getNext();
            
        }else{
            getNode(index).getPrevious().setNext(getNode(index).getNext());

            getNode(index).getNext().setPrevious(getNode(index).getPrevious());
 
        }

        size -= 1;
    }

    public void arrayToMeList(ArrayList<E> array){
        
        head = null;
        tail = null;

        for (int i = 0; i < array.size(); i++){
            add(array.get(i));
            
        }


    }

    public ArrayList<E> toArray(){
        ArrayList<E> array = new ArrayList<E>();

        for (int i = 0; i < size; i++){
            array.add(get(i));
            
        }

        return array;

    }

    private ArrayList<Token> toArrayToken(){
        ArrayList<Token> array = new ArrayList<>();

        for (int i = 0; i < size; i++){
            array.add((Token) get(i));
            
        }

        return array;

    }

    private ArrayList<CommunSquare> toArrayCommunSquare(){
        ArrayList<CommunSquare> array = new ArrayList<>();

        for (int i = 0; i < size; i++){
            array.add((CommunSquare) get(i));
            
        }

        return array;

    }
    
}


