package com.google.zxing.datamatrix.encoder;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
final class d extends k {
    d() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.k
    public int c(int i2) {
        return i2 <= 8 ? TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL : TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND;
    }

    @Override // com.google.zxing.datamatrix.encoder.k
    public int g() {
        return 10;
    }
}
