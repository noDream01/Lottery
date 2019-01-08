package lv.lottery.registration;

import java.util.Objects;

public class LotteryRegistration {

    private Long id;
    private String title;
    private Integer limit;

    public LotteryRegistration(){

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

    public LotteryRegistration(Long id, String title, Integer limit) {
        this.id = id;
        this.title = title;
        this.limit = limit;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryRegistration that = (LotteryRegistration) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(limit, that.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, limit);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}