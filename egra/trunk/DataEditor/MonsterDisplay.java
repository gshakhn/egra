import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MonsterDisplay extends JPanel
{

	public DataEditor de;

	public JTextArea monsterDisplayTA;

	public AbilityDisplay ad;

	public MonsterDisplay(DataEditor de)
	{
		super();

		this.de = de;

		setLayout(new BorderLayout());

		monsterDisplayTA = new JTextArea();
		monsterDisplayTA.setEditable(false);
		add(monsterDisplayTA, BorderLayout.CENTER);
	}

	public void setAbility(Ability a)
	{
		de.abilityInfo.setInfo(a);
	}
}