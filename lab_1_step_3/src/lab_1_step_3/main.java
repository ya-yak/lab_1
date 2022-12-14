package lab_1_step_3;
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
	
	String pattern = "([0-9]+(?=,?|\\\\n?))+|((,|\\\\n){2,})";
	
	Pattern pat = Pattern.compile(pattern);
	
	String str;
	
	public StringCalculator(){}
	
	public int add(String numbers)
	{
		
		System.out.println(numbers);
		
		Matcher m = pat.matcher(numbers);
		
		List<String> ms = new ArrayList<String>();
		
		while (m.find()) {ms.add(m.group());}
		
		int sum = 0;
		
		for (String n : ms) {
			
			if(n.charAt(0) != ',' && n.charAt(0) != '\n')
					
				sum += Integer.parseInt(n);
			
			else
			{
				
				sum = -1;
						
				break;
				
			}
			
		}
		
		return sum;
		
	}
	
}