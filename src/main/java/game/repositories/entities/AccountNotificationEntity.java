package game.repositories.entities;

public class AccountNotificationEntity {

    private Integer id;
    private Integer accountId;
    private Integer notificationId;

    public AccountNotificationEntity() {
    }

    public AccountNotificationEntity(Integer id, Integer accountId, Integer notificationId) {
        this.id = id;
        this.accountId = accountId;
        this.notificationId = notificationId;
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
        return "AccountNotificationEntity{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", notificationId=" + notificationId +
                '}';
    }
}
