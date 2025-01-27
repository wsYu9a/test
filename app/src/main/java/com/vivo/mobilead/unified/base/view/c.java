package com.vivo.mobilead.unified.base.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private Dialog f29839a;

    /* renamed from: b */
    private Context f29840b;

    /* renamed from: c */
    private com.vivo.mobilead.unified.base.callback.a f29841c;

    class a implements com.vivo.mobilead.unified.base.callback.a {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.a
        public void a() {
            if (c.this.f29841c != null) {
                c.this.f29841c.a();
            }
            c.this.a();
        }

        @Override // com.vivo.mobilead.unified.base.callback.a
        public void b() {
            if (c.this.f29841c != null) {
                c.this.f29841c.b();
            }
            c.this.a();
        }
    }

    public c(Context context) {
        this.f29840b = context;
        d dVar = new d(context);
        dVar.setActionClickListener(new a());
        Dialog dialog = new Dialog(context);
        this.f29839a = dialog;
        dialog.requestWindowFeature(1);
        if (this.f29839a.getWindow() != null) {
            this.f29839a.getWindow().setBackgroundDrawable(y0.a(context));
        }
        this.f29839a.setContentView(dVar);
        this.f29839a.setCanceledOnTouchOutside(false);
    }

    public void b() {
        Dialog dialog = this.f29839a;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        Context context = this.f29840b;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.f29839a.show();
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        Dialog dialog = this.f29839a;
        if (dialog != null) {
            dialog.setOnDismissListener(onDismissListener);
        }
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        Dialog dialog = this.f29839a;
        if (dialog != null) {
            dialog.setOnShowListener(onShowListener);
        }
    }

    public void a() {
        if (this.f29839a != null) {
            Context context = this.f29840b;
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                return;
            }
            this.f29839a.dismiss();
        }
    }

    public void a(com.vivo.mobilead.unified.base.callback.a aVar) {
        this.f29841c = aVar;
    }
}
