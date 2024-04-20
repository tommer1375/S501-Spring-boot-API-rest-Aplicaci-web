package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.domain;


public class Flowers {


    private Integer  pk_FlowerID;

    private String flowerName;

    private String flowerCountry;

    public Flowers (){

    }
    public Flowers (Integer pk_FlowerID, String flowerName, String flowerCountry) {
        this.pk_FlowerID = pk_FlowerID;
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
    }

    public Integer getPk_FlowerID() {
        return pk_FlowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public String getFlowerCountry() {
        return flowerCountry;
    }

    public void setPk_FlowerID(Integer pk_FlowerID) {
        this.pk_FlowerID = pk_FlowerID;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setFlowerCountry(String flowerCountry) {
        this.flowerCountry = flowerCountry;
    }

}


