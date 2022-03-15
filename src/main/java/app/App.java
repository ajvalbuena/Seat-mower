package app;

import app.application.TerrainInspection;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] input = new String[5];

        System.out.println("Please, enter the upper limits of your plateau, and your mowers (with the initial position and their " +
                "instructions):");
        for (int i = 0; i < input.length; i++) {
            input[i] = in.nextLine();
        }

        System.out.println(TerrainInspection.inspectWithMower(input[0], input[1], input[2]));
        System.out.println(TerrainInspection.inspectWithMower(input[0], input[3], input[4]));
    }


}
