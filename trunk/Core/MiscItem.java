/**
 * Information about the miscellaneous item.
 * 
 * @author George Shakhnazaryan
 */
public class MiscItem extends Item
{

	public MiscItem(String id, String name, int cost)
	{
		this.name = name;
		this.cost = cost;
		this.id = id;
	}

	/**
	 * This returns an <code>Item</code> that has the same attributes as this
	 * <code>Item</code>, but a generic uniqueID of null.
	 * 
	 * @see Item
	 */
	public Item cloneItem()
	{
		return new MiscItem(id, name, cost);
	}
}