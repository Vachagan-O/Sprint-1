import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);

        printMenu();

        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) { // 1 Ввести количество шагов за определённый день
                System.out.println("За какой месяц хотите ввести количество шагов?");
                System.out.println("0 - Январь ... 11 - Декабрь");

                int month = scanner.nextInt();
                while (month < 0 || month > 11) {
                    System.out.println("Вы ввели некорректное значение, введите от 1 до 12.");
                    month = scanner.nextInt();
                }
                System.out.println("За какой день хотите ввести количество шагов?");
                System.out.println("0 - первый ... 29 - тридцатый");
                int day = scanner.nextInt();
                while (day < 0 || day > 29) {
                    System.out.println("Вы ввели некорректное значение, введите от 0 до 29.");
                    day = scanner.nextInt();
                }
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Введите положительное значение");
                    steps = scanner.nextInt();
                }
                stepTracker.saveDay(month, day, steps);


            } else if (userInput == 2) { //2 Напечатать статистику
                System.out.println("За какой месяц хотите напечатать статистику?");
                System.out.println("0 - Январь ... 11 - Декабрь");
                int month = scanner.nextInt();
                if (month < 0) {
                    System.out.println("Вы ввели некорректное значение, введите от 1 до 12.");
                    break;
                } else if (month >11) {
                    System.out.println("Вы ввели некорректное значение, введите от 1 до 12.");
                    break;
                }
                System.out.println("Количество шагов по дням в выбранном месяце: "); //2.1
                stepTracker.numberOfStepsTakenPerDay(month);
                System.out.println("Общее количество шагов в выбранном месяце: "); //2.2
                System.out.println(stepTracker.totalNumberOfStepsPerMonth(month));
                System.out.println("Максимальное пройденное количество шагов в выбранном месяце:"); //2.3
                System.out.println(stepTracker.maximumNumberOfStepsTaken(month));
                System.out.println("Среднее количество шагов в выбранном месяце:"); //2.4
                System.out.println(stepTracker.averageNumberOfSteps(month));
                System.out.println("Пройденная дистанция в выбранном меясце (в км):"); //2.5
                System.out.println(converter.distanceTraveled(stepTracker.sumOfSteps));
                System.out.println("Количество сожжённых килокалорий в выбранном месяце (в ккал):"); //2.6
                System.out.println(converter.outputCalories(stepTracker.sumOfSteps));
                System.out.println("Лучшая серия в выбранном месяце:"); //2.7
                System.out.println(stepTracker.bestSeries(month));




            } else if (userInput == 3) { // 3 Изменить цель по количеству шагов в день
                System.out.println("Ввод целевого количества шагов");
                int target = scanner.nextInt();
                if (target < 0) {
                    System.out.println("Вы ввели отрицательное значение, введите корректное количество шагов");
                }
                stepTracker.newsTarget(target);





            } else {
                System.out.println("Извините, такой команды не существует.");
            }// обработка разных случаев

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
} 