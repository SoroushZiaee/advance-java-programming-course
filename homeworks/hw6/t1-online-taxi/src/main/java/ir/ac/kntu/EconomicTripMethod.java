package ir.ac.kntu;

public class EconomicTripMethod implements TripMethod{
    @Override
    public int calcPrice(TripParam param) {
        int finalPrice;
        int basePrice = 5000;

        // Define the finalPrice
        finalPrice = basePrice * DistanceMap.DISTANCE.get(param.getLine());

        if (param.isRainy() & !param.isPeakTime()){
            finalPrice *= 1.2;
        }

        if (param.isPeakTime() & !param.isRainy()){
            finalPrice *= 1.2;
        }

        if (param.isRainy() & param.isPeakTime()){
            finalPrice *= 1.4;
        }

        return finalPrice;
    }
}
