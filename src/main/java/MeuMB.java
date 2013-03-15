
public class MeuMB {

	private MeuBC bc;

	public MeuMB() {
		this.bc = new MeuBC__WeldProxy();
	}

	public void metodo1() {
		this.bc.metodo1();
	}
}
