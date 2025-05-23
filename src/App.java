public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        City C1 = new City("Ingolstadt", 48.764001378240835, 11.42625484665524);
        City C2 = new City("München", 48.13891855227781, 11.577266137987793);
        City C3 = new City("Nürnberg", 49.45061728516064, 11.076253152617218);
        City C4 = new City("Ulm", 48.40203485876449,  9.976324958249457);
        City C5 = new City("Stuttgart", 48.77593813959718, 9.17688481609677);
        City C6 = new City("Augsburg", 48.3684765834842, 10.89671693335146);
        City C7 = new City("Regensburg", 49.01662121288669, 12.092787603517024);
        City C8 = new City("Würzburg", 49.79296114327296,  9.945390533206055);

        System.out.println(C1);
        System.out.println(C2);
        System.out.println(C3);
        System.out.println(C4);
        System.out.println(C5);
        System.out.println(C6);
        System.out.println(C7);
        System.out.println(C8);

    }
}
