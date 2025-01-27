package com.vivo.advv.vaf.expr.engine.executor;

import android.text.TextUtils;
import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class NotExecutor extends ArithExecutor {
    private static final String TAG = "NotExecutor_TMTEST";

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
            data.setInt(readData.getInt() == 0 ? 1 : 0);
        } else if (i2 == 2) {
            data.setInt(0.0f == readData.getFloat() ? 1 : 0);
        } else {
            if (i2 != 3) {
                VVLog.e(TAG, "invalidate type:" + readData.mType);
                return 2;
            }
            data.setInt(TextUtils.isEmpty(readData.getString()) ? 1 : 0);
        }
        return 1;
    }
}
