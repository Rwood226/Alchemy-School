import java.util.Scanner;
import java.util.InputMismatchException;

public class PotionApp {
    private static int totalAdded = 0;
    private static Scanner scanner = new Scanner(System.in);

    // Ingredients
    private static Ingredient bicornHorn = new Ingredient("Bicorn Horn", 5);
    private static Ingredient dragonBlood = new Ingredient("Dragon Blood", 7);
    private static Ingredient armadilloBile = new Ingredient("Armadillo Bile", 10);
    private static Ingredient wormwoodEssence = new Ingredient("Wormwood Essence", 4);
    private static Ingredient moonstone = new Ingredient("Moonstone", 3);
    private static Ingredient fries = new Ingredient("Fries", 4);

    public static void main(String[] args) {
        // 1. create objects
        // 2. call helper methods
        // 3. print final result

        Potion potion = new Potion();
        printIngredients();

        // Implement the menu loop: print the menu, read the user's choice,
        // call the matching helper method, repeat until the user quits.
        // The menu always offers all actions (no specific order required). Potion
        // enforces the phases (not PotionApp!); no brewing rules in here!
        // When evaluating: print the result AND the potion (see toString())
        System.out.println ("\n\nYou are attending Professor Rogers' Advanced Potion-Making class at Yinzer's School for Alchemy and Wizardry.");
        System.out.println ("You are currently working through Encapsulating Ingredients, a potions book by Phineas Bourne that gives instructions on how to brew hundreds of advanced potions.");
        System.out.println ("Beware: Some potions might bubble, explode, or summon a ghostly \"Yinz!\" if brewed incorrectly!\n");

        while (true) {
            printMenu();

            try {
                int act = scanner.nextInt();

                if (act == 1) {
                    selectIngredient(potion);
                }
                else if (act == 2) {
                    stirPotion(potion);
                }
                else if (act == 3) {
                    heatPotion(potion);
                }
                else if (act == 4) {
                    System.out.println (potion.evaluatePotion());
                }
                else if (act == 5) {
                    break;
                }
                else {
                    System.out.println ("\n\nInvalid number\n");
                }
            }
            catch (InputMismatchException e) {
                System.out.println ("\n\nInvalid option\n");
            }
            scanner.nextLine();
        }
        scanner.close();
    }

    // (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
    private static void printMenu() {
        System.out.println ("(1) Add an ingredient");
        System.out.println ("(2) Stir");
        System.out.println ("(3) Heat");
        System.out.println ("(4) Evaluate");
        System.out.println ("(5) Quit");
    }

    // Ask which ingredient (1-6) and add that ingredient to the potion
    static void selectIngredient(Potion potion) {

        if (totalAdded == 10) {
            System.out.println ("\n\nYou really shouldn't add more than 10 ingredients...\n");
        }

        else {
            System.out.println ("\n\nWhich ingredient would you like to add?\n");
            printIngredients();

            int ingredient = scanner.nextInt();
            totalAdded++;

            if (ingredient == 1) {
                potion.addIngredient(bicornHorn.getStrength());
                System.out.println ("\nAdded Bicorn Horn\n\n");
            }
            else if (ingredient == 2) {
                potion.addIngredient(dragonBlood.getStrength());
                System.out.println ("\nAdded Dragon Blood\n\n");
            }
            else if (ingredient == 3) {
                potion.addIngredient(armadilloBile.getStrength());
                System.out.println ("\nAdded Armadillo Bile\n\n");
            }
            else if (ingredient == 4) {
                potion.addIngredient(wormwoodEssence.getStrength());
                System.out.println ("\nAdded Wormwood Essence\n\n");
            }
            else if (ingredient == 5) {
                potion.addIngredient(moonstone.getStrength());
                System.out.println ("\nAdded Moonstone\n\n");
            }
            else if (ingredient == 6) {
                potion.addIngredient(fries.getStrength());
                System.out.println ("\nAdded Fries\n\n");
            }
            else {
                System.out.println ("\n\nInvalid ingredient\n");
            }
        }
    }

    // prompt user for stiring (1-3) and stir the potion that many times
    static void stirPotion(Potion potion) {
        System.out.println ("\n\nHow many times would you like to stir your potion? (1-3 times)\n");

        int stirVal = scanner.nextInt();
        if (stirVal >= 1 && stirVal <= 3) {
            potion.stir(stirVal);
        }
        else {
            System.out.println ("\n\nI'd recommend stirring between 1 and 3 times\n");
        }
    }

    // prompt user for a heating level (1-3) and heat the potion that many times
    static void heatPotion(Potion potion) {
        System.out.println ("\n\nHow high do you want to heat your potion? (1-3)\n");

        int heatVal = scanner.nextInt();
        if (heatVal >= 1 && heatVal <= 3) {
            potion.heat(heatVal);
        }
        else {
            System.out.println ("\n\nI'd recommend a heating level between 1 and 3\n");
        }
    }

    // Helper to print out the ingredients (uses printf pattern from L08)
    private static void printIngredients() {
        System.out.println("Encapsulating Ingredients, p. 412 - available ingredients:");
        System.out.printf("  %-4s %-18s %s%n", "No.", "Ingredient", "Strength");
        System.out.printf("  %-4d %-18s %+d%n", 1, bicornHorn.getPotionName(), bicornHorn.getStrength());
        System.out.printf("  %-4d %-18s %+d%n", 2, dragonBlood.getPotionName(), dragonBlood.getStrength());
        System.out.printf("  %-4d %-18s %+d%n", 3, armadilloBile.getPotionName(), armadilloBile.getStrength());
        System.out.printf("  %-4d %-18s %+d%n", 4, wormwoodEssence.getPotionName(), wormwoodEssence.getStrength());
        System.out.printf("  %-4d %-18s %+d%n", 5, moonstone.getPotionName(), moonstone.getStrength());
        System.out.printf("  %-4d %-18s %+d%n", 6, fries.getPotionName(), fries.getStrength());
    }
}
