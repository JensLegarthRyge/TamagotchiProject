package Tamagotchi;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int activitiesPerformed=0;
        printGameTitle();
        System.out.println("\t\t\tWelcome to the Tamagotchi game\n" +
                "Press 1 to create a new Dog \t Press 2 to create a new Cat");

        int userChoicePetType = getNextInt();
        //If user picks dog
        if (userChoicePetType==1){
            System.out.println("\nA dog - great choice!\n" +
                    "Please write the name you wish for your dog below:");
            Dog userChosenPet = new Dog(getNextLine());
            System.out.println("\nWhat a lovely name for your new pet!\n");
            userChosenPet.printStats();
            System.out.println("\nPress 'Enter(⌅/↵)' to continue");
            getNextLine();

            while (userChosenPet.healthBar[0].equals("❤️")){
                printOptionsForNextActivity();
                int userChoiceNextActivity = getNextInt();
                if (userChoiceNextActivity==1){
                    userChosenPet.walk();
                    userChosenPet.checkVitals();
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                } else if (userChoiceNextActivity==2){
                    userChosenPet.feedPet();
                    userChosenPet.checkVitals();
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                } else if (userChoiceNextActivity==3){
                    userChosenPet.play();
                    userChosenPet.checkVitals();
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                } else if (userChoiceNextActivity==4){
                    System.out.println("How many hours should "+userChosenPet.name+" rest for?");
                    userChosenPet.rest(getNextInt());
                    userChosenPet.checkVitals();
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                } else if (userChoiceNextActivity==5){
                    userChosenPet.printStats();
                }

            }
            System.out.println("\nUnfortunately, you've failed to properly take care of "+userChosenPet.name+", which is why they can no longer be with us.\n" +
                    userChosenPet.name+" has passed on to a better place, where their life fortunately is no longer in your hands.\n" +
                    "I truly, and with a heavy heart, am disappointed in you.\n" +
                    "May "+userChosenPet.name+" forever rest in peace.✞");

        //If user picks cat
        } else if (userChoicePetType==2){
            System.out.println("\nA cat - great choice!\n" +
                    "Please write the name you wish for your cat below:");
            Cat userChosenPet = new Cat(getNextLine());
            System.out.println("\nWhat a lovely name for your new pet!\n");
            userChosenPet.printStats();
            System.out.println("\nPress 'Enter(⌅/↵)' to continue");
            getNextLine();

            while (userChosenPet.healthBar[0].equals("❤️")){
                printOptionsForNextActivity();
                int userChoiceNextActivity = getNextInt();
                if (userChoiceNextActivity==1){
                    userChosenPet.walk();
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                    userChosenPet.checkVitals();
                } else if (userChoiceNextActivity==2){
                    userChosenPet.feedPet();
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                    userChosenPet.checkVitals();
                } else if (userChoiceNextActivity==3){
                    userChosenPet.play();
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                    userChosenPet.checkVitals();
                } else if (userChoiceNextActivity==4){
                    System.out.println("How many hours should "+userChosenPet.name+" rest for?");
                    userChosenPet.rest(getNextInt());
                    activitiesPerformed+=1;
                    userChosenPet.checkAge(activitiesPerformed);
                    userChosenPet.checkVitals();
                } else if (userChoiceNextActivity==5){
                    userChosenPet.printStats();
                }

            }
            System.out.println("\nUnfortunately, you've failed to properly take care of "+userChosenPet.name+", which is why they can no longer be with us.\n" +
                    userChosenPet.name+" has passed on to a better place, where their life fortunately is no longer in your hands.\n" +
                    "I truly, and with a heavy heart, am disappointed in you.\n" +
                    "May "+userChosenPet.name+" forever rest in peace.✞");
        }













    }
    static void printGameTitle(){
        System.out.println("########################################");
        System.out.println("##############🐕TAMAGOTCHI🐈############");
        System.out.println("########################################");
    }

    public static void printOptionsForNextActivity(){
        System.out.println("\nWhat do you wanna do?\n");
        System.out.println("Press 1 to let your pet go for a walk🌳\t\tPress 2 to let your pet eat🍽");
        System.out.println("Press 3 to let your pet play🃏\t\t\t\tPress 4 to let your pet rest💤");
        System.out.println("Press 5 to view the current stats for your pet📊");
    }

    static int getNextInt(){
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        return nextInt;
    }
    static String getNextLine(){
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        return nextLine;
    }
}
