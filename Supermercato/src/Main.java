import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ProdottoException, NumberFormatException, IOException 
	{
		ListaProdotti ListaProdotti= new ListaProdotti();
		int x= 0;
		ConsoleInput tastiera= new ConsoleInput();
		Menu menu = new Menu();
		String[] m1=new String [8];
		m1[0]="aggiungi prodotto";
		m1[1]="elimina dalla vendita un prodotto"; // + csv: prodottiEliminati.txt
		m1[2]="vendi prodotto";
		m1[3]="compra prodotto";
		m1[4]="visualizza in ordine alfabetico";
		m1[5]="visualizza prodotti minore di x";
		m1[6]="visualizza in base alle quantità rimasta";
		m1[7]="esci";		
do {
		menu.show(m1);
		
		x=tastiera.readInt();

		switch (x) 
		{
		case 0: //aggiunge prodotto
			
			Scanner tastiera1= new Scanner(System.in);
			String tipoProdotto;
			int numeroProdotto = 0;
			String codiceProdotto;
			
			System.out.println("inserisci il tipo di prodotto");
			tipoProdotto=tastiera.readString();
			System.out.println("inserisci il numero di prodotti");
			numeroProdotto=tastiera.readInt();
			System.out.println("inserisci il codice del prodotto");
			codiceProdotto=tastiera.readString();
			Prodotto prodotto1= new Prodotto(tipoProdotto,numeroProdotto,codiceProdotto);
			ListaProdotti.inseriscInPosizione(prodotto1, ListaProdotti.getElementi()+1);
			tastiera1.nextLine();
			break;
		
		case 1: //elimina prodotto
			
				String x1;
				Prodotto prodottoEliminare;
				System.out.println("prodotto da eliminare ");
				x1=tastiera.readString();
				
				for (int i = 1; i < ListaProdotti.getElementi()+1; i++) 
				{
					if (ListaProdotti.getProdotto(i).getTipoProdotto().compareTo(x1) == 0)
					{
						ListaProdotti.esportaCSV(i);
						ListaProdotti.eliminaInPosizione(i);
					}
				}
				

				break;
		
		case 2: //vendere
			String prodottoCercare;
			int c=0;
			System.out.println("prodotto da vendere ");
			prodottoCercare=tastiera.readString();
			System.out.println("prodotto venduti in quantità:  ");
			c=tastiera.readInt();
			ListaProdotti.aggiornaQuantitaVenduta(prodottoCercare, c);
			
		break;
		
		case 3://comprare
			String prodottoComprare;
			int c1=0;
			System.out.println("prodotto da comprare ");
			prodottoComprare=tastiera.readString();
			System.out.println("prodotto comprato in quantità:  ");
			c1=tastiera.readInt();
			ListaProdotti.aggiornaQuantitaComprata(prodottoComprare, c1);
		break;
		
		case 4://visualizza alfabetico
			Prodotto[] diocane = new Prodotto[ListaProdotti.getElementi()];
			diocane = ListaProdotti.creaArreyProdotto();
			ListaProdotti.ordinaProdottiCrescente(diocane);
			
			for (int i = 0; i < diocane.length; i++) 
			{
				System.out.println(diocane[i].ToString()+'\n');
			}
			break;
			
		case 5:
				//visualizza quantità da meno a piu
			
		break;
		
		case 6: //visualizza quantita inferiore a quaInt
			int quaInt=0;
			System.out.println("quantità massima  ");
			quaInt=tastiera.readInt();	
			
			Prodotto[] ArreyProdotti1 = ListaProdotti.creaArreyProdotto(); 
			for (int i = 0; i < ArreyProdotti1.length; i++) 
			{
				if (ArreyProdotti1[i].getNumeroProdotto()<quaInt) 
				{
					System.out.println(ArreyProdotti1[i].ToString()+'\n');
				}
			}
			
			
			
			
			break;
			default:
			break;
					}
} while (x !=7);

	}
}