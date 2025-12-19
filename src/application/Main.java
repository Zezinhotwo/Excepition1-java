package application;

import Model.entities.Reservation;

import java.rmi.server.RemoteServer;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date: (dd/MM/yyyy): ");
        Date checkInt = sdf.parse(sc.next());
        System.out.print("Check-out date: (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkInt)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkInt, checkOut);
            System.out.println("Rerservation: " + reservation);
            System.out.println();
            System.out.println("Enter data  to update the reservation:");
            System.out.print("Check-in date: (dd/MM/yyyy): ");
            checkInt = sdf.parse(sc.next());
            System.out.print("Check-out date: (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkInt.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Check-out date for update must be after check-in date");
            } else if (!checkOut.after(checkInt)) {
                System.out.println("Error in reservation: Check-out date must be future check-in date");
            } else {
                reservation.updateDates(checkInt, checkInt);
                System.out.println("Rerservation: " + reservation);
            }


        }

        sc.close();

    }
}

