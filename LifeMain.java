import java.io.*;
import java.util.*;

public class LifeMain {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print(
            "Welcome to the CS 132 Game of Life, a simulation of the lifecycle of a bacteria colony.\n\n" +
            "Cells (X) live and die by the following rules:\n- A cell with 1 or fewer neighbors dies.\n- Locations with 2 neighbors remain stable.\n- Locations with 3 neighbors will create life.\n- A cell with 4 or more neighbors dies.\n\n" +
            "Grid input file name? "
        );

        Scanner input = new Scanner(System.in);
        //LifeModel model = new LifeModel(input.nextLine());
        LifeModel model = new LifeModel("glider.txt");

        input.close();

        System.out.print("\n" + model.toString());
    }

    
}
