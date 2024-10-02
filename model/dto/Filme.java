package br.com.fiap.model.dto;

public class Filme {
    private int codigo;
    private String titulo;
    private String genero;
    private String produtora;

    public Filme() { //construtor com passagem de parâmetro → criar/instanciar vários objetos a partir de uma mesma classe.
    }

    public int getCodigo() { //getters e setters → métodos para acessar e modificar atributos "private" desta classe (bean) em outra classe.
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo; //"this" → referenciar/diferenciar parâmetro do método de mesmo nome do atributo.
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
}
