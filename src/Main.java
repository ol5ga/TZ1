import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();
        int month;
        int day;
        int steps;
        int goalSteps = 10000;
        int [][] monthData;
        monthData = new int[11][29];


        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                // Ввести кол-во шагов за определенный день
                System.out.println("За какой день вводятся данные? (введите значение от 1 до 30)");
                day = scanner. nextInt();
                System.out.println("За какой месяц вводятся значения? (введите значение от 0 до 11)");
                month = scanner. nextInt();
                System.out.println("Введите колличество шагов за " + day + "." + month);
                steps = scanner. nextInt();
                tracker.SaveSteps(monthData, month, day, steps);

            } else if (userInput == 2) {
                // Напечатать статистику за определенный месяц
                System.out.println("За какой месяц требуется статистика?");
                month = scanner.nextInt();
                tracker.GetStatistics(monthData, month, goalSteps);
            } else if (userInput == 3) {
                //Изменить цель по кол-ву шагов в день
                goalSteps = tracker.ChangeGoal(goalSteps);
            } else System.out.println("Извините, такой команды пока нет");
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");

    }
    private static void printMenu() {
        System.out.println ("Что вы хотите сделать?");
        System.out.println("1 - Вести кол-во шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по кол-ву шагов в день");
        System.out.println("0 - Выход");
    }



}

