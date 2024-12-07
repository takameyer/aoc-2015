import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {
    public static void main(String[] args) {
        /*
         * Notes:
         * - Surface area of a box is 2*l*w + 2*w*h + 2*h*l
         * - Need to find the area of the smallest size
         */
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            int totalSurfaceAreaAndExtra = 0;
            while ((line = reader.readLine()) != null) {
                String[] dimensions = line.split("x");
                Box box = new Box(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2]));
                totalSurfaceAreaAndExtra += box.getSurfaceArea() + box.getSmallestSide();
            }
            System.out.println(totalSurfaceAreaAndExtra);
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
    }
}
