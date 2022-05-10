package com.HomeFluent.Homeaccount.dto;

public class VehicleLoan implements Debts{
    private long principle;
    private long totalAmount;
    private int intersetRate;
    DebtsCategories debtcat;
    
    @Override
    public long getRepayment() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getLoanType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getIntererstRate() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getPrinciple() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
