import java.io.File;

public class FileUtils
{
    public static boolean deleteFiles(File contenTodelete)
    {
        File [] allContents =  contenTodelete.listFiles();
        if(allContents != null)
        {
            for (File file : allContents)
            {
                deleteFiles(file);
            }
        }
        return contenTodelete.delete();
    }
}
