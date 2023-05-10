import java.util.Arrays;

public class Main {
        public static void main(String[] args) {
            int[] shape = {4, 3, 3, 2};  //  <-  размерности массива
            MultiDimensionalArray array = new MultiDimensionalArray(shape);

            double number = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 2; l++) {
                            array.setValue(number++, i, j, k, l);
                        }
                    }
                }
            }

            // Прямой
            long start = System.nanoTime();
            double value = array.getValue(0, 1, 1, 0);
            System.out.println("Value at (0, 1, 1, 0) = " + value);
            long end = System.nanoTime();
            System.out.println("Time: " + (end - start));


            // Айлифф
             start = System.nanoTime();
            double valueAlyiff = array.getAlyiff(-4, 1, 1, 0);
            System.out.println("Value at (-4, 1, 1, 0) = " + valueAlyiff);
             end = System.nanoTime();
            System.out.println("Time: " + (end - start));

            // Определяющие вектора
             start = System.nanoTime();
            int[] vector = array.getVector(0, 3, 0, 2, 0, 2, 0, 1);
            System.out.println("Vector: " + Arrays.toString(vector));
             end = System.nanoTime();
            System.out.println("Time: " + (end - start));
        }
}