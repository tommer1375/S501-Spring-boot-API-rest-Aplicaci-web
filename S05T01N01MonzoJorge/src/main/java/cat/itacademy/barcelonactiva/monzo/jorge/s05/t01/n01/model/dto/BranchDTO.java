package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto;

import java.util.*;

public class BranchDTO {

    private Integer pk_BranchID;
    private String nameBranch;
    private String countryBranch;
    private String typeBranch;

    private static final List<String> countriesUE = List.of("Austria", "Bélgica", "Bulgaria", "Croacia", "Chipre",
            "República Checa", "Dinamarca", "Estonia", "Finlandia", "Francia", "Alemania", "Grecia", "Hungría", "Irlanda",
            "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia", "Portugal", "Rumania",
            "Eslovaquia", "Eslovenia", "España", "Suecia");


    public BranchDTO() {
    }

    public BranchDTO(Integer pk_BranchID, String nameBranch, String countryBranch) {
        this.pk_BranchID = pk_BranchID;
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
        this.typeBranch = checkCountryBranch(countryBranch);
    }

    public Integer getPk_BranchID() {
        return pk_BranchID;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public String getCountryBranch() {
        return countryBranch;
    }

    public String getTypeBranch() {
        return typeBranch;
    }

    public void setPk_BranchID(Integer pk_BranchID) {
        this.pk_BranchID = pk_BranchID;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;
    }

    public void setTypeBranch(String typeBranch) {
        this.typeBranch = typeBranch;
    }

    public static String checkCountryBranch (String country) {
        if (countriesUE.contains(country)) {
            return "UE";
        } else {
            return "Outside UE";
        }
    }
}



