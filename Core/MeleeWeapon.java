/**
 * Information about the melee weapon.
 * 
 * @author George Shakhnazaryan
 */
public class MeleeWeapon extends EquippableItem
{

	public int hand;

	// 1 = either
	// 2 = main
	// 3 = off
	// 4 = both

	public int minDamage;

	public int maxDamage;

	public String extraAbility;

	public int chanceForExtra;

	public MeleeWeapon(String id, ItemType type, String name, int minDamage,
			int maxDamage, int currentHealth, int maxHealth, int cost,
			int hand, int melee, int block, int dodge, int cast, int save,
			int resist, int crit, double meleeBonus, double spell,
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

	public Item cloneItem()
	{
		return new MeleeWeapon(id, type, name, minDamage, maxDamage,
				currentHealth, maxHealth, cost, hand, boostToMeleeHit,
				boostToBlock, boostToDodge, boostToCast, boostToSave,
				boostToResist, boostToCrit, boostMeleeDamage, boostSpellDamage,
				extraAbility, chanceForExtra);
	}
}