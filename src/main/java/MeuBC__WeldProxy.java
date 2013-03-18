/**
 * Classe criada pelo Weld em tempo de execução utilizando o recurso CtNewMethod.delegator(...) do Javassist.
 */
public class MeuBC__WeldProxy extends MeuBC {

	/**
	 * Referência à classe MeuBC do seu projeto.
	 */
	private MeuBC delegate = new MeuBC();

	/**
	 * O Weld percebe que o método MeuBC.metodo1() possui a anotação @Transaction e incrementa código antes e depois da
	 * chamada à instância real. Esta é uma explicação simplificada do seu funcionamento!
	 */
	@Override
	public void metodo1() {
		PilhaExecucao.colocar("MeuBC__WeldProxy.metodo1()");
		delegate.metodo1();
	}

	/**
	 * Ocorre a mesma situação do metodo1().
	 */
	@Override
	public void metodo2() {
		PilhaExecucao.colocar("MeuBC__WeldProxy.metodo2()");
		delegate.metodo2();
	}
}
