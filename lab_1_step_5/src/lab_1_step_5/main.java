package lab_1_step_5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String inp = sc.nextLine();
		
		System.out.println(String.valueOf(new StringCalculator().add(inp)));
		
	}
	
}

class StringCalculator {
	
	
	
	public StringCalculator(){}
	
	public int add(String numbers)
	{
		
		String pattern0 = "(?<=//).+(?=\\n)";
		
		Pattern pat0 = Pattern.compile(pattern0);
		
		Matcher m0 = pat0.matcher(numbers);
		
		m0.find();
		
		String del = m0.group(0);
		
		String num2 = numbers.replaceAll(String.format("//|(,|\\n|%s)(?!$)", del), " ").trim();
		
		int sum = 0;
		
		for (String n : num2.split(" ")) {
			
			if(n.length() > 0 && Character.isDigit(n.charAt(n.length() - 1))) {
				
				if(Integer.parseInt(n) < 0) {
					
					String prt = num2.replaceAll("(?<!-)[0-9]+", "");
					
					throw new ArithmeticException("sorry negative are not allowed :( " + prt);
					
				}
					
				sum += Integer.parseInt(n);
				
			} else {
				
				sum = -1;
						
				break;
				
			}
			
		}
		
		return sum;
		
	}
	
}