public class Connection {
public final double Distance;
public City stadt1;
public City stadt2;


    public Connection(City stadt1, City stadt2)
    {
        this.Distance = getDistanceInKm(stadt1, stadt2);
    }

    double getDistanceInKm(City stadt1, City stadt2) 
    {
        double lat1 = stadt1.getLatKoord(); //holt sich die Latitude von Stadt 1
        double lon1 = stadt1.getLongKoord(); //holt sich die Longitude von Stadt 1
        double lat2 = stadt2.getLatKoord(); //holt sich die Latitude von Stadt 2
        double lon2 = stadt2.getLongKoord(); //holt sich die Longitude von Stadt 2
        double earthRadiusKm = 6371; //Radius der Erde in km
        double dLat = degreesToRadians(lat2-lat1); //Differenz der Breiten
        double dLon = degreesToRadians(lon2-lon1); //Differenz der Längen
        lat1 = degreesToRadians(lat1); //Umwandlung der Breite von Stadt 1 in Bogenmaß
        lat2 = degreesToRadians(lat2); //Umwandlung der Breite von Stadt 2 in Bogenmaß
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.sin(dLon/2) *
        Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); //Berechnung der Differenz der Breiten und Längen
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); //Berechnung der Differenz der Breiten und Längen
        return earthRadiusKm * c; //Berechnung der Distanz in km und returnt Diese
        }

        private double degreesToRadians(double degrees) 
        {
            return degrees * Math.PI / 180; //Umwandlung der Grad in Bogenmaß
        }

        public City getOtherCity(City stadt)
        {
            if (stadt.getName().equals(stadt1.getName()))
            {
                return stadt1;
            }
            else if (stadt1.getName().equals(stadt2.getName()))
            {
                return stadt2;
            }
            else
            {
                return null;
            }
        }
}
