package demo;

import java.util.ArrayList;
import java.util.Collections;
import characters.*;
import abilities.*;

public class DemoRPG {

  public static void main(String[] args) {
    System.out.println("--- RPG SYSTEM DEMO ---\n");

    // GAME 1: Warrior vs Mage
    runBattle(new Warrior("Thorin"), new Mage("Gandalf"));

    // GAME 2: Warrior vs Archer
    runBattle(new Warrior("Thorin"), new Archer("Legolas"));

    // GAME 3: Archer vs Mage
    runBattle(new Archer("Legolas"), new Mage("Gandalf"));
  }

  /**
   * STATIC GAME LOGIC
   * Handles the loop and end-game condition.
   */
  public static void runBattle(characters.Character p1, characters.Character p2) {
    // Assigning abilities immediately after creation
    assignSkills(p1);
    assignSkills(p2);

    System.out.println(">>> MATCH START: " + p1.getName() + " vs " + p2.getName());

    int round = 1;
    while (p1.isAlive() && p2.isAlive()) {
      System.out.println("\n[ROUND " + round + "]");

      // Player 1 Turn
      performTurn(p1, p2, round);
      if (!p2.isAlive())
        break;

      // Player 2 Turn
      performTurn(p2, p1, round);

      round++;
      if (round > 20)
        break; // Safety
    }

    System.out.println("\n--- FINAL RESULT ---");
    System.out.println("Winner: " + (p1.isAlive() ? p1.getName() : p2.getName()));
    System.out.println("====================================\n");
  }

  private static void performTurn(characters.Character attacker, characters.Character target, int round) {
    ArrayList<characters.Character> targets = new ArrayList<>(Collections.singletonList(target));

    System.out.print(attacker.getName() + " is acting... ");

    // LOGIC: Use Special if Round > 1, but check Mana first
    boolean usedSpecial = false;

    if (round > 1) {
      // MANA CHECK: If it's a Mage, we check mana before allowing the ability
      if (attacker instanceof Mage) {
        Mage mage = (Mage) attacker;
        // Assuming Fireball/CelestialFlare cost at least 15-20 Mana
        if (mage.getMana() < 15) {
          System.out.print("OUT OF MANA! ");
        } else {
          attacker.useAbility(round % 2, targets); // Alternates between skill 0 and 1
          usedSpecial = true;
        }
      } else {
        // Warriors/Archers use special moves (assuming they use stamina or are free)
        attacker.useAbility(0, targets);
        usedSpecial = true;
      }
    }

    // FALLBACK: Normal Attack if round 1 OR if out of mana
    if (!usedSpecial) {
      System.out.print("Executes a Normal Attack. ");
      attacker.attack(target);
    }

    // REQUIRED DISPLAY
    System.out.println("\n>> Target: " + target.getName() + " | Result: " + target.getHealth() + " HP remaining.");
  }

  private static void assignSkills(characters.Character c) {
    if (c instanceof Warrior) {
      c.learn(new ShieldSlam());
      c.learn(new SecondWind());
    } else if (c instanceof Mage) {
      c.learn(new Fireball());
      c.learn(new CelestialFlare());
    } else if (c instanceof Archer) {
      c.learn(new DoubleShot());
      c.learn(new ArrowRain());
    }
  }
}
