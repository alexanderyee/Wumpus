package model;
//Alex Yee
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
			if (!(e == Element.NOTHING) && (e2 == Element.NOTHING))
				this.e2 = this.e;
			this.e = e;
		}
	}

	@Override
	public String toString() {
		if (!this.visibility)
			return "X";
		else if (this.e==Element.BLOOD || e2==Element.BLOOD)
			return "B";
		else if (this.e==Element.GOOP || e2==Element.GOOP)
			return "G";
		else if (this.e==Element.WUMPUS || e2==Element.WUMPUS)
			return "W";
		else if (this.e==Element.HUNTER || e2==Element.HUNTER)
			return "O";
		else if (this.e==Element.PIT || e2==Element.PIT)
			return "P";
		else if (this.e==Element.SLIME || e2==Element.SLIME)
			return "S";
		else
			return " ";
		
	}
	public String toStringWhenDone() {
		
		 if (this.e==Element.BLOOD || e2==Element.BLOOD)
			return "B";
		else if (this.e==Element.GOOP || e2==Element.GOOP)
			return "G";
		else if (this.e==Element.WUMPUS || e2==Element.WUMPUS)
			return "W";
		else if (this.e==Element.HUNTER || e2==Element.HUNTER)
			return "O";
		else if (this.e==Element.PIT || e2==Element.PIT)
			return "P";
		else if (this.e==Element.SLIME || e2==Element.SLIME)
			return "S";
		else
			return " ";
		
	}
}
