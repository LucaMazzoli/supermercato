
public class Menu 
{	
	public Menu()
	{
		
	}

	public void show(String[] voci)
	{
		for (int i = 0; i < voci.length; i++) 
		{
			System.out.println(voci[i]+" ---> "+i);
		}

	}
}