package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    private static final int PRICE = 4;

    public FragileParcel(ParcelData data) {
        super(data);
    }

    @Override
    public int getPrice(){
        return PRICE;
    }

    @Override
    public void packageItem(){
        System.out.println("Посылка "+ getDescription()+" обёрнута в защитную плёнку");
        System.out.println("Посылка "+getDescription()+" упакована");
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка "+getDescription()+" изменила местоположение на "+newLocation);
    }
}
