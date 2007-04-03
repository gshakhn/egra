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
	public int currentHealth;

	/**
	 * The maximum durability of this <code>EquippableItem</code>
	 */
	public int maxHealth;

	/**
	 * The increase ToMeleeHit this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public int boostToMeleeHit;

	/**
	 * The increase ToBlock this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public int boostToBlock;

	/**
	 * The increase ToDodge this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public int boostToDodge;

	/**
	 * The increase ToCast this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public int boostToCast;

	/**
	 * The increase ToSave this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public int boostToSave;

	/**
	 * The increase Resist this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public int boostToResist;

	/**
	 * The increase ToCrit this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public int boostToCrit;

	/**
	 * The increase MeleeDamage this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public double boostMeleeDamage;

	/**
	 * The increase SpellDamage this <code>EquippableItem</code> gives the
	 * equipper.
	 */
	public double boostSpellDamage;
}
