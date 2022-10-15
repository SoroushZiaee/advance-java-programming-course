package ir.ac.kntu;

public class VIPTripMethod implements TripMethod {
    @Override
    public int calcPrice(TripParam param) {
        int finalPrice;
        int basePrice = 10000;

        // Define the finalPrice
        finalPrice = basePrice * DistanceMap.DISTANCE.get(param.getLine());

        if (param.isRainy() & !param.isPeakTime()){
            finalPrice *= 2;
        }

        if (param.isPeakTime() & !param.isRainy()){
            finalPrice *= 2;
        }

        if (param.isRainy() & param.isPeakTime()){
            finalPrice *= 3;
        }

        return finalPrice;
    }
}
