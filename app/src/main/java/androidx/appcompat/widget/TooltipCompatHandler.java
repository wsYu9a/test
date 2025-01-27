package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private static final String f1019a = "TooltipCompatHandler";

    /* renamed from: b */
    private static final long f1020b = 2500;

    /* renamed from: c */
    private static final long f1021c = 15000;

    /* renamed from: d */
    private static final long f1022d = 3000;

    /* renamed from: e */
    private static TooltipCompatHandler f1023e;

    /* renamed from: f */
    private static TooltipCompatHandler f1024f;

    /* renamed from: g */
    private final View f1025g;

    /* renamed from: h */
    private final CharSequence f1026h;

    /* renamed from: i */
    private final int f1027i;

    /* renamed from: j */
    private final Runnable f1028j = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.f(false);
        }
    };
    private final Runnable k = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.c();
        }
    };
    private int l;
    private int m;
    private TooltipPopup n;
    private boolean o;

    /* renamed from: androidx.appcompat.widget.TooltipCompatHandler$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.f(false);
        }
    }

    /* renamed from: androidx.appcompat.widget.TooltipCompatHandler$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.c();
        }
    }

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f1025g = view;
        this.f1026h = charSequence;
        this.f1027i = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f1025g.removeCallbacks(this.f1028j);
    }

    private void b() {
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    private void d() {
        this.f1025g.postDelayed(this.f1028j, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = f1023e;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.a();
        }
        f1023e = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.d();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.l) <= this.f1027i && Math.abs(y - this.m) <= this.f1027i) {
            return false;
        }
        this.l = x;
        this.m = y;
        return true;
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = f1023e;
        if (tooltipCompatHandler != null && tooltipCompatHandler.f1025g == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new TooltipCompatHandler(view, charSequence);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler2 = f1024f;
        if (tooltipCompatHandler2 != null && tooltipCompatHandler2.f1025g == view) {
            tooltipCompatHandler2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    void c() {
        if (f1024f == this) {
            f1024f = null;
            TooltipPopup tooltipPopup = this.n;
            if (tooltipPopup != null) {
                tooltipPopup.c();
                this.n = null;
                b();
                this.f1025g.removeOnAttachStateChangeListener(this);
            } else {
                Log.e(f1019a, "sActiveHandler.mPopup == null");
            }
        }
        if (f1023e == this) {
            e(null);
        }
        this.f1025g.removeCallbacks(this.k);
    }

    void f(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (ViewCompat.isAttachedToWindow(this.f1025g)) {
            e(null);
            TooltipCompatHandler tooltipCompatHandler = f1024f;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.c();
            }
            f1024f = this;
            this.o = z;
            TooltipPopup tooltipPopup = new TooltipPopup(this.f1025g.getContext());
            this.n = tooltipPopup;
            tooltipPopup.e(this.f1025g, this.l, this.m, this.o, this.f1026h);
            this.f1025g.addOnAttachStateChangeListener(this);
            if (this.o) {
                j3 = f1020b;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f1025g) & 1) == 1) {
                    j2 = f1022d;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = f1021c;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f1025g.removeCallbacks(this.k);
            this.f1025g.postDelayed(this.k, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.n != null && this.o) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1025g.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f1025g.isEnabled() && this.n == null && g(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.l = view.getWidth() / 2;
        this.m = view.getHeight() / 2;
        f(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
