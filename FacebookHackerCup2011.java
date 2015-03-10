import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class FacebookHackerCup2011 {

    public static void main(String[] args) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(args[0]));
            String line = "";
            while((line = br.readLine()) != null){
            	
            	//Find the double square count of each number read
                doubleSquareCount(Integer.parseInt(line.trim()));
            }
        }catch(Exception e){
            throw new RuntimeException("Problem reading file: "+e.getCause());
        }finally{
            try{
                br.close();
            }catch(Exception e){}
        }
    }

    /**
     * Calculates the number of ways an integer can be expressed as the sum of two perfect squares
     * @param num arguement
     */
    private static void doubleSquareCount(int num){

        //Mathematically...
        //x2+y2 = num2;
        //x2 = num2 - y2
        //x = SqRt (num2 - y2)

        int count = 0;

        if(num == 0){
            System.out.println(++count);
        }
        else {
            Map<Integer, Integer> squares = new HashMap<>();
            for (int i = 0; i < Math.sqrt(num); i++) {
                int x = (int) Math.pow(i, 2);
                if (isPerfectSquare(num - x) && !squares.containsKey(x)) {
                    squares.put(x, num - x);
                    squares.put(num - x, x);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    private static boolean isPerfectSquare(int x){

        double sq = Math.sqrt(x);
        int sqInt = (int) sq;

        return ((sqInt * sqInt) == x);
    }
}
