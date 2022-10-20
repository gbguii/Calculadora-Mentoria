package br.com.gbgui.ClassAbove;

import java.util.List;
import java.util.Scanner;

import br.com.gbgui.menu.menuView;

public abstract class AbstractClass {

	protected static Scanner sc = new Scanner(System.in);
	
	public abstract void init();
	public Integer optionSelected = 0;
	
	protected void printResult(String msg, double result) {
		System.out.println("\n"+ msg + this.defineNumberFormat(result));
	}
	
	protected void printOptions(List<String> list) {
		System.out.println("\nSelecione a op��o: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " - " + list.get(i));
		}
		System.out.print("Digite a op��o: ");
	}
	
	protected void isContinue() {
		System.out.print("\nDeseja reliazar uma nova conta ? S/N: ");
		try {
			String confirm = sc.next();
			if (isConfirm(confirm)) {
				this.optionSelected = 0;
				this.init();
			} else if(!isConfirm(confirm)){
				System.out.print("\nDeseja voltar ao menu inicial ? S/N: ");
				String confirmToMenu = sc.next();
				if(isConfirm(confirmToMenu)) {
					menuView mv = new menuView();
				}else {
					throw new Exception();
				}
			}
		}catch(Exception e) {
			sc.nextLine();
			System.out.println("At� mais!");
		}
	}
	
	
	private boolean isConfirm(String value) {
		boolean result = false;
		if (!value.isEmpty() || value != null) {
			if (value.equalsIgnoreCase("s") || value.equalsIgnoreCase("sim")) {
				result = true;
			}
		}    
		return result;
	}
	
	
	private String defineNumberFormat(Double value) {
		String result = "";
		if (value != null) {
			String valueToString = value.toString();
			if (valueToString.endsWith(".00")) {
				result = valueToString.replace(".00", "");
			}else if(valueToString.endsWith(".0")){
				result = valueToString.replace(".0", "");
			}else if(valueToString.contains("E")) {
				result = String.format("%.0f", value);
			}else {
				result = String.format("%.2f", value);
			}
		}
		return result;
	}
}
