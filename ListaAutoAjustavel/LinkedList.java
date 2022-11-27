package ListaAutoAjustavel;

public class LinkedList {
  No primeiro = null;

  public No getPrimeiro() {
    return primeiro;
  }

  public void inserir(String chave, String valor, int cf) {
    No novo = new No();
    novo.chave = chave;
    novo.valor = valor;
    novo.cf = cf;

    if (this.primeiro == null) {
      primeiro = novo;
    } else {
      No atual = primeiro;
      if (atual.chave.equals(chave)) {
        atual.valor = valor;
        return;
      }

      while (atual.proximo != null) {
        atual = atual.proximo;
        if (atual.chave.equals(chave)) {
          atual.valor = valor;
          return;
        }
      }
      atual.proximo = novo;
    }

  }

  public No buscarTR(String chave) {
    System.out.println("Buscando: " + chave);
    return this.buscarTR(primeiro, chave);
  }

  private No buscarTR(No l, String chave) {
    No atual, anterior = null;
    No temp;

    for (atual = l; atual != null; atual = atual.proximo) {
      if (atual.chave.equals(chave)) {
        atual.cf = atual.cf + 1;

        if (!atual.chave.equals(this.primeiro.chave) && atual.cf > anterior.cf) {
          temp = anterior;

          anterior.chave = atual.chave;
          anterior.valor = atual.valor;
          anterior.cf = atual.cf;

          atual.chave = temp.chave;
          atual.valor = temp.valor;
          atual.cf = temp.cf;

          return anterior;
        }
        return atual;
      }
      anterior = atual;
    }

    return null;
  }

  public void imprimir() {
    this.imprimir(this.primeiro);
  }

  private void imprimir(No l) {
    No atual = l;
    while (atual != null) {
      System.out.println("Chave: " + atual.chave + " Frequência: " + atual.cf);
      atual = atual.proximo;
    }
    System.out.println();
  }
}
