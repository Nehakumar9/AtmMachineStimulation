package atmmachinestimulation;
import java.util.*;
class InsufficientException extends Exception
{
	public InsufficientException(String s)
	{
		super(s);
	}
}
class InvalidAmountException extends Exception
{
	InvalidAmountException(String str)
	{
		super(str);
	}
}
class Balance
{
	private int balance = 60000;
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
}
public class AtmMachineStimulation {
	public static void atmAutomation() {
		Scanner scanner = new Scanner(System.in);
		Balance balance = new Balance();
		int option = 0;
		do {
			System.out.println("1)Withdraw\n2)Deposit\n3)CheckBalance\n4)Exit");
			System.out.println("Choose Your option");
			//int option = 0;
			option=scanner.nextInt();
			if(option==1)
			{
				System.out.println("Enter amount");
				int amount = scanner.nextInt();
				try {
					if(amount > balance.getBalance())
					{
						throw new InsufficientException("Amount Must be Less than the balance");
					}
					else if(amount<=0)
					{
						throw new InvalidAmountException("Enter a valid amouunt");
					}
					else
					{
						System.out.println("Amount drawn successfull"+" "+(balance.getBalance()-amount));
					}
				}
				catch(InvalidAmountException invalidamountexception)
				{
					System.out.println(invalidamountexception);
				}
				catch(InsufficientException insufficientexception)
				{
					System.out.println(insufficientexception);
				}
			}
			else if(option == 2)
			{
				System.out.println("Enter amount");
				int amount = scanner.nextInt();
				try {
					if(amount<=0)
					{
						throw new InvalidAmountException("Enter a valid amouunt");
					}
					else
					{
						System.out.println("Your amount has been deposited"+" "+(balance.getBalance()+amount));
					}
				}
				catch(InvalidAmountException invalidamountexception)
				{
					System.out.println(invalidamountexception);
				}
				
			}
			else if(option == 3)
			{
				System.out.println("Your account balance: "+balance.getBalance());
			}
			else if(option == 4) {
				break;
			}
			else {
				System.out.println("Valid option please");		
			}
		}
		while(option!=4);
		System.out.println("Thank you for using this ATM");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		atmAutomation();
	}
}
