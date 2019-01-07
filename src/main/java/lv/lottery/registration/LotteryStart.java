package lv.lottery.registration;

import java.util.Objects;

public class LotteryStart {

    private Long id;
    private String title;
    private Integer limit;

    public LotteryStart(){

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

    public LotteryStart(Long id, String title, Integer limit) {
        this.id = id;
        this.title = title;
        this.limit = limit;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, limit);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}