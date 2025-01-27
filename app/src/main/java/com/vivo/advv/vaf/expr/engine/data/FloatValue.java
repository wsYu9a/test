package com.vivo.advv.vaf.expr.engine.data;

import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class FloatValue extends Value {
    private static final String TAG = "FloatValue_TMTEST";
    public float mValue;

    public FloatValue(float f2) {
        this.mValue = f2;
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public void copy(Value value) {
        if (value != null) {
            this.mValue = ((FloatValue) value).mValue;
        } else {
            VVLog.e(TAG, "value is null");
        }
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public Object getValue() {
        return Float.valueOf(this.mValue);
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public Class<?> getValueClass() {
        return Float.TYPE;
    }

    public String toString() {
        return String.format("value type:float, value:%f", Float.valueOf(this.mValue));
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    /* renamed from: clone */
    public Value mo79clone() {
        return Value.sValueCache.mallocFloatValue(this.mValue);
    }
}
