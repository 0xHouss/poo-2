package abilities;

import java.util.ArrayList;
import characters.Character;

public class ArrowRain extends Ability {
  public ArrowRain() {
    super("Arrow Rain", "Covers the battlefield in arrows.", 0);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    System.out.println("Arrows fall from the sky!");

    for (Character target : targets)
      if (target.isAlive())
        target.takeDamage(10);
  }
}
