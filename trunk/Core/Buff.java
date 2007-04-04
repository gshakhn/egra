import java.util.Date;

/**
 * A buff to a fighter.
 * 
 * @author George Shakhnazaryan
 */
public class Buff
{

	private String id;
	
	private String uniqueID;

	private String name;

	private int bonusToMeleeHit;

	private int bonusToDodge;

	private int bonusToBlock;

	private int bonusToCast;

	private int bonusToSave;

	private int bonusToResist;

	private int bonusToCrit;

	private int damagePerTick;

	private int timePerTick;

	private Date creationTime;

	private Date expirationTime;

	private int duration;

	private String pictureFile;

	public Buff(String id, String name, int bonusToMeleeHit, int bonusToDodge,
			int bonusToBlock, int bonusToCast, int bonusToSave,
			int bonusToResist, int bonusToCrit, int damagePerTick,
			int timePerTick, int duration, String pictureFile)
	{
		this.id = id;
		this.name = name;

		this.bonusToMeleeHit = bonusToMeleeHit;
		this.bonusToDodge = bonusToDodge;
		this.bonusToBlock = bonusToBlock;
		this.bonusToCast = bonusToCast;
		this.bonusToSave = bonusToSave;
		this.bonusToResist = bonusToResist;
		this.bonusToCrit = bonusToCrit;

		this.damagePerTick = damagePerTick;
		this.timePerTick = timePerTick;
		this.duration = duration;

		this.pictureFile = pictureFile;
		
		uniqueID = null;
	}

	/**
	 * Returns a string identifying this Buff.
	 * 
	 * Format:
	 * ID + " " + Name
	 * 
	 * @return The ID + name of this Buff.
	 */
	public String toString()
	{
		return String.valueOf(id) + " " + name;
	}

	/**
	 * Returns information about the Buff to the client in a human-readable
	 * format.
	 * 
	 * @return Information about the <code>Buff</code>.
	 */
	public String getInfo()
	{
		String s = "";
		s += "Buff Info:\n";
		s += "ID: " + String.valueOf(id) + "\n";
		s += "Name: " + name + "\n";
		s += "Duration: " + String.valueOf(duration) + "\n";
		s += "Bonus to Melee Hit: " + String.valueOf(bonusToMeleeHit) + "\n";
		s += "Bonus to Dodge: " + String.valueOf(bonusToDodge) + "\n";
		s += "Bonus to Block: " + String.valueOf(bonusToBlock) + "\n";
		s += "Bonus to Cast: " + String.valueOf(bonusToCast) + "\n";
		s += "Bonus to Save: " + String.valueOf(bonusToSave) + "\n";
		s += "Bonus to Resist: " + String.valueOf(bonusToResist) + "\n";
		s += "Bonus to Crit: " + String.valueOf(bonusToCrit) + "\n";
		s += "Damage per Tick: " + String.valueOf(damagePerTick) + "\n";
		s += "Time per Tick: " + String.valueOf(timePerTick);

		return s;
	}

	/**
	 * Creates a specific instance of the <code>Buff</code>.
	 * 
	 * @return A specific instance of this <code>Buff</code>.
	 */
	public Buff createBuff()
	{
		Buff b = new Buff(id, name, bonusToMeleeHit, bonusToDodge,
				bonusToBlock, bonusToCast, bonusToSave, bonusToResist,
				bonusToCrit, damagePerTick, timePerTick, duration, pictureFile);

		b.creationTime = new Date();
		b.expirationTime = new Date(b.creationTime.getTime() + 1000 * duration);
		
		b.uniqueID = "Buff-" + id + "-" + Database.nextID();

		return b;
	}

	/**
	 * @return Returns the bonusToBlock.
	 */
	public int getBonusToBlock()
	{
		return bonusToBlock;
	}

	/**
	 * @return Returns the bonusToCast.
	 */
	public int getBonusToCast()
	{
		return bonusToCast;
	}

	/**
	 * @return Returns the bonusToCrit.
	 */
	public int getBonusToCrit()
	{
		return bonusToCrit;
	}

	/**
	 * @return Returns the bonusToDodge.
	 */
	public int getBonusToDodge()
	{
		return bonusToDodge;
	}

	/**
	 * @return Returns the bonusToMeleeHit.
	 */
	public int getBonusToMeleeHit()
	{
		return bonusToMeleeHit;
	}

	/**
	 * @return Returns the bonusToResist.
	 */
	public int getBonusToResist()
	{
		return bonusToResist;
	}

	/**
	 * @return Returns the bonusToSave.
	 */
	public int getBonusToSave()
	{
		return bonusToSave;
	}

	/**
	 * @return Returns the creationTime.
	 */
	public Date getCreationTime()
	{
		return creationTime;
	}

	/**
	 * @return Returns the damagePerTick.
	 */
	public int getDamagePerTick()
	{
		return damagePerTick;
	}

	/**
	 * @return Returns the duration.
	 */
	public int getDuration()
	{
		return duration;
	}

	/**
	 * @return Returns the expirationTime.
	 */
	public Date getExpirationTime()
	{
		return expirationTime;
	}

	/**
	 * @return Returns the id.
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return Returns the pictureFile.
	 */
	public String getPictureFile()
	{
		return pictureFile;
	}

	/**
	 * @return Returns the timePerTick.
	 */
	public int getTimePerTick()
	{
		return timePerTick;
	}

	/**
	 * @return the uniqueID
	 */
	public String getUniqueID()
	{
		return uniqueID;
	}
}