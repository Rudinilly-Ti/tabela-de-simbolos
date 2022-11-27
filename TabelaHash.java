import ListaAutoAjustavel.LinkedList;
import ListaAutoAjustavel.No;

public class TabelaHash {
  private LinkedList[] tabela;
  private int tamanho;

  public TabelaHash(int tamanho) {
    this.tamanho = tamanho;
    tabela = new LinkedList[tamanho];
    for (int i = 0; i < tamanho; i++) {
      tabela[i] = new LinkedList();
    }
  }

  private int funcaoHash(String chave, int tamanho) {
    int soma = 0;
    for (int i = 0; i < chave.length(); i++) {
      soma += chave.charAt(i);
    }
    return soma % tamanho;
  }

  public void inserir(String chave, String valor) {
    int posicao = funcaoHash(chave, this.tamanho);
    tabela[posicao].inserir(chave, valor, 0);
  }

  public void buscar(String chave) {
    int posicao = funcaoHash(chave, this.tamanho);
    No no = tabela[posicao].buscarTR(chave);
    if (no != null) {
      System.out.println("Ip: " + no.getValor());
    } else {
      System.out.println("Chave não encontrada");
    }
  }

  public void imprimir() {
    for (int i = 0; i < tamanho; i++) {
      System.out.println("Posicao " + i);
      tabela[i].imprimir();
    }
  }

  public void aumentarTamanho(int novoTamanho) {
    LinkedList[] novaTabela = new LinkedList[novoTamanho];
    for (int i = 0; i < novoTamanho; i++) {
      novaTabela[i] = new LinkedList();
    }

    for (int i = 0; i < tamanho; i++) {
      LinkedList lista = tabela[i];
      No atual = lista.getPrimeiro();
      while (atual != null) {
        int posicao = funcaoHash(atual.getChave(), novoTamanho);
        novaTabela[posicao].inserir(atual.getChave(), atual.getValor(), atual.getCf());
        atual = atual.getProximo();
      }
    }

    this.tabela = novaTabela;
    this.tamanho = novoTamanho;
  }
}
