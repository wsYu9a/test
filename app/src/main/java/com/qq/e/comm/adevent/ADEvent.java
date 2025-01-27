package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes4.dex */
public class ADEvent {

    /* renamed from: a */
    private final int f23991a;

    /* renamed from: b */
    private final Object[] f23992b;

    public ADEvent(int i2, Object... objArr) {
        this.f23991a = i2;
        this.f23992b = objArr;
        if (i2 < 100) {
            a("EventId 错误" + i2);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(int i2, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f23992b) == null || objArr.length <= i2) {
            return null;
        }
        T t = (T) objArr[i2];
        if (t == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.f23991a);
            return null;
        }
        if (cls.isInstance(objArr[i2])) {
            return t;
        }
        GDTLogger.e("ADEvent" + this.f23991a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName());
        return null;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.f23991a;
    }
}
