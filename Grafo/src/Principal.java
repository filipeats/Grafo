import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
	public static void main(String[] args) {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		Grafo objGrafo = new Grafo(10000);
		int inicio = 0;
		int fim = 1;
		
		try {
			objGrafo.criar(true);
			
			while (inicio != fim) {
				System.out.print("Digite o início: ");
				inicio = Integer.parseInt(leitor.readLine());
				
				System.out.print("Digite o fim: ");
				fim = Integer.parseInt(leitor.readLine());
				
				if (objGrafo.procurarPercurso(inicio, fim)) {
					System.out.println("ACHEI um caminho !");
				} else {
					System.out.println("NÃO há um caminho !");
				}
			}
		} catch (Exception erro) {}
	}
}