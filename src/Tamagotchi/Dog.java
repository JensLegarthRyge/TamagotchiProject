package Tamagotchi;

import java.util.Random;

public class Dog extends Tamagotchi{
    public Dog(String name) {
        super(name);
    }

    @Override
    //Play suited for dog
    void play() {
        Random random = new Random();
        int toy = random.nextInt(3);
        if (toy == 0) {//feather
            System.out.println(this.name + " plays with a feather and it's quite boring.");
            System.out.println("Their mood and hunger went up by 1% and their energy down by 30%");
            this.mood += 1;
            this.energy -= 20;
        } else if (toy == 1) {//plush toy
            System.out.println(this.name + " plays with a plush toy and it brings them joy.");
            System.out.println("Their mood and hunger went up by 10% and their energy down by 10%");
            this.mood += 10;
            this.energy -= 10;
        } else if (toy == 2) {//old shoe
            System.out.println(this.name + " plays with an old shoe and it brings them great joy!");
            System.out.println("Their mood and hunger went up by 20% and their energy down by 20%");
            this.mood += 20;
            this.energy -= 20;
        }
    }

    @Override
    void walk() {
        super.walk();
        System.out.println("You and "+this.name+" go for a walk - "+this.name+" comes back happy, hungry and exhausted");
        System.out.println(this.name+"'s hunger increased by 30%, their mood increased by 20% and their energy \n" +
                "decreased by 20%");
    }
}
