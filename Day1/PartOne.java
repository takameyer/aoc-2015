import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {
    public static void main(String[] args) {
        /*
         * Notes:
         * - Read input from test.txt file
         * - Process each line:
         *   - Convert line to char array
         *   - Iterate through each character
         *   - Print the line
         * - Remember to close reader when done
				 *
				 * Rules:
				 * - An open '(' means go up one floor
				 * - A closing ')' means go down one floor
         *
				 * NOTE: This just solves solution two.  I was lazy and it was too easy.
         */
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
						int floor = 0;
						int charCount = 0;
						int firstBasement = 0;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
										charCount++;
                    if (c == '(') {
                        floor++;
                    } else if (c == ')') {
                        floor--;
                    }

										if(floor == -1 && firstBasement == 0) {
											firstBasement = charCount;
										}
                }
                System.out.println(floor);
								System.out.println(firstBasement);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
