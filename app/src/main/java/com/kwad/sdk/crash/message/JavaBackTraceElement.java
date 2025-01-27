package com.kwad.sdk.crash.message;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public final class JavaBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 2317636129771661110L;
    public String mDeclaringClass;
    public boolean mIsCausedBy;
    public boolean mIsNative;
    public boolean mIsTitle;

    public JavaBackTraceElement(String str, int i10) {
        super(str, i10);
        this.mDeclaringClass = "";
        this.mIsTitle = false;
        this.mIsCausedBy = false;
        this.mIsNative = false;
    }

    public final String getDeclaringClass() {
        return this.mDeclaringClass;
    }

    public final boolean isCausedBy() {
        return this.mIsCausedBy;
    }

    public final boolean isNative() {
        return this.mIsNative;
    }

    public final boolean isTitle() {
        return this.mIsTitle;
    }

    public final void setDeclaringClass(String str) {
        this.mDeclaringClass = str;
    }

    public final void setIsCausedBy(boolean z10) {
        this.mIsCausedBy = z10;
    }

    public final void setIsNative(boolean z10) {
        this.mIsNative = z10;
    }

    public final void setIsTitle(boolean z10) {
        this.mIsTitle = z10;
    }
}
