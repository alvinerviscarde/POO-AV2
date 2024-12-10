package gato;

public class Gato {
	// Atributos da classe Gato
    String nome;
    int idade;
    
    // Construtor da classe Gato
    public Gato(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método para imprimir informações sobre o gato
    @Override
    public String toString() {
        return "Gato{nome='" + nome + "', idade=" + idade + "}";
    }
    
    // Método de ordenação Insertion Sort com base na idade do gato
    public static void insertionSort(Gato[] gatos) {
        for (int i = 1; i < gatos.length; i++) {
            Gato chave = gatos[i];
            int j = i - 1;
            
            // Move os elementos maiores para uma posição à frente
            while (j >= 0 && gatos[j].idade > chave.idade) {
                gatos[j + 1] = gatos[j];
                j = j - 1;
            }
            gatos[j + 1] = chave;
        }
    }

    // Método de busca binária para encontrar um gato baseado na idade
    public static int buscaBinaria(Gato[] gatos, int idade) {
        int esquerda = 0;
        int direita = gatos.length - 1;
        
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (gatos[meio].idade == idade) {
                return meio; // Retorna o índice do gato com a idade procurada
            } else if (gatos[meio].idade < idade) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        
        return -1; // Retorna -1 se o gato não for encontrado
    }

    public static void main(String[] args) {
        // Criação de alguns gatos
        Gato[] gatos = {
            new Gato("Mingau", 4),
            new Gato("Tom", 7),
            new Gato("Peludo", 2),
            new Gato("Luna", 5)
        };

        // Imprime a lista de gatos antes da ordenação
        System.out.println("Antes da ordenação:");
        for (Gato gato : gatos) {
            System.out.println(gato);
        }

        // Organiza os gatos pelo método Insertion Sort
        insertionSort(gatos);

        // Imprime a lista de gatos após a ordenação
        System.out.println("\nApós a ordenação por idade:");
        for (Gato gato : gatos) {
            System.out.println(gato);
        }

        // Realiza a busca binária para encontrar um gato com idade 5
        int idadeProcurada = 5;
        int indice = buscaBinaria(gatos, idadeProcurada);
        if (indice != -1) {
            System.out.println("\nGato encontrado: " + gatos[indice]);
        } else {
            System.out.println("\nGato com idade " + idadeProcurada + " não encontrado.");
        }
    }
}
