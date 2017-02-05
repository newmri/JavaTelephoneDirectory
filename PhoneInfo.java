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
}

}
class PhoneMain
{

public static void main(String[] args)
{
PhoneInfo pi= new PhoneInfo("Kim","010-1111-1111");
PhoneInfo pi2= new PhoneInfo("Park","010-2222-2222","1993/10/01");
pi.ShowPhoneInfo();
pi2.ShowPhoneInfo();
}

}