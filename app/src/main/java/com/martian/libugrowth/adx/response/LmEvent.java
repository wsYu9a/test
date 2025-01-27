package com.martian.libugrowth.adx.response;

import java.util.List;

/* loaded from: classes3.dex */
public class LmEvent {
    private List<String> clk;

    /* renamed from: com */
    private List<String> f13011com;
    private List<String> first;
    private List<String> imp;
    private List<String> mid;
    private List<String> third;
    private List<LmUdef> udef;

    public List<String> getClk() {
        return this.clk;
    }

    public List<String> getCom() {
        return this.f13011com;
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

    public List<String> getStepUrls(int i10) {
        if (i10 == 0) {
            return this.imp;
        }
        if (i10 == 1) {
            return this.first;
        }
        if (i10 == 2) {
            return this.mid;
        }
        if (i10 == 3) {
            return this.third;
        }
        if (i10 != 4) {
            return null;
        }
        return this.f13011com;
    }

    public List<String> getThird() {
        return this.third;
    }

    public List<LmUdef> getUdef() {
        return this.udef;
    }

    public int getValidEvents() {
        List<String> list = this.imp;
        int i10 = (list == null || list.isEmpty()) ? 0 : 1;
        List<String> list2 = this.first;
        if (list2 != null && !list2.isEmpty()) {
            i10++;
        }
        List<String> list3 = this.mid;
        if (list3 != null && !list3.isEmpty()) {
            i10++;
        }
        List<String> list4 = this.third;
        if (list4 != null && !list4.isEmpty()) {
            i10++;
        }
        List<String> list5 = this.f13011com;
        return (list5 == null || list5.isEmpty()) ? i10 : i10 + 1;
    }

    public void setClk(List<String> list) {
        this.clk = list;
    }

    public void setCom(List<String> list) {
        this.f13011com = list;
    }

    public void setFirst(List<String> list) {
        this.first = list;
    }

    public void setImp(List<String> list) {
        this.imp = list;
    }

    public void setMid(List<String> list) {
        this.mid = list;
    }

    public void setThird(List<String> list) {
        this.third = list;
    }

    public void setUdef(List<LmUdef> list) {
        this.udef = list;
    }
}
