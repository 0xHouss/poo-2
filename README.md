Below is a **clean object-oriented architecture** for the TP. No code—only the **design, classes, and responsibilities** so you can implement it yourself.

The design focuses on:

* inheritance
* polymorphism
* encapsulation
* extensibility

---

# 1. Project Structure

A simple package structure is enough.

```
rpg/
│
├── characters/
│   ├── Character (abstract)
│   ├── Warrior
│   ├── Mage
│   └── Archer
│
├── abilities/
│   ├── Ability (interface or abstract class)
│   ├── DamageAbility
│   └── HealAbility
│
└── demo/
    └── DemoRPG
```

Minimal version:

```
rpg/
 ├── characters/
 ├── abilities/
 └── DemoRPG
```

---

# 2. Core Abstraction: Character

### `Character` (abstract class)

This is the **base class for all characters**.

It contains everything **shared by all roles**.

---

## Attributes

Common state for every character:

* `name`
* `level`
* `currentHealth`
* `maxHealth`
* `abilities` (array or list with max size **2**)

---

## Responsibilities

Every character must be able to:

* check if they are alive
* receive damage
* heal
* attack
* level up
* manage abilities
* display their state

Conceptual methods (not code):

```
isAlive()

takeDamage(amount)

heal(amount)

attack(Character target)     ← abstract

levelUp()

addAbility(Ability ability)

useAbility(index, Character target)

displayStatus()
```

Important design rule:

`attack()` should be **abstract**, because each role attacks differently.

---

# 3. Character Specializations

Three classes extend `Character`.

```
Character
 ├── Warrior
 ├── Mage
 └── Archer
```

Each subclass adds **specific attributes and behavior**.

---

# Warrior

Represents a **physical fighter / tank**.

### Additional attributes

* `strength`
* `defense`

### Behavior

* deals **strong physical damage**
* reduces part of incoming damage

Example logic:

```
damage dealt = strength * coefficient
damage received = incomingDamage - defense
```

---

# Mage

Represents a **magic user**.

### Additional attributes

* `mana`
* `maxMana`
* `magicPower`

### Behavior

* uses **mana to cast abilities**
* cannot cast spells if mana is insufficient

Attack characteristics:

* magical damage
* consumes mana

---

# Archer

Represents a **ranged attacker**.

### Additional attributes

* `precision`
* `agility`

### Behavior

Attacks depend on accuracy.

Possible outcomes:

```
miss
normal hit
critical hit
```

Example concept:

* precision affects hit chance
* critical hits deal extra damage

---

# 4. Ability System

Abilities are **independent objects** that characters can use.

---

## `Ability`

Should be an **interface or abstract class**.

### Attributes

Minimum requirement:

```
name
```

---

### Core method

Conceptually:

```
use(Character caster, Character target)
```

This makes the system flexible:

* abilities can affect **self**
* abilities can affect **another character**

---

# 5. Ability Implementations

You must implement **at least two abilities**.

Example types:

---

## Damage Ability

```
DamageAbility
```

Effect:

* deals extra damage to a target

---

## Heal Ability

```
HealAbility
```

Effect:

* restores health points

---

Optional extra abilities if you want:

```
ShieldAbility
BuffAbility
ManaRestoreAbility
```

The system should allow **adding new abilities without modifying characters**.

---

# 6. Ability Storage in Characters

Each character can store **up to two abilities**.

Conceptually:

```
Ability[] abilities = new Ability[2]
```

The character manages them.

Key responsibilities:

```
addAbility()

useAbility(index, target)

displayAbilities()
```

Rules enforced here:

* cannot exceed 2 abilities
* cannot use an empty slot
* invalid index must be handled

---

# 7. Combat Actions

Characters perform actions like:

```
attack(target)
useAbility(index, target)
```

---

### Normal Attack Flow

1. check if attacker is alive
2. calculate damage (depends on role)
3. apply damage to target
4. print result

---

### Ability Usage Flow

1. verify ability exists
2. call `ability.use(caster, target)`
3. apply effects
4. display results

---

# 8. Constraint Management (Robustness)

Your classes must enforce constraints.

---

### Character constraints

```
level >= 1
maxHealth > 0
0 <= currentHealth <= maxHealth
```

---

### Combat constraints

```
dead characters cannot act
```

---

### Ability constraints

```
cannot add ability if full
cannot use ability if slot empty
invalid index handled
```

---

### Damage / Healing constraints

```
damage must be positive
healing cannot exceed maxHealth
```

---

# 9. Demonstration Class

`DemoRPG`

This class only **runs a scenario to demonstrate the system**.

---

### Responsibilities

1. Create characters

Example conceptually:

```
Warrior
Mage
```

---

2. Assign abilities

Example:

```
heal ability
special attack ability
```

---

3. Print initial state

Example:

```
=== Initial State ===
Warrior HP: 120/120
Mage HP: 80/80
```

---

4. Run a small combat scenario

At least **3 turns**.

Example structure:

```
Turn 1
Warrior attacks Mage

Turn 2
Mage uses Heal ability

Turn 3
Mage attacks Warrior
```

---

5. Stop when a condition is reached

Example:

```
one character HP = 0
```

---

6. Print final result

Example:

```
Warrior wins!
Mage has been defeated.
```

---

# 10. Minimal Class List

A clean solution can use only **7 classes**:

```
Character (abstract)

Warrior
Mage
Archer

Ability (interface)

DamageAbility
HealAbility

DemoRPG
```

---

# 11. OOP Concepts Demonstrated

Your professor expects to see these clearly.

---

## Encapsulation

Attributes are private.

State changes only through methods.

---

## Inheritance

```
Character
 ├── Warrior
 ├── Mage
 └── Archer
```

---

## Polymorphism

Different implementations of:

```
attack()
```

depending on the role.

---

## Composition

Characters **contain abilities**.

```
Character → Ability[]
```

---

# 12. Important Design Rule

Do **not** hardcode ability behavior inside characters.

Correct design:

```
ability.use(caster, target)
```

The ability object controls its behavior.

Incorrect design:

```
if ability == heal
if ability == fireball
```

Abilities must be **self-contained objects**.

---

If you'd like, I can also show you the **UML class diagram for this design**, which is usually exactly what professors expect for RPG OOP assignments.


