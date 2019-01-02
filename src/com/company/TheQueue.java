package com.company;

import java.util.Arrays;

public class TheQueue {

    private String[] queue;
    private int queueSize;
    private int front, rear, numberOfItems = 0;

    public TheQueue(int size){
        queueSize = size;
        queue = new String[size];
        Arrays.fill(queue, "_");
    }

    public void insert(String input){
        if (numberOfItems +1 <= queueSize){
            queue[rear] = input;
            rear++;
            numberOfItems++;
        } else {
            System.out.println("Queue is full");
        }
    }

    public void remove(){
        if (numberOfItems > 0){
            System.out.println("Remove " + queue[front]);
            queue[front] = "_";
            front++;
        } else {
            System.out.println("The Queue is empty");
        }
    }

    public void print(){
        for(int i=0; i<queue.length; i++){
            System.out.print(" "+queue[i]);
        }
        System.out.println();
    }

    public void peek(){
        System.out.println("peek = "+ queue[front]);
    }

    public void priorityInsert(String input){
        int i;

        if(numberOfItems == 0){
            insert(input);
        } else {
            for (i = numberOfItems -1; i>=0; i--){
                if(Integer.parseInt(input)>Integer.parseInt(queue[i])){
                    queue[i+1] = queue[i];
                } else break;
            }
            queue[i+1] = input;
            rear++;
            numberOfItems++;
        }



    }

    public static void main(String[] args) {

        TheQueue theQueue = new TheQueue(10);
        theQueue.print();
        theQueue.priorityInsert("10");
        theQueue.print();
        theQueue.priorityInsert("20");
        theQueue.print();
        theQueue.priorityInsert("15");
        theQueue.print();
        theQueue.priorityInsert("11");
        theQueue.print();

    }
}
