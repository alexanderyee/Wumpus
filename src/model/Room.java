package model;

public class Room {
	private Element e;
	private boolean visibility;
	public Room(Element e){
		this.e = e;
		visibility = false;
	}
	public Element getElement() {
		return e;
	}
	public void makeVisible(){
		visibility = true;
	}
	public boolean isVisible(){
		return visibility;
	}
}
