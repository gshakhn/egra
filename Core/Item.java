/**
 * A generic object.
 * 
 * @author George Shakhnazaryan
 * 
 */
public abstract class Item
{

	/**
	 * The ID of this <code>Item</code>. Each <code>Item</code> has an ID,
	 * but a specific instance of an <code>Item</code> has its own uniqueID.
	 */
	protected String id;

	/**
	 * The unique ID of a specific instance of an <code>Item</code>. Defaults
	 * to null when an <code>Item</code> is created.
	 */
	protected String uniqueID;

	/**
	 * The name of this <code>Item</code> for the end user.
	 */
	protected String name;

	/**
	 * The cost of this <code>Item</code> in monetary units.
	 */
	protected int cost;

	/**
	 * The type of this item.
	 * 
	 * @see ItemType
	 */
	protected ItemType type;

	/**
	 * Returns a string identifying this Item.
	 * 
	 * Format:
	 * ID + " " + Name
	 * 
	 * @return The ID + name of this Item.
	 */
	public String toString()
	{
		return id + " " + name;
	}

	/**
	 * Creates a specific instance of the <code>Item</code>.
	 * 
	 * @return A specific instance of this <code>Item</code>.
	 */
	public Item createItem()
	{
		Item i = cloneItem();
		i.uniqueID = type + "-" + id + "-" + Database.nextID();
		return i;
	}

	public abstract Item cloneItem();

	public int getCost()
	{
		return cost;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public ItemType getType()
	{
		return type;
	}

	public String getUniqueID()
	{
		return uniqueID;
	}
}
