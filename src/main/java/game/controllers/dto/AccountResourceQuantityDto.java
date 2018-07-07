package game.controllers.dto;

public class AccountResourceQuantityDto {
    private Integer resourceId;
    private Integer resourceNumber;
    private Integer resourcePerMIn;


    public AccountResourceQuantityDto() {
    }

    public AccountResourceQuantityDto(Integer resourceId, Integer resourceNumber, Integer resourcePerMIn) {
        this.resourceId = resourceId;
        this.resourceNumber = resourceNumber;
        this.resourcePerMIn = resourcePerMIn;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(Integer resourceNumber) {
        this.resourceNumber = resourceNumber;
    }

    public Integer getResourcePerMIn() {
        return resourcePerMIn;
    }

    public void setResourcePerMIn(Integer resourcePerMIn) {
        this.resourcePerMIn = resourcePerMIn;
    }

    @Override
    public String toString() {
        return "AccountResourceQuantityDto{" +
                "resourceId=" + resourceId +
                ", resourceNumber=" + resourceNumber +
                ", resourcePerMIn=" + resourcePerMIn +
                '}';
    }
}
