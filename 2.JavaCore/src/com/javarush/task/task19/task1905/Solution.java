package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
Solution solution = new Solution();

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;


        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> item : countries.entrySet()){
                if (item.getValue().equals(customer.getCountryName())) return item.getKey();
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name = contact.getName().split(", ");
            return name[1];
        }

        @Override
        public String getContactLastName() {
            String[] surname = contact.getName().split(", ");
            return surname[0];
        }

        @Override
        public String getDialString() {
            String number = contact.getPhoneNumber();
            String[] arr2 = number.split("\\(");
            String number2 = "";
            for (int i = 0; i < arr2.length; i++) {
                number2 = number2 + arr2[i];
            }
            String[] arr3 = number2.split("\\)");
            String number3 = "";
            for (int i = 0; i < arr3.length; i++) {
                number3 = number3 + arr3[i];
            }
            String[] arr4 = number3.split("\\-");
            String number4 = "";
            for (int i = 0; i < arr4.length; i++) {
                number4 = number4 + arr4[i];
            }
            return "callto://"+number4;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}