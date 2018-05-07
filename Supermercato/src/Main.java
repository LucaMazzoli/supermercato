import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ProdottoException 
	{
		ListaProdotti ListaProdotti= new ListaProdotti();
		int x= 0;
		Scanner tastiera= new Scanner(System.in);
		Menu menu = new Menu();
		String[] m1=new String [5];
		m1[0]="aggiungi prodotto";
		m1[1]="elimina dalla vendita un prodotto"; // + csv: prodottiEliminati.txt
		m1[2]="vendi prodotto";
		m1[3]="compra prodotto";
		m1[4]="visualizza prodotti";
		menu.show(m1);
		
		
		Menu menu1= new Menu();
		String[] m2= new String[4];
		m2[0]="visualizza in ordine alfabetico";
		m2[1]="visualizza prodotti minore di x";
		m2[2]="visualizza in base alle quantità rimasta";
		m2[3]="esci";

		x=tastiera.nextInt();
		int y;
		
do {
		switch (x) 
		{
		case 0:
			
			Scanner tastiera1= new Scanner(System.in);
			String tipoProdotto;
			int numeroProdotto;
			String codiceProdotto;
			
			tipoProdotto=tastiera.nextLine();
			numeroProdotto=tastiera.nextInt();
			codiceProdotto=tastiera.nextLine();
			Prodotto prodotto1= new Prodotto(tipoProdotto,numeroProdotto,codiceProdotto);
			ListaProdotti.inserisciInCoda(prodotto1);
			
		break;
		
		case 1:

		break;
		
		case 2:
			int venduto;
			
		break;
		
		case 3:
			int comprato;
			
		break;
		
		case 4:
			menu1.show(m2);
			y=tastiera.nextInt();
	do {
				switch (y) 
			{
			case 0:
				//visualizza 1
			break;
			case 1:
				//visualizza 2
			break;
			case 2:
				//visualizza 3
			break;
				default:
				break;
			}
	} while (y == 3);

		break;		

		default:
			break;
		}
} while (x!=0 && x!=1 && x!=2 && x!=3 && x!=4);

	}
}