import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class AttackPicker extends JPanel implements ActionListener
{

	public DataEditor de;

	public JComboBox attackBox;

	public JButton attackButton;

	AbilityDisplay ad;

	public AttackPicker(DataEditor de)
	{
		super();

		this.de = de;

		setBackground(Color.BLACK);

		setLayout(new BorderLayout());
		add(de.abilityInfo, BorderLayout.CENTER);
		attackBox = new JComboBox();
		attackBox.addActionListener(this);
		attackBox.setEditable(false);
		attackBox.setEnabled(true);
		add(attackBox, BorderLayout.NORTH);
		attackButton = new JButton("Select");
		attackButton.addActionListener(this);
		add(attackButton, BorderLayout.SOUTH);
	}

	public void reset()
	{
		if (ad != null)
		{
			ad.attackInfo.setText("");
		}

	}

	public void actionPerformed(ActionEvent e)
	{
		Ability a = (Ability) (attackBox.getSelectedItem());
		if (a != null)
		{
			if (e.getSource() == attackBox)
				de.abilityInfo.setInfo(a);
			de.validate();
		}
		if (e.getSource() == attackButton)
		{
			setVisible(false);
			de.validate();
		}
	}
}