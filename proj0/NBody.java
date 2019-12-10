public class NBody{
    public static double readRadius(String text) {
        In in = new In(text);
        in.readInt();
        double secondItemInFile = in.readDouble();

        // System.out.println("The Radius is: " + secondItemInFile);
        return secondItemInFile;
    }

    public static Body[] readBodies(String text) {
        In in = new In(text);
        int num = in.readInt();

        Body[] Planets = new Body[num];
        int index = 0;
        in.readDouble();
        while(index < num) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planets[index] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);;
            index += 1;
        }
        return Planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius =  readRadius(filename);
        Body[] bArray = readBodies(filename);

    }
}