public class MeuBC__WeldProxy extends MeuBC {

	private MeuBC delegate;

	@Override
	public void metodo1() {
		delegate.metodo1();
	}

	@Override
	public void metodo2() {
		delegate.metodo2();
	}

	@Override
	public void metodo3() {
		delegate.metodo3();
	}
}
