import java.awt.*;

public class Planet {
    public double earthX = 0;
    public double earthY = 0;
    public double earthAngle = 0;
    private int speed;

    public void setSpeed(int speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }

    private int radiusSun;

    public void setRadiusSun(int radiusSun) {
        if (radiusSun > 0) {
            this.radiusSun = radiusSun;
        }

    }

    private int diameter;

    public void setDiameter(int diameter) {
        if (diameter > 0) {
            this.diameter = diameter;
        }

    }

    public Planet(int speed, int radiusSun, int diameter) {
        this.setSpeed(speed);
        this.setRadiusSun(radiusSun);
        this.setDiameter(diameter);
    }

    public void updatePosition() {
        earthAngle += getSpeed();
        earthX = getRadiusSun() * Math.cos(Math.toRadians(earthAngle));
        earthY = getRadiusSun() * Math.sin(Math.toRadians(earthAngle));
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) earthX + 500, (int) earthY + 500, getDiameter(), getDiameter());

    }

    public int getSpeed() {
        return speed;
    }

    public int getRadiusSun() {
        return radiusSun;
    }

    public int getDiameter() {
        return diameter;
    }
}
