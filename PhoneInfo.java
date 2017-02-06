import java.util.Scanner;
class PhoneInfo
{
String name;
String phoneNumber;
String birthday;

public PhoneInfo(String name, String phoneNumber)
{
this.name=name;
this.phoneNumber=phoneNumber;
this.birthday=null;
}

public PhoneInfo(String name, String phoneNumber, String birthday)
{
this.name=name;
this.phoneNumber=phoneNumber;
this.birthday=birthday;
}

public void ShowPhoneInfo()
{
System.out.println("");
System.out.println(" ---- PhoneInfo ---- ");
System.out.println("name: " + name);
System.out.println("phoneNumber: " + phoneNumber);
if(birthday!=null) System.out.println("birthday: " + birthday);
System.out.println("");
}

}

class PhoneMain
{
static Scanner input= new Scanner(System.in);

public static void ShowSelection()
{
System.out.println(" ---- Select ---- ");
System.out.println("1. Input info");
System.out.println("2. Quit program");
System.out.print("Select: ");
}

public static void GetInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
System.out.print("PhoneNumber: ");
String phoneNumber=input.nextLine();
System.out.print("BirthDay: ");
String birthday=input.nextLine();

PhoneInfo pinfo= new PhoneInfo(name,phoneNumber,birthday);
pinfo.ShowPhoneInfo();
}
public static void main(String[] args)
{
int select=0;
while(2!=select){
ShowSelection();
select=input.nextInt();
input.nextLine();
if(1==select){
GetInfo();
}
}
}

}