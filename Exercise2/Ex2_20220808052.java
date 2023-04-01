import java.util.Date;

public class Ex2_20220808052 {
    public static void main(String[] args) {
        City sanfransisco = new City("94016","San Fransisco");
        City ankara = new City("06000","Ankara");
        Person haydar = new Person("Haydar Can","Karabacak","0599 999 99 99");
        //Ticket ucak = new Ticket(ankara,sanfransisco,new Date(2023,12,6),60); 
        Ticket ucak = new Ticket(ankara,sanfransisco,60); 

        System.out.println(ucak.getDate());
    }
}

class Ticket
{
    private City from ;
    private City to;
    private Date date;
    private int seat;

    Ticket(City from,City to,Date date,int seat)
    {
        this.from = from;
        this.to = to;
        this.date = date;
        this.seat = seat;
    }

    Ticket(City from,City to,int seat)
    {
        this.from = from;
        this.to = to;
        Date tempDate = new Date();
        tempDate.setTime(tempDate.getTime()+ 86400000);
        this.date = tempDate;
        this.seat = seat;
    }
    public City getFrom()
    {
        return this.from;
    }
    public City getTo()
    {
        return this.to;
    }
    public Date getDate()
    {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
}
class City
{
    private String postalCode;
    private String name;


    City(String postalCode,String name)
    {
        this.postalCode = postalCode;
        this.name = name;
    }


    public String getPostalCode() {
        return postalCode;
    }
    public String getName() {
        return name;
    }
}
class Person
{
    private String name;
    private String surname;
    private String phoneNumber;

    Person(String name,String surname,String phoneNumber)
    {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
