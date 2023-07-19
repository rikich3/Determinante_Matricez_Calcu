import java.util.*;

public class detMatriz{

    public static void main(String[] args){
        double[][] obj;
        Scanner sc = new Scanner(System.in);
        obj = initMat(4);
        prDoubleMatr(obj);
        System.out.println("La determinante de tal matriz es: " + solve(obj));
    }
    public static double[][] initMat(int size){
        Scanner sc = new Scanner(System.in);
        if(size < 1) return null;
        double[][] obj = new double[size][size];
        for(int i = 0; i < size; i++){
            for(int e = 0; e < size; e++) obj[i][e] = sc.nextDouble();
        }
        return obj;
    }
    private static void prDoubleMatr(double[][] subject){
        for(int i = 0; i < subject.length ; i++){
            for(int e = 0; e < subject[0].length ; e++){
                System.out.print("" + subject[i][e] + " ");
            }
            System.out.println();
        }
    }
    private static double solve(double[][] obj){
        int objlen = obj.length;
        double[] myL = new double[objlen];
        double eldeter = 0;
        if(objlen == 2){
            return (obj[0][0]* obj[1][1]) - (obj[1][0] * obj[0][1]);
        }
        double[][] nless1 = new double[objlen - 1][objlen - 1];
        for(int i = 0; i < objlen; i++){
            //calculamos matriz
            int helpy = 0;
            for(int e = 1; e < objlen; e++){
                helpy = 0;
                for(int a = 0; a < objlen; a++){
                   if(a == i){
                        //a++; 
                        helpy++;
                    }
                    else nless1[e-1][a - helpy] = obj[e][a]; //s
                }
            }
            myL[i] = (i % 2 == 0)? obj[0][i]* solve(nless1): (-1.0) * obj[0][i]* solve(nless1);
        }
        for(double i: myL){
            eldeter += i;
        }
        return eldeter;
    }
}