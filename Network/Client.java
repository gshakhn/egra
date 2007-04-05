import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JApplet;

/**
 * The client.
 * 
 * @author George Shakhnazaryan
 */

public class Client extends JApplet implements Runnable
{

	private Socket socket;

	private final int PORT = 31415;

	private final String HOST = "www.react-z.com";

	private final String ClientVersion = "1.0";

	private WorldCell currentCell;

	private Player player;

	BufferedReader in;

	BufferedWriter out;

	private final int SLEEPTIME = 100;

	public void init()
	{
		try
		{
			socket = new Socket(HOST, PORT);

			try
			{
				in = new BufferedReader(new InputStreamReader(socket
						.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket
						.getOutputStream()));

				out.write(OpCodes.SENDVERSIONNUMBER);

				boolean versionInfoRecieved = false;

				while (!versionInfoRecieved)
				{
					try
					{
						Thread.sleep(SLEEPTIME);
					} catch (InterruptedException ex)
					{
					}

					String serverVersion = "";
					if (in.ready())
						serverVersion = in.readLine();

					if (!serverVersion.equals("")
							&& (serverVersion
									.substring(0, OpCodes.OPCODELENGTH))
									.equals(OpCodes.SENDVERSIONNUMBER))
					{
						int versionLength = Integer.parseInt(serverVersion
								.substring(OpCodes.OPCODELENGTH,
										OpCodes.OPCODELENGTH + 1));
						serverVersion = serverVersion.substring(
								OpCodes.OPCODELENGTH + 1, OpCodes.OPCODELENGTH
										+ 1 + versionLength);

						if (!serverVersion.equals(ClientVersion))
						{
							outOfDateClient();
							in.close();
							out.close();
							socket.close();
						}
						else
						{
							versionInfoRecieved = true;
						}
					}
				}
			} catch (IOException ex)
			{
				ex.toString();
			}
		} catch (IOException ex)
		{
			ex.toString();
		}
	}

	/**
	 * Message is sent to client to ask them to upgrade. Connections then close.
	 */
	private void outOfDateClient()
	{
		// Calvin and Cult are out of date.
	}

	public void run()
	{

	}
}