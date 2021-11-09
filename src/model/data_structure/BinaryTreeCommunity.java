package data_structure;

import java.io.Serializable;
import objects.CommunityServiceCards;

public class BinaryTreeCommunity implements Serializable {

	private static final long serialVersionUID = 7L;
	private Node<CommunityServiceCards> head;
	private int size;

	public BinaryTreeCommunity() {
        head = null;
       	size = 0;
    }
    
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<CommunityServiceCards> getHead() {
		return this.head;
	}

	public void add(CommunityServiceCards e){
		if(head == null){
			head = new Node<CommunityServiceCards>(e);

		}else{
			add(e, head);
		}
		
	}
	
   	private void add(CommunityServiceCards e, Node<CommunityServiceCards> temp){

		if(temp.getItem().getIdAction() >= e.getIdAction()){
			if(temp.getPrevious() == null){
				temp.setPrevious(new Node<CommunityServiceCards>(e));

			}else{
				add(e, temp.getPrevious());
			}

		}else {
			if(temp.getNext() == null){
				temp.setNext(new Node<CommunityServiceCards>(e));

			}else{
				add(e, temp.getNext());
			}
		}
		
	}

	public CommunityServiceCards get(int index){
		return get(index, head);

	}

	private CommunityServiceCards get(int index, Node<CommunityServiceCards> temp){

		if(temp.getItem().getIdAction() == index){
			return temp.getItem();

		}else{

			if(temp.getItem().getIdAction() < index){
				return get(index, temp.getNext());

			}else{

				return get(index, temp.getPrevious());
			}

		}

	}

  
}


