/**
 * Information about an attack.
 * 
 * @author George Shakhnazaryan
 */
public class Attack
{

	public Fighter attacker;

	public Fighter defender;

	public Ability abilityUsed;

	public Attack(Fighter a, Fighter d, Ability abilityU)
	{
		attacker = a;
		defender = d;
		abilityUsed = abilityU;
	}

	/**
	 * TODO!
	 * 
	 * @return The string that will be sent to the client.
	 */
	public String process()
	{
		return null;
	}
}
