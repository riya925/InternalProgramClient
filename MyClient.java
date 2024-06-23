import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args)
	{
		try
		{
			Socket ser=new Socket("localhost",1234);
			
			DataInputStream dis=new DataInputStream(ser.getInputStream());
			DataOutputStream dos=new DataOutputStream(ser.getOutputStream());
			Scanner scan=new Scanner(System.in);
			String msg="";
			int n;
			
			System.out.println("\n Enter the string : ");
			msg=scan.nextLine();
			dos.writeUTF(msg);
			
			n=dis.readInt();
			System.out.println("\n No of vowel is = "+n);
			
			dis.close();
			dos.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Error : "+e.getMessage());
		}
	}
}