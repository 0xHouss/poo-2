package abilities;

import java.util.ArrayList;
import characters.Character;

public class Execute extends Ability {
  public Execute() {
    super("Execute", "Deals double damage if target is below 30% HP.", 0);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    if (!targets.isEmpty()) {
      Character target = targets.get(0);
      int damage = 20;

      System.out.println(user.getName() + " attempts to execute " + target.getName() + "!");
      if (target.getHealth() < (target.getMaxHealth() * 0.3)) {
        damage *= 2;
        System.out.println("A lethal strike!");
      }

      target.takeDamage(damage);
    }
  }
}
