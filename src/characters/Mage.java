package characters;

import java.util.ArrayList;
import abilities.Ability;
import characters.Character;

public class Mage extends Character {
  private Integer mana, maxMana, intelligence;

  public Mage(String name) {
    super(name, 100);
    this.mana = 100;
    this.maxMana = 100;
    this.intelligence = 20;
  }

  public Integer getMana() {
    return mana;
  }

  public void loseMana(int pts) {
    if (pts < 0)
      throw new IllegalArgumentException("Mana loss cannot be negative!");

    if (pts > mana)
      throw new IllegalStateException("Not enough mana to lose " + pts + " points!");

    this.mana -= pts;
  }

  public void regenerateMana(int pts) {
    if (pts < 0)
      throw new IllegalArgumentException("Mana regeneration cannot be negative!");

    this.mana = Math.min(maxMana, mana + pts);
  }

  @Override
  public void attackAction(Character that) {
    int damage = intelligence + (int) (Math.random() * 10); // Basic spell damage based on intelligence
    that.takeDamage(damage);
    this.mana = Math.min(maxMana, mana + 5); // Regenerate some mana on basic attack
    System.out.println(getName() + " casts a basic spell on " + that.getName() + " for " + damage + " damage!");
  }

  @Override
  public void useAbility(int index, ArrayList<Character> targets) {
    assertAlive();

    Ability ability = getAbility(index);

    if (ability.getManaCost() > mana)
      throw new IllegalStateException("Not enough mana to use " + ability.getName() + "!");

    ability.use(this, targets);
  }

  @Override
  public String toString() {
    return getName() + "\n" +
        " - Health: " + getHealth() + "/" + getMaxHealth() + (isAlive() ? "" : " [Defeated]") + "\n" +
        " - Mana: " + mana + "/" + maxMana + "\n" +
        " - Level: " + getLevel() + "\n" +
        " - Skills: " + getAbilityString();
  }
}
