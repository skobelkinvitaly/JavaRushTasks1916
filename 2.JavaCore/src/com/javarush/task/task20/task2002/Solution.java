package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Long.parseLong;
import static java.lang.Long.valueOf;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:\\test1.txt");
            InputStream inputStream = new FileInputStream("D:\\test1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            javaRush.users.add(new User());
//            javaRush.users.get(0).setFirstName("Vitaly");
//            javaRush.users.get(0).setLastName("Ivanov");
//            javaRush.users.get(0).setMale(true);
//            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
//            javaRush.users.get(0).setBirthDate(new Date());

            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            if (users.size() > 0) {
                for (User j :
                        users) {
                    pw.println(j.getFirstName());
                    pw.println(j.getLastName());
                    pw.println(j.getBirthDate().getTime());
//                    pw.println(j.getBirthDate() == null ? null: j.getBirthDate().getTime());
                    pw.println(j.isMale());
                    pw.println(j.getCountry().toString());
                }
            }
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            if (users != null){
                while (r.ready()){
                    User user = new User();
                    user.setFirstName(r.readLine());
                    user.setLastName(r.readLine());
                    user.setBirthDate(new Date(Long.parseLong(r.readLine())));
                    user.setMale(Boolean.parseBoolean(r.readLine()));
                    String str = r.readLine();
                    if (str.equals("UKRAINE")) user.setCountry(User.Country.UKRAINE);
                    if (str.equals("RUSSIA")) user.setCountry(User.Country.RUSSIA);
                    if (str.equals("OTHER")) user.setCountry(User.Country.OTHER);
                    users.add(user);
                }
            }
            r.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
