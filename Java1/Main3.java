package Java1;

import java.util.Random;

class ArrayAnalysis {
    public static void main(String[] args) {
        int arraySize = 20;
        int[] numbers = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }

        System.out.println("Згенерований масив:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Кількість непарних чисел: " + oddCount);
    }
}
