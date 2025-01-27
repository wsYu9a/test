package com.tanx.onlyid.api.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
public class CooseaImpl implements d {

    /* renamed from: a */
    public final Context f21992a;

    /* renamed from: b */
    public final KeyguardManager f21993b;

    public CooseaImpl(Context context) {
        this.f21992a = context;
        this.f21993b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f21992a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f21993b;
        if (keyguardManager == null) {
            cVar.oaidError(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.f21993b, null);
            if (invoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            String obj = invoke.toString();
            e.b("OAID obtain success: " + obj);
            cVar.oaidSucc(obj);
        } catch (Exception e10) {
            e.b(e10);
        }
    }

    @Override // ug.d
    public boolean b() {
        KeyguardManager keyguardManager;
        if (this.f21992a == null || (keyguardManager = this.f21993b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.f21993b, null);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
