package griffin_problem2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicateCounter 
{
	public void count()
	{
		String filePath = "./problem2.txt";
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		BufferedReader read = null;
		try
		{
			read = new BufferedReader(new FileReader(filePath));
			String currentLine = read.readLine();
			while(currentLine!=null)
			{
				String[] words = currentLine.toLowerCase().split(" ");
				for(String word: words)
				{
					if(wordCountMap.containsKey(word))
					{
						wordCountMap.put(word,  wordCountMap.get(word)+1);
					}
					else
					{
						wordCountMap.put(word,  1);
					}
				}
				currentLine = read.readLine();
			}
			String mostRepeatedWord = null;
			int count = 0;
			Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
			for(Entry<String, Integer> entry : entrySet)
			{
				if(entry.getValue()>count)
				{
					mostRepeatedWord = entry.getKey();
					count = entry.getValue();
				}
			}
		}
		catch(IOException ioe)
		{
			System.out.println("An IOException has been encountered");
			System.out.println("Please verify problem2.txt is where it should");
		}
		finally
		{
			try {
				read.close();
			} 
			catch (IOException e) 
			{
				System.out.println("File failed to close successfully.");
			}
			write(wordCountMap);
		}
	}
	
	public void write(HashMap<String, Integer> hm)
	{
		String outputFile = "./unique_words_counts.txt";
		File file = new File(outputFile);
		BufferedWriter bf = null;
		try
		{
			bf = new BufferedWriter( new FileWriter(file));
			for(Map.Entry<String, Integer> entry : hm.entrySet())
			{
				bf.write(entry.getKey() + ":" + entry.getValue());
				bf.newLine();
			}
			bf.flush();
		}
		catch(IOException ioe)
		{
			System.out.println("An IOException has been encountered");
			System.out.println("The file probably had issues creating");
		}
		finally
		{
			try
			{
				bf.close();
			}
			catch(Exception e)
			{
			}
		}
	}
}
