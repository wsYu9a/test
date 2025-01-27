package com.vivo.advv.vaf.expr.engine.data;

import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class IntValue extends Value {
    private static final String TAG = "IntValue_TMTEST";
    public int mValue;

    public IntValue(int i2) {
        this.mValue = i2;
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public void copy(Value value) {
        if (value != null) {
            this.mValue = ((IntValue) value).mValue;
        } else {
            VVLog.e(TAG, "value is null");
        }
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public Object getValue() {
        return Integer.valueOf(this.mValue);
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public Class<?> getValueClass() {
        return Integer.TYPE;
    }

    public String toString() {
        return String.format("value type:int, value:%d", Integer.valueOf(this.mValue));
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    /* renamed from: clone */
    public Value mo79clone() {
        return Value.sValueCache.mallocIntValue(this.mValue);
    }
}
