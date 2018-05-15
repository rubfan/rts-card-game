package game.repositories.entities;

public class AccountAchievementEntity {
    private Integer accountId;
    private Integer achievementId;
    private Float number;

    public AccountAchievementEntity() {
    }

    public AccountAchievementEntity(Integer accountId, Integer achievementId, Float number) {
        this.accountId = accountId;
        this.achievementId = achievementId;
        this.number = number;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountAchievementEntity{" +
                "accountId=" + accountId +
                ", achievementId=" + achievementId +
                ", number=" + number +
                '}';
    }
}
