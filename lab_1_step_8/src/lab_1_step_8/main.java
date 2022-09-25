package lab_1_step_8;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter numbers: ");
		
		String inp = sc.nextLine();
		
		System.out.println(String.valueOf(new StringCalculator().add(inp)));
		
	}
	
}

class StringCalculator {
	
	public StringCalculator(){}
	
	private String pattern0, num2, prt;
	
	private Pattern pat0;
	
	private Matcher m0;
	
	private List<String> dels;
	
	private int sum;
	
	public int add(String numbers) {
		
		//-- GET TEMPLATE OF DELIMITERS
		
		pattern0 = "((?<=\\[)[^\\[\\]]+(?=\\]))";
		
		pat0 = Pattern.compile(pattern0);
		
		m0 = pat0.matcher(numbers.replace(numbers.replaceAll("//.+]\\\\n", ""), ""));
		
		//-- GET DELIMITERS --
		
		dels = new ArrayList<String>();
		
		while (m0.find()) {dels.add(m0.group());}
		
		//-- REPLACE DELIMITERS WITH ',' --
		
		num2 = numbers;
		
		num2 = num2.replaceAll("//.+]\\\\n", "");
		
		num2 = num2.replaceAll("(?<=^)//|(,|\\\\n|\\[|\\])(?!$)", " ");
		
		num2 = num2.replaceAll("\\\\", "\\[s");
		
		for (String del: dels) {
			
			//-- REPLACE UNSAFE CHARACTERS --
			
			if (del.contains("\\")) del = del.replace("\\", "\\[s");
			if (del.contains("*")) del = del.replace("*", "\\*");
			if (del.contains("(")) del = del.replace("(", "\\(");
			if (del.contains(")")) del = del.replace(")", "\\)");
			if (del.contains("{")) del = del.replace("{", "\\{");
			if (del.contains("}")) del = del.replace("}", "\\}");
			if (del.contains("|")) del = del.replace("|", "\\|");
			if (del.contains("&")) del = del.replace("&", "\\&");
			if (del.contains("?")) del = del.replace("?", "\\?");
			if (del.contains("+")) del = del.replace("+", "\\+");
			if (del.contains("^")) del = del.replace("^", "\\^");
			if (del.contains(".")) del = del.replace(".", "\\.");
		
			num2 = num2.replaceAll("(?<=[0-9])" + del + "(?=[0-9])", " ");
		
		}
		
		num2 = num2.trim();
		
		//-- GET SUM --
		
		sum = 0;
		
		for (String n : num2.split(" ")) {
			
			if (n.length() > 0 && n.replaceAll("[-0-9]+", "").length() == 0) {
				
				if (Integer.parseInt(n) < 0) {
					
					prt = num2.replaceAll("(?<!-)[0-9]+", "");
					
					throw new ArithmeticException("sorry negative are not allowed :( " + prt);
					
				}
					
				if(Integer.parseInt(n) <= 1000) sum += Integer.parseInt(n);
				
			} else {
				
				throw new ArithmeticException("sorry a mistake found in your numbers :(");
				
			}
			
		}
		
		return sum;
		
	}
	
}