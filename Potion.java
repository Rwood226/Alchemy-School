import java.util.Random;

public class Potion {
    private int totalAdd = 0;
    private int totalStrength = 0;
    private int quality = 0;
    private int potionScore = 0;
    private boolean ruined = false;
    private boolean stirred = false;
    private boolean heated = false; 
    private boolean evaluated = false;

    Random random = new Random();

    // adds ingredients
    // a fourth ingredient ruins the potion
    public void addIngredient(int strength) {
        if (totalAdd >= 4) {
            ruined = true;
        }

        totalStrength += strength;
        totalAdd++;
    }

    // adds random [1..5] to strength each call
    public void stir(int stirVal) {
        if (totalAdd >= 3 && stirred == false) {
            stirVal *= random.nextInt(1, 5);
            totalStrength += stirVal;
            
            System.out.println ("\n\nPotion stirred\n");
            stirred = true;
        }
        else if (stirred == true) {
            System.out.println ("\n\nYou shouldn't stir the potion too much\n");
        }
        else {
            System.out.println ("\n\nYou must add at least 3 ingredients before stirring\n");
        }
    }

    // adds random [0..7] to quality each call
    public void heat(int heat) {
        if (stirred == true && heated == false) {
            heat *= random.nextInt(0, 7);
            quality += heat;

            System.out.println ("\n\nPotion heated\n");
            heated = true;
        }
        else if (stirred == false) {
            System.out.println ("\n\nYou must stir the potion before heating it\n");
        }
        else {
            System.out.println ("\n\nHeating the potion too much will lead to disaster\n");
        }
    }

    // returns the result as a String
    // (success / partial success / failure) and triggers the CauldronEvent once.
    public String evaluatePotion() {
        if (heated == false) {
            return "\n\nYou must heat the potion before it is done\n";
        }
        else if (evaluated == true) {
            return "\n\nThe potion has already been created";
        }

        evaluated = true;
        if (CauldronEvent.triggerEvent() == true) {
            return toString();
        }

        // set parameters for evaluation based on strength and quality
        if (totalStrength > 22 && totalStrength < 35) {
            potionScore = 10;
        }
        else if (totalStrength < 40) {
            potionScore = 7;
        }
        else {
            potionScore = 1;
        }
        potionScore *= quality;

        // returns strings based on score
        if (ruined == true) {
            return "\n\nThe potion is ruined, try fewer ingredients next time\n" + toString();
        }
        else if (potionScore == 210) {
            return "\n\nAmazing! A perfect potion!\n" + toString();
        }
        else if (potionScore >= 91) {
            return "\n\nSuccess! A good potion\n" + toString();
        }
        else if (potionScore >= 21) {
            return "\n\nA partial success, good try\n" + toString();
        }
        else {
            return "\n\nThe potion failed, better luck next time\n" + toString();
        }
    }

    // Override toString() so that printing a Potion shows its strength, its
    // quality and how many ingredients are in it
    @Override
    public String toString() {
        return "[Ingredients: " + totalAdd + ", Strength: " + totalStrength + ", Quality: " + quality + ", Potion Grade: " + potionScore + "]\n";
    }
}
