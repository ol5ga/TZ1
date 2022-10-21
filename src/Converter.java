public class Converter {

    public double StepsToDistance(int SumSteps){
        double Distance;
        Distance = (SumSteps * 0.75) / 1000;

        return Distance;
    }



   public double StepsToCalories(int SumSteps){
        double Calories;
        Calories = SumSteps * 0.05;

        return Calories;
   }



}
