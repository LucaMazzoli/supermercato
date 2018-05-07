public class ProdottoException extends Exception 
{
	private String messaggio;
	
	public ProdottoException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
