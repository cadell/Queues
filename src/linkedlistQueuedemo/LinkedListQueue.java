/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistQueuedemo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

/**
   An implementation of a queue as a sequence of nodes.
*/
public class LinkedListQueue implements Iterable<LinkedListQueue.Node>
{
   private Node first;
   private Node last;
   
   /** 
      Constructs an empty queue.
   */
   public LinkedListQueue()
   {  
      first = null;
      last = null;
   }

   /**
      Adds an element to the top of the stack.
      @param element the element to add
   */
   public void enqueue(Object element)
   {  
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = null;
      if (last != null)
      {
          last.next = newNode;
      }
      
      if (first == null)
      {
          first = newNode;
      }
      
      last = newNode;
   }

   /**
      Removes the element from the top of the stack.
      @return the removed element
   */
   public Object dequeue()
   {  
      if (first == null) { throw new NoSuchElementException(); }
      Object element = first.data;
      if (first == last)
      {
         last = null;
      }

      first = first.next;
      return element;
   }

   /**
      Checks whether this stack is empty.
      @return true if the stack is empty
   */
   public boolean empty()
   {
      return first == null;
   }

    @Override
    public Iterator<Node> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new NodeIterator();
    }

    class NodeIterator implements Iterator<Node>
    {
        private Node currents;
        public boolean hasNext()
        {
            if(currents == null)
            {
                currents = first;
                return Optional.ofNullable(currents).isPresent();
            }
            else
            {
                currents = currents.next;
                return Optional.ofNullable(currents).isPresent();
            }
        }

        @Override
        public String toString() {
            return "NodeIterator{" + "currents=" + currents + '}';
        }
        
        public Node next()
        {
            return currents;
        }
    }
   
   class Node
   {  
      public Object data;
      public Node next;

        @Override
        public String toString() {
            return (String)data;
        }
      
   }
}
