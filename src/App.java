public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        City I = new City("Ingolstadt", 48.764001378240835, 11.42625484665524);
        City M = new City("München", 48.13891855227781, 11.577266137987793);
        City N = new City("Nürnberg", 49.45061728516064, 11.076253152617218);
        City U = new City("Ulm", 48.40203485876449,  9.976324958249457);
        City S = new City("Stuttgart", 48.77593813959718, 9.17688481609677);
        City A = new City("Augsburg", 48.3684765834842, 10.89671693335146);
        City R = new City("Regensburg", 49.01662121288669, 12.092787603517024);
        City W = new City("Würzburg", 49.79296114327296,  9.945390533206055);

        System.out.println(I);
        System.out.println(M);
        System.out.println(N);
        System.out.println(U);
        System.out.println(S);
        System.out.println(A);
        System.out.println(R);
        System.out.println(W);

        I.addConnection(M);
        I.addConnection(N);
        I.addConnection(R);
        I.addConnection(A);
        M.addConnection(A);
        U.addConnection(A);
        S.addConnection(U);
        S.addConnection(N);
        S.addConnection(W);
        R.addConnection(M);
        R.addConnection(N);
        N.addConnection(U);

        System.out.println("Beste Route: " + S.getRouteTo(R).toString());
    }
}
