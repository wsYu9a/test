package cn.vlion.ad.inland.ad.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public class VlionBaseAdView extends FrameLayout {

    /* renamed from: a */
    public b f2229a;

    /* renamed from: b */
    public a f2230b;

    /* renamed from: c */
    public cn.vlion.ad.inland.base.a f2231c;

    /* renamed from: d */
    public volatile boolean f2232d;

    /* renamed from: e */
    public boolean f2233e;

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            LogVlion.e("VlionBaseAdView onScrollChanged");
            VlionBaseAdView vlionBaseAdView = VlionBaseAdView.this;
            vlionBaseAdView.a(vlionBaseAdView.c());
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            LogVlion.e("VlionBaseAdView onActivityPaused");
            VlionBaseAdView.this.a(false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            LogVlion.e("VlionBaseAdView onActivityResumed");
            VlionBaseAdView.this.a(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    public VlionBaseAdView(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            LogVlion.e("VlionBaseAdView unregisterExposure= ");
            if (this.f2230b != null) {
                getViewTreeObserver().removeOnScrollChangedListener(this.f2230b);
                this.f2230b = null;
            }
            if (this.f2229a != null) {
                VlionSDkManager.getInstance().unregisterActivityLifecycleCallbacks(this.f2229a);
                this.f2229a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b() {
        try {
            LogVlion.e("VlionBaseAdView initRender");
            this.f2230b = new a();
            getViewTreeObserver().addOnScrollChangedListener(this.f2230b);
            this.f2229a = new b();
            VlionSDkManager.getInstance().registerActivityLifecycleCallbacks(this.f2229a);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final boolean c() {
        try {
            int width = getWidth();
            int height = getHeight();
            LogVlion.e("VlionBaseAdView isRectVisible: width()=" + width + " height=" + height);
            if (width == 0 || height == 0) {
                return false;
            }
            Rect rect = new Rect();
            boolean isShown = isShown();
            boolean localVisibleRect = getLocalVisibleRect(rect);
            LogVlion.e("VlionBaseAdView isRectVisible: isShown=" + isShown + " isLocalVisibleRect=" + localVisibleRect);
            if (isShown && localVisibleRect) {
                int i10 = (rect.bottom - rect.top) * (rect.right - rect.left);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionBaseAdView isRectVisible: width * height=");
                int i11 = width * height;
                sb2.append(i11);
                sb2.append(" (rect.right - rect.left) * (rect.bottom - rect.top)=");
                sb2.append((rect.bottom - rect.top) * (rect.right - rect.left));
                sb2.append(" 左移一位=");
                sb2.append(((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
                sb2.append(" rectPix=");
                sb2.append(i10);
                LogVlion.e(sb2.toString());
                if (!this.f2233e && i10 > 0) {
                    cn.vlion.ad.inland.base.a aVar = this.f2231c;
                    if (aVar != null) {
                        aVar.onAdEnter();
                    }
                    this.f2233e = true;
                }
                return i11 <= (((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        LogVlion.e("VlionBaseAdView onLayout:");
        a(c());
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        LogVlion.e("VlionBaseAdView onWindowFocusChanged hasWindowFocus=" + z10);
        a(z10);
    }

    public void setAdExposureListener(cn.vlion.ad.inland.base.a aVar) {
        this.f2231c = aVar;
    }

    public VlionBaseAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(boolean z10) {
        try {
            LogVlion.e("VlionBaseAdView isResume= " + z10 + " isExposure=" + this.f2232d);
            if (this.f2232d || !z10) {
                return;
            }
            boolean c10 = c();
            LogVlion.e("VlionBaseAdView isViewVisible: isRectVisible=" + c10);
            if (c10) {
                LogVlion.e("VlionBaseAdView becomeVisible: ");
                try {
                    LogVlion.e("VlionBaseAdView exposure ");
                    cn.vlion.ad.inland.base.a aVar = this.f2231c;
                    if (aVar != null) {
                        aVar.onAdExposure();
                    }
                    this.f2232d = true;
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public VlionBaseAdView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
