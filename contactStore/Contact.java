package contactStore;

public class Contact{
    private String id;
    private String name;
    private String contactNum;
    private String company;
    private double salary;
    private String birthday;



    public Contact(String id,String name,String contactNum,String company,double salary,String birthday){
        this.id = id;
        this.name = name;
        this.contactNum = contactNum;
        this.company = company;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getContactNum(){
        return this.contactNum;
    }
    public String getCompany(){
        return this.company;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getBirthday(){
        return this.birthday;
    }

}   


