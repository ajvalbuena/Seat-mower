package app;

import app.application.TerrainInspection;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the initial mower: ");
        String mover = in.nextLine();

        System.out.println("Enter the instructions: ");
        String instructions = in.nextLine();

        System.out.println(TerrainInspection.inspectWithMower(mover,instructions));
    }


}
