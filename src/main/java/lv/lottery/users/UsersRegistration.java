package lv.lottery.users;

import java.util.Objects;

public class UsersRegistration {

    public Long id;
    public String email;
    public Byte age;
    public String code;

    public UsersRegistration(Long id, String email, Byte age, String code) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.code = code;
    }

    public UsersRegistration(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRegistration usersRegistration = (UsersRegistration) o;
        return Objects.equals(id, usersRegistration.id) &&
                Objects.equals(email, usersRegistration.email) &&
                Objects.equals(age, usersRegistration.age) &&
                Objects.equals(code, usersRegistration.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, age, code);
    }
}
