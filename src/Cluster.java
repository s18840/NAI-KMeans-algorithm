import java.util.LinkedList;
import java.util.List;

public class Cluster {

    Iris irisCentroid;
    List<Iris> irisType;
    double distance;

    public Cluster(Iris irisCentroid) {
        this.irisCentroid = irisCentroid;
        this.irisType = new LinkedList<>();
    }

    public void add(Iris iris){
        irisType.add(iris);
        if(irisType.size()!=1){
            double sum =0;
            for (Iris i:irisType){
                sum +=i.irisDistance(irisCentroid);
            }
            distance = sum/irisType.size();

        }else{
            distance = irisCentroid.irisDistance(iris);
        }
        createNewCentroid();
    }

    public void createNewCentroid(){
        double sum1=0;
        double sum2=0;
        double sum3=0;
        double sum4=0;

        for (Iris i : irisType) {
            sum1+= i.getIrisNumber1();
            sum2+= i.getIrisNumber2();
            sum3+= i.getIrisNumber3();
            sum4+= i.getIrisNumber4();
        }
        irisCentroid = new Iris(sum1/irisType.size(),sum2/irisType.size(),sum3/irisType.size(),sum4/irisType.size());
    }

    public  void delete(){
        double sum=0;
        for (Iris i : irisType) {
            sum += i.irisDistance(irisCentroid);
        }
        distance = sum/irisType.size();
        createNewCentroid();
    }

    public void showType(){
        System.out.println(irisType.toString());
    }

    public Iris getIrisCentroid() {
        return irisCentroid;
    }

    public List<Iris> getIrisType() {
        return irisType;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return String.valueOf(irisType.toString());
    }

}
