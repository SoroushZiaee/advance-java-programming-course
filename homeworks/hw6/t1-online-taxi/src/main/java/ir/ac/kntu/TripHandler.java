package ir.ac.kntu;

public class TripHandler {

	private static TripHandler instance = new TripHandler();

	private TripHandler(){}

	public static TripHandler getInstance(){
		return instance;
	}

	public int calcPrice(String type, TripParam params) {
		switch (type){
			case "bike":
				return new BikeTripMethod().calcPrice(params);
			case "vip":
				return new VIPTripMethod().calcPrice(params);
			case "economic":
				return new EconomicTripMethod().calcPrice(params);
		}
		return 0;
	}

}
