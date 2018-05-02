package game.repositories.entities;

import java.util.*;


public class MessageEntity {
    private Integer id;
    private String text;
    private Integer from_account_id;
    private Integer to_account_id;
    private Date time;

    public MessageEntity() { }

    public MessageEntity(Integer id, String text, Integer from_account_id, Integer to_account_id, Date time) {
        this.id = id;
        this.text = text;
        this.from_account_id = from_account_id;
        this.to_account_id = to_account_id;
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

    public Integer getFrom_account_id() {
        return from_account_id;
    }

    public void setFrom_account_id(Integer from_account_id) {
        this.from_account_id = from_account_id;
    }

    public Integer getTo_account_id() {
        return to_account_id;
    }

    public void setTo_account_id(Integer to_account_id) {
        this.to_account_id = to_account_id;
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
                ", from_account_id=" + from_account_id +
                ", to_account_id=" + to_account_id +
                ", time=" + time +
                '}';
    }
}
