import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greb {

	public static void main(String[] args) throws Exception {
		final String regex = "(?<=a.account_number = ).*";
		final Pattern p = Pattern.compile(regex);
		String s="";
		FileReader fr = new FileReader("/home/saravanants/Desktop/1.txt");
		BufferedReader br = new BufferedReader(fr);
		String l;
		Set<String> lst=new HashSet<String>();  

		while((l = br.readLine())!= null) {
			
			//System.out.println("------");
			Matcher m = p.matcher(l);
			while(m.find()) {
				s = m.group(0);
				lst.add(s);
				//lst.add("\"./accountData[@accountNumber='"+m.group(0)+"']/..\",");

				}		
			}
		System.out.println(lst.size());
		System.out.println();
		//System.out.println(lst.toString());
		lst.forEach(System.out::println);
		
		/*Iterator i = lst.iterator();
		while(i.hasNext())
		{
			System.out.println("\"./accountData[@accountNumber='"+i.next()+"']/..\",");

		}*/
		}

}
