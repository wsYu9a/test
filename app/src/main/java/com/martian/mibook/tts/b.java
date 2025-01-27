package com.martian.mibook.tts;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.martian.libsliding.SlidingLayout;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingContent;

/* loaded from: classes4.dex */
public class b extends PhoneStateListener {

    /* renamed from: b */
    private final SlidingLayout f14132b;

    /* renamed from: d */
    final TelephonyManager f14134d;

    /* renamed from: c */
    private com.martian.libsliding.slider.c f14133c = null;

    /* renamed from: a */
    private boolean f14131a = false;

    public b(SlidingLayout sl_container) {
        this.f14132b = sl_container;
        this.f14134d = (TelephonyManager) sl_container.getContext().getSystemService("phone");
    }

    public void a() {
        this.f14131a = false;
        h();
        i();
        this.f14133c = null;
    }

    public boolean b() {
        return this.f14131a;
    }

    public void c() {
        com.martian.libsliding.slider.c cVar = this.f14133c;
        if (cVar != null) {
            cVar.E();
        }
    }

    public void d() {
        com.martian.libsliding.slider.c cVar = this.f14133c;
        if (cVar != null) {
            cVar.F();
        }
    }

    public void e(MiReadingContent.MiContentCursor cursor) {
        this.f14131a = true;
        this.f14132b.D();
    }

    public void f() {
        this.f14131a = true;
        com.martian.libsliding.slider.c cVar = new com.martian.libsliding.slider.c(MiConfigSingleton.V3().Z2());
        this.f14133c = cVar;
        this.f14132b.y(cVar, MiConfigSingleton.V3().Q5());
        this.f14132b.D();
    }

    public void g() {
        this.f14131a = false;
        h();
        i();
    }

    public boolean h() {
        boolean z = this.f14131a;
        this.f14131a = false;
        if (this.f14132b.E()) {
            this.f14131a = false;
            return true;
        }
        this.f14131a = z;
        return false;
    }

    public void i() {
        this.f14131a = false;
        try {
            this.f14134d.listen(null, 0);
        } catch (Exception unused) {
        }
        this.f14132b.E();
    }
}
