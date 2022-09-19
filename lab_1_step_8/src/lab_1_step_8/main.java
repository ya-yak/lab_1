package lab_1_step_8;
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
		
		String pattern0 = "((?<=\\[)[^\\[\\]]+(?=\\]))";
		
		Pattern pat0 = Pattern.compile(pattern0);
		
		Matcher m0 = pat0.matcher(numbers);
		
		List<String> dels = new ArrayList<String>();
		
		while (m0.find()) {dels.add(m0.group());}
		
		String num2 = numbers;
		
		for (String del: dels)
		
			num2 = num2.replaceAll(String.format("(?<=^)//|(,|\\\\n|%s|\\[|\\])(?!$)", del), " ").trim();
		
		int sum = 0;
		
		for (String n : num2.split(" ")) {
			
			if(n.length() > 0 && Character.isDigit(n.charAt(n.length() - 1))) {
				
				if(Integer.parseInt(n) < 0) {
					
					String prt = num2.replaceAll("(?<!-)[0-9]+", "");
					
					throw new ArithmeticException("sorry negative are not allowed :( " + prt);
					
				}
					
				if(Integer.parseInt(n) <= 1000) sum += Integer.parseInt(n);
				
			} else {
				
				sum = -1;
						
				break;
				
			}
			
		}
		
		return sum;
		
	}
	
}