package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private int sumWeight;
    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    ArrayList<T> parcelbox=new ArrayList<>();

    public int addParcel(T parcel){
       if(parcel.getWeight()+sumWeight<=maxWeight) {
           parcelbox.add(parcel);
           sumWeight+=parcel.getWeight();
           System.out.println("Посылка была успешно добавлена в коробку!");
           return 0;
       }else {
           System.out.println("Вес превышен. Посылка не будет добавлена в коробку");
           return -1;
       }
    }

    public void getAllParcels(){
    for (T parcel:parcelbox){
        System.out.println(parcel.getDescription());
    }
    }
}
