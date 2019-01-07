package lv.lottery.users;

import java.util.Objects;

public class AddUsers {

    public Long id;
    public String email;
    public Byte age;
    public String code;

    public AddUsers(){

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
        AddUsers addUsers = (AddUsers) o;
        return Objects.equals(id, addUsers.id) &&
                Objects.equals(email, addUsers.email) &&
                Objects.equals(age, addUsers.age) &&
                Objects.equals(code, addUsers.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, age, code);
    }
}
