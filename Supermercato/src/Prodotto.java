public class Prodotto 
{
private String tipoProdotto;
private int numeroProdotto;
private String codiceProdotto;
	
public Prodotto()
	{
	}

public Prodotto (String tipoProdotto, int numeroProdotto, String codiceProdotto)
	{
	this.tipoProdotto=tipoProdotto;
	this.numeroProdotto=numeroProdotto;
	this.codiceProdotto=codiceProdotto;
	}

	public String getTipoProdotto() 
		{
			return tipoProdotto;
		}
	public void setTipoProdotto(String tipoProdotto) 
		{
			this.tipoProdotto = tipoProdotto;
		}
	public int getNumeroProdotto() 
		{
			return numeroProdotto;
		}
	public void setNumeroProdotto(int numeroProdotto) 
		{
			this.numeroProdotto = numeroProdotto;
		}
	public String getCodiceIdentificativo() 
		{
			return codiceProdotto;
		}
	public void setCodiceIdentificativo(String codiceIdentificativo) 
		{
			this.codiceProdotto = codiceIdentificativo;
		}
	public String ToString()
	{
		String Stringa= "tipo: "+getTipoProdotto() + '\n' + "codice: " + getCodiceIdentificativo() + '\n' + "numero: " + getNumeroProdotto();
		return Stringa;
	}
	


}