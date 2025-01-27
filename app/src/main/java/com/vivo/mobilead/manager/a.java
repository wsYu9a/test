package com.vivo.mobilead.manager;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: g */
    private static final a f29501g = new a();

    /* renamed from: b */
    private int f29503b;

    /* renamed from: c */
    private InterfaceC0600a f29504c;

    /* renamed from: f */
    private String f29507f;

    /* renamed from: a */
    private boolean f29502a = false;

    /* renamed from: d */
    private AtomicBoolean f29505d = new AtomicBoolean(false);

    /* renamed from: e */
    private AtomicInteger f29506e = new AtomicInteger(0);

    /* renamed from: com.vivo.mobilead.manager.a$a */
    public interface InterfaceC0600a {
        void a(boolean z);
    }

    private a() {
    }

    public static a b() {
        return f29501g;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.equals(this.f29507f) && this.f29505d.get()) {
            this.f29506e.incrementAndGet();
        }
        this.f29507f = str;
        this.f29505d.set(true);
        if (this.f29502a) {
            this.f29503b = 1;
        } else {
            this.f29503b = 0;
            a(true);
        }
        this.f29502a = true;
    }

    public void a() {
        if (this.f29506e.get() > 1) {
            this.f29506e.decrementAndGet();
            return;
        }
        this.f29505d.set(false);
        if (this.f29503b == 1) {
            this.f29503b = 2;
        } else if (this.f29502a) {
            this.f29506e.set(0);
            this.f29502a = false;
            a(false);
        }
    }

    private void a(boolean z) {
        InterfaceC0600a interfaceC0600a = this.f29504c;
        if (interfaceC0600a == null) {
            return;
        }
        interfaceC0600a.a(z);
    }

    public void a(InterfaceC0600a interfaceC0600a) {
        this.f29504c = interfaceC0600a;
    }
}
