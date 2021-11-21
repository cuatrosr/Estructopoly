package model.data_structure;

import java.io.Serializable;
import model.objects.FortuneCards;

public class BinaryTreeFortune implements Serializable {

    private static final long serialVersionUID = 7L;
    private Node<FortuneCards> head;
    private int size;

    public BinaryTreeFortune() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<FortuneCards> getHead() {
        return this.head;
    }

    public void add(FortuneCards e) {
        if (head == null) {
            head = new Node<FortuneCards>(e);

        } else {
            add(e, head);
        }

    }

    private void add(FortuneCards e, Node<FortuneCards> temp) {

        if (temp.getItem().getIdAction() >= e.getIdAction()) {
            if (temp.getPrevious() == null) {
                temp.setPrevious(new Node<FortuneCards>(e));

            } else {
                add(e, temp.getPrevious());
            }

        } else {
            if (temp.getNext() == null) {
                temp.setNext(new Node<FortuneCards>(e));

            } else {
                add(e, temp.getNext());
            }
        }

    }

    public FortuneCards get(int index) {
        return get(index, head);

    }

    private FortuneCards get(int index, Node<FortuneCards> temp) {

        if (temp.getItem().getIdAction() == index) {
            return temp.getItem();

        } else {

            if (temp.getItem().getIdAction() < index) {
                return get(index, temp.getNext());

            } else {

                return get(index, temp.getPrevious());
            }

        }

    }

}
