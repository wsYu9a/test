package com.heytap.mcssdk.n;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class a extends d {
    private String L;
    private String M;
    private long N;
    private long O;
    private int P;
    private String R;
    private String Q = "08:00-22:00";
    private int S = 0;
    private int T = 0;

    @Override // com.heytap.mcssdk.n.d
    public int getType() {
        return 4098;
    }

    public int h() {
        return this.P;
    }

    public String i() {
        return this.M;
    }

    public int j() {
        return this.T;
    }

    public long k() {
        return this.O;
    }

    public int l() {
        return this.S;
    }

    public String m() {
        return this.R;
    }

    public long n() {
        return this.N;
    }

    public String o() {
        return this.Q;
    }

    public String p() {
        return this.L;
    }

    public void q(int i2) {
        this.P = i2;
    }

    public void r(String str) {
        this.M = str;
    }

    public void s(int i2) {
        this.T = i2;
    }

    public void t(long j2) {
        this.O = j2;
    }

    public String toString() {
        return "AppMessage{mTitle='" + this.L + "', mContent='" + this.M + "', mStartDate=" + this.N + ", mEndDate=" + this.O + ", mBalanceTime=" + this.P + ", mTimeRanges='" + this.Q + "', mRule='" + this.R + "', mForcedDelivery=" + this.S + ", mDistinctBycontent=" + this.T + '}';
    }

    public void u(int i2) {
        this.S = i2;
    }

    public void v(String str) {
        this.R = str;
    }

    public void w(long j2) {
        this.N = j2;
    }

    public void x(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Q = str;
    }

    public void y(String str) {
        this.L = str;
    }
}
