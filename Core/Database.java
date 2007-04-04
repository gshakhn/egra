import java.util.Hashtable;

/**
 * Database of all weapons, armor, shields.
 * 
 * @author George Shakhnazaryan
 */
public class Database
{
	/**
	 * This counter is used to generate uniqueIds for created items.
	 */
	private static int uniqueIDCounter;

	/**
	 * This is a map of all Abilities. The key is the id of the Ability.
	 */
	private static Hashtable<String, Ability> abilities;

	/**
	 * This is a map of all Monsters. The key is the id of the Monster.
	 */
	private static Hashtable<String, Monster> monsters;

	/**
	 * This is a map of all Items. The key is the id of the Item.
	 */
	private static Hashtable<String, Item> items;

	/**
	 * @return The next unique ID.
	 */
	public static int nextID()
	{
		return uniqueIDCounter++;
	}

	/**
	 * @param newID
	 *            The new unique ID.
	 */
	public static void setID(int newID)
	{
		uniqueIDCounter = newID;
	}

	/**
	 * Initializes the database.
	 * 
	 * Note: Currently information is hardcoded.
	 */
	public static void initialize()
	{
		items = new Hashtable<String, Item>();

		abilities = new Hashtable<String, Ability>();;
		monsters = new Hashtable<String, Monster>();;

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
		Item i = new MiscItem("MiscItem-0", "Rock", 1);
		items.put(i.getId(), i);
	}

	private static void initializeAmulets()
	{
		Item i = new Armor("Amulet-0", ItemType.AMULET, "None", -1, -1, 0, 0,
				0, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeBoots()
	{
		Item i = new Armor("Boots-0", ItemType.BOOTS, "None", -1, -1, 0, 0, 0,
				0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeBracers()
	{
		Item i = new Armor("Bracers-0", ItemType.BRACERS, "None", -1, -1, 0, 0,
				0, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeChest()
	{
		Item i = new Armor("Chest-0", ItemType.CHEST, "Cloth Shirt", 10, 10, 5,
				0, 1, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeGloves()
	{
		Item i = new Armor("Gloves-0", ItemType.GLOVES, "None", -1, -1, 0, 0,
				0, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeGoggles()
	{
		Item i = new Armor("Goggles-0", ItemType.GOGGLES, "None", -1, -1, 0, 0,
				0, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeHats()
	{
		Item i = new Armor("Hats-0", ItemType.HAT, "None", -1, -1, 0, 0, 0, 0,
				0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeMeleeWeapons()
	{
		Item i = new MeleeWeapon("MeleeWeapon-0", ItemType.MELEE_WEAPON,
				"Fist", 1, 2, -1, -1, 5, WeaponHand.EITHER, 0, 0, 0, 0, 0, 0,
				0, 0, 0, "", 0);
		items.put(i.getId(), i);
	}

	private static void initializePants()
	{
		Item i = new Armor("Pants-0", ItemType.PANTS, "Cloth Pants", 10, 10, 5,
				0, 1, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeRings()
	{
		Item i = new Armor("Ring-0", ItemType.RING, "None", -1, -1, 0, 0, 0, 0,
				0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeShields()
	{
		Item i = new Armor("Shield-0", ItemType.SHIELD, "None", -1, -1, 0, 0,
				0, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeShoulders()
	{
		Item i = new Armor("Shoulders-0", ItemType.SHOULDER, "None", -1, -1, 0,
				0, 0, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeSocks()
	{
		Item i = new Armor("Socks-0", ItemType.SOCKS, "None", -1, -1, 0, 0, 0,
				0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeBelts()
	{
		Item i = new Armor("Belt-0", ItemType.BELT, "None", -1, -1, 0, 0, 0, 0,
				0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	private static void initializeEarrings()
	{
		Item i = new Armor("Earring-0", ItemType.EARRING, "None", -1, -1, 0, 0,
				0, 0, 0, 0, 0, 0, 0.0, 0.0);
		items.put(i.getId(), i);
	}

	/**
	 * Returns the Item based on the Item's id.
	 * 
	 * @param id
	 *            The id of the Item.
	 * @return The Item.
	 */
	public static Item getItem(String id)
	{
		return items.get(id);
	}

	/**
	 * Returns the Ability based on the Ability's id.
	 * 
	 * @param id
	 *            The id of the Ability.
	 * @return The Ability.
	 */
	public static Ability getAbility(String id)
	{
		return abilities.get(id);
	}

	/**
	 * Returns the Monster based on the Monster's id.
	 * 
	 * @param id
	 *            The id of the Monster.
	 * @return The item.
	 */
	public static Monster getMonster(String id)
	{
		return monsters.get(id);
	}
}