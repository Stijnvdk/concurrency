package util;

import java.util.Random;

/**
 * Created by Stijn on 26-11-2014.
 */
public class ArrayGenerator {

    private static Random random = new Random();


    public static int[] createArray(Integer aantal){
        int[] result = new int[aantal];
        for (int i = 0; i < aantal; i++)
        {
            result[i] = random.nextInt(25000);
        }
        return result;
    }

}
