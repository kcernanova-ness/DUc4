package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        System.out.println("1. Using Java Stream API find out sum of all numbers between 1 and 10000 that are dividable by both 3 and 5 but not dividable by 7");
        System.out.println(Stream.iterate(1, A -> A + 1)
                            .limit(10000)
                            .filter(A -> A % 3 == 0)
                            .filter(A -> A % 5 == 0)
                            .filter(A -> A % 7 != 0)
                            .mapToInt(A -> A)
                            .sum());
        System.out.println();

        System.out.println("2. Using Java Stream API print first 100 even numbers that are not dividable by 8");
        Stream.iterate(1, A -> A + 1)
                .filter(A -> A % 2 == 0)
                .filter(A -> A % 8 != 0)
                .limit(100)
                .forEach(A -> System.out.print(A+" "));
        System.out.println();
        System.out.println();


        List<Book> list = new ArrayList<>();
        list.add(new Book("Romeo and Juliet", 120));
        list.add(new Book("Hamlet", 100));
        list.add(new Book("Harry Potter and the Order of the Phoenix", 59));
        list.add(new Book("Animal Farm", 67));
        list.add(new Book("Jane Eyre", 28));
        list.add(new Book("Alice's Adventures in Wonderland", 250));
        list.add(new Book("The Little Prince", 115));
        list.add(new Book("Dracula", 46));
        list.add(new Book("Little Women", 89));
        list.add(new Book("Harry Potter and the Deathly Hallows", 62));

        System.out.println("3.1 Using Java Stream API print names (in alphabetic order) of all books that have price smaller than 100.");
        list.stream().sorted(Comparator.comparing(Book::getName)).filter(A -> A.getPrice() < 100).forEach(A -> System.out.println(A.getName()));
        System.out.println();

        System.out.println("3.2 Using Java stream API find out how many books have name shorter than 5 characters.");
        System.out.println(list.stream().map(A -> A.getName()).filter(A -> A.length() < 5).count());
        System.out.println();

        System.out.println("3.3 Using Java stream API find out what is the average price of the book in the list");
        System.out.println(list.stream().mapToInt(A -> A.getPrice()).average().getAsDouble());
        System.out.println();

        System.out.println("3.4 Using Java stream API find out if all books in list are cheaper than 500.");
        System.out.println(list.stream().map(A -> A.getPrice()).allMatch(A -> A < 500));
    }
}
