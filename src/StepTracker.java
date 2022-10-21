import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter convert = new Converter();


    StepTracker() {

    }

    public int[][] SaveSteps(int[][] monthData, int month, int day, int steps) {

        monthData[month][day - 1] = steps;
        return monthData;
    }

    public void GetStatistics(int[][] monthData, int month, int goalSteps) {
        int maxSteps = 0;
        int sumSteps = 0;


        for (int j = 0; j <= monthData[month].length - 2; j++) {
            System.out.print((j + 1) + " день: " + monthData[month][j] + ", ");
        }
        System.out.println("30 день: " + monthData[month][10]);

        for (int j = 0; j <= monthData[month].length - 1; j++) {
            sumSteps = sumSteps + monthData[month][j];
            if (monthData[month][j] > maxSteps) {
                maxSteps = monthData[month][j];
            }
        }
        System.out.println("Максимальное количество шагов: " + maxSteps);
        System.out.println("Среднее количество шагов: " + sumSteps / 30);
        System.out.println("Лучшая серия за месяц: " + GetMaxSeries(monthData, month, goalSteps));
        System.out.println("Пройденная дистанция за месяц " + convert.StepsToDistance(sumSteps)); //пройденная дистанция
        System.out.println("Количество сожженых килокалорий: " + convert.StepsToCalories(sumSteps)); ////кол-во сожженых кикалорий
    }


    int GetMaxSeries(int[][] monthData, int month, int goalSteps) {
        int sequence = 0;
        int maxSeries = 0;
        for (int j = 0; j <= monthData[month].length - 1; j++) {
            if (monthData[month][j] >= goalSteps) {
                sequence = sequence + 1;
            } else if (sequence > maxSeries) {
                maxSeries = sequence;
            } else sequence = 0;
        }
        return maxSeries;


    }


    public int ChangeGoal(int goalSteps) {
        // проверить на отрицательное
        int newGoalSteps;

        System.out.println("Введите новую цель по количеству шагов");
        newGoalSteps = scanner.nextInt();
                if (newGoalSteps < 0) {
            System.out.println("Количество шагов должно быть полодительным");
        } else goalSteps = newGoalSteps;
        return goalSteps;
    }
}

