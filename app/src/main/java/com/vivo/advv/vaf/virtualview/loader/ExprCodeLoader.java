package com.vivo.advv.vaf.virtualview.loader;

import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class ExprCodeLoader {
    private static final String TAG = "CodeManager_TMTEST";
    private ConcurrentHashMap<Integer, ExprCode> mCodeMap = new ConcurrentHashMap<>();

    public ExprCode get(int i2) {
        return this.mCodeMap.get(Integer.valueOf(i2));
    }

    public boolean loadFromBuffer(CodeReader codeReader, int i2) {
        int maxSize = codeReader.getMaxSize();
        int readInt = codeReader.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = codeReader.readInt();
            short readShort = codeReader.readShort();
            int pos = codeReader.getPos();
            if (pos + readShort > maxSize) {
                VVLog.e(TAG, "read string over");
                return false;
            }
            this.mCodeMap.put(Integer.valueOf(readInt2), new ExprCode(codeReader.getCode(), pos, readShort));
            codeReader.seekBy(readShort);
        }
        return true;
    }

    public void reset() {
    }
}
