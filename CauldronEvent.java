import java.util.Random;

/* ** NO NEED TO CHANGE/SUBMIT THIS FILE ** */
// Optional but not necessary.
public class CauldronEvent {
    public static boolean triggerEvent() {
        Random random = new Random();
        int event = random.nextInt(4);

        if (event == 1) {
            System.out.println("\n\nThe potion exploded! You have to be careful with these things");
            return true;
        }

        return false;
    }
}
