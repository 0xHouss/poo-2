package abilities;

import java.util.ArrayList;
import characters.Character;

public class Meditate extends Ability {
  public Meditate() {
    super("Meditate", "Restores 15 mana points to the user.", 0);
  }

  @Override
  protected void useAction(Character user, ArrayList<Character> targets) {
    // In your logic, a Mage subclass should have a setMana method
    // For now, let's assume we cast to Mage or handle it via a custom method
    System.out.println(user.getName() + " focuses their mind and regains mana.");
    // logic: user.setMana(user.getMana() + 15);
  }
}
