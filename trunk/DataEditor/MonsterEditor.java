import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Allows user to edit/create monsters.
 * 
 * @author George Shakhnazaryan
 */
public class MonsterEditor extends JPanel implements ActionListener
{
	private DataEditor de;

	private JLabel idLabel;

	private JLabel idLabel2;

	private JLabel nameLabel;

	private JTextField nameTF;

	private JLabel attackLabel;

	private JButton attackButton;

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

	private JLabel healthLabel;

	private JTextField healthTF;

	private JLabel minDamageLabel;

	private JTextField minDamageTF;

	private JLabel maxDamageLabel;

	private JTextField maxDamageTF;

	private JLabel itemsLabel;

	private JButton itemsButton;

	private JLabel spawnTimeLabel;

	private JTextField spawnTimeTF;

	private JLabel chanceToMoveLabel;

	private JTextField chanceToMoveTF;

	private JLabel timeBetweenMovingLabel;

	private JTextField timeBetweenMovingTF;

	private JLabel pictureLabel;

	private JButton pictureButton;

	private JButton saveMonsterButton;

	private JLabel levelLabel;

	private JTextField levelTF;

	public Ability pickedAbility;

	public File pickedPicture;

	public boolean itemsPicked;

	public Item[] pickedItems;

	public int[] pickedChance;

	public MonsterEditor(DataEditor de)
	{
		super();

		this.de = de;

		setLayout(new GridLayout(21, 2));
		idLabel = new JLabel("ID:");
		add(idLabel);
		idLabel2 = new JLabel("");
		add(idLabel2);
		nameLabel = new JLabel("Name:");
		add(nameLabel);
		nameTF = new JTextField("", 5);
		add(nameTF);
		levelLabel = new JLabel("Level:");
		add(levelLabel);
		levelTF = new JTextField("", 5);
		add(levelTF);
		attackLabel = new JLabel("Attack:");
		add(attackLabel);
		attackButton = new JButton("More...");
		attackButton.addActionListener(this);
		add(attackButton);
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
		healthLabel = new JLabel("Maximum Health:");
		add(healthLabel);
		healthTF = new JTextField("", 5);
		add(healthTF);
		minDamageLabel = new JLabel("Minimum Damage:");
		add(minDamageLabel);
		minDamageTF = new JTextField("", 5);
		add(minDamageTF);
		maxDamageLabel = new JLabel("Maximum Damage:");
		add(maxDamageLabel);
		maxDamageTF = new JTextField("", 5);
		add(maxDamageTF);
		itemsLabel = new JLabel("Items");
		add(itemsLabel);
		itemsButton = new JButton("More...");
		itemsButton.addActionListener(this);
		add(itemsButton);
		spawnTimeLabel = new JLabel("Spawn Time:");
		add(spawnTimeLabel);
		spawnTimeTF = new JTextField("", 5);
		add(spawnTimeTF);
		chanceToMoveLabel = new JLabel("Chance to Move:");
		add(chanceToMoveLabel);
		chanceToMoveTF = new JTextField("", 5);
		add(chanceToMoveTF);
		timeBetweenMovingLabel = new JLabel("Time Between Moving:");
		add(timeBetweenMovingLabel);
		timeBetweenMovingTF = new JTextField("", 5);
		add(timeBetweenMovingTF);
		pictureLabel = new JLabel("Picture:");
		add(pictureLabel);
		pictureButton = new JButton("More...");
		pictureButton.addActionListener(this);
		add(pictureButton);

		saveMonsterButton = new JButton("Save Monster");
		saveMonsterButton.addActionListener(this);
		add(saveMonsterButton);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == attackButton)
		{
			de.attackPicker.setVisible(true);
			de.validate();
		}
		else if (e.getSource() == itemsButton)
		{
			de.itemPicker.setVisible(true);
			de.validate();
		}
		else if (e.getSource() == saveMonsterButton)
			saveMonster();
	}

	public void loadMonster(Monster m)
	{
		idLabel2.setText(String.valueOf(m.id));
		nameTF.setText(m.name);
		meleeHitTF.setText(String.valueOf(m.baseToMeleeHit));
		dodgeTF.setText(String.valueOf(m.baseToDodge));
		blockTF.setText(String.valueOf(m.baseToBlock));
		castTF.setText(String.valueOf(m.baseToCast));
		saveTF.setText(String.valueOf(m.baseToSave));
		resistTF.setText(String.valueOf(m.baseToResist));
		critTF.setText(String.valueOf(m.baseToCrit));
		healthTF.setText(String.valueOf(m.myMaxHealth));
		minDamageTF.setText(String.valueOf(m.minDamage));
		maxDamageTF.setText(String.valueOf(m.maxDamage));
		spawnTimeTF.setText(String.valueOf(m.spawnTime));
		chanceToMoveTF.setText(String.valueOf(m.chanceToMove));
		timeBetweenMovingTF.setText(String.valueOf(m.timeBetweenMoving));
		levelTF.setText(String.valueOf(m.level));

		Ability a = (Ability) (de.abilities.get(m.attack));
		de.attackPicker.attackBox.setSelectedItem(a);

		de.itemPicker.items = new Vector();
		de.itemPicker.quantities = new Vector();
		for (int ind = 0; ind < m.drops.length; ind++)
		{
			de.itemPicker.items.add(m.drops[ind]);
			de.itemPicker.quantities.add(m.chanceToDrop[ind]);
		}
		de.itemPicker.itemList.setListData(de.itemPicker.items);
		de.itemPicker.quantityList.setListData(de.itemPicker.quantities);
	}

	public void reset()
	{
		idLabel2.setText("Monster-" + String.valueOf(de.monsters.size() + 1));
		nameTF.setText("");
		meleeHitTF.setText("");
		dodgeTF.setText("");
		blockTF.setText("");
		castTF.setText("");
		saveTF.setText("");
		resistTF.setText("");
		critTF.setText("");
		healthTF.setText("");
		minDamageTF.setText("");
		maxDamageTF.setText("");
		spawnTimeTF.setText("");
		chanceToMoveTF.setText("");
		timeBetweenMovingTF.setText("");
		levelTF.setText("");
	}

	public void saveMonster()
	{
		Monster m = new Monster(idLabel2.getText(), nameTF.getText(),
				((Ability) (de.attackPicker.attackBox.getSelectedItem())).id,
				Integer.parseInt(minDamageTF.getText()), Integer
						.parseInt(maxDamageTF.getText()), Integer
						.parseInt(meleeHitTF.getText()), Integer
						.parseInt(dodgeTF.getText()), Integer.parseInt(blockTF
						.getText()), Integer.parseInt(castTF.getText()),
				Integer.parseInt(saveTF.getText()), Integer.parseInt(resistTF
						.getText()), Integer.parseInt(critTF.getText()),
				de.itemPicker.getItems(), de.itemPicker.getQuantities(),
				Integer.parseInt(healthTF.getText()), Integer
						.parseInt(chanceToMoveTF.getText()), Integer
						.parseInt(timeBetweenMovingTF.getText()), Integer
						.parseInt(levelTF.getText()), "");

		de.addMonster(m);
	}
}