package med.voll.api.model;

public enum Especialidade {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologia"),
    GINECOLOGIA("ginecologia"),
    DERMATOLOGIA("dermatologia");

    private String especialidadeMinusc;

    Especialidade(String especialidadeMinusc){
        this.especialidadeMinusc = especialidadeMinusc;
    }
}