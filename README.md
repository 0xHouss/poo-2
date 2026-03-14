## RPG System: DemoRPG Execution Guide

### Overview

The DemoRPG class serves as the entry point for a console-based battle simulation. It demonstrates a robust RPG framework using Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, and encapsulation. The execution is structured as a Tri-Matchup Tournament, where three distinct character roles (Warrior, Mage, and Archer) face off in 1v1 combat.

---

### Execution Logic

The program follows a strictly defined execution flow to meet the requirements of the simulation:

#### 1. Matchup Initialization

In the main method, the simulation triggers three independent games. For each game, characters are recreated from scratch. By instantiating new objects (e.g., new Warrior("Thorin")) for every match, we ensure all characters start with full Health (HP) and full Mana (MP).

The matches are ordered as follows:

* Game 1: Warrior vs. Mage
* Game 2: Warrior vs. Archer
* Game 3: Archer vs. Mage

#### 2. The runBattle Static Function

This is the core engine of the demo. It takes two Character objects and executes a loop that persists until a logical end-game condition is met. The loop continues as long as p1.isAlive() and p2.isAlive() return true. It calculates rounds and manages turn-based logic.

#### 3. Action and Attack Types

The simulation is programmed to showcase three distinct types of actions across a minimum of 3 rounds:

* Round 1: Normal Attack. A basic physical strike with no resource cost.
* Round 2: Special Ability. A class-specific move (e.g., ShieldSlam, Fireball).
* Round 3+: Advanced/AoE. High-tier abilities or secondary skills (e.g., ArrowRain).

---

### Resource and Role Management

#### Mana Constraints (The Mage Check)

The execution includes a specific safeguard for magic users. Before a Mage uses a special ability, the system calls getMana(). If the mana is below the required threshold (e.g., 15 MP), the spell fails. The console logs "OUT OF MANA!" and the character defaults to a Normal Attack to ensure the turn is not skipped.

#### Role Differentiation

The demo highlights the unique mechanics of each role:

* Warrior: High HP, focus on physical damage and survival.
* Archer: Moderate HP, high precision and multi-target abilities.
* Mage: Low HP, dependent on Mana for high-impact area-of-effect (AoE) spells.

---

### Console Output Requirements

After every single action, the system provides a real-time status update to the console, including:

1. The Actor: Who is performing the action.
2. The Action: Whether it was a normal strike or a specific ability.
3. The Target: Who received the impact.
4. The Result: The updated Health Points (HP) of the target using the getHealth() method.

---

### End-Game Condition

The match concludes immediately when a character's HP drops to 0. The static function then breaks the combat loop, evaluates the winner using isAlive(), and displays the Final Result and the winning character's name.
