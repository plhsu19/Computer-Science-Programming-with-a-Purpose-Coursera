public class Clock {

    private int hour;
    private int minute;
    private static final int HOUR_PER_DAY = 24;
    private static final int MIN_PER_HOUR = 60;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOUR_PER_DAY) throw new IllegalArgumentException("Input hour out of range!");
        hour = h;
        if (m < 0 || m >= MIN_PER_HOUR) throw new IllegalArgumentException("Input minute out of range!");
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() > 5) throw new IllegalArgumentException("Invalid time format");
        if (s.charAt(2) != ':') throw new IllegalArgumentException("Invalid time format");
        String[] intime = s.split(":");
        int hourstr = Integer.parseInt(intime[0]);
        if(hourstr < 0 || hourstr >= HOUR_PER_DAY) throw new IllegalArgumentException("Input hour out of range!");
        hour = hourstr;
        int minstr = Integer.parseInt(intime[1]);
        if(minstr < 0 || minstr >= MIN_PER_HOUR) throw new IllegalArgumentException("Input minute out of range!");
        minute = minstr;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hourtostring = Integer.toString(hour);
        String mintostring = Integer.toString(minute);
        if (hour < 10) hourtostring = "0" + hourtostring;
        if (minute < 10) mintostring = "0" + mintostring;
        String finaldisplay = hourtostring + ":" + mintostring;
        return finaldisplay;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hour < that.hour) return true;
        if (this.hour > that.hour) return false;
        if (this.hour == that.hour) {
            if (this.minute < that.minute) return true;
            if (this.minute >= that.minute) return false;
        }
        return true;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minute < (MIN_PER_HOUR - 1)) minute ++;
        else {
            minute = 0;
            if (hour < (HOUR_PER_DAY - 1)) hour ++;
            else if (hour == (HOUR_PER_DAY - 1)) hour = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("negative delta minute!");
        int newmin = (minute + delta) % MIN_PER_HOUR;
        int deltahour = (minute + delta) / MIN_PER_HOUR;
        minute = newmin;
        hour += deltahour;
        if (hour > (HOUR_PER_DAY - 1)) hour = (hour % HOUR_PER_DAY);
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock a = new Clock(args[0]);
        Clock b = new Clock(12, 30);
        Clock c = new Clock(args[0]);

        System.out.println("Input time is " + a);

        if (a.isEarlierThan(b)) System.out.println(a + " is earlier than " + b);
        else System.out.println(a + " is not earlier than " + b);

        a.tic();
        System.out.println("1 minute later than input time is " + a);
        
        a = c;
        int deltamin = Integer.parseInt(args[1]);
        a.toc(deltamin);
        System.out.println(args[1] + " minute later than input time is " + a);

    }

}