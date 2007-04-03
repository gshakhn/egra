import java.io.File;

public class BuffFileFilter implements EgraFileFilter
{

	public BuffFileFilter()
	{

	}

	public boolean accept(File f)
	{
		String s = f.getAbsolutePath();
		int i = s.length();
		if (".aab".equals(s.substring(i - 4)))
			return true;
		return false;
	}

}