import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartTwo {
    public static void main(String[] args) {
        /*
         * Notes:
         * - The length of ribbon is the shortest distance around its sides
         * or the smallest perimeter of any one face
         * - Each bow size is equal to the cubic feet of volume of the box
         */
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./input.txt"));
            String line;
            int totalRibbonLength = 0;
            while ((line = reader.readLine()) != null) {
                String[] dimensions = line.split("x");
                Box box = new Box(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2]));
                totalRibbonLength += box.getSmallestPerimeter() + box.getVolume();
            }
            System.out.println(totalRibbonLength);
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static class Box {
        int length;
        int width;
        int height;

        public Box(int length, int width, int height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        public int getSurfaceArea() {
            return 2 * length * width + 2 * width * height + 2 * height * length;
        }

        public int getSmallestSide() {
            int side1 = length * width;
            int side2 = width * height;
            int side3 = height * length;
            return Math.min(side1, Math.min(side2, side3));
        }

        public int getSmallestPerimeter() {
            int side1 = 2 * (length + width);
            int side2 = 2 * (width + height);
            int side3 = 2 * (height + length);
            return Math.min(side1, Math.min(side2, side3));
        }

        public int getVolume() {
            return length * width * height;
        }
    }
}
