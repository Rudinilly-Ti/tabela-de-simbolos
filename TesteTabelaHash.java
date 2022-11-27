import java.io.BufferedReader;
import java.io.FileReader;

public class TesteTabelaHash {
  public static void main(String[] args) throws Exception {
    TabelaHash tabela = new TabelaHash(51);

    FileReader arquivo = new FileReader("sites.txt");
    BufferedReader leitor = new BufferedReader(arquivo);

    for (int i = 0; i < 25; i++) {
      String linha = leitor.readLine();
      String porta;
      if (i > 9) {
        porta = i + "000";
      } else {
        porta = i + "0000";
      }
      tabela.inserir(linha, "192.168.0." + i + ":" + porta);
    }

    tabela.buscar("www.espn.com.br");

    new Thread();
    Thread.sleep(10000);

    System.out.println("Adicionando mais 25 sites...");
    tabela.aumentarTamanho(101);
    for (int i = 25; i < 50; i++) {
      String linha = leitor.readLine();
      tabela.inserir(linha, "192.168.0." + i + ":" + i + "000");
    }

    tabela.buscar("www.uol.com.br");

    Thread.sleep(10000);

    System.out.println("Adicionando mais 25 sites...");
    tabela.aumentarTamanho(151);
    for (int i = 0; i < 25; i++) {
      String linha = leitor.readLine();
      String porta;
      if (i > 9) {
        porta = i + "000";
      } else {
        porta = i + "0000";
      }
      tabela.inserir(linha, "192.168.1." + i + ":" + porta);
    }

    tabela.buscar("www.never.com.br");

    Thread.sleep(10000);

    System.out.println("Adicionando mais 25 sites...");
    tabela.aumentarTamanho(201);
    for (int i = 25; i < 50; i++) {
      String linha = leitor.readLine();
      tabela.inserir(linha, "192.168.1." + i + ":" + i + "000");
    }

    tabela.buscar("www.always.com.br");

    // Fecha o arquivo
    leitor.close();

    // Imprime a tabela
    tabela.imprimir();

  }
}
