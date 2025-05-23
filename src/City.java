import java.util.ArrayList;

public class City
{
    String Name;
    double LatKoord;
    double LongKoord;

    private ArrayList<Connection> connectedCities = new ArrayList<>();

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

    public void addConnection(City cityToConnect)
        {
            if (cityToConnect.getName().equals(this.getName()))
            {
                System.out.println("Eine Stadt kann nicht mit sich selbst verbunden werden.");
            }else
            {
                Connection connection = new Connection(this, cityToConnect);
                this.connectedCities.add(connection);
                cityToConnect.connectedCities.add(connection);

            }
        }

    public String getRouteTo(City Destination)
    {
        Route route = Route.getShortestRoute(this, Destination);
        if (route == null)
        {
            return "No route found";
        }
        return route.toString();
    }

    public ArrayList<Connection> getConnections()
    {
        return connectedCities;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return Name.equals(city.Name);
    }
}
