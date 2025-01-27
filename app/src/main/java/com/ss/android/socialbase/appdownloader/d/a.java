package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* loaded from: classes4.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {

    /* renamed from: a */
    private AlertDialog.Builder f21814a;

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a */
    public static class C0647a implements k {

        /* renamed from: a */
        private AlertDialog f21815a;

        public C0647a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f21815a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            AlertDialog alertDialog = this.f21815a;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            AlertDialog alertDialog = this.f21815a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public a(Context context) {
        this.f21814a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i10) {
        AlertDialog.Builder builder = this.f21814a;
        if (builder != null) {
            builder.setTitle(i10);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l b(int i10, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f21814a;
        if (builder != null) {
            builder.setNegativeButton(i10, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(String str) {
        AlertDialog.Builder builder = this.f21814a;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i10, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f21814a;
        if (builder != null) {
            builder.setPositiveButton(i10, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.f21814a;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public k a() {
        return new C0647a(this.f21814a);
    }
}
