package modelo;
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;
    private String login;
    private String email;
    private String fone;
    private String cpf;
    private String dataN;
    private String nomeM;
    private String dataI;
    private String dataA;

    public Usuario() {
    }

    //Dados da tabela usuarios
    public Usuario(int id, String nome, String senha, String login, String email, String fone, String cpf, String dataN, String nomeM, String dataI, String dataA) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.email = email;
        this.fone = fone;
        this.cpf = cpf;
        this.dataN = dataN;
        this.nomeM = nomeM;
        this.dataI = dataI;
        this.dataA = dataA;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }

    public String getNomeM() {
        return nomeM;
    }

    public void setNomeM(String nomeM) {
        this.nomeM = nomeM;
    }

    public String getDataI() {
        return dataI;
    }

    public void setDataI(String dataI) {
        this.dataI = dataI;
    }

    public String getDataA() {
        return dataA;
    }

    public void setDataA(String dataA) {
        this.dataA = dataA;
    }

    

    
    
    
}
