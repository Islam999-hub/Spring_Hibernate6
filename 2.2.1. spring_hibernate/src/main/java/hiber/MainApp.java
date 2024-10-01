package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User islam = new User("Islam", "Makhauri", "islam999.osago@mail.ru");
      User alik = new User("Alik", "Muradov", "AliMuradov@mail.ru");
      User malik = new User("Malik", "Makhauri", "malikmakhauri3@mail.ru");
      User anzor = new User("Anzor", "Makhauri", "AnzorMakhauri@mail.ru");

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }


      Car lexus = new Car("Lexus", 1, islam);
      Car woltswagen = new Car("Woltswagen", 2, alik);
      Car mercedes = new Car("Marcedes", 3, malik);
      Car audi = new Car("Audi", 4, anzor);


      islam.setCar(lexus);
      alik.setCar(woltswagen);
      malik.setCar(mercedes);
      anzor.setCar(audi);


      userService.add(islam);
      userService.add(alik);
      userService.add(malik);
      userService.add(anzor);


      User user = (User) userService.getUserCar("Lexus", 1  );
      System.out.println(user);












      context.close();
   }
}
