package game.controllers.dto;

public class AccountNotificationDto {

    private Integer accountId;
    private Integer notificationId;

    public AccountNotificationDto(Integer accountId, Integer notificationId) {
        this.accountId = accountId;
        this.notificationId = notificationId;
    }

    public AccountNotificationDto() {
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
                ", accountId=" + accountId +
                ", notificationId=" + notificationId +
                '}';
    }
}
