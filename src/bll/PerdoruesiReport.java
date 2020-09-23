/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adis Durguti
 */
@Entity
@Table(name = "PerdoruesiReport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerdoruesiReport.findAll", query = "SELECT p FROM PerdoruesiReport p"),
    @NamedQuery(name = "PerdoruesiReport.findByReportID", query = "SELECT p FROM PerdoruesiReport p WHERE p.reportID = :reportID"),
    @NamedQuery(name = "PerdoruesiReport.findByStatus", query = "SELECT p FROM PerdoruesiReport p WHERE p.status = :status"),
    @NamedQuery(name = "PerdoruesiReport.findByDate", query = "SELECT p FROM PerdoruesiReport p WHERE p.date = :date"),
    @NamedQuery(name = "PerdoruesiReport.findByTime", query = "SELECT p FROM PerdoruesiReport p WHERE p.time = :time")})
public class PerdoruesiReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reportID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer reportID;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @JoinColumn(name = "perdoruesiID", referencedColumnName = "perdoruesiID")
    @ManyToOne(optional = false)
    private Perdoruesi perdoruesiID;

    public PerdoruesiReport() {
    }

    public PerdoruesiReport(Integer reportID) {
        this.reportID = reportID;
    }

    public PerdoruesiReport(Integer reportID, String status, Date date, Date time) {
        this.reportID = reportID;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Perdoruesi getPerdoruesiID() {
        return perdoruesiID;
    }

    public void setPerdoruesiID(Perdoruesi perdoruesiID) {
        this.perdoruesiID = perdoruesiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportID != null ? reportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerdoruesiReport)) {
            return false;
        }
        PerdoruesiReport other = (PerdoruesiReport) object;
        if ((this.reportID == null && other.reportID != null) || (this.reportID != null && !this.reportID.equals(other.reportID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bll.PerdoruesiReport[ reportID=" + reportID + " ]";
    }
    
}
