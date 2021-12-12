package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {



    private static long loanAmount;
    private static int termInYears;
    private static float annualRate;

    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }


    private int getNumberOfPayments(){
        return termInYears *12;
    }

    private float getMonthlyInterestRate(){
        float interestRate =  annualRate/100;

        return interestRate = interestRate/12;
    }

    public void calculateMonthlyPayment(){
        long P = this.loanAmount;
        float r = this.getMonthlyInterestRate();
        int n = this.getNumberOfPayments();

        this.monthlyPayment = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));

    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");

        return "monthlyPayment: " + df.format(monthlyPayment);
    }


    public static void main(String[] args){
        loanAmount = Long.parseLong(args[0]);
        termInYears = Integer.parseInt(args[1]);
        annualRate = Float.parseFloat(args[2]);

        MortgageCalculator calculator  = new MortgageCalculator(loanAmount,termInYears,annualRate);
        calculator.calculateMonthlyPayment();

        System.out.println(calculator.toString());




    }

}
