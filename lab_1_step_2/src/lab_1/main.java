package lab_1;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class main {
	
	public static void main(String[] args) {
		
		System.out.println(String.valueOf(new StringCalculator().add("")));
		
	}
	
}

class StringCalculator {
	
	String pattern = "([0-9]+(?=,?))+";
	
	Pattern pat = Pattern.compile(pattern);
	
	String str;
	
	public StringCalculator(){}
	
	public int add(String numbers)
	{
		
		Matcher m = pat.matcher(numbers);
		
		List<String> ms = new ArrayList<String>();
		
		while (m.find()) {ms.add(m.group());}
		
		int sum = 0;
		
		for (String n : ms) {
			
			sum += Integer.parseInt(n);
			
		}
		
		return sum;
		
	}
	
}