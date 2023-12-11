package cesur.examen.domain.client;

import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Carlos Bustos
 * Fecha: 11/12/23
 */

public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        var out = new ArrayList<Client>();

        // Obtener todos los coches del fabricante (manufacturer)
        List<Car> carsByManufacturer = CarDAO.getAllByManufacturer(manufacturer);

        // Crear un conjunto para almacenar clientes sin duplicados
        Set<Client> clients = new HashSet<>();

        // Iterar sobre los coches y agregar los clientes al conjunto
        for (Car car : carsByManufacturer) {
            clients.add(car.getClient());
        }

        out.addAll(clients);

        return out;
    }
}
