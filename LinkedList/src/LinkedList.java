import java.util.Scanner;

public class LinkedList {

  public static  Node head;

    public static class Node{
        int data;
        Node nextNode;

        Node(int data,Node node){
            this.data =data;
            this.nextNode = node;
        }
    }

    public static void insertNodeAtEnd(int data){
        if(head == null){
            head = new Node(data,null);
          printLinkedlist(head);
            return;
        }

        Node node = head;

        while(node.nextNode != null){
            node = node.nextNode;
        }

        node.nextNode  = new Node(data,null);
       printLinkedlist(head);
    }

    public static void printLinkedlist(Node node){
        System.out.println("Linked List");
        while(node != null){
            System.out.print(node.data+" ");
            node = node.nextNode;
        }
        System.out.println();

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("enter no to be inserted   ");
            insertNodeAtEnd(scanner.nextInt());
        }
    }
}
