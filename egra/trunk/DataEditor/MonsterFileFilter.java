import java.io.File;

public class MonsterFileFilter implements EgraFileFilter
{

	public MonsterFileFilter()
	{

	}

	public boolean accept(File f)
	{
		String s = f.getAbsolutePath();
		int i = s.length();
		if (".aam".equals(s.substring(i - 4)))
			return true;
		return false;
	}

}