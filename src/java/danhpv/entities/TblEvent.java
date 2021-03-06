/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhpv.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "tblEvent", catalog = "ClubManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEvent.findAll", query = "SELECT t FROM TblEvent t")
    , @NamedQuery(name = "TblEvent.findByEventID", query = "SELECT t FROM TblEvent t WHERE t.eventID = :eventID")
    , @NamedQuery(name = "TblEvent.findByEventName", query = "SELECT t FROM TblEvent t WHERE t.eventName = :eventName")
    , @NamedQuery(name = "TblEvent.findByEventDesc", query = "SELECT t FROM TblEvent t WHERE t.eventDesc = :eventDesc")
    , @NamedQuery(name = "TblEvent.findByBanner", query = "SELECT t FROM TblEvent t WHERE t.banner = :banner")
    , @NamedQuery(name = "TblEvent.findByTimeCloseRegister", query = "SELECT t FROM TblEvent t WHERE t.timeCloseRegister = :timeCloseRegister")
    , @NamedQuery(name = "TblEvent.findByTimeStartEvent", query = "SELECT t FROM TblEvent t WHERE t.timeStartEvent = :timeStartEvent")
    , @NamedQuery(name = "TblEvent.findByTimeCloseEvent", query = "SELECT t FROM TblEvent t WHERE t.timeCloseEvent = :timeCloseEvent")
    , @NamedQuery(name = "TblEvent.findByLocator", query = "SELECT t FROM TblEvent t WHERE t.locator = :locator")
    , @NamedQuery(name = "TblEvent.findByTotal", query = "SELECT t FROM TblEvent t WHERE t.total = :total")
    , @NamedQuery(name = "TblEvent.findByIsInternal", query = "SELECT t FROM TblEvent t WHERE t.isInternal = :isInternal")
    , @NamedQuery(name = "TblEvent.findByNumRegister", query = "SELECT t FROM TblEvent t WHERE t.numRegister = :numRegister")
    , @NamedQuery(name = "TblEvent.findByEventStatus", query = "SELECT t FROM TblEvent t WHERE t.eventStatus = :eventStatus")})
public class TblEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "eventID", nullable = false, length = 20)
    private String eventID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eventName", nullable = false, length = 50)
    private String eventName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "eventDesc", nullable = false, length = 1000)
    private String eventDesc;
    @Size(max = 200)
    @Column(name = "banner", length = 200)
    private String banner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeCloseRegister", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCloseRegister;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeStartEvent", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStartEvent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeCloseEvent", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCloseEvent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "locator", nullable = false, length = 100)
    private String locator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total", nullable = false)
    private int total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isInternal", nullable = false)
    private boolean isInternal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numRegister", nullable = false)
    private int numRegister;
    @Size(max = 20)
    @Column(name = "eventStatus", length = 20)
    private String eventStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private Collection<TblNotifications> tblNotificationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private Collection<TblComment> tblCommentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private Collection<TblEventDetail> tblEventDetailCollection;

    public TblEvent() {
    }

    public TblEvent(String eventID) {
        this.eventID = eventID;
    }

    public TblEvent(String eventID, String eventName, String eventDesc, Date timeCloseRegister, Date timeStartEvent, Date timeCloseEvent, String locator, int total, boolean isInternal, int numRegister) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.timeCloseRegister = timeCloseRegister;
        this.timeStartEvent = timeStartEvent;
        this.timeCloseEvent = timeCloseEvent;
        this.locator = locator;
        this.total = total;
        this.isInternal = isInternal;
        this.numRegister = numRegister;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getTimeCloseRegister() {
        return timeCloseRegister;
    }

    public void setTimeCloseRegister(Date timeCloseRegister) {
        this.timeCloseRegister = timeCloseRegister;
    }

    public Date getTimeStartEvent() {
        return timeStartEvent;
    }

    public void setTimeStartEvent(Date timeStartEvent) {
        this.timeStartEvent = timeStartEvent;
    }

    public Date getTimeCloseEvent() {
        return timeCloseEvent;
    }

    public void setTimeCloseEvent(Date timeCloseEvent) {
        this.timeCloseEvent = timeCloseEvent;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(boolean isInternal) {
        this.isInternal = isInternal;
    }

    public int getNumRegister() {
        return numRegister;
    }

    public void setNumRegister(int numRegister) {
        this.numRegister = numRegister;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    @XmlTransient
    public Collection<TblNotifications> getTblNotificationsCollection() {
        return tblNotificationsCollection;
    }

    public void setTblNotificationsCollection(Collection<TblNotifications> tblNotificationsCollection) {
        this.tblNotificationsCollection = tblNotificationsCollection;
    }

    @XmlTransient
    public Collection<TblComment> getTblCommentCollection() {
        return tblCommentCollection;
    }

    public void setTblCommentCollection(Collection<TblComment> tblCommentCollection) {
        this.tblCommentCollection = tblCommentCollection;
    }

    @XmlTransient
    public Collection<TblEventDetail> getTblEventDetailCollection() {
        return tblEventDetailCollection;
    }

    public void setTblEventDetailCollection(Collection<TblEventDetail> tblEventDetailCollection) {
        this.tblEventDetailCollection = tblEventDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEvent)) {
            return false;
        }
        TblEvent other = (TblEvent) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "danhpv.entities.TblEvent[ eventID=" + eventID + " ]";
    }
    
}
