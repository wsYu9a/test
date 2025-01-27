package com.opos.cmn.e.a.b.f;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.opos.cmn.i.g;

/* loaded from: classes4.dex */
public class a extends Dialog {

    /* renamed from: a */
    private boolean f16973a;

    /* renamed from: b */
    private com.opos.cmn.e.a.b.d.a f16974b;

    /* renamed from: c */
    private Activity f16975c;

    public a(Activity activity, int i2, com.opos.cmn.e.a.b.d.a aVar) {
        super(activity, i2);
        this.f16973a = true;
        this.f16975c = activity;
        this.f16974b = aVar;
    }

    public a(Activity activity, com.opos.cmn.e.a.b.d.a aVar) {
        super(activity);
        this.f16973a = true;
        this.f16975c = activity;
        this.f16974b = aVar;
    }

    private void a() {
        com.opos.cmn.e.a.b.d.a aVar = this.f16974b;
        if (aVar != null) {
            setCancelable(aVar.f16965b);
            setCanceledOnTouchOutside(this.f16974b.f16966c);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f16973a) {
            com.opos.cmn.an.f.a.a("", "dialog has detach do not dismiss");
        } else {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16973a = false;
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
        this.f16973a = true;
        com.opos.cmn.an.f.a.b("", "dialog onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.f16975c;
        if (activity == null || activity.isFinishing() || this.f16975c.isDestroyed()) {
            com.opos.cmn.an.f.a.b("", "show but activity has destroy");
        } else {
            g.a(getContext().getApplicationContext(), getWindow());
            super.show();
        }
    }
}
