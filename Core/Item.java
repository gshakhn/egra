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
	 * to null when an <code>Item</code> is created with the constructor.
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
	 * Format: ID + " " + Name
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

	/**
	 * This returns an <code>Item</code> that has the same attributes as this
	 * <code>Item</code>, but a generic uniqueID of null.
	 * 
	 * @see Item
	 */
	public abstract Item cloneItem();

	/**
	 * @return the cost
	 */
	public int getCost()
	{
		return cost;
	}

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the type
	 */
	public ItemType getType()
	{
		return type;
	}

	/**
	 * @return the uniqueID
	 */
	public String getUniqueID()
	{
		return uniqueID;
	}

}