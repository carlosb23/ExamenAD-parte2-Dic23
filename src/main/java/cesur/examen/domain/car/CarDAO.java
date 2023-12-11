package cesur.examen.domain.car;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Carlos Bustos
 * Fecha: 11/12/23
 */

@Log
public class CarDAO implements DAO<Car> {
    @Override
    public Car save(Car car) {

        /* Implement method here */
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                // Comenzar la transacción
                transaction = session.beginTransaction();

                // Guardar el nuevo coche en la base de datos
                session.save(car);

                // Commit de la transacción
                transaction.commit();
            } catch (Exception e) {
                // Manejar cualquier excepción que pueda ocurrir durante la transacción
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }


            return car;
        }
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    public static List<Car> getAllByManufacturer(String manufacturer){
        var out = new ArrayList<Car>();

        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            Query<Car> query = session.createQuery("from Car where manufacturer=: m", Car.class);
            query.setParameter("m",manufacturer);

            out = (ArrayList<Car>) query.getResultList();
        }
       return out;
    }
}
