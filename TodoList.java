import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> completed = new ArrayList<>();

        while (true) {

            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();

                    tasks.add(task);
                    completed.add(false);

                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nYour Tasks:");

                        for (int i = 0; i < tasks.size(); i++) {

                            String status;

                            if (completed.get(i)) {
                                status = "Completed";
                            } else {
                                status = "Pending";
                            }

                            System.out.println(
                                    (i + 1) + ". " + tasks.get(i)
                                            + " [" + status + "]"
                            );
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {

                        System.out.print("Enter task number to complete: ");
                        int number = scanner.nextInt();

                        if (number >= 1 && number <= tasks.size()) {
                            completed.set(number - 1, true);
                            System.out.println("Task marked as completed!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {

                        System.out.print("Enter task number to delete: ");
                        int number = scanner.nextInt();

                        if (number >= 1 && number <= tasks.size()) {
                            tasks.remove(number - 1);
                            completed.remove(number - 1);

                            System.out.println("Task deleted successfully!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using To-Do List!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
