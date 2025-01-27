package com.kwad.sdk.crash.message;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public final class NativeBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 8646793782725084250L;
    public String mBuildId;
    public String mPc;

    public NativeBackTraceElement(String str, int i10) {
        super(str, i10);
        this.mBuildId = "";
        this.mPc = "";
    }

    public final String getBuildId() {
        return this.mBuildId;
    }

    public final String getPc() {
        return this.mPc;
    }

    public final void setBuildId(String str) {
        this.mBuildId = str;
    }

    public final void setPc(String str) {
        this.mPc = str;
    }
}
