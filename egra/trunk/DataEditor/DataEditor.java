import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DataEditor extends JFrame implements ActionListener
{

	public File mainDirectory;

	private static DataEditor dataEditor;

	public MonsterEditor monsterEditor;

	public AttackPicker attackPicker;

	public BuffDisplay buffInfo;

	public AbilityDisplay abilityInfo;

	public CellPicker cellPicker;

	public MonsterDisplay monsterInfo;

	public DataEditorPane dataEditorPane;

	public ItemPicker itemPicker;

	public BuffEditor buffEditor;

	public HashMap monsters;

	public HashMap abilities;

	public HashMap cells;

	public HashMap buffs;

	public ItemMap items;

	private JButton saveButton;

	private JButton loadButton;

	private JComboBox monsterSelect;

	private JButton monsterButton;

	private JComboBox buffSelect;

	private JButton buffButton;

	public static void main(String args[])
	{
		dataEditor = new DataEditor();
	}

	public DataEditor()
	{
		super("Egra Data Editor");

		mainDirectory = new File("data");

		abilities = new HashMap();
		cells = new HashMap();
		monsters = new HashMap();
		buffs = new HashMap();
		items = new ItemMap();

		initializeTestInfo();

		setSize(1200, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));

		dataEditorPane = new DataEditorPane();
		add(dataEditorPane);

		abilityInfo = new AbilityDisplay();
		abilityInfo.setSize(400, 400);
		abilityInfo.setBackground(Color.white);

		monsterEditor = new MonsterEditor(this);
		monsterEditor.setSize(400, 400);
		monsterEditor.setBackground(Color.white);
		monsterEditor.setVisible(false);
		add(monsterEditor);

		buffEditor = new BuffEditor(this);
		buffEditor.setSize(400, 400);
		buffEditor.setBackground(Color.white);
		buffEditor.setVisible(false);
		add(buffEditor);

		attackPicker = new AttackPicker(this);
		attackPicker.setBackground(Color.white);
		attackPicker.setSize(400, 400);
		attackPicker.setVisible(false);
		add(attackPicker);

		cellPicker = new CellPicker(this);

		monsterInfo = new MonsterDisplay(this);
		monsterInfo.setSize(400, 400);
		monsterInfo.setBackground(Color.white);
		monsterInfo.setVisible(false);
		add(monsterInfo);

		itemPicker = new ItemPicker(this);
		itemPicker.setSize(400, 400);
		itemPicker.setBackground(Color.white);
		itemPicker.setVisible(false);
		add(itemPicker);

		initializeAttackPicker();
		initializeCellPicker();
		initializeItemPicker();

		dataEditorPane.setLayout(new GridLayout(3, 2));
		saveButton = new JButton("Save Data");
		saveButton.addActionListener(this);
		dataEditorPane.add(saveButton);
		loadButton = new JButton("Load Data");
		loadButton.addActionListener(this);
		dataEditorPane.add(loadButton);
		monsterSelect = new JComboBox();
		initializeMonsterSelect();
		dataEditorPane.add(monsterSelect);
		monsterButton = new JButton("Edit");
		monsterButton.addActionListener(this);
		dataEditorPane.add(monsterButton);
		buffSelect = new JComboBox();
		initializeBuffSelect();
		dataEditorPane.add(buffSelect);
		buffButton = new JButton("Edit");
		buffButton.addActionListener(this);
		dataEditorPane.add(buffButton);

		setVisible(true);
	}

	public void initializeMonsterSelect()
	{
		monsterSelect.removeAllItems();
		monsterSelect.addItem("Create New Monster");
		for (Iterator i = monsters.values().iterator(); i.hasNext();)
			monsterSelect.addItem(i.next());
	}

	public void initializeBuffSelect()
	{
		buffSelect.removeAllItems();
		buffSelect.addItem("Create New Buff");
		for (Iterator i = buffs.values().iterator(); i.hasNext();)
			buffSelect.addItem(i.next());
	}

	public void initializeTestInfo()
	{
		Buff b = new Buff("Buff-1", "Super Buff", 1, 1, 1, 1, 1, 1, 1, 1, "");
		// buffs.put(b.id,b);
		Ability a = new Ability("Ability-1", "Super Attack", 1, 1, 1, 1, true,
				true, 1., 1, 1, 1, 1, b, 1, 1, 1, 1, b, 1, 1);
		abilities.put(a.id, a);
		Ability a2 = new Ability("Ability-2", "Super Duper Attack", 1, 1, 1, 1,
				true, true, 1., 1, 1, 1, 1, b, 1, 1, 1, 1, b, 1, 1);
		abilities.put(a2.id, a2);
		WorldCell wc = new WorldCell(1, "Some Cell", 0, 0, null, null, null,
				null);
		cells.put(wc.id, wc);
		Item item = new MiscItem(ItemMap.miscItemID + "1", "Rock", 1);
		items.add(item);
		/*
		 * String [] drops = new String[1]; drops [0] = item.id; int [] chance =
		 * new int [1]; chance [0] = 50; Monster m = new
		 * Monster("Monster-1","Super
		 * Creature",a.id,1,1,1,1,1,1,1,1,1,drops,chance,1,1,1,100,"PictureFile");
		 * monsters.put(m.id,m); wc.addCharacter(m);
		 */
	}

	public void initializeAttackPicker()
	{
		attackPicker.attackBox.removeAllItems();
		for (Iterator i = abilities.values().iterator(); i.hasNext();)
			attackPicker.attackBox.addItem(i.next());
	}

	public void initializeItemPicker()
	{
		itemPicker.itemCB.removeAllItems();
		for (ItemMap.ItemIterator i = items.iterator(); i.hasNext();)
			itemPicker.itemCB.addItem(i.next());
		itemPicker.validate();
	}

	public void initializeCellPicker()
	{
		cellPicker.cellBox.removeAllItems();
		for (Iterator i = cells.values().iterator(); i.hasNext();)
			cellPicker.cellBox.addItem(i.next());
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == monsterButton)
		{
			if (monsterSelect.getSelectedIndex() == 0)
			{
				monsterEditor.reset();
				attackPicker.reset();
				itemPicker.reset();
			}
			else if (monsterSelect.getSelectedIndex() > 0)
			{
				Monster m = (Monster) (monsterSelect.getSelectedItem());
				monsterEditor.loadMonster(m);
			}
			monsterEditor.setVisible(true);
		}
		else if (e.getSource() == buffButton)
		{
			if (buffSelect.getSelectedIndex() == 0)
			{
				buffEditor.reset();
			}
			else if (buffSelect.getSelectedIndex() > 0)
			{
				Buff b = (Buff) (buffSelect.getSelectedItem());
				buffEditor.loadBuff(b);
			}
			buffEditor.setVisible(true);
		}
		else if (e.getSource() == saveButton)
			save();
		else if (e.getSource() == loadButton)
			load();
	}

	public void load()
	{
		if (!mainDirectory.exists() || !mainDirectory.isDirectory())
			return;

		loadMonsters(mainDirectory);
		loadBuffs(mainDirectory);

		reset();
	}

	public void loadMonsters(File md)
	{
		monsters = new HashMap();

		File directory = new File(md, "Monsters");
		if (!directory.exists())
			return;

		File[] filesToOpen = directory.listFiles(new MonsterFileFilter());

		try
		{
			for (int ind = 0; ind < filesToOpen.length; ind++)
			{
				BufferedReader fr = new BufferedReader(new FileReader(
						filesToOpen[ind]));
				String id = fr.readLine();
				String name = fr.readLine();
				int level = Integer.parseInt(fr.readLine());
				String attack = fr.readLine();
				int toMeleeHit = Integer.parseInt(fr.readLine());
				int toDodge = Integer.parseInt(fr.readLine());
				int toBlock = Integer.parseInt(fr.readLine());
				int toCast = Integer.parseInt(fr.readLine());
				int toSave = Integer.parseInt(fr.readLine());
				int toResist = Integer.parseInt(fr.readLine());
				int toCrit = Integer.parseInt(fr.readLine());
				int health = Integer.parseInt(fr.readLine());
				int minDamage = Integer.parseInt(fr.readLine());
				int maxDamage = Integer.parseInt(fr.readLine());

				fr.readLine();
				int nbrDrops = 0;
				String[] drops1 = new String[10];
				int[] probDrops1 = new int[10];
				String s;
				boolean moreItems = true;
				do
				{
					s = fr.readLine();
					if (s.equals("}"))
						moreItems = false;
					else
					{
						drops1[nbrDrops] = s;
						probDrops1[nbrDrops] = Integer.parseInt(fr.readLine());
						nbrDrops++;
					}
				} while (moreItems);
				String[] drops2 = new String[nbrDrops];
				int[] probDrops2 = new int[nbrDrops];
				for (int ind2 = 0; ind2 < nbrDrops; ind2++)
				{
					drops2[ind2] = drops1[ind2];
					probDrops2[ind2] = probDrops1[ind2];
				}

				int spawnTime = Integer.parseInt(fr.readLine());
				int chanceToMove = Integer.parseInt(fr.readLine());
				int timeBetweenMoving = Integer.parseInt(fr.readLine());
				String pictureFile = fr.readLine();

				fr.close();

				Monster m = new Monster(id, name, attack, minDamage, maxDamage,
						toMeleeHit, toDodge, toBlock, toCast, toSave, toResist,
						toCrit, drops2, probDrops2, health, chanceToMove,
						timeBetweenMoving, level, pictureFile);

				monsters.put(m.id, m);
			}

		} catch (IOException ioe)
		{
			System.out.println(ioe.toString() + " read Monsters");
		}

		initializeMonsterSelect();
	}

	public void loadBuffs(File md)
	{
		buffs = new HashMap();

		File directory = new File(md, "Buffs");
		if (!directory.exists())
			return;

		File[] filesToOpen = directory.listFiles(new BuffFileFilter());

		try
		{
			for (int ind = 0; ind < filesToOpen.length; ind++)
			{
				BufferedReader fr = new BufferedReader(new FileReader(
						filesToOpen[ind]));
				String id = fr.readLine();
				String name = fr.readLine();
				int toMeleeHit = Integer.parseInt(fr.readLine());
				int toDodge = Integer.parseInt(fr.readLine());
				int toBlock = Integer.parseInt(fr.readLine());
				int toCast = Integer.parseInt(fr.readLine());
				int toSave = Integer.parseInt(fr.readLine());
				int toResist = Integer.parseInt(fr.readLine());
				int toCrit = Integer.parseInt(fr.readLine());
				int duration = Integer.parseInt(fr.readLine());
				String pictureFile = fr.readLine();

				fr.close();

				Buff b = new Buff(id, name, toMeleeHit, toDodge, toBlock,
						toCast, toSave, toResist, toCrit, duration, pictureFile);

				buffs.put(b.id, b);
			}

		} catch (IOException ioe)
		{
			System.out.println(ioe.toString() + " read Buffs");
		}

		initializeBuffSelect();
	}

	public void save()
	{
		if (mainDirectory.exists())
		{
			boolean b = mainDirectory.delete();
			if (!b)
				delete(mainDirectory);
		}
		mainDirectory.mkdir();

		saveMonsters(mainDirectory);
		saveBuffs(mainDirectory);

		reset();
	}

	public void saveMonsters(File md)
	{
		File directory = new File(md, "Monsters");
		directory.mkdir();

		for (Iterator i = monsters.values().iterator(); i.hasNext();)
		{
			Monster m = (Monster) (i.next());
			String name = m.id;
			File f = new File(directory, name + ".egram");

			try
			{
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write(m.id + "\n");
				fw.write(m.name + "\n");
				fw.write(String.valueOf(m.level) + "\n");
				fw.write(m.attack + "\n");
				fw.write(String.valueOf(m.baseToMeleeHit) + "\n");
				fw.write(String.valueOf(m.baseToDodge) + "\n");
				fw.write(String.valueOf(m.baseToBlock) + "\n");
				fw.write(String.valueOf(m.baseToCast) + "\n");
				fw.write(String.valueOf(m.baseToSave) + "\n");
				fw.write(String.valueOf(m.baseToResist) + "\n");
				fw.write(String.valueOf(m.baseToCrit) + "\n");
				fw.write(String.valueOf(m.myMaxHealth) + "\n");
				fw.write(String.valueOf(m.minDamage) + "\n");
				fw.write(String.valueOf(m.maxDamage) + "\n");
				fw.write("{\n");
				for (int ind = 0; ind < m.drops.length; ind++)
				{
					fw.write((m.drops[ind]) + "\n");
					fw.write(String.valueOf(m.chanceToDrop[ind]) + "\n");
				}
				fw.write("}\n");
				fw.write(String.valueOf(m.spawnTime) + "\n");
				fw.write(String.valueOf(m.chanceToMove) + "\n");
				fw.write(String.valueOf(m.timeBetweenMoving) + "\n");
				fw.write(m.pictureFile);
				fw.close();
			} catch (IOException ie)
			{
				System.out.println(ie.toString() + " write Monsters.");
			}
		}
	}

	public void saveBuffs(File md)
	{
		File directory = new File(md, "Buffs");
		directory.mkdir();

		for (Iterator i = buffs.values().iterator(); i.hasNext();)
		{
			Buff b = (Buff) (i.next());
			String name = b.id;
			File f = new File(directory, name + ".egrab");

			try
			{
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write(b.id + "\n");
				fw.write(b.name + "\n");
				fw.write(String.valueOf(b.bonusToMeleeHit) + "\n");
				fw.write(String.valueOf(b.bonusToDodge) + "\n");
				fw.write(String.valueOf(b.bonusToBlock) + "\n");
				fw.write(String.valueOf(b.bonusToCast) + "\n");
				fw.write(String.valueOf(b.bonusToSave) + "\n");
				fw.write(String.valueOf(b.bonusToResist) + "\n");
				fw.write(String.valueOf(b.bonusToCrit) + "\n");
				fw.write(String.valueOf(b.duration) + "\n");
				fw.write(b.pictureFile);
				fw.close();
			} catch (IOException ie)
			{
				System.out.println(ie.toString() + " write Buff.");
			}
		}
	}

	public void delete(File f)
	{
		if (f.getAbsolutePath().equals(
				mainDirectory.getAbsolutePath() + "Graphics"))
			return;
		if (f.isFile())
			f.delete();
		if (f.isDirectory())
		{
			boolean b = f.delete();
			if (!b)
			{
				String[] filesToDelete = f.list();
				for (int ind = 0; ind < filesToDelete.length; ind++)
					delete(new File(f, filesToDelete[ind]));
			}
			f.delete();
		}
	}

	public void addMonster(Monster m)
	{
		monsters.put(m.id, m);
		reset();
	}

	public void addBuff(Buff b)
	{
		buffs.put(b.id, b);
		reset();
	}

	public void reset()
	{
		monsterEditor.setVisible(false);
		itemPicker.setVisible(false);
		attackPicker.setVisible(false);
		buffEditor.setVisible(false);

		monsterEditor.reset();
		itemPicker.reset();
		attackPicker.reset();
		buffEditor.reset();

		initializeAttackPicker();
		initializeCellPicker();
		initializeItemPicker();
		initializeMonsterSelect();
		initializeBuffSelect();
	}

	public class DataEditorPane extends JPanel
	{
		public DataEditorPane()
		{
			setBackground(Color.white);
			setSize(500, 500);
		}
	}
}