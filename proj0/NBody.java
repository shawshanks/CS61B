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
        int T = in.readInt();

        Body[] Planets = new Body[T];
        int index = 0;
        in.readDouble();
        while(index < T) {
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
        /** Get data */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius =  NBody.readRadius(filename);
        Body[] planetArray = NBody.readBodies(filename);


        /** Creating an Animation */

        /* Enable double buffering */
        StdDraw.enableDoubleBuffering();

        /* set initial time */
        double time = 0;

        /* Set up a loop to loop until this time variable reaches (and includes) the T */
        while (time <= T) {
            double[] xForces = new double[planetArray.length];
            double[] yForces = new double[planetArray.length];

            /* Calculate the net x and y forces for each Body */
            for (int i = 0; i < planetArray.length; i += 1){
                xForces[i] = planetArray[i].calcNetForceExertedByX(planetArray);
                yForces[i] = planetArray[i].calcNetForceExertedByY(planetArray);
            }

            /* update each body’s position, velocity, and acceleration.*/
            for (int i = 0; i < planetArray.length; i += 1) {
                planetArray[i].update(dt, xForces[i], yForces[i]);
            }
            /** Draw the Background */
            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");


            /** Draw all the  Body */
      
            for (int i = 0; i < planetArray.length; i++) {
                planetArray[i].draw();
            }

            /** show the offscreen buffer. */
            StdDraw.show();

            /** Pause the animation for 10 milliseconds */
            StdDraw.pause(10);

            /** Increase your time variable by dt. */
            time += dt;
            
        }

        /* Print out the final state of universe when time reaches T */

        StdOut.printf("%d\n", planetArray.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planetArray.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                      planetArray[i].xxPos, planetArray[i].yyPos, planetArray[i].xxVel,
                      planetArray[i].yyVel, planetArray[i].mass, planetArray[i].imgFileName); 
        }
    }     

}