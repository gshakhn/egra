/**
 * Database of all weapons, armor, shields.
 * 
 * @author George Shakhnazaryan
 */
public class Database
{
	protected static int uniqueIDCounter;

	private static int NbrTYPES = 16;

	private final static int NbrMAX = 1;

	private static Ability[] abilities;

	private final static int NbrABILITIES = 0;

	private static Monster[] monsters;

	private final static int NbrMONSTERS = 0;

	private static Item[][] items;

	public static int nextID()
	{
		return uniqueIDCounter++;
	}

	public static void setID(int newID)
	{
		uniqueIDCounter = newID;
	}

	public static void initialize()
	{
		items = new Item[NbrTYPES][NbrMAX];

		for (int row = 0; row < NbrTYPES; row++)
			for (int col = 0; col < NbrMAX; col++)
				items[row][col] = null;

		abilities = new Ability[NbrABILITIES];
		monsters = new Monster[NbrMONSTERS];

		initializeMiscItems();
		initializeAmulets();
		initializeBoots();
		initializeBracers();
		initializeChest();
		initializeGloves();
		initializeGoggles();
		initializeHats();
		initializeMeleeWeapons();
		initializePants();
		initializeRings();
		initializeShields();
		initializeShoulders();
		initializeSocks();
		initializeBelts();
		initializeEarrings();
	}

	private static void initializeMiscItems()
	{
		items[0][0] = new MiscItem("MiscItem-0", "Rock", 1);
	}

	private static void initializeAmulets()
	{
		items[1][0] = new Armor("Amulet-0", 1, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeBoots()
	{
		items[2][0] = new Armor("Boots-0", 2, "None", -1, -1, 0, 0, 0, 0, 0, 0,
				0, 0, 0.0, 0.0);
	}

	private static void initializeBracers()
	{
		items[3][0] = new Armor("Bracers-0", 3, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeChest()
	{
		items[4][0] = new Armor("Chest-0", 4, "Cloth Shirt", 10, 10, 5, 0, 1,
				0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeGloves()
	{
		items[5][0] = new Armor("Gloves-0", 5, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeGoggles()
	{
		items[6][0] = new Armor("Goggles-0", 6, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeHats()
	{
		items[7][0] = new Armor("Hats-0", 7, "None", -1, -1, 0, 0, 0, 0, 0, 0,
				0, 0, 0.0, 0.0);
	}

	private static void initializeMeleeWeapons()
	{
		items[8][0] = new MeleeWeapon("MeleeWeapon-0", 8, "Fist", 1, 2, -1, -1,
				5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0);
	}

	private static void initializePants()
	{
		items[9][0] = new Armor("Pants-0", 9, "Cloth Pants", 10, 10, 5, 0, 1,
				0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeRings()
	{
		items[10][0] = new Armor("Ring-0", 10, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeShields()
	{
		items[11][0] = new Armor("Shield-0", 11, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeShoulders()
	{
		items[12][0] = new Armor("Shoulders-0", 12, "None", -1, -1, 0, 0, 0, 0,
				0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeSocks()
	{
		items[13][0] = new Armor("Socks-0", 13, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeBelts()
	{
		items[14][0] = new Armor("Belt-0", 14, "None", -1, -1, 0, 0, 0, 0, 0,
				0, 0, 0, 0.0, 0.0);
	}

	private static void initializeEarrings()
	{
		items[15][0] = new Armor("Earring-0", 15, "None", -1, -1, 0, 0, 0, 0,
				0, 0, 0, 0, 0.0, 0.0);
	}

	public static Item getItem(int type, int i)
	{
		return items[type][i];
	}

	public static Item getMiscItem(int i)
	{
		return items[0][i];
	}

	public static Item getAmulet(int i)
	{
		return items[1][i];
	}

	public static Item getBoots(int i)
	{
		return items[2][i];
	}

	public static Item getBracers(int i)
	{
		return items[3][i];
	}

	public static Item getChest(int i)
	{
		return items[4][i];
	}

	public static Item getGloves(int i)
	{
		return items[5][i];
	}

	public static Item getGoggles(int i)
	{
		return items[6][i];
	}

	public static Item getHat(int i)
	{
		return items[7][i];
	}

	public static Item getMeleeWeapon(int i)
	{
		return items[8][i];
	}

	public static Item getPants(int i)
	{
		return items[9][i];
	}

	public static Item getRing(int i)
	{
		return items[10][i];
	}

	public static Item getShield(int i)
	{
		return items[11][i];
	}

	public static Item getShoulders(int i)
	{
		return items[12][i];
	}

	public static Item getSocks(int i)
	{
		return items[13][i];
	}

	public static Item getBelt(int i)
	{
		return items[14][i];
	}

	public static Item getEarring(int i)
	{
		return items[15][i];
	}

	public static Ability getAbility(int i)
	{
		return abilities[i];
	}

	public static Monster getMonster(int i)
	{
		return monsters[i];
	}
}