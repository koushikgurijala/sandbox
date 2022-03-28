package org.steveww.spark;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LocationTests {

	@Test
	@DisplayName("Distance between 0.0, 0.0 and 0.0, 0.0 = 0")
	void getDistance() {
		Location location = new Location(0, 0);
		assertEquals(0, location.getDistance(0, 0), "Distance between 0.0, 0.0 and 0.0, 0.0 should be 0");
	}

	@ParameterizedTest(name = "Distance between {0}, {1} and {2}, {3} = {4}")
	@CsvSource({ "0.0, 0.0, 0.0, 0.0, 0", "0.0, 0.0, 1.0, 1.0, 157", "0.0, 0.0, -1.0, -1.0, 157" })
	void getDistance(double lat1, double long1, double lat2, double long2, double distance) {
		Location location = new Location(lat1, long1);
		assertEquals(distance, location.getDistance(lat2, long2), () -> "Distance between " + lat1 + ", " + long1
				+ " and " + lat2 + ", " + long2 + " should be " + distance);
	}

}