import java.util.Date;

/**
 * Information about the monster.
 * 
 * @author George Shakhnazaryan
 * 
 */
public class Monster extends Fighter
{
	/**
	 * The ID of this <code>Monster</code>. Each <code>Monster</code> has
	 * an ID, but a specific instance of an <code>Monster</code> has its own
	 * uniqueID.
	 */
	private String id;

	/**
	 * The unique ID of a specific instance of an <code>Monster</code>.
	 * Defaults to null when an <code>Monster</code> is created with the
	 * constructor.
	 */
	private String uniqueID;

	/**
	 * The name of this <code>Monster</code> for the end user.
	 */
	private String name;

	/**
	 * The ID of the Ability the monster uses.
	 */
	private String attack;

	/**
	 * The monster's original cell.
	 */
	private WorldCell homeCell;

	/**
	 * The IDs of the Items the Monster can drop.
	 */
	private String[] drops;

	/**
	 * The chance that the item is actually dropped. x / 1000.
	 */
	private int[] chanceToDrop;

	/**
	 * Is the Monster alive or not?
	 */
	private boolean alive;

	/**
	 * The time between the Monster dying and spawning again.
	 */
	private int spawnTime;

	/**
	 * The time the Monster was created.
	 */
	private Date creationTime;

	/**
	 * The time the Monster died.
	 */
	private Date deathTime;

	/**
	 * The chance that the Monster will move to another cell. x / 1000.
	 */
	private int chanceToMove;

	/**
	 * The time the Monster last moved.
	 */
	private Date lastMoved;

	/**
	 * The time interval between which the Monster chooses to move or not.
	 */
	private int timeBetweenMoving;

	/**
	 * The level of the Monster.
	 */
	private int level;

	/**
	 * The file name of the image of the Monster.
	 */
	private String pictureFile;

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

	/**
	 * @return The ID's of the Items this monster drops.
	 */
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
			deathTime = new Date();
			alive = false;
		}

		// Possible movement
		if (System.currentTimeMillis() - lastMoved.getTime() > timeBetweenMoving
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

			lastMoved = new Date();
		}

		processBuffs();
	}

	/**
	 * Creates a specific instance of the <code>Monster</code>.
	 * 
	 * @return A specific instance of this <code>Monster</code>.
	 */
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

		creationTime = new Date();
		lastMoved = new Date();

		return m;
	}

	/**
	 * Returns a string identifying this Monster.
	 * 
	 * Format: ID + " " + Name
	 * 
	 * @return The ID + name of this Monster.
	 */
	public String toString()
	{
		return String.valueOf(id) + " " + name;
	}

	/**
	 * Returns information about the Monster to the client in a human-readable
	 * format.
	 * 
	 * @return Information about the <code>Monster</code>.
	 */
	public String getInfo()
	{
		String s = "";
		s += "ID: " + String.valueOf(id) + "\n";
		s += "Name: " + name + "\n";
		s += "Ability: " + attack.toString() + "\n";

		return s;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive()
	{
		return alive;
	}

	/**
	 * @return the attack
	 */
	public String getAttack()
	{
		return attack;
	}

	/**
	 * @return the chanceToDrop
	 */
	public int[] getChanceToDrop()
	{
		return chanceToDrop;
	}

	/**
	 * @return the chanceToMove
	 */
	public int getChanceToMove()
	{
		return chanceToMove;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime()
	{
		return creationTime;
	}

	/**
	 * @return the deathTime
	 */
	public Date getDeathTime()
	{
		return deathTime;
	}

	/**
	 * @return the drops
	 */
	public String[] getDrops()
	{
		return drops;
	}

	/**
	 * @return the homeCell
	 */
	public WorldCell getHomeCell()
	{
		return homeCell;
	}

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @return the lastMoved
	 */
	public Date getLastMoved()
	{
		return lastMoved;
	}

	/**
	 * @return the level
	 */
	public int getLevel()
	{
		return level;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the pictureFile
	 */
	public String getPictureFile()
	{
		return pictureFile;
	}

	/**
	 * @return the spawnTime
	 */
	public int getSpawnTime()
	{
		return spawnTime;
	}

	/**
	 * @return the timeBetweenMoving
	 */
	public int getTimeBetweenMoving()
	{
		return timeBetweenMoving;
	}

	/**
	 * @return the uniqueID
	 */
	public String getUniqueID()
	{
		return uniqueID;
	}
}