package ru.yandex.practicum.delivery;

public class ParcelData {
    public String description;
    public int weight;
    public String deliveryAddress;
    public int sendDay;

    public ParcelData(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }
}
