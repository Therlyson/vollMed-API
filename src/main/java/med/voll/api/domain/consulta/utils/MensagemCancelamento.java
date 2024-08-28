package med.voll.api.domain.consulta.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MensagemCancelamento {
    PACIENTE_DESISTIU("Paciente desistiu"),
    MEDICO_CANCELOU("Médico cancelou"),
    OUTROS("Outros");

    private final String mensagem;

    MensagemCancelamento(String mensagem) {
        this.mensagem = mensagem;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.mensagem;
    }

    @JsonCreator
    public static MensagemCancelamento fromString(String mensagem) {
        for (MensagemCancelamento m : MensagemCancelamento.values()) {
            if (m.mensagem.equalsIgnoreCase(mensagem)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Não é um motivo válido: " + mensagem + "\nMotivos válidos: " + MensagemCancelamento.MEDICO_CANCELOU
                + ", " + MensagemCancelamento.PACIENTE_DESISTIU + ", " + MensagemCancelamento.OUTROS);
    }
}
