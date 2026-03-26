package abilities;

import java.util.ArrayList;
import characters.Character;

public class ShieldSlam extends Ability {
  public ShieldSlam() {
    super("Shield Slam", "Hits the enemy with a shield based on Defense.", 0);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    if (!targets.isEmpty()) {
      Character target = targets.get(0);
      // Logic: Damage scales with user defense if you added that attribute
      target.takeDamage(15);
      System.out.println(user.getName() + " bashes " + target.getName() + " with their shield!");
    }
  }
}
