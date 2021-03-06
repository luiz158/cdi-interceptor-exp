import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MeuBCTest {

	/**
	 * Por debaixo dos panos, simplificadamente é isso que ocorre quando você usa o @Inject.
	 */
	private MeuBC meuBC = new MeuBC__WeldProxy();

	/**
	 * Se você espera isto, perceba que o teste vai falhar.
	 */
	@Test
	public void execucaoEsperadaPorVoce() {
		PilhaExecucao.limpar();

		meuBC.metodo1();

		assertEquals("MeuBC.metodo2()", PilhaExecucao.retirar());
		assertEquals("MeuBC__WeldProxy.metodo2()", PilhaExecucao.retirar());
		assertEquals("MeuBC.metodo1()", PilhaExecucao.retirar());
		assertEquals("MeuBC__WeldProxy.metodo1()", PilhaExecucao.retirar());
		assertEquals(true, PilhaExecucao.vazia());
	}

	/**
	 * Execução esperada de acordo com a implementação do Weld utilizando o Delegator.
	 */
	@Test
	public void execucaoAtualDoWeld() {
		PilhaExecucao.limpar();

		meuBC.metodo1();

		assertEquals("MeuBC.metodo2()", PilhaExecucao.retirar());
		assertEquals("MeuBC.metodo1()", PilhaExecucao.retirar());
		assertEquals("MeuBC__WeldProxy.metodo1()", PilhaExecucao.retirar());
		assertEquals(true, PilhaExecucao.vazia());

		// Porquê a chamada "MeuBC__WeldProxy.metodo2()" não ocorre??? Porque o "MeuBC.metodo1()" invoca diretamente o
		// "MeuBC.metodo2()" sem passar pelo Proxy. A instância delegada simplesmente não conhece o Proxy, só o Proxy
		// que conhece a instância delegada.
	}
}
