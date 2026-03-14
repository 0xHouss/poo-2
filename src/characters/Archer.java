package characters;

import java.util.Random;
import characters.Character;

public class Archer extends Character {
  private int precision, range;

  public Archer(String name) {
    super(name, 100);
  }

  @Override
  public void attackAction(Character that) {
    Random random = new Random();

    double missChance = Math.max(0.05, 0.30 - precision * 0.002);
    double critChance = 0.05 + precision * 0.003;

    double roll = random.nextDouble();

    int damage = 15; // Base damage

    if (roll < missChance) {
      damage = 0;
      System.out.println("Missed!");
    } else if (roll < missChance + critChance) {
      damage *= 2; // Critical hit doubles the damage
      System.out.println("Critical hit!");
    }

    that.takeDamage(damage);
    System.out.println("Dealt " + damage + " damage to " + that.getName());
  }
}
