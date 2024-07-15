package med.voll.api.model;

public record DadosEndereco(String logradouro, Integer numero, String complemento,
                            String bairro, String cidade, String uf, String cep) {
}
