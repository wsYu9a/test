package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bj;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ViewCompatDelegate implements a {

    /* renamed from: c */
    private final b f5754c;

    /* renamed from: b */
    private static final AtomicInteger f5752b = new AtomicInteger(100000);

    /* renamed from: a */
    private static final String f5751a = "generateViewId";

    /* renamed from: d */
    private static final boolean f5753d = ar.a((Class<?>) ViewCompat.class, f5751a, (Class<?>[]) new Class[0]);

    public ViewCompatDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f5754c = b.a(iAdInterListener, this);
    }

    @SuppressLint({"NewApi"})
    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        if (f5753d) {
            return ViewCompat.generateViewId();
        }
        if (bj.a((Context) null).a() >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f5752b;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f5754c.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f5754c.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f5754c.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f5754c.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f5754c.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f5754c.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f5751a.equals(str2)) {
            return Integer.valueOf(generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f5754c.setTarget(obj);
    }
}
