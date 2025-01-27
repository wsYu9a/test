package com.vivo.google.android.exoplayer3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public interface k {

    /* renamed from: a */
    public static final ByteBuffer f27548a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a extends Exception {
        public a(int i2, int i3, int i4) {
            super("Unhandled format: " + i2 + " Hz, " + i3 + " channels in encoding " + i4);
        }
    }

    ByteBuffer a();

    void a(ByteBuffer byteBuffer);

    boolean a(int i2, int i3, int i4);

    boolean b();

    int c();

    void d();

    int e();

    void f();

    void flush();

    boolean isEnded();
}
