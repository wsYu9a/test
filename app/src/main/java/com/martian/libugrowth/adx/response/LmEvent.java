package com.martian.libugrowth.adx.response;

import java.util.List;

/* loaded from: classes3.dex */
public class LmEvent {
    private List<String> clk;

    /* renamed from: com */
    private List<String> f10662com;
    private List<String> first;
    private List<String> imp;
    private List<String> mid;
    private List<String> third;
    private List<LmUdef> udef;

    public List<String> getClk() {
        return this.clk;
    }

    public List<String> getCom() {
        return this.f10662com;
    }

    public List<String> getFirst() {
        return this.first;
    }

    public List<String> getImp() {
        return this.imp;
    }

    public List<String> getMid() {
        return this.mid;
    }

    public List<String> getStepUrls(int step) {
        if (step == 0) {
            return this.imp;
        }
        if (step == 1) {
            return this.first;
        }
        if (step == 2) {
            return this.mid;
        }
        if (step == 3) {
            return this.third;
        }
        if (step != 4) {
            return null;
        }
        return this.f10662com;
    }

    public List<String> getThird() {
        return this.third;
    }

    public List<LmUdef> getUdef() {
        return this.udef;
    }

    public int getValidEvents() {
        List<String> list = this.imp;
        int i2 = (list == null || list.isEmpty()) ? 0 : 1;
        List<String> list2 = this.first;
        if (list2 != null && !list2.isEmpty()) {
            i2++;
        }
        List<String> list3 = this.mid;
        if (list3 != null && !list3.isEmpty()) {
            i2++;
        }
        List<String> list4 = this.third;
        if (list4 != null && !list4.isEmpty()) {
            i2++;
        }
        List<String> list5 = this.f10662com;
        return (list5 == null || list5.isEmpty()) ? i2 : i2 + 1;
    }

    public void setClk(List<String> clk) {
        this.clk = clk;
    }

    public void setCom(List<String> com2) {
        this.f10662com = com2;
    }

    public void setFirst(List<String> first) {
        this.first = first;
    }

    public void setImp(List<String> imp) {
        this.imp = imp;
    }

    public void setMid(List<String> mid) {
        this.mid = mid;
    }

    public void setThird(List<String> third) {
        this.third = third;
    }

    public void setUdef(List<LmUdef> udef) {
        this.udef = udef;
    }
}
