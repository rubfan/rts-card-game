package game.controllers.dto;

public class AccountBuildingDto {

    private Integer accountId;
    private Integer buildingId;
    private Float number;

    public AccountBuildingDto() {
    }

    public AccountBuildingDto(Integer accountId, Integer buildingId, Float number) {
        this.accountId = accountId;
        this.buildingId = buildingId;
        this.number = number;
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

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
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
