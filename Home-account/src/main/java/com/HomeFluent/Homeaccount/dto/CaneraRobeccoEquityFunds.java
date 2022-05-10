package com.HomeFluent.Homeaccount.dto;

public class CaneraRobeccoEquityFunds implements MutualFunds {
    private long totalInvestedAmount;
    private long totalReturnAmount;
    private int interestRate;



    public void setTotalInvestedAmount(long totalInvestedAmount) {
        this.totalInvestedAmount = totalInvestedAmount;
    }

 

    public void setTotalReturnAmount(long totalReturnAmount) {
        this.totalReturnAmount = totalReturnAmount;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public long getInterestRate() {
        // TODO Auto-generated method stub
        return this.interestRate;
    }

    @Override
    public long getReturns() {
        // TODO Auto-generated method stub
        return this.totalReturnAmount;
    }

    @Override
    public long getInvestedAmount() {
        // TODO Auto-generated method stub
        return this.totalInvestedAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + interestRate;
        result = prime * result + (int) (totalInvestedAmount ^ (totalInvestedAmount >>> 32));
        result = prime * result + (int) (totalReturnAmount ^ (totalReturnAmount >>> 32));
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
        CaneraRobeccoEquityFunds other = (CaneraRobeccoEquityFunds) obj;
        if (interestRate != other.interestRate)
            return false;
        if (totalInvestedAmount != other.totalInvestedAmount)
            return false;
        if (totalReturnAmount != other.totalReturnAmount)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CaneraRobeccoEquityFunds [interestRate=" + interestRate + ", totalInvestedAmount=" + totalInvestedAmount
                + ", totalReturnAmount=" + totalReturnAmount + "]";
    }

    
    
}
