package ru.yandex.practicum;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import ru.yandex.practicum.delivery.*;

@DisplayName("Тесты на вычисления стоимости посылок")
public class DeliveryCostTest {
    private static final String PARCEL_NAME = "Ноутбук";
    private static final int PARCEL_WEIGHT = 3;
    private static final String DESTINATION = "Москва";
    private static final int SEND_DAY = 2;
    private static final int timeToLive = 5;

    @Test
    @DisplayName("Вычисление стоимости стандартной посылки")
    public void calculateDeliveryCost_CalculatingCostStandardParcel_6Test(){
        //given
        ParcelData data= new ParcelData(PARCEL_NAME, PARCEL_WEIGHT, DESTINATION, SEND_DAY);
        StandardParcel standardparcel = new StandardParcel(data);
        //when
        int result =standardparcel.calculateDeliveryCost();
        //then
        Assertions.assertEquals(6,result,"Ожидается стоимость 6");
    }



    @Test
    @DisplayName("Вычисление стоимости скоропортящиеся посылки")
    public void calculateDeliveryCost_CalculatingCostPerishableParcel_9Test(){
        //given
        ParcelData data= new ParcelData(PARCEL_NAME, PARCEL_WEIGHT, DESTINATION, SEND_DAY);
        PerishableParcel perishableparcel = new PerishableParcel(data,timeToLive);
        //when
        int result=perishableparcel.calculateDeliveryCost();
        //then
        Assertions.assertEquals(9,result,"Ожидается стоимость 9");
    }


    @Test
    @DisplayName("Вычисление стоимости хрупкой посылки")
    public void calculateDeliveryCost_CalculatingCostFragileParcel_12Test(){
        //given
        ParcelData data= new ParcelData(PARCEL_NAME, PARCEL_WEIGHT, DESTINATION, SEND_DAY);
        FragileParcel fragileparcel = new FragileParcel(data);
        //when
        int result=fragileparcel.calculateDeliveryCost();
        //then
        Assertions.assertEquals(12,result,"Ожидается стоимость 12");
    }

}
