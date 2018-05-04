package game.repositories.entities;

import java.util.List;

public class AccountUpgradeEntity {
    private Integer id;
    private AccountEntity accountEntity;
    private List<UpgradeProductEntity> upgradeProductEntityList;
    private Float number;

    public AccountUpgradeEntity(Integer id, AccountEntity accountEntity, List<UpgradeProductEntity> upgradeProductEntityList, Float number) {
        this.id = id;
        this.accountEntity = accountEntity;
        this.upgradeProductEntityList = upgradeProductEntityList;
        this.number = number;
    }

    public AccountUpgradeEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public List<UpgradeProductEntity> getUpgradeProductEntityList() {
        return upgradeProductEntityList;
    }

    public void setUpgradeProductEntityList(List<UpgradeProductEntity> upgradeProductEntityList) {
        this.upgradeProductEntityList = upgradeProductEntityList;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountUpgradeEntity{" +
                "id=" + id +
                ", accountEntity=" + accountEntity +
                ", upgradeProductEntityList=" + upgradeProductEntityList +
                ", number=" + number +
                '}';
    }
}
