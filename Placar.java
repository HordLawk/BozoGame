public class Placar {
    private int posicoes[];

    public Placar(){
        this.posicoes = new int[10];
        for(int i = 0; i < this.posicoes.length; i++) this.posicoes[i] = -1;
    }

    public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException{
        int index = posicao - 1;
        if(posicoes[index] != -1) throw new java.lang.IllegalArgumentException("Posição ocupada");
        posicoes[index] = 0;
        if(posicao < 7){
            for(int i = 0; i < dados.length; i++) if(dados[i] == posicao) posicoes[index] += dados[i];
        }
        else{
            switch(posicao){
                case 7:{
                    int rep1 = 1;
                    int n2 = -1;
                    for(int i = 1; i < dados.length; i++){
                        if(dados[i] == dados[0]){
                            rep1++;
                        }
                        else{
                            n2 = dados[i];
                        }
                    }
                    int rep2 = 0;
                    for(int i = 0; i < dados.length; i++) if(dados[i] == n2) rep2++;
                    posicoes[index] = ((rep1 == 5) || ((rep1 == 2) && (rep2 == 3)) || ((rep1 == 3) && (rep2 == 2))) ? 15 : 0;
                }
                break;
                case 8:{
                    int reps[] = new int[6];
                    for(int i = 1; i < 7; i++) for(int k = 0; k < dados.length; k++) if(dados[k] == i) reps[i - 1]++;
                    int certos = 0;
                    for(int i = 0; (i < 5) && (reps[i] == 1); i++) certos++;
                    if(certos == 5){
                        posicoes[index] = 20;
                    }
                    else{
                        certos = 0;
                        for(int i = 1; (i < 6) && (reps[i] == 1); i++) certos++;
                        posicoes[index] = (certos == 5) ? 20 : 0;
                    }
                }
                break;
                case 9:{
                    int rep1 = 1;
                    int n2 = -1;
                    for(int i = 1; i < dados.length; i++){
                        if(dados[i] == dados[0]){
                            rep1++;
                        }
                        else{
                            n2 = dados[i];
                        }
                    }
                    int rep2 = 0;
                    for(int i = 0; i < dados.length; i++) if(dados[i] == n2) rep2++;
                    posicoes[index] = ((rep1 > 3) || (rep2 == 4)) ? 30 : 0;
                }
                break;
                case 10:{
                    int i;
                    for(i = 1; (i < dados.length) && (dados[i] == dados[0]); i++);
                    posicoes[index] = (i == dados.length) ? 40 : 0;
                }
                break;
            }
        }
    }

    public int getScore(){
        int soma = 0;
        for(int i = 0; i < posicoes.length; i++) if(posicoes[i] != -1) soma += posicoes[i];
        return soma;
    }

    public String toString(){
        return String.format("%s    |   %s    |   %s\n", posicaoString(0), posicaoString(6), posicaoString(3)) +
                             "--------------------------\n" +
               String.format("%s    |   %s    |   %s\n", posicaoString(1), posicaoString(7), posicaoString(4)) +
                             "--------------------------\n" +
               String.format("%s    |   %s    |   %s\n", posicaoString(2), posicaoString(8), posicaoString(5)) +
                             "--------------------------\n" +
               String.format("      |   %s    |\n", posicaoString(9)) +
                             "      +---------+";
    }

    private String posicaoString(int index){
        return (posicoes[index] == -1) ? String.format("(%s)", index + 1) : String.format("%s", posicoes[index]);
    }
}
