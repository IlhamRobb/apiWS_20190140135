/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.c5;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IlhamRobbS
 */
@Entity
@Table(name = "nyucidong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nyucidong.findAll", query = "SELECT n FROM Nyucidong n"),
    @NamedQuery(name = "Nyucidong.findByIdKendaraan", query = "SELECT n FROM Nyucidong n WHERE n.idKendaraan = :idKendaraan"),
    @NamedQuery(name = "Nyucidong.findByJenisKendaraan", query = "SELECT n FROM Nyucidong n WHERE n.jenisKendaraan = :jenisKendaraan"),
    @NamedQuery(name = "Nyucidong.findByMerkKendaraan", query = "SELECT n FROM Nyucidong n WHERE n.merkKendaraan = :merkKendaraan"),
    @NamedQuery(name = "Nyucidong.findByNomorKendaraan", query = "SELECT n FROM Nyucidong n WHERE n.nomorKendaraan = :nomorKendaraan"),
    @NamedQuery(name = "Nyucidong.findByStatus", query = "SELECT n FROM Nyucidong n WHERE n.status = :status")})
public class Nyucidong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kendaraan")
    private Integer idKendaraan;
    @Column(name = "jenis_kendaraan")
    private String jenisKendaraan;
    @Column(name = "merk_kendaraan")
    private String merkKendaraan;
    @Column(name = "nomor_kendaraan")
    private String nomorKendaraan;
    @Column(name = "Status")
    private String status;

    public Nyucidong() {
    }

    public Nyucidong(Integer idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public Integer getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(Integer idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public void setMerkKendaraan(String merkKendaraan) {
        this.merkKendaraan = merkKendaraan;
    }

    public String getNomorKendaraan() {
        return nomorKendaraan;
    }

    public void setNomorKendaraan(String nomorKendaraan) {
        this.nomorKendaraan = nomorKendaraan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKendaraan != null ? idKendaraan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nyucidong)) {
            return false;
        }
        Nyucidong other = (Nyucidong) object;
        if ((this.idKendaraan == null && other.idKendaraan != null) || (this.idKendaraan != null && !this.idKendaraan.equals(other.idKendaraan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pws.c5.Nyucidong[ idKendaraan=" + idKendaraan + " ]";
    }
    
}
