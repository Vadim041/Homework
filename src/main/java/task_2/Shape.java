package task_2;

public abstract class Shape implements Calculatable {

    protected String fillColor;
    protected String borderColor;

    public Shape(){}

    public Shape(String fillColor, String borderColor){
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printInfo(){}
}
