package com.ss.android.socialbase.appdownloader.g;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.i.nt;
import com.ss.android.socialbase.appdownloader.i.t;

/* loaded from: classes4.dex */
public class j extends com.ss.android.socialbase.appdownloader.i.zx {

    /* renamed from: j */
    private AlertDialog.Builder f24426j;

    /* renamed from: com.ss.android.socialbase.appdownloader.g.j$j */
    private static class C0508j implements t {

        /* renamed from: j */
        private AlertDialog f24427j;

        public C0508j(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f24427j = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.i.t
        public void j() {
            AlertDialog alertDialog = this.f24427j;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.i.t
        public boolean zx() {
            AlertDialog alertDialog = this.f24427j;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public j(Context context) {
        this.f24426j = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.i.nt
    public nt j(int i2) {
        AlertDialog.Builder builder = this.f24426j;
        if (builder != null) {
            builder.setTitle(i2);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.i.nt
    public nt zx(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f24426j;
        if (builder != null) {
            builder.setNegativeButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.i.nt
    public nt j(String str) {
        AlertDialog.Builder builder = this.f24426j;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.i.nt
    public nt j(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f24426j;
        if (builder != null) {
            builder.setPositiveButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.i.nt
    public nt j(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.f24426j;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.i.nt
    public t j() {
        return new C0508j(this.f24426j);
    }
}
