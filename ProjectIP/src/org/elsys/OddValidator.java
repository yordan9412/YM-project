package org.elsys;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class OddValidator implements Validator {
	public void validate(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {

		final String str = (String) value;
		int counter = 0;
		
		if(str.length() > 30) {
			final FacesMessage message = new FacesMessage("�� ���� ������ �� 30 �������!");
			throw new ValidatorException(message);
		}
		if(str.charAt(0)=='+' || str.charAt(0)=='-' || str.charAt(0)=='*' || str.charAt(0)=='/')  {
			final FacesMessage message = new FacesMessage("������� ������ ������ �� � �����, � �� ��������!");
			throw new ValidatorException(message);
		}

		if(str.charAt(str.length()-1)=='+' || str.charAt(str.length()-1)=='-' || 
			     str.charAt(str.length()-1)=='*' || str.charAt(str.length()-1)=='/')  {
			final FacesMessage message = new FacesMessage("���������� ������ ������ �� � �����, � �� ��������!");
			throw new ValidatorException(message);
		}
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/')
				counter++;
			if(str.charAt(i)!='+' && str.charAt(i)!='-' && str.charAt(i)!='*' && str.charAt(i)!='/' &&
			   str.charAt(i)!='0' && str.charAt(i)!='1' && str.charAt(i)!='2' && str.charAt(i)!='3' &&
			   str.charAt(i)!='4' && str.charAt(i)!='5' && str.charAt(i)!='6' && str.charAt(i)!='7' &&
			   str.charAt(i)!='8' && str.charAt(i)!='9') {
				final FacesMessage message = new FacesMessage("����� ������ ������ �� � ��� ����� ��� 1 �� ���������� / * - +");
				throw new ValidatorException(message);
			}
			else if( (str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/') 
					&& (str.charAt(i+1)=='+' || str.charAt(i+1)=='-' || 
					    str.charAt(i+1)=='*' || str.charAt(i+1)=='/')) {
				final FacesMessage message = new FacesMessage("�� ���� ��� ������� ������� �� �� ��������!");
				throw new ValidatorException(message);
			}
		}
		
		if(counter == 0) {
			final FacesMessage message = new FacesMessage("� ������ ���� �����!");
			throw new ValidatorException(message);
		}

	}
}