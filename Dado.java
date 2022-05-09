public class Dado {
    private int lados;
    private int ladoSelecionado;

    public Dado(){
        this.lados = 6;
    }

    public Dado(int n){
        this.lados = n;
    }

    public int getLado(){
        return ladoSelecionado;
    }

    public static void main(String[] args) throws InterruptedException{
        Dado d = new Dado();
        d.rolar();
        System.out.printf("%s\n", d);
    }

    public int rolar(){
        Random r = new Random();
        ladoSelecionado = r.getIntRand(lados) + 1;
        return ladoSelecionado;
    }

    public String toString(){
        String str =   "+-----+\n";
        switch(ladoSelecionado){
            case 1:{
                str += "|     |\n" +
                       "|  *  |\n" +
                       "|     |\n";
            }
            break;
            case 2:{
                str += "|*    |\n" +
                       "|     |\n" +
                       "|    *|\n";
            }
            break;
            case 3:{
                str += "|*    |\n" +
                       "|  *  |\n" +
                       "|    *|\n";
            }
            break;
            case 4:{
                str += "|*   *|\n" +
                       "|     |\n" +
                       "|*   *|\n";
            }
            break;
            case 5:{
                str += "|*   *|\n" +
                       "|  *  |\n" +
                       "|*   *|\n";
            }
            break;
            case 6:{
                str += "|*   *|\n" +
                       "|*   *|\n" +
                       "|*   *|\n";
            }
            break;
        }
        str +=         "+-----+";
        return str;
    }
}
