package HomeWork2;
import java.io.File;

public class Task1 {
    public static void main(String[] args)
    {
        File path=new File("c:\\Users\\Владимир\\Desktop");
        ReaderFolder(path);
    }

    static void ReaderFolder(File path){
        try {
            int count=1;
            String msg="Расширение файла: ";
            File []  files= path.listFiles();
            for(File file:files){
                if (file.isFile()) 
                System.out.printf("%d. %s%s\n",count,msg,getExtension(file.getName()));
                count++;
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    static String getExtension(String filename)
    {
        String extension = "";
        int i = filename.lastIndexOf('.');
        if (i >= 0)
        {
            extension = filename.substring(i+1);
        }
        return extension;
    }
}
