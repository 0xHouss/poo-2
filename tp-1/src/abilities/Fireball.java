package abilities;

import java.util.ArrayList;
import characters.Character;

public class Fireball extends Ability {
  public Fireball() {
    super("Fireball", "Deals massive magical damage to a single target.", 30);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    if (!targets.isEmpty()) {
      Character target = targets.get(0);
      int damage = 40 + (user.getLevel() * 5);
      System.out.println(user.getName() + " launches a ball of fire at " + target.getName() + "!");
      target.takeDamage(damage);
    }
  }
}
