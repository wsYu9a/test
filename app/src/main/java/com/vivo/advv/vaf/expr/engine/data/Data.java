package com.vivo.advv.vaf.expr.engine.data;

import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class Data {
    private static final String TAG = "Data_TMTEST";
    public static final byte TYPE_FLOAT = 2;
    public static final byte TYPE_INT = 1;
    public static final byte TYPE_NONE = 0;
    public static final byte TYPE_OBJECT = 4;
    public static final byte TYPE_STR = 3;
    private static ValueCache sValueCache = ValueCache.getInstance();
    public int mType;
    public Value mValue;

    public Data() {
        reset();
    }

    private void freeValue(int i2, Value value) {
        if (value != null) {
            if (i2 == 1) {
                sValueCache.freeIntValue((IntValue) value);
                return;
            }
            if (i2 == 2) {
                sValueCache.freeFloatValue((FloatValue) value);
            } else if (i2 == 3) {
                sValueCache.freeStrValue((StrValue) value);
            } else {
                if (i2 != 4) {
                    return;
                }
                sValueCache.freeObjValue((ObjValue) value);
            }
        }
    }

    public void copy(Data data) {
        if (data == null) {
            VVLog.e(TAG, "copy failed");
            return;
        }
        int i2 = data.mType;
        if (i2 == this.mType) {
            this.mValue.copy(data.mValue);
        } else {
            this.mType = i2;
            this.mValue = data.mValue.mo79clone();
        }
    }

    public float getFloat() {
        if (2 == this.mType) {
            return ((FloatValue) this.mValue).mValue;
        }
        return 0.0f;
    }

    public int getInt() {
        if (1 == this.mType) {
            return ((IntValue) this.mValue).mValue;
        }
        return 0;
    }

    public Object getObject() {
        if (4 == this.mType) {
            return ((ObjValue) this.mValue).mValue;
        }
        return null;
    }

    public String getString() {
        if (3 == this.mType) {
            return ((StrValue) this.mValue).mValue;
        }
        return null;
    }

    public void reset() {
        this.mType = 0;
    }

    public boolean set(Object obj) {
        if (obj instanceof Integer) {
            setInt(((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Float) {
            setFloat(((Float) obj).floatValue());
            return true;
        }
        if (obj instanceof String) {
            setString((String) obj);
            return true;
        }
        setObject(obj);
        return true;
    }

    public void setFloat(float f2) {
        int i2 = this.mType;
        if (2 == i2) {
            ((FloatValue) this.mValue).mValue = f2;
            return;
        }
        freeValue(i2, this.mValue);
        this.mType = 2;
        this.mValue = sValueCache.mallocFloatValue(f2);
    }

    public void setInt(int i2) {
        int i3 = this.mType;
        if (1 == i3) {
            ((IntValue) this.mValue).mValue = i2;
            return;
        }
        freeValue(i3, this.mValue);
        this.mType = 1;
        this.mValue = sValueCache.mallocIntValue(i2);
    }

    public void setObject(Object obj) {
        int i2 = this.mType;
        if (4 == i2) {
            ((ObjValue) this.mValue).mValue = obj;
            return;
        }
        freeValue(i2, this.mValue);
        this.mType = 4;
        this.mValue = sValueCache.mallocObjValue(obj);
    }

    public void setString(String str) {
        int i2 = this.mType;
        if (3 == i2) {
            ((StrValue) this.mValue).mValue = str;
            return;
        }
        freeValue(i2, this.mValue);
        this.mType = 3;
        this.mValue = sValueCache.mallocStrValue(str);
    }

    public String toString() {
        int i2 = this.mType;
        if (i2 == 1) {
            return String.format("type:int value:" + this.mValue, new Object[0]);
        }
        if (i2 == 2) {
            return String.format("type:float value:" + this.mValue, new Object[0]);
        }
        if (i2 == 3) {
            return String.format("type:string value:" + this.mValue, new Object[0]);
        }
        if (i2 != 4) {
            return "type:none";
        }
        return String.format("type:object value:" + this.mValue, new Object[0]);
    }
}
