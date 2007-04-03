import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

/**
 * Picks a world cell.
 * 
 * @author George Shakhnazaryan
 */
public class CellPicker extends JPanel implements ActionListener
{

	public DataEditor de;

	public JComboBox cellBox;

	public JTextArea cellInfo;

	public JButton cellButton;

	public MonsterListDisplay mld;

	public JLabel monsterLabel;

	public JScrollPane monsterScroll;

	public JList monsterList;

	public JButton monsterButton;

	public CellPicker(DataEditor de)
	{
		super();

		this.de = de;

		setLayout(new BorderLayout());
		cellBox = new JComboBox();
		cellBox.addActionListener(this);
		cellBox.setEditable(false);
		cellBox.setEnabled(true);
		add(cellBox, BorderLayout.NORTH);
		cellInfo = new JTextArea(2, 10);
		cellInfo.setEditable(false);
		add(cellInfo, BorderLayout.CENTER);
		cellButton = new JButton("Select");
		cellButton.addActionListener(this);
		add(cellButton, BorderLayout.SOUTH);

		mld = new MonsterListDisplay();
		mld.setLayout(new BorderLayout());
		add(mld, BorderLayout.EAST);
		monsterLabel = new JLabel("Monsters in this cell:");
		mld.add(monsterLabel, BorderLayout.NORTH);
		monsterList = new JList();
		monsterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		monsterScroll = new JScrollPane(monsterList);
		mld.add(monsterScroll, BorderLayout.CENTER);
		monsterButton = new JButton("Get Monster Info");
		monsterButton.addActionListener(this);
		mld.add(monsterButton, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		WorldCell wc = (WorldCell) (cellBox.getSelectedItem());
		if (wc != null)
		{
			if (e.getSource() == cellButton)
			{
				setVisible(false);
			}
			else if (e.getSource() == cellBox)
			{
				cellInfo.setText(wc.getInfo());
				Vector v = new Vector();
				for (Iterator i = de.monsters.values().iterator(); i.hasNext();)
					v.add(i.next());
				monsterList.setListData(v);
			}
			else if (e.getSource() == monsterButton)
			{
				Monster m = (Monster) (monsterList.getSelectedValue());
				if (m != null)
				{
					de.monsterInfo.monsterDisplayTA.setText(m.getInfo());
				}
			}
		}
	}

	public class MonsterListDisplay extends JPanel
	{
		public MonsterListDisplay()
		{
			setBackground(Color.white);
		}
	}
}
