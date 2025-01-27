package com.vivo.advv.vaf.expr.engine.data;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class ValueCache {
    private static ValueCache sThis;
    private List<IntValue> mIntCache = new LinkedList();
    private List<FloatValue> mFloatCache = new LinkedList();
    private List<StrValue> mStrCache = new LinkedList();
    private List<ObjValue> mObjCache = new LinkedList();

    private ValueCache() {
    }

    public static ValueCache getInstance() {
        if (sThis == null) {
            sThis = new ValueCache();
        }
        return sThis;
    }

    public void freeFloatValue(FloatValue floatValue) {
        this.mFloatCache.add(floatValue);
    }

    public void freeIntValue(IntValue intValue) {
        this.mIntCache.add(intValue);
    }

    public void freeObjValue(ObjValue objValue) {
        this.mObjCache.add(objValue);
    }

    public void freeStrValue(StrValue strValue) {
        this.mStrCache.add(strValue);
    }

    public FloatValue mallocFloatValue(float f2) {
        if (this.mFloatCache.size() <= 0) {
            return new FloatValue(f2);
        }
        FloatValue remove = this.mFloatCache.remove(0);
        remove.mValue = f2;
        return remove;
    }

    public IntValue mallocIntValue(int i2) {
        if (this.mIntCache.size() <= 0) {
            return new IntValue(i2);
        }
        IntValue remove = this.mIntCache.remove(0);
        remove.mValue = i2;
        return remove;
    }

    public ObjValue mallocObjValue(Object obj) {
        if (this.mObjCache.size() <= 0) {
            return new ObjValue(obj);
        }
        ObjValue remove = this.mObjCache.remove(0);
        remove.mValue = obj;
        return remove;
    }

    public StrValue mallocStrValue(String str) {
        if (this.mStrCache.size() <= 0) {
            return new StrValue(str);
        }
        StrValue remove = this.mStrCache.remove(0);
        remove.mValue = str;
        return remove;
    }
}
