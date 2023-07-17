package contactStore;
public class ContactList{
    private Node first; 
////////////// add new  //////////////////

    public void add(Contact contact){
        Node n1=new Node(contact);
        if(first==null){
            first=n1;
        }else{
            Node lastNode=first;
            while(lastNode.next!=null){
                lastNode=lastNode.next;
            } 
            lastNode.next=n1;
        }
    }
///////////// to array ///////////////

    public Contact[] toArray(){
        Contact[] contactArray=new Contact[size()];
        Node temp=first;
        for(int i=0; temp!=null; i++){
            contactArray[i]=temp.contact;
            temp=temp.next;
        }
        return contactArray;
    }

///////////////// remove indext wise contact //////////////////
        public void remove(int index) {
            if (index >= 0 && index < size()) {
                if (index == 0) {
                    first = first.next;
                } else {
                    Node temp = first;
                    for (int i = 0; i < index - 1; i++) {
                        temp = temp.next;
                    }
                    temp.next = temp.next.next;
                }
            }
        }
/////////////// remove contact wise //////////////

    public void remove(Contact contact){
        remove(indexOf(contact));
    }

/////////////// index of  //////////////
    public int indexOf(Contact contact){
        Node temp=first;
        int index=-1;
        while(temp!=null){
            index++;
            if(temp.contact.getId().equals(contact.getId())){
                return index;
            }
            temp=temp.next;
        }
        return -1;
    }

    
///////////// get contact /////////////////

    public Contact get(int index){
            if(index==0){
                return first.contact;
            }else{
                Node temp=first;
                for(int i=0; i<index; i++){
                    temp=temp.next;
                }
                return temp.contact;
            }
   
    }
///////////// get contact  from input /////////////////
    public Contact get(String input){
        Node temp=first;
        while(temp != null ){
            if( input.equals(temp.contact.getName()) || input.equals(temp.contact.getContactNum())){
                return temp.contact;
            }
                temp=temp.next;
              }
                return null;
           
   
    }
    /////////////////// size //////////////////
    public int size(){
        int count=0;
        Node temp=first;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    /////////// sorting by salary ///////////
    public void sortBySalary(){
        Node temp = first;
        while(temp.next != null){

      
        }
    }

    //------------Inner class----------------
    private class Node{
        private Contact contact;
        private Node next;
        
        Node(Contact contact){this.contact=contact;}
    }
    //--------------------------------------

}


