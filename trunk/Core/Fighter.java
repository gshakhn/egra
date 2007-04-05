import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Generic fighter, either player or monster.
 * 
 * @author George Shakhnazaryan
 */
public abstract class Fighter
{

	protected int totalToMeleeHit;

	protected int totalToDodge;

	protected int totalToBlock;

	protected int totalToCast;

	protected int totalToSave;

	protected int totalToResist;

	protected int totalToCrit;

	protected int baseToMeleeHit;

	protected int baseToDodge;

	protected int baseToBlock;

	protected int baseToCast;

	protected int baseToSave;

	protected int baseToResist;

	protected int baseToCrit;

	protected int minDamage;

	protected int maxDamage;

	protected double meleeBoost;

	protected double spellBoost;

	protected int myMaxHealth;

	protected int myCurrentHealth;

	protected WorldCell currentCell;

	protected int timeBeforeAttack;

	protected LinkedList<Buff> myBuffs;

	public Fighter()
	{
		myBuffs = new LinkedList<Buff>();
	}

	public void processBuffs()
	{
		totalToMeleeHit = baseToMeleeHit;
		totalToDodge = baseToDodge;
		totalToBlock = baseToBlock;
		totalToCast = baseToCast;
		totalToSave = baseToSave;
		totalToResist = baseToResist;
		totalToCrit = baseToCrit;

		for (ListIterator i = myBuffs.listIterator(); i.hasNext();)
		{
			Buff b = (Buff) (i.next());
			if (b.getCreationTime().after(b.getExpirationTime()))
				i.remove();
			else
			{
				totalToMeleeHit += b.getBonusToMeleeHit();
				totalToDodge += b.getBonusToDodge();
				totalToBlock += b.getBonusToBlock();
				totalToCast += b.getBonusToCast();
				totalToSave += b.getBonusToSave();
				totalToResist += b.getBonusToResist();
				totalToCrit += b.getBonusToCrit();
			}
		}
	}

	public abstract void regen();

	public abstract void process();

	/**
	 * @return the baseToBlock
	 */
	public int getBaseToBlock()
	{
		return baseToBlock;
	}

	/**
	 * @return the baseToCast
	 */
	public int getBaseToCast()
	{
		return baseToCast;
	}

	/**
	 * @return the baseToCrit
	 */
	public int getBaseToCrit()
	{
		return baseToCrit;
	}

	/**
	 * @return the baseToDodge
	 */
	public int getBaseToDodge()
	{
		return baseToDodge;
	}

	/**
	 * @return the baseToMeleeHit
	 */
	public int getBaseToMeleeHit()
	{
		return baseToMeleeHit;
	}

	/**
	 * @return the baseToResist
	 */
	public int getBaseToResist()
	{
		return baseToResist;
	}

	/**
	 * @return the baseToSave
	 */
	public int getBaseToSave()
	{
		return baseToSave;
	}

	/**
	 * @return the currentCell
	 */
	public WorldCell getCurrentCell()
	{
		return currentCell;
	}

	/**
	 * @return the maxDamage
	 */
	public int getMaxDamage()
	{
		return maxDamage;
	}

	/**
	 * @return the meleeBoost
	 */
	public double getMeleeBoost()
	{
		return meleeBoost;
	}

	/**
	 * @return the minDamage
	 */
	public int getMinDamage()
	{
		return minDamage;
	}

	/**
	 * @return the myBuffs
	 */
	public LinkedList<Buff> getMyBuffs()
	{
		return myBuffs;
	}

	/**
	 * @return the myCurrentHealth
	 */
	public int getMyCurrentHealth()
	{
		return myCurrentHealth;
	}

	/**
	 * @return the myMaxHealth
	 */
	public int getMyMaxHealth()
	{
		return myMaxHealth;
	}

	/**
	 * @return the spellBoost
	 */
	public double getSpellBoost()
	{
		return spellBoost;
	}

	/**
	 * @return the timeBeforeAttack
	 */
	public int getTimeBeforeAttack()
	{
		return timeBeforeAttack;
	}

	/**
	 * @return the totalToBlock
	 */
	public int getTotalToBlock()
	{
		return totalToBlock;
	}

	/**
	 * @return the totalToCast
	 */
	public int getTotalToCast()
	{
		return totalToCast;
	}

	/**
	 * @return the totalToCrit
	 */
	public int getTotalToCrit()
	{
		return totalToCrit;
	}

	/**
	 * @return the totalToDodge
	 */
	public int getTotalToDodge()
	{
		return totalToDodge;
	}

	/**
	 * @return the totalToMeleeHit
	 */
	public int getTotalToMeleeHit()
	{
		return totalToMeleeHit;
	}

	/**
	 * @return the totalToResist
	 */
	public int getTotalToResist()
	{
		return totalToResist;
	}

	/**
	 * @return the totalToSave
	 */
	public int getTotalToSave()
	{
		return totalToSave;
	}
}
