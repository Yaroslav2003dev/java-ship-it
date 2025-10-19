package ru.yandex.practicum;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.ParcelData;
import ru.yandex.practicum.delivery.StandardParcel;

@DisplayName("Тесты на добавления посылок в ParcelBox")
public class AddingNewParcelTest {
    private static final String PARCEL_NAME = "Машина";
    private static final int PARCEL_WEIGHT = 20;
    private static final String DESTINATION = "Москва";
    private static final int SEND_DAY = 2;
    private static final int BOX_CAPACITY = 25;

    @Test
    @DisplayName("Добавление посылки, вес которой не превышает лимит коробки — посылка успешно добавляется")
    public void addParcel_WeightWithinLimit_0Test(){
        //given
        ParcelData data= new ParcelData(PARCEL_NAME, PARCEL_WEIGHT, DESTINATION, SEND_DAY);
        StandardParcel parcel = new StandardParcel(data);
        ParcelBox<StandardParcel> standardBox= new ParcelBox<>(BOX_CAPACITY);
        //when
        int result = standardBox.addParcel(parcel);
        //then
        Assertions.assertEquals(0, result,"Ожидается 0: посылка должна быть успешно добавлена в коробку");
    }

    @Test
    @DisplayName("Добавление посылки, вес которой превышает лимит коробки — посылка не добавляется")
    public void addParcel_WeightExceedsLimit_ParcelNotAddedTest() {
        // given
        ParcelData data = new ParcelData(PARCEL_NAME, BOX_CAPACITY + 5, DESTINATION, SEND_DAY);
        StandardParcel parcel = new StandardParcel(data);
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(BOX_CAPACITY);
        // when
        int result = standardBox.addParcel(parcel);
        // then
        Assertions.assertEquals(-1, result, "Ожидается -1: вес превышен, посылка не должна быть добавлена");
    }
}
