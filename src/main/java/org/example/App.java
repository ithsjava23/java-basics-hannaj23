package org.example;

import java.util.Locale;
import java.util.Scanner;
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
                    case "1":
                        MenyVal1(elPriserInput, tidsintervall, scInput);
                        break;
                    case "2":
                        MenyVal2(elPriserInput, tidsintervall);
                        break;
                    case "3":
                        MenyVal3(elPriserInput);
                        break;
                    case "4":
                        MenyVal4(elPriserInput);
                        break;
                    case "e","E":
                        break;
                    default:

                }
            } while (!choice.equalsIgnoreCase("e"));

           // System.exit(0);
    }

        public static void PrintMenu() {
            System.out.print("\nElpriser\n"
                    +"========\n"
                    +"1. Inmatning\n"
                    +"2. Min, Max och Medel\n"
                    +"3. Sortera\n"
                    +"4. Bästa Laddningstid (4h)\n"
                    +"e. Avsluta\n");

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
            for (int i = 0; i < elPriserInput.length; i++) {
                if (minPrice > elPriserInput[i]) {
                    minPrice = elPriserInput[i];
                    indexLowPrice = i;
                }
            }
            System.out.print("Lägsta pris: " + tidsintervall[indexLowPrice] + ", " + minPrice + " öre/kWh\n");


            int bigPrice = elPriserInput[0];
            int indexBigPrice = 0;
            for (int i = 0; i < elPriserInput.length; i++) {
                if (bigPrice < elPriserInput[i]) {
                    bigPrice = elPriserInput[i];
                    indexBigPrice = i;
                }
            }
            System.out.print("Högsta pris: " + tidsintervall[indexBigPrice] + ", " + bigPrice + " öre/kWh\n");



            int sumPrices = 0;
            float averagePrice;
            for (int i = 0; i < elPriserInput.length; i++) {
                sumPrices += elPriserInput[i];
            }
            averagePrice = sumPrices / 24.0f;
            System.out.printf("Medelpris: %.2f öre/kWh\n", averagePrice);



            }




        public static void MenyVal3(int[] prices){
            //System.out.print("Val 3\n");
        }
        public static void MenyVal4(int[] prices){
            //System.out.print("Val 4\n");
        }

    }

    class TimePrice{
    String time;
    int price;

        public TimePrice (String time, int price) {
            this.time = time;
            this.price = price;
        }




    }


//Här kan jag göra en ny klass, ej använda public när den är i samma här