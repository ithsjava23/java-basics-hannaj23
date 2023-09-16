package org.example;

import java.util.*;
import java.util.Arrays;
public class App {

    public static void main(String[] args) {
        Locale swedishLocale = new Locale("sv", "SE");
        Locale.setDefault(swedishLocale);
            Scanner scInput = new Scanner(System.in);


            int[] elPriserInput = new int[24];
            String[] tidsintervall = {"00-01", "01-02", "02-03", "03-04", "04-05", "05-06", "06-07", "07-08", "08-09", "09-10", "10-11", "11-12",
                                  "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"};

            String choice;
            do {
                PrintMenu();
                choice = scInput.nextLine();

                switch (choice) {
                    case "1" -> MenyVal1(elPriserInput, tidsintervall, scInput);
                    case "2" -> MenyVal2(elPriserInput, tidsintervall);
                    case "3" -> MenyVal3(elPriserInput, tidsintervall);
                    case "4" -> MenyVal4(elPriserInput);
                    default -> {
                    }
                }
            } while (!choice.equalsIgnoreCase("e"));
    }

        public static void PrintMenu() {
            System.out.print("""

                    Elpriser
                    ========
                    1. Inmatning
                    2. Min, Max och Medel
                    3. Sortera
                    4. Bästa Laddningstid (4h)
                    e. Avsluta
                    """);

        }
        public static void MenyVal1(int[] elPriserInput, String[] tidsintervall, Scanner scInput){

            System.out.print("Inmatning av priset\n");
            for (int i = 0; i < elPriserInput.length; i++) {
                System.out.print(tidsintervall[i] + ": ");
                elPriserInput[i] = Integer.parseInt(scInput.nextLine());
            }
        }

        public static void MenyVal2(int[] elPriserInput, String[] tidsintervall) {

            int minPrice = elPriserInput[0];
            int indexLowPrice = 0;
            int bigPrice = elPriserInput[0];
            int indexBigPrice = 0;
            int sumPrices = 0;
            float averagePrice;
            for (int i = 0; i < elPriserInput.length; i++) {
                if (minPrice > elPriserInput[i]) {
                    minPrice = elPriserInput[i];
                    indexLowPrice = i;
                }
                if (bigPrice < elPriserInput[i]) {
                    bigPrice = elPriserInput[i];
                    indexBigPrice = i;
                }
                sumPrices += elPriserInput[i];
            }
            averagePrice = sumPrices / 24.0f;

            System.out.print("Lägsta pris: " + tidsintervall[indexLowPrice] + ", " + minPrice + " öre/kWh\n");
            System.out.print("Högsta pris: " + tidsintervall[indexBigPrice] + ", " + bigPrice + " öre/kWh\n");
            System.out.printf("Medelpris: %.2f öre/kWh\n", averagePrice);

        }

        public static void MenyVal3(int[] prices, String[] tidsintervall){

            Integer[] index = new Integer[prices.length];
            for (int i = 0; i < prices.length; i++) {
                index[i] = i;
            }
            Arrays.sort(index, Comparator.comparingInt(i -> -prices[i]));

            for (int i = 0; i < prices.length; i++) {
                System.out.print(tidsintervall[index[i]] + " " + prices[index[i]] + " öre\n");
            }
        }


        public static void MenyVal4(int[] prices) {
            //System.out.print("Val 4\n");

            int lowest4hPrice = 0;
            for (int i = 0; i < 4; i++) {
                lowest4hPrice += prices[i];
            }
            int index = 0;
            for (int i = 4; i < prices.length-4; i++) {
                if (lowest4hPrice > (prices[i] + prices[i+1] + prices[i+2] + prices[i+3])) {
                    lowest4hPrice = (prices[i] + prices[i+1] + prices[i+2] + prices[i+3]);
                    index = i;
                }
            }
            float averagePrice4h = lowest4hPrice/4f;

            System.out.printf("Påbörja laddning klockan " + String.format("%02d", index) + "\n"
                            + "Medelpris 4h: %.1f öre/kWh\n", averagePrice4h);
        }
}