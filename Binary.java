package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0";
				return;
			}
		}
	
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		if (this.number.isEmpty()) {
			this.number = "0";
		}
  	}
	
	public String getValue()
	{
		return this.number;
	}
	
	public static Binary add(Binary num1,Binary num2)
	{
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		int carry=0;
		String num3="";
		while(ind1>=0 ||  ind2>=0 || carry!=0)
		{
			int sum=carry;
			if(ind1>=0){
				sum += (num1.number.charAt(ind1)=='1')? 1:0;
				ind1--;
			}
			if(ind2>=0){
				sum += (num2.number.charAt(ind2)=='1')? 1:0;
				ind2--;
			}
			carry=sum/2;
			sum=sum%2;
			num3 =( (sum==0)? "0":"1")+num3;
		}
		Binary result=new Binary(num3);
		return result;
	}

	public static Binary or(Binary a, Binary b) {
		String result = "";
		int maxLength = Math.max(a.getValue().length(), b.getValue().length());
		a = new Binary(padBinary(a.getValue(), maxLength));
		b = new Binary(padBinary(b.getValue(), maxLength));
		for (int i = 0; i < maxLength; i++) {
			char bitA = a.getValue().charAt(i);
			char bitB = b.getValue().charAt(i);
			result += (bitA == '1' || bitB == '1') ? '1' : '0';
		}
		return new Binary(result);
	}

	public static Binary and(Binary a, Binary b) {
		String result = "";
		int maxLength = Math.max(a.getValue().length(), b.getValue().length());
		a = new Binary(padBinary(a.getValue(), maxLength));
		b = new Binary(padBinary(b.getValue(), maxLength));
		for (int i = 0; i < maxLength; i++) {
			char bitA = a.getValue().charAt(i);
			char bitB = b.getValue().charAt(i);
			result += (bitA == '1' && bitB == '1') ? '1' : '0';
		}
		return new Binary(result);
	}

	public static Binary multiply(Binary a, Binary b) {
		Binary result = new Binary("0");
		for (int i = b.getValue().length() - 1; i >= 0; i--) {
			if (b.getValue().charAt(i) == '1') {
				result = add(result, new Binary(a.getValue() + "0".repeat(b.getValue().length() - 1 - i)));
			}
		}
		return result;
	}

	private static String padBinary(String binary, int length) {
		StringBuilder padded = new StringBuilder(binary);
		while (padded.length() < length) {
			padded.insert(0, '0'); // Add leading zeros
		}
		return padded.toString();
	}
}
