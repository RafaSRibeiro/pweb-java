package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Pessoa;

@ManagedBean
@ViewScoped
public class PessoaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pessoa pessoa = new Pessoa();

    private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    public void inserePessoa() {
        listaPessoas.add(pessoa);
        pessoa = new Pessoa();
        addMessage("Cadastro", "Pessoa cadastrada com sucesso");
    }

    public Pessoa getPessoa() {

        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {

        this.pessoa = pessoa;
    }

    public List<Pessoa> getListaPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setIdade(35);
        pessoa1.setNome("Rafael Ribeiro");
        pessoa1.setSexo("Masculino");
        pessoas.add(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setIdade(13);
        pessoa2.setNome("Vinícius Martins Ribeiro");
        pessoa2.setSexo("Masculino");
        pessoas.add(pessoa2);

        listaPessoas = pessoas;

        return listaPessoas;
    }

    public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {

        this.listaPessoas = listaPessoas;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
