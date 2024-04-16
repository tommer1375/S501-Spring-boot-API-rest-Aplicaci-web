package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto;

import java.util.*;
import jakarta.validation.constraints.NotEmpty;


public class BranchDTO {

    private Integer pk_BranchID;
    @NotEmpty(message = "The name cannot be empty")
    private String nameBranch;
    @NotEmpty(message = "The name cannot be empty")
    private String countryBranch;
    private String typeBranch;

    private static final List<String> countriesUE = List.of("Alemania", "Austria", "Bélgica", "Bulgaria",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia");

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

    public static String checkCountryBranch (String countryBranch) {

        if (countriesUE.contains(countryBranch)) {
            return "UE";
        } else {
            return "Not UE";
        }
    }

}



