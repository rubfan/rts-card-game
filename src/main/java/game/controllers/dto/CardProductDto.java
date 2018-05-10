package game.controllers.dto;

import java.util.List;

public class CardProductDto {
    private Integer id;
    private CardDto cardDto;
    private List<BuildingQuantityDto> p1BuildingQuantityDtoList;
    private List<BuildingQuantityDto> p2BuildingQuantityDtoList;
    private List<ResourceQuantityDto> p1ResourceQuantityDtoList;
    private List<ResourceQuantityDto> p2ResourceQuantityDtoList;
    private List<UpgradeQuantityDto> p1UpgradeQuantityDtoList;
    private List<UpgradeQuantityDto> p2UpgradeQuantityDtoList;
    private List<BuildingQuantityDto> necessaryBuildingQuantityDtoList;
    private List<UpgradeQuantityDto> necessaryUpgradeQuantityDtoList;

    public CardProductDto() {}


    public CardProductDto(Integer id, CardDto cardDto, List<BuildingQuantityDto> p1BuildingQuantityDtoList,
                          List<BuildingQuantityDto> p2BuildingQuantityDtoList,
                          List<ResourceQuantityDto> p1ResourceQuantityDtoList,
                          List<ResourceQuantityDto> p2ResourceQuantityDtoList,
                          List<UpgradeQuantityDto> p1UpgradeQuantityDtoList,
                          List<UpgradeQuantityDto> p2UpgradeQuantityDtoList,
                          List<BuildingQuantityDto> necessaryBuildingQuantityDtoList,
                          List<UpgradeQuantityDto> necessaryUpgradeQuantityDtoList) {
        this.id = id;
        this.cardDto = cardDto;
        this.p1BuildingQuantityDtoList = p1BuildingQuantityDtoList;
        this.p2BuildingQuantityDtoList = p2BuildingQuantityDtoList;
        this.p1ResourceQuantityDtoList = p1ResourceQuantityDtoList;
        this.p2ResourceQuantityDtoList = p2ResourceQuantityDtoList;
        this.p1UpgradeQuantityDtoList = p1UpgradeQuantityDtoList;
        this.p2UpgradeQuantityDtoList = p2UpgradeQuantityDtoList;
        this.necessaryBuildingQuantityDtoList = necessaryBuildingQuantityDtoList;
        this.necessaryUpgradeQuantityDtoList = necessaryUpgradeQuantityDtoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CardDto getCardDto() {
        return cardDto;
    }

    public void setCardDto(CardDto cardDto) {
        this.cardDto = cardDto;
    }

    public List<BuildingQuantityDto> getP1BuildingQuantityDtoList() {
        return p1BuildingQuantityDtoList;
    }

    public void setP1BuildingQuantityDtoList(List<BuildingQuantityDto> p1BuildingQuantityDtoList) {
        this.p1BuildingQuantityDtoList = p1BuildingQuantityDtoList;
    }

    public List<BuildingQuantityDto> getP2BuildingQuantityDtoList() {
        return p2BuildingQuantityDtoList;
    }

    public void setP2BuildingQuantityDtoList(List<BuildingQuantityDto> p2BuildingQuantityDtoList) {
        this.p2BuildingQuantityDtoList = p2BuildingQuantityDtoList;
    }

    public List<ResourceQuantityDto> getP1ResourceQuantityDtoList() {
        return p1ResourceQuantityDtoList;
    }

    public void setP1ResourceQuantityDtoList(List<ResourceQuantityDto> p1ResourceQuantityDtoList) {
        this.p1ResourceQuantityDtoList = p1ResourceQuantityDtoList;
    }

    public List<ResourceQuantityDto> getP2ResourceQuantityDtoList() {
        return p2ResourceQuantityDtoList;
    }

    public void setP2ResourceQuantityDtoList(List<ResourceQuantityDto> p2ResourceQuantityDtoList) {
        this.p2ResourceQuantityDtoList = p2ResourceQuantityDtoList;
    }

    public List<UpgradeQuantityDto> getP1UpgradeQuantityDtoList() {
        return p1UpgradeQuantityDtoList;
    }

    public void setP1UpgradeQuantityDtoList(List<UpgradeQuantityDto> p1UpgradeQuantityDtoList) {
        this.p1UpgradeQuantityDtoList = p1UpgradeQuantityDtoList;
    }

    public List<UpgradeQuantityDto> getP2UpgradeQuantityDtoList() {
        return p2UpgradeQuantityDtoList;
    }

    public void setP2UpgradeQuantityDtoList(List<UpgradeQuantityDto> p2UpgradeQuantityDtoList) {
        this.p2UpgradeQuantityDtoList = p2UpgradeQuantityDtoList;
    }

    public List<BuildingQuantityDto> getNecessaryBuildingQuantityDtoList() {
        return necessaryBuildingQuantityDtoList;
    }

    public void setNecessaryBuildingQuantityDtoList(List<BuildingQuantityDto> necessaryBuildingQuantityDtoList) {
        this.necessaryBuildingQuantityDtoList = necessaryBuildingQuantityDtoList;
    }

    public List<UpgradeQuantityDto> getNecessaryUpgradeQuantityDtoList() {
        return necessaryUpgradeQuantityDtoList;
    }

    public void setNecessaryUpgradeQuantityDtoList(List<UpgradeQuantityDto> necessaryUpgradeQuantityDtoList) {
        this.necessaryUpgradeQuantityDtoList = necessaryUpgradeQuantityDtoList;
    }

    @Override
    public String toString() {
        return "CardProductDto{" +
                "id=" + id +
                ", cardDto=" + cardDto +
                ", p1BuildingQuantityDtoList=" + p1BuildingQuantityDtoList +
                ", p2BuildingQuantityDtoList=" + p2BuildingQuantityDtoList +
                ", p1ResourceQuantityDtoList=" + p1ResourceQuantityDtoList +
                ", p2ResourceQuantityDtoList=" + p2ResourceQuantityDtoList +
                ", p1UpgradeQuantityDtoList=" + p1UpgradeQuantityDtoList +
                ", p2UpgradeQuantityDtoList=" + p2UpgradeQuantityDtoList +
                ", necessaryBuildingQuantityDtoList=" + necessaryBuildingQuantityDtoList +
                ", necessaryUpgradeQuantityDtoList=" + necessaryUpgradeQuantityDtoList +
                '}';
    }
}
