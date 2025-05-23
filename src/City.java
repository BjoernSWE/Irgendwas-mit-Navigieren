

public class City 
{
    String Name;
    double LatKoord;
    double LongKoord;

    public City(String Name, double LatKoord, double LongKoord)
    {
        this.Name = Name;
        this.LatKoord = LatKoord;
        this.LongKoord = LongKoord;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public void setLatKoord(double LatKoord)
    {
        this.LatKoord = LatKoord;
    }

    public void setLongKoord(double LongKoord)
    {
        this.LongKoord = LongKoord;
    }

    public String getName()
    {
        return this.Name;
    }

    public double getLatKoord()
    {
        return this.LatKoord;
    }

    public double getLongKoord()
    {
        return this.LongKoord;
    }

    @Override
    public String toString()
    {
        return Name + " " + LatKoord + " " + LongKoord;
    }
}
