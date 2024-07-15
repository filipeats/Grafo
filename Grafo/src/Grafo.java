import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	// Propriedades da classe
	private boolean[][] grafo = null;
	
	// Método construtor da classe
	public Grafo(int qtdVertices) {
		grafo = new boolean[qtdVertices][qtdVertices];
	}
	
	// Métodos da classe
	public void criar(boolean sorteio) throws Exception {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0 ; i < (grafo.length - 1) ; i++) {
			for (int j = (i + 1) ; j < grafo.length ; j++) {
				boolean aresta = (((int) (10 * Math.random())) == 0);
				
				if (! sorteio) {
					System.out.print("Digite <S> se há uma aresta entre " + i + " e " + j + ": ");
					aresta = (leitor.readLine().equalsIgnoreCase("S"));
				}
				
				grafo[i][j] = aresta;
				grafo[j][i] = aresta;
			}
		}
	}
	
	boolean procurarPercursoRecursivo(boolean visitado[], int inicio, int fim) {
		boolean retorno = false;
		
		if (inicio == fim) {
			retorno = true;
		} else {
			visitado[inicio] = true;
			
			for (int vizinho = 0 ; vizinho < grafo.length ; vizinho++) {
				if ((grafo[inicio][vizinho]) && (! visitado[vizinho])) {
					if (procurarPercursoRecursivo(visitado, vizinho, fim)) {
						retorno = true;
						System.out.print(vizinho + " <- ");
						break;
					}
				}
			}
		}
		
		return retorno;
	}
	
	boolean procurarPercurso(int inicio, int fim) {
		boolean[] visitado = new boolean[grafo.length];
		
		boolean encontrei = procurarPercursoRecursivo(visitado, inicio, fim);
		System.out.println(inicio);
		
		return encontrei;
	}
}