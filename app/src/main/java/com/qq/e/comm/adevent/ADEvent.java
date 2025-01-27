package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class ADEvent {

    /* renamed from: a */
    private final int f16540a;

    /* renamed from: b */
    private final Object[] f16541b;

    public ADEvent(int i10, Object... objArr) {
        this.f16540a = i10;
        this.f16541b = objArr;
        if (i10 < 100) {
            a("EventId 错误" + i10);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.f16540a;
    }

    public <T> T getParam(int i10, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f16541b) == null || objArr.length <= i10) {
            return null;
        }
        T t10 = (T) objArr[i10];
        if (t10 == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.f16540a);
            return null;
        }
        if (cls.isInstance(t10)) {
            return t10;
        }
        GDTLogger.e("ADEvent" + this.f16540a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t10.getClass().getName());
        return null;
    }
}
