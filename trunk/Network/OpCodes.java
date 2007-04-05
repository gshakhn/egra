/**
 * Stores all opcodes.
 * 
 * @author George Shakhnazaryan
 */
public class OpCodes
{

	/*
	 * Note: Format for message is: (length of message) + message
	 */

	public static final String SENDCHAT = ""; // client sends message to
												// server

	public static final String RECIEVECHAT = ""; // client recieves message
													// from server

	/*
	 * NOTE: supports messages up to 999 characters. Client needs to limit.
	 */
	public static final String MOVE = ""; // client moves

	public static final String ATTACK = ""; // client sends attack

	public static final String AUTHENTICATE = ""; // client attempts to login

	public static final String COMBATTEXT = ""; // client recieves information

	// about attacks done in the WorldCell
	public static final String EQUIP = ""; // client equips something

	public static final String GETITEM = ""; // client picks up item

	public static final String SENDPLAYERINFO = ""; // client recieves info
													// about self

	public static final String SENDOTHERPLAYERINFO = ""; // client recieves
															// info about other

	public static final String BUY = ""; // client buys item

	public static final String SELL = ""; // client sells item

	public static final String WORLDCELLINFO1 = ""; // generic information about
													// cell

	public static final String WORLDCELLINFO2 = ""; // information on what
													// inhabits cell

	public static final String SENDVERSIONNUMBER = ""; // information about the
														// current version of
														// the game

	public static final String VERSIONNUMBERCHECKED = ""; // the versions of
															// client and server
															// match

	public static final int OPCODELENGTH = 4; // length of an opcode
}
