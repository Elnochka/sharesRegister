package com.september.model;

import java.util.Objects;

public class HistoryShare {
    private Integer idHistoryShare;
    private Long edrpou;
    private String nameField;
    private String oldValue;
    private String newValue;

    public HistoryShare(Integer idHistoryShare, Long edrpou, String nameField, String oldValue, String newValue) {
        this.idHistoryShare = idHistoryShare;
        this.edrpou = edrpou;
        this.nameField = nameField;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public HistoryShare(Long edrpou, String nameField, String oldValue, String newValue) {
        this.edrpou = edrpou;
        this.nameField = nameField;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public HistoryShare() {
    }

    public Integer getIdHistoryShare() {
        return idHistoryShare;
    }

    public void setIdHistoryShare(Integer idHistoryShare) {
        this.idHistoryShare = idHistoryShare;
    }

    public Long getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(Long edrpou) {
        this.edrpou = edrpou;
    }

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return "HistoryShare{" +
                "idHistoryShare=" + idHistoryShare +
                ", edrpou=" + edrpou +
                ", nameField='" + nameField + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryShare that = (HistoryShare) o;
        return Objects.equals(idHistoryShare, that.idHistoryShare) &&
                Objects.equals(edrpou, that.edrpou) &&
                Objects.equals(nameField, that.nameField) &&
                Objects.equals(oldValue, that.oldValue) &&
                Objects.equals(newValue, that.newValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idHistoryShare, edrpou, nameField, oldValue, newValue);
    }
}
