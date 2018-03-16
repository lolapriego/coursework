import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int ADD_ELEMENT = 1;
    private static final int DEQUEUE_ELEMENT = 2;
    private static final int PRINT_ELEMENT = 3;

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int command = in.nextInt();
            switch(command) {
                case ADD_ELEMENT:
                    int element = in.nextInt();
                    queue.addToQueue(element);
                    break;
                case DEQUEUE_ELEMENT:
                    queue.dequeue();
                    break;
                case PRINT_ELEMENT:
                    queue.printElementAtFront();
                    break;
            }
        }
    }

    /**
    * Simple things first. Let's see how this would look like using an actual Java Queue, so we
    * have the API ready. After that, we can migrate to using two stacks as a queue.
    */
    static class MyQueue {
        private Queue mQueue;

        public MyQueue() {
            mQueue = new LinkedList<Integer>();
        }

        public void addToQueue(int element) {
            mQueue.add(element);
        }

        public void dequeue() {
            mQueue.remove();
        }

        public void printElementAtFront() {
            System.out.println(mQueue.peek());
        }
    }

    /**
    * Ahora vamos a pensar cuales son todos los comandos que podemos ejecutar con
    * una Stack, https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
    * La siempre que tengamos que remover un elemento, este estará al final de
    * la Stack. Podemos volcar todos los elementos en la segunda stack, para
    * poder acceder al último. Sólo tenemos que hacer esto cuando se ejecute
    * dequeue.
    */
    static class MyQueue {
        private Stack mStackOne;
        private Stack mStackTwo;

        public MyQueue() {
            mStackOne = new Stack<Integer>();
            mStackTwo = new Stack<Integer>();
        }

        public void addToQueue(int element) {
          mStackOne.push(element);
        }

        public void dequeue() {
          if (mStackTwo.isEmpty()) {
            changeQueues(mStackOne, mStackTwo);
          }
          mStackTwo.pop();
        }

        public void printElementAtFront() {
          if (mStackTwo.isEmpty()) {
            changeQueues(mStackOne, mStackTwo);
          }
          System.out.println(mStackTwo.peek());
        }

        private void changeQueues(Stack origin, Stack destin) {
            while (!origin.empty()) {
              destin.push(origin.pop());
            }
        }
    }
}
