package com.vivo.advv.vaf.expr.engine.executor;

import android.text.TextUtils;
import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class JmpcExecutor extends ArithExecutor {
    private static final String TAG = "JmpcExecutor_TMTEST";

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        super.execute(obj);
        int readInt = this.mCodeReader.readInt();
        Data readData = readData(this.mCodeReader.readByte());
        int i2 = readData.mType;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        VVLog.e(TAG, "type invalidate:" + readData);
                        return 2;
                    }
                    if (readData.getObject() == null) {
                        this.mCodeReader.setPos(readInt);
                    }
                } else if (TextUtils.isEmpty(readData.getString())) {
                    this.mCodeReader.setPos(readInt);
                }
            } else if (readData.getFloat() <= 0.0f) {
                this.mCodeReader.setPos(readInt);
            }
        } else if (readData.getInt() <= 0) {
            this.mCodeReader.setPos(readInt);
        }
        return 1;
    }
}
