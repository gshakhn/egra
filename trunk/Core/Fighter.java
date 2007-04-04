import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Generic fighter, either player or monster.
 * 
 * @author George Shakhnazaryan
 */
public abstract class Fighter
{

	public int totalToMeleeHit;

	public int totalToDodge;

	public int totalToBlock;

	public int totalToCast;

	public int totalToSave;

	public int totalToResist;

	public int totalToCrit;

	public int baseToMeleeHit;

	public int baseToDodge;

	public int baseToBlock;

	public int baseToCast;

	public int baseToSave;

	public int baseToResist;

	public int baseToCrit;

	public int minDamage;

	public int maxDamage;

	public double meleeBoost;

	public double spellBoost;

	public int myMaxHealth;

	public int myCurrentHealth;

	public WorldCell currentCell;

	public int timeBeforeAttack;

	public LinkedList<Buff> myBuffs;

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
}
