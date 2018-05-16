package game.repositories.entities;

public class AccountNotificationEntity {

    private Integer accountId;
    private Integer notificationId;

    public AccountNotificationEntity() {
    }

    public AccountNotificationEntity(Integer accountId, Integer notificationId) {
        this.accountId = accountId;
        this.notificationId = notificationId;
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
        return "AccountNotificationEntity{" +
                ", accountId=" + accountId +
                ", notificationId=" + notificationId +
                '}';
    }
}
