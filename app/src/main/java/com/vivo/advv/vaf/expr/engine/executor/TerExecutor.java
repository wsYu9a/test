package com.vivo.advv.vaf.expr.engine.executor;

import android.text.TextUtils;
import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class TerExecutor extends ArithExecutor {
    private static final String TAG = "TerExecutor_TMTEST";

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        int execute = super.execute(obj);
        short readShort = this.mCodeReader.readShort();
        int i2 = readShort & 7;
        int i3 = (readShort >> 3) & 7;
        int i4 = (readShort >> 6) & 7;
        Data readData = readData(i2);
        Data readData2 = readData(i3);
        Data readData3 = readData(i4);
        if (4 != i2 && 4 != i3 && 4 != i4) {
            this.mAriResultRegIndex = this.mCodeReader.readByte();
        }
        Data data = this.mRegisterManger.get(this.mAriResultRegIndex);
        if (data == null) {
            return execute;
        }
        int i5 = readData.mType;
        if (i5 != 1) {
            if (i5 == 2) {
                double d2 = readData.getFloat();
                if (d2 > 1.0E-7d || d2 < -1.0E-7d) {
                    data.copy(readData2);
                } else {
                    data.copy(readData3);
                }
            } else {
                if (i5 != 3) {
                    VVLog.e(TAG, "type error:" + i2);
                    return 2;
                }
                if (TextUtils.isEmpty(readData.getString())) {
                    data.copy(readData3);
                } else {
                    data.copy(readData2);
                }
            }
        } else if (readData.getInt() != 0) {
            data.copy(readData2);
        } else {
            data.copy(readData3);
        }
        return 1;
    }
}
