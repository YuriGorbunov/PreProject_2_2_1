package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("Yura", "Gorbunov", "myEmail@mail.ru", new Car("Audi", 5)));
      userService.add(new User("Ivan", "Popov", "ivan2@mail.ru", new Car("Lada",11)));
      userService.add(new User("Sergey", "Lozhkin", "sergey@mail.ru", new Car("BMW", 3)));
      userService.add(new User("Anton", "Vorobyov", "anton4@mail.ru", new Car("Lexus", 311)));

      List<User> users = userService.listUsers();
      List<Car> cars = carService.listOfCars();

      System.out.println(users.toString());
      System.out.println(cars.toString());

      System.out.println(userService.getUserByCar("Audi", 5));

      context.close();
   }
}
