package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelData;
import ru.yandex.practicum.delivery.PerishableParcel;

public class ExpiredTest {
    @Test
    public void calculatingExpired(){
        ParcelData data= new ParcelData("Пицца", 3, "Москва", 2);
        PerishableParcel perishableparcel = new PerishableParcel(data,2);
        Assertions.assertTrue(perishableparcel.isExpired(5),"Посылка не испортилась");
        Assertions.assertTrue(perishableparcel.isExpired(4),"Посылка не испортилась");
        Assertions.assertFalse(perishableparcel.isExpired(3),"Посылка испортилась");
    }
}
