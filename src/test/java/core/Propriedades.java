package core;

public class Propriedades {

    public static boolean FECHAR_BROWSER = true;

    public static Browser BROWSER = Browser.FIREFOX;

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;

    public enum Browser {
        CHROME,
        FIREFOX
    }

    public enum TipoExecucao {
        LOCAL,
        GRID
    }
}
