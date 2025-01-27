package com.vivo.advv.virtualview.common;

import com.vivo.advv.Log;
import com.vivo.advv.TextUtils;

/* loaded from: classes4.dex */
public class StringSlice implements CharSequence {
    private static final String TAG = "StringSlice_TMTEST";
    private int mStartPos;
    private String mStr;
    private int mStrLen;

    public StringSlice() {
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.mStr.charAt(this.mStartPos + i2);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mStrLen;
    }

    public void setPos(int i2, int i3) {
        if (i2 < 0 || i3 <= 0) {
            return;
        }
        this.mStartPos = i2;
        this.mStrLen = i3;
    }

    public void setStr(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str) || i2 < 0 || i3 <= 0) {
            return;
        }
        Log.d(TAG, "start:" + i2 + "  len:" + i3);
        this.mStr = str;
        this.mStartPos = i2;
        this.mStrLen = i3;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return new StringSlice(this.mStr, this.mStartPos + i2, i3 - i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.mStr;
        int i2 = this.mStartPos;
        return String.format("StringSlice:%s", str.substring(i2, this.mStrLen + i2));
    }

    public StringSlice(String str, int i2, int i3) {
        setStr(str, i2, i3);
    }
}
