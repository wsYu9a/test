package b7;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class a extends d {
    public String L;
    public String M;
    public long N;
    public long O;
    public int P;
    public String R;
    public String Q = "08:00-22:00";
    public int S = 0;
    public int T = 0;

    @Override // b7.d
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

    public void q(int i10) {
        this.P = i10;
    }

    public void r(String str) {
        this.M = str;
    }

    public void s(int i10) {
        this.T = i10;
    }

    public void t(long j10) {
        this.O = j10;
    }

    public String toString() {
        return "AppMessage{mTitle='" + this.L + "', mContent='" + this.M + "', mStartDate=" + this.N + ", mEndDate=" + this.O + ", mBalanceTime=" + this.P + ", mTimeRanges='" + this.Q + "', mRule='" + this.R + "', mForcedDelivery=" + this.S + ", mDistinctBycontent=" + this.T + '}';
    }

    public void u(int i10) {
        this.S = i10;
    }

    public void v(String str) {
        this.R = str;
    }

    public void w(long j10) {
        this.N = j10;
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
