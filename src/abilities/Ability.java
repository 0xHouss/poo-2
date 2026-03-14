package abilities;

import java.util.ArrayList;
import characters.Character;
import characters.Mage;

public abstract class Ability {
  private String name, description;
  private int manaCost;

  public Ability(String name, String description, int manaCost) {
    if (manaCost < 0)
      throw new IllegalArgumentException("Mana cost cannot be negative!");

    this.name = name;
    this.description = description;
    this.manaCost = manaCost;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getManaCost() {
    return manaCost;
  }

  public void use(Character user, ArrayList<Character> targets) {
    if (manaCost > 0) {
      if (!(user instanceof Mage))
        throw new IllegalStateException("Only Mages can use mana-based abilities!");

      Mage mageUser = (Mage) user;

      if (mageUser.getMana() < manaCost)
        throw new IllegalStateException("Not enough mana to use " + name + "!");

      mageUser.loseMana(manaCost);
    }

    useAction(user, targets);
  }

  protected abstract void useAction(Character user, ArrayList<Character> target);

  @Override
  public String toString() {
    return name + ": " + description;
  }
}
