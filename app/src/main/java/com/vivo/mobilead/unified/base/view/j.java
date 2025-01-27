package com.vivo.mobilead.unified.base.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.vivo.mobilead.util.y0;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    private Dialog f29876a;

    /* renamed from: b */
    private Context f29877b;

    /* renamed from: c */
    private k f29878c;

    /* renamed from: e */
    private d f29880e;

    /* renamed from: d */
    private AtomicInteger f29879d = new AtomicInteger(3);

    /* renamed from: f */
    private Runnable f29881f = new c();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.f29880e != null) {
                j.this.f29880e.cancel();
            }
            j.this.a();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.f29880e != null) {
                j.this.f29880e.a();
            }
            j.this.a();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f29879d.decrementAndGet() >= 0) {
                if (j.this.f29878c != null) {
                    j.this.f29878c.setTvSure(j.this.f29879d.get());
                }
                com.vivo.mobilead.util.f1.c.b(j.this.f29881f, 1000L);
            } else {
                if (j.this.f29880e != null) {
                    j.this.f29880e.a();
                }
                j.this.a();
            }
        }
    }

    public interface d {
        void a();

        void cancel();
    }

    public j(Context context) {
        this.f29877b = context;
        k kVar = new k(context);
        this.f29878c = kVar;
        kVar.setCancelClickListener(new a());
        this.f29878c.setSureClickListener(new b());
        Dialog dialog = new Dialog(context);
        this.f29876a = dialog;
        dialog.requestWindowFeature(1);
        if (this.f29876a.getWindow() != null) {
            this.f29876a.getWindow().setBackgroundDrawable(y0.a(context));
        }
        this.f29876a.setContentView(this.f29878c, new ViewGroup.LayoutParams(com.vivo.mobilead.util.m.a(context, 304.0f), -2));
        this.f29876a.setCanceledOnTouchOutside(true);
        com.vivo.mobilead.util.f1.c.b(this.f29881f, 1000L);
    }

    public void a(String str) {
        k kVar = this.f29878c;
        if (kVar != null) {
            kVar.setIcon(str);
        }
    }

    public void b() {
        Context context;
        Dialog dialog = this.f29876a;
        if (dialog == null || dialog.isShowing() || (context = this.f29877b) == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.f29876a.show();
    }

    public void a(d dVar) {
        this.f29880e = dVar;
    }

    public void a() {
        Context context;
        com.vivo.mobilead.util.f1.c.e(this.f29881f);
        if (this.f29876a == null || (context = this.f29877b) == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.f29876a.dismiss();
    }
}
