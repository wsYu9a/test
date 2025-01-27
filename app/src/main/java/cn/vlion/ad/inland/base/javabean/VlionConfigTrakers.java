package cn.vlion.ad.inland.base.javabean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class VlionConfigTrakers implements Serializable {
    private List<String> clkTrackers;
    private List<String> impTrackers;
    private int rtaRes;

    public List<String> getClkTrackers() {
        return this.clkTrackers;
    }

    public List<String> getImpTrackers() {
        return this.impTrackers;
    }

    public int getRtaRes() {
        return this.rtaRes;
    }

    public void setClkTrackers(List<String> list) {
        this.clkTrackers = list;
    }

    public void setImpTrackers(List<String> list) {
        this.impTrackers = list;
    }

    public void setRtaRes(int i10) {
        this.rtaRes = i10;
    }
}
