package cn.sisyphe.coffee.bill.domain.headquarters;

import cn.sisyphe.coffee.bill.domain.base.model.Bill;
import cn.sisyphe.coffee.bill.domain.headquarters.enums.BasicEnum;
import cn.sisyphe.coffee.bill.domain.headquarters.enums.PlanTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author ncmao
 * @Date 2017/12/25 15:38
 * @description
 */

@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class HeadQuarterBill extends Bill<HeadQuarterBillDetail> {

    @Column
    private String planName;

    @Column
    private String planCode;

    @Column
    @Enumerated(value = EnumType.STRING)
    private BasicEnum basicEnum;


    @Column
    @Enumerated(value = EnumType.STRING)
    private PlanTypeEnum planType;

    //创建人名称
    @Column
    private String creatorName;

    //审核人名称
    @Column
    private String auditorName;


    //完成度
    @Column
    private BigDecimal progress;



    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public BasicEnum getBasicEnum() {
        return basicEnum;
    }

    public void setBasicEnum(BasicEnum basicEnum) {
        this.basicEnum = basicEnum;
    }

    public PlanTypeEnum getPlanType() {
        return planType;
    }

    public void setPlanType(PlanTypeEnum planType) {
        this.planType = planType;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public BigDecimal getProgress() {
        return progress;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
    }
}
