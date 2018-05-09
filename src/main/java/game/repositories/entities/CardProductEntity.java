package game.repositories.entities;

import java.util.List;

public class CardProductEntity {
    private Integer id;
    private CardEntity cardEntity;
    private List<BuildingQuantityEntity> p1BuildingQuantityEntityList;
    private List<BuildingQuantityEntity> p2BuildingQuantityEntityList;
    private List<ResourceQuantityEntity> p1ResourceQuantityEntityList;
    private List<ResourceQuantityEntity> p2ResourceQuantityEntityList;
    private List<UpgradeQuantityEntity> p1UpgradeQuantityEntityList;
    private List<UpgradeQuantityEntity> p2UpgradeQuantityEntityList;
    private List<BuildingQuantityEntity> necessaryBuildingQuantityEntityList;
    private List<UpgradeQuantityEntity> necessaryUpgradeQuantityEntityList;

    public CardProductEntity() {
    }

    public CardProductEntity(Integer id, CardEntity cardEntity, List<BuildingQuantityEntity> p1BuildingQuantityEntityList,
                             List<BuildingQuantityEntity> p2BuildingQuantityEntityList,
                             List<ResourceQuantityEntity> p1ResourceQuantityEntityList,
                             List<ResourceQuantityEntity> p2ResourceQuantityEntityList,
                             List<UpgradeQuantityEntity> p1UpgradeQuantityEntityList,
                             List<UpgradeQuantityEntity> p2UpgradeQuantityEntityList,
                             List<BuildingQuantityEntity> necessaryBuildingQuantityEntityList,
                             List<UpgradeQuantityEntity> necessaryUpgradeQuantityEntityList) {
        this.id = id;
        this.cardEntity = cardEntity;
        this.p1BuildingQuantityEntityList = p1BuildingQuantityEntityList;
        this.p2BuildingQuantityEntityList = p2BuildingQuantityEntityList;
        this.p1ResourceQuantityEntityList = p1ResourceQuantityEntityList;
        this.p2ResourceQuantityEntityList = p2ResourceQuantityEntityList;
        this.p1UpgradeQuantityEntityList = p1UpgradeQuantityEntityList;
        this.p2UpgradeQuantityEntityList = p2UpgradeQuantityEntityList;
        this.necessaryBuildingQuantityEntityList = necessaryBuildingQuantityEntityList;
        this.necessaryUpgradeQuantityEntityList = necessaryUpgradeQuantityEntityList;
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

    public List<BuildingQuantityEntity> getP1BuildingQuantityEntityList() {
        return p1BuildingQuantityEntityList;
    }

    public void setP1BuildingQuantityEntityList(List<BuildingQuantityEntity> p1BuildingQuantityEntityList) {
        this.p1BuildingQuantityEntityList = p1BuildingQuantityEntityList;
    }

    public List<BuildingQuantityEntity> getP2BuildingQuantityEntityList() {
        return p2BuildingQuantityEntityList;
    }

    public void setP2BuildingQuantityEntityList(List<BuildingQuantityEntity> p2BuildingQuantityEntityList) {
        this.p2BuildingQuantityEntityList = p2BuildingQuantityEntityList;
    }

    public List<ResourceQuantityEntity> getP1ResourceQuantityEntityList() {
        return p1ResourceQuantityEntityList;
    }

    public void setP1ResourceQuantityEntityList(List<ResourceQuantityEntity> p1ResourceQuantityEntityList) {
        this.p1ResourceQuantityEntityList = p1ResourceQuantityEntityList;
    }

    public List<ResourceQuantityEntity> getP2ResourceQuantityEntityList() {
        return p2ResourceQuantityEntityList;
    }

    public void setP2ResourceQuantityEntityList(List<ResourceQuantityEntity> p2ResourceQuantityEntityList) {
        this.p2ResourceQuantityEntityList = p2ResourceQuantityEntityList;
    }

    public List<UpgradeQuantityEntity> getP1UpgradeQuantityEntityList() {
        return p1UpgradeQuantityEntityList;
    }

    public void setP1UpgradeQuantityEntityList(List<UpgradeQuantityEntity> p1UpgradeQuantityEntityList) {
        this.p1UpgradeQuantityEntityList = p1UpgradeQuantityEntityList;
    }

    public List<UpgradeQuantityEntity> getP2UpgradeQuantityEntityList() {
        return p2UpgradeQuantityEntityList;
    }

    public void setP2UpgradeQuantityEntityList(List<UpgradeQuantityEntity> p2UpgradeQuantityEntityList) {
        this.p2UpgradeQuantityEntityList = p2UpgradeQuantityEntityList;
    }

    public List<BuildingQuantityEntity> getNecessaryBuildingQuantityEntityList() {
        return necessaryBuildingQuantityEntityList;
    }

    public void setNecessaryBuildingQuantityEntityList(List<BuildingQuantityEntity> necessaryBuildingQuantityEntityList) {
        this.necessaryBuildingQuantityEntityList = necessaryBuildingQuantityEntityList;
    }

    public List<UpgradeQuantityEntity> getNecessaryUpgradeQuantityEntityList() {
        return necessaryUpgradeQuantityEntityList;
    }

    public void setNecessaryUpgradeQuantityEntityList(List<UpgradeQuantityEntity> necessaryUpgradeQuantityEntityList) {
        this.necessaryUpgradeQuantityEntityList = necessaryUpgradeQuantityEntityList;
    }

    @Override
    public String toString() {
        return "CardProductEntity{" +
                "id=" + id +
                ", cardEntity=" + cardEntity +
                ", p1BuildingQuantityEntityList=" + p1BuildingQuantityEntityList +
                ", p2BuildingQuantityEntityList=" + p2BuildingQuantityEntityList +
                ", p1ResourceQuantityEntityList=" + p1ResourceQuantityEntityList +
                ", p2ResourceQuantityEntityList=" + p2ResourceQuantityEntityList +
                ", p1UpgradeQuantityEntityList=" + p1UpgradeQuantityEntityList +
                ", p2UpgradeQuantityEntityList=" + p2UpgradeQuantityEntityList +
                ", necessaryBuildingQuantityEntityList=" + necessaryBuildingQuantityEntityList +
                ", necessaryUpgradeQuantityEntityList=" + necessaryUpgradeQuantityEntityList +
                '}';
    }
}
