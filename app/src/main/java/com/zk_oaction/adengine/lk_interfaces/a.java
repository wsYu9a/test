package com.zk_oaction.adengine.lk_interfaces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;

/* loaded from: classes5.dex */
public interface a {
    b a(String str, float f2, int i2);

    void a();

    void a(long j2);

    void a(String str);

    void b();

    void b(View view, Map map);

    void c();

    void c(String str, int i2, String str2, Map map);

    void d();

    void d(String str, int i2, int i3, int i4, Map map);

    void e(String str, int i2, int i3, int i4, Map map);

    void f(String str, int i2, int i3, int i4, Map map);

    void g(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

    void h(MotionEvent motionEvent, int i2, int i3);

    void i(MotionEvent motionEvent, int i2, int i3);

    void j(String str, int i2, String str2);

    void k(String str, int i2, int i3, Map map);

    void l(String str, String[] strArr);

    b m(int i2, int i3, Bitmap.Config config);

    void n(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String[] strArr3, String[] strArr4);

    void o(MotionEvent motionEvent, int i2, int i3);

    void p(Intent intent);

    void q(String str, float f2, boolean z, boolean z2);
}
