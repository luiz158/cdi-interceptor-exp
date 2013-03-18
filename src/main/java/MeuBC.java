/**
 * Esta é a classe que você criou no seu projeto, porém em tempo de execução a classe instanciada é outra: uma classe
 * criada pelo Weld em tempo de execução que delega as chamadas para esta sua classe.
 */
public class MeuBC {

	/**
	 * Supondo que o metodo1 esteja anotado com @Transaction (ou qualquer outro interceptor)
	 */
	public void metodo1() {
		PilhaExecucao.colocar("MeuBC.metodo1()");
		metodo2();
	}

	/**
	 * Supondo que o metodo2 esteja anotado com @Transaction (ou qualquer outro interceptor)
	 */
	public void metodo2() {
		PilhaExecucao.colocar("MeuBC.metodo2()");
	}
}
