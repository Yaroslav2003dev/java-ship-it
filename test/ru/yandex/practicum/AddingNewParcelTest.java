package ru.yandex.practicum;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.ParcelData;
import ru.yandex.practicum.delivery.StandardParcel;

public class AddingNewParcelTest {


    @Test
    public void addingNewParcelToTheBox(){
        ParcelData data= new ParcelData("Машина", 20, "Москва", 2);
        StandardParcel parcel = new StandardParcel(data);
        ParcelBox<StandardParcel> standardBox= new ParcelBox<>(25);
        Assertions.assertEquals(0, standardBox.addParcel(parcel),"Вес превышен. Посылка не будет добавлена в коробку");
        Assertions.assertEquals(-1, standardBox.addParcel(parcel),"Посылка была успешно добавлена в коробку!");
    }
}
