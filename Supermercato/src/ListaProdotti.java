import java.io.*;

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
	

	public Prodotto[] creaArreyProdotto() throws ProdottoException
	{
		Prodotto[] ArreyProdotti = new Prodotto[getElementi()];
		for (int i = 0; i < ArreyProdotti.length; i++) 
		{
			ArreyProdotti[i]=getProdotto(i+1);
		}
		
		return ArreyProdotti;
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
	public void aggiornaQuantitaVenduta(String prodottoCercato, int quantita) throws NumberFormatException, IOException, ProdottoException
	{
		Prodotto prodotto;
		prodotto=cercaProdotti(prodottoCercato);
		prodotto.setNumeroProdotto(prodotto.getNumeroProdotto()-quantita);
	}
	public void aggiornaQuantitaComprata(String prodottoCercato, int quantita) throws NumberFormatException, IOException, ProdottoException
	{
		Prodotto prodotto;
		prodotto=cercaProdotti(prodottoCercato);
		prodotto.setNumeroProdotto(prodotto.getNumeroProdotto()+quantita);
	}
	public Prodotto cercaProdotti(String prodottoCercare) throws NumberFormatException, IOException, ProdottoException
	{
		Prodotto prodotto;
		for (int i = 1; i <= getElementi(); i++) 
		{
			prodotto=getProdotto(i);
			if (prodotto.getTipoProdotto().compareTo(prodottoCercare)==0) 
			{
				return prodotto;
			}
		}
		return null;
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
	
	public void esportaCSV (int i) throws IOException, ProdottoException
	{
		PrintWriter file_output =new PrintWriter ( new BufferedWriter (new FileWriter ("ProdottiEliminati.txt", true )));
	
		file_output.println(getProdotto(i).ToString());
		
		file_output.close();
		
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
	public void salvaProdotto(String nomeFile) throws IOException
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
	
///////////////////////////////	
	
	
	public int scambia (Prodotto[] array, int pos1, int pos2)
	{
		Prodotto s;
		if (pos1<0 || pos2<0 || pos1>=array.length || pos2>=array.length)
			return -1;
		else
		{
			s=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=s;
			return 0;
		}			
	}
	
	public void ordinaProdottiCrescente(Prodotto[] arrayCopia)
	{		
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{				
				if (arrayCopia[i].getTipoProdotto().compareTo(arrayCopia[i+1].getTipoProdotto())<0)
					scambia(arrayCopia,i,i+1);
		}
	}
	
	private Prodotto[] copiaArray(Prodotto[] array)
	{
		Prodotto[] arrayCopia=new Prodotto[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
			arrayCopia[i]=array[i];
		return arrayCopia;
	}
	
	
}