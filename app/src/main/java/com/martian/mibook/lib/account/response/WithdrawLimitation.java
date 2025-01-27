package com.martian.mibook.lib.account.response;

import java.util.List;

/* loaded from: classes3.dex */
public class WithdrawLimitation {

    /* renamed from: a */
    private Boolean f13926a;
    private List<TYWithdrawBookCoins> bookCoinsList;
    private String bookCoinsRules;
    private Boolean enableBookCoins;
    private Boolean enableTax;
    private List<TYWithdrawMoneyItem> moneyItems;
    private List<Integer> moneyList;
    private String moneyRules;
    private Integer withdrawLeftCount;
    private Integer withdrawMoneyMonthly;

    public boolean getA() {
        Boolean bool = this.f13926a;
        return bool != null && bool.booleanValue();
    }

    public List<TYWithdrawBookCoins> getBookCoinsList() {
        return this.bookCoinsList;
    }

    public String getBookCoinsRules() {
        return this.bookCoinsRules;
    }

    public boolean getEnableBookCoins() {
        Boolean bool = this.enableBookCoins;
        return bool != null && bool.booleanValue();
    }

    public boolean getEnableTax() {
        Boolean bool = this.enableTax;
        return bool != null && bool.booleanValue();
    }

    public List<TYWithdrawMoneyItem> getMoneyItems() {
        return this.moneyItems;
    }

    public List<Integer> getMoneyList() {
        return this.moneyList;
    }

    public String getMoneyRules() {
        return this.moneyRules;
    }

    public int getWithdrawLeftCount() {
        Integer num = this.withdrawLeftCount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getWithdrawMoneyMonthly() {
        Integer num = this.withdrawMoneyMonthly;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setA(Boolean a2) {
        this.f13926a = a2;
    }

    public void setBookCoinsList(List<TYWithdrawBookCoins> bookCoinsList) {
        this.bookCoinsList = bookCoinsList;
    }

    public void setBookCoinsRules(String bookCoinsRules) {
        this.bookCoinsRules = bookCoinsRules;
    }

    public void setEnableBookCoins(Boolean enableBookCoins) {
        this.enableBookCoins = enableBookCoins;
    }

    public void setEnableTax(Boolean enableTax) {
        this.enableTax = enableTax;
    }

    public void setMoneyItems(List<TYWithdrawMoneyItem> moneyItems) {
        this.moneyItems = moneyItems;
    }

    public void setMoneyList(List<Integer> moneyList) {
        this.moneyList = moneyList;
    }

    public void setMoneyRules(String moneyRules) {
        this.moneyRules = moneyRules;
    }

    public void setWithdrawLeftCount(Integer withdrawLeftCount) {
        this.withdrawLeftCount = withdrawLeftCount;
    }

    public void setWithdrawMoneyMonthly(Integer withdrawMoneyMonthly) {
        this.withdrawMoneyMonthly = withdrawMoneyMonthly;
    }
}
