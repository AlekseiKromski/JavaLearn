public class Main {
    public static void main(String arg[]){
        int[][] numbers = {{1,2,3},{2,3,4},{5,6,7}};
        for(int[] number: numbers){
            for(int j = 0; j < number.length; j++){
                System.out.println(number[j]);
            }
            System.out.println("++++++++");

        }
    }
}
