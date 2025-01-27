package com.sigmob.windad.rewardVideo;

import java.util.HashMap;

/* loaded from: classes4.dex */
public class WindRewardInfo {

    /* renamed from: a */
    public final boolean f20907a;

    /* renamed from: b */
    public HashMap<String, String> f20908b;

    public WindRewardInfo(boolean z10) {
        this.f20907a = z10;
    }

    public HashMap<String, String> getOptions() {
        return this.f20908b;
    }

    public boolean isReward() {
        return this.f20907a;
    }

    public void setOptions(HashMap<String, String> hashMap) {
        this.f20908b = hashMap;
    }

    public String toString() {
        return "WindRewardInfo{isReward=" + this.f20907a + ", options=" + this.f20908b + '}';
    }

    public WindRewardInfo(boolean z10, HashMap<String, String> hashMap) {
        this.f20907a = z10;
        this.f20908b = hashMap;
    }
}
