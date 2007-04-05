/**
 * The type of Item. The types can be: MISC, AMULET, BOOTS, BRACERS, CHEST,
 * GLOVES, GOGGLES, HAT, MELEE_WEAPON, PANTS, RING, SHIELD, SHOULDER, SOCKS,
 * BELT, EARRING;}
 */

public enum ItemType {
	MISC(0), AMULET(1), BOOTS(2), BRACERS(3), CHEST(4), GLOVES(5), GOGGLES(6), HAT(
			7), MELEE_WEAPON(8), PANTS(9), RING(10), SHIELD(11), SHOULDER(12), SOCKS(
			13), BELT(14), EARRING(15);

	private final int num;

	private static final int numTypes = 16;

	ItemType(int num)
	{
		this.num = num;
	}

	public int num()
	{
		return num;
	}

	public static int numTypes()
	{
		return numTypes;
	}
}