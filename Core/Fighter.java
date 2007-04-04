import java.util.LinkedList;
import java.util.ListIterator;

import java.util.Scanner;

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
		myBuffs = new LinkedList();
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
			if (b.duration >= System.currentTimeMillis() - b.creationTime)
				i.remove();
			else
			{
				totalToMeleeHit += b.bonusToMeleeHit;
				totalToDodge += b.bonusToDodge;
				totalToBlock += b.bonusToBlock;
				totalToCast += b.bonusToCast;
				totalToSave += b.bonusToSave;
				totalToResist += b.bonusToResist;
				totalToCrit += b.bonusToCrit;
			}
		}
	}

	public abstract void regen();

	public abstract void process();
}
