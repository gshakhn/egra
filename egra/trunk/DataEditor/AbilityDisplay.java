import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AbilityDisplay extends JPanel implements ActionListener
{

	public JTextArea attackInfo;

	public JButton buffInfo;

	public JButton deBuffInfo;

	public BuffButtonDisplay bbd;

	public Ability a;

	public BuffDisplay bd;

	public AbilityDisplay()
	{
		setLayout(new BorderLayout(10, 10));

		attackInfo = new JTextArea(26, 10);
		attackInfo.setEditable(false);
		add(attackInfo, BorderLayout.CENTER);

		bbd = new BuffButtonDisplay();
		bbd.setLayout(new GridLayout(2, 1));
		add(bbd, BorderLayout.WEST);
		buffInfo = new JButton("View Buff Info");
		buffInfo.addActionListener(this);
		bbd.add(buffInfo);
		deBuffInfo = new JButton("View Debuff Info");
		deBuffInfo.addActionListener(this);
		bbd.add(deBuffInfo);
	}

	public void setInfo(Ability a)
	{
		this.a = a;

		attackInfo.setText(a.getInfo());
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == buffInfo)
		{
			BuffDisplay bd = new BuffDisplay(a.helpfulBuff);
			add(bd, BorderLayout.EAST);
		}
		else if (e.getSource() == deBuffInfo)
		{
			BuffDisplay bd = new BuffDisplay(a.deBuff);
			add(bd, BorderLayout.EAST);
		}
		updateUI();
	}

	public class BuffButtonDisplay extends JPanel
	{
		public BuffButtonDisplay()
		{
			setBackground(Color.white);
		}
	}
}