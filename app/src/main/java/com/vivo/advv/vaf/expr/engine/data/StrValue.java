package com.vivo.advv.vaf.expr.engine.data;

import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class StrValue extends Value {
    private static final String TAG = "StrValue_TMTEST";
    public String mValue;

    public StrValue(String str) {
        this.mValue = str;
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public void copy(Value value) {
        if (value != null) {
            this.mValue = new String(((StrValue) value).mValue);
        } else {
            VVLog.e(TAG, "value is null");
        }
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public Object getValue() {
        return this.mValue;
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public Class<?> getValueClass() {
        return String.class;
    }

    public String toString() {
        return "value type:string, value:" + this.mValue;
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    /* renamed from: clone */
    public Value mo79clone() {
        return Value.sValueCache.mallocStrValue(this.mValue);
    }
}
