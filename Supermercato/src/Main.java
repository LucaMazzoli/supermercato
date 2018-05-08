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
		menu.show(m1);
		
do {
		menu.show(m1);
		
		x=tastiera.readInt();

		switch (x) 
		{
		case 0:
			
			Scanner tastiera1= new Scanner(System.in);
			String tipoProdotto;
			int numeroProdotto;
			String codiceProdotto;
			System.out.println("inserisci il tipo di prodotto");
			tipoProdotto=tastiera.readString();
			System.out.println("inserisci il numero di prodott1");
			numeroProdotto=tastiera.readInt();
			System.out.println("inserisci il codice del prodotto");
			codiceProdotto=tastiera.readString();
			Prodotto prodotto1= new Prodotto(tipoProdotto,numeroProdotto,codiceProdotto);
			ListaProdotti.inserisciInCoda(prodotto1);
			System.out.println(prodotto1.ToStringProdotto(tipoProdotto, numeroProdotto, codiceProdotto));
			tastiera1.nextLine();
			break;
		
		case 1:
				int x1=0;
				System.out.println("prodotto da eliminare in posizione: ");
				x1=tastiera.readInt();
				ListaProdotti.eliminaInPosizione(x1);
		break;
		
		case 2:
			int venduto;
			
		break;
		
		case 3:
			int comprato;
			
		break;
		
		case 4:
				//visualizza 1
		break;
		case 5:
				//visualizza 2
		break;
		case 6:
				//visualizza 3
		break;
			default:
			break;
					}
} while (x !=7);

	}
}