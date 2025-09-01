package workshops;

class Node{
    String stage;
    Node next;

    Node(String stage){
        this.stage = stage;
        this.next = null;

    }
}
public class ParcelTracker{

    private Node head;

    public void addStage(String stage){
        Node newStage = new Node(stage);
        if(head == null){
            head = newStage;
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr  = curr.next;
        }
        curr.next = newStage;
    }

    public void addCheckPoint(String exist , String stage){
        Node newstage = new Node(stage);
        Node curr = head;

        while(curr != null && !curr.stage.equals(exist)){
            curr = curr.next;
        }

        newstage.next = curr.next;
        curr.next = newstage;

    }

    public void track(){
        Node curr = head;
        if(head == null){
            System.out.println("parcel not found");
        }

        while(curr != null){
            System.out.print(curr.stage+"->");
            curr = curr.next;
        }
        System.out.println();
        
    }

    public void lostParcel(String newstage){
        Node curr  = head;
        while(curr != null && !curr.stage.equals(newstage)){
            curr  =curr.next;
        }

        if(curr != null){
            curr.next = null;
            System.out.println("Parcel lost at "+ newstage);
        }
    }

    public static void main(String[] args) {
        ParcelTracker list = new ParcelTracker();

        list.addStage("Packed");
        list.addStage("Shipped");
        list.addStage("In Transit");
        list.addStage("Delivered");

        list.addCheckPoint("Shipped" , "Warehouse Scan");

        list.track();

        list.lostParcel("Shipped");
        list.track();
    }
}
