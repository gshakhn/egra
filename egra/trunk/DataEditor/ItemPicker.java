import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ItemPicker extends JPanel implements ActionListener,
		ListSelectionListener
{

	public DataEditor de;

	public JComboBox itemCB;

	public JTextField quantityTF;

	public JList itemList;

	public JList quantityList;

	public JButton addItem;

	public JButton removeItem;

	public JButton done;

	public Vector items;

	public Vector quantities;

	public ItemPicker(DataEditor de)
	{
		this.de = de;

		items = new Vector();
		quantities = new Vector();

		setLayout(new GridLayout(3, 3));

		itemCB = new JComboBox();
		itemCB.setEditable(false);
		itemCB.setEnabled(true);
		itemCB.addActionListener(this);
		add(itemCB);

		quantityTF = new JTextField();
		add(quantityTF);

		addItem = new JButton("Add Item");
		addItem.addActionListener(this);
		add(addItem);

		itemList = new JList(items);
		itemList.addListSelectionListener(this);
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(itemList);

		quantityList = new JList(quantities);
		quantityList.addListSelectionListener(this);
		quantityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(quantityList);

		removeItem = new JButton("Remove Item");
		removeItem.addActionListener(this);
		add(removeItem);

		done = new JButton("Done");
		done.addActionListener(this);
		add(done);
	}

	public void reset()
	{
		items = new Vector();
		quantities = new Vector();
		itemList.setListData(items);
		quantityList.setListData(quantities);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == done)
		{
			setVisible(false);
			de.validate();
		}
		else if (e.getSource() == removeItem && !itemList.isSelectionEmpty())
		{
			int removeNbr = itemList.getSelectedIndex();
			items.remove(removeNbr);
			quantities.remove(removeNbr);
			itemList.setListData(items);
			quantityList.setListData(quantities);
		}
		else if (e.getSource() == addItem && itemCB.getSelectedItem() != null)
		{
			String id = ((Item) (itemCB.getSelectedItem())).id;
			items.add(id);
			quantities.add(new Integer(quantityTF.getText()));
			itemList.setListData(items);
			quantityList.setListData(quantities);
		}
	}

	public void valueChanged(ListSelectionEvent e)
	{
		if (e.getSource() == itemList && !itemList.isSelectionEmpty())
			quantityList.setSelectedIndex(itemList.getSelectedIndex());
		else if (e.getSource() == quantityList
				&& !quantityList.isSelectionEmpty())
			itemList.setSelectedIndex(quantityList.getSelectedIndex());
	}

	public String[] getItems()
	{
		int size = items.size();
		String[] s = new String[size];
		for (int ind = 0; ind < size; ind++)
		{
			s[ind] = (String) (items.get(ind));
		}

		return s;
	}

	public int[] getQuantities()
	{
		int size = quantities.size();
		int[] s = new int[size];
		for (int ind = 0; ind < size; ind++)
		{
			s[ind] = ((Integer) (quantities.get(ind))).intValue();
		}

		return s;
	}
}
