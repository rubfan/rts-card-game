package game.controllers.dto;

public class AccountNotificationDto {

    private Integer id;
    private Integer accountId;
    private Integer notificationId;

    public AccountNotificationDto(Integer id, Integer accountId, Integer notificationId) {
        this.id = id;
        this.accountId = accountId;
        this.notificationId = notificationId;
    }

    public AccountNotificationDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    @Override
    public String toString() {
        return "AccountNotificationDto{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", notificationId=" + notificationId +
                '}';
    }
}
