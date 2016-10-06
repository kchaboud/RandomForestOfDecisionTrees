package tools;

public class Tuple<X, Y>
{
    public final X x;
    public final Y y;

    public X getX()
    {
        return x;
    }

    public Y getY()
    {
        return y;
    }

    public Tuple(X x, Y y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "attribut : " + "x=" + x + ", split :" + y;
    }
}
