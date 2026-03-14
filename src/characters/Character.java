package characters;

import java.util.ArrayList;
import abilities.Ability;

public abstract class Character {
  private String name;
  private int level, health, maxHealth;
  private Ability[] abilities = new Ability[2];
  private int maxAbilities = 2;
  private int abilityCount = 0;

  public Character(String name, int maxHealth) {
    this.name = name;
    this.level = 1;

    if (maxHealth <= 0)
      throw new IllegalArgumentException("Max health must be strictly positive!");

    this.maxHealth = maxHealth;
    this.health = maxHealth;
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public int getHealth() {
    return health;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public Ability[] getAbilities() {
    return abilities;
  }

  public void learn(Ability skill) {
    if (abilityCount >= maxAbilities)
      throw new IllegalStateException("Cannot learn more than 2 skills!");

    if (skill.getManaCost() > 0 && !(this instanceof Mage))
      throw new IllegalStateException("Only Mages can learn mana-based abilities!");

    abilities[abilityCount] = skill;
    abilityCount++;
  }

  public boolean isAlive() {
    return health > 0;
  }

  public void takeDamage(int pts) {
    assertAlive();

    if (pts < 0)
      throw new IllegalArgumentException("Cannot take negative damage!");

    health = Math.max(health - pts, 0); // Ensure health does not go below 0

    if (health == 0)
      System.out.println(name + " has fallen!");
  }

  public void heal(int pts) {
    assertAlive();

    if (pts <= 0)
      throw new IllegalArgumentException("Cannot heal negative health!");

    health = Math.min(health + pts, maxHealth); // Ensure health does not exceed maxHealth

    if (health > maxHealth)
      health = maxHealth;
  }

  public final void attack(Character that) {
    assertAlive();
    that.assertAlive();

    this.attackAction(that);
  }

  protected abstract void attackAction(Character that);

  protected void assertAlive() {
    if (!isAlive())
      throw new IllegalStateException("Character dead!");
  }

  public void levelUp() {
    this.levelUp(1);
  }

  public void levelUp(int lvls) {
    if (lvls < 1)
      throw new IllegalArgumentException("Gained levels have to be positive!");

    this.level += lvls;
    System.out.println(name + " viens de monter au niveau " + this.level);
  }

  public void useAbility(int index, ArrayList<Character> targets) {
    assertAlive();

    Ability ability = getAbility(index);

    if (ability.getManaCost() > 0)
      throw new IllegalStateException("This character cannot use abilities!");

    ability.use(this, targets);
  }

  public boolean hasAbility(Ability ability) {
    for (int i = 0; i < abilityCount; i++)
      if (abilities[i].equals(ability))
        return true;

    return false;
  }

  public Ability getAbility(int index) {
    if (index < 0 || index >= abilityCount)
      throw new IllegalArgumentException("Invalid ability index!");

    return abilities[index];
  }

  public String getAbilityString() {
    String abilityString = "";

    if (abilityCount >= 2)
      abilityString = abilities[0].getName() + ", " + abilities[1].getName();
    else if (abilityCount == 1)
      abilityString = abilities[0].getName();
    else
      abilityString = "Aucun";

    return abilityString;
  }

  public void displayStatus() {
    System.out.println(this);
  }

  public void displayAbilities() {
    System.out.println("Abilities of " + name + ":");
    for (int i = 0; i < abilityCount; i++) {
      System.out.println(" - " + abilities[i]);
    }
  }

  @Override
  public String toString() {
    return name + "\n" +
        " - Health: " + health + "/" + maxHealth + (isAlive() ? "" : " [Defeated]") + "\n" +
        " - Level: " + level + "\n" +
        " - Skills: " + getAbilityString();
  }
}
