package com.wiktorkielar.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

import static com.wiktorkielar.constants.ValidationConstants.FIELD_CANNOT_BE_EMPTY_PL;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "contract_number")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String contractNumber;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "amount")
    private double amount;

    @Column(name = "billing_period")
    @NotBlank(message = FIELD_CANNOT_BE_EMPTY_PL)
    private String billingPeriod;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "system_id")
    private System system;

    public Contract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (id != contract.id) return false;
        if (Double.compare(contract.amount, amount) != 0) return false;
        if (active != contract.active) return false;
        if (contractNumber != null ? !contractNumber.equals(contract.contractNumber) : contract.contractNumber != null)
            return false;
        if (startDate != null ? !startDate.equals(contract.startDate) : contract.startDate != null) return false;
        if (endDate != null ? !endDate.equals(contract.endDate) : contract.endDate != null) return false;
        if (billingPeriod != null ? !billingPeriod.equals(contract.billingPeriod) : contract.billingPeriod != null)
            return false;
        return system != null ? system.equals(contract.system) : contract.system == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (contractNumber != null ? contractNumber.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (billingPeriod != null ? billingPeriod.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", contractNumber='" + contractNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", billingPeriod='" + billingPeriod + '\'' +
                ", active=" + active +
                ", system=" + system +
                '}';
    }
}
