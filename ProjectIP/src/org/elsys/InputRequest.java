package org.elsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InputRequest {
	
	private String formula;
	
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	
	public int doCalculate(String str) {
		str+='.';
		String signs = "";
		String number = "";
		int[] array = new int[20];
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)!='0' && str.charAt(i)!='4' && str.charAt(i)!='7' && 
			   str.charAt(i)!='1' && str.charAt(i)!='5' && str.charAt(i)!='8' && 
			   str.charAt(i)!='2' && str.charAt(i)!='6' && str.charAt(i)!='9' && 
			   str.charAt(i)!='3' && str.charAt(i)!='.') {
				signs+=str.charAt(i);
			}
		}
		
		for (int i = 0, j = 0; i < str.length(); i++) {
			if(str.charAt(i)!='+' && str.charAt(i)!='-' && str.charAt(i)!='*' && str.charAt(i)!='/'
					&& str.charAt(i)!='.') {
				number+=str.charAt(i);
			}
			else {
				array[j] = Integer.parseInt(number);
				number="";
				j++;
			}
		}
		
		int sum = array[0];
		for (int i = 0, j = 1; i < signs.length(); i++,j++) {
			if (signs.charAt(i)=='+') sum+=array[j];
			if (signs.charAt(i)=='-') sum-=array[j];
			if (signs.charAt(i)=='*') sum*=array[j];
			if (signs.charAt(i)=='/') sum/=array[j];
		}
		return sum;
	}
	
	public String doInput() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","surgeon");
		Statement statement = con.createStatement();
		String sql = "INSERT INTO math(data, result) VALUES('" + formula + "','" + doCalculate(formula) + "')";
		statement.executeUpdate(sql);
		return "success";
	}

}
