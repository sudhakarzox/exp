package scratch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class upi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern;
		Matcher matcher;
		
		List<String> trans=new ArrayList<String>();
		trans.add("Dear UPI user A/C X3418 debited by 150.0 on date 11May24 trf to Payu Payments Pv Refno 413255929744. If not u? call 1800111109. -SBI");
		trans.add("Dear UPI user A/C X3418 debited by 35000.0 on date 26Dec23 trf to V  Gowtham Refno 372656540646. If not u? call 1800111109. -SBI");
		trans.add("Dear UPI user A/C X3418 debited by 10000.0 on date 25Dec23 trf to YESHWANTH GOWDA Refno 335971824792. If not u? call 1800111109. -SBI");
		trans.add("Dear SBI UPI User, ur A/cX3418 credited by Rs270 on 12May24 by  (Ref no 413370665282)");
		trans.add("ICICI Bank Acct XX372 debited for Rs 2050.00 on 16-Feb-23, SANJAY N  credited. UPI:304759178114. Call 18002662 for dispute/SMS BLOCK 372 to 9215676766.");
		
		String s;
		
		
		 for(int i=0;i<trans.size();i++) {
			 
		s=trans.get(i);
		
		 pattern = Pattern.compile("UPI", Pattern.CASE_INSENSITIVE);
		 matcher = pattern.matcher(s);
		 
		 if(matcher.find()) { 
			 T t=new T(); 
			 pattern = Pattern.compile("debited", Pattern.CASE_INSENSITIVE);
			 matcher = pattern.matcher(s);
			 
			 if(matcher.find()) {
				 t.type="debit";
			 }else {
				 t.type="credit";
			 }
			 
			 pattern = Pattern.compile("(\\d*\\.0)", Pattern.CASE_INSENSITIVE);
			 matcher = pattern.matcher(s);
			 
			 if(matcher.find()) {
				 t.amt=Float.parseFloat(s.substring(matcher.start(), matcher.end()));
			 }
			 
			 pattern = Pattern.compile("(Rs[\\s\\.]*[\\d\\,\\.]*)", Pattern.CASE_INSENSITIVE);
			 matcher = pattern.matcher(s);
			 
			 if(matcher.find()) {
				 t.amt=Float.parseFloat(s.substring(matcher.start()+2, matcher.end()));
			 }
			 
			 pattern = Pattern.compile("(\\d{2}-?[A-Za-z]{3}-?\\d{2})", Pattern.CASE_INSENSITIVE);
			 matcher = pattern.matcher(s);
			 
			 if(matcher.find()) {
				 t.date=s.substring(matcher.start(), matcher.end());
			 }
			 
			 
			 
			 System.out.println(t);
		 
		 }
		 }
		 
		
		
		
	}

	

}

class T{
	Float amt;
	String type;
	String date;
	String account;
	@Override
	public String toString() {
		return "T [amt=" + amt + ", type=" + type + ", date=" + date;
	}
}
