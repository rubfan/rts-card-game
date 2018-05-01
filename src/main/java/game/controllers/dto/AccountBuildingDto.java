package game.controllers.dto;

public class AccountBuildingDto {

    private int accountId;
    private int buildingId;
    private float number;

    public AccountBuildingDto() {
    }

    public AccountBuildingDto(int accountId, int buildingId, float number) {
        this.accountId = accountId;
        this.buildingId = buildingId;
        this.number = number;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
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
        return "AccountBuildingDto{" +
                "accountId=" + accountId +
                ", buildingId=" + buildingId +
                ", number=" + number +
                '}';
    }
}
