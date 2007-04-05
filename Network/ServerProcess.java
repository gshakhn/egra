import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JFrame;

/**
 * Processes everything on server.
 * 
 * @author George Shakhnazaryan
 */
public class ServerProcess extends JFrame implements Runnable
{

	private final int SLEEPTIME = 100;

	private LinkedList<PlayerHandler> clients;

	BufferedReader in;

	BufferedWriter out;

	private ArrayList<WorldCell> cells;

	private final String VERSION = "1.0";

	private final String VERSIONLENGTH = "3";

	private boolean versionChecked = false;

	public ServerProcess()
	{
		new Thread(this).start();
	}

	public void run()
	{
		while (true)
		{
			// Process world cells.
			for (ListIterator i = cells.listIterator(); i.hasNext();)
			{
				WorldCell wc = (WorldCell) (i.next());
				wc.process();
			}

			// Send and recieve info.
			for (ListIterator i = clients.listIterator(); i.hasNext();)
			{
				PlayerHandler ph = (PlayerHandler) (i.next());
				try
				{
					in = new BufferedReader(new InputStreamReader(ph.socket
							.getInputStream()));
					out = new BufferedWriter(new OutputStreamWriter(ph.socket
							.getOutputStream()));

					if (in.ready())
						process(in.readLine(), ph);
					in.close();

					// Send stuff to client if need to.
					String toSendToClient = ph.toSend;
					if (!toSendToClient.equals(""))
					{
						out.write(toSendToClient);
						out.flush();
						out.close();
						ph.toSend = "";
					}
				} catch (IOException ex)
				{
					ph.close();
					i.remove();
				}
			}

			try
			{
				Thread.sleep(SLEEPTIME);
			} catch (InterruptedException ex)
			{
			}
		}
	}

	public void process(String s, PlayerHandler ph)
	{
		String opcode = s.substring(0, OpCodes.OPCODELENGTH);
		String message = s.substring(OpCodes.OPCODELENGTH);
		boolean validMessage = false;
		if (opcode.equals(OpCodes.SENDCHAT))
		{
			int length = Integer.parseInt(message.substring(0, 3));
			String messageToSend = message.substring(3, length + 2);
			ph.player.currentCell.sendChat(ph.player.myName + ": "
					+ messageToSend);
			message = message.substring(length + 3);
			validMessage = true;
		}
		else if (opcode.equals(OpCodes.SENDVERSIONNUMBER))
		{
			ph.toSend += OpCodes.SENDVERSIONNUMBER + VERSIONLENGTH + VERSION;
		}

		if (validMessage && !message.equals(""))
			process(message, ph);
	}

	public void addClient(PlayerHandler s)
	{
		clients.add(s);
	}
}