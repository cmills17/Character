
//this code reads in the csv file, parses it, checks to see if there are at least 2 values in a row, 
//and then prints the value in column
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class csvfile
{

	public static ArrayList<String[]> getData()
	{
		ArrayList<String[]> data = new ArrayList<String[]>(); 
		
		String csvFile = "entityfacts.csv"; //
		BufferedReader br = null; //
		String line = "";
		String cvsSplitBy = ","; // splits the row at every comma
		try
		{

			br = new BufferedReader(new FileReader(csvFile)); // puts the csv
															  // file into a
															  // file reader,
															  // created
															  // filereader
															  // called br
			while ((line = br.readLine()) != null)
			{ // reads in individual lines until last line is empty/null
				line = br.readLine();
				// System.out.println(line);
				String[] thisLine = line.split(cvsSplitBy); // splits the line
															// into columns

				if (thisLine.length > 1)
				{ // sets it up so that prints only rows w/ more than 1 value
					System.out.println(thisLine[1]); // makes it just print
													 // column1
					if (thisLine.length > 4) // if row has over 4 values
					{
						data.add(thisLine);
						System.out.println(thisLine[4]); // print value in
														 // column4
					}

					// for column[1] = 0x22c1 {
					// System.out.println([5]);
				}
				for (int i = 0; i < thisLine.length; i++)
				{
					String s = thisLine[i]; // reads the string from the string
											// array
					for (int j = 0; j < s.length(); j++)
					{
						if (s.charAt(j) == ' ')
						{

						}
					}

				}

			}

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done"); // prints the word "done"
		return data;
	}

}