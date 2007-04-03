import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Allows user to edit/create buffs.
 * 
 * @author George Shakhnazaryan
 */
public class BuffEditor extends JPanel implements ActionListener
{

	private DataEditor de;

	private JLabel idLabel;

	private JLabel idLabel2;

	private JLabel nameLabel;

	private JTextField nameTF;

	private JLabel meleeHitLabel;

	private JTextField meleeHitTF;

	private JLabel dodgeLabel;

	private JTextField dodgeTF;

	private JLabel blockLabel;

	private JTextField blockTF;

	private JLabel castLabel;

	private JTextField castTF;

	private JLabel saveLabel;

	private JTextField saveTF;

	private JLabel resistLabel;

	private JTextField resistTF;

	private JLabel critLabel;

	private JTextField critTF;

	private JLabel durationLabel;

	private JTextField durationTF;

	private JLabel pictureLabel;

	private JButton pictureButton;

	private JButton saveBuffButton;

	public BuffEditor(DataEditor de)
	{
		super();

		this.de = de;

		setLayout(new GridLayout(12, 2));
		idLabel = new JLabel("ID:");
		add(idLabel);
		idLabel2 = new JLabel("");
		add(idLabel2);
		nameLabel = new JLabel("Name:");
		add(nameLabel);
		nameTF = new JTextField("", 5);
		add(nameTF);
		meleeHitLabel = new JLabel("To Melee Hit:");
		add(meleeHitLabel);
		meleeHitTF = new JTextField("", 5);
		add(meleeHitTF);
		dodgeLabel = new JLabel("To Dodge:");
		add(dodgeLabel);
		dodgeTF = new JTextField("", 5);
		add(dodgeTF);
		blockLabel = new JLabel("To Block:");
		add(blockLabel);
		blockTF = new JTextField("", 5);
		add(blockTF);
		castLabel = new JLabel("To Cast:");
		add(castLabel);
		castTF = new JTextField("", 5);
		add(castTF);
		saveLabel = new JLabel("To Save:");
		add(saveLabel);
		saveTF = new JTextField("", 5);
		add(saveTF);
		resistLabel = new JLabel("To Resist:");
		add(resistLabel);
		resistTF = new JTextField("", 5);
		add(resistTF);
		critLabel = new JLabel("To Crit:");
		add(critLabel);
		critTF = new JTextField("", 5);
		add(critTF);
		durationLabel = new JLabel("Duration:");
		add(durationLabel);
		durationTF = new JTextField("", 5);
		add(durationTF);
		pictureLabel = new JLabel("Picture:");
		add(pictureLabel);
		pictureButton = new JButton("More...");
		pictureButton.addActionListener(this);
		add(pictureButton);

		saveBuffButton = new JButton("Save Buff");
		saveBuffButton.addActionListener(this);
		add(saveBuffButton);
	}

	public void loadBuff(Buff b)
	{
		idLabel2.setText(String.valueOf(b.id));
		nameTF.setText(b.name);
		meleeHitTF.setText(String.valueOf(b.bonusToMeleeHit));
		dodgeTF.setText(String.valueOf(b.bonusToDodge));
		blockTF.setText(String.valueOf(b.bonusToBlock));
		castTF.setText(String.valueOf(b.bonusToCast));
		saveTF.setText(String.valueOf(b.bonusToSave));
		resistTF.setText(String.valueOf(b.bonusToResist));
		critTF.setText(String.valueOf(b.bonusToCrit));
		durationTF.setText(String.valueOf(b.duration));
	}

	public void reset()
	{
		idLabel2.setText("Buff-" + String.valueOf(de.buffs.size() + 1));
		nameTF.setText("");
		meleeHitTF.setText("");
		dodgeTF.setText("");
		blockTF.setText("");
		castTF.setText("");
		saveTF.setText("");
		resistTF.setText("");
		critTF.setText("");
		durationTF.setText("");
	}

	public void saveBuff()
	{
		Buff b = new Buff(idLabel2.getText(), nameTF.getText(), Integer
				.parseInt(meleeHitTF.getText()), Integer.parseInt(dodgeTF
				.getText()), Integer.parseInt(blockTF.getText()), Integer
				.parseInt(castTF.getText()),
				Integer.parseInt(saveTF.getText()), Integer.parseInt(resistTF
						.getText()), Integer.parseInt(critTF.getText()),
				Integer.parseInt(durationTF.getText()), "");

		de.addBuff(b);

		System.out.println(b.getInfo());
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == saveBuffButton)
			saveBuff();
	}
}