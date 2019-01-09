package lv.lottery.users;

import java.util.List;
import java.util.Optional;

public interface UsersDAO {

    List<UsersRegistration> getAll();

    Optional<UsersRegistration> getById(Long id);

    Long insert(UsersRegistration usersRegistration);

    void update(Long userId, UsersRegistration usersRegistration);



}
