package game.repositories.entities;

public class AccountUpgradeEntity {
    private Integer accountId;
    private Integer upgradeId;
    private Integer quantity;

    public AccountUpgradeEntity(){}

    public AccountUpgradeEntity(Integer accountId, Integer upgradeId, Integer quantity) {
        this.accountId = accountId;
        this.upgradeId = upgradeId;
        this.quantity = quantity;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AccountUpgradeEntity{" +
                "accountId=" + accountId +
                ", upgradeId=" + upgradeId +
                ", quantity=" + quantity +
                '}';
    }
}
