package game.controllers.dto;

import java.util.List;

public class CardProductDto {
    private Integer id;
    private CardDto card;
    private List<AccountBuildingDto> p1buildingList;
    private List<AccountBuildingDto> p2buildingList;
    private List<AccountResourceDto> p1accountResourceList;
    private List<AccountResourceDto> p2accountResourceList;
    private List<AccountUpgradeDto> p1accountUpgradeList;
    private List<AccountUpgradeDto> p2accountUpgradeList;
    private List<AccountBuildingDto> necessaryBuildingList;
    private List<AccountUpgradeDto> necessaryAccountUpgradeList;

    public CardProductDto() {}

    public CardProductDto(Integer id, CardDto card, List<AccountBuildingDto> p1buildingList, List<AccountBuildingDto> p2buildingList, List<AccountResourceDto> p1accountResourceList, List<AccountResourceDto> p2accountResourceList, List<AccountUpgradeDto> p1accountUpgradeList, List<AccountUpgradeDto> p2accountUpgradeList, List<AccountBuildingDto> necessaryBuildingList, List<AccountUpgradeDto> necessaryAccountUpgradeList) {
        this.id = id;
        this.card = card;
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

    public CardDto getCard() {
        return card;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }

    public List<AccountBuildingDto> getP1buildingList() {
        return p1buildingList;
    }

    public void setP1buildingList(List<AccountBuildingDto> p1buildingList) {
        this.p1buildingList = p1buildingList;
    }

    public List<AccountBuildingDto> getP2buildingList() {
        return p2buildingList;
    }

    public void setP2buildingList(List<AccountBuildingDto> p2buildingList) {
        this.p2buildingList = p2buildingList;
    }

    public List<AccountResourceDto> getP1accountResourceList() {
        return p1accountResourceList;
    }

    public void setP1accountResourceList(List<AccountResourceDto> p1accountResourceList) {
        this.p1accountResourceList = p1accountResourceList;
    }

    public List<AccountResourceDto> getP2accountResourceList() {
        return p2accountResourceList;
    }

    public void setP2accountResourceList(List<AccountResourceDto> p2accountResourceList) {
        this.p2accountResourceList = p2accountResourceList;
    }

    public List<AccountUpgradeDto> getP1accountUpgradeList() {
        return p1accountUpgradeList;
    }

    public void setP1accountUpgradeList(List<AccountUpgradeDto> p1accountUpgradeList) {
        this.p1accountUpgradeList = p1accountUpgradeList;
    }

    public List<AccountUpgradeDto> getP2accountUpgradeList() {
        return p2accountUpgradeList;
    }

    public void setP2accountUpgradeList(List<AccountUpgradeDto> p2accountUpgradeList) {
        this.p2accountUpgradeList = p2accountUpgradeList;
    }

    public List<AccountBuildingDto> getNecessaryBuildingList() {
        return necessaryBuildingList;
    }

    public void setNecessaryBuildingList(List<AccountBuildingDto> necessaryBuildingList) {
        this.necessaryBuildingList = necessaryBuildingList;
    }

    public List<AccountUpgradeDto> getNecessaryAccountUpgradeList() {
        return necessaryAccountUpgradeList;
    }

    public void setNecessaryAccountUpgradeList(List<AccountUpgradeDto> necessaryAccountUpgradeList) {
        this.necessaryAccountUpgradeList = necessaryAccountUpgradeList;
    }

    @Override
    public String toString() {
        return "CardProductDto{" +
                "id=" + id +
                ", card=" + card +
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
