public class Converter {

    double distance;
    double calories;

    public double distanceTraveled(int sunOfSteps) { // 2.5
        distance = sunOfSteps * 0.00075;
        return distance;
    }

    public double outputCalories(int sumOfSteps) { // 2.6
        calories = sumOfSteps   * 0.05;
        return calories;
    }
}
