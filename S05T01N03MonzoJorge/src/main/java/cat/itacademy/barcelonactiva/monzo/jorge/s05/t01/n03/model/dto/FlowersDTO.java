package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.dto;


import java.util.List;

public class FlowersDTO {

    private Integer pk_FlowersID;
    private String flowerName;
    private String flowerCountry;
    private String flowerType;

    private static final List<String> countriesUE = List.of("Alemania", "Austria", "Bélgica", "Bulgaria",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia");

    public FlowersDTO() {
    }

    public FlowersDTO(Integer pk_FlowersID, String flowerName, String flowerCountry) {
        this.pk_FlowersID = pk_FlowersID;
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
        this.flowerType = checkCountryFlowers(flowerCountry);
    }

    public Integer getPk_FlowersID() {
        return pk_FlowersID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public String getFlowerCountry() {
        return flowerCountry;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setPk_FlowersID(Integer pk_FlowersID) {
        this.pk_FlowersID = pk_FlowersID;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setFlowerCountry(String flowerCountry) {
        this.flowerCountry = flowerCountry;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public static String checkCountryFlowers (String countryBranch) {

        if (countriesUE.contains(countryBranch)) {
            return "UE";
        } else {
            return "Not UE";
        }
    }
}