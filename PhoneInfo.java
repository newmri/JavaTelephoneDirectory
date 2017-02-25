import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

interface MENU{int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;}
interface INPUT_SELECT{int NORMAL=1, UNIV=2, COMPANY=3;}

class MenuSelectException extends Exception
{
int wrongSelect;
public MenuSelectException(int num)
{
super("wrong select");
wrongSelect=num;
}
public void ShowException(){System.out.println("Number: " + wrongSelect + " Invalide Number");}
}

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

public int hashCode(){return name.hashCode();}

public boolean equals(Object obj)
{
PhoneInfo comp=(PhoneInfo)obj;
if(name.compareTo(comp.name)==0) return true;
else return false;
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
HashSet<PhoneInfo> m_info= new HashSet<PhoneInfo>();
Scanner input= new Scanner(System.in);
static PhoneBookManager inst=null;

private PhoneBookManager(){}

public static PhoneBookManager CreateManagerInst()
{
if(null==inst) inst=new PhoneBookManager();
return inst;
}

public void ShowSelection()
{
System.out.println(" ---- Select ---- ");
System.out.println("1. Input info");
System.out.println("2. Search info");
System.out.println("3. Delete info");
System.out.println("4. Quit Program");
System.out.print("Select: ");
}



public PhoneInfo search(String name)
{

Iterator<PhoneInfo> itor=m_info.iterator();
while(itor.hasNext()){
PhoneInfo curinfo=itor.next();
if(name.compareTo(curinfo.name)==0) return curinfo;
}
return null;
}

public void SearchInfo()
{
System.out.print("Name: ");
String name=input.nextLine();

PhoneInfo info=search(name);
if(null==info)
	System.out.println("There is no data");
else
	info.ShowPhoneInfo();

}

public void DeleteInfo()
{
System.out.print("Name: ");
String name=input.nextLine();

Iterator<PhoneInfo> itor=m_info.iterator();
while(itor.hasNext()){
PhoneInfo curinfo=itor.next();
if(name.compareTo(curinfo.name)==0){
itor.remove();
System.out.println("Data has been deleted.");
return;
}
}
System.out.println("There is no data");

}

private void GetNormalInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
System.out.print("PhoneNumber: ");
String phoneNumber=input.nextLine();
PhoneInfo info = new PhoneInfo(name,phoneNumber);
boolean canadd=m_info.add(info);

if(true==canadd)
	System.out.println("Data store has been succssed.");
else
	System.out.println("Data u have inputed already exists.");	


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

PhoneInfo info = new PhoneUniveInfo(name,phoneNumber,major,year);
boolean canadd=m_info.add(info);

if(canadd)
	System.out.println("Data store has been succssed.");
else
	System.out.println("Data u have inputed already exists.");	

}

private void GetCompanyInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
System.out.print("PhoneNumber: ");
String phoneNumber=input.nextLine();
System.out.print("company: ");
String company=input.nextLine();

PhoneInfo info = new PhoneCompanyInfo(name,phoneNumber,company);
boolean canadd=m_info.add(info);

if(canadd)
	System.out.println("Data store has been succssed.");
else
	System.out.println("Data u have inputed already exists.");	


}

public void GetInfo() throws MenuSelectException
{
System.out.print("1. normal 2. Univ 3. Company: ");
int select = input.nextInt();
input.nextLine();

switch(select){
case INPUT_SELECT.NORMAL:
	GetNormalInfo();
	break;
case INPUT_SELECT.UNIV:
	GetUnivInfo();
	break;
case INPUT_SELECT.COMPANY:
	GetCompanyInfo();
	break;
default:
	throw new MenuSelectException(select);
}

}
}


class PhoneMain
{
public static void main(String[] args)
{
PhoneBookManager pbm= PhoneBookManager.CreateManagerInst();
int select=0;

while(true){
try{

pbm.ShowSelection();
select=pbm.input.nextInt();
pbm.input.nextLine();

switch(select){
case MENU.INPUT:
	pbm.GetInfo();
	break;
case MENU.SEARCH:
	pbm.SearchInfo();
	break;
case MENU.DELETE:
	pbm.DeleteInfo();
	break;
case MENU.EXIT:
	System.out.println("Quited Program..");
	return;
default: throw new MenuSelectException(select);
	 
}

}

catch(MenuSelectException e){e.ShowException();}

}

}

}

