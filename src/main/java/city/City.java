package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building){
        if (calculateReservedArea()+building.getArea() > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
        buildings.add(building);
    }

    public Building findHighestBuilding(){
        Building highestBuilding = buildings.get(0);
        int largestNumberOfLevels = 0;
        for (Building building : buildings){
            if (largestNumberOfLevels<building.getLevels()){
                highestBuilding = building;
                largestNumberOfLevels = building.getLevels();
            }
        }
        return highestBuilding;
    }

    public List<Building> findBuildingsByStreet(String street){
        List<Building> buildingsInStreet = new ArrayList<>();
        for (Building building : buildings){
            if (building.getAddress().getStreet().equals(street)){
                buildingsInStreet.add(building);
            }
        }
        return buildingsInStreet;
    }

    private int calculateReservedArea(){
        int reservedArea = 0;
        for (Building building : buildings){
            reservedArea += building.getArea();
        }
        return reservedArea;
    }

    public boolean isThereBuildingWithMorePeopleThan(int number){
        for (Building building : buildings){
            if (building.calculateNumberOfPeopleCanFit()>number){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }


}
