/**
 * Information about the melee weapon.
 * 
 * @author George Shakhnazaryan
 */
public class MeleeWeapon extends EquippableItem
{

	/**
	 * The hand the weapon is in.
	 */
	private WeaponHand hand;

	/**
	 * The minimum base damage the weapon does.
	 */
	private int minDamage;

	/**
	 * The maxium base damage the weapon does.
	 */
	private int maxDamage;

	/**
	 * An extra ability the weapon automatically performs. e.g. Bleeding attack
	 * to give bleeding debuff.
	 */
	private String extraAbility;

	/**
	 * Chance the weapon has in attacking multiple times.
	 */
	private int chanceForExtra;

	public MeleeWeapon(String id, ItemType type, String name, int minDamage,
			int maxDamage, int currentHealth, int maxHealth, int cost,
			WeaponHand hand, int melee, int block, int dodge, int cast,
			int save, int resist, int crit, double meleeBonus, double spell,
			String extraAbility, int chanceForExtra)
	{
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.currentHealth = currentHealth;
		this.maxHealth = maxHealth;
		this.cost = cost;
		this.id = id;
		this.hand = hand;
		this.type = type;

		boostToMeleeHit = melee;
		boostToBlock = block;
		boostToDodge = dodge;
		boostToCast = cast;
		boostToSave = save;
		boostToResist = resist;
		boostToCrit = crit;

		boostMeleeDamage = meleeBonus;
		boostSpellDamage = spell;

		this.extraAbility = extraAbility;
		this.chanceForExtra = chanceForExtra;
	}

	/**
	 * This returns an <code>Item</code> that has the same attributes as this
	 * <code>Item</code>, but a generic uniqueID of null.
	 * 
	 * @see Item
	 */
	public Item cloneItem()
	{
		return new MeleeWeapon(id, type, name, minDamage, maxDamage,
				currentHealth, maxHealth, cost, hand, boostToMeleeHit,
				boostToBlock, boostToDodge, boostToCast, boostToSave,
				boostToResist, boostToCrit, boostMeleeDamage, boostSpellDamage,
				extraAbility, chanceForExtra);
	}

	/**
	 * @return the chanceForExtra
	 */
	public int getChanceForExtra()
	{
		return chanceForExtra;
	}

	/**
	 * @return the extraAbility
	 */
	public String getExtraAbility()
	{
		return extraAbility;
	}

	/**
	 * @return the hand
	 */
	public WeaponHand getHand()
	{
		return hand;
	}

	/**
	 * @return the maxDamage
	 */
	public int getMaxDamage()
	{
		return maxDamage;
	}

	/**
	 * @return the minDamage
	 */
	public int getMinDamage()
	{
		return minDamage;
	}
}