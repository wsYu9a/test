package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class CompositeEqExecutor extends EqualExecutor {
    private static final String TAG = "ComEqExecutor_TMTEST";

    protected void calcFloatFloat(Data data, float f2, float f3) {
    }

    protected void calcFloatInt(Data data, float f2, int i2) {
    }

    protected void calcFloatString(Data data, float f2, String str) {
    }

    protected void calcIntFloat(Data data, int i2, float f2) {
    }

    protected void calcIntInt(Data data, int i2, int i3) {
    }

    protected void calcIntString(Data data, int i2, String str) {
    }

    protected void calcStringFloat(Data data, String str, float f2) {
    }

    protected void calcStringInt(Data data, String str, int i2) {
    }

    protected void calcStringString(Data data, String str, String str2) {
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.EqualExecutor
    protected int eqDeal(Data data, Data data2) {
        if (this.mMyObjs.size() <= 0) {
            VVLog.e(TAG, "obj is empty");
            return 2;
        }
        for (Object obj : this.mMyObjs) {
            Object propertyImp = this.mNativeObjectManager.getPropertyImp(obj, this.mPropertyNameId);
            if (propertyImp != null) {
                Data data3 = new Data();
                if (propertyImp instanceof Integer) {
                    int i2 = data2.mType;
                    if (i2 == 1) {
                        calcIntInt(data3, ((Integer) propertyImp).intValue(), data2.getInt());
                    } else if (i2 == 2) {
                        calcIntFloat(data3, ((Integer) propertyImp).intValue(), data2.getFloat());
                    } else if (i2 == 3) {
                        calcIntString(data3, ((Integer) propertyImp).intValue(), data2.getString());
                    }
                } else if (propertyImp instanceof Float) {
                    int i3 = data2.mType;
                    if (i3 == 1) {
                        calcFloatInt(data3, ((Float) propertyImp).floatValue(), data2.getInt());
                    } else if (i3 == 2) {
                        calcFloatFloat(data3, ((Float) propertyImp).floatValue(), data2.getFloat());
                    } else if (i3 == 3) {
                        calcFloatString(data3, ((Float) propertyImp).floatValue(), data2.getString());
                    }
                } else if (propertyImp instanceof String) {
                    int i4 = data2.mType;
                    if (i4 == 1) {
                        calcStringInt(data3, (String) propertyImp, data2.getInt());
                    } else if (i4 == 2) {
                        calcStringFloat(data3, (String) propertyImp, data2.getFloat());
                    } else if (i4 == 3) {
                        calcStringString(data3, (String) propertyImp, data2.getString());
                    }
                } else {
                    VVLog.e(TAG, "var type invalidate:" + propertyImp);
                }
                this.mNativeObjectManager.setPropertyImp(obj, this.mPropertyNameId, data3);
            } else {
                VVLog.e(TAG, "result value is empty:" + propertyImp);
            }
        }
        return 1;
    }
}
