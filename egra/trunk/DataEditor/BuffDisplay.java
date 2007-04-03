import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Displays the buff.
 * 
 * @author Owner
 * 
 */
public class BuffDisplay extends JPanel
{

	public JTextArea buffDisplayTA;

	public BuffDisplay(Buff b)
	{
		super();

		setBackground(Color.white);

		buffDisplayTA = new JTextArea(b.getInfo());
		buffDisplayTA.setEditable(false);
		add(buffDisplayTA);
	}

	public BuffDisplay()
	{
		super();

		setBackground(Color.white);

		buffDisplayTA = new JTextArea();
		buffDisplayTA.setEditable(false);
		add(buffDisplayTA);
	}
}
