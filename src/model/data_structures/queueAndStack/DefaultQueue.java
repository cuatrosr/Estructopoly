package model.data_structures.queueAndStack;

import model.interface_class.Queue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A custom implementation of the Queue generic data type. <br>
 */
public class DefaultQueue<T> implements Queue<T>, Serializable {

    class Node<T> implements Serializable {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> next() {
            return next;
        }

        public T data() {
            return data;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    /**
     * The main contructor of the class. Creates an empty Queue. <br>
     */
    public DefaultQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(T data) {
        Node<T> element = new Node<>(data);
        if (front == null) {
            rear = element;
            front = element;
        } else {
            rear.setNext(element);
            rear = element;
        }
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T dequeue() {
        Node<T> trash = front;
        if (front == null) {
            throw new NoSuchElementException("Can't dequeue from an empty queue");
        } else if (front == rear) {
            front = rear = null;
        } else {
            front = front.next();
        }
        size--;
        return trash.data();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T front() {
        return front.data();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> head = front;
        sb.append("(");
        String prefix = "";
        while (head != null) {
            sb.append(prefix).append(head.data());
            prefix = ", ";
            head = head.next();
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Reverses the Queue,such that the frontmost element is now at the back.
     * <br>
     *
     * @return The reversed Queue, such that the unreversed Queue is still
     * accessible with `front()`. <br>
     */
    public DefaultQueue<T> reverse() {
        DefaultStack<T> aux = new DefaultStack<>();
        DefaultQueue<T> reversed = new DefaultQueue<>();
        while (!isEmpty()) {
            aux.push(dequeue());
        }
        while (!aux.isEmpty()) {
            reversed.enqueue(aux.pop());
        }
        return reversed;
    }

    public void toQueue(T[] array) {
        front = null;
        rear = null;

        for (T var : array) {
            enqueue(var);

        }

    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arr = new ArrayList<>();
        Node<T> head = front;
        while (head != null) {
            arr.add(head.data);
            head = head.next();
        }
        return arr;
    }
}
