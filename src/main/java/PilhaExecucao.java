import java.util.Stack;

public class PilhaExecucao {

	private static Stack<String> stack = new Stack<String>();

	public static void colocar(String metodo) {
		stack.push(metodo);
	}

	public static String retirar() {
		return stack.pop();
	}

	public static void limpar() {
		stack.clear();
	}

	public static boolean vazia() {
		return stack.isEmpty();
	}
}
