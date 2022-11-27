package ListaAutoAjustavel;

public class No {
  String chave;
  String valor;
  Integer cf;
  No proximo;

  public No() {
  }

  public No(String chave, String valor, Integer cf, No proximo) {
    this.chave = chave;
    this.valor = valor;
    this.cf = cf;
    this.proximo = proximo;
  }

  public String getChave() {
    return this.chave;
  }

  public void setChave(String chave) {
    this.chave = chave;
  }

  public String getValor() {
    return this.valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public Integer getCf() {
    return this.cf;
  }

  public void setCf(Integer cf) {
    this.cf = cf;
  }

  public No getProximo() {
    return this.proximo;
  }

  public void setProximo(No proximo) {
    this.proximo = proximo;
  }
}