package abilities;

import java.util.ArrayList;
import characters.Character;

public class SecondWind extends Ability {
  public SecondWind() {
    super("Second Wind", "A quick recovery restoring 25% HP.", 0);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    int healAmount = user.getMaxHealth() / 4;
    user.heal(healAmount);
    System.out.println(user.getName() + " catches their breath and heals for " + healAmount + " HP.");
  }
}
