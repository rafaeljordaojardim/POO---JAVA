package projectExceptions;

public class MinhasExceptions extends Exception {

    private int cod;

    public MinhasExceptions( int cod) {
        this.cod = cod;
    }

    @Override
    public String getMessage() {
        String mensagem = "";
        switch (cod){
            case 1:
                    mensagem = "Digite um número inteiro!";
               break;
            case 2:
                    mensagem = "Digite um valor positivo";
                break;
            case 3:
                mensagem = "O estado deve conter dois caracteres. Ex: 'SP'";
                break;
        }
        return mensagem;
    }

}
