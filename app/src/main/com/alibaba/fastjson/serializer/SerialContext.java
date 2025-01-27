package com.alibaba.fastjson.serializer;

import p1.b;

/* loaded from: classes.dex */
public class SerialContext {
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public SerialContext(SerialContext serialContext, Object obj, Object obj2, int i10) {
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i10;
    }

    public String toString() {
        if (this.parent == null) {
            return "$";
        }
        if (!(this.fieldName instanceof Integer)) {
            return this.parent.toString() + b.f29697h + this.fieldName;
        }
        return this.parent.toString() + "[" + this.fieldName + "]";
    }
}
