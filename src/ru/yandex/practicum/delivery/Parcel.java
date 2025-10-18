package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;

    public int getSendDay() {
        return sendDay;
    }

    public Parcel(ParcelData data) {
        this.description = data.description;
        this.weight = data.weight;
        this.deliveryAddress = data.deliveryAddress;
        this.sendDay = data.sendDay;
    }

    public String getDescription() {
        return description;
    }

    public void packageItem(){
        System.out.println("Посылка "+description+" упакована");
    }

    public int getWeight() {
        return weight;
    }

    public void deliver(){
        System.out.println("Посылка "+description+" доставлена по адресу "+deliveryAddress);
    }

    public abstract int getPrice();

    public int calculateDeliveryCost(){
        return getPrice()*weight;
    }
}
