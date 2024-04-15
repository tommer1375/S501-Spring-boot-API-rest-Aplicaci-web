package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto;

import java.util.*;
import jakarta.validation.constraints.NotEmpty;


public class BranchDTO {

    private Integer pk_BranchID;
    private String nameBranch;
    private String countryBranch;
    private String typeBranch;

    private static final List<String> countriesUE = Arrays.asList("Alemania", "Austria", "Bélgica", "Bulgaria",
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
    @NotEmpty(message = "El nombre no puede estar en blanco.")
    public String getNameBranch() {
        return nameBranch;
    }
    @NotEmpty(message = "El país no puede estar en blanco.")
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

    public static String checkCountryBranch () {

        String resultado = "";

        if(countryBranch != null){
            Collator collator = Collator.getInstance(Locale.getDefault());
            collator.setStrength(Collator.PRIMARY); // Ignora acentos y mayúsculas/minúsculas.

            resultado = PAISES_EU.stream().anyMatch(pais -> collator.equals(pais, paisSucursal)) ? "EU" : "Fuera de la UE";
        } else {
            resultado = "Pais no especificado.";
        }

        return resultado;





        if (countriesUE.contains(country)) {
            return "UE";
        } else {
            return "Outside UE";
        }
    }
}



