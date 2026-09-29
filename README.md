**PLEASE MAKE SURE TO READ ALL INSTRUCTIONS AND ALL HINTS / COMMENTS IN THE CODE TEMPLATE!**

Fall 2026 - CMPINF 0401 - Assignment 1
# Problem Statement: PotionApp
## Learning Goals
In this assignment, you will practice creating and accessing objects, as well as writing methods.

## Background 
*You are attending Professor Rogers' Advanced Potion-Making class at Yinzer's School for Alchemy and Wizardry.
You are currently working through *Encapsulating Ingredients*, a potions book by Phineas Bourne that gives instructions on how to brew hundreds of advanced potions.
Beware: Some potions might bubble, explode, or summon a ghostly "Yinz!" if brewed incorrectly!*

Implement a program that simulates potion brewing.
Each potion-making attempt involves:
1. **Choosing Ingredients (-> Strength)**: Ingredients have effects on the potion's strength; choosing the correct combination is crucial.
2. **Stirring (-> Strength)**: The potion must be stirred a certain amount of times, which influences the strength of the potion
3. **Heating (-> Quality)**: The potion must be heated to a certain level, which influences the quality of the potion
4. **Potion Evaluation**: Your potion’s final result depends on its strength (from ingredients and stirring) and quality (from heating). If both are high enough, you will brew a perfect potion; otherwise, you may end up with a weaker effect, a failed brew, or even an explosive mishap!

----

## Code Template
You are provided with a code template: https://github.com/pitt-0401/PotionApp-template

- Implement the necessary classes (i.e., **Ingredient**, **Potion**, **PotionApp**), and define appropriate attributes, constructors, getters, setters (if needed!), and methods. Make sure to define appropriate visibilities (access modifiers).
- **`PotionApp`** is menu-driven: the user picks what to do next (add an ingredient, stir, heat, evaluate, quit) and can pick in any order. A finished potion consists of three ingredients, 1 to 3 stirs, and 1 to 3 heating levels. 
- After stirring and heating, the potion needs some time to take effect. To reflect the real world's unpredictability, use a random variable that determines the effect on the potion, which should be generated each time either method is invoked, e.g., add a random number between 1 and 5 (stirring) or 0 - 7 (heating).

### Logic
Please make sure to follow the logical rules below:

1. **Potion Progress**: A potion progresses through the following phases: ADD → STIR → HEAT → EVALUATE
  The user picks actions in any order, so **`Potion`** enforces the phases (not `PotionApp`!):
   - `stir()` prints an error message until exactly 3 ingredients have been added.
   - `heat()` prints an error message until the potion has been stirred.
   - `evaluatePotion()` returns an error string (instead of a result) if the potion has not been heated yet or was already evaluated; in those cases the `CauldronEvent` is not triggered, so it fires only once.
   - If the potion is ruined/exploded/evaluated, `stir()`/`heat()` print an error message and `evaluatePotion()` returns an error string; the potion stays unchanged.
2. **Ingredients**: Each potion requires exactly **three ingredients**. The student can choose from a list of **six possible ingredients**, each with a different effect. Adding more than three ingredients causes the potion to be ruined.
3. **Stirring and Heating**: After adding all ingredients, the student must first **stir** the potion and then adjust the **heat effect**. After each action, the potion's strength or quality is modified by a **randomized amount**: Stirring (→ `strength`) / heating (→ `quality`) is increased by a random effect (see template). 
4. **Potion Evaluation**: The outcome of the potion is determined by the combination of ingredients (strength), stirring (strength), and heating effect (quality). 
In addition, while the potion is being evaluated, there is a 25% chance that it explodes (**`CauldronEvent`**, *already implemented*), which should be triggered once during the evaluation process.
The potion can result in one of several outcomes:
   - **Success**: The potion is perfectly brewed.
   - **Partial Success**: The potion works but is less effective.
   - **Failure**: The potion fails.

   You decide the strength/quality thresholds for each outcome.

### Hints
- Each ingredient has a unique effect on the potion’s outcome (e.g., increasing or decreasing its strength).
- Stirring and heating should be represented as methods that take random values as inputs to determine how they affect the potion's strength or quality. Heating level N means call heat() N times.
- Override `toString()` in **Ingredient** and **Potion** (see L08).
- Remember to compile often and to test your program!

### Where to Start
First, have a look at the code template. There are some TODOs that should help you understand what to do.
The following is a suggestion to help you get started:
1. Comment out any code that prevents the program from compiling. Build it up step-by-step. 
2. Begin by implementing the **Ingredient** class. Ingredients have a name and affect the potion's strength.
3. Next, implement the **Potion** class. Ingredients can be added and potions can be stirred and heated. You should track the strength (impacted by ingredients and stirring the potion) of the potion and its quality (impacted by heating the potion). Potion should track its phase/state and print an error message for actions that are not its turn yet. *Ingredients do not have to be stored in the Potion class, only the added effect and phase!* 
4. Implement the logic for **PotionApp** (see TODOs in the code).
5. Test your error messages: try to stir before adding ingredients, heat before stirring, evaluate before heating, and add a fourth ingredient. Each one should print a message and leave the potion unchanged.
6. Test the brewing process by simulating different ingredient combinations, stirring, and heating to see how the potion outcome changes.

### Random number

Also see `CauldronEvent.java` for an example:
```
import java.util.Random;
public class Main {

  public static void main (String[] args) {
    Random rand = new Random();
    int min = 50, max = 100;
    System.out.println("Generated numbers are within "+ min +" to "+ max);
    System.out.println(rand.nextInt(max - min + 1) + min);
  }
}
```
---

### Sample Output
The following is an **example output** to help you understand the idea of the program. 
I strongly encourage you to make up your own prompts! 
As long as the described functionality exists, you may also be creative and add additional functionality/effects.

```
Encapsulating Ingredients, p. 412 - available ingredients:
  No.  Ingredient         Strength
  1    Bicorn Horn        +5
  2    Dragon Blood       +7
  3    Armadillo Bile     +10
  4    Wormwood Essence   +4
  5    Moonstone          +3
  6    Fries              +4

What would you like to do?
  (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
Your choice: 2
How many times would you like to stir (1-3)? 1
You need 3 ingredients before you can stir (0/3).

What would you like to do?
  (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
Your choice: 1
Which ingredient (1-6)? Phoenix tears
Invalid input. Please enter a number.
Which ingredient (1-6)? 4
Added Wormwood Essence (1/3). Strength is now: 4

What would you like to do?
  (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
Your choice: 3
Heating level (1-3)? Be careful, it may explode! 1
Stir the potion before you heat it.

[... ingredients 2 and 3 added ...]

What would you like to do?
  (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
Your choice: 2
How many times would you like to stir (1-3)? 3
Potion stirred. Strength is now: 26
Potion stirred. Strength is now: 27
Potion stirred. Strength is now: 29

What would you like to do?
  (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
Your choice: 3
Heating level (1-3)? Be careful, it may explode! 2
Potion heated. Quality is now: 5
Potion heated. Quality is now: 6

What would you like to do?
  (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
Your choice: 4

Potion Result: Success! The potion is perfectly brewed.
Potion [ingredients: 3/3, strength: 29, quality: 6, ruined: false]

What would you like to do?
  (1) Add an ingredient  (2) Stir  (3) Heat  (4) Evaluate  (5) Quit
Your choice: 5
Fire’s aht. See yinz next class!
```
