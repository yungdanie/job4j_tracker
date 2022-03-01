package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void info() {
        System.out.println("Active:" + this.active);
        System.out.println("Status:" + this.status);
        System.out.println("Message:" + this.message);
    }

    public static void main(String[] args) {
        Error type1 = new Error();
        Error type2 = new Error(true, 2, "Type2");
        Error type3 = new Error(false, 3, "Type3");
        type1.info();
        type2.info();
        type3.info();
    }
}
