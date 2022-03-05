package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(21);
        student.setName("Daniel");
        student.setSurName("Agentov");
        student.setFaculty("Energeticheskiy");
        student.setSpec("Svyaz");
        System.out.println("Имя студента " + student.getName()
                + ", фамилия студента " + student.getSurName()
                + ", факультет студента " + student.getFaculty());

    }
}
