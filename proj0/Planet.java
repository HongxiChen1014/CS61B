/**
 * @author daisy
 * @description
 * @create 2021-11-22-21:34
 */
public class Planet {
    private double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        return G * this.mass * p.mass / Math.pow(distance, 2);
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        return this.calcForceExertedBy(p) * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        return this.calcForceExertedBy(p) * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double fx = 0;
        for (Planet i : p) {
            if (!this.equals(i)) {
                fx += this.calcForceExertedByX(i);
            }
        }
        return fx;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double fy = 0;
        for (Planet i : p) {
            if (!this.equals(i)) {
                fy += this.calcForceExertedByY(i);
            }
        }
        return fy;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
