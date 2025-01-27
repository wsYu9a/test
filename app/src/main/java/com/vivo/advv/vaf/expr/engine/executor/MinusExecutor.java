package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class MinusExecutor extends ArithExecutor {
    private static final String TAG = "MinusExecutor_TMTEST";

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        int execute = super.execute(obj);
        byte readByte = this.mCodeReader.readByte();
        Data readData = readData(readByte);
        if (readByte == 0) {
            this.mAriResultRegIndex = this.mCodeReader.readByte();
        }
        Data data = this.mRegisterManger.get(this.mAriResultRegIndex);
        if (readData == null || data == null) {
            VVLog.e(TAG, "read data failed");
            return execute;
        }
        int i2 = readData.mType;
        if (i2 == 1) {
            data.setInt(-readData.getInt());
        } else {
            if (i2 != 2) {
                VVLog.e(TAG, "invalidate type:" + readData.mType);
                return 2;
            }
            data.setFloat(-readData.getFloat());
        }
        return 1;
    }
}
