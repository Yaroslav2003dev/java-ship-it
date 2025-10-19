package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelData;
import ru.yandex.practicum.delivery.PerishableParcel;

@DisplayName("Тест на выявление испорченности посылок")
public class ExpiredTest {
    private static final String PARCEL_NAME = "Пицца";
    private static final int PARCEL_WEIGHT = 3;
    private static final String DESTINATION = "Москва";
    private static final int SEND_DAY = 2;
    private static final int timeToLive = 2;
    private static final int currentDay=3;
    @Test
    @DisplayName("Выявление не испорченной посылки")
    public void isExpired_ParcelsIsGood_FalseTest(){
        //given
        ParcelData data= new ParcelData(PARCEL_NAME, PARCEL_WEIGHT, DESTINATION, SEND_DAY);
        PerishableParcel perishableparcel = new PerishableParcel(data,timeToLive);
        //when
        boolean isExpired=perishableparcel.isExpired(currentDay);
        //then
        Assertions.assertFalse(isExpired,"Посылка не должна испортиться. Ожидается False");
    }

    @Test
    @DisplayName("Выявление испорченной посылки")
    public void isExpired_ParcelExpired_TrueTest(){
        //given
        ParcelData data= new ParcelData(PARCEL_NAME, PARCEL_WEIGHT, DESTINATION, SEND_DAY);
        PerishableParcel perishableparcel = new PerishableParcel(data,timeToLive);
        //when
        boolean isExpired=perishableparcel.isExpired(currentDay+5);
        //then
        Assertions.assertTrue(isExpired,"Посылка должна испортиться. Ожидается True");
    }

    @Test
    @DisplayName("Выявление испорченной посылки на границе срока годности")
    public void isExpired_ParcelIsExpiredToday_TrueTest(){
        //given
        ParcelData data= new ParcelData(PARCEL_NAME, PARCEL_WEIGHT, DESTINATION, SEND_DAY);
        PerishableParcel perishableparcel = new PerishableParcel(data,timeToLive);
        //when
        boolean isExpired=perishableparcel.isExpired(SEND_DAY+timeToLive);
        //then
        Assertions.assertTrue(isExpired,"Посылка должна испортиться. Ожидается True");
    }
}
