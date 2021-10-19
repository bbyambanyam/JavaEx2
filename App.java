package App;
import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {
        //File ruu bichih
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fout = new FileOutputStream("array1.dat");
        DataOutputStream dout = new DataOutputStream(fout);

        FileOutputStream fout2 = new FileOutputStream("array2.dat");
        DataOutputStream dout2 = new DataOutputStream(fout2);

        FileOutputStream fout3 = new FileOutputStream("array3.dat");
        DataOutputStream dout3 = new DataOutputStream(fout3);

        int randomNumber = 0;
        for(int i=1;i<=3;i++) {
            randomNumber = getRandomNumber(1, 100);
            dout.writeInt(randomNumber);
        }

        for(int i=1;i<=3;i++) {
            randomNumber = getRandomNumber(1, 100);
            dout2.writeInt(randomNumber);
        }

        for(int i=1;i<=3;i++) {
            randomNumber = getRandomNumber(1, 100);
            dout3.writeInt(randomNumber);
        }
        // Closing binary file object
        fout.close();
        dout.close();

        fout2.close();
        dout2.close();

        fout3.close();
        dout3.close();
        
        ob.close();

        //File aas unshij niilber awah
        int sum1 = sumOfArray("array1.dat");
        int sum2 = sumOfArray("array2.dat");
        int sum3 = sumOfArray("array3.dat");
        
        int maxNumber = maxOfThree(sum1, sum2, sum3);
            FileOutputStream foutR = new FileOutputStream("result.txt");
            DataOutputStream doutR = new DataOutputStream(foutR);
            
            DataInputStream in = new DataInputStream(new FileInputStream("array1.dat"));
            while(in.available()>0)
            {   
                doutR.writeInt(in.readInt());
            }
            in.close();

            foutR.close();
            doutR.close();

        if (maxNumber == sum1){
            Writer wr = new FileWriter("result.txt");
    
            DataInputStream in11 = new DataInputStream(new FileInputStream("array1.dat"));
            while(in11.available()>0)
            {   
                wr.write(String.valueOf(in11.readInt()));
            }
            in11.close();
            wr.close();
        }else if(maxNumber == sum2){
            Writer wr = new FileWriter("result.txt");
            
            DataInputStream in22 = new DataInputStream(new FileInputStream("array2.dat"));
            while(in22.available()>0)
            {   
                wr.write(String.valueOf(in22.readInt()));
            }
            in22.close();
            wr.close();
        }else{
            Writer wr = new FileWriter("result.txt");
            
            DataInputStream in33 = new DataInputStream(new FileInputStream("array3.dat"));
            while(in33.available()>0)
            {   
                wr.write(String.valueOf(in33.readInt()));
            }
            wr.close();
            in33.close();
        }


    }
    static int sumOfArray(String filename) throws FileNotFoundException, IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(filename));
        int sum = 0;
        while(in.available()>0)
		{	           
            sum += in.readInt();
        }
        in.close();

        return sum;
    }
    static int maxOfThree(int x, int y, int z)
    {
 
        return z > (x > y ? x : y) ? z : ((x > y) ? x : y);
    }

    static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
