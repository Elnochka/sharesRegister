package com.september.model;

import java.util.Date;
import java.util.Objects;

public class Share {
    private Integer idShare;
    private String comment;
    private Long edrpou;
    private Integer quantity;
    private Double commonValue;
    private Double value;
    private String dateShare;
    private String status;


    public Share(Integer idShare, String comment, Long edrpou, Integer quantity, Double commonValue, Double value, String dateShare, String status) {
        this.idShare = idShare;
        this.comment = comment;
        this.edrpou = edrpou;
        this.quantity = quantity;
        this.commonValue = commonValue;
        this.value = value;
        this.dateShare = dateShare;
        this.status = status;

    }

    public Share() {
    }

    public Share(String comment, Long edrpou, Integer quantity, Double commonValue, Double value, String dateShare, String status) {

        this.comment = comment;
        this.edrpou = edrpou;
        this.quantity = quantity;
        this.commonValue = commonValue;
        this.value = value;
        this.dateShare = dateShare;
        this.status = status;

    }

    public Share(String comment, Integer quantity, Double commonValue, Double value, String dateShare, String status) {
        this.comment = comment;
        this.quantity = quantity;
        this.commonValue = commonValue;
        this.value = value;
        this.dateShare = dateShare;
        this.status = status;
    }

    public Share(String comment, Long edrpou, Integer quantity, Double value, String dateShare, String status) {
        this.comment = comment;
        this.edrpou = edrpou;
        this.quantity = quantity;
        this.value = value;
        this.dateShare = dateShare;
        this.status = status;
        this.commonValue = value * quantity;
    }

    public Share(String comment, Integer quantity, Double value, String dateShare, String status) {
        this.comment = comment;
        this.quantity = quantity;
        this.value = value;
        this.dateShare = dateShare;
        this.status = status;
        this.commonValue = value * quantity;
    }

    public Integer getIdShare() {
        return idShare;
    }

    public void setIdShare(Integer idShare) {
        this.idShare = idShare;
    }

    public Long getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(Long edrpou) {
        this.edrpou = edrpou;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCommonValue() {
        return commonValue;
    }

    public void setCommonValue(Double commonValue) {
        this.commonValue = commonValue;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDateShare() {
        return dateShare;
    }

    public void setDateShare(String dateShare) {
        this.dateShare = dateShare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Share share = (Share) o;
        return Objects.equals(idShare, share.idShare) &&
                Objects.equals(comment, share.comment) &&
                Objects.equals(edrpou, share.edrpou) &&
                Objects.equals(quantity, share.quantity) &&
                Objects.equals(commonValue, share.commonValue) &&
                Objects.equals(value, share.value) &&
                Objects.equals(dateShare, share.dateShare) &&
                Objects.equals(status, share.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idShare, comment, edrpou, quantity, commonValue, value, dateShare, status);
    }

    @Override
    public String toString() {
        return "Share{" +
                "idShare=" + idShare +
                ", comment='" + comment + '\'' +
                ", edrpou=" + edrpou +
                ", quantity=" + quantity +
                ", commonValue=" + commonValue +
                ", value=" + value +
                ", dateShare='" + dateShare + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
