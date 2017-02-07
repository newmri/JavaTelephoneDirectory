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

public void ShowPhoneInfo()
{
System.out.println("");
System.out.println(" ---- PhoneInfo ---- ");
System.out.println("name: " + name);
System.out.println("phoneNumber: " + phoneNumber);
if(birthday!=null) System.out.println("birthday: " + birthday);
System.out.println("");
}

public PhoneInfo(String name, String phoneNumber, String birthday)
{
this.name=name;
this.phoneNumber=phoneNumber;
this.birthday=birthday;
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
public void GetInfo()
{
System.out.print("Name: ");
String name=input.nextLine();
System.out.print("PhoneNumber: ");
String phoneNumber=input.nextLine();
System.out.print("BirthDay: ");
String birthday=input.nextLine();

pifdata[cnt++] = new PhoneInfo(name,phoneNumber,birthday);
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
switch(select)
{
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
}

}

}

}