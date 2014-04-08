package ohtu;

public class Submission {
    
    private String student_number;
    private String first_name;
    private String last_name;
    private String week;
    private String points;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    @Override
    public String toString() {
        return " viikko " + week + ": tehtyjä tehtäviä yhteensä: " + this.getTotalPoints() +
                ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + this.getDoneAssignments();
    }
    
    public int getTotalPoints() {
        int done = 0;
        if (a1) done++;
        if (a2) done++;
        if (a3) done++;
        if (a4) done++;
        if (a5) done++;
        if (a6) done++;
        if (a7) done++;
        if (a8) done++;
        if (a9) done++;
        if (a10) done++;
        if (a11) done++;
        if (a12) done++;
        if (a13) done++;
        if (a14) done++;
        if (a15) done++;
        if (a16) done++;
        if (a17) done++;
        if (a18) done++;
        if (a19) done++;
        if (a20) done++;
        if (a21) done++;
        return done;
    }

    public String getDoneAssignments() {
        String done = "";
        if (a1) done += "1";
        if (a2) done += " 2";
        if (a3) done += " 3";
        if (a4) done += " 4";
        if (a5) done += " 5";
        if (a6) done += " 6";
        if (a7) done += " 7";
        if (a8) done += " 8";
        if (a9) done += " 9";
        if (a10) done += " 10";
        if (a11) done += " 11";
        if (a12) done += " 12";
        if (a13) done += " 13";
        if (a14) done += " 14";
        if (a15) done += " 15";
        if (a16) done += " 16";
        if (a17) done += " 17";
        if (a18) done += " 18";
        if (a19) done += " 19";
        if (a20) done += " 20";
        if (a21) done += " 21";
        return done;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public int getHours() {
        return hours;
    }
}