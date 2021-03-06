package lv.lottery.registration;

import lv.lottery.users.UsersRegistration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "DZ_LOTTERIES")
public class LotteryRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long id;
    @Column(name = "title_lottery")
    public String title;
    @Column(name = "limit_users")
    public Integer limit;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "regStatus")
    public Boolean regStatus;
    @Column(name = "winner")
    private String winner;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lottery")
    private List<UsersRegistration> users = new ArrayList<>();

    public List<UsersRegistration> getUsers() {
        return users;
    }

    public void setUsers(List<UsersRegistration> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "LotteryRegistration{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", limit=" + limit +
                ", createdDate=" + createdDate +
                ", regStatus=" + regStatus +
                ", users=" + users.stream().map(UsersRegistration::getId).map(Objects::toString).collect(Collectors.joining(", ")) +
                ", winner=" + winner +
                '}';
    }

    public Boolean getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(Boolean regStatus) {
        this.regStatus = regStatus;
    }

    public String getTitle() {
        return title;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public LotteryRegistration(Long id, String title, Integer limit, Date createdDate, Boolean regStatus,String winner) {
        this.id = id;
        this.title = title;
        this.limit = limit;
        this.createdDate = createdDate;
        this.regStatus = regStatus;
        this.winner = winner;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryRegistration that = (LotteryRegistration) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(limit, that.limit) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(regStatus, that.regStatus) &&
                Objects.equals(winner, that.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, limit, createdDate, regStatus, winner);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public LotteryRegistration() {
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
