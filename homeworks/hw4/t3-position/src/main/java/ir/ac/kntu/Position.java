package ir.ac.kntu;

public class Position {
    private double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Position convertStringToPosition(String str) {
        double[] pos = new double[2];
        String[] posStr = str.split(",");
        pos[0] = Double.valueOf(posStr[0]);
        pos[1] = Double.valueOf(posStr[1]);

        return new Position(pos[0], pos[1]);
    }


    public static Position convertArrayToPosition(double[] pos) {
        return new Position(pos[0], pos[1]);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{x:" + x +
                ", y:" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return Double.compare(position.getX(), getX()) == 0 && Double.compare(position.getY(), getY()) == 0;
    }

    public Position[] getBounds(int acc) {
        Position[] pos = new Position[2];
        pos[0] = new Position(this.x - acc, this.y - acc);
        pos[1] = new Position(this.x + acc, this.y + acc);
        return pos;
    }

    public double getDistance(Position p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }
}
