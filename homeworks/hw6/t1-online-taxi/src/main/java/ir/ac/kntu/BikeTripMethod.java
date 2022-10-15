package ir.ac.kntu;

public class BikeTripMethod implements TripMethod{
    @Override
    public int calcPrice(TripParam param) {
        int finalPrice;
        int basePrice = 4000;

        // Define the finalPrice
        finalPrice = basePrice * DistanceMap.DISTANCE.get(param.getLine());

        if (param.isRainy() & !param.isPeakTime()){
            finalPrice *= 0.8;
        }

        if (param.isPeakTime() & !param.isRainy()){
            finalPrice *= 2;
        }

        if (param.isRainy() & param.isPeakTime()){
            finalPrice *= 1.5;
        }

        return finalPrice;
    }
}
