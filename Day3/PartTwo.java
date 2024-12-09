import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.awt.Point;

public class PartTwo {
	/*
	 * Notes:
	 * - Santa is delivering presents to an infinite two-dimensional grid of houses
	 * - He starts by delivering a present to the house at his starting location,
	 * which is a house at 0,0
	 * - After each move, he delivers a present to the house at his new location
	 * - The directions are given as a series of letters:
	 * - '^' moves north
	 * - 'v' moves south
	 * - '<' moves west
	 * - '>' moves east
	 */

	private static final char NORTH = '^';
	private static final char SOUTH = 'v';
	private static final char WEST = '<';
	private static final char EAST = '>';

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			String line;

			Set<Point> visitedHouses = new HashSet<>();

			Point santaCurrentLocation = new Point(0, 0);
			Point roboSantaCurrentLocation = new Point(0, 0);
			visitedHouses.add(santaCurrentLocation);

			boolean isSantaTurn = true;


			while ((line = reader.readLine()) != null) {
				for (char direction : line.toCharArray()) {
					if (isSantaTurn) {
						santaCurrentLocation = move(santaCurrentLocation, direction);
						visitedHouses.add(santaCurrentLocation);
					} else {
						roboSantaCurrentLocation = move(roboSantaCurrentLocation, direction);
						visitedHouses.add(roboSantaCurrentLocation);
					}
					isSantaTurn = !isSantaTurn;
				}
			}
			reader.close();

			System.out.println(visitedHouses.size());
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}

	private static Point move(Point currentLocation, char direction) {
		switch (direction) {
			case NORTH:
				return new Point(currentLocation.x, currentLocation.y - 1);
			case SOUTH:
				return new Point(currentLocation.x, currentLocation.y + 1);
			case EAST:
				return new Point(currentLocation.x + 1, currentLocation.y);
			case WEST:
				return new Point(currentLocation.x - 1, currentLocation.y);
			default:
				return currentLocation;
		}
	}
}
