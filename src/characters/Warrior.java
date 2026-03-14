package characters;

import characters.Character;

public class Warrior extends Character {
  private Integer strength, defense;

  public Warrior(String name) {
    super(name, 150);
    this.strength = 20;
    this.defense = 10;
  }

  @Override
  public void attackAction(Character that) {
    Integer baseDamage = 15;

    that.takeDamage(strength + baseDamage);
  }

  @Override
  public void takeDamage(int pts) {
    int damage = pts - defense;

    if (damage < 0)
      damage = 0;

    super.takeDamage(damage);
  }
}
