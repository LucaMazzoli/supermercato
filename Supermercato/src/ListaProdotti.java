import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ListaProdotti implements Serializable
{
	private Nodo head;
	private int elementi;
	
	public ListaProdotti()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Prodotto prodotto, Nodo link)
	{
		Nodo nodo= new Nodo(prodotto);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws ProdottoException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new ProdottoException("Posizione non valida");
		if (elementi==0)
			throw new ProdottoException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
	}
	
	public void inserisciInTesta (Prodotto prodotto)
	{
		
		Nodo p=creaNodo(prodotto, head);
		head=p;
		elementi++;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	public void inserisciInCoda(Prodotto prodotto) throws ProdottoException
	{
		if(elementi==0)
		{
			inserisciInTesta(prodotto);
			return;
		}
		
		Nodo pn=creaNodo(prodotto, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	
	public void inseriscInPosizione(Prodotto prodotto,int posizione) throws ProdottoException
	{
		if (posizione<=1)
		{
			inserisciInTesta(prodotto);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(prodotto);
			return;
		}
		
		Nodo pn=creaNodo(prodotto, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	public void eliminaInTesta() throws ProdottoException
	{
		if (elementi==0)
			throw new ProdottoException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	
	public void eliminaInCoda() throws ProdottoException
	{
		if (elementi==0)
			throw new ProdottoException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws ProdottoException
	{
		if (elementi==0)
			throw new ProdottoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new ProdottoException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	public String visita (int posizione) throws ProdottoException
	{
		if (elementi==0)
			throw new ProdottoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new ProdottoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	
	public Prodotto getProdotto (int posizione) throws ProdottoException
	{
		if (elementi==0)
			throw new ProdottoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new ProdottoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	public void esportaCSV (String nomeFile) throws IOException, ProdottoException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String prodottoCSV;
		Prodotto prodotto;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			prodotto=getProdotto(i);
			prodottoCSV=prodotto.getTipoProdotto()+";"+prodotto.getNumeroProdotto()+";"+prodotto.getCodiceIdentificativo()+";";
			file.toFile(prodottoCSV);
		}
		file.closeFile();
		
	}

	public Prodotto importaCSV (String nomeFile) throws IOException, ProdottoException
	{
		Prodotto prodotto=new Prodotto();
		TextFile file=new TextFile(nomeFile,'R');
		String rigaLetta;
		String[] elementiPersona;
		Prodotto prodotto1;
		
			try 
			{
				while(true)
				{
					rigaLetta=file.fromFile();
					elementiPersona=rigaLetta.split(";");
					prodotto=new Prodotto(elementiPersona[0],elementiPersona[1].charAt(0),elementiPersona[2]);
				}
				
			} 
			catch (ProdottoException e) 
			{
				if (e.toString().compareTo("End of file")==0)
					file.closeFile();
				else
					throw new ProdottoException(e.toString());
			}
		
			return prodotto;		
			
	}
	public void salvaFesta(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Prodotto caricaProdotto (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Prodotto prodotto;
		
		prodotto=(Prodotto)(reader.readObject());
		file.close();
		return prodotto;
	}
}