/**
 * A buff to a fighter.
 * 
 * @author George Shakhnazaryan
 */
public class Buff
{

	public String id;

	public String name;

	public int bonusToMeleeHit;

	public int bonusToDodge;

	public int bonusToBlock;

	public int bonusToCast;

	public int bonusToSave;

	public int bonusToResist;

	public int bonusToCrit;

	public long creationTime;

	public int duration;

	public String pictureFile;

	public Buff(String id, String name, int melee, int dodge, int block,
			int cast, int save, int resist, int crit, int duration,
			String pictureFile)
	{
		this.id = id;
		this.name = name;

		creationTime = System.currentTimeMillis();
		this.duration = duration;

		bonusToMeleeHit = melee;
		bonusToDodge = dodge;
		bonusToBlock = block;
		bonusToCast = cast;
		bonusToSave = save;
		bonusToResist = resist;
		bonusToCrit = crit;

		this.pictureFile = pictureFile;
	}

	public String toString()
	{
		return String.valueOf(id) + " " + name;
	}

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
		s += "Bonus to Crit: " + String.valueOf(bonusToCrit);

		return s;
	}
}