public class RevesPuzzle { 
    
    // recursive function to solve 
    // Tower of Hanoi puzzle 
    public static void Reves(int n, char from_rod, 
                      char to_rod, char aux_rod1, 
                      char aux_rod2) {
        if (n == 0) return;
        if (n == 1) StdOut.println("Move disc " + n + " from " +
                                   from_rod + " to " + to_rod);
        else {
            Reves(n-2, from_rod, aux_rod1, to_rod, aux_rod2);
            StdOut.println("Move disc " + (n - 1) + " from " +
                                   from_rod + " to " + aux_rod2);
            StdOut.println("Move disc " + n + " from " +
                                   from_rod + " to " + to_rod);
            StdOut.println("Move disc " + (n - 1) + " from " +
                                   aux_rod2 + " to " + to_rod);
            Reves(n-2, aux_rod1, to_rod, from_rod, aux_rod2);
        }
        
    }
        
    // Driver method 
    public static void main(String args[]) {
        
        int n = Integer.parseInt(args[0]);
        Reves(n, 'A', 'D', 'B', 'C');
    }
}
        