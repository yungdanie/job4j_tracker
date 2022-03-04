package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book();
        Book bookTwo = new Book();
        Book bookThree = new Book();
        Book bookFour = new Book();
        bookFour.setName("Clean code");
        Book[] books = new Book[4];
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;
        books[3] = bookFour;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        books[0] = books[3];
        books[3] = bookOne;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }

        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " - " + books[i].getPages());
            }
        }
    }
}
