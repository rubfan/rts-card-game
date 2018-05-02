package game.repositories.entities;

public class AccountBuildingEntity {

    private Integer accountId;
    private Integer buildingId;
    private Float number;


    public AccountBuildingEntity(Integer accountId, Integer buildingId, Float number) {
        this.accountId = accountId;
        this.buildingId = buildingId;
        this.number = number;
    }

    public AccountBuildingEntity() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountBuildingEntity{" +
                "accountId=" + accountId +
                ", buildingId=" + buildingId +
                ", number=" + number +
                '}';
    }
}
