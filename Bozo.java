import java.io.IOException;

public class Bozo {
    public static void main(String args[]) throws IOException{
        Placar p = new Placar();
        RolaDados rd = new RolaDados(5);
        System.out.printf("%s\n\n", p);
        for(int i = 1; i < 11; i++){
            System.out.printf("****** Rodada %s\n" +
                              "Pressione ENTER para lançar os dados\n", i);
            EntradaTeclado.leString();
            int dados[] = rd.rolar();
            for(int k = 0; k < 2; k++){
                System.out.printf("%s\n\n" +
                                  "Digite os números dos dados que quiser TROCAR. Separados por espaços.\n", rd);
                dados = rd.rolar(EntradaTeclado.leString());
            }
            System.out.printf("%s\n\n\n\n" +
                              "%s\n\n" +
                              "Escolha a posição que quer ocupar com essa jogada ===> ", rd, p);
            while(true){
                try{
                    int pos = EntradaTeclado.leInt();
                    p.add(pos, dados);
                    break;
                }
                catch(Exception e){
                    System.out.printf("Posição inválida\n" +
                                      "Escolha a posição que quer ocupar com essa jogada ===> ");
                }
            }
            System.out.printf("\n\n\n" +
                              "%s\n\n", p);
        }
        System.out.printf("***********************************\n" +
                          "***\n" +
                          "*** Seu escore final foi: %s\n" +
                          "***\n" +
                          "***********************************\n", p.getScore());     
    }
}
