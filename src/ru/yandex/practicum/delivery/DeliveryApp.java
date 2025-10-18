package ru.yandex.practicum.delivery;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> allTracks = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox= new ParcelBox<>(25);
    private static ParcelBox<FragileParcel> fragileBox= new ParcelBox<>(25);
    private static ParcelBox<PerishableParcel> perishableBox= new ParcelBox<>(15);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4: {
                    System.out.println("Введите новое местоположение посылок");
                    String newLocation = scanner.nextLine();
                    showTracks(newLocation);
                    break;
                }
                case 5: {
                    showTypeParcel();
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1: {
                            standardBox.getAllParcels();
                            break;
                        }
                        case 2: {
                            fragileBox.getAllParcels();
                            break;
                        }
                        case 3: {
                            perishableBox.getAllParcels();
                            break;
                        }
                        default:
                            System.out.println("Такого типа посылки не существует");
                    }
                    break;
                }
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Изменить местоположение посылки");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Какой тип посылки хотите отправить?");
        showTypeParcel();
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: {
                ParcelData data = showRequiredField();
                StandardParcel parcel = new StandardParcel(data);
                allParcels.add(parcel);
                standardBox.addParcel(parcel);
                break;
            }
            case 2: {
                ParcelData data = showRequiredField();
                FragileParcel parcel = new FragileParcel(data);
                allParcels.add(parcel);
                allTracks.add(parcel);
                fragileBox.addParcel(parcel);
                break;
            }
            case 3:
                ParcelData data = showRequiredField();
                System.out.println("Введите срок годности (кол-во дней):");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel parcel = new PerishableParcel(data,timeToLive);
                allParcels.add(parcel);
                perishableBox.addParcel(parcel);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for(Parcel parcel: allParcels){
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sum=0;
        for(Parcel parcel: allParcels){
            sum+= parcel.calculateDeliveryCost();
        }
        System.out.println("Общая сумма доставки "+sum);
    }

    private static void showTypeParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
    }

    private static void showTracks(String newLocation) {
        for(Trackable track: allTracks){
            track.reportStatus(newLocation);
        }
    }

    private static ParcelData showRequiredField() {
        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес места назначения посылки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправки посылки:");
        int sendDay = Integer.parseInt(scanner.nextLine());
        return new ParcelData(description, weight, deliveryAddress, sendDay);
    }

}