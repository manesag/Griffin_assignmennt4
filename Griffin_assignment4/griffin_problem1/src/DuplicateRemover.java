package griffin_problem1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover 
{
	public void remove()
	{
		String input = null;
		String filePath = "./problem1.txt";
		try
		{
			Scanner sc = new Scanner(new File(filePath));
			Set<String> set = new HashSet<>();
		      while (sc.hasNextLine()) 
		      {
		         input = sc.nextLine();
		         set.add(input);
		      }
		      write(set);
		      sc.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("The file problem1.txt was not found");
			System.out.println("Please place it into the directory above.");
		}
	}
	
	public void write(Set<String> x)
	{
		PrintWriter write = null;
		try 
		{
			write = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./unique_words.txt"), "UTF-8"));
			for (String s:x)
			{
				write.println(s);
			}
			write.close();
		}
		catch(UnsupportedEncodingException | FileNotFoundException uee)
		{
			System.out.println("The file could not be printed");
			System.out.println("Your system might not support UTF-8 encoding format");
		} 

		finally
		{
			write.close();
		}
	}
}
