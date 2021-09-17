package Main;

import java.util.Scanner;

public class Main {

    //Создание объекта класса DB_users
    private static DB_Users users = new DB_Users("Пользователи");
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        addInDB();
        try {
            signIn();
        } catch (DateBaseException e) {
            e.printStackTrace();
        }


    }

    private static void addInDB(){
        /*
        Заполнение БД девятью пользователями, где логин это - "userN" и пароль - "passwordN"
         */
        for (int i = 1; i <= 9; i++)
            users.addUser("User" + i,("password" + i).hashCode());
    }

    private static void signIn() throws DateBaseException {
        boolean flag = true;
        while (true) {
            System.out.print("Введите логин: ");
            String login = in.nextLine();
            System.out.print("Введите пароль: ");
            String password = in.nextLine();
            if (users.signUp(login,password.hashCode()) != -1) {
                System.out.print("Вы вошли в систему! Вот база данных пользователей:\n\n");
                users.print();
                flag = false;
                System.exit(0);
            }
            else System.out.println("ЛОГИН ИЛИ ПАРОЛЬ НЕ ВЕРНЫ!");

        }
    }

}