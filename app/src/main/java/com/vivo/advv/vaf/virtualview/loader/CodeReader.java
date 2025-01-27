package com.vivo.advv.vaf.virtualview.loader;

import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class CodeReader {
    private static final String TAG = "CodeReader_TMTEST";
    private byte[] mCode;
    private int mCount;
    private int mCurIndex;
    private int patchVersion;

    public byte[] getCode() {
        return this.mCode;
    }

    public int getMaxSize() {
        return this.mCount;
    }

    public int getPatchVersion() {
        return this.patchVersion;
    }

    public int getPos() {
        return this.mCurIndex;
    }

    public boolean isEndOfCode() {
        return this.mCurIndex == this.mCount;
    }

    public byte readByte() {
        int i2;
        byte[] bArr = this.mCode;
        if (bArr != null && (i2 = this.mCurIndex) < this.mCount) {
            this.mCurIndex = i2 + 1;
            return bArr[i2];
        }
        VVLog.e(TAG, "readByte error mCode:" + this.mCode + "  mCurIndex:" + this.mCurIndex + "  mCount:" + this.mCount);
        return (byte) -1;
    }

    public int readInt() {
        int i2;
        byte[] bArr = this.mCode;
        if (bArr == null || (i2 = this.mCurIndex) >= this.mCount - 3) {
            VVLog.e(TAG, "readInt error mCode:" + this.mCode + "  mCurIndex:" + this.mCurIndex + "  mCount:" + this.mCount);
            return -1;
        }
        int i3 = i2 + 1;
        this.mCurIndex = i3;
        int i4 = (bArr[i2] & 255) << 24;
        int i5 = i3 + 1;
        this.mCurIndex = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        int i7 = i5 + 1;
        this.mCurIndex = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        this.mCurIndex = i7 + 1;
        return (bArr[i7] & 255) | i8;
    }

    public short readShort() {
        int i2;
        byte[] bArr = this.mCode;
        if (bArr != null && (i2 = this.mCurIndex) < this.mCount - 1) {
            int i3 = i2 + 1;
            this.mCurIndex = i3;
            int i4 = (bArr[i2] & 255) << 8;
            this.mCurIndex = i3 + 1;
            return (short) ((bArr[i3] & 255) | i4);
        }
        VVLog.e(TAG, "readShort error mCode:" + this.mCode + "  mCurIndex:" + this.mCurIndex + "  mCount:" + this.mCount);
        return (short) -1;
    }

    public void release() {
        if (this.mCode != null) {
            this.mCode = null;
        }
    }

    public boolean seek(int i2) {
        int i3 = this.mCount;
        if (i2 > i3) {
            this.mCurIndex = i3;
            return false;
        }
        if (i2 < 0) {
            this.mCurIndex = 0;
            return false;
        }
        this.mCurIndex = i2;
        return true;
    }

    public boolean seekBy(int i2) {
        return seek(this.mCurIndex + i2);
    }

    public void setCode(byte[] bArr) {
        this.mCode = bArr;
        if (bArr != null) {
            this.mCount = bArr.length;
        } else {
            this.mCount = 0;
        }
        this.mCurIndex = 0;
    }

    public void setPatchVersion(int i2) {
        this.patchVersion = i2;
    }
}
