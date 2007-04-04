/**
 * The player class that is stored in memory on the server.
 * 
 * @author George Shakhnazaryan
 */
public class Player extends Fighter
{
	public String myName;

	public int myClass;

	public int myXP;

	public int myNeededXP;

	public int myLevel;

	public int myGold;

	public EquippableItem[] myEquippedItems;

	public int[] myAbilities;

	public int nbrAbilities;

	public int[] myItems;

	public int nbrItems;

	public WorldCell currentLocation;

	public boolean inCombat;

	public String password;

	public PlayerHandler ph;

	public int myMaxMana;

	public int myMaxEnergy;

	public int myCurrentMana;

	public int myCurrentEnergy;

	private static final int NbrEQUIPMENTSLOTS = 14;

	/*
	 * Stat Order
	 * 
	 * Health Mana ToMeleeHit ToBlock ToDodge ToCast ToSave ToResist ToCrit
	 */
	private final int[] fighterStats = { 100, 0, 50, 25, 50, 200, 50, 75, 50 };

	private final int[] wizardStats = { 75, 100, 100, 50, 50, 75, 50, 25, 50 };

	/**
	 * Creates the player on the server. Either through create a new player, or
	 * from loading it from database. Player will be held in memory until
	 * logoff.
	 * 
	 * @param name
	 *            The name of the player.
	 * @param playerClass
	 *            The class of the player. 1 = Fighter 2 = Wizard
	 */
	public Player(String name, int playerClass)
	{
		super();

		myName = name.toString();

		myClass = playerClass;

		myEquippedItems = new EquippableItem[NbrEQUIPMENTSLOTS];
		/*
		 * for (int ind = 0; ind < NbrEQUIPMENTSLOTS; ind++)
		 * myEquippedItems[ind] = (EquippableItem) (Database.getItem(ind + 1,
		 * 0));
		 */

		switch (myClass)
		{
			case 1:
				myMaxHealth = fighterStats[0];
				myMaxMana = fighterStats[1];
				baseToMeleeHit = fighterStats[2];
				baseToDodge = fighterStats[3];
				baseToBlock = fighterStats[4];
				baseToCast = fighterStats[5];
				baseToSave = fighterStats[6];
				baseToResist = fighterStats[7];
				baseToCrit = fighterStats[8];
				break;
			case 2:
				myMaxHealth = wizardStats[0];
				myMaxMana = wizardStats[1];
				baseToMeleeHit = wizardStats[2];
				baseToDodge = wizardStats[3];
				baseToBlock = wizardStats[4];
				baseToCast = wizardStats[5];
				baseToSave = wizardStats[6];
				baseToResist = wizardStats[7];
				baseToCrit = wizardStats[8];
				break;
		}

		myCurrentHealth = myMaxHealth;
		myCurrentMana = myMaxMana;
		myCurrentEnergy = myMaxEnergy;
	}

	public void process()
	{
		processBuffs();
	}

	public void regen()
	{
		myCurrentHealth += (int) ((double) myMaxHealth * 0.1);
		myCurrentMana += (int) ((double) myMaxMana * 0.1);
		myCurrentEnergy += (int) ((double) myMaxEnergy * 0.1);
	}

	/**
	 * Calculates the total stats each time equipment is changed, level, etc.
	 * 
	 */
	public void addStats()
	{
		minDamage = 0;
		minDamage = ((MeleeWeapon) (myEquippedItems[7])).getMinDamage();
		if (myEquippedItems[10] instanceof MeleeWeapon)
			minDamage += ((MeleeWeapon) (myEquippedItems[10])).getMinDamage();
		maxDamage = 0;
		maxDamage = ((MeleeWeapon) (myEquippedItems[7])).getMaxDamage();
		if (myEquippedItems[10] instanceof MeleeWeapon)
			maxDamage += ((MeleeWeapon) (myEquippedItems[10])).getMaxDamage();

		meleeBoost = 0.0;
		spellBoost = 0.0;

		processBuffs();

		for (int ind = 0; ind < NbrEQUIPMENTSLOTS; ind++)
		{
			meleeBoost += (myEquippedItems[ind]).boostMeleeDamage;
			spellBoost += (myEquippedItems[ind]).boostSpellDamage;

			totalToMeleeHit += (myEquippedItems[ind]).boostToMeleeHit;
			totalToDodge += (myEquippedItems[ind]).boostToDodge;
			totalToBlock += (myEquippedItems[ind]).boostToBlock;
			totalToCast += (myEquippedItems[ind]).boostToCast;
			totalToSave += (myEquippedItems[ind]).boostToSave;
			totalToResist += (myEquippedItems[ind]).boostToResist;
			totalToCrit += (myEquippedItems[ind]).boostToCrit;
		}

	}

	public String getInfo()
	{
		String s = new String();
		s += "Name: " + myName;
		s += "/n" + "Class: " + myClass;
		s += "/n" + "Health: " + String.valueOf(myMaxHealth);
		s += "/n" + "Mana: " + String.valueOf(myMaxMana);
		s += "/n" + "Gold: " + String.valueOf(myGold);
		s += "/n" + "Level: " + String.valueOf(myLevel);
		s += "/n" + "Experience: " + String.valueOf(myXP);
		s += "/n" + "Experience to Level: " + String.valueOf(myNeededXP);
		s += "/n" + "To Melee Hit: " + String.valueOf(baseToMeleeHit) + " ("
				+ String.valueOf(totalToMeleeHit) + ")";
		s += "/n" + "To Dodge: " + String.valueOf(baseToDodge) + " ("
				+ String.valueOf(totalToDodge) + ")";
		s += "/n" + "To Block: " + String.valueOf(baseToBlock) + " ("
				+ String.valueOf(totalToBlock) + ")";
		s += "/n" + "To Cast: " + String.valueOf(baseToCast) + " ("
				+ String.valueOf(totalToCast) + ")";
		s += "/n" + "To Save: " + String.valueOf(baseToSave) + " ("
				+ String.valueOf(totalToSave) + ")";
		s += "/n" + "To Resist: " + String.valueOf(baseToResist) + " ("
				+ String.valueOf(totalToResist) + ")";
		s += "/n" + "To Crit: " + String.valueOf(baseToCrit) + " ("
				+ String.valueOf(totalToCrit) + ")";
		return s;
	}
}