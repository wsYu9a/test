package com.vivo.advv.vaf.expr.engine;

import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class CodeReader {
    private static final String TAG = "CodeReader";
    private ExprCode mCode;
    private int mCurIndex;
    private int mStartPos;

    public int curPos() {
        return this.mCurIndex - this.mStartPos;
    }

    public boolean isEndOfCode() {
        return this.mCurIndex == this.mCode.mEndPos;
    }

    public byte readByte() {
        int i2;
        ExprCode exprCode = this.mCode;
        if (exprCode != null && (i2 = this.mCurIndex) < exprCode.mEndPos) {
            byte[] bArr = exprCode.mCodeBase;
            this.mCurIndex = i2 + 1;
            return bArr[i2];
        }
        VVLog.e(TAG, "readByte error mCode:" + this.mCode + "  mCurIndex:" + this.mCurIndex);
        return (byte) 0;
    }

    public int readInt() {
        if (this.mCode == null || this.mCurIndex >= r0.mEndPos - 3) {
            VVLog.e(TAG, "readInt error mCode:" + this.mCode + "  mCurIndex:" + this.mCurIndex);
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte[] bArr = this.mCode.mCodeBase;
            int i5 = this.mCurIndex;
            this.mCurIndex = i5 + 1;
            i2 |= (bArr[i5] & 255) << i3;
            i3 += 8;
        }
        return i2;
    }

    public short readShort() {
        int i2;
        ExprCode exprCode = this.mCode;
        if (exprCode != null && (i2 = this.mCurIndex) < exprCode.mEndPos - 1) {
            byte[] bArr = exprCode.mCodeBase;
            int i3 = i2 + 1;
            this.mCurIndex = i3;
            short s = (short) (bArr[i2] & 255);
            this.mCurIndex = i3 + 1;
            return (short) ((bArr[i3] << 8) | s);
        }
        VVLog.e(TAG, "readShort error mCode:" + this.mCode + "  mCurIndex:" + this.mCurIndex);
        return (short) 0;
    }

    public void release() {
        if (this.mCode != null) {
            this.mCode = null;
        }
    }

    public void setCode(ExprCode exprCode) {
        this.mCode = exprCode;
        int i2 = exprCode.mStartPos;
        this.mStartPos = i2;
        this.mCurIndex = i2;
    }

    public void setPos(int i2) {
        this.mCurIndex = this.mStartPos + i2;
    }
}
