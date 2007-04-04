import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * A cell in the world
 * 
 * @author George Shakhnazaryan
 */
public class WorldCell
{

	public int id;

	public String name;

	public int x;

	public int y;

	public LinkedList<Fighter> characters;

	public WorldCell[] directions;

	public int nbrDirections;

	public ArrayList<Attack> attacksToProcess;

	public int ctrCharacters;

	public WorldCell(int id, String name, int x, int y, WorldCell n,
			WorldCell s, WorldCell w, WorldCell e)
	{
		this.id = id;
		this.name = name;

		this.x = x;
		this.y = y;

		directions = new WorldCell[4];
		directions[0] = n;
		directions[1] = e;
		directions[2] = s;
		directions[3] = w;

		characters = new LinkedList<Fighter>();
	}

	public void addCharacter(Fighter f)
	{
		characters.add(f);
		if (f instanceof Player)
			ctrCharacters++;
	}

	public void removeCharacter(Fighter f)
	{
		characters.remove(f);
		if (f instanceof Player)
			ctrCharacters--;
	}

	public void addAttack(Attack a)
	{
		attacksToProcess.add(a);
	}

	public void process()
	{
		long currentTime = System.currentTimeMillis();
		for (ListIterator<Fighter> i = characters.listIterator(); i.hasNext();)
		{
			Fighter f = (Fighter) (i.next());
			if (f instanceof Monster)
			{
				Monster m = (Monster) (f);
				if (!m.isAlive()
						&& (m.getDeathTime().getTime() - m.getCreationTime()
								.getTime()) >= m.getSpawnTime())
				{
					i.set(m.createMonster(this));
				}
			}

			f.process();
		}

		for (Iterator i = attacksToProcess.iterator(); i.hasNext();)
		{
			sendAttack(((Attack) (i.next())).process());
			i.remove();
		}
	}

	public void sendChat(String s)
	{
		int length = s.length();
		String message = OpCodes.SENDCHAT + String.valueOf(length) + s;

		for (ListIterator i = characters.listIterator(); i.hasNext();)
		{
			Fighter f = (Fighter) (i.next());
			if (f instanceof Player)
				((Player) (f)).ph.toSend += message;
		}
	}

	public void sendAttack(String s)
	{
		int length = s.length();
		String message = OpCodes.COMBATTEXT + String.valueOf(length) + s;

		for (ListIterator i = characters.listIterator(); i.hasNext();)
		{
			Fighter f = (Fighter) (i.next());
			if (f instanceof Player)
				((Player) (f)).ph.toSend += message;
		}
	}

	public String toString()
	{
		return String.valueOf(id) + " " + name + " (" + String.valueOf(x) + ","
				+ String.valueOf(y) + ")";
	}

	public String getInfo()
	{
		String s = "";
		s += "This Cell: " + toString() + "\n";
		s += "North Cell: ";
		if (directions[0] != null)
			s += (directions[0]).toString();
		s += "\n";
		s += "East Cell: ";
		if (directions[0] != null)
			s += (directions[0]).toString();
		s += "\n";
		s += "South Cell: ";
		if (directions[0] != null)
			s += (directions[0]).toString();
		s += "\n";
		s += "West Cell: ";
		if (directions[0] != null)
			s += (directions[0]).toString();
		s += "\n";
		s += "Number of Monsters: " + String.valueOf(characters.size());

		return s;
	}
}