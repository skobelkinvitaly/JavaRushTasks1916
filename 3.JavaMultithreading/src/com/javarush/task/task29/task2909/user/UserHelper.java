package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

//    private boolean isManAnya = false;
//    private boolean isManRoma = true;

    public void printUsers() {
//        System.out.println("Имя: " + userAnya.getName());
//        System.out.println("Фамилия: " + userAnya.getSurname());
        userAnya.printInfo();
        userAnya.printAdditionalInfo();
//        printAdditionalInfo(userAnya);


//        System.out.println("Имя: " + userRoma.getName());
//        System.out.println("Фамилия: " + userRoma.getSurname());
        userRoma.printInfo();
        userRoma.printAdditionalInfo();
//        printAdditionalInfo(userRoma);
    }

//    public void printAdditionalInfo(User user) {
//        if (user.getAge() < 16)
//            System.out.println("Пользователь моложе 16 лет");
//        else
//            System.out.println("Пользователь старше 16 лет");
//    }
//
//    private boolean ageLessThan16(User user) {
//        if (user.getAge() < 16) {
//            return true;
//        }
//        return false;
//    }

    public int calculateAverageAge() {
//        int age = 28;
        User userUra = new User("Юра", "Карп", 28);

//        age = (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;

        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int  calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
//        base.set(base.get() + age / 100);
//        base.set((int) (base.get() * (hasWork ? 1.1 : 0.9)));
//        base.set((int) (base.get() * (hasHouse ? 1.1 : 0.9)));
        int n1 = base.get() + age / 100;
        int n2 = (int) (n1 * (hasWork ? 1.1 : 0.9));
        int n3 = (int) (n2 * (hasHouse ? 1.1 : 0.9));
        return  n3;
    }

    public String getBossName(User user) {
        Work work = user.getWork();
//        return work.getBoss();
        return user.getBoss();
    }
}