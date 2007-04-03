import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Initializes all data. Waits for connection with clients and passes on to
 * ServerProcess.
 * 
 * @author George Shakhnazaryan
 */

public class ServerConnect implements Runnable
{

	private static final int PORT = 31415;

	private static ServerProcess sp;

	public static void main(String[] args)
	{
		Database.setID(Integer.parseInt((args[0])));
		sp = new ServerProcess();
		new ServerConnect();
	}

	public ServerConnect()
	{
		new Thread(this).start();
	}

	public void run()
	{
		try
		{
			ServerSocket server = new ServerSocket(PORT);
			while (true)
			{
				Socket client = server.accept();
				PlayerHandler ph = new PlayerHandler(null, client);
				sp.addClient(ph);
			}
		} catch (IOException ex)
		{
			System.out.println(ex.toString());
		}
	}
}
