package com.vivo.advv.vaf.virtualview.core;

import android.content.Context;

/* loaded from: classes4.dex */
public interface IBean {
    void appendData(Object obj);

    void click(int i2, boolean z);

    void doEvent(int i2, int i3, Object obj);

    void init(Context context, ViewBase viewBase);

    void setData(Object obj);

    void uninit();
}
