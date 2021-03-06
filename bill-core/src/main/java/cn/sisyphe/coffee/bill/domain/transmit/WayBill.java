package cn.sisyphe.coffee.bill.domain.transmit;


import cn.sisyphe.coffee.bill.domain.base.model.BaseEntity;
import cn.sisyphe.coffee.bill.domain.transmit.enums.ReceivedStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 运货单
 */
@Entity
@Table
public class WayBill extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wayBill")
    private Set<WayBillDetail> wayBillDetailSet = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;


    @Column(length = 255, nullable = false)
    private String billCode;


    /**
     * 出库站点
     */
    @Column(length = 255)
    private String outStationCode;

    /**
     * 入库站点
     */
    @Column(length = 255)
    private String inStationCode;

    /**
     * 发货时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(nullable = false)
    private Date deliveryTime;

    /**
     * 预计到货时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date planArrivalTime;

    /**
     * 物流公司名称
     */
    @Column(nullable = false)
    private String logisticsCompanyName;

    /**
     * 目的地
     */
    @Column(nullable = false)
    private String destination;


    /**
     * 运货件数
     */
    @Column(nullable = false)
    private Integer amountOfPackages;

    /**
     * 总重量
     */
    @Column
    private Long totalWeight;

    /**
     * 备注
     */
    @Column
    private String memo;

    @Column
    private String operatorCode;

    /**
     * 操作人姓名
     */
    @Column
    private String operatorName;


    /**
     * 收货状态
     */
    @Column
    @Enumerated(value = EnumType.STRING)
    private ReceivedStatusEnum receivedStatus;


    /**
     * 运货件数
     *
     * @return
     */
    private int calcTotalPackageAmoumt() {
        int totalAmount = 0;
        if (wayBillDetailSet == null) {
            return 0;
        }
        for (WayBillDetail wayBillDetail : wayBillDetailSet) {
            //
            if (!wayBillDetail.getPackageCode().equals("")) {
                totalAmount += 1;
            }
        }
        return totalAmount;
    }


    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public ReceivedStatusEnum getReceivedStatus() {
        return receivedStatus;
    }

    public void setReceivedStatus(ReceivedStatusEnum receivedStatus) {
        this.receivedStatus = receivedStatus;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }


    public String getInStationCode() {
        return inStationCode;
    }

    public void setInStationCode(String inStationCode) {
        this.inStationCode = inStationCode;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getPlanArrivalTime() {
        return planArrivalTime;
    }

    public void setPlanArrivalTime(Date planArrivalTime) {
        this.planArrivalTime = planArrivalTime;
    }

    public String getLogisticsCompanyName() {
        return logisticsCompanyName;
    }

    public void setLogisticsCompanyName(String logisticsCompanyName) {
        this.logisticsCompanyName = logisticsCompanyName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getAmountOfPackages() {
        return amountOfPackages;
    }

    public void setAmountOfPackages(Integer amountOfPackages) {
        this.amountOfPackages = amountOfPackages;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }


    public Set<WayBillDetail> getWayBillDetailSet() {
        return wayBillDetailSet;
    }

    public void setWayBillDetailSet(Set<WayBillDetail> wayBillDetailSet) {
        this.wayBillDetailSet = wayBillDetailSet;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getOutStationCode() {
        return outStationCode;
    }

    public void setOutStationCode(String outStationCode) {
        this.outStationCode = outStationCode;
    }

    @Override
    public String toString() {
        return "WayBill{" +
                "deliveryTime=" + deliveryTime +
                ", planArrivalTime=" + planArrivalTime +
                ", logisticsCompanyName='" + logisticsCompanyName + '\'' +
                ", destination='" + destination + '\'' +
                ", amountOfPackages=" + amountOfPackages +
                ", totalWeight=" + totalWeight +
                ", memo='" + memo + '\'' +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }
}
