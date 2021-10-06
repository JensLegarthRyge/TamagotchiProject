package Tamagotchi;

import java.util.Arrays;
import java.util.Random;

public class Tamagotchi {
    String comma = ",";
    String openBracket = "\\[";
    String closeBracket = "]";
    String blank = "";

    String name;
    int healthBarIndex = 5;
    int age;
    int mood;
    int energy;
    int hunger;
    String[] healthBar;

    void walk() {
        this.energy -= 20;
        this.hunger += 30;
        this.mood += 20;
    }

    void play() {
        Random random = new Random();
        int toy = random.nextInt(3);
        if (toy == 0) {//feather
            System.out.println(this.name + " plays with a feather and it brings them great joy!");
            System.out.println("Their mood and hunger went up by 20% and their energy down by 20%");
            this.mood += 20;
            this.energy -= 20;
        } else if (toy == 1) {//plush toy
            System.out.println(this.name + " plays with a plush toy and it brings them joy!");
            System.out.println("\"Their mood and hunger went up by 10% and their energy down by 10%");
            this.mood += 10;
            this.energy -= 10;
        } else if (toy == 2) {//old shoe
            System.out.println(this.name + " plays with an old shoe and it brings them great joy!");
            System.out.println("Their mood and hunger went up by 20% and their energy down by 20%");
            this.mood += 20;
            this.energy -= 20;
        }
    }

    public Tamagotchi(String name) {
        this.name = name;
        this.age = 0;
        this.mood = 50;
        this.energy = 50;
        this.hunger=50;
        this.healthBar = new String[]{"❤️", "❤️", "❤️", "❤️", "❤️", "❤️"};
    }

    void printStats(){
        System.out.println("Here are the current stats for "+this.name+":");
        System.out.println("---------------------------------------------");
        System.out.println("Health:\t\t\t\t\t"+Arrays.toString(this.healthBar).replaceAll(comma,blank).replaceAll(openBracket,blank)
                .replaceAll(closeBracket,blank));
        System.out.println(""+this.name+" is "+this.age+" years old");
        if (this.mood > 100){
            System.out.println(this.name+"'s mod is as good as can be!");
        } else
        System.out.println("Mood is at "+this.mood+"%");
        if (this.energy > 100){
            System.out.println(this.name+" is fully energized!");
        } else
        System.out.println("Energy is at "+this.energy+"%");
        if (this.hunger<0) {
            System.out.println(this.name + " is well-fed");
        }else
        System.out.println("Hunger is at "+this.hunger+"%");
    }

    void feedPet(){
        Random random = new Random();
        int food = random.nextInt(6);
        String foodType="";
        if (food==0){ //A treat
            this.mood+=10;
            this.hunger-=5;
            foodType="a treat";
            System.out.println(this.name+" was fed "+foodType+" - Hunger decreased by 5% and mood increased by 10%");
        } else if (food>1){//Dry food
            this.hunger-=20;
            foodType="some dry food";
            System.out.println(this.name+" was fed "+foodType+" - Hunger decreased by 20%");
        } else if (food==1){ //Fish
            this.mood+=5;
            this.hunger-=10;
            foodType="a fish";
            System.out.println(this.name+" was fed "+foodType+" - Hunger decreased by 10% and mood increased by 5%");
        }
    }

    void rest(int hours){
        this.energy+=hours*10;
        if (this.energy>=100){
            System.out.println(this.name+" is fully rested!");
        } else if (this.energy<100){
            System.out.println(this.name+" is at "+this.energy+"% energy");
        }
    }

    void checkVitals() {
        if (this.mood <= 0) {
            this.healthBar[healthBarIndex] = "🖤";
            System.out.println(this.name + " suffered mental trauma and lost a healthpoint");
            System.out.println(Arrays.toString(this.healthBar).replaceAll(comma, blank).replaceAll(openBracket, blank)
                    .replaceAll(closeBracket, blank));
            healthBarIndex -= 1;
            this.mood = 0;

        }
        if (this.energy <= 0) {
            this.healthBar[healthBarIndex] = "🖤";
            System.out.println(this.name + " suffered physical exhaustion and lost a healthpoint");
            System.out.println(Arrays.toString(this.healthBar).replaceAll(comma, blank).replaceAll(openBracket, blank)
                    .replaceAll(closeBracket, blank));
            healthBarIndex -= 1;
            this.energy = 0;

        }
        if (this.hunger >= 100) {
            this.healthBar[healthBarIndex] = "🖤";
            System.out.println(this.name + "'s hunger was neglected and they lost a healthpoint");
            System.out.println(Arrays.toString(this.healthBar).replaceAll(comma, blank).replaceAll(openBracket, blank)
                    .replaceAll(closeBracket, blank));
            healthBarIndex -= 1;
            this.hunger = 0;
        }
    }

    void checkAge(int activitiesPerformed){
        if (activitiesPerformed%5==0){
            this.age+=1;
            System.out.println("\nCongratulations! - "+this.name+" just had their birthday and");

            if (this.age==1){
                System.out.println("is now 1 year old");
            } else
                System.out.println("is now "+this.age+" years old");
        }
    }
}
