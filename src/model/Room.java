package model;

public class Room {
	private Element e;
	private Element e2;
	private boolean visibility;

	public Room(Element e) {
		this.e = e;
		visibility = false;
		e2 = Element.NOTHING;
	}

	public Element getElement() {
		return this.e;
	}
	public Element getSecondElement(){
		return this.e2;
	}
	public void makeVisible() {
		visibility = true;
	}

	public boolean isVisible() {
		return visibility;
	}

	public void changeElement(Element e) {
		if (this.e==Element.BLOOD && e==Element.SLIME)
			this.e = Element.GOOP;
		else {
			this.e2 = this.e;
			this.e = e;
		}
	}

	@Override
	public String toString() {
		if (this.e==Element.BLOOD)
			return "B";
		else if (this.e==Element.GOOP)
			return "G";
		else if (this.e==Element.WUMPUS)
			return "W";
		else if (this.e==Element.HUNTER)
			return "O";
		else if (this.e==Element.PIT)
			return "P";
		else if (this.e==Element.SLIME)
			return "S";
		else if (this.e==Element.NOTHING && this.visibility)
			return " ";
		else
			return "X";
	}
}
