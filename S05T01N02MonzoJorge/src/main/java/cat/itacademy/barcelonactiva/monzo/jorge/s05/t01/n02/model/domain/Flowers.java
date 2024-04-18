package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.domain;


import jakarta.persistence.*;

@Entity
@Table (name="flowers")

public class Flowers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  pk_FlowerID;
    @Column(name = "name")
    private String flowerName;
    @Column(name = "country")
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

    public boolean allNull(){
        if (flowerName != null || flowerCountry != null){
            return false;
        } else {
            return true;
        }
    }
}


