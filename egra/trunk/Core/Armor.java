/**
 * A piece of armor that the user can equip.
 * 
 * @author George Shakhnazaryan
 */

public class Armor extends EquippableItem
{

	public Armor(String id, int type, String name, int currentHealth,
			int maxHealth, int cost, int melee, int block, int dodge, int cast,
			int save, int resist, int crit, double meleeBonus, double spell)
	{
		this.name = name;
		this.currentHealth = currentHealth;
		this.maxHealth = maxHealth;
		this.id = id;
		this.cost = cost;
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

		uniqueID = null;
	}

	/**
	 * This returns an <code>Item</code> that has the same attributes as this
	 * <code>Item</code>, but a generic uniqueID of null.
	 * 
	 * @see Item
	 */
	public Item cloneItem()
	{
		return new Armor(id, type, name, currentHealth, maxHealth, cost,
				boostToMeleeHit, boostToBlock, boostToDodge, boostToCast,
				boostToSave, boostToResist, boostToCrit, boostMeleeDamage,
				boostSpellDamage);
	}
}