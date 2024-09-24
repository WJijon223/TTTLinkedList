public class LinkedList {

    private Node head; // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = new Node("");
        this.head.position = 1;
        for (int i = 2; i <= 9; i++) {
            insertAtEnd("", i);
        }
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data, int position) {
        Node node = new Node(data);
        Node n = this.head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
        n.next.position = position;
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        Node n = this.head;
        while (n.position != position) {
            n = n.next;
        }
        n.data = data;
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        Node n = this.head;
        while (n.position != position) {
            n = n.next;
        }
        return n.data;
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        Node n = this.head;
        while (n != null) {
            if (n.position == 4 || n.position == 7) {
                System.out.println();
                System.out.println("---------");
            }
            if(n.data.equals("")) {
                System.out.print(" ");
            }
            else{
                System.out.print(n.data);
            }
            if (!(n.position == 3) && !(n.position == 6) && !(n.position == 9)) {
                System.out.print(" | ");
            }
            n = n.next; // Move to next node after printing
        }
    }
    

    // Method to check for a win
    public boolean checkWinCondition() {
        //check possible row wins
        if(checkWins(1,2,3) || checkWins(4, 5, 6) || checkWins(7,8,9)) {
            return true;
        }
        //check possible column wins
        if(checkWins(1,4,7) || checkWins(2,5,8) || checkWins(3, 6, 9)) {
            return true;
        }
        //check possible diagonal wins
        if(checkWins(1,5,9) || checkWins(3,5,7)) {
            return true;
        }
        return false;
    }

    public boolean checkWins(int pos1, int pos2, int pos3) {
        String pos1data = getPositionValue(pos1);
        String pos2data = getPositionValue(pos2);
        String pos3data = getPositionValue(pos3);

        //checks to make sure that the positions are not empty and are equal to one another
        return !pos1data.equals("") && pos1data.equals(pos2data) && pos2data.equals(pos3data);
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        Node n = this.head;
        while(n.next != null) {
            if (n.data.equals("")) {
                return false;
            }
            n = n.next;
        }
        if (n.data.equals("")) {
            return false;
        }
        return true;
    }

    // Method to reset the board
    public void resetBoard() {
        Node n = this.head;
        while (n.next != null) {
            n.data = null;
            n = n.next;
        }
        n.data = "";
    }
}