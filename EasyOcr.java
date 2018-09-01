import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class EasyOcr {

	public static void main(String[] args) throws Exception {
		Pattern p = Pattern.compile("[A-z\\s]+");
		File dir = new File("/home/saravanants/Desktop/Oregon Trail Electric Cooperative | ITD/ocred");
		File file[] =  dir.listFiles();
		Set s = new TreeSet<>();
		
		for(File f : file)
		{
			System.out.println("File name --> "+f.getName());
			PdfReader reader = new PdfReader(f.getAbsolutePath());
		    PdfTextExtractor px = new PdfTextExtractor(reader);
		    String page = px.getTextFromPage(1);
		    String temp ="OCR.txt";
		    System.out.println("*****************************");
		    FileOutputStream fos = new FileOutputStream(temp);
		    DataOutputStream dos = new DataOutputStream(fos);
		    dos.writeUTF(page);
			FileReader fr = new FileReader(temp);
			BufferedReader br = new BufferedReader(fr);
			String l;
			int i=0;
			while((l = br.readLine())!= null) {
				i++;
				System.out.println(l);
				Matcher m = p.matcher(l);
				while(m.find())
					{
					s.add(m.group(0));
					}		
				}
			
			System.out.println(i);
			
		}
		System.out.println("*****************************");
		System.out.println("*******List of Words*********");
		System.out.println("*****************************");
		s.forEach(System.out::println);		
		System.out.println("*****************************");

		
	}

}
//
//FileInputStream fis = new FileInputStream("/home/saravanants/Desktop/a.txt");
//DataInputStream dis = new DataInputStream(fis);
//int i = 0;
//String t;
//
//while((t=dis.readUTF()) != null) {
//	i++;
//	if(i==25)
//	{
//    	System.out.println(t);
//
//	}
//	
//}
//System.out.println(i);
//
//page.substring(2);
//int a=10;
//
//int l = page.split(System.getProperty("line.separator")).length;
////System.out.println(l);
//LineNumberReader lnr = new LineNumberReader(new StringReader(page));
//int ll = lnr.getLineNumber();
//System.out.println(page.split("[\n|\r]").length);
