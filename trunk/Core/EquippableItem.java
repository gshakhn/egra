/**
 * An <code>Item</code> that a being can equip on themselves.
 * 
 * @author George Shakhnazaryan
 * 
 */
public abstract class EquippableItem extends Item
{
	/**
	 * The current durability of this <code>EquippableItem</code>.
	 */
	protected int currentHealth;

	/**
	 * The maximum durability of this <code>EquippableItem</code>
	 */
	protected int maxHealth;

	/**
	 * The increase ToMeleeHit this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected int boostToMeleeHit;

	/**
	 * The increase ToBlock this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected int boostToBlock;

	/**
	 * The increase ToDodge this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected int boostToDodge;

	/**
	 * The increase ToCast this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected int boostToCast;

	/**
	 * The increase ToSave this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected int boostToSave;

	/**
	 * The increase Resist this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected int boostToResist;

	/**
	 * The increase ToCrit this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected int boostToCrit;

	/**
	 * The increase MeleeDamage this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected double boostMeleeDamage;

	/**
	 * The increase SpellDamage this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	protected double boostSpellDamage;

	/**
	 * @return the currentHealth
	 */
	public int getCurrentHealth()
	{
		return currentHealth;
	}

	/**
	 * @param currentHealth
	 *            the currentHealth to set
	 */
	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = currentHealth;
	}

	/**
	 * @return the boostMeleeDamage
	 */
	public double getBoostMeleeDamage()
	{
		return boostMeleeDamage;
	}

	/**
	 * @return the boostSpellDamage
	 */
	public double getBoostSpellDamage()
	{
		return boostSpellDamage;
	}

	/**
	 * @return the boostToBlock
	 */
	public int getBoostToBlock()
	{
		return boostToBlock;
	}

	/**
	 * @return the boostToCast
	 */
	public int getBoostToCast()
	{
		return boostToCast;
	}

	/**
	 * @return the boostToCrit
	 */
	public int getBoostToCrit()
	{
		return boostToCrit;
	}

	/**
	 * @return the boostToDodge
	 */
	public int getBoostToDodge()
	{
		return boostToDodge;
	}

	/**
	 * @return the boostToMeleeHit
	 */
	public int getBoostToMeleeHit()
	{
		return boostToMeleeHit;
	}

	/**
	 * @return the boostToResist
	 */
	public int getBoostToResist()
	{
		return boostToResist;
	}

	/**
	 * @return the boostToSave
	 */
	public int getBoostToSave()
	{
		return boostToSave;
	}

	/**
	 * @return the maxHealth
	 */
	public int getMaxHealth()
	{
		return maxHealth;
	}
}
