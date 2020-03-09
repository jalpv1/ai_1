import java.util.ArrayList;
import java.util.List;

//enum Position {RIGHT, LEFT}

public class Node {

	private int cannibalLeft;
	private int missionaryLeft;
	private int cannibalRight;
	private int missionaryRight;
	private Bank boat;

	private Node parentNode;

	public Node(int cannibalLeft, int missionaryLeft, Bank boat,
				int cannibalRight, int missionaryRight) {
		this.cannibalLeft = cannibalLeft;
		this.missionaryLeft = missionaryLeft;
		this.boat = boat;
		this.cannibalRight = cannibalRight;
		this.missionaryRight = missionaryRight;
	}

	public boolean isGoal() {
		return cannibalLeft == 0 && missionaryLeft == 0;
	}

	public boolean isValid() {
		if (missionaryLeft >= 0 && missionaryRight >= 0 && cannibalLeft >= 0 && cannibalRight >= 0
	               && (missionaryLeft == 0 || missionaryLeft >= cannibalLeft)
	               && (missionaryRight == 0 || missionaryRight >= cannibalRight)) {
			return true;
		}
		return false;
	}

	public Bank getBoat() {
		return boat;
	}

	public void setBoat(Bank boat) {
		this.boat = boat;
	}



	public int getCannibalLeft() {
		return cannibalLeft;
	}

	public void setCannibalLeft(int cannibalLeft) {
		this.cannibalLeft = cannibalLeft;
	}

	public int getMissionaryLeft() {
		return missionaryLeft;
	}

	public void setMissionaryLeft(int missionaryLeft) {
		this.missionaryLeft = missionaryLeft;
	}

	public int getCannibalRight() {
		return cannibalRight;
	}

	public void setCannibalRight(int cannibalRight) {
		this.cannibalRight = cannibalRight;
	}

	public int getMissionaryRight() {
		return missionaryRight;
	}

	public void setMissionaryRight(int missionaryRight) {
		this.missionaryRight = missionaryRight;
	}

	public void goToLeft() {
		boat = Bank.LEFT;
	}

	public void goToRight() {
		boat = Bank.RIGHT;
	}

	public boolean isOnLeft() {
		return boat == Bank.LEFT;
	}

	public boolean isOnRigth() {
		return boat == Bank.RIGHT;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
			return "CL " + cannibalLeft + "," +"ML " +missionaryLeft + " -------- "
        			+ " CR "+cannibalRight + "," + " MR "+ missionaryRight  + " Boat - " + boat;
     }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}
		Node s = (Node) obj;
        return (s.cannibalLeft == cannibalLeft && s.missionaryLeft == missionaryLeft
        		&& s.boat == boat && s.cannibalRight == cannibalRight
        		&& s.missionaryRight == missionaryRight);
	}
}
