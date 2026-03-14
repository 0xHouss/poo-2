package abilities;

import java.util.ArrayList;
import characters.Character;

public class DoubleShot extends Ability {
  public DoubleShot() {
    super("Double Shot", "Fires two arrows at a single target.", 0);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    if (!targets.isEmpty()) {
      Character target = targets.get(0);
      System.out.println(user.getName() + " fires two arrows in rapid succession!");
      target.takeDamage(15);
      if (target.isAlive())
        target.takeDamage(15);
    }
  }
}
