import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>
{

    private int size;
    private T[] linked;
    private Node head;

    
    public class Node 
    {
        T data;
        Node next;

        /* Node Constructor */
        Node(T newData)
        {
            data = newData;
            next = null;
        }
    }

    class LinkedListIterator implements Iterator<T>
    {
        
        Node index;

        public LinkedListIterator()
        {
            index = head;
        }

       
        public boolean hasNext()
        {
           
            if(index != null)
            {
                return true;
            } 
            else
            {
                return false;
            }
        }

       
        public T next()
        {
           
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
           
            T value = index.data;
            index = index.next;
            return value;
        }
    }

    public void add(T item)
    {

        Node current = new Node(item);
        if(size == 0)
        {
            head = current;
            current.next = null;
        }
        else 
        {
            LinkedListIterator list = new LinkedListIterator();
            for(int i = 0; i < size; i++)
            {
                list.next();
            }
            
            list.index.next = current;
            current.next = null;
        }
        ++size;

    }

    public void add(int pos, T item)
    {
        if(pos == 0)
        {
            Node current = new Node(item);
            current.next = head;
            head = current;
        } 
        else 
        {
            Node prev = head;
            for(int i = 0; i < pos - 1; i++)
            {
                prev = prev.next;
            }

            Node current = new Node(item);
            prev.next = current;
            current.next = prev.next;
        }
        size++;
    }

    public T get(int pos)
    {
        if(pos < 0) 
        {
            return null;
        }

        Node node = head;
        for(int i = 0; i < pos; i++){
            node = node.next;
        }
        return node.data;

    }

    public T remove(int pos)
    {

        if(pos < 0 || pos+1 > size)
        {
            return null;
        }
        Node current;
 
        if(pos == 0)
        {
            current = head;
            head = head.next;
        } 
        else 
        {
            LinkedListIterator list = new LinkedListIterator();
            for(int i = 0; i < pos; i++)
            {
                list.next();
            }

            current = list.index;
            current.next = list.index.next.next;
        }
        --size;
        return current.data;

    }
    public int size()
    {
        return size;
    }

}