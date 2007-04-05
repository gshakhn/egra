import java.net.Socket;

/**
 * Contains reference to the Player and to the Socket of that player.
 * 
 * @author George Shakhnazaryan
 * 
 */
public class PlayerHandler
{

	public Player player;

	public Socket socket;

	public String toSend;

	public PlayerHandler(Player player, Socket socket)
	{
		this.player = player;
		this.socket = socket;

		player.ph = this;
		toSend = "";
	}

	public void close()
	{
	}
}
