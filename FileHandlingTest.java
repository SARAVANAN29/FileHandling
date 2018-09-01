import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandlingTest {

	public static void main(String[] args)throws Exception {
			
	File f=new File("/opt/templates/templates/src/main/java/urjanet/pull/template");  
	String[] filenames=f.list();
        int i =0;
        /*System.out.println(f.getPath());
	    System.out.println(f.list());
	    for(String filename:filenames){  
	       // System.out.println(filename);
	        i++;
		    System.out.println(filename.toString().endsWith(".java"));
		   
	    }  */
	    Path p = Paths.get("/home/saravanants/Documents");
	    Files.list(p);
	    System.out.println(p);
	    
		
	}
}
