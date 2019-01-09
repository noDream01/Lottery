package lv.lottery.users;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DZ_LOTTERY_PARTICIPANTS")
public class UsersRegistration {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Byte age;
    @Column(name = "code")
    private String code;
    @Column(name = "assigned_lottery_id")
    private Long assignedLotteryId;



    public UsersRegistration(Long id, String email, Byte age, String code, Long assignedLotteryId) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.code = code;
        this.assignedLotteryId = assignedLotteryId;
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

    public Long getAssignedLotteryId() {
        return assignedLotteryId;
    }

    public void setAssignedLotteryId(Long assignedLotteryId) {
        this.assignedLotteryId = assignedLotteryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRegistration usersRegistration = (UsersRegistration) o;
        return Objects.equals(id, usersRegistration.id) &&
                Objects.equals(email, usersRegistration.email) &&
                Objects.equals(age, usersRegistration.age) &&
                Objects.equals(code, usersRegistration.code) &&
                Objects.equals(assignedLotteryId, usersRegistration.assignedLotteryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, age, code, assignedLotteryId);
    }
}
