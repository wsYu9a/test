package cn.vlion.ad.inland.base;

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
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class v0 extends FrameLayout {

    /* renamed from: a */
    public b f3420a;

    /* renamed from: b */
    public a f3421b;

    /* renamed from: c */
    public Activity f3422c;

    /* renamed from: d */
    public cn.vlion.ad.inland.base.a f3423d;

    /* renamed from: e */
    public volatile boolean f3424e;

    /* renamed from: f */
    public boolean f3425f;

    /* renamed from: g */
    public WeakReference<Activity> f3426g;

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            LogVlion.e("VlionBaseAdVideoExposureView onScrollChanged");
            v0 v0Var = v0.this;
            v0Var.a(v0Var.b());
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
            try {
                LogVlion.e("VlionBaseAdVideoExposureView onActivityPaused");
                if (v0.this.f3426g.get() == null || v0.this.f3426g.get().isFinishing() || activity != v0.this.f3426g.get()) {
                    return;
                }
                LogVlion.e("VlionBaseAdVideoExposureView ------current------ onActivityPaused");
                v0.this.getClass();
                v0.this.a(false);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                LogVlion.e("VlionBaseAdVideoExposureView onActivityResumed");
                if (v0.this.f3426g.get() == null || v0.this.f3426g.get().isFinishing() || activity != v0.this.f3426g.get()) {
                    return;
                }
                LogVlion.e("VlionBaseAdVideoExposureView ------current------  onActivityResumed");
                v0.this.getClass();
                v0.this.a(true);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
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

    public v0(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            LogVlion.e("VlionBaseAdVideoExposureView initRender");
            this.f3421b = new a();
            getViewTreeObserver().addOnScrollChangedListener(this.f3421b);
            this.f3420a = new b();
            VlionSDkManager.getInstance().registerActivityLifecycleCallbacks(this.f3420a);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final boolean b() {
        try {
            int width = getWidth();
            int height = getHeight();
            LogVlion.e("VlionBaseAdVideoExposureView isRectVisible: width()=" + width + " height=" + height);
            if (width == 0 || height == 0) {
                return false;
            }
            Rect rect = new Rect();
            boolean isShown = isShown();
            boolean localVisibleRect = getLocalVisibleRect(rect);
            LogVlion.e("VlionBaseAdVideoExposureView isRectVisible: isShown=" + isShown + " isLocalVisibleRect=" + localVisibleRect);
            if (isShown && localVisibleRect) {
                int i10 = (rect.bottom - rect.top) * (rect.right - rect.left);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionBaseAdVideoExposureView isRectVisible: width * height=");
                int i11 = width * height;
                sb2.append(i11);
                sb2.append(" (rect.right - rect.left) * (rect.bottom - rect.top)=");
                sb2.append((rect.bottom - rect.top) * (rect.right - rect.left));
                sb2.append(" 左移一位=");
                sb2.append(((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
                sb2.append(" rectPix=");
                sb2.append(i10);
                LogVlion.e(sb2.toString());
                if (!this.f3425f && i10 > 0) {
                    cn.vlion.ad.inland.base.a aVar = this.f3423d;
                    if (aVar != null) {
                        aVar.onAdEnter();
                    }
                    this.f3425f = true;
                }
                return i11 <= (((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public void destroy() {
        try {
            LogVlion.e("VlionBaseAdVideoExposureView unregisterExposure= ");
            if (this.f3421b != null) {
                getViewTreeObserver().removeOnScrollChangedListener(this.f3421b);
                this.f3421b = null;
            }
            if (this.f3420a != null) {
                VlionSDkManager.getInstance().unregisterActivityLifecycleCallbacks(this.f3420a);
                this.f3420a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        LogVlion.e("VlionBaseAdVideoExposureView onLayout:");
        if (this.f3424e) {
            return;
        }
        a(b());
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        LogVlion.e("VlionBaseAdVideoExposureView onWindowFocusChanged hasWindowFocus=" + z10);
        a(z10);
    }

    public void setAdExposureListener(cn.vlion.ad.inland.base.a aVar) {
        this.f3423d = aVar;
    }

    public v0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(boolean z10) {
        try {
            LogVlion.e("VlionBaseAdVideoExposureView isResume= " + z10 + " isExposure=" + this.f3424e);
            if (this.f3424e || !z10) {
                return;
            }
            boolean b10 = b();
            LogVlion.e("VlionBaseAdVideoExposureView isViewVisible: isRectVisible=" + b10);
            if (b10) {
                LogVlion.e("VlionBaseAdVideoExposureView becomeVisible: ");
                try {
                    LogVlion.e("VlionBaseAdVideoExposureView exposure ");
                    cn.vlion.ad.inland.base.a aVar = this.f3423d;
                    if (aVar != null) {
                        aVar.onAdExposure();
                    }
                    this.f3424e = true;
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public v0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        if (context != null) {
            try {
                if (context instanceof Activity) {
                    this.f3422c = (Activity) context;
                    this.f3426g = new WeakReference<>(this.f3422c);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
