import java.io.File;
import java.io.FileFilter;

public interface EgraFileFilter extends FileFilter
{

	public boolean accept(File f);
}