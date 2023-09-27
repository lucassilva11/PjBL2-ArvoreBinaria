package arvoreBinaria;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria ab = new ArvoreBinaria();

		ab.incluir(14);
		ab.incluir(15);
		ab.incluir(4);
		ab.incluir(9);
		ab.incluir(7);
		ab.incluir(18);
		ab.incluir(3);
		ab.incluir(5);
		ab.incluir(16);
		ab.incluir(20);
		ab.buscar(14);
		ab.remover(3, true);
	}

}
