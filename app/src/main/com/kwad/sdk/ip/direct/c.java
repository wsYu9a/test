package com.kwad.sdk.ip.direct;

/* loaded from: classes3.dex */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float aNh = -1.0f;
    private int aNn = 20;
    private int aNm = 3;
    private StringBuffer aNo = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return (int) (this.aNh - cVar.aNh);
    }

    public final int KF() {
        return this.aNm;
    }

    public final float KG() {
        return this.aNh;
    }

    public final void bF(boolean z10) {
        this.success = z10;
    }

    public final void dF(int i10) {
        this.weight = i10;
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final void k(float f10) {
        this.aNh = f10;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.aNm + ", pingWaitTime=" + this.aNn + ", pingTime='" + this.aNh + " ms', success=" + this.success + '}';
    }
}
