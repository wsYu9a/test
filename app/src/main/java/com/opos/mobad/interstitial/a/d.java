package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

/* loaded from: classes4.dex */
public class d extends Dialog {

    /* renamed from: a */
    private Boolean f21046a;

    /* renamed from: b */
    private Activity f21047b;

    public d(Activity activity, int i2) {
        super(activity, i2);
        this.f21046a = null;
        this.f21047b = activity;
    }

    private void a() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Boolean bool = this.f21046a;
        if (bool == null || !bool.booleanValue()) {
            super.dismiss();
        } else {
            com.opos.cmn.an.f.a.a("", "dialog has detach do not dismiss");
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f21046a = Boolean.FALSE;
        com.opos.cmn.an.f.a.b("", "dialog onAttachedToWindow");
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21046a = Boolean.TRUE;
        com.opos.cmn.an.f.a.b("", "dialog onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.f21047b;
        if (activity == null || activity.isFinishing() || this.f21047b.isDestroyed()) {
            com.opos.cmn.an.f.a.b("", "show but activity has destroy");
        } else {
            com.opos.cmn.i.g.a(getContext().getApplicationContext(), getWindow());
            super.show();
        }
    }
}
