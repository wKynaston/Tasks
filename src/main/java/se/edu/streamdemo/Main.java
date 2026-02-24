package se.edu.streamdemo;

import se.edu.streamdemo.data.Datamanager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        printWelcomeMessage();
        //Here the path is a relative path so we can use it on any machine
        Datamanager dataManager = new Datamanager("./data/data.txt");
        ArrayList<Task> tasksData = dataManager.loadData();

//        System.out.println("Printing all data ...");
//        printAllData(tasksData);
//        printDataUsingStreams(tasksData);
        System.out.println("Printing deadlines ...");
        printDeadlines(tasksData);
        printDeadlineUsingStreams(tasksData);
        System.out.println("Total number of deadlines (iteration): " + countDeadlines(tasksData));
        System.out.println("Total number of deadlines (streams): " + countDeadlinesUsingStreams(tasksData));
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to Task manager (using streams)");
    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesUsingStreams(ArrayList<Task> tasks){
        int count = (int) tasks.stream()
                .filter(t -> t instanceof Deadline)
                .count();
        return count;


    }
    public static void printAllData(ArrayList<Task> tasksData) {
        System.out.println("Printing Data using iteration...");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataUsingStreams(ArrayList<Task> tasks){
        System.out.println("Printing Data Using Streams...");
        tasks.stream()
                .forEach(System.out::println);
    }
    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Printing Deadline Using Iteration");
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlineUsingStreams(ArrayList<Task> tasksData){
        System.out.println("Printing Deadline Using Streams...");
        //tasksData is the list
        tasksData.stream()
                //task here is each element in the list
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }

}
