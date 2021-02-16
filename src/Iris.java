public class Iris {
    double irisNumber1;
    double irisNumber2;
    double irisNumber3;
    double irisNumber4;
    String irisType;

    public Iris(double irisNumber1, double irisNumber2, double irisNumber3, double irisNumber4) {
        this.irisNumber1 = irisNumber1;
        this.irisNumber2 = irisNumber2;
        this.irisNumber3 = irisNumber3;
        this.irisNumber4 = irisNumber4;
    }

    public Iris(double[] irisTab, String irisType) {
        this.irisNumber1 = irisTab[0];
        this.irisNumber2 = irisTab[1];
        this.irisNumber3 = irisTab[2];
        this.irisNumber4 = irisTab[3];
        this.irisType = irisType;
    }
    public double irisDistance (Iris iris){
        return Math.sqrt(Math.pow(irisNumber1-iris.getIrisNumber1(),2)+Math.pow(irisNumber2-iris.getIrisNumber2(),2)+
                Math.pow(irisNumber3-iris.getIrisNumber3(),2)+Math.pow(irisNumber4-iris.getIrisNumber4(),2));
    }

    public double getIrisNumber1() {
        return irisNumber1;
    }

    public double getIrisNumber2() {
        return irisNumber2;
    }

    public double getIrisNumber3() {
        return irisNumber3;
    }

    public double getIrisNumber4() {
        return irisNumber4;
    }

    @Override
    public String toString() {
        return "{ " +irisNumber1 + ", " + irisNumber2 +", "+ irisNumber3 + ", " + irisNumber4 + "(" + irisType + ")"+ '}';
    }
}
