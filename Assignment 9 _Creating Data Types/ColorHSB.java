import java.util.ArrayList;

public class ColorHSB {
    
    private final int hu;
    private final int sa;
    private final int br;
    
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if ( h > 359 || h < 0 || s > 100 || s < 0 || b > 100 || b < 0)
            throw new IllegalArgumentException("hue, saturation or brightness is/are outside prescibed range");
        hu = h;
        sa = s;
        br = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hu + ", " + sa + ", " + br + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (sa == 0 || br == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException(" there is no second ColorHSB to obtain distance");
        int delta = this.hu - that.hu;
        int deltah1 = delta * delta;
        int deltah2 = (360 - (int) Math.abs(delta)) * (360 - (int) Math.abs(delta));
        int deltah = deltah1;
        if (deltah > deltah2) deltah = deltah2;
        return deltah + (this.sa - that.sa) * (this.sa - that.sa) + (this.br - that.br) * (this.br - that.br);
    }
        

    // Sample client (see below).
        public static void main(String[] args) {
        
        int hue = Integer.parseInt(args[0]);
        int sat = Integer.parseInt(args[1]);
        int bright = Integer.parseInt(args[2]);
        ColorHSB a = new ColorHSB(hue, sat, bright); //create the ColorHSB type object a
        
        ArrayList<String> nColor = new ArrayList<String>();  //create a Name string array for pre-defined colors 
        ArrayList<ColorHSB> pColor = new ArrayList<ColorHSB>(); //create a ColorHSB array for pre-defined colors
        
        while (!StdIn.isEmpty()) {
            nColor.add(StdIn.readString());
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB preColor = new ColorHSB(h, s, b);
            pColor.add(preColor);
        }
        
        int minDistance = a.distanceSquaredTo(pColor.get(0));
        int minInt = 0;
        
        for (int j = 0; j < nColor.size(); j ++) {
            int distance = a.distanceSquaredTo(pColor.get(j));
            if (distance <= minDistance) {
                minDistance = distance;
                minInt = j;
            }
        }
        
        System.out.println(nColor.get(minInt) + " " + pColor.get(minInt));          
}
        
}