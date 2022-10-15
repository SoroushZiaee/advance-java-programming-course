package ir.ac.kntu;

import java.util.HashMap;
import java.util.Map;

public class DistanceMap {
	final static Map<Line, Integer> DISTANCE = new HashMap<>();

	static {
		DISTANCE.put(new Line(0, 0), 1);
		DISTANCE.put(new Line(0, 1), 2);
		DISTANCE.put(new Line(0, 2), 2);
		DISTANCE.put(new Line(0, 3), 4);
		DISTANCE.put(new Line(0, 4), 3);

		DISTANCE.put(new Line(1, 0), 2);
		DISTANCE.put(new Line(1, 1), 1);
		DISTANCE.put(new Line(1, 2), 4);
		DISTANCE.put(new Line(1, 3), 2);
		DISTANCE.put(new Line(1, 4), 3);

		DISTANCE.put(new Line(2, 0), 3);
		DISTANCE.put(new Line(2, 1), 5);
		DISTANCE.put(new Line(2, 2), 1);
		DISTANCE.put(new Line(2, 3), 3);
		DISTANCE.put(new Line(2, 4), 2);

		DISTANCE.put(new Line(3, 0), 4);
		DISTANCE.put(new Line(3, 1), 3);
		DISTANCE.put(new Line(3, 2), 3);
		DISTANCE.put(new Line(3, 3), 1);
		DISTANCE.put(new Line(3, 4), 2);

		DISTANCE.put(new Line(4, 0), 3);
		DISTANCE.put(new Line(4, 1), 3);
		DISTANCE.put(new Line(4, 2), 2);
		DISTANCE.put(new Line(4, 3), 2);
		DISTANCE.put(new Line(4, 4), 1);
	}

}