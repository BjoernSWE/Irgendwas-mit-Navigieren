import java.util.ArrayList;

public class Route 
{
    private ArrayList<City> routeCities;
    private double totalDistance;

    private Route() 
    {
        this.routeCities = new ArrayList<>();
        this.totalDistance = 0.0;
    }
    
    private Route(Route other) 
    {
        this.routeCities = new ArrayList<>(other.routeCities);
        this.totalDistance = other.totalDistance;
    }

    public void appendCity(City city, Connection connection)
    {
        routeCities.add(city);
        if(connection != null)
        {
            totalDistance += connection.Distance;
        }
    }

    public double getTotalDistance() 
    {
        return totalDistance;
    }

    public boolean containsCity(City city)
    {
        return routeCities.contains(city);
    }

    @Override
    public String toString() {
        String result = "";
        for(City city : routeCities) {
            result += city.getName() + " - ";
        }
        result = result.substring(0, result.length() - 3); // Remove the last " - "
        result += "; Distance: " + Math.round(totalDistance);
        return result;
    }

    public static Route getShortestRoute(City origin, City destination) 
    {
        Route currentRoute = new Route();
        ArrayList<Route> allPossibleRoutes = new ArrayList<>();
        addAllRoutes(allPossibleRoutes, currentRoute, origin, destination, null);
        ArrayList<Route> routesOrderedByDistance = new ArrayList<>();
        for (Route route : allPossibleRoutes) {
            int insertIndex = 0;
            while (insertIndex < routesOrderedByDistance.size() &&
                   route.getTotalDistance() >= routesOrderedByDistance.get(insertIndex).getTotalDistance()) {
                insertIndex++;
            }
            routesOrderedByDistance.add(insertIndex, route);
        }
        for (Route route : routesOrderedByDistance) {
            System.out.println(route);
        }
        return routesOrderedByDistance.isEmpty() ? null : routesOrderedByDistance.get(0); //(? :) Ternärer Operator prüft nur, ob die Liste leer ist
    }

    private static void addAllRoutes(ArrayList<Route> allPossibleRoutes, Route currentRoute, City currentCity, City destination, Connection connection)
    {
        if (currentCity == null) return;
        currentRoute.appendCity(currentCity, connection);
        if (currentCity.getName().equals(destination.getName())) 
        {
            allPossibleRoutes.add(new Route(currentRoute));
            return;
        }
        ArrayList<Connection> connections = currentCity.getConnections();
        for (Connection conn : currentCity.getConnections())
        {
            City nextCity = conn.getOtherCity(currentCity);
            if (!currentRoute.containsCity(nextCity))
            {
                Route continuedRoute = new Route(currentRoute);
                addAllRoutes(allPossibleRoutes, continuedRoute, nextCity, destination, conn);
            }
        }
    }
}
