package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_BranchID;


    @Column(name = "name")
    private String nameBranch;

    @Column(name = "country")
    private String countryBranch;

    public Branch() {}


    public Branch (String nameBranch, String countryBranch){
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
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

    public void setPk_BranchID(Integer pk_BranchID) {
        this.pk_BranchID = pk_BranchID;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;
    }
}
