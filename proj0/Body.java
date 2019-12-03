public class Body {
    static final double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body (double xP, double yP, double xV, double yV, double m,
                    String img) {
        /** Constructors that can initialize an instance of the Boyd calss */
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;


    }

    public Body(Body b) {
        /** The second constructor should take in a Body object and initialize
        * an identical Body object (i.e. a copy). */
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body another) {
        double dx = this.xxPos - another.xxPos;
        double dy = this.yyPos - another.yyPos;
        return Math.hypot(dx, dy);
    }

    public double calcForceExertedBy(Body another) {
        /** calculate the force exerted on this body by the given body*/
        return (this.mass * another.mass * G / Math.pow(this.calcDistance(another), 2));
    }

    public double calcForceExertedByX(Body another) {
        /** 计算分力 describe the force exerted in the X directions 
         * the signs is determined by  (another.xxPos - this.xxPos) 
         */
        return (this.calcForceExertedBy(another) * (another.xxPos - this.xxPos) / 
                    calcDistance(another));
    }

    public double calcForceExertedByY(Body another) {
        /** 计算分力 describe the force exerted in the Y directions 
         * the signs is determined by  (another.yyPos - this.yyPos) 
         */
        return (this.calcForceExertedBy(another) * (another.yyPos - this.yyPos) / 
                    calcDistance(another));
    }

    public double calcNetForceExertedByX(Body[] b) {
        double FxNet = 0;
        // for (int i = 0; i < b.length; i++) {
        //     if (!this.equals(b[i])) {
        //         FxNet += this.calcForceExertedByX(b[i]);
        //     }
        // }
        for (Body i: b) {
            if (!this.equals(i)) {
                FxNet += this.calcForceExertedByX(i);
            }
        }
        return FxNet;
    }

    public double calcNetForceExertedByY(Body[] b) {
        double FyNet = 0;
        for (int i = 0; i < b.length; i++) {
            if (!this.equals(b[i])) {
                FyNet += this.calcForceExertedByY(b[i]);
            }
        }
        return FyNet;
    }

    public void update(double dt, double fX, double fY) {
        /** update the postion and velocity */
        double axNet = fX / this.mass;
        double ayNet = fY / this.mass;
        this.xxVel += axNet * dt;
        this.yyVel += ayNet * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

}
