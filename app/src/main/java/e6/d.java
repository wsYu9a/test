package e6;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public final class d extends k {
    public d() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // e6.k
    public int c(int i10) {
        if (i10 <= 8) {
            return TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL;
        }
        return 155;
    }

    @Override // e6.k
    public int g() {
        return 10;
    }
}
