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

	public Item cloneItem()
	{
		return new MiscItem(id, name, cost);
	}
}