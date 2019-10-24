import java.util.Scanner;
public class Shop {

	private static boolean check1 = false;
	private static boolean check2= false;
	private static String[] names = new String[100];
	private static double[] prices = new double[100];
	private static int[] amounts = new int [100];
	private static int items = 0;
	private static double discAmount=0,discount=0,subTotal=0; 
	
public static void setupShop(){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of items: ");
		items = in.nextInt();
		for (int i = 0; i < items; i++){
				System.out.println("Enter name of product " + i + ":");
				names[i] = in.next();
				System.out.println("Enter price of product " + i + ":");
				prices[i] = in.nextDouble();
		}
		System.out.println("Please enter the amount to qualify for discount: ");
		discAmount = in.nextDouble();
		System.out.println("Please enter the discount rate (0.1 = 10%)");
		discount = in.nextDouble();
			intro(in);
	}

public static void Buy(){
		
		Scanner in = new Scanner(System.in);
		for (int i =0; i < amounts.length; i++)
			amounts[i]=0;
		for(int i =0;i<items; i++ ){
		System.out.println("Enter the amount of " + names[i] + ": ");
		amounts[i]= in.nextInt();
	}
		intro(in);
		}
	
public static void listItems(){
		Scanner in = new Scanner(System.in);
		for(int i =0; i<items; i++){
			if (amounts[i] !=0){
		System.out.print(amounts[i]);
		System.out.print(" count of " + names[i] + " @ " + prices[i]);
		System.out.println(" = $" + (amounts[i]*prices[i]));
		System.out.println("");
			}
		}
		intro(in);
	}
	
public static void Checkout(){
		System.out.println("Thanks for coming!");
		for (int i =0; i<items; i++)
		subTotal+= (amounts[i]*prices[i]);
		if (subTotal > discAmount)
			discount *= subTotal;
		else 
			discount = 0;
		System.out.println("Sub Total: $" + subTotal);
		System.out.println("-Discount: $" + discount);
		System.out.println("Total: $" + (subTotal-discount));
	}
	
public static void checking(int in){
		Scanner input = new Scanner(System.in);
		int function = in;
		if(function>4){
			System.out.println("Error: Do not know "+ function);
			System.out.println("");

			intro(input);
		}
		if(function == 1){
			check1=true;
			setupShop();
		}
		 if(function==2 && check1 == true){
			 check2= true;
				Buy();			
	}
		 if(function ==2 && check1 == false){
				System.out.println("You have not set up shop!");
				System.out.println("");

				intro(input);
		 }
		 if(function == 3 && check1==false){
			System.out.println("You have not set up shop!");
			System.out.println("");
			intro(input);
		}
	
		 if(function == 3 && check1 == true && check2==false){
		System.out.println("You have not bought anything!");
		System.out.println("");
		intro(input);
		}
		 if(function == 3 && check1 == true && check2 ==true)
		listItems();
		
		if(function == 4 && check1==true)
		Checkout(); 
		
			if(function == 4 && check1 == false){
			System.out.println("You have not set up shop!");
			System.out.println("");
			intro(input);
		}
		 
		}
	
public static void intro(Scanner input){
		Scanner in = new Scanner(System.in);
		int function = 0;
		System.out.println("This program supports 4 functions:");
		System.out.println("	1. Setup Shop");
		System.out.println(" 	2. Buy");
		System.out.println(" 	3. List Items");
		System.out.println("	4. Checkout");
		System.out.println("Please choose the function you want: ");
		function = in.nextInt();
		checking(function);
		
		
	}
	
	
	
public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		intro(input);
		
		
	}

}
