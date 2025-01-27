package com.vivo.advv.expr.common;

import java.util.List;

/* loaded from: classes4.dex */
public class ExprCode {
    private static final String TAG = "ExprCode_TMTEST";
    public byte[] mCodeBase;
    public int mEndPos;
    public int mStartPos;

    public ExprCode() {
        this.mCodeBase = null;
        this.mStartPos = 0;
        this.mEndPos = 0;
    }

    public int size() {
        return this.mEndPos - this.mStartPos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("start pos:" + this.mStartPos + "  endPos:" + this.mEndPos + "  [");
        for (int i2 = this.mStartPos; i2 < this.mEndPos; i2++) {
            sb.append(((int) this.mCodeBase[i2]) + ",");
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: clone */
    public ExprCode m78clone() {
        if (this.mCodeBase == null) {
            return null;
        }
        int size = size();
        ExprCode exprCode = new ExprCode();
        exprCode.mCodeBase = new byte[size];
        exprCode.mStartPos = 0;
        exprCode.mEndPos = size;
        for (int i2 = 0; i2 < size; i2++) {
            exprCode.mCodeBase[i2] = this.mCodeBase[i2];
        }
        return exprCode;
    }

    public ExprCode(byte[] bArr, int i2, int i3) {
        this.mCodeBase = bArr;
        this.mStartPos = i2;
        this.mEndPos = i2 + i3;
    }

    public ExprCode(List<Byte> list) {
        if (list != null) {
            int size = list.size();
            this.mCodeBase = new byte[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.mCodeBase[i2] = list.get(i2).byteValue();
            }
            this.mStartPos = 0;
            this.mEndPos = size;
        }
    }
}
