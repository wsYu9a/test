package com.vivo.advv.vaf.expr.engine.data;

import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class ObjValue extends Value {
    private static final String TAG = "ObjValue_TMTEST";
    public Object mValue;

    public ObjValue(Object obj) {
        this.mValue = obj;
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    public void copy(Value value) {
        if (value != null) {
            this.mValue = ((ObjValue) value).mValue;
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
        return this.mValue.getClass();
    }

    public String toString() {
        return "value type:object, value:" + this.mValue;
    }

    @Override // com.vivo.advv.vaf.expr.engine.data.Value
    /* renamed from: clone */
    public Value mo79clone() {
        return Value.sValueCache.mallocObjValue(this.mValue);
    }
}
