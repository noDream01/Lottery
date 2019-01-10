package lv.lottery.registration;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "LotteryRegistration{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", limit=" + limit +
                ", createdDate=" + createdDate +
                '}';
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

    public LotteryRegistration(Long id, String title, Integer limit, Date createdDate) {
        this.id = id;
        this.title = title;
        this.limit = limit;
        this.createdDate = createdDate;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryRegistration that = (LotteryRegistration) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(limit, that.limit) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, limit, createdDate);
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
}
