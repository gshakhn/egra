/**
 * An ability, such as spell or special attack.
 * 
 * @author George Shakhnazaryan
 */
public class Ability
{
	/**
	 * The unique ID of this <code>Ability</code>.
	 */
	public String id;

	/**
	 * The name of this <code>Ability</code> for the end user.
	 */
	public String name;

	/**
	 * The mana cost of using this <code>Ability</code>.
	 */
	public int manaCost;

	/**
	 * The energy cost of using this <code>Ability</code>.
	 */
	public int energyCost;

	/**
	 * The delay in time before the <code>Ability</code> is performed after it
	 * is selected.
	 */
	public int timeBefore;

	/**
	 * The delay in using any other Abilities after the <code>Ability</code>
	 * is performed.
	 */
	public int timeAfter;

	/**
	 * Whether or not this <code>Ability</code> is a spell.
	 */
	public boolean spell;

	/**
	 * Whether of not this <code>Ability</code> is a heal.
	 */
	public boolean heal;

	/**
	 * The base damage of the weapon is multiplied by this value.
	 */
	public double weaponMultiplier;

	/**
	 * The base damage of the <code>Ability</code>. This is added to the
	 * multiplied weapon damage to calculate the damage of the
	 * <code>Ability</code>.
	 */
	public int damage;

	/**
	 * This value is added to the user's ToMeleeHit to calculate the attack for
	 * the use of this <code>Ability</code> only.
	 */
	public int temporaryBoostToMeleeHit;

	/**
	 * This value is added to the user's ToCast to calculate the attack for the
	 * use of this <code>Ability</code> only.
	 */
	public int temporaryBoostToCast;

	/**
	 * This value is added to the user's ToCrit to calculate the attack for the
	 * use of this <code>Ability</code> only.
	 */
	public int temporaryBoostToCrit;

	/**
	 * The Buff is added to the user by the <code>Ability</code>.
	 */
	public Buff helpfulBuff;

	/**
	 * This value is added to the target's ToBlock to calculate the attack for
	 * the use of this <code>Ability</code> only.
	 */
	public int temporaryDamageToBlock;

	/**
	 * This value is added to the target's ToMeleeHit to calculate the attack
	 * for the use of this <code>Ability</code> only.
	 */
	public int temporaryDamageToDodge;

	/**
	 * This value is added to the target's ToDodge to calculate the attack for
	 * the use of this <code>Ability</code> only.
	 */
	public int temporaryDamageToSave;

	/**
	 * This value is added to the target's ToSave to calculate the attack for
	 * the use of this <code>Ability</code> only.
	 */
	public int temporaryDamageToResist;

	/**
	 * The Buff is added to the target by the <code>Ability</code>.
	 */
	public Buff deBuff;

	/**
	 * The experience necessary to use the <code>Ability</code>.
	 */
	public int XPCost;

	/**
	 * The cost to purchase the <code>Ability</code> in monetary units.
	 */
	public int goldCost;

	public Ability(String id, String name, int manaCost, int energyCost,
			int timeBefore, int timeAfter, boolean spell, boolean heal,
			double weaponMultiplier, int damage, int temporaryBoostToMeleeHit,
			int temporaryBoostToCast, int temporaryBoostToCrit,
			Buff helpfulBuff, int temporaryDamageToBlock,
			int temporaryDamageToDodge, int temporaryDamageToSave,
			int temporaryDamageToResist, Buff deBuff, int XPCost, int goldCost)
	{
		this.id = id;
		this.name = name;
		this.manaCost = manaCost;
		this.energyCost = energyCost;
		this.timeBefore = timeBefore;
		this.timeAfter = timeAfter;
		this.spell = spell;
		this.heal = heal;
		this.weaponMultiplier = weaponMultiplier;
		this.damage = damage;
		this.temporaryBoostToMeleeHit = temporaryBoostToMeleeHit;
		this.temporaryBoostToCast = temporaryBoostToCast;
		this.helpfulBuff = helpfulBuff;
		this.temporaryDamageToBlock = temporaryDamageToBlock;
		this.temporaryDamageToDodge = temporaryDamageToDodge;
		this.temporaryDamageToSave = temporaryDamageToSave;
		this.temporaryDamageToResist = temporaryDamageToResist;
		this.deBuff = deBuff;
		this.XPCost = XPCost;
		this.goldCost = goldCost;
	}

	/**
	 * Returns a string identifying this unique Ability.
	 */
	public String toString()
	{
		return String.valueOf(id) + " " + name;
	}

	/**
	 * Returns information about the ability to the client in a human-readable
	 * format.
	 * 
	 * @return Information about the <code>Ability</code>.
	 */
	public String getInfo()
	{
		String s = "";
		s += "Ability Info:\n";
		s += "ID: " + String.valueOf(id) + "\n";
		s += "Name: " + name + "\n";
		s += "Mana Cost: " + String.valueOf(manaCost) + "\n";
		s += "Energy Cost: " + String.valueOf(energyCost) + "\n";
		s += "Spell: " + String.valueOf(spell) + "\n";
		s += "Heal: " + String.valueOf(heal) + "\n";
		s += "Base Damage Multiplier: " + String.valueOf(weaponMultiplier)
				+ "\n";
		s += "Boost to Damage: " + String.valueOf(damage) + "\n";
		s += "Instant Boost to Melee Damage: "
				+ String.valueOf(temporaryBoostToMeleeHit) + "\n";
		s += "Instant Boost to Cast: " + String.valueOf(temporaryBoostToCast)
				+ "\n";
		s += "Instant Boost to Crit: " + String.valueOf(temporaryBoostToCrit)
				+ "\n";
		s += "Buff to User: " + helpfulBuff.toString() + "\n";
		s += "Instant Damage to Dodge: "
				+ String.valueOf(temporaryDamageToDodge) + "\n";
		s += "Instant Damage to Block: "
				+ String.valueOf(temporaryDamageToBlock) + "\n";
		s += "Instant Damage to Save: " + String.valueOf(temporaryDamageToSave)
				+ "\n";
		s += "Instant Damage to Resist: "
				+ String.valueOf(temporaryDamageToResist) + "\n";
		s += "Buff to Enemy: " + deBuff.toString() + "\n";
		s += "Needed XP to Get: " + String.valueOf(XPCost) + "\n";
		s += "Gold Cost: " + String.valueOf(goldCost);

		return s;
	}
}