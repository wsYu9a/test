package cn.vlion.ad.inland.ad.natives;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class VlionNativeViewEventManager {

    /* renamed from: a */
    public ViewGroup f2299a;

    /* renamed from: b */
    public List<View> f2300b;

    /* renamed from: c */
    public List<View> f2301c;

    /* renamed from: d */
    public VlionCustomsNativeEventListener f2302d;

    /* renamed from: e */
    public d f2303e;

    /* renamed from: f */
    public a f2304f;

    /* renamed from: g */
    public WeakReference<Activity> f2305g;

    /* renamed from: h */
    public volatile boolean f2306h;

    /* renamed from: i */
    public b f2307i;

    /* renamed from: j */
    public c f2308j;

    /* renamed from: k */
    public String f2309k;

    /* renamed from: l */
    public List<VlionCustomAdData.SeatbidBean.BidBean.McBean.macroValues> f2310l;

    /* renamed from: m */
    public boolean f2311m;

    /* renamed from: n */
    public boolean f2312n = true;

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            LogVlion.e("VlionNativeViewEventManager onScrollChanged");
            VlionNativeViewEventManager vlionNativeViewEventManager = VlionNativeViewEventManager.this;
            VlionNativeViewEventManager.a(vlionNativeViewEventManager, vlionNativeViewEventManager.b());
        }
    }

    public class b implements ViewTreeObserver.OnWindowFocusChangeListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z10) {
            LogVlion.e("VlionNativeViewEventManager onWindowFocusChanged" + z10);
            VlionNativeViewEventManager.a(VlionNativeViewEventManager.this, z10);
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            StringBuilder a10 = l1.a("VlionNativeViewEventManager onGlobalLayout");
            a10.append(VlionNativeViewEventManager.this.f2312n);
            LogVlion.e(a10.toString());
            VlionNativeViewEventManager vlionNativeViewEventManager = VlionNativeViewEventManager.this;
            if (vlionNativeViewEventManager.f2312n) {
                VlionNativeViewEventManager.a(vlionNativeViewEventManager, true);
            }
        }
    }

    public class d implements Application.ActivityLifecycleCallbacks {
        public d() {
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
                LogVlion.e("VlionNativeViewEventManager onActivityPaused");
                if (VlionNativeViewEventManager.this.f2305g.get() == null || VlionNativeViewEventManager.this.f2305g.get().isFinishing() || activity != VlionNativeViewEventManager.this.f2305g.get()) {
                    return;
                }
                LogVlion.e("VlionNativeViewEventManager ------current------ onActivityPaused");
                VlionNativeViewEventManager vlionNativeViewEventManager = VlionNativeViewEventManager.this;
                vlionNativeViewEventManager.f2312n = false;
                VlionNativeViewEventManager.a(vlionNativeViewEventManager, false);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                LogVlion.e("VlionNativeViewEventManager onActivityResumed");
                if (VlionNativeViewEventManager.this.f2305g.get() == null || VlionNativeViewEventManager.this.f2305g.get().isFinishing() || activity != VlionNativeViewEventManager.this.f2305g.get()) {
                    return;
                }
                LogVlion.e("VlionNativeViewEventManager ------current------  onActivityResumed");
                VlionNativeViewEventManager vlionNativeViewEventManager = VlionNativeViewEventManager.this;
                vlionNativeViewEventManager.f2312n = true;
                VlionNativeViewEventManager.a(vlionNativeViewEventManager, true);
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

    public class e implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f2317a;

        /* renamed from: b */
        public final /* synthetic */ int[] f2318b;

        /* renamed from: c */
        public final /* synthetic */ i0 f2319c;

        public e(int i10, int[] iArr, i0 i0Var) {
            this.f2317a = i10;
            this.f2318b = iArr;
            this.f2319c = i0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionNativeViewEventManager clickview position= " + this.f2317a);
                if (VlionNativeViewEventManager.this.f2302d != null) {
                    VlionADClickType vlionADClickType = new VlionADClickType("click", DensityUtil.px2dip(VlionNativeViewEventManager.this.f2305g.get(), this.f2318b[0]) + "," + DensityUtil.px2dip(VlionNativeViewEventManager.this.f2305g.get(), this.f2318b[1]), "main", "hotsplot", "");
                    VlionNativeViewEventManager vlionNativeViewEventManager = VlionNativeViewEventManager.this;
                    VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(vlionNativeViewEventManager.f2309k, vlionNativeViewEventManager.f2310l);
                    vlionClickParameterReplace.handleBaseParameter(VlionNativeViewEventManager.this.f2299a);
                    vlionClickParameterReplace.handleClickParameter(this.f2319c, vlionADClickType);
                    vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                    VlionNativeViewEventManager.this.f2302d.onClick(vlionADClickType);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f2321a;

        public f(int i10) {
            this.f2321a = i10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionNativeViewEventManager closeList position= " + this.f2321a);
                VlionCustomsNativeEventListener vlionCustomsNativeEventListener = VlionNativeViewEventManager.this.f2302d;
                if (vlionCustomsNativeEventListener != null) {
                    vlionCustomsNativeEventListener.onClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public VlionNativeViewEventManager(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, String str, List<VlionCustomAdData.SeatbidBean.BidBean.McBean.macroValues> list3, VlionCustomsNativeEventListener vlionCustomsNativeEventListener) {
        this.f2309k = "";
        this.f2305g = new WeakReference<>(activity);
        this.f2299a = viewGroup;
        this.f2300b = list;
        this.f2301c = list2;
        this.f2309k = str;
        this.f2310l = list3;
        this.f2302d = vlionCustomsNativeEventListener;
        a();
    }

    public final void a() {
        try {
            LogVlion.e("VlionNativeViewEventManager initRender");
            ViewGroup viewGroup = this.f2299a;
            if (viewGroup != null) {
                this.f2304f = new a();
                this.f2307i = new b();
                this.f2308j = new c();
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.f2304f);
                this.f2299a.getViewTreeObserver().addOnWindowFocusChangeListener(this.f2307i);
                this.f2299a.getViewTreeObserver().addOnGlobalLayoutListener(this.f2308j);
            }
            this.f2303e = new d();
            if (this.f2305g.get() != null) {
                VlionSDkManager.getInstance().registerActivityLifecycleCallbacks(this.f2303e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final boolean b() {
        try {
            ViewGroup viewGroup = this.f2299a;
            if (viewGroup == null) {
                return false;
            }
            int width = viewGroup.getWidth();
            int height = this.f2299a.getHeight();
            LogVlion.e("VlionNativeViewEventManager isRectVisible: width()=" + width + " height=" + height);
            if (width == 0 || height == 0) {
                return false;
            }
            Rect rect = new Rect();
            boolean isShown = this.f2299a.isShown();
            boolean localVisibleRect = this.f2299a.getLocalVisibleRect(rect);
            LogVlion.e("VlionNativeViewEventManager isRectVisible: isShown=" + isShown + " isLocalVisibleRect=" + localVisibleRect);
            if (isShown && localVisibleRect) {
                int i10 = (rect.bottom - rect.top) * (rect.right - rect.left);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionNativeViewEventManager isRectVisible: width * height=");
                int i11 = width * height;
                sb2.append(i11);
                sb2.append(" (rect.right - rect.left) * (rect.bottom - rect.top)=");
                sb2.append((rect.bottom - rect.top) * (rect.right - rect.left));
                sb2.append(" 左移一位=");
                sb2.append(((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
                LogVlion.e(sb2.toString());
                if (!this.f2311m && i10 > 0) {
                    VlionCustomsNativeEventListener vlionCustomsNativeEventListener = this.f2302d;
                    if (vlionCustomsNativeEventListener != null) {
                        vlionCustomsNativeEventListener.onAdEnter();
                    }
                    this.f2311m = true;
                }
                return i11 <= (((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public final void c() {
        try {
            LogVlion.e("VlionNativeViewEventManager exposure ");
            VlionCustomsNativeEventListener vlionCustomsNativeEventListener = this.f2302d;
            if (vlionCustomsNativeEventListener != null) {
                vlionCustomsNativeEventListener.onExposure();
            }
            this.f2306h = true;
            List<View> list = this.f2300b;
            if (list != null && list.size() > 0) {
                LogVlion.e("VlionNativeViewEventManager clickList.size()= " + this.f2300b.size());
                for (int i10 = 0; i10 < this.f2300b.size(); i10++) {
                    View view = this.f2300b.get(i10);
                    if (view != null) {
                        view.setOnClickListener(new e(i10, new int[2], new i0(view)));
                    }
                }
            }
            List<View> list2 = this.f2301c;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            LogVlion.e("VlionNativeViewEventManager closeList.size()= " + this.f2301c.size());
            for (int i11 = 0; i11 < this.f2301c.size(); i11++) {
                View view2 = this.f2301c.get(i11);
                if (view2 != null) {
                    view2.setOnClickListener(new f(i11));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        try {
            LogVlion.e("VlionNativeViewEventManager unregisterExposure= ");
            if (this.f2304f != null && (viewGroup3 = this.f2299a) != null) {
                viewGroup3.getViewTreeObserver().removeOnScrollChangedListener(this.f2304f);
                this.f2304f = null;
            }
            if (this.f2307i != null && (viewGroup2 = this.f2299a) != null) {
                viewGroup2.getViewTreeObserver().removeOnWindowFocusChangeListener(this.f2307i);
                this.f2307i = null;
            }
            if (this.f2308j == null || (viewGroup = this.f2299a) == null) {
                return;
            }
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this.f2308j);
            this.f2308j = null;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void destroy() {
        try {
            d();
            List<View> list = this.f2300b;
            if (list != null) {
                list.clear();
            }
            List<View> list2 = this.f2301c;
            if (list2 != null) {
                list2.clear();
            }
            if (this.f2303e != null) {
                VlionSDkManager.getInstance().unregisterActivityLifecycleCallbacks(this.f2303e);
                this.f2303e = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(VlionNativeViewEventManager vlionNativeViewEventManager, boolean z10) {
        vlionNativeViewEventManager.getClass();
        try {
            LogVlion.e("VlionNativeViewEventManager isResume= " + z10 + " isExposure=" + vlionNativeViewEventManager.f2306h);
            if (!vlionNativeViewEventManager.f2306h && z10) {
                boolean b10 = vlionNativeViewEventManager.b();
                LogVlion.e("VlionNativeViewEventManager isViewVisible: isRectVisible=" + b10);
                if (b10) {
                    LogVlion.e("VlionNativeViewEventManager becomeVisible: ");
                    vlionNativeViewEventManager.c();
                }
            }
            VlionCustomsNativeEventListener vlionCustomsNativeEventListener = vlionNativeViewEventManager.f2302d;
            if (vlionCustomsNativeEventListener != null) {
                vlionCustomsNativeEventListener.isResume(z10 && vlionNativeViewEventManager.b());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
