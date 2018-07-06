package game.repositories.entities;

public class AccountResourceQuantityEntity {
    private Integer resourceId;
    private Integer resourceNumber;
    private Integer resourcePerMIn;

    public AccountResourceQuantityEntity() {
    }

    public AccountResourceQuantityEntity(Integer resourceId, Integer resourceNumber, Integer resourcePerMIn) {
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
        return "AccountResourceQuantityEntity{" +
                "resourceId=" + resourceId +
                ", resourceNumber=" + resourceNumber +
                ", resourcePerMIn=" + resourcePerMIn +
                '}';
    }
}
