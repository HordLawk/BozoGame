import java.util.concurrent.TimeUnit;

public class RolaDados {
    private int dados[];

    public RolaDados(int n){
        dados = new int[n];
        Dado d = new Dado();
        for(int i = 0; i < dados.length; i++){
            dados[i] = d.rolar();
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }

    public static void main(java.lang.String[] args) throws java.lang.Exception{
        RolaDados rd = new RolaDados(5);
        System.out.printf("%s\n", rd.toString());
        int ds[] = rd.rolar();
        for(int i = 0; i < ds.length; i++) System.out.printf("%s ", ds[i]);
        System.out.println();
        boolean a[] = {false, false, true, false, true};
        ds = rd.rolar(a);
        for(int i = 0; i < ds.length; i++) System.out.printf("%s ", ds[i]);
        System.out.println();
        ds = rd.rolar("3 5 7");
        for(int i = 0; i < ds.length; i++) System.out.printf("%s ", ds[i]);
        System.out.println();
        System.out.printf("%s\n", rd.toString());
    }

    public int[] rolar(){
        Dado d = new Dado();
        for(int i = 0; i < dados.length; i++){
            dados[i] = d.rolar();
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch(InterruptedException e){}
        }
        return dados;
    }

    public int[] rolar(boolean[] quais){
        Dado d = new Dado();
        for(int i = 0; i < dados.length; i++){
            if(quais[i] == false) continue;
            dados[i] = d.rolar();
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch(InterruptedException e){}
        }
        return dados;
    }

    public int[] rolar(String s){
        String[] strs = s.split(" ");
        Dado d = new Dado();
        for(int i = 0; i < strs.length; i++){
            int index;
            try{
                index = Integer.parseInt(strs[i], 10) - 1;
            }
            catch(NumberFormatException e){
                continue;
            }
            if(index >= dados.length) continue;
            dados[index] = d.rolar();
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch(InterruptedException e){}
        }
        return dados;
    }

    public String toString(){
        String lines[] = new String[6];
        for(int i = 0; i < lines.length; i++) lines[i] = "";
        for(int i = 0; i < dados.length; i++){
            lines[0] += String.format(" %s         ", i + 1);
            lines[1] +=               "+-----+    ";
            switch(dados[i]){
                case 1:{
                    lines[2] +=       "|     |    ";
                    lines[3] +=       "|  *  |    ";
                    lines[4] +=       "|     |    ";
                }
                break;
                case 2:{
                    lines[2] +=       "|*    |    ";
                    lines[3] +=       "|     |    ";
                    lines[4] +=       "|    *|    ";
                }
                break;
                case 3:{
                    lines[2] +=       "|*    |    ";
                    lines[3] +=       "|  *  |    ";
                    lines[4] +=       "|    *|    ";
                }
                break;
                case 4:{
                    lines[2] +=       "|*   *|    ";
                    lines[3] +=       "|     |    ";
                    lines[4] +=       "|*   *|    ";
                }
                break;
                case 5:{
                    lines[2] +=       "|*   *|    ";
                    lines[3] +=       "|  *  |    ";
                    lines[4] +=       "|*   *|    ";
                }
                break;
                case 6:{
                    lines[2] +=       "|*   *|    ";
                    lines[3] +=       "|*   *|    ";
                    lines[4] +=       "|*   *|    ";
                }
                break;
            }
            lines[5] +=               "+-----+    ";
        }
        return String.join("\n", lines);
    }
}
