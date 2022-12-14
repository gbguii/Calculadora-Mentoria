package br.com.gbgui.imc;

import br.com.gbgui.ClassAbove.AbstractClass;
import br.com.gbgui.ClassAbove.InterfaceClass;

public class ImcView extends AbstractClass implements InterfaceClass{
	
	Double height = 0.0;
	Double weight = 0.0;
	
	public ImcView() {
		System.out.println("\n********** IMC **********");
		this.init();
	}
	
	@Override
	public void init() {
		this.getValues();
		this.calculate(height, weight, 0);
	}
	
	@Override
	public void getValues() {
		boolean repeat = true;
		while (repeat) {
			try {
				System.out.print("\nDigite a altura: (ex 1,73)  ");
				height = sc.nextDouble();
				System.out.print("Digite o peso: (ex 76,90) ");
				weight = sc.nextDouble();
				if(height < 0 || weight < 0) {
					throw new Exception();
				}
				repeat = false;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("\nops.. esse valor n?o ? permitido");
			}
		}
	}
	
	public String defineDegree(Double value) {
		String result = "";
		if(value < 18.5) {
			result = "Abaixo do peso - IMC: ";
		}else if(value < 25) {
			result = "Peso normal - IMC: ";
		}else if(value < 30) {
			result = "Sobrepeso - IMC: ";
		}else if(value < 35) {
			result = "Obsesidade grau I - IMC: ";
		}else if(value < 40) {
			result = "Obsesidade grau II - IMC: ";
		}else {
			result = "Obsesidade grau III - IMC: ";
		}
		return result;
	}
	
	@Override
	public void calculate(Double firstValue, Double secondValue, int option) {
		// firstValue = height  --  secondValue = weight
		double result = secondValue / (Math.pow(firstValue, 2));
		String msg = defineDegree(result);
		this.printResult(msg, result);
		this.isContinue();
	}
	
	
}
