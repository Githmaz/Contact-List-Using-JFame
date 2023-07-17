package contactStore;

import java.util.*;
public class ContactController{
	public static boolean addContact(Contact contact){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.add(contact);
		return true;
	}
	public static Contact[] getAllContact(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		return contactList.toArray();
	}

//_________________________   sort by Salary  ___________________________//

	public static Contact[] getAllContactSortBySalary(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Contact[] contactArray=contactList.toArray();
		for (int i = 1; i < contactArray.length; i++){
			for(int j=0; j<contactArray.length-i; j++){
				if(contactArray[j].getSalary()<contactArray[j+1].getSalary()){
					Contact tempContact=contactArray[j];
					contactArray[j]=contactArray[j+1];
					contactArray[j+1]=tempContact;
				}
			}
		}
		
		return contactArray;
	}
//_________________________   sort by Name  ___________________________//

	public static Contact[] getAllContactSortByName() {
		ContactList contactList = DBConnection.getInstance().getContactList();
		Contact[] contactArray = contactList.toArray();
		for (int i = 1; i < contactArray.length; i++) {
			for (int j = 0; j < contactArray.length - i; j++) {
				if (contactArray[j].getName().compareTo(contactArray[j + 1].getName()) > 0) {
					Contact tempContact = contactArray[j];
					contactArray[j] = contactArray[j + 1];
					contactArray[j + 1] = tempContact;
				}
			}
		}
		return contactArray;
	}

//_________________________   sort by Birthday  ___________________________//
	public static Contact[] getAllContactSortByBday() {
		ContactList contactList = DBConnection.getInstance().getContactList();
		Contact[] contactArray = contactList.toArray();
		for (int i = 1; i < contactArray.length; i++) {
			for (int j = 0; j < contactArray.length - i; j++) {
				if (contactArray[j].getBirthday().compareTo(contactArray[j + 1].getBirthday()) > 0) {
					Contact tempContact = contactArray[j];
					contactArray[j] = contactArray[j + 1];
					contactArray[j + 1] = tempContact;
				}
			}
		}
		return contactArray;
	}

//_________________________    Search    ___________________________//

	 public static Contact searchContact(String input){
		ContactList contactList=DBConnection.getInstance().getContactList();
		return contactList.get(input);
	
	}

//_________________________    Update   ___________________________//

	public static boolean updateContact(Contact contact){
		ContactList contactList=DBConnection.getInstance().getContactList();
        contactList.remove(contactList.indexOf(contact));
        contactList.add(contact);
        return true;
    }

//_________________________    Delete    ___________________________//
	public static boolean deleteContact(Contact contact){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.remove(contactList.indexOf(contact));
		return true;
	
		
	}

	public static String lastId(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		String[] idArray=new String[contactList.size()];
		for (int i = 0; i < contactList.size(); i++){
			idArray[i]=contactList.get(i).getId();
		}
		Arrays.sort(idArray);	
		return idArray.length== 0 ? null : idArray[idArray.length-1];
	}
}

