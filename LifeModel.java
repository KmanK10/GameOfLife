import java.io.*;
import java.util.*;

public class LifeModel {
    private boolean[][] grid;

    public LifeModel(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        grid = new boolean[scanner.nextInt()][scanner.nextInt()];

        for (boolean[] x : grid) {
            String line = scanner.next();

            for (int i = 0; i < x.length; i++) {
                x[i] = line.charAt(i) == 'X';
            }
        }

        scanner.close();
    }

    public int getRows() {return grid.length;}
    public int getCols() {return grid[0].length;}

    public boolean isAlive(int x, int y) {return grid[x][y];}

    public void update() {
        
    }

    public String toString() {
        String output = "";

        for (boolean[] x : grid) {
            output += "\u001B[47m\u001B[30m";
            for (boolean y: x) output += y ? "\u2593" : "\u2591";
            
            output += "\u001B[0m\n";
        }

        return output;
    }
}