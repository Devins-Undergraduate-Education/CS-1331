public class Test {
    public static void main(String args[]) {
        String s = "Veiled Caverns: 1234, 56";
        String[] arrOfInfo = s.split(", |\\: ");
        for(int i = 0; i < arrOfInfo.length; i++) {
        System.out.println("\"" + arrOfInfo[i] + "\"");
        }
    }
}