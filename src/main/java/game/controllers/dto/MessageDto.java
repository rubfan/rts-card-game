package game.controllers.dto;

import java.util.Date;

public class MessageDto {
    private int id;
    private String text;
    private int from_account_id;
    private int to_account_id;
    private Date time;

    public MessageDto() { }

    public MessageDto(int id, String text, int from_account_id, int to_account_id, Date time) {
        this.id = id;
        this.text = text;
        this.from_account_id = from_account_id;
        this.to_account_id = to_account_id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFrom_account_id() {
        return from_account_id;
    }

    public void setFrom_account_id(int from_account_id) {
        this.from_account_id = from_account_id;
    }

    public int getTo_account_id() {
        return to_account_id;
    }

    public void setTo_account_id(int to_account_id) {
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
