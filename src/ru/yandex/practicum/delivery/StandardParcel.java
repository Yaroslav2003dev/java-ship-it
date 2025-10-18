package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    private static final int PRICE = 2;

    public StandardParcel(ParcelData data) {
        super(data);
    }

    @Override
    public int getPrice(){
        return PRICE;
    }

}
