/**
 * Information about the monster.
 * 
 * @author George Shakhnazaryan
 * 
 */
public class Monster extends Fighter
{
	public String id;

	public String name;

	public String attack;

	public WorldCell homeCell;

	public String[] drops;

	public int[] chanceToDrop;

	public String uniqueID;

	public boolean alive;

	public int spawnTime;

	public long deathTime;

	public int chanceToMove;

	public long lastMoved;

	public int timeBetweenMoving;

	public int level;

	public String pictureFile;

	public Monster(String id, String name, String attack, int minDamage,
			int maxDamage, int toMeleeHit, int toDodge, int toBlock,
			int toCast, int toSave, int toResist, int toCrit, String[] drops,
			int[] chanceToDrop, int maxHealth, int chanceToMove,
			int timeBeforeMoving, int level, String pictureFile)
	{
		super();

		this.id = id;
		this.name = name;
		this.attack = attack;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;

		this.totalToMeleeHit = toMeleeHit;
		this.totalToDodge = toDodge;
		this.totalToBlock = toBlock;
		this.totalToCast = toCast;
		this.totalToSave = toSave;
		this.totalToResist = toResist;
		this.totalToCrit = toCrit;

		this.drops = drops;
		this.chanceToDrop = chanceToDrop;

		this.chanceToMove = chanceToMove;
		lastMoved = 0;
		this.timeBetweenMoving = timeBeforeMoving;

		myMaxHealth = maxHealth;

		timeBeforeAttack = 0;

		this.level = level;

		this.pictureFile = pictureFile;
	}

	public void regen()
	{
		myCurrentHealth += (int) ((double) myMaxHealth * 0.1);
	}

	public String[] drop()
	{
		String[] whatDrops = new String[drops.length];
		int nbrDrops = 0;
		for (int ind = 0; ind < drops.length; ind++)
			if ((int) (Math.random() * 100) + 1 > chanceToDrop[ind])
			{
				whatDrops[nbrDrops] = drops[ind];
				nbrDrops++;
			}
		String[] theDrops = new String[nbrDrops];
		for (int ind = 0; ind < nbrDrops; ind++)
			theDrops[ind] = whatDrops[ind];
		return theDrops;
	}

	public void process()
	{
		// Check Death
		if (alive && myCurrentHealth != 0)
		{
			deathTime = System.currentTimeMillis();
			alive = false;
		}

		// Possible movement
		if (System.currentTimeMillis() - lastMoved > timeBetweenMoving
				&& (int) (Math.random() * 100) + 1 > chanceToMove)
		{
			WorldCell[] directions = currentCell.directions;
			int direction;
			do
			{
				direction = (int) (Math.random() * 4);
			} while (directions[direction] != null);

			currentCell.removeCharacter(this);
			currentCell = directions[direction];
			currentCell.addCharacter(this);

			lastMoved = System.currentTimeMillis();
		}

		processBuffs();
	}

	public Monster createMonster(WorldCell home)
	{
		Monster m = new Monster(id, name, attack, minDamage, maxDamage,
				totalToMeleeHit, totalToDodge, totalToBlock, totalToCast,
				totalToSave, totalToResist, totalToCrit, drops, chanceToDrop,
				myMaxHealth, chanceToMove, timeBetweenMoving, level,
				pictureFile);

		m.myCurrentHealth = myMaxHealth;

		m.uniqueID = "M-" + String.valueOf(id) + "-"
				+ String.valueOf(Database.nextID());

		homeCell = home;
		currentCell = home;

		alive = true;

		return m;
	}

	public String toString()
	{
		return String.valueOf(id) + " " + name;
	}

	public String getInfo()
	{
		String s = "";
		s += "ID: " + String.valueOf(id) + "\n";
		s += "Name: " + name + "\n";
		s += "Ability: " + attack.toString() + "\n";

		return s;
	}
}