package com.vivo.mobilead.model;

import android.view.KeyEvent;
import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private VafContext f29561a;

    /* renamed from: b */
    private View f29562b;

    public b(VafContext vafContext, View view) {
        this.f29561a = vafContext;
        this.f29562b = view;
    }

    public void a() {
        KeyEvent.Callback callback = this.f29562b;
        if (callback instanceof IContainer) {
            try {
                ((IContainer) callback).destroy();
            } catch (Exception e2) {
                VOpenLog.w("DynamicInfo", "destroy->" + e2.getMessage());
            }
        }
    }

    public View b() {
        return this.f29562b;
    }

    public VafContext c() {
        return this.f29561a;
    }
}
