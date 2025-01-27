package com.google.android.flexbox;

import android.os.Parcelable;

/* loaded from: classes2.dex */
interface FlexItem extends Parcelable {
    public static final int A0 = 16777215;

    /* renamed from: v0, reason: collision with root package name */
    public static final int f8965v0 = 1;

    /* renamed from: w0, reason: collision with root package name */
    public static final float f8966w0 = 0.0f;

    /* renamed from: x0, reason: collision with root package name */
    public static final float f8967x0 = 1.0f;

    /* renamed from: y0, reason: collision with root package name */
    public static final float f8968y0 = 0.0f;

    /* renamed from: z0, reason: collision with root package name */
    public static final float f8969z0 = -1.0f;

    int A();

    void B(int alignSelf);

    void e(int order);

    int g();

    int getHeight();

    int getMarginEnd();

    int getMarginStart();

    int getOrder();

    int getWidth();

    float h();

    void i(int maxWidth);

    void j(boolean wrapBefore);

    int k();

    void l(int maxHeight);

    int m();

    void n(int minHeight);

    float o();

    float p();

    boolean q();

    int r();

    void s(float flexGrow);

    void setHeight(int height);

    void setWidth(int width);

    void t(float flexBasisPercent);

    void u(float flexShrink);

    void v(int minWidth);

    int w();

    int x();

    int y();

    int z();
}
