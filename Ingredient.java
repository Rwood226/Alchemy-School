public class Ingredient {
    private String potionName;
    private int strength;

    // create a potion with a name and a strength value between 1 and 10
    public Ingredient(String name, int strength) {
        if (0 <= strength && strength <= 10) {
            this.potionName = name;
            this.strength = strength;
        }
        else {
            // handle exception with defaults
            this.potionName = "N/A";
            this.strength = 11;
        }
    }

    // setters for name and strength if using default values
    public void setPotionName(String name) {
        if (this.potionName == "N/A") {
            this.potionName = name;
        }
    }
    public void setStrength(int strength) {
        if (this.strength == 11) {
            this.strength = strength;
        }
    }

    // getters
    public String getPotionName() {
        return this.potionName;
    }
    public int getStrength() {
        return this.strength;
    }
}
