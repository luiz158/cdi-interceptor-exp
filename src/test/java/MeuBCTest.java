import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MeuBCTest {

	/**
	 * Por debaixo dos panos, simplificadamente é isso que ocorre quando você usa o @Inject.
	 */
	private MeuBC meuBC = new MeuBC__WeldProxy();

	/**
	 * Execução esperada de acordo com a implementação do Weld utilizando o Delegator.
	 */
	@Test
	public void execucaoAtual() {
		meuBC.metodo1();

		assertEquals("MeuBC.metodo2()", PilhaExecucao.retirar());
		assertEquals("MeuBC.metodo1()", PilhaExecucao.retirar());
		assertEquals("MeuBC__WeldProxy.metodo1()", PilhaExecucao.retirar());
		assertEquals(true, PilhaExecucao.vazia());
	}
	
	/**
	 * Se você espera isto, perceba que o teste vai falhar.
	 */
	@Test
	public void execucaoEsperadaPorVoce() {
		meuBC.metodo1();
		
		assertEquals("MeuBC.metodo2()", PilhaExecucao.retirar());
		assertEquals("MeuBC__WeldProxy.metodo2()", PilhaExecucao.retirar());
		assertEquals("MeuBC.metodo1()", PilhaExecucao.retirar());
		assertEquals("MeuBC__WeldProxy.metodo1()", PilhaExecucao.retirar());
		assertEquals(true, PilhaExecucao.vazia());
	}
}
