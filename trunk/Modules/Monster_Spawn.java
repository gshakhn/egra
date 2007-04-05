/**
 * A monster that is reborn a certain time after dying.
 * 
 * @author George Shakhnazaryan
 * 
 */
public class Monster_Spawn extends Monster
{

	/**
	 * The time between the Monster dying and spawning again.
	 */
	private int spawnTime;

	public Monster_Spawn(String id, String name, String attack, int minDamage,
			int maxDamage, int toMeleeHit, int toDodge, int toBlock,
			int toCast, int toSave, int toResist, int toCrit, String[] drops,
			int[] chanceToDrop, int maxHealth, int chanceToMove,
			int timeBetweenMoving, int level, String pictureFile, int spawnTime)
	{
		super(id, name, attack, minDamage, maxDamage, toMeleeHit, toDodge,
				toBlock, toCast, toSave, toResist, toCrit, drops, chanceToDrop,
				maxHealth, chanceToMove, timeBetweenMoving, level, pictureFile);

		this.spawnTime = spawnTime;
	}

	protected void reproduce()
	{
		if ((deathTime.getTime() - creationTime.getTime()) >= spawnTime)
			createMonster(homeCell);
	}

	public Monster createMonster(WorldCell home)
	{
		Monster_Spawn m = new Monster_Spawn(id, name, attack, minDamage,
				maxDamage, totalToMeleeHit, totalToDodge, totalToBlock,
				totalToCast, totalToSave, totalToResist, totalToCrit, drops,
				chanceToDrop, myMaxHealth, chanceToMove, timeBetweenMoving,
				level, pictureFile, spawnTime);

		return createMonster(home, m);
	}

	/**
	 * @return the spawnTime
	 */
	public int getSpawnTime()
	{
		return spawnTime;
	}
}
