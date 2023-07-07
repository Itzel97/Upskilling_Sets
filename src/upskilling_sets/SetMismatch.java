

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

    // Objective: Receive an array of numbers of length n whose elements are {1,2,...,n}
    // but one number is duplicated. Find the duplicate and return the missing number
    public static void main(String[] args) {
        int[] numbers = {3, 2, 4, 1, 5, 9, 4, 8, 6}; // {1,2,3,4,5,6,7,8,9} = 9 * (10) / 2 = 45
        // Expected output =  duplicate = 4, missing_number = 7

        int[] result = findMismatch(numbers);
        System.out.println("Duplicate = "+result[0]);
        System.out.println("Missing = "+result[1]);
    }

    public static int[] findMismatch(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0;
        int n = numbers.length;
        long sum = (n * (n+1)) / 2; // = 45
        int realSum = 0;

        for(int i : numbers) {
            if(!set.add(i)) duplicate = i;
            realSum += i;
        }

        // = 42
        int missingNumber = (int)sum - realSum + duplicate;

        return new int[] {duplicate, missingNumber};
    }

    public static int[] findMismatchSolucion(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int[] arreglo = new int[2];
        int indice = 1;

        for(int i : numbers){
            if(!set.add(i))
                arreglo[0] = i;

            if(!set.contains(indice)) arreglo[1] = indice;
            indice++;
        }

        return arreglo;
    }

    public static int[] findMismatchPrimeraSolucion(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int[] arreglo = new int[2];
        int n = numbers.length;

        for(int i : numbers){
            if(!set.add(i)){
                arreglo[0] = i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)) arreglo[1] = i;
        }

        return arreglo;
    }
}
