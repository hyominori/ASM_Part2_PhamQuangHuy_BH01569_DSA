package StudentFile;

public class Student {
    private int id;
    private String name;
    private double mark;

    public Student(int id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getRanking () {
        if (mark >= 9 && mark <= 10) return "Excellent";
        else if (mark >= 7.5) return "Very Good";
        else if (mark >= 6.5) return "Good";
        else if (mark >= 5.0) return "Medium";
        else return "Fail";
    }

    @Override
    public String toString (){
        return "ID: " + id + ", Name: " + name + ", Mark: " + mark + ", Rank: " + getRanking();
    }

}
