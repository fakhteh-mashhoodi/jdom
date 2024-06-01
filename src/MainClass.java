import domainModel.Users;
import repository.UserRepository;

public class MainClass {
    public static void main(String[] args) {
        new XmlManager().read();
        UserRepository repository = new UserRepository();
       Users newUser = Users.builder()
               .username("mohamad")
               .password("5698")
                .build();
        int affectedRows = repository.insert(newUser);
        System.out.println(affectedRows);



    }
}
