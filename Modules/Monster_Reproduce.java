/**
 * A monster that is reproduces when two meet.
 * 
 * @author George Shakhnazaryan
 * 
 */
public class Monster_Reproduce extends Monster
{
	/**
	 * Monster won't reproduce if the amount of monsters of this type is above
	 * this value.
	 */
	protected int maxPop;

	protected MonsterGender gender;

	public Monster_Reproduce(String id, String name, String attack,
			int minDamage, int maxDamage, int toMeleeHit, int toDodge,
			int toBlock, int toCast, int toSave, int toResist, int toCrit,
			String[] drops, int[] chanceToDrop, int maxHealth,
			int chanceToMove, int timeBetweenMoving, int level,
			String pictureFile, MonsterGender gender)
	{
		super(id, name, attack, minDamage, maxDamage, toMeleeHit, toDodge,
				toBlock, toCast, toSave, toResist, toCrit, drops, chanceToDrop,
				maxHealth, chanceToMove, timeBetweenMoving, level, pictureFile);

		this.gender = gender;
	}

	/**
	 * TODO
	 */
	protected void reproduce()
	{
	}

	public Monster createMonster(WorldCell home)
	{
		Monster_Reproduce m = new Monster_Reproduce(id, name, attack,
				minDamage, maxDamage, totalToMeleeHit, totalToDodge,
				totalToBlock, totalToCast, totalToSave, totalToResist,
				totalToCrit, drops, chanceToDrop, myMaxHealth, chanceToMove,
				timeBetweenMoving, level, pictureFile, gender);

		return createMonster(home, m);
	}
}
