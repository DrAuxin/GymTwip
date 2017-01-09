package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Customer list[] = new Customer[100];
        int id;
        int count = 0;
        while (true)
        {
            double tab = 0;
            double num;
            int type = 0;
            double discount = 1;
            double prices[][] = {{65, 0, 1,}, {10, 8, 3}, {0, 10, 7}, {25, 20, 15}};
            Scanner user = new Scanner(System.in);
            System.out.println("Are you an employee?");
            String response = user.next();
            if (response.equalsIgnoreCase("yes")) {
                type = 2;
                discount = 0.9;
            }
            System.out.println("Do you have a membership?");
            response = user.next();
            if (response.equalsIgnoreCase("yes")) {
                discount = 0.8;
                if (type != 2)
                    type = 1;
            }
            if (response.equalsIgnoreCase("no"))
            {
                System.out.println("Would you like to purchase a membership?");
                response = user.next();
                if (response.equalsIgnoreCase("yes"))
                {
                    tab = tab + prices[0][type];
                    if (type != 2)
                        type = 1;
                    discount = 0.8;
                }
            }
            while (true) {
                System.out.println("What would you like to purchase (class, retail, aquatics, trainer)?");
                response = user.next();
                if (response.equalsIgnoreCase("class")) {
                    System.out.println("How many classes?");
                    num = user.nextInt();
                    tab = tab + num * prices[1][type];
                } else if (response.equalsIgnoreCase("retail")) {
                    System.out.println("How much would you like to spend on retail?");
                    num = user.nextDouble();
                    tab = tab + num * discount;
                } else if (response.equalsIgnoreCase("aquatics") && type != 0) {
                    tab = tab + prices[2][type];
                } else if (response.equalsIgnoreCase("trainer")) {
                    System.out.println("How many hours do you want the trainer?");
                    num = user.nextDouble();
                    tab = tab + num * prices[3][type];
                } else
                    System.out.println("That is not available.");
                System.out.println("Do you want anything else?");
                response = user.next();
                if (response.equalsIgnoreCase("no"))
                    break;
            }
            System.out.println("Your total is " + tab);
            System.out.println("Would you like to give us some information about your self?");
            response = user.next();
            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Have you given us information before?");
                response = user.next();
                if (response.equalsIgnoreCase("no")) {
                    System.out.println("You will be customer " + count);
                    id = count;

                } else {
                    System.out.println("What is your customer number?");
                    id = user.nextInt();
                }
                System.out.println("What is your weight?");
                list[id].weight = user.nextDouble();
                System.out.println("What is your SSN?");
                list[id].SSN = user.nextLong();
                System.out.println("How many hours have you spent here today?");
                list[id].hours = user.nextDouble() + list[id].hours;
                list[id].visits += 1;
            }
        }
    }
}

/**
 * Created by Paul on 1/7/2017.


