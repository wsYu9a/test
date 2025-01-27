package com.sigmob.sdk.base.common;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a */
    public String f17898a;

    /* renamed from: b */
    public Context f17899b;

    /* renamed from: c */
    public ImageView f17900c;

    /* renamed from: d */
    public RelativeLayout f17901d;

    /* renamed from: e */
    public k f17902e;

    /* renamed from: f */
    public RelativeLayout f17903f;

    /* renamed from: g */
    public g f17904g;

    /* renamed from: h */
    public WeakReference<Activity> f17905h;

    public j(Activity activity, String str, k kVar) {
        this.f17899b = activity.getApplicationContext();
        this.f17905h = new WeakReference<>(activity);
        this.f17898a = str;
        this.f17902e = kVar;
        this.f17901d = new RelativeLayout(this.f17899b);
    }

    public void a(int i10, int i11, Intent intent) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public boolean b() {
        return true;
    }

    public void c() {
        try {
            ImageView imageView = this.f17900c;
            if (imageView != null) {
                com.sigmob.sdk.base.utils.e.e(imageView);
                this.f17900c = null;
            }
        } catch (Throwable unused) {
        }
    }

    public void d() {
        try {
            e();
            ImageView imageView = this.f17900c;
            if (imageView != null) {
                this.f17901d.addView(imageView, 0, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Throwable unused) {
        }
    }

    public final void e() {
        ViewGroup viewGroup;
        View childAt;
        Activity g10 = com.sigmob.sdk.a.g();
        ViewGroup i10 = i();
        if (g10 == null || i10 == null || (viewGroup = (ViewGroup) g10.getWindow().findViewById(R.id.content)) == null || (childAt = viewGroup.getChildAt(0)) == null) {
            return;
        }
        com.sigmob.sdk.base.blurkit.a.a(this.f17899b);
        Bitmap a10 = com.sigmob.sdk.base.blurkit.a.a().a(childAt, 25);
        if (this.f17900c == null) {
            this.f17900c = new ImageView(this.f17899b);
        }
        this.f17900c.setImageBitmap(a10);
    }

    public Activity f() {
        Activity b10 = com.sigmob.sdk.base.utils.e.b(this.f17901d);
        if (b10 != null) {
            return b10;
        }
        WeakReference<Activity> weakReference = this.f17905h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public k g() {
        return this.f17902e;
    }

    public Context h() {
        return this.f17899b;
    }

    public ViewGroup i() {
        RelativeLayout relativeLayout = this.f17903f;
        return relativeLayout != null ? relativeLayout : this.f17901d;
    }

    public abstract void j();

    public abstract void k();

    public void l() {
        this.f17902e = null;
        RelativeLayout relativeLayout = this.f17901d;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public void p() {
        WindowManager.LayoutParams attributes = f().getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        f().getWindow().setAttributes(attributes);
    }

    public void a(String str) {
        String str2 = this.f17898a;
        if (str2 != null) {
            BaseBroadcastReceiver.a(this.f17899b, str2, str);
        } else {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    public void a(String str, int i10) {
        String str2 = this.f17898a;
        if (str2 != null) {
            BaseBroadcastReceiver.a(this.f17899b, str2, str, i10);
        } else {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    public void a(String str, Map<String, Object> map) {
        String str2 = this.f17898a;
        if (str2 != null) {
            BaseBroadcastReceiver.a(this.f17899b, str2, map, str, 0);
        } else {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    public void a(Context context, int i10, Bundle bundle) {
        g gVar;
        if (bundle != null) {
            try {
                if (bundle.getBoolean(com.sigmob.sdk.base.k.f18192x, false)) {
                    int i11 = context.getResources().getDisplayMetrics().widthPixels;
                    int i12 = context.getResources().getDisplayMetrics().heightPixels;
                    if (i10 == 6) {
                        int min = (Math.min(i11, i12) * 85) / 100;
                        gVar = new g((min * 16) / 9, min);
                    } else {
                        int min2 = (Math.min(i11, i12) * 85) / 100;
                        gVar = new g(min2, (min2 * 16) / 9);
                    }
                    this.f17904g = gVar;
                    this.f17903f = new RelativeLayout(context);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f17904g.b(), this.f17904g.a());
                    layoutParams.addRule(13);
                    this.f17903f.setLayoutParams(layoutParams);
                    this.f17901d.removeAllViews();
                    this.f17901d.addView(this.f17903f);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
