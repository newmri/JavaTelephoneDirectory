import java.util.Scanner;


class PhoneInfo
{
String name;
String phoneNumber;


public PhoneInfo(String name, String phoneNumber)
{
this.name=name;
this.phoneNumber=phoneNumber;
}

public void ShowPhoneInfo()
{
System.out.println("");
System.out.println(" ---- PhoneInfo ---- ");
System.out.println("name: " + name);
System.out.println("phoneNumber: " + phoneNumber);
System.out.println("");
}


}

class PhoneUniveInfo extends PhoneInfo
{
String major;
int year;

public PhoneUniveInfo(String name,String phoneNumber,String major,int year)
{
super(name, phoneNumber);
this.major=major;
this.year=year;
}

public void ShowPhoneInfo()
{
System.out.println("");
System.out.println(" ---- PhoneInfo ---- ");
System.out.println("name: " + name);
System.out.println("phoneNumber: " + phoneNumber);
System.out.println("major: " + major);
System.out.println("year: " + year);
System.out.println("");
}

}

class PhoneCompanyInfo extends PhoneInfo
{
String company;

public PhoneCompanyInfo(String name,String phoneNumber,String company)
{
super(name,phoneNumber);
this.company=company;
}

public void ShowPhoneInfo()
{
System.out.println("");
System.out.println(" ---- PhoneInfo ---- ");
System.out.println("name: " + name);
System.out.println("phoneNumber: " + phoneNumber);
System.out.println("company: " + company);
System.out.println("");
}

}
class PhoneBookManager
{
final int MAX=100;
int cnt=0;
PhoneInfo[] pifdata = new PhoneInfo[MAX];
Scanner input= new Scanner(System.in);

public void ShowSelection()
{
System.out.println(" ---- Select ---- ");
System.out.println("1. Input info");
System.out.println("2. Search info");
System.out.println("3. Delete info");
System.out.println("4. Quit Program");
System.out.print("Select: ");
}



public int search(String name)
{
for( int i=0; i<cnt; i++){
PhoneInfo temp = pifdata[i];
if(name.compareTo(temp.name)==0) return i;
}
return -1;
}

public void SearchInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
int idx=search(name);
if(-1!=idx) pifdata[idx].ShowPhoneInfo();
else System.out.println("There is no data");
}

public void DeleteInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
int idx=search(name);
if(-1!=idx){
for(int i=idx; i<(cnt-1); i++)
pifdata[i]=pifdata[i+1];
cnt--;
} 
else System.out.println("There is no data");

}

private void GetNormalInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
System.out.print("PhoneNumber: ");
String phoneNumber=input.nextLine();
pifdata[cnt++] = new PhoneInfo(name,phoneNumber);	
}
private void GetUnivInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
System.out.print("PhoneNumber: ");
String phoneNumber=input.nextLine();
System.out.print("Major: ");
String major=input.nextLine();
System.out.print("year: ");
int year=input.nextInt();
pifdata[cnt++] = new PhoneUniveInfo(name,phoneNumber,major,year);
}

private void GetCompanyInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
System.out.print("PhoneNumber: ");
String phoneNumber=input.nextLine();
System.out.print("company: ");
String company=input.nextLine();
pifdata[cnt++] = new PhoneCompanyInfo(name,phoneNumber,company);	
}
public void GetInfo()
{
System.out.print("1. normal 2. Univ 3. Company: ");
int select = input.nextInt();
input.nextLine();

switch(select){
case 1:
	GetNormalInfo();
	break;
case 2:
	GetUnivInfo();
	break;
case 3:
	GetCompanyInfo();
	break;
default:
	System.out.println("Error");
	break;	
}

}
}

class PhoneMain
{
public static void main(String[] args)
{
PhoneBookManager pbm= new PhoneBookManager();
int select=0;

while(true){
pbm.ShowSelection();
select=pbm.input.nextInt();
pbm.input.nextLine();

switch(select){
case 1:
	pbm.GetInfo();
	break;
case 2:
	pbm.SearchInfo();
	break;
case 3:
	pbm.DeleteInfo();
	break;
case 4:
	System.out.println("Quited Program..");
	return;
default: System.out.println("Error");
	 break;
}

}

}

}