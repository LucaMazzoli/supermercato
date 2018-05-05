import java.util.Scanner;

public class Main {
	public static void main(String[] args) 
	{
		int x= 0;
		Scanner tastiera= new Scanner(System.in);
		Menu menu = new Menu();
		String[] m1=new String [5];
		m1[0]="aggiungi prodotto";
		m1[1]="elimina prodotto";
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
			//codice cosa deve fare
		break;
		
		case 1:
			//codice cosa deve fare
		break;
		
		case 2:
			//codice cosa deve fare
		break;
		
		case 3:
			//codice cosa deve fare
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
} while (y!=0 && y!=1 && y!=2);

		break;		

		default:
			break;
		}
		} while (x!=0 && x!=1 && x!=2 && x!=3 && x!=4);

	}
}