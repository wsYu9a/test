package b.b.a.g;

import android.app.ProgressDialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
final class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f4280a = false;

    /* renamed from: b */
    final /* synthetic */ DialogInterface.OnCancelListener f4281b = null;

    /* renamed from: c */
    final /* synthetic */ CharSequence f4282c;

    /* renamed from: d */
    final /* synthetic */ a f4283d;

    b(a aVar, CharSequence charSequence) {
        this.f4283d = aVar;
        this.f4282c = charSequence;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f4283d;
        if (aVar.f4279b == null) {
            aVar.f4279b = new ProgressDialog(this.f4283d.f4278a);
        }
        this.f4283d.f4279b.setCancelable(this.f4280a);
        this.f4283d.f4279b.setOnCancelListener(this.f4281b);
        this.f4283d.f4279b.setMessage(this.f4282c);
        try {
            this.f4283d.f4279b.show();
        } catch (Exception unused) {
            this.f4283d.f4279b = null;
        }
    }
}
