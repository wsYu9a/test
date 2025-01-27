package com.vivo.mobilead.unified.base.view;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.PopupWindow;
import com.vivo.mobilead.unified.base.view.h;
import java.io.File;

/* loaded from: classes4.dex */
public class g extends PopupWindow {

    /* renamed from: a */
    private Activity f29853a;

    /* renamed from: b */
    private h f29854b;

    /* renamed from: c */
    private int f29855c;

    /* renamed from: d */
    private int f29856d;

    /* renamed from: e */
    private boolean f29857e;

    /* renamed from: f */
    private h.b f29858f;

    /* renamed from: g */
    private Application.ActivityLifecycleCallbacks f29859g;

    class a implements h.b {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.view.h.b
        public void a(float f2, float f3) {
            g.this.f29855c = (int) (r0.f29855c + f2);
            g.this.f29856d = (int) (r3.f29856d + f3);
            g gVar = g.this;
            gVar.update(gVar.f29855c, g.this.f29856d, -1, -1);
        }
    }

    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            g.this.f29853a.getApplication().unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity.equals(g.this.f29853a)) {
                g.this.f29857e = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity.equals(g.this.f29853a)) {
                g.this.f29857e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public g(Activity activity, int i2, int i3) {
        super(activity);
        this.f29857e = true;
        this.f29858f = new a();
        this.f29859g = new b();
        this.f29853a = activity;
        this.f29855c = i2;
        this.f29856d = i3;
        setFocusable(false);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        this.f29853a.getApplication().registerActivityLifecycleCallbacks(this.f29859g);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
    }

    public boolean c() {
        return this.f29857e;
    }

    public Rect b() {
        if (this.f29854b != null) {
            int i2 = this.f29855c;
            return new Rect(i2, this.f29856d, this.f29854b.getWidth() + i2, this.f29856d + this.f29854b.getHeight());
        }
        int i3 = this.f29855c;
        int i4 = this.f29856d;
        return new Rect(i3, i4, i3, i4);
    }

    public void a() {
        super.dismiss();
    }

    public void a(com.vivo.ad.model.b bVar, Bitmap bitmap, byte[] bArr, File file, View.OnClickListener onClickListener, com.vivo.ad.view.k kVar, com.vivo.mobilead.unified.base.callback.d dVar) {
        h hVar = new h(this.f29853a);
        this.f29854b = hVar;
        hVar.setCloseListener(onClickListener);
        this.f29854b.setWidgetClickListener(kVar);
        this.f29854b.setDragListener(this.f29858f);
        this.f29854b.setExposureListener(dVar);
        this.f29854b.a(bitmap, bArr, file, bVar.e(), bVar.k(), bVar.O());
        setContentView(this.f29854b);
        if (this.f29855c < 0 || this.f29856d < 0) {
            DisplayMetrics displayMetrics = this.f29853a.getResources().getDisplayMetrics();
            this.f29856d = displayMetrics.heightPixels / 4;
            this.f29855c = (displayMetrics.widthPixels - com.vivo.mobilead.util.m.a(this.f29853a, 14.0f)) - com.vivo.mobilead.util.m.a(this.f29853a, 60.0f);
        }
        super.showAtLocation(this.f29853a.getWindow().getDecorView(), 51, this.f29855c, this.f29856d);
    }

    public void a(com.vivo.ad.model.b bVar, Bitmap bitmap, byte[] bArr, File file) {
        if (this.f29854b == null || !isShowing()) {
            return;
        }
        this.f29854b.a(bitmap, bArr, file, bVar.e(), bVar.k(), bVar.O());
    }
}
