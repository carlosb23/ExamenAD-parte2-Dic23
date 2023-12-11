package cesur.examen.domain.car;

import cesur.examen.domain.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Carlos Bustos
 * Fecha: 11/12/23
 */


@Data
@Entity
@Table(name = "garaje")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "matricula")
    private String plate;
    @Column(name = "modelo")
    private String model;
    @Column(name = "fabricante")
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Client client;
    /**
     * Override inherited toString() method to prevent stackOverFlow exceptions
     * from relationship.
     * @return
     */
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", client=" + client.getName() +
                '}';
    }
}
