package ru.yandex.practicum;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import ru.yandex.practicum.delivery.*;

public class DeliveryCostTest {
    @Test
    public void calculatingTheCostOfParcel(){
        ParcelData data= new ParcelData("Ноутбук", 3, "Москва", 2);
        StandardParcel standardparcel = new StandardParcel(data);
        Assertions.assertEquals(6,standardparcel.calculateDeliveryCost());
        PerishableParcel perishableparcel = new PerishableParcel(data,5);
        Assertions.assertEquals(9,perishableparcel.calculateDeliveryCost());
        FragileParcel fragileparcel = new FragileParcel(data);
        Assertions.assertEquals(12,fragileparcel.calculateDeliveryCost());
    }

}
