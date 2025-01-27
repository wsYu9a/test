package com.wbl.ad.yzz.util;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class a0 {

    /* renamed from: a */
    public int f34224a;

    /* renamed from: b */
    public int f34225b;

    /* renamed from: c */
    public int f34226c;

    public a0(String str) {
        try {
            String[] split = str.split("\\.");
            if (split.length == 3) {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                int parseInt3 = Integer.parseInt(split[2]);
                this.f34224a = parseInt;
                this.f34225b = parseInt2;
                this.f34226c = parseInt3;
            } else if (split.length == 2) {
                int parseInt4 = Integer.parseInt(split[0]);
                int parseInt5 = Integer.parseInt(split[1]);
                this.f34224a = parseInt4;
                this.f34225b = parseInt5;
            } else if (split.length == 1) {
                this.f34224a = Integer.parseInt(split[0]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int a(a0 a0Var) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9129, this, a0Var);
    }

    public boolean equals(Object obj) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9132, this, obj);
    }

    public int hashCode() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9131, this, null);
    }

    public String toString() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9126, this, null);
    }
}
