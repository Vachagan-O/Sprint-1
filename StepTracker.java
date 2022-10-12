public class StepTracker {

    long[][] daysAndMonths = new long[12][30];
    int purposeOfSteps = 10000;
    int sumOfSteps = 0;

    public void saveDay(int month, int day, int steps) { // 1 Ввести количество шагов за определённый день

        daysAndMonths[month][day] = steps;
        System.out.println(steps + " шагов было введено в " + day + "-ый день " + month + "-ого месяца");
        System.out.println("Шаги сохранены");
    }


    public void numberOfStepsTakenPerDay(int month) { //2.1 Количество шагов по дням
        for (int i = 0; i < daysAndMonths[month].length; i++) {
            System.out.print((i) + " день: " + daysAndMonths[month][i] + ", ");
        }
    }


    public int totalNumberOfStepsPerMonth(int month) { //2.2 Общее количество шагов
        for (int i = 0; i < daysAndMonths[month].length; i++) {
            sumOfSteps += daysAndMonths[month][i];
        }
        return sumOfSteps;
    }

    public int maximumNumberOfStepsTaken(int month) { // 2.3 Максимальное пройденное количество шагов
        int maxSteps = 0;
        for (long j = 0; j < daysAndMonths[month].length; j++) {
            if (daysAndMonths[month][(int) j] > maxSteps) {
                maxSteps = (int) daysAndMonths[month][(int) j];
            }
        }
        return maxSteps;
    }

    public double averageNumberOfSteps(int month) {  // 2.4 Среднее количество шагов
        double avengerSumSteps = sumOfSteps / daysAndMonths[month].length;
        return avengerSumSteps;
    }

    public int bestSeries(int month) {  // 2.7 Лучшая серия
        int timeSteps = 0;
        int maxSteps = 0;
        for (int i = 0; i < daysAndMonths[month].length; i++) {
            if (daysAndMonths[month][i] >=  purposeOfSteps) {
                timeSteps++;
            }else {
                if (timeSteps > maxSteps){
                    maxSteps = timeSteps;
                    timeSteps = 0;
                }
            }
        }

        return maxSteps;
    }


    public void newsTarget(int target) { // 3 Изменить цель по количеству шагов в день
        purposeOfSteps = target;
        System.out.println("Новая цель: " + purposeOfSteps + " шагов.");
    }
}