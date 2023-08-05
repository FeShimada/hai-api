package org.acme.enumerations;

public enum DiaSemana {
    DOMINGO(0),
    SEGUNDA(1),
    TERCA(2),
    QUARTA(3),
    QUINTA(4),
    SEXTA(5),
    SABADO(6);

    private final int value;

    private DiaSemana(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DiaSemana valueOf(int valor) {
        switch (valor) {
            case 0: return DOMINGO;
            case 1: return SEGUNDA;
            case 2: return TERCA;
            case 3: return QUARTA;
            case 4: return QUINTA;
            case 5: return SEXTA;
            case 6: return SABADO;
            default:
                throw new IllegalArgumentException("Valor inválido para DiaSemana: " + valor);
        }
    }

}
