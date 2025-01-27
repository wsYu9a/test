package com.vivo.advv.vaf.virtualview.core;

/* loaded from: classes4.dex */
public interface IView {
    void comLayout(int i2, int i3, int i4, int i5);

    int getComMeasuredHeight();

    int getComMeasuredWidth();

    void measureComponent(int i2, int i3);

    void onComLayout(boolean z, int i2, int i3, int i4, int i5);

    void onComMeasure(int i2, int i3);
}
