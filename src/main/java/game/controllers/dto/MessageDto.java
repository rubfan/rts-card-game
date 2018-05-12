package game.controllers.dto;

import java.util.Date;

public class MessageDto {
    private Integer id;
    private String text;
    private Integer fromAccountId;
    private Integer toAccountId;
    private Date time;

    public MessageDto() { }

    public MessageDto(Integer id, String text, Integer fromAccountId, Integer toAccountId, Date time) {
        this.id = id;
        this.text = text;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", time=" + time +
                '}';
    }
}
