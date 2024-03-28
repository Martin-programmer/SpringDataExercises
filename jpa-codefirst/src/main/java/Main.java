import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicles");
        EntityManager entityManager = emf.createEntityManager();

        Car car = new Car("Seat Ibiza", new BigDecimal(8000),"Diesel",5);
        Truck truck = new Truck("Fuse Canter",new BigDecimal(20000),"gasoline",5.5);
        Plane plane = new Plane("Boeing",new BigDecimal(5820000),"gasoline",200);


        entityManager.getTransaction().begin();
        entityManager.persist(car);
        PlateNumber carPlateNumber = new PlateNumber("ЕН2480КК",car);
        car.setPlateNumber(carPlateNumber);
        entityManager.persist(carPlateNumber);
        entityManager.persist(truck);
        entityManager.persist(plane);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Car foundedCar = entityManager.find(Car.class, 1L);
        Truck foundedTruck = entityManager.find(Truck.class, 2L);
        Plane foundedPlane = entityManager.find(Plane.class,3L);
        System.out.println(foundedCar.getModel());
        System.out.println(foundedTruck.getModel());
        System.out.println(foundedPlane.getModel());
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.createQuery("SELECT v FROM Vehicle v")
                        .getResultList().forEach(System.out::println);
        entityManager.getTransaction().commit();


        entityManager.close();


    }
}
