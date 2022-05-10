package com.HomeFluent.Homeaccount.dto;

public class HomeLoan implements Debts{

    private long principle;
    private long totalAmount;
    private int intersetRate;
    DebtsCategories debtcat;
    

    public void setPrinciple(long principle) {
        this.principle = principle;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setIntersetRate(int intersetRate) {
        this.intersetRate = intersetRate;
    }

    @Override
    public long getRepayment() {
        // TODO Auto-generated method stub
        return this.totalAmount;
    }

    @Override
    public String getLoanType() {
        // TODO Auto-generated method stub
        return debtcat.HOME_LOAN.toString();
    }

    @Override
    public int getIntererstRate() {
        return this.intersetRate;
    }

    @Override
    public long getPrinciple() {
        // TODO Auto-generated method stub
        return this.principle;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((debtcat == null) ? 0 : debtcat.hashCode());
        result = prime * result + intersetRate;
        result = prime * result + (int) (principle ^ (principle >>> 32));
        result = prime * result + (int) (totalAmount ^ (totalAmount >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HomeLoan other = (HomeLoan) obj;
        if (debtcat != other.debtcat)
            return false;
        if (intersetRate != other.intersetRate)
            return false;
        if (principle != other.principle)
            return false;
        if (totalAmount != other.totalAmount)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "HomeLoan [debtcat=" + debtcat + ", intersetRate=" + intersetRate + ", principle=" + principle
                + ", totalAmount=" + totalAmount + "]";
    }
    
}
