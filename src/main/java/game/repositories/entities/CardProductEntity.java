package game.repositories.entities;

import java.util.List;

public class CardProductEntity {
    private Integer id;
    private CardEntity cardEntity;
    private List<AccountBuildingEntity> p1buildingList;
    private List<AccountBuildingEntity> p2buildingList;
    private List<AccountResourceEntity> p1accountResourceList;
    private List<AccountResourceEntity> p2accountResourceList;
    private List<AccountUpgradeEntity> p1accountUpgradeList;
    private List<AccountUpgradeEntity> p2accountUpgradeList;
    private List<AccountBuildingEntity> necessaryBuildingList;
    private List<AccountUpgradeEntity> necessaryAccountUpgradeList;

    public CardProductEntity() {}

    public CardProductEntity(Integer id, CardEntity cardEntity, List<AccountBuildingEntity> p1buildingList, List<AccountBuildingEntity> p2buildingList, List<AccountResourceEntity> p1accountResourceList, List<AccountResourceEntity> p2accountResourceList, List<AccountUpgradeEntity> p1accountUpgradeList, List<AccountUpgradeEntity> p2accountUpgradeList, List<AccountBuildingEntity> necessaryBuildingList, List<AccountUpgradeEntity> necessaryAccountUpgradeList) {
        this.id = id;
        this.cardEntity = cardEntity;
        this.p1buildingList = p1buildingList;
        this.p2buildingList = p2buildingList;
        this.p1accountResourceList = p1accountResourceList;
        this.p2accountResourceList = p2accountResourceList;
        this.p1accountUpgradeList = p1accountUpgradeList;
        this.p2accountUpgradeList = p2accountUpgradeList;
        this.necessaryBuildingList = necessaryBuildingList;
        this.necessaryAccountUpgradeList = necessaryAccountUpgradeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CardEntity getCardEntity() {
        return cardEntity;
    }

    public void setCardEntity(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
    }

    public List<AccountBuildingEntity> getP1buildingList() {
        return p1buildingList;
    }

    public void setP1buildingList(List<AccountBuildingEntity> p1buildingList) {
        this.p1buildingList = p1buildingList;
    }

    public List<AccountBuildingEntity> getP2buildingList() {
        return p2buildingList;
    }

    public void setP2buildingList(List<AccountBuildingEntity> p2buildingList) {
        this.p2buildingList = p2buildingList;
    }

    public List<AccountResourceEntity> getP1accountResourceList() {
        return p1accountResourceList;
    }

    public void setP1accountResourceList(List<AccountResourceEntity> p1accountResourceList) {
        this.p1accountResourceList = p1accountResourceList;
    }

    public List<AccountResourceEntity> getP2accountResourceList() {
        return p2accountResourceList;
    }

    public void setP2accountResourceList(List<AccountResourceEntity> p2accountResourceList) {
        this.p2accountResourceList = p2accountResourceList;
    }

    public List<AccountUpgradeEntity> getP1accountUpgradeList() {
        return p1accountUpgradeList;
    }

    public void setP1accountUpgradeList(List<AccountUpgradeEntity> p1accountUpgradeList) {
        this.p1accountUpgradeList = p1accountUpgradeList;
    }

    public List<AccountUpgradeEntity> getP2accountUpgradeList() {
        return p2accountUpgradeList;
    }

    public void setP2accountUpgradeList(List<AccountUpgradeEntity> p2accountUpgradeList) {
        this.p2accountUpgradeList = p2accountUpgradeList;
    }

    public List<AccountBuildingEntity> getNecessaryBuildingList() {
        return necessaryBuildingList;
    }

    public void setNecessaryBuildingList(List<AccountBuildingEntity> necessaryBuildingList) {
        this.necessaryBuildingList = necessaryBuildingList;
    }

    public List<AccountUpgradeEntity> getNecessaryAccountUpgradeList() {
        return necessaryAccountUpgradeList;
    }

    public void setNecessaryAccountUpgradeList(List<AccountUpgradeEntity> necessaryAccountUpgradeList) {
        this.necessaryAccountUpgradeList = necessaryAccountUpgradeList;
    }

    @Override
    public String toString() {
        return "CardProductEntity{" +
                "id=" + id +
                ", cardEntity=" + cardEntity +
                ", p1buildingList=" + p1buildingList +
                ", p2buildingList=" + p2buildingList +
                ", p1accountResourceList=" + p1accountResourceList +
                ", p2accountResourceList=" + p2accountResourceList +
                ", p1accountUpgradeList=" + p1accountUpgradeList +
                ", p2accountUpgradeList=" + p2accountUpgradeList +
                ", necessaryBuildingList=" + necessaryBuildingList +
                ", necessaryAccountUpgradeList=" + necessaryAccountUpgradeList +
                '}';
    }
}
