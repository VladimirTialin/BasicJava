
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class PolishNotation
{
	public static int Predicate(String symbol){
		if (symbol.equals("^")) return 1;
		else if (symbol.equals("*") ||
		 		 symbol.equals("/")) return 2; 
		else if (symbol.equals("+") ||
				 symbol.equals("-")) return 3;
		else return 4;
		}

	private static boolean isDigit(String s) throws NumberFormatException {
		try {
			Integer.parseInt(s);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
			}
		}
		
	private static boolean isDigitOrLetter(String str) {
		char symbol=str.charAt(0);
		if (Character.isDigit(symbol) || 
			Character.isLetter(symbol)) return true;
			else return false;
    }
	
	private static boolean ErrorInExpression(String [] array) {
		int count=0;
		for (String item : array) {
			if(isDigit(item)) count++;
		}
		if (count==0) return false;
		else return true;
	}

	public static String Postfix(String[] infix){
		LinkedList<String> deque = new LinkedList<>();
		StringBuilder postfix = new StringBuilder();
		if (ErrorInExpression(infix) == false)
		return "Ошибка! Выражение составлено не верно.";
		for (String item: infix) {
			if (item.equals("(")) {
				deque.addFirst(item);
			}
			else if (item.equals(")")){
				while (!deque.peek().equals("(")) {
					postfix.append(deque.pop()).append(" ");
				}
				 deque.pop();
			}
			else if (isDigitOrLetter(item)) {
				postfix.append(item).append(" ");
			}
			else {
				while (!deque.isEmpty() && Predicate(item) >= Predicate(deque.peek())) {
					postfix.append(deque.pop()).append(" ");
				}
				deque.addFirst(item);
			}
		}
		while (!deque.isEmpty()) {
			postfix.append(deque.pop()).append(" ");;
		}	
		return postfix.toString();
	}

	public static void Calc(String str){
	LinkedList<Double> linkedlist = new LinkedList<>();
	String[] exp=str.split(" ");
	double result=0;
	try{
		for (int i = 0; i < exp.length; i++) {

		if (isDigit(exp[i])) {
			linkedlist.push(Double.parseDouble(exp[i]));
		} else {
			switch (exp[i]) {
				case "+":
					result = linkedlist.pop() + linkedlist.pop();
					linkedlist.push(result);
					break;
				case "-":
					result = -linkedlist.pop() + linkedlist.pop();
					linkedlist.push(result);
					break;
				case "*":
					result = linkedlist.pop() * linkedlist.pop();
					linkedlist.push(result);
					break;
				case "/":
					double temp=linkedlist.pop();
					if (temp!=0){
						result =  linkedlist.pop()/ temp;
						linkedlist.push(result);
						break;
					}
					else{
						System.out.println("Делить на ноль нельзя!");
						break;
					}
				case "^":
				double pow = linkedlist.pop();
				double number = linkedlist.pop();
				result = Math.pow(number, pow);
				linkedlist.push(result);
					break;
			}
		}
	}
		System.out.printf("%s = %.2f\n", str,linkedlist.pop());
	}
	catch (NoSuchElementException ex)
	{
		System.out.println("Ошибка! Данное выражение не может быть вычислено.");
	}
}

private static String FormatString(String str) {
	int count=0;
	int bracket=0;
	str=str.trim();
	for (char item: str.toCharArray()) {
		if(item==' ')count++;
		if (item=='(' || item==')') bracket++;
	}
	if (count == 0 || count % 2 == 1)
	{
	str=str.replaceAll("\\s","");
	str=str.replace("+"," + ")
		       .replace("-"," - ")
		       .replace("/"," / ")
	           .replace("*"," * ")
		       .replace("^"," ^ ");
	}
	if (bracket%2==0){
		str=str.replace("(","( ")
		       .replace(")"," )");
	}
	else str="Невозможно отредактировать строку! Не хватает скобок.";
	return str;
	}

	public static String Expression() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Введите выражение: ");
			String expression=scanner.nextLine();
			return expression;
		}
	}
	public static void main(String[] args)
	{
		String infix = Expression();
		String[] str=FormatString(infix).split(" ");
		System.out.printf("Обратная польская нотация: %s\n",Postfix(str));
		Calc(Postfix(str));


	}
}