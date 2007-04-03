import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Allows user to edit/create abilities.
 * 
 * @author George Shakhnazaryan
 */

public class AbilityEditor extends JPanel implements ActionListener
{

	private DataEditor de;

	private JLabel idLabel;

	private JLabel idLabel2;

	private JLabel nameLabel;

	private JTextField nameTF;

	private JLabel manaCostLabel;

	private JTextField manaCostTF;

	private JLabel energyCostLabel;

	private JTextField energyCostTF;

	private JLabel timeBeforeLabel;

	private JTextField timeBeforeTF;

	private JLabel timeAfterLabel;

	private JTextField timeAfterTF;

	private JLabel spellLabel;

	private JComboBox spellCB;

	private JLabel healLabel;

	private JComboBox healCB;

	private JLabel weaponMultiplierLabel;

	private JTextField weaponMultiplierTF;

	private JLabel damageLabel;

	private JTextField damageTF;

	private JLabel temporaryBoostToMeleeHitLabel;

	private JTextField temporaryBoostToMeleeHitTF;

	private JLabel temporaryBoostToBlockLabel;

	private JTextField temporaryBoostToBlockTF;

	private JLabel temporaryBoostToDodgeLabel;

	private JTextField temporaryBoostToDodgeTF;

	private JLabel temporaryBoostToCastLabel;

	private JTextField temporaryBoostToCastTF;

	private JLabel temporaryBoostToSaveLabel;

	private JTextField temporaryBoostToSaveTF;

	private JLabel temporaryBoostToResistLabel;

	private JTextField temporaryBoostToResistTF;

	private JLabel temporaryBoostToCritLabel;

	private JTextField temporaryBoostToCritTF;

	private JLabel temporaryDamageToMeleeHitLabel;

	private JTextField temporaryDamageToMeleeHitTF;

	private JLabel temporaryDamageToBlockLabel;

	private JTextField temporaryDamageToBlockTF;

	private JLabel temporaryDamageToDodgeLabel;

	private JTextField temporaryDamageToDodgeTF;

	private JLabel temporaryDamageToCastLabel;

	private JTextField temporaryDamageToCastTF;

	private JLabel temporaryDamageToSaveLabel;

	private JTextField temporaryDamageToSaveTF;

	private JLabel temporaryDamageToResistLabel;

	private JTextField temporaryDamageToResistTF;

	private JLabel temporaryDamageToCritLabel;

	private JTextField temporaryDamageToCritTF;

	private JLabel XPCostLabel;

	private JTextField XPCostTF;

	private JLabel goldCostLabel;

	private JTextField goldCostTF;

	private JButton saveAbilityButton;

	public Buff helpfulBuff;

	public Buff deBuff;

	public AbilityEditor(DataEditor de)
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
		manaCostLabel = new JLabel("Mana Cost:");
		add(manaCostLabel);
		manaCostTF = new JTextField("", 5);
		add(manaCostTF);
		energyCostLabel = new JLabel("Energy Cost:");
		add(energyCostLabel);
		energyCostTF = new JTextField("", 5);
		add(energyCostTF);
		timeBeforeLabel = new JLabel("Time Before:");
		add(timeBeforeLabel);
		timeBeforeTF = new JTextField("", 5);
		add(timeBeforeTF);
		timeAfterLabel = new JLabel("Time After:");
		add(timeAfterLabel);
		timeAfterTF = new JTextField("", 5);
		add(timeAfterTF);
		spellLabel = new JLabel("Spell?");
		add(spellLabel);
		spellCB = new JComboBox();
		spellCB.addItem(new Boolean(true));
		spellCB.addItem(new Boolean(false));
		add(spellCB);
		healLabel = new JLabel("Heal?");
		add(healLabel);
		healCB = new JComboBox();
		healCB.addItem(new Boolean(true));
		healCB.addItem(new Boolean(false));
		add(healCB);
		weaponMultiplierLabel = new JLabel("Weapon Multiplier:");
		add(weaponMultiplierLabel);
		weaponMultiplierTF = new JTextField("", 5);
		add(weaponMultiplierTF);
		damageLabel = new JLabel("Damage:");
		add(damageLabel);
		damageTF = new JTextField("", 5);
		add(damageTF);
		temporaryBoostToMeleeHitLabel = new JLabel("Temp Boost to Melee:");
		add(temporaryBoostToMeleeHitLabel);
		temporaryBoostToMeleeHitTF = new JTextField("", 5);
		add(temporaryBoostToMeleeHitTF);
		temporaryBoostToBlockLabel = new JLabel("Temp Boost to Block:");
		add(temporaryBoostToBlockLabel);
		temporaryBoostToBlockTF = new JTextField("", 5);
		add(temporaryBoostToBlockTF);
		temporaryBoostToDodgeLabel = new JLabel("Temp Boost to Dodge:");
		add(temporaryBoostToDodgeLabel);
		temporaryBoostToDodgeTF = new JTextField("", 5);
		add(temporaryBoostToDodgeTF);
		temporaryBoostToCastLabel = new JLabel("Temp Boost to Cast:");
		add(temporaryBoostToCastLabel);
		temporaryBoostToCastTF = new JTextField("", 5);
		add(temporaryBoostToCastTF);
		temporaryBoostToSaveLabel = new JLabel("Temp Boost to Save:");
		add(temporaryBoostToSaveLabel);
		temporaryBoostToSaveTF = new JTextField("", 5);
		add(temporaryBoostToSaveTF);
		temporaryBoostToResistLabel = new JLabel("Temp Boost to Resist:");
		add(temporaryBoostToResistLabel);
		temporaryBoostToResistTF = new JTextField("", 5);
		add(temporaryBoostToResistTF);
		temporaryBoostToCritLabel = new JLabel("Temp Boost to Crit:");
		add(temporaryBoostToCritLabel);
		temporaryBoostToCritTF = new JTextField("", 5);
		add(temporaryBoostToCritTF);
		temporaryDamageToMeleeHitLabel = new JLabel("Temp Damage to Melee:");
		add(temporaryDamageToMeleeHitLabel);
		temporaryDamageToMeleeHitTF = new JTextField("", 5);
		add(temporaryDamageToMeleeHitTF);
		temporaryDamageToBlockLabel = new JLabel("Temp Damage to Block:");
		add(temporaryDamageToBlockLabel);
		temporaryDamageToBlockTF = new JTextField("", 5);
		add(temporaryDamageToBlockTF);
		temporaryDamageToDodgeLabel = new JLabel("Temp Damage to Dodge:");
		add(temporaryDamageToDodgeLabel);
		temporaryDamageToDodgeTF = new JTextField("", 5);
		add(temporaryDamageToDodgeTF);
		temporaryDamageToCastLabel = new JLabel("Temp Damage to Cast:");
		add(temporaryDamageToCastLabel);
		temporaryDamageToCastTF = new JTextField("", 5);
		add(temporaryDamageToCastTF);
		temporaryDamageToSaveLabel = new JLabel("Temp Damage to Save:");
		add(temporaryDamageToSaveLabel);
		temporaryDamageToSaveTF = new JTextField("", 5);
		add(temporaryDamageToSaveTF);
		temporaryDamageToResistLabel = new JLabel("Temp Damage to Resist:");
		add(temporaryDamageToResistLabel);
		temporaryDamageToResistTF = new JTextField("", 5);
		add(temporaryDamageToResistTF);
		temporaryDamageToCritLabel = new JLabel("Temp Damage to Crit:");
		add(temporaryDamageToCritLabel);
		temporaryDamageToCritTF = new JTextField("", 5);
		add(temporaryDamageToCritTF);
		XPCostLabel = new JLabel("XP Cost:");
		add(XPCostLabel);
		XPCostTF = new JTextField("", 5);
		add(XPCostTF);
		goldCostLabel = new JLabel("Gold Cost:");
		add(goldCostLabel);
		goldCostTF = new JTextField("", 5);
		add(goldCostTF);
	}

	public void actionPerformed(ActionEvent e)
	{
	}
}
