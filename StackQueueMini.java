//Evan Gniadek Period 3
//The purpose of this code is to test my ability to process the data in Stacks and queues 


import java.util.*;

class StackQueueMini {
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Stack<Integer> coolStack = new Stack <Integer> ();
      int times = 0;
      System.out.println("Enter five whole numbers on distinct lines " );
      while(times < 5){

        Integer toAdd = input.nextInt();
        
        if(toAdd >= 0){
          coolStack.push(toAdd);
          times++;
          
        }
        else
          System.out.println("does not compute: try again");    
      }//end of while
      coolStack = doubleUp(coolStack);
      System.out.println("your input in printed in order of most recent where every element is printed twice");
      System.out.println("top");
      while(!coolStack.isEmpty())
        System.out.println(coolStack.pop());
      System.out.println("bottom");
      //Start of queue
      Queue<Integer> coolQueue = new LinkedList<Integer> ();
      System.out.println("Enter ten whole numbers on distinct lines " );
      times = 0;
      while(times < 10){

        
        Integer toAdd = input.nextInt();
        if(toAdd >= 0){
          coolQueue.add(toAdd);
          times++;
          
        }
        else
          System.out.println("does not compute: try again");    
      }//end of while 
      coolQueue = evenThenOdd(coolQueue);
      System.out.println("Your input where the evens come first in the original order of the list than the odds in the original order of the odds");
      System.out.println("top");
      while(!coolQueue.isEmpty())
        System.out.println(coolQueue.remove());
        System.out.println("bottom");
  } // end main

  public static Stack doubleUp(Stack givenStack){
    Stack<Integer> liquidStack = new Stack <Integer> ();
    while(!givenStack.isEmpty()){
      int temp = (int)givenStack.pop();
      liquidStack.push(temp);
    }
    while(!liquidStack.isEmpty()){
      int temp = liquidStack.pop();
      for(int i = 0; i < 2; i++) givenStack.push(temp);
    }
    return givenStack;
  }
  public static Queue evenThenOdd(Queue givenQueue){
    Queue solidQueue = new LinkedList<Integer> ();
    Queue liquidQueue = new LinkedList<Integer> ();
    while(!givenQueue.isEmpty()){
      if((int)givenQueue.peek() %2 == 0)
        solidQueue.add(givenQueue.remove());
      else
        liquidQueue.add(givenQueue.remove());
    }//end of while
    while(!solidQueue.isEmpty()) givenQueue.add(solidQueue.remove());
    while(!liquidQueue.isEmpty()) givenQueue.add(liquidQueue.remove());
    return givenQueue;
  }//end of static method
} // end class