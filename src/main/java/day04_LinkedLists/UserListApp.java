package day04_LinkedLists;

public class UserListApp {

    public static void main(String[] args) {

         UserLinkedList list = new UserLinkedList();

         list.insertLast(new UserNode("Carol", "Smith"));
         list.insertLast(new UserNode("Jack", "Reacher"));
         list.insertLast(new UserNode("John", "Doe"));
         list.printNames();

         list.deleteByName("Jack");
         list.printNames();
    }
}