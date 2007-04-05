/**
 * Database of all weapons, armor, shields.
 * 
 * @author George Shakhnazaryan
 */
public class Database
{
	protected static int uniqueIDCounter;

	private static int NbrTYPES = ItemType.numTypes();

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
		items[ItemType.MISC.num()][0] = new MiscItem("MiscItem-0", "Rock", 1);
	}

	private static void initializeAmulets()
	{
		items[ItemType.AMULET.num()][0] = new Armor("Amulet-0",
				ItemType.AMULET, "None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0,
				0.0);
	}

	private static void initializeBoots()
	{
		items[ItemType.BOOTS.num()][0] = new Armor("Boots-0", ItemType.BOOTS,
				"None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeBracers()
	{
		items[ItemType.BRACERS.num()][0] = new Armor("Bracers-0",
				ItemType.BRACERS, "None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0,
				0.0);
	}

	private static void initializeChest()
	{
		items[ItemType.CHEST.num()][0] = new Armor("Chest-0", ItemType.CHEST,
				"Cloth Shirt", 10, 10, 5, 0, 1, 0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeGloves()
	{
		items[ItemType.GLOVES.num()][0] = new Armor("Gloves-0",
				ItemType.GLOVES, "None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0,
				0.0);
	}

	private static void initializeGoggles()
	{
		items[ItemType.GOGGLES.num()][0] = new Armor("Goggles-0",
				ItemType.GOGGLES, "None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0,
				0.0);
	}

	private static void initializeHats()
	{
		items[ItemType.HAT.num()][0] = new Armor("Hats-0", ItemType.HAT,
				"None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeMeleeWeapons()
	{
		items[ItemType.MELEE_WEAPON.num()][0] = new MeleeWeapon(
				"MeleeWeapon-0", ItemType.MELEE_WEAPON, "Fist", 1, 2, -1, -1,
				5, WeaponHand.EITHER, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0);
	}

	private static void initializePants()
	{
		items[ItemType.PANTS.num()][0] = new Armor("Pants-0", ItemType.PANTS,
				"Cloth Pants", 10, 10, 5, 0, 1, 0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeRings()
	{
		items[ItemType.RING.num()][0] = new Armor("Ring-0", ItemType.RING,
				"None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeShields()
	{
		items[ItemType.SHIELD.num()][0] = new Armor("Shield-0",
				ItemType.SHIELD, "None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0,
				0.0);
	}

	private static void initializeShoulders()
	{
		items[ItemType.SHOULDER.num()][0] = new Armor("Shoulders-0",
				ItemType.SHOULDER, "None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0,
				0.0);
	}

	private static void initializeSocks()
	{
		items[ItemType.SOCKS.num()][0] = new Armor("Socks-0", ItemType.SOCKS,
				"None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeBelts()
	{
		items[ItemType.BELT.num()][0] = new Armor("Belt-0", ItemType.BELT,
				"None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0, 0.0);
	}

	private static void initializeEarrings()
	{
		items[ItemType.EARRING.num()][0] = new Armor("Earring-0",
				ItemType.EARRING, "None", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0.0,
				0.0);
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