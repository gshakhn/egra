import java.util.ArrayList;

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
	private String id;

	/**
	 * The name of this <code>Ability</code> for the end user.
	 */
	private String name;

	/**
	 * The mana cost of using this <code>Ability</code>.
	 */
	private int manaCost;

	/**
	 * The energy cost of using this <code>Ability</code>.
	 */
	private int energyCost;

	/**
	 * The delay in time before the <code>Ability</code> is performed after it
	 * is selected.
	 */
	private int timeBefore;

	/**
	 * The delay in using any other Abilities after the <code>Ability</code>
	 * is performed.
	 */
	private int timeAfter;

	/**
	 * The types of abilities.
	 */
	public enum AbilityType (ATTACK, OFFENSIVE_SPELL, DEFENSIVE_SPELL)
	
	/**
	 * The type of this ability.
	 */
	private AbilityType type;

	/**
	 * The base damage of the weapon is multiplied by this value.
	 */
	private double weaponMultiplier;

	/**
	 * The base damage of the <code>Ability</code>. This is added to the
	 * multiplied weapon damage to calculate the damage of the
	 * <code>Ability</code>.
	 * 
	 * If it is a spell, it is pure damage done to the enemy.
	 * 
	 * If it is a heal, the user is healed by this amount.
	 */
	private int damage;

	/**
	 * This value is added to the user's ToMeleeHit to calculate the attack for
	 * the use of this <code>Ability</code> only.
	 */
	private int temporaryBoostToMeleeHit;

	/**
	 * This value is added to the user's ToCast to calculate the attack for the
	 * use of this <code>Ability</code> only.
	 */
	private int temporaryBoostToCast;

	/**
	 * This value is added to the user's ToCrit to calculate the attack for the
	 * use of this <code>Ability</code> only.
	 */
	private int temporaryBoostToCrit;

	/**
	 * These buffs are added to the user by the <code>Ability</code>.
	 */
	private ArrayList<Buff> helpfulBuffs;

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
	 * These Buffs are added to the target by the <code>Ability</code>.
	 */
	public ArrayList<Buff> deBuffs;

	/**
	 * The experience necessary to use the <code>Ability</code>.
	 */
	public int XPCost;

	/**
	 * The cost to purchase the <code>Ability</code> in monetary units.
	 */
	public int goldCost;

	public Ability(String id, String name, int manaCost, int energyCost,
			int timeBefore, int timeAfter, AbilityType type,
			double weaponMultiplier, int damage, int temporaryBoostToMeleeHit,
			int temporaryBoostToCast, int temporaryBoostToCrit,
			ArrayList<Buff> helpfulBuffs, int temporaryDamageToBlock,
			int temporaryDamageToDodge, int temporaryDamageToSave,
			int temporaryDamageToResist, ArrayList<Buff> deBuffs, int XPCost, int goldCost)
	{
		this.id = id;
		this.name = name;
		this.manaCost = manaCost;
		this.energyCost = energyCost;
		this.timeBefore = timeBefore;
		this.timeAfter = timeAfter;
		this.type = type;
		this.weaponMultiplier = weaponMultiplier;
		this.damage = damage;
		this.temporaryBoostToMeleeHit = temporaryBoostToMeleeHit;
		this.temporaryBoostToCast = temporaryBoostToCast;
		this.helpfulBuffs = helpfulBuffs;
		this.temporaryDamageToBlock = temporaryDamageToBlock;
		this.temporaryDamageToDodge = temporaryDamageToDodge;
		this.temporaryDamageToSave = temporaryDamageToSave;
		this.temporaryDamageToResist = temporaryDamageToResist;
		this.deBuffs = deBuffs;
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
		s += "AbilityType: " + type + "\n";
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
    /**
     * @return Returns the damage.
     */
    public int getDamage() {
        return damage;
    }
    /**
     * @return Returns the energyCost.
     */
    public int getEnergyCost() {
        return energyCost;
    }
    /**
     * @return Returns the goldCost.
     */
    public int getGoldCost() {
        return goldCost;
    }
    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }
    /**
     * @return Returns the manaCost.
     */
    public int getManaCost() {
        return manaCost;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @return Returns the temporaryBoostToCast.
     */
    public int getTemporaryBoostToCast() {
        return temporaryBoostToCast;
    }
    /**
     * @return Returns the temporaryBoostToCrit.
     */
    public int getTemporaryBoostToCrit() {
        return temporaryBoostToCrit;
    }
    /**
     * @return Returns the temporaryBoostToMeleeHit.
     */
    public int getTemporaryBoostToMeleeHit() {
        return temporaryBoostToMeleeHit;
    }
    /**
     * @return Returns the temporaryDamageToBlock.
     */
    public int getTemporaryDamageToBlock() {
        return temporaryDamageToBlock;
    }
    /**
     * @return Returns the temporaryDamageToDodge.
     */
    public int getTemporaryDamageToDodge() {
        return temporaryDamageToDodge;
    }
    /**
     * @return Returns the temporaryDamageToResist.
     */
    public int getTemporaryDamageToResist() {
        return temporaryDamageToResist;
    }
    /**
     * @return Returns the temporaryDamageToSave.
     */
    public int getTemporaryDamageToSave() {
        return temporaryDamageToSave;
    }
    /**
     * @return Returns the timeAfter.
     */
    public int getTimeAfter() {
        return timeAfter;
    }
    /**
     * @return Returns the timeBefore.
     */
    public int getTimeBefore() {
        return timeBefore;
    }
    /**
     * @return Returns the type.
     */
    public AbilityType getType() {
        return type;
    }
    /**
     * @return Returns the weaponMultiplier.
     */
    public double getWeaponMultiplier() {
        return weaponMultiplier;
    }
    /**
     * @return Returns the xPCost.
     */
    public int getXPCost() {
        return XPCost;
    }
}