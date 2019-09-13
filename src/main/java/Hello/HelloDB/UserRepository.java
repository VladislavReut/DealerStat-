package Hello.HelloDB;
import org.springframework.data.repository.CrudRepository;

    public interface UserRepository extends CrudRepository<User, Integer> {
     }
