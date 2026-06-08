public class TimeCalculator {
    public static void main (String[] args) {
        
        //Variable Declaration
        int hours = 104; 
        int minutes = 52; 
        int seconds = 37; 
        int timeCalculation = seconds; 

        //timecalculation calculations
        timeCalculation += 43; 
        timeCalculation /= 2; 
        timeCalculation += seconds * 8;
        timeCalculation += minutes; 
        timeCalculation -= 20; 
        timeCalculation *= 13; 
        timeCalculation /= hours % 100; 
        timeCalculation -= 631;

        //Print
        System.out.println("Time: " + timeCalculation);
    }
}
