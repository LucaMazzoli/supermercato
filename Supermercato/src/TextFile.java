import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TextFile 
{
	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public TextFile(String prodottiEliminati, char mode) throws IOException
	{
		this.mode='R';
		if (mode=='w' || mode=='W')
		{
			FileWriter f1= new FileWriter(prodottiEliminati);
			writer = new BufferedWriter(f1);
			this.mode='W';
		}
		else
		{
			FileReader f1= new FileReader(prodottiEliminati);
			reader= new BufferedReader(f1);
			this.mode='R';
		}
		
		
	}
	
	public void toFile(String line) throws ProdottoException, IOException
	{
		if (mode=='R')
			throw new ProdottoException("File aperto in lettura");
		writer.write(line);
		writer.newLine();
	}
	
	public String fromFile() throws ProdottoException, IOException
	{
		String rigaLetta;
		if (mode=='W')
			throw new ProdottoException("File aperto in scrittura");
		rigaLetta=reader.readLine();
		if (rigaLetta==null)
			throw new ProdottoException("End of file");
		return rigaLetta;
	}
	
	public void closeFile() throws IOException
	{
		if (mode=='R')
			reader.close();
		else
			writer.close();
	}
}