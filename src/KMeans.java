import java.util.*;

public class KMeans {
    public static void kMeans(List<Iris> irisList, int k) {
            List<Cluster> clusterList = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                Iris centroid = irisList.get(k);
                clusterList.add(new Cluster(centroid));
            }
            //do szukania klastrow z najmniejsza odlegloscia
            for (Iris p : irisList) {
                Cluster lowestCluster = clusterList.get(0);
                for (Cluster c : clusterList) {
                    if (c.getIrisCentroid().irisDistance(p) <= lowestCluster.getIrisCentroid().irisDistance(p))
                        lowestCluster = c;
                }
                lowestCluster.add(p);

            }

            double clusterDistance = 0;
            //wypisanie wartosci
            for (Cluster c : clusterList) {
                clusterDistance += c.getDistance();
            }

            System.out.println(clusterDistance / clusterList.size());

            int status = 0;
            int licznik = 0;

            List<Double> wyniki = new ArrayList<>();

            while (licznik < 2) {
                status = 0;

                for (Cluster c : clusterList) {
                    for (Iterator<Iris> irisIterator = c.getIrisType().iterator(); irisIterator.hasNext(); ) {
                        Iris ir = irisIterator.next();
                        Cluster lowestCluster = clusterList.get(0);
                        for (Cluster cl : clusterList) {
                            if (cl.getIrisCentroid().irisDistance(ir) <= lowestCluster.getIrisCentroid().irisDistance(ir))
                                lowestCluster = cl;
                        }

                        if (!c.equals(lowestCluster)) {
                            status -= 1;
                            lowestCluster.add(ir);
                            irisIterator.remove();
                            c.delete();
                        } else {
                            status += 1;
                        }


                    }
                }
                double clusterDistance2 = 0;

                for (Cluster cl : clusterList) {
                    clusterDistance2 += cl.getDistance();
                }

                double dane = clusterDistance2/clusterList.size();
                wyniki.add(dane);

                if (status == irisList.size())
                    licznik += 1;
                else
                    licznik = 0;
            }
        for(Double d : wyniki){
            System.out.println(d);
        }
        System.out.println("");
        for (Cluster c : clusterList)
                c.showType();
            System.out.println("");
    }
}
