package abilities;

import java.util.ArrayList;
import characters.Character;

public class CelestialFlare extends Ability {
  public CelestialFlare() {
    super("Celestial Flare", "A burst of cosmic energy hitting all enemies.", 40);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    System.out.println(user.getName() + " summons a Celestial Flare!");
    for (Character target : targets) {
      if (target.isAlive()) {
        target.takeDamage(25);
      }
    }
  }
}
