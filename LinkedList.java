import java.util.*;

public class LinkedList<T> implements List<T> 
{
    Node head;
    int size;

    private class Node
    {
        T data;
        Node next;
        public Node(T item) 
        {
            this.data = item;
            this.next = null;
        }
    }

    public LinkedList() 
    {
        this.head = new Node(null);
        this.size = 0;
    }

    public void add(T item) 
    {
        if(head.data == null) 
        {
            head = new Node(item);
            size++;
        }
        else 
        {
         
            Node node = new Node(item);
            Node old = head; 
            while(old.next != null) 
            { 
                old = old.next; 
            }
            old.next = node;
            size++;
        }
    }

    public void add(int pos, T item) 
    {
        if(pos == 0) {
            Node node = new Node(item);
            node.next = head;
            head = node;
            size++;
        }
        else 
        {
            Node old = head;
            for(int i = 0; i < pos ; i++) 
            {
                old = old.next;
            }
            Node node = new Node(item);
            node.next = old.next;
            old.next = node;
            size++;
        }
    }

    public T remove(int pos) 
    {
        if(pos > size || pos < 0) 
        {
            return null;
        }
        if(pos == 0) 
        {
            Node node = head;
            head = head.next;
            size--;
            return node.data;
        }
        Node old = head;
        for(int i = 0; i < pos; i++) 
            old = old.next;
        Node node = old.next;
        old.next = node.next;
        size--;
        return node.data;
    }

    public T get(int pos) 
    {
        Node current = head;
        int counts = 0;

        if(pos < 0 || pos > size-1) 
        {
            return null;
        }
        else 
        {
            while(current!=null) 
            {
                if(counts == pos) 
                {
                    return current.data;
                }
                counts++;
                current = current.next;
            }
        }
        return null;
    }

    public int size() 
    {
        return size;
    }
}
