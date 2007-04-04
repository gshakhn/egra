import java.util.HashMap;
import java.util.Iterator;

public class ItemMap
{
	public HashMap miscItems;

	public HashMap amulets;

	public HashMap boots;

	public HashMap bracers;

	public HashMap chest;

	public HashMap gloves;

	public HashMap goggles;

	public HashMap hats;

	public HashMap meleeWeapons;

	public HashMap pants;

	public HashMap rings;

	public HashMap shields;

	public HashMap shoulders;

	public HashMap socks;

	public HashMap belts;

	public HashMap earrings;

	public static final String miscItemID = "IMIT-";

	public static final String amuletID = "IAMU-";

	public static final String bootsID = "IBOO-";

	public static final String bracersID = "IBRA-";

	public static final String chestID = "ICHE-";

	public static final String glovesID = "IGLO-";

	public static final String gogglesID = "IGOG-";

	public static final String hatID = "IHAT-";

	public static final String meleeWeaponID = "IMWE-";

	public static final String pantsID = "IPAN-";

	public static final String ringID = "IRIN-";

	public static final String shieldID = "ISHI-";

	public static final String shouldersID = "ISHO-";

	public static final String socksID = "ISOC-";

	public static final String beltID = "IBEL-";

	public static final String earringID = "IEAR-";

	public ItemMap()
	{
		miscItems = new HashMap();
		amulets = new HashMap();
		boots = new HashMap();
		bracers = new HashMap();
		chest = new HashMap();
		gloves = new HashMap();
		goggles = new HashMap();
		hats = new HashMap();
		meleeWeapons = new HashMap();
		pants = new HashMap();
		rings = new HashMap();
		shields = new HashMap();
		shoulders = new HashMap();
		socks = new HashMap();
		belts = new HashMap();
		earrings = new HashMap();
	}

	public Item get(String id)
	{
		Item i = null;
		String s = id.substring(0, 4);
		if (s.equals(miscItemID))
			i = (Item) (miscItems.get(id));
		else if (s.equals(amuletID))
			i = (Item) (amulets.get(id));
		else if (s.equals(bootsID))
			i = (Item) (boots.get(id));
		else if (s.equals(bracersID))
			i = (Item) (bracers.get(id));
		else if (s.equals(chestID))
			i = (Item) (chest.get(id));
		else if (s.equals(glovesID))
			i = (Item) (gloves.get(id));
		else if (s.equals(gogglesID))
			i = (Item) (goggles.get(id));
		else if (s.equals(hatID))
			i = (Item) (hats.get(id));
		else if (s.equals(meleeWeaponID))
			i = (Item) (meleeWeapons.get(id));
		else if (s.equals(pantsID))
			i = (Item) (pants.get(id));
		else if (s.equals(ringID))
			i = (Item) (rings.get(id));
		else if (s.equals(shieldID))
			i = (Item) (shields.get(id));
		else if (s.equals(shouldersID))
			i = (Item) (shoulders.get(id));
		else if (s.equals(socksID))
			i = (Item) (socks.get(id));
		else if (s.equals(beltID))
			i = (Item) (belts.get(id));
		else if (s.equals(earringID))
			i = (Item) (earrings.get(id));

		return i;
	}

	public void add(Item i)
	{
		ItemType type = i.type;
		if (type == ItemType.MISC)
			miscItems.put(i.id, i);
		else if (type == ItemType.AMULET)
			amulets.put(i.id, i);
		else if (type == ItemType.BOOTS)
			boots.put(i.id, i);
		else if (type == ItemType.BRACERS)
			bracers.put(i.id, i);
		else if (type == ItemType.CHEST)
			chest.put(i.id, i);
		else if (type == ItemType.GLOVES)
			gloves.put(i.id, i);
		else if (type == ItemType.GOGGLES)
			goggles.put(i.id, i);
		else if (type == ItemType.HAT)
			hats.put(i.id, i);
		else if (type == ItemType.MELEE_WEAPON)
			meleeWeapons.put(i.id, i);
		else if (type == ItemType.PANTS)
			pants.put(i.id, i);
		else if (type == ItemType.RING)
			rings.put(i.id, i);
		else if (type == ItemType.SHIELD)
			shields.put(i.id, i);
		else if (type == ItemType.SHOULDER)
			shoulders.put(i.id, i);
		else if (type == ItemType.SOCKS)
			socks.put(i.id, i);
		else if (type == ItemType.BELT)
			belts.put(i.id, i);
		else if (type == ItemType.EARRING)
			earrings.put(i.id, i);
	}

	public ItemIterator iterator()
	{
		return new ItemIterator();
	}

	public class ItemIterator
	{
		private int type;

		Iterator iterator;

		public ItemIterator()
		{
			type = 0;
			iterator = miscItems.values().iterator();
		}

		public boolean hasNext()
		{
			boolean hn = false;
			if (iterator.hasNext())
				return true;
			else
			{
				while (type <= 16 && !iterator.hasNext())
				{
					type++;
					if (type == 1)
						iterator = amulets.values().iterator();
					else if (type == 2)
						iterator = boots.values().iterator();
					else if (type == 3)
						iterator = bracers.values().iterator();
					else if (type == 4)
						iterator = chest.values().iterator();
					else if (type == 5)
						iterator = gloves.values().iterator();
					else if (type == 6)
						iterator = goggles.values().iterator();
					else if (type == 7)
						iterator = hats.values().iterator();
					else if (type == 8)
						iterator = meleeWeapons.values().iterator();
					else if (type == 9)
						iterator = pants.values().iterator();
					else if (type == 10)
						iterator = rings.values().iterator();
					else if (type == 11)
						iterator = shields.values().iterator();
					else if (type == 12)
						iterator = shoulders.values().iterator();
					else if (type == 13)
						iterator = socks.values().iterator();
					else if (type == 14)
						iterator = belts.values().iterator();
					else if (type == 15)
						iterator = earrings.values().iterator();
				}
			}
			hn = iterator.hasNext();
			return hn;
		}

		public Item next()
		{
			return (Item) (iterator.next());
		}
	}
}