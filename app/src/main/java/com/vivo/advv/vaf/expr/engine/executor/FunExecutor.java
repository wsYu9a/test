package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.expr.engine.data.Value;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/* loaded from: classes4.dex */
public class FunExecutor extends ArithExecutor {
    private static final String TAG = "FunExecutor_TMTEST";

    protected boolean call(int i2, int i3, Value[] valueArr, Set<Object> set) {
        int length = valueArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            clsArr[i4] = valueArr[i4].getValueClass();
            objArr[i4] = valueArr[i4].getValue();
        }
        String string = this.mStringSupport.getString(i2);
        for (Object obj : set) {
            try {
                Method method = obj.getClass().getMethod(string, clsArr);
                if (method != null) {
                    Object invoke = method.invoke(obj, objArr);
                    Data data = this.mRegisterManger.get(i3);
                    if (invoke == null) {
                        data.reset();
                    } else if (!data.set(invoke)) {
                        VVLog.e(TAG, "call set return value failed:" + invoke);
                    }
                    z = true;
                } else {
                    VVLog.e(TAG, "get method failed:" + obj.getClass());
                }
            } catch (IllegalAccessException e2) {
                VVLog.e(TAG, "call get method failed:" + e2 + obj);
            } catch (NoSuchMethodException e3) {
                VVLog.e(TAG, "call get method failed:" + e3 + obj);
            } catch (InvocationTargetException unused) {
            }
        }
        return z;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        int execute = super.execute(obj);
        Set<Object> findObject = findObject();
        if (findObject == null) {
            VVLog.e(TAG, "execute findObject failed");
            return execute;
        }
        int readInt = this.mCodeReader.readInt();
        Value[] readParam = readParam();
        if (readParam == null || !call(readInt, this.mCodeReader.readByte(), readParam, findObject)) {
            return execute;
        }
        return 1;
    }

    protected Value[] readParam() {
        int readByte = this.mCodeReader.readByte();
        Value[] valueArr = new Value[readByte];
        for (int i2 = 0; i2 < readByte; i2++) {
            byte readByte2 = this.mCodeReader.readByte();
            Data readData = readData(readByte2);
            if (readData != null) {
                valueArr[i2] = readData.mValue;
            } else {
                VVLog.e(TAG, "read param failed:" + ((int) readByte2));
                valueArr = null;
            }
        }
        return valueArr;
    }
}
