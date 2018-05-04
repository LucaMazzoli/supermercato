public class Nodo 
{
private Prodotto info;
private Nodo link;

public Nodo(Prodotto prodotto)
	{
	setInfo(prodotto);
	link=null;
	}
public Prodotto getInfo()
	{
	return info;
	}
public void setInfo(Prodotto info)
	{
	this.info=info;
	}
public Nodo getLink()
	{
	return link;
	}
public void setLink(Nodo Link)
	{
	this.link=link;
	}
}