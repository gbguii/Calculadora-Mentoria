package br.com.gbgui.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.gbgui.ClassAbove.AbstractClass;
import br.com.gbgui.ClassAbove.InterfaceClass;

public class CalculatorView extends AbstractClass implements InterfaceClass{
	
	private static List<String> optionsCalculator = Arrays.asList("Soma", "Subtra��o", "Multiplica��o", "Divis�o",
			"Potencia��o");
	
	private Double firstValue;
	private Double secondValue;

	public CalculatorView() {
		System.out.println("\n********** Calculadora **********");
		this.init();
	}
	
	@Override
	public void init() {
		while (optionSelected == 0) {
			this.printOptions(optionsCalculator);
			try {
				optionSelected = sc.nextInt();
				if (optionSelected <= 0 || optionSelected > optionsCalculator.size()) {
					throw new Exception();
				}
			} catch (Exception e) {
				optionSelected = 0;
				System.out.println("\nops... essa op��o n�o existe");
				sc.nextLine();
			}
		}
		this.getValues();
		this.calculate(firstValue, secondValue, this.optionSelected);
	}
	
	@Override
	public void getValues() {
		int control = 0;
		while (control == 0) {
			try {
				System.out.print("Digite o primeiro valor: ");
				this.firstValue = sc.nextDouble();
				System.out.print("Digite o segundo valor: ");
				this.secondValue = sc.nextDouble();
				control = 10;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("\n� permitido apenas n�meros...");
			}
		}
	}
	
	@Override
	public void calculate(Double firstValue, Double secondValue, int option) {
		if(option == 1) {
			Double result = firstValue + secondValue;
			this.printResult("Resultado da soma:", result);
		}else if(option == 2) {
			Double result = firstValue - secondValue;
			this.printResult("Resultado da subtra��o: ", result);
		}else if(option == 3) {
			Double result = firstValue * secondValue;
			this.printResult("Resultado da multiplica��o: ", result);
		}else if(option == 4) {
			Double result = firstValue / secondValue;
			this.printResult("Resultado da divis�o: ", result);
		}else if(option == 5) {
			Double result = Math.pow(firstValue, secondValue);
			this.printResult("Resultado da potencia��o: ", result);
		}
		this.isContinue();
	}


}
