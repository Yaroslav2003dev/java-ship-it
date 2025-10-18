package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private static final int PRICE = 3;

    private final int timeToLive;

    public PerishableParcel(ParcelData data, int timeToLive) {
        super(data);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay){
        return timeToLive + getSendDay() <= currentDay;
    }

    @Override
    public int getPrice(){
        return PRICE;
    }


}
