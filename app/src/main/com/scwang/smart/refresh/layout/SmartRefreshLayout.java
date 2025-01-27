package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.kernel.R;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes3.dex */
public class SmartRefreshLayout extends ViewGroup implements pf.f, NestedScrollingParent {

    /* renamed from: b1 */
    public static sf.b f16688b1;

    /* renamed from: c1 */
    public static sf.c f16689c1;

    /* renamed from: d1 */
    public static sf.d f16690d1;

    /* renamed from: e1 */
    public static ViewGroup.MarginLayoutParams f16691e1 = new ViewGroup.MarginLayoutParams(-1, -1);
    public Interpolator A;
    public int[] B;
    public boolean C;
    public float C0;
    public boolean D;
    public pf.a D0;
    public boolean E;
    public pf.a E0;
    public boolean F;
    public pf.b F0;
    public boolean G;
    public Paint G0;
    public boolean H;
    public Handler H0;
    public boolean I;
    public pf.e I0;
    public boolean J;
    public RefreshState J0;
    public boolean K;
    public RefreshState K0;
    public boolean L;
    public long L0;
    public boolean M;
    public int M0;
    public boolean N;
    public int N0;
    public boolean O;
    public boolean O0;
    public boolean P;
    public boolean P0;
    public boolean Q;
    public boolean Q0;
    public boolean R;
    public boolean R0;
    public boolean S;
    public long S0;
    public boolean T;
    public float T0;
    public boolean U;
    public float U0;
    public boolean V;
    public boolean V0;
    public boolean W;
    public MotionEvent W0;
    public float X0;
    public boolean Y0;
    public Runnable Z0;

    /* renamed from: a0 */
    public boolean f16692a0;

    /* renamed from: a1 */
    public ValueAnimator f16693a1;

    /* renamed from: b */
    public int f16694b;

    /* renamed from: b0 */
    public boolean f16695b0;

    /* renamed from: c */
    public int f16696c;

    /* renamed from: c0 */
    public sf.g f16697c0;

    /* renamed from: d */
    public int f16698d;

    /* renamed from: d0 */
    public sf.e f16699d0;

    /* renamed from: e */
    public int f16700e;

    /* renamed from: e0 */
    public sf.f f16701e0;

    /* renamed from: f */
    public int f16702f;

    /* renamed from: f0 */
    public sf.j f16703f0;

    /* renamed from: g */
    public int f16704g;

    /* renamed from: g0 */
    public int f16705g0;

    /* renamed from: h */
    public int f16706h;

    /* renamed from: h0 */
    public boolean f16707h0;

    /* renamed from: i */
    public float f16708i;

    /* renamed from: i0 */
    public int[] f16709i0;

    /* renamed from: j */
    public float f16710j;

    /* renamed from: j0 */
    public NestedScrollingChildHelper f16711j0;

    /* renamed from: k */
    public float f16712k;

    /* renamed from: k0 */
    public NestedScrollingParentHelper f16713k0;

    /* renamed from: l */
    public float f16714l;

    /* renamed from: l0 */
    public int f16715l0;

    /* renamed from: m */
    public float f16716m;

    /* renamed from: m0 */
    public qf.a f16717m0;

    /* renamed from: n */
    public char f16718n;

    /* renamed from: n0 */
    public int f16719n0;

    /* renamed from: o */
    public boolean f16720o;

    /* renamed from: o0 */
    public qf.a f16721o0;

    /* renamed from: p */
    public boolean f16722p;

    /* renamed from: p0 */
    public int f16723p0;

    /* renamed from: q */
    public boolean f16724q;

    /* renamed from: q0 */
    public int f16725q0;

    /* renamed from: r */
    public int f16726r;

    /* renamed from: r0 */
    public float f16727r0;

    /* renamed from: s */
    public int f16728s;

    /* renamed from: s0 */
    public float f16729s0;

    /* renamed from: t */
    public int f16730t;

    /* renamed from: t0 */
    public float f16731t0;

    /* renamed from: u */
    public int f16732u;

    /* renamed from: u0 */
    public float f16733u0;

    /* renamed from: v */
    public int f16734v;

    /* renamed from: w */
    public int f16735w;

    /* renamed from: x */
    public int f16736x;

    /* renamed from: y */
    public Scroller f16737y;

    /* renamed from: z */
    public VelocityTracker f16738z;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b */
        public final /* synthetic */ boolean f16741b;

        public a(boolean z10) {
            this.f16741b = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.setStateDirectLoading(this.f16741b);
            }
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b */
        public final /* synthetic */ boolean f16743b;

        public b(boolean z10) {
            this.f16743b = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.L0 = System.currentTimeMillis();
                SmartRefreshLayout.this.Q0(RefreshState.Refreshing);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                sf.g gVar = smartRefreshLayout.f16697c0;
                if (gVar != null) {
                    if (this.f16743b) {
                        gVar.b(smartRefreshLayout);
                    }
                } else if (smartRefreshLayout.f16701e0 == null) {
                    smartRefreshLayout.c0(3000);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                pf.a aVar = smartRefreshLayout2.D0;
                if (aVar != null) {
                    float f10 = smartRefreshLayout2.f16727r0;
                    if (f10 < 10.0f) {
                        f10 *= smartRefreshLayout2.f16715l0;
                    }
                    aVar.t(smartRefreshLayout2, smartRefreshLayout2.f16715l0, (int) f10);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                sf.f fVar = smartRefreshLayout3.f16701e0;
                if (fVar == null || !(smartRefreshLayout3.D0 instanceof pf.d)) {
                    return;
                }
                if (this.f16743b) {
                    fVar.b(smartRefreshLayout3);
                }
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                float f11 = smartRefreshLayout4.f16727r0;
                if (f11 < 10.0f) {
                    f11 *= smartRefreshLayout4.f16715l0;
                }
                smartRefreshLayout4.f16701e0.f((pf.d) smartRefreshLayout4.D0, smartRefreshLayout4.f16715l0, (int) f11);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f16693a1 = null;
                if (smartRefreshLayout.f16696c == 0 && (refreshState = smartRefreshLayout.J0) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                    smartRefreshLayout.Q0(refreshState2);
                    return;
                }
                RefreshState refreshState3 = smartRefreshLayout.J0;
                if (refreshState3 != smartRefreshLayout.K0) {
                    smartRefreshLayout.setViceState(refreshState3);
                }
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b */
        public int f16746b = 0;

        /* renamed from: c */
        public final /* synthetic */ int f16747c;

        /* renamed from: d */
        public final /* synthetic */ Boolean f16748d;

        /* renamed from: e */
        public final /* synthetic */ boolean f16749e;

        public d(int i10, Boolean bool, boolean z10) {
            this.f16747c = i10;
            this.f16748d = bool;
            this.f16749e = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f16746b;
            if (i10 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.J0;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.K0 == RefreshState.Refreshing) {
                    smartRefreshLayout.K0 = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.f16693a1;
                    if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.f16693a1.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.f16693a1 = null;
                        if (smartRefreshLayout2.I0.e(0) == null) {
                            SmartRefreshLayout.this.Q0(refreshState2);
                        } else {
                            SmartRefreshLayout.this.Q0(RefreshState.PullDownCanceled);
                        }
                    } else if (refreshState == RefreshState.Refreshing && smartRefreshLayout.D0 != null && smartRefreshLayout.F0 != null) {
                        this.f16746b = i10 + 1;
                        smartRefreshLayout.H0.postDelayed(this, this.f16747c);
                        SmartRefreshLayout.this.Q0(RefreshState.RefreshFinish);
                        if (this.f16748d == Boolean.FALSE) {
                            SmartRefreshLayout.this.a(false);
                        }
                    }
                }
                if (this.f16748d == Boolean.TRUE) {
                    SmartRefreshLayout.this.a(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int o10 = smartRefreshLayout3.D0.o(smartRefreshLayout3, this.f16749e);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            sf.f fVar = smartRefreshLayout4.f16701e0;
            if (fVar != null) {
                pf.a aVar = smartRefreshLayout4.D0;
                if (aVar instanceof pf.d) {
                    fVar.q((pf.d) aVar, this.f16749e);
                }
            }
            if (o10 < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                if (smartRefreshLayout5.f16720o || smartRefreshLayout5.f16707h0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.f16720o) {
                        float f10 = smartRefreshLayout6.f16714l;
                        smartRefreshLayout6.f16710j = f10;
                        smartRefreshLayout6.f16700e = 0;
                        smartRefreshLayout6.f16720o = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout6.f16712k, (f10 + smartRefreshLayout6.f16696c) - (smartRefreshLayout6.f16694b * 2), 0));
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout7.f16712k, smartRefreshLayout7.f16714l + smartRefreshLayout7.f16696c, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.f16707h0) {
                        smartRefreshLayout8.f16705g0 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout8.f16712k, smartRefreshLayout8.f16714l, 0));
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        smartRefreshLayout9.f16707h0 = false;
                        smartRefreshLayout9.f16700e = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i11 = smartRefreshLayout10.f16696c;
                if (i11 <= 0) {
                    if (i11 < 0) {
                        smartRefreshLayout10.E0(0, o10, smartRefreshLayout10.A, smartRefreshLayout10.f16704g);
                        return;
                    } else {
                        smartRefreshLayout10.I0.i(0, false);
                        SmartRefreshLayout.this.I0.o(RefreshState.None);
                        return;
                    }
                }
                ValueAnimator E0 = smartRefreshLayout10.E0(0, o10, smartRefreshLayout10.A, smartRefreshLayout10.f16704g);
                SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener f11 = smartRefreshLayout11.P ? smartRefreshLayout11.F0.f(smartRefreshLayout11.f16696c) : null;
                if (E0 == null || f11 == null) {
                    return;
                }
                E0.addUpdateListener(f11);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b */
        public int f16751b = 0;

        /* renamed from: c */
        public final /* synthetic */ int f16752c;

        /* renamed from: d */
        public final /* synthetic */ boolean f16753d;

        /* renamed from: e */
        public final /* synthetic */ boolean f16754e;

        public class a extends AnimatorListenerAdapter {

            /* renamed from: b */
            public final /* synthetic */ boolean f16756b;

            public a(boolean z10) {
                this.f16756b = z10;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.R0 = false;
                    if (this.f16756b) {
                        smartRefreshLayout.a(true);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.J0 == RefreshState.LoadFinish) {
                        smartRefreshLayout2.Q0(RefreshState.None);
                    }
                }
            }
        }

        public e(int i10, boolean z10, boolean z11) {
            this.f16752c = i10;
            this.f16753d = z10;
            this.f16754e = z11;
        }

        public final /* synthetic */ void b(int i10, boolean z10) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
            ValueAnimator valueAnimator;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (!smartRefreshLayout.O || i10 >= 0) {
                animatorUpdateListener = null;
            } else {
                animatorUpdateListener = smartRefreshLayout.F0.f(smartRefreshLayout.f16696c);
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
            }
            a aVar = new a(z10);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i11 = smartRefreshLayout2.f16696c;
            if (i11 > 0) {
                valueAnimator = smartRefreshLayout2.I0.e(0);
            } else {
                if (animatorUpdateListener != null || i11 == 0) {
                    ValueAnimator valueAnimator2 = smartRefreshLayout2.f16693a1;
                    if (valueAnimator2 != null) {
                        valueAnimator2.setDuration(0L);
                        SmartRefreshLayout.this.f16693a1.cancel();
                        SmartRefreshLayout.this.f16693a1 = null;
                    }
                    SmartRefreshLayout.this.I0.i(0, false);
                    SmartRefreshLayout.this.I0.o(RefreshState.None);
                } else if (z10 && smartRefreshLayout2.I) {
                    int i12 = smartRefreshLayout2.f16719n0;
                    if (i11 >= (-i12)) {
                        smartRefreshLayout2.Q0(RefreshState.None);
                    } else {
                        valueAnimator = smartRefreshLayout2.I0.e(-i12);
                    }
                } else {
                    valueAnimator = smartRefreshLayout2.I0.e(0);
                }
                valueAnimator = null;
            }
            if (valueAnimator != null) {
                valueAnimator.addListener(aVar);
            } else {
                aVar.onAnimationEnd(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        
            if (r6.F0.i() != false) goto L199;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 331
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.e.run():void");
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* renamed from: b */
        public final /* synthetic */ boolean f16758b;

        public f(boolean z10) {
            this.f16758b = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.I0.f(animator, this.f16758b);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* renamed from: b */
        public final /* synthetic */ boolean f16760b;

        public g(boolean z10) {
            this.f16760b = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.I0.j(animator, this.f16760b);
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16762a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f16762a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16762a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16762a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16762a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16762a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16762a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16762a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16762a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16762a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16762a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16762a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16762a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: d */
        public int f16765d;

        /* renamed from: g */
        public float f16768g;

        /* renamed from: b */
        public int f16763b = 0;

        /* renamed from: c */
        public int f16764c = 10;

        /* renamed from: f */
        public float f16767f = 0.0f;

        /* renamed from: e */
        public long f16766e = AnimationUtils.currentAnimationTimeMillis();

        public i(float f10, int i10) {
            this.f16768g = f10;
            this.f16765d = i10;
            SmartRefreshLayout.this.H0.postDelayed(this, this.f16764c);
            if (f10 > 0.0f) {
                SmartRefreshLayout.this.I0.o(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.I0.o(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.Z0 != this || smartRefreshLayout.J0.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.f16696c) < Math.abs(this.f16765d)) {
                double d10 = this.f16768g;
                this.f16763b = this.f16763b + 1;
                this.f16768g = (float) (d10 * Math.pow(0.949999988079071d, r2 * 2));
            } else if (this.f16765d != 0) {
                double d11 = this.f16768g;
                this.f16763b = this.f16763b + 1;
                this.f16768g = (float) (d11 * Math.pow(0.44999998807907104d, r2 * 2));
            } else {
                double d12 = this.f16768g;
                this.f16763b = this.f16763b + 1;
                this.f16768g = (float) (d12 * Math.pow(0.8500000238418579d, r2 * 2));
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f10 = this.f16768g * (((currentAnimationTimeMillis - this.f16766e) * 1.0f) / 1000.0f);
            if (Math.abs(f10) >= 1.0f) {
                this.f16766e = currentAnimationTimeMillis;
                float f11 = this.f16767f + f10;
                this.f16767f = f11;
                SmartRefreshLayout.this.P0(f11);
                SmartRefreshLayout.this.H0.postDelayed(this, this.f16764c);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout2.K0;
            boolean z10 = refreshState.isDragging;
            if (z10 && refreshState.isHeader) {
                smartRefreshLayout2.I0.o(RefreshState.PullDownCanceled);
            } else if (z10 && refreshState.isFooter) {
                smartRefreshLayout2.I0.o(RefreshState.PullUpCanceled);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.Z0 = null;
            if (Math.abs(smartRefreshLayout3.f16696c) >= Math.abs(this.f16765d)) {
                int min = Math.min(Math.max((int) uf.c.i(Math.abs(SmartRefreshLayout.this.f16696c - this.f16765d)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.E0(this.f16765d, 0, smartRefreshLayout4.A, min);
            }
        }
    }

    public class j implements Runnable {

        /* renamed from: b */
        public int f16770b;

        /* renamed from: e */
        public float f16773e;

        /* renamed from: c */
        public int f16771c = 0;

        /* renamed from: d */
        public int f16772d = 10;

        /* renamed from: f */
        public float f16774f = 0.98f;

        /* renamed from: g */
        public long f16775g = 0;

        /* renamed from: h */
        public long f16776h = AnimationUtils.currentAnimationTimeMillis();

        public j(float f10) {
            this.f16773e = f10;
            this.f16770b = SmartRefreshLayout.this.f16696c;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0057, code lost:
        
            if (r0.f16696c > r0.f16715l0) goto L139;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0049, code lost:
        
            if (r0.f16696c >= (-r0.f16719n0)) goto L135;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable a() {
            /*
                r11 = this;
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.J0
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.f16696c
                if (r2 == 0) goto Lab
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L26
                boolean r1 = r0.U
                if (r1 == 0) goto L59
                boolean r1 = r0.I
                if (r1 == 0) goto L59
                boolean r1 = r0.V
                if (r1 == 0) goto L59
                boolean r1 = r0.D
                boolean r0 = r0.H0(r1)
                if (r0 == 0) goto L59
            L26:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.J0
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
                if (r1 == r2) goto L42
                boolean r1 = r0.U
                if (r1 == 0) goto L4b
                boolean r1 = r0.I
                if (r1 == 0) goto L4b
                boolean r1 = r0.V
                if (r1 == 0) goto L4b
                boolean r1 = r0.D
                boolean r0 = r0.H0(r1)
                if (r0 == 0) goto L4b
            L42:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r0.f16696c
                int r0 = r0.f16719n0
                int r0 = -r0
                if (r1 < r0) goto L59
            L4b:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.J0
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto Lab
                int r1 = r0.f16696c
                int r0 = r0.f16715l0
                if (r1 <= r0) goto Lab
            L59:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r0 = r0.f16696c
                float r1 = r11.f16773e
                r2 = 0
                r4 = r0
            L61:
                int r5 = r0 * r4
                if (r5 <= 0) goto Lab
                double r5 = (double) r1
                float r1 = r11.f16774f
                double r7 = (double) r1
                int r2 = r2 + 1
                int r1 = r11.f16772d
                int r1 = r1 * r2
                float r1 = (float) r1
                r9 = 1092616192(0x41200000, float:10.0)
                float r1 = r1 / r9
                double r9 = (double) r1
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r1 = (float) r5
                int r5 = r11.f16772d
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r1
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto La7
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.J0
                boolean r2 = r1.isOpening
                if (r2 == 0) goto La6
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L9f
                int r5 = r0.f16715l0
                if (r4 > r5) goto La6
            L9f:
                if (r1 == r2) goto Lab
                int r0 = r0.f16719n0
                int r0 = -r0
                if (r4 >= r0) goto Lab
            La6:
                return r3
            La7:
                float r4 = (float) r4
                float r4 = r4 + r5
                int r4 = (int) r4
                goto L61
            Lab:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.f16775g = r0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.H0
                int r1 = r11.f16772d
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.j.a():java.lang.Runnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.Z0 != this || smartRefreshLayout.J0.isFinishing) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j10 = currentAnimationTimeMillis - this.f16776h;
            float pow = (float) (this.f16773e * Math.pow(this.f16774f, (currentAnimationTimeMillis - this.f16775g) / (1000.0f / this.f16772d)));
            this.f16773e = pow;
            float f10 = pow * ((j10 * 1.0f) / 1000.0f);
            if (Math.abs(f10) <= 1.0f) {
                SmartRefreshLayout.this.Z0 = null;
                return;
            }
            this.f16776h = currentAnimationTimeMillis;
            int i10 = (int) (this.f16770b + f10);
            this.f16770b = i10;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.f16696c * i10 > 0) {
                smartRefreshLayout2.I0.i(i10, true);
                SmartRefreshLayout.this.H0.postDelayed(this, this.f16772d);
                return;
            }
            smartRefreshLayout2.Z0 = null;
            smartRefreshLayout2.I0.i(0, true);
            uf.c.d(SmartRefreshLayout.this.F0.g(), (int) (-this.f16773e));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.R0 || f10 <= 0.0f) {
                return;
            }
            smartRefreshLayout3.R0 = false;
        }
    }

    public class k implements pf.e {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.I0.o(RefreshState.TwoLevel);
                }
            }
        }

        public k() {
        }

        @Override // pf.e
        public pf.e a(float f10) {
            SmartRefreshLayout.this.C0 = f10;
            return this;
        }

        @Override // pf.e
        public pf.e b(@NonNull pf.a aVar, boolean z10) {
            if (aVar.equals(SmartRefreshLayout.this.D0)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.f16692a0) {
                    smartRefreshLayout.f16692a0 = true;
                    smartRefreshLayout.G = z10;
                }
            } else if (aVar.equals(SmartRefreshLayout.this.E0)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.f16695b0) {
                    smartRefreshLayout2.f16695b0 = true;
                    smartRefreshLayout2.H = z10;
                }
            }
            return this;
        }

        @Override // pf.e
        public pf.e c(@NonNull pf.a aVar, int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.G0 == null && i10 != 0) {
                smartRefreshLayout.G0 = new Paint();
            }
            if (aVar.equals(SmartRefreshLayout.this.D0)) {
                SmartRefreshLayout.this.M0 = i10;
            } else if (aVar.equals(SmartRefreshLayout.this.E0)) {
                SmartRefreshLayout.this.N0 = i10;
            }
            return this;
        }

        @Override // pf.e
        public pf.e d() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.J0 == RefreshState.TwoLevel) {
                smartRefreshLayout.I0.o(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.f16696c == 0) {
                    i(0, false);
                    SmartRefreshLayout.this.Q0(RefreshState.None);
                } else {
                    e(0).setDuration(SmartRefreshLayout.this.f16702f);
                }
            }
            return this;
        }

        @Override // pf.e
        public ValueAnimator e(int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.E0(i10, 0, smartRefreshLayout.A, smartRefreshLayout.f16704g);
        }

        @Override // pf.e
        public pf.e f(Animator animator, boolean z10) {
            if (animator != null && animator.getDuration() == 0) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f16693a1 = null;
            if (smartRefreshLayout.D0 != null) {
                RefreshState refreshState = smartRefreshLayout.J0;
                RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                if (refreshState != refreshState2) {
                    o(refreshState2);
                }
                SmartRefreshLayout.this.setStateRefreshing(!z10);
            } else {
                o(RefreshState.None);
            }
            return this;
        }

        @Override // pf.e
        public pf.e g(int i10) {
            SmartRefreshLayout.this.f16702f = i10;
            return this;
        }

        @Override // pf.e
        public pf.e h(boolean z10) {
            if (z10) {
                a aVar = new a();
                ValueAnimator e10 = e(SmartRefreshLayout.this.getMeasuredHeight());
                if (e10 != null) {
                    if (e10 == SmartRefreshLayout.this.f16693a1) {
                        e10.setDuration(r1.f16702f);
                        e10.addListener(aVar);
                    }
                }
                aVar.onAnimationEnd(null);
            } else if (e(0) == null) {
                SmartRefreshLayout.this.Q0(RefreshState.None);
            }
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b4, code lost:
        
            if (r10 > 0) goto L463;
         */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b9  */
        @Override // pf.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public pf.e i(int r19, boolean r20) {
            /*
                Method dump skipped, instructions count: 910
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.k.i(int, boolean):pf.e");
        }

        @Override // pf.e
        public pf.e j(Animator animator, boolean z10) {
            if (animator != null && animator.getDuration() == 0) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f16693a1 = null;
            if (smartRefreshLayout.E0 != null) {
                RefreshState refreshState = smartRefreshLayout.J0;
                RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                if (refreshState != refreshState2) {
                    o(refreshState2);
                }
                SmartRefreshLayout.this.setStateLoading(!z10);
            } else {
                o(RefreshState.None);
            }
            return this;
        }

        @Override // pf.e
        @NonNull
        public pf.b k() {
            return SmartRefreshLayout.this.F0;
        }

        @Override // pf.e
        @NonNull
        public pf.f l() {
            return SmartRefreshLayout.this;
        }

        @Override // pf.e
        public pf.e m(@NonNull pf.a aVar, boolean z10) {
            if (aVar.equals(SmartRefreshLayout.this.D0)) {
                SmartRefreshLayout.this.O0 = z10;
            } else if (aVar.equals(SmartRefreshLayout.this.E0)) {
                SmartRefreshLayout.this.P0 = z10;
            }
            return this;
        }

        @Override // pf.e
        public pf.e n(@NonNull pf.a aVar) {
            if (aVar.equals(SmartRefreshLayout.this.D0)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                qf.a aVar2 = smartRefreshLayout.f16717m0;
                if (aVar2.f30065b) {
                    smartRefreshLayout.f16717m0 = aVar2.c();
                }
            } else if (aVar.equals(SmartRefreshLayout.this.E0)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                qf.a aVar3 = smartRefreshLayout2.f16721o0;
                if (aVar3.f30065b) {
                    smartRefreshLayout2.f16721o0 = aVar3.c();
                }
            }
            return this;
        }

        @Override // pf.e
        public pf.e o(@NonNull RefreshState refreshState) {
            switch (h.f16762a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.J0;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.f16696c == 0) {
                        smartRefreshLayout.Q0(refreshState3);
                        break;
                    } else if (smartRefreshLayout.f16696c != 0) {
                        e(0);
                        break;
                    }
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.J0.isOpening && smartRefreshLayout2.H0(smartRefreshLayout2.C)) {
                        SmartRefreshLayout.this.Q0(RefreshState.PullDownToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                        break;
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.H0(smartRefreshLayout3.D)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.J0;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.U || !smartRefreshLayout4.I || !smartRefreshLayout4.V)) {
                            smartRefreshLayout4.Q0(RefreshState.PullUpToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.J0.isOpening && smartRefreshLayout5.H0(smartRefreshLayout5.C)) {
                        SmartRefreshLayout.this.Q0(RefreshState.PullDownCanceled);
                        o(RefreshState.None);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                        break;
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.H0(smartRefreshLayout6.D)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.J0.isOpening && (!smartRefreshLayout7.U || !smartRefreshLayout7.I || !smartRefreshLayout7.V)) {
                            smartRefreshLayout7.Q0(RefreshState.PullUpCanceled);
                            o(RefreshState.None);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.J0.isOpening && smartRefreshLayout8.H0(smartRefreshLayout8.C)) {
                        SmartRefreshLayout.this.Q0(RefreshState.ReleaseToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                        break;
                    }
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.H0(smartRefreshLayout9.D)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.J0;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.U || !smartRefreshLayout10.I || !smartRefreshLayout10.V)) {
                            smartRefreshLayout10.Q0(RefreshState.ReleaseToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.J0.isOpening && smartRefreshLayout11.H0(smartRefreshLayout11.C)) {
                        SmartRefreshLayout.this.Q0(RefreshState.ReleaseToTwoLevel);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                        break;
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.J0.isOpening && smartRefreshLayout12.H0(smartRefreshLayout12.C)) {
                        SmartRefreshLayout.this.Q0(RefreshState.RefreshReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                        break;
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.J0.isOpening && smartRefreshLayout13.H0(smartRefreshLayout13.D)) {
                        SmartRefreshLayout.this.Q0(RefreshState.LoadReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                        break;
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    break;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    break;
                default:
                    SmartRefreshLayout.this.Q0(refreshState);
                    break;
            }
            return null;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull sf.b bVar) {
        f16688b1 = bVar;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull sf.c cVar) {
        f16689c1 = cVar;
    }

    public static void setDefaultRefreshInitializer(@NonNull sf.d dVar) {
        f16690d1 = dVar;
    }

    @Override // pf.f
    public pf.f A(boolean z10) {
        this.G = z10;
        this.f16692a0 = true;
        return this;
    }

    @Override // pf.f
    public pf.f B(sf.h hVar) {
        this.f16697c0 = hVar;
        this.f16699d0 = hVar;
        this.D = this.D || !(this.W || hVar == null);
        return this;
    }

    @Override // pf.f
    public pf.f C(boolean z10) {
        this.M = z10;
        return this;
    }

    @Override // pf.f
    public pf.f D(@NonNull pf.c cVar, int i10, int i11) {
        pf.a aVar;
        pf.a aVar2 = this.E0;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.E0 = cVar;
        this.R0 = false;
        this.N0 = 0;
        this.V = false;
        this.P0 = false;
        this.f16721o0 = qf.a.f30051c;
        this.D = !this.W || this.D;
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -2;
        }
        LayoutParams layoutParams = new LayoutParams(i10, i11);
        ViewGroup.LayoutParams layoutParams2 = cVar.getView().getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        if (this.E0.getSpinnerStyle().f30073b) {
            super.addView(this.E0.getView(), getChildCount(), layoutParams);
        } else {
            super.addView(this.E0.getView(), 0, layoutParams);
        }
        int[] iArr = this.B;
        if (iArr != null && (aVar = this.E0) != null) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // pf.f
    public pf.f E(sf.g gVar) {
        this.f16697c0 = gVar;
        return this;
    }

    public ValueAnimator E0(int i10, int i11, Interpolator interpolator, int i12) {
        if (this.f16696c == i10) {
            return null;
        }
        ValueAnimator valueAnimator = this.f16693a1;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f16693a1.cancel();
            this.f16693a1 = null;
        }
        this.Z0 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f16696c, i10);
        this.f16693a1 = ofInt;
        ofInt.setDuration(i12);
        this.f16693a1.setInterpolator(interpolator);
        this.f16693a1.addListener(new c());
        this.f16693a1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: of.e
            public /* synthetic */ e() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SmartRefreshLayout.this.J0(valueAnimator2);
            }
        });
        this.f16693a1.setStartDelay(i11);
        this.f16693a1.start();
        return this.f16693a1;
    }

    @Override // pf.f
    public pf.f F(boolean z10) {
        this.E = z10;
        return this;
    }

    public void F0(float f10) {
        RefreshState refreshState;
        if (this.f16693a1 == null) {
            if (f10 > 0.0f && ((refreshState = this.J0) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.Z0 = new i(f10, this.f16715l0);
                return;
            }
            if (f10 < 0.0f && (this.J0 == RefreshState.Loading || ((this.I && this.U && this.V && H0(this.D)) || (this.M && !this.U && H0(this.D) && this.J0 != RefreshState.Refreshing)))) {
                this.Z0 = new i(f10, -this.f16719n0);
            } else if (this.f16696c == 0 && this.K) {
                this.Z0 = new i(f10, 0);
            }
        }
    }

    @Override // pf.f
    public pf.f G(boolean z10) {
        this.O = z10;
        return this;
    }

    public boolean G0(int i10) {
        if (i10 == 0) {
            if (this.f16693a1 != null) {
                RefreshState refreshState = this.J0;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.I0.o(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.I0.o(RefreshState.PullUpToLoad);
                }
                this.f16693a1.setDuration(0L);
                this.f16693a1.cancel();
                this.f16693a1 = null;
            }
            this.Z0 = null;
        }
        return this.f16693a1 != null;
    }

    @Override // pf.f
    public pf.f H(boolean z10) {
        this.F = z10;
        return this;
    }

    public boolean H0(boolean z10) {
        return z10 && !this.N;
    }

    @Override // pf.f
    public pf.f I(boolean z10) {
        this.I = z10;
        return this;
    }

    public boolean I0(boolean z10, @Nullable pf.a aVar) {
        return z10 || this.N || aVar == null || aVar.getSpinnerStyle() == qf.b.f30068f;
    }

    @Override // pf.f
    public pf.f J(float f10) {
        return w(uf.c.c(f10));
    }

    public final /* synthetic */ void J0(ValueAnimator valueAnimator) {
        this.I0.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
    }

    @Override // pf.f
    public pf.f K(int i10, boolean z10, Boolean bool) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        d dVar = new d(i11, bool, z10);
        if (i12 > 0) {
            this.H0.postDelayed(dVar, i12);
        } else {
            dVar.run();
        }
        return this;
    }

    public final /* synthetic */ void K0(ValueAnimator valueAnimator) {
        if (this.f16693a1 == null || this.E0 == null) {
            return;
        }
        this.I0.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
    }

    @Override // pf.f
    public boolean L() {
        return Z(0, this.f16704g, (this.f16729s0 + this.f16733u0) / 2.0f, false);
    }

    public final /* synthetic */ void L0(int i10, float f10, boolean z10) {
        if (this.K0 != RefreshState.Loading) {
            return;
        }
        ValueAnimator valueAnimator = this.f16693a1;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f16693a1.cancel();
            this.f16693a1 = null;
        }
        this.f16712k = getMeasuredWidth() / 2.0f;
        this.I0.o(RefreshState.PullUpToLoad);
        pf.a aVar = this.E0;
        if (aVar == null || !aVar.m(i10, f10, z10)) {
            int i11 = this.f16719n0;
            float f11 = i11 == 0 ? this.f16733u0 : i11;
            if (f10 < 10.0f) {
                f10 *= f11;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f16696c, -((int) f10));
            this.f16693a1 = ofInt;
            ofInt.setDuration(i10);
            this.f16693a1.setInterpolator(new uf.c(uf.c.f31055b));
            this.f16693a1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: of.d
                public /* synthetic */ d() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    SmartRefreshLayout.this.K0(valueAnimator2);
                }
            });
            this.f16693a1.addListener(new g(z10));
            this.f16693a1.start();
        }
    }

    @Override // pf.f
    public pf.f M(boolean z10) {
        this.P = z10;
        return this;
    }

    public final /* synthetic */ void M0(ValueAnimator valueAnimator) {
        if (this.f16693a1 == null || this.D0 == null) {
            return;
        }
        this.I0.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
    }

    @Override // pf.f
    public pf.f N(boolean z10) {
        this.W = true;
        this.D = z10;
        return this;
    }

    public final /* synthetic */ void N0(int i10, float f10, boolean z10) {
        if (this.K0 != RefreshState.Refreshing) {
            return;
        }
        ValueAnimator valueAnimator = this.f16693a1;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f16693a1.cancel();
            this.f16693a1 = null;
        }
        this.f16712k = getMeasuredWidth() / 2.0f;
        this.I0.o(RefreshState.PullDownToRefresh);
        pf.a aVar = this.D0;
        if (aVar == null || !aVar.m(i10, f10, z10)) {
            int i11 = this.f16715l0;
            float f11 = i11 == 0 ? this.f16731t0 : i11;
            if (f10 < 10.0f) {
                f10 *= f11;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f16696c, (int) f10);
            this.f16693a1 = ofInt;
            ofInt.setDuration(i10);
            this.f16693a1.setInterpolator(new uf.c(uf.c.f31055b));
            this.f16693a1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: of.b
                public /* synthetic */ b() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    SmartRefreshLayout.this.M0(valueAnimator2);
                }
            });
            this.f16693a1.addListener(new f(z10));
            this.f16693a1.start();
        }
    }

    @Override // pf.f
    public pf.f O(@NonNull pf.d dVar) {
        return r0(dVar, 0, 0);
    }

    public final /* synthetic */ void O0() {
        sf.e eVar = this.f16699d0;
        if (eVar != null) {
            eVar.p(this);
        } else if (this.f16701e0 == null) {
            y(2000);
        }
        sf.f fVar = this.f16701e0;
        if (fVar != null) {
            fVar.p(this);
        }
    }

    @Override // pf.f
    public pf.f P(boolean z10) {
        setNestedScrollingEnabled(z10);
        return this;
    }

    public void P0(float f10) {
        RefreshState refreshState;
        float f11 = (!this.f16707h0 || this.Q || f10 >= 0.0f || this.F0.i()) ? f10 : 0.0f;
        if (f11 > this.f16706h * 5 && getTag() == null && getTag(R.id.srl_tag) == null) {
            float f12 = this.f16714l;
            int i10 = this.f16706h;
            if (f12 < i10 / 6.0f && this.f16712k < i10 / 16.0f) {
                Toast.makeText(getContext(), "不要再拉了，臣妾做不到啊！", 0).show();
                setTag(R.id.srl_tag, "不要再拉了，臣妾做不到啊！");
            }
        }
        RefreshState refreshState2 = this.J0;
        if (refreshState2 == RefreshState.TwoLevel && f11 > 0.0f) {
            this.I0.i(Math.min((int) f11, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f11 >= 0.0f) {
            int i11 = this.f16715l0;
            if (f11 < i11) {
                this.I0.i((int) f11, true);
            } else {
                float f13 = this.f16727r0;
                if (f13 < 10.0f) {
                    f13 *= i11;
                }
                double d10 = f13 - i11;
                double max = Math.max((this.f16706h * 4) / 3, getHeight()) - this.f16715l0;
                double d11 = -Math.max(0.0f, (f11 - r5) * this.f16716m);
                if (max == l5.c.f27899e) {
                    max = 1.0d;
                }
                this.I0.i(((int) (d10 * (1.0d - Math.pow(100.0d, d11 / max)))) + this.f16715l0, true);
            }
        } else if (f11 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.I && this.U && this.V && H0(this.D)) || (this.M && !this.U && H0(this.D))))) {
            int i12 = this.f16719n0;
            if (f11 > (-i12)) {
                this.I0.i((int) f11, true);
            } else {
                float f14 = this.f16729s0;
                if (f14 < 10.0f) {
                    f14 *= i12;
                }
                double max2 = Math.max((this.f16706h * 4) / 3, getHeight()) - this.f16719n0;
                double d12 = -(f14 - i12);
                double d13 = -(-Math.min(0.0f, (r11 + f11) * this.f16716m));
                if (max2 == l5.c.f27899e) {
                    max2 = 1.0d;
                }
                this.I0.i(((int) (d12 * (1.0d - Math.pow(100.0d, d13 / max2)))) - this.f16719n0, true);
            }
        } else if (f11 >= 0.0f) {
            float f15 = this.f16727r0;
            double d14 = f15 < 10.0f ? this.f16715l0 * f15 : f15;
            double max3 = Math.max(this.f16706h / 2, getHeight());
            double d15 = -Math.max(0.0f, this.f16716m * f11);
            if (max3 == l5.c.f27899e) {
                max3 = 1.0d;
            }
            this.I0.i((int) (d14 * (1.0d - Math.pow(100.0d, d15 / max3))), true);
        } else {
            float f16 = this.f16729s0;
            double d16 = f16 < 10.0f ? this.f16719n0 * f16 : f16;
            double max4 = Math.max(this.f16706h / 2, getHeight());
            this.I0.i((int) ((-d16) * (1.0d - Math.pow(100.0d, (-(-Math.min(0.0f, this.f16716m * f11))) / (max4 == l5.c.f27899e ? 1.0d : max4)))), true);
        }
        if (!this.M || this.U || !H0(this.D) || f11 >= 0.0f || (refreshState = this.J0) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        if (this.T) {
            this.Z0 = null;
            this.I0.e(-this.f16719n0);
        }
        setStateDirectLoading(false);
        this.H0.postDelayed(new Runnable() { // from class: of.f
            public /* synthetic */ f() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SmartRefreshLayout.this.O0();
            }
        }, this.f16704g);
    }

    @Override // pf.f
    public boolean Q(int i10) {
        return q(i10, this.f16704g, (this.f16727r0 + this.f16731t0) / 2.0f, false);
    }

    public void Q0(RefreshState refreshState) {
        RefreshState refreshState2 = this.J0;
        if (refreshState2 == refreshState) {
            if (this.K0 != refreshState2) {
                this.K0 = refreshState2;
                return;
            }
            return;
        }
        this.J0 = refreshState;
        this.K0 = refreshState;
        pf.a aVar = this.D0;
        pf.a aVar2 = this.E0;
        sf.f fVar = this.f16701e0;
        if (aVar != null) {
            aVar.c(this, refreshState2, refreshState);
        }
        if (aVar2 != null) {
            aVar2.c(this, refreshState2, refreshState);
        }
        if (fVar != null) {
            fVar.c(this, refreshState2, refreshState);
        }
        if (refreshState == RefreshState.LoadFinish) {
            this.R0 = false;
        }
    }

    @Override // pf.f
    public pf.f R(boolean z10) {
        this.K = z10;
        return this;
    }

    public void R0() {
        RefreshState refreshState = this.J0;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.f16736x <= -1000 || this.f16696c <= getHeight() / 2) {
                if (this.f16720o) {
                    this.I0.d();
                    return;
                }
                return;
            } else {
                ValueAnimator e10 = this.I0.e(getHeight());
                if (e10 != null) {
                    e10.setDuration(this.f16702f);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState == refreshState2 || (this.I && this.U && this.V && this.f16696c < 0 && H0(this.D))) {
            int i10 = this.f16696c;
            int i11 = this.f16719n0;
            if (i10 < (-i11)) {
                this.I0.e(-i11);
                return;
            } else {
                if (i10 > 0) {
                    this.I0.e(0);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState3 = this.J0;
        RefreshState refreshState4 = RefreshState.Refreshing;
        if (refreshState3 == refreshState4) {
            int i12 = this.f16696c;
            int i13 = this.f16715l0;
            if (i12 > i13) {
                this.I0.e(i13);
                return;
            } else {
                if (i12 < 0) {
                    this.I0.e(0);
                    return;
                }
                return;
            }
        }
        if (refreshState3 == RefreshState.PullDownToRefresh) {
            this.I0.o(RefreshState.PullDownCanceled);
            return;
        }
        if (refreshState3 == RefreshState.PullUpToLoad) {
            this.I0.o(RefreshState.PullUpCanceled);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToRefresh) {
            this.I0.o(refreshState4);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToLoad) {
            this.I0.o(refreshState2);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
            this.I0.o(RefreshState.TwoLevelReleased);
            return;
        }
        if (refreshState3 == RefreshState.RefreshReleased) {
            if (this.f16693a1 == null) {
                this.I0.e(this.f16715l0);
            }
        } else if (refreshState3 == RefreshState.LoadReleased) {
            if (this.f16693a1 == null) {
                this.I0.e(-this.f16719n0);
            }
        } else if (refreshState3 == RefreshState.LoadFinish) {
            Log.d("SmartRefreshLayout", "overSpinner 时 LoadFinish 状态无任何操作即可");
        } else if (this.f16696c != 0) {
            this.I0.e(0);
        }
    }

    @Override // pf.f
    public pf.f S() {
        return o(true);
    }

    public int S0(float f10) {
        double d10;
        float f11;
        double log;
        float f12;
        double d11;
        RefreshState refreshState = this.J0;
        if (refreshState != RefreshState.TwoLevel || f10 <= 0.0f) {
            if (refreshState != RefreshState.Refreshing || f10 < 0.0f) {
                if (f10 < 0.0f && (refreshState == RefreshState.Loading || ((this.I && this.U && this.V && H0(this.D)) || (this.M && !this.U && H0(this.D))))) {
                    int i10 = this.f16719n0;
                    if (f10 <= (-i10)) {
                        float f13 = this.f16729s0;
                        if (f13 < 10.0f) {
                            f13 *= i10;
                        }
                        d10 = -(((-(Math.max((this.f16706h * 4) / 3, getHeight()) - this.f16719n0)) * (Math.log(1.0d - ((-f10) / (f13 - i10))) / Math.log(100.0d))) - this.f16719n0);
                        f11 = this.f16716m;
                    }
                } else if (f10 >= 0.0f) {
                    float f14 = this.f16727r0;
                    log = (-Math.max(this.f16706h / 2, getHeight())) * (Math.log(1.0d - ((f10 * 1.0f) / (f14 < 10.0f ? this.f16715l0 * f14 : f14))) / Math.log(100.0d));
                    f12 = this.f16716m;
                    d11 = log / f12;
                } else {
                    float f15 = this.f16729s0;
                    d10 = -(((-Math.max(this.f16706h / 2, getHeight())) * (Math.log(1.0d - ((-f10) / (f15 < 10.0f ? this.f16719n0 * f15 : f15))) / Math.log(100.0d))) - this.f16719n0);
                    f11 = this.f16716m;
                }
                d11 = d10 / f11;
            } else {
                int i11 = this.f16715l0;
                if (f10 >= i11) {
                    float f16 = this.f16727r0;
                    if (f16 < 10.0f) {
                        f16 *= i11;
                    }
                    log = ((-(Math.max((this.f16706h * 4) / 3, getHeight()) - this.f16715l0)) * (Math.log(1.0d - ((f10 * 1.0f) / (f16 - i11))) / Math.log(100.0d))) + this.f16715l0;
                    f12 = this.f16716m;
                    d11 = log / f12;
                }
            }
            return Math.round((float) d11);
        }
        d11 = f10;
        return Math.round((float) d11);
    }

    @Override // pf.f
    public pf.f T(int i10) {
        this.f16732u = i10;
        return this;
    }

    public boolean T0(float f10) {
        if (f10 == 0.0f) {
            f10 = this.f16736x;
        }
        if (Math.abs(f10) > this.f16734v) {
            int i10 = this.f16696c;
            if (i10 * f10 < 0.0f) {
                RefreshState refreshState = this.J0;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i10 < 0 && this.U)) {
                    this.Z0 = new j(f10).a();
                    return true;
                }
                if (refreshState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f10 < 0.0f && ((this.K && (this.D || this.L)) || ((this.J0 == RefreshState.Loading && i10 >= 0) || (this.M && H0(this.D))))) || (f10 > 0.0f && ((this.K && this.C) || this.L || (this.J0 == RefreshState.Refreshing && this.f16696c <= 0)))) {
                this.V0 = false;
                this.f16737y.fling(0, 0, 0, (int) (-f10), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.f16737y.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    @Override // pf.f
    public pf.f U(@NonNull pf.c cVar) {
        return D(cVar, 0, 0);
    }

    @Override // pf.f
    public pf.f V() {
        RefreshState refreshState;
        RefreshState refreshState2 = this.J0;
        RefreshState refreshState3 = RefreshState.None;
        if (refreshState2 == refreshState3 && ((refreshState = this.K0) == RefreshState.Refreshing || refreshState == RefreshState.Loading)) {
            this.K0 = refreshState3;
        }
        if (refreshState2 == RefreshState.Refreshing) {
            p();
        } else if (refreshState2 == RefreshState.Loading) {
            S();
        } else if (this.I0.e(0) == null) {
            Q0(refreshState3);
        } else if (this.J0.isHeader) {
            Q0(RefreshState.PullDownCanceled);
        } else {
            Q0(RefreshState.PullUpCanceled);
        }
        return this;
    }

    @Override // pf.f
    public pf.f W(boolean z10) {
        return z10 ? K(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.L0))), 300) << 16, true, Boolean.FALSE) : K(0, false, null);
    }

    @Override // pf.f
    public pf.f X(int i10) {
        this.f16725q0 = i10;
        return this;
    }

    @Override // pf.f
    public pf.f Y(float f10) {
        this.f16729s0 = f10;
        pf.a aVar = this.E0;
        if (aVar == null || !this.Q0) {
            this.f16721o0 = this.f16721o0.c();
        } else {
            if (f10 < 10.0f) {
                f10 *= this.f16719n0;
            }
            aVar.d(this.I0, this.f16719n0, (int) f10);
        }
        return this;
    }

    @Override // pf.f
    public boolean Z(int i10, int i11, float f10, boolean z10) {
        if (this.J0 != RefreshState.None || !H0(this.D) || this.U) {
            return false;
        }
        of.c cVar = new Runnable() { // from class: of.c

            /* renamed from: c */
            public final /* synthetic */ int f29176c;

            /* renamed from: d */
            public final /* synthetic */ float f29177d;

            /* renamed from: e */
            public final /* synthetic */ boolean f29178e;

            public /* synthetic */ c(int i112, float f102, boolean z102) {
                i11 = i112;
                f10 = f102;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SmartRefreshLayout.this.L0(i11, f10, z10);
            }
        };
        setViceState(RefreshState.Loading);
        if (i10 > 0) {
            this.H0.postDelayed(cVar, i10);
            return true;
        }
        cVar.run();
        return true;
    }

    @Override // pf.f
    public pf.f a(boolean z10) {
        RefreshState refreshState = this.J0;
        if (refreshState == RefreshState.Refreshing && z10) {
            k0();
        } else if (refreshState == RefreshState.Loading && z10) {
            e0();
        } else if (this.U != z10) {
            this.U = z10;
            pf.a aVar = this.E0;
            if (aVar instanceof pf.c) {
                if (((pf.c) aVar).a(z10)) {
                    this.V = true;
                    if (this.U && this.I && this.f16696c > 0 && this.E0.getSpinnerStyle() == qf.b.f30066d && H0(this.D) && I0(this.C, this.D0)) {
                        this.E0.getView().setTranslationY(this.f16696c);
                    }
                } else {
                    this.V = false;
                    new RuntimeException("Footer:" + this.E0 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    @Override // pf.f
    public boolean a0() {
        return this.J0 == RefreshState.Refreshing;
    }

    @Override // pf.f
    public pf.f b(boolean z10) {
        this.Q = z10;
        pf.b bVar = this.F0;
        if (bVar != null) {
            bVar.b(z10);
        }
        return this;
    }

    @Override // pf.f
    public pf.f b0(int i10) {
        this.f16704g = i10;
        return this;
    }

    @Override // pf.f
    public pf.f c(sf.j jVar) {
        this.f16703f0 = jVar;
        pf.b bVar = this.F0;
        if (bVar != null) {
            bVar.c(jVar);
        }
        return this;
    }

    @Override // pf.f
    public pf.f c0(int i10) {
        return K(i10, true, Boolean.FALSE);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f16737y.getCurrY();
        if (this.f16737y.computeScrollOffset()) {
            int finalY = this.f16737y.getFinalY();
            if ((finalY >= 0 || !((this.C || this.L) && this.F0.a())) && (finalY <= 0 || !((this.D || this.L) && this.F0.i()))) {
                this.V0 = true;
                invalidate();
            } else {
                if (this.V0) {
                    F0(finalY > 0 ? -this.f16737y.getCurrVelocity() : this.f16737y.getCurrVelocity());
                }
                this.f16737y.forceFinished(true);
            }
        }
    }

    @Override // pf.f
    public boolean d() {
        return Z(0, this.f16704g, (this.f16729s0 + this.f16733u0) / 2.0f, true);
    }

    @Override // pf.f
    public pf.f d0(@NonNull View view, int i10, int i11) {
        pf.b bVar = this.F0;
        if (bVar != null) {
            super.removeView(bVar.getView());
        }
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -1;
        }
        LayoutParams layoutParams = new LayoutParams(i10, i11);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        super.addView(view, getChildCount(), layoutParams);
        this.F0 = new vf.a(view);
        if (this.Q0) {
            View findViewById = findViewById(this.f16726r);
            View findViewById2 = findViewById(this.f16728s);
            this.F0.c(this.f16703f0);
            this.F0.b(this.Q);
            this.F0.e(this.I0, findViewById, findViewById2);
        }
        pf.a aVar = this.D0;
        if (aVar != null && aVar.getSpinnerStyle().f30073b) {
            super.bringChildToFront(this.D0.getView());
        }
        pf.a aVar2 = this.E0;
        if (aVar2 != null && aVar2.getSpinnerStyle().f30073b) {
            super.bringChildToFront(this.E0.getView());
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0150, code lost:
    
        if (r6 != 3) goto L789;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d2, code lost:
    
        if (r2.isFinishing == false) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
    
        if (r2.isHeader == false) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e4, code lost:
    
        if (r2.isFinishing == false) goto L619;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e8, code lost:
    
        if (r2.isFooter == false) goto L619;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 952
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@NonNull Canvas canvas, View view, long j10) {
        Paint paint;
        Paint paint2;
        pf.b bVar = this.F0;
        View view2 = bVar != null ? bVar.getView() : null;
        pf.a aVar = this.D0;
        if (aVar != null && aVar.getView() == view) {
            if (!H0(this.C) || (!this.J && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.f16696c, view.getTop());
                int i10 = this.M0;
                if (i10 != 0 && (paint2 = this.G0) != null) {
                    paint2.setColor(i10);
                    if (this.D0.getSpinnerStyle().f30074c) {
                        max = view.getBottom();
                    } else if (this.D0.getSpinnerStyle() == qf.b.f30066d) {
                        max = view.getBottom() + this.f16696c;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), max, this.G0);
                }
                if ((this.E && this.D0.getSpinnerStyle() == qf.b.f30068f) || this.D0.getSpinnerStyle().f30074c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        pf.a aVar2 = this.E0;
        if (aVar2 != null && aVar2.getView() == view) {
            if (!H0(this.D) || (!this.J && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f16696c, view.getBottom());
                int i11 = this.N0;
                if (i11 != 0 && (paint = this.G0) != null) {
                    paint.setColor(i11);
                    if (this.E0.getSpinnerStyle().f30074c) {
                        min = view.getTop();
                    } else if (this.E0.getSpinnerStyle() == qf.b.f30066d) {
                        min = view.getTop() + this.f16696c;
                    }
                    canvas.drawRect(0.0f, min, getWidth(), view.getBottom(), this.G0);
                }
                if ((this.F && this.E0.getSpinnerStyle() == qf.b.f30068f) || this.E0.getSpinnerStyle().f30074c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // pf.f
    public pf.f e(boolean z10) {
        this.S = z10;
        return this;
    }

    @Override // pf.f
    public pf.f e0() {
        return l0(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.L0))), 300) << 16, true, true);
    }

    @Override // pf.f
    public pf.f f(@NonNull View view) {
        return d0(view, 0, 0);
    }

    @Override // pf.f
    public pf.f f0(sf.e eVar) {
        this.f16699d0 = eVar;
        this.D = this.D || !(this.W || eVar == null);
        return this;
    }

    @Override // pf.f
    public pf.f g(float f10) {
        this.f16733u0 = f10;
        return this;
    }

    @Override // pf.f
    public pf.f g0(float f10) {
        this.f16727r0 = f10;
        pf.a aVar = this.D0;
        if (aVar == null || !this.Q0) {
            this.f16717m0 = this.f16717m0.c();
        } else {
            if (f10 < 10.0f) {
                f10 *= this.f16715l0;
            }
            aVar.d(this.I0, this.f16715l0, (int) f10);
        }
        return this;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // pf.f
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f16713k0.getNestedScrollAxes();
    }

    @Override // pf.f
    @Nullable
    public pf.c getRefreshFooter() {
        pf.a aVar = this.E0;
        if (aVar instanceof pf.c) {
            return (pf.c) aVar;
        }
        return null;
    }

    @Override // pf.f
    @Nullable
    public pf.d getRefreshHeader() {
        pf.a aVar = this.D0;
        if (aVar instanceof pf.d) {
            return (pf.d) aVar;
        }
        return null;
    }

    @Override // pf.f
    @NonNull
    public RefreshState getState() {
        return this.J0;
    }

    @Override // pf.f
    public boolean h(int i10) {
        return Z(i10, this.f16704g, (this.f16729s0 + this.f16733u0) / 2.0f, false);
    }

    @Override // pf.f
    public pf.f h0(sf.f fVar) {
        this.f16701e0 = fVar;
        return this;
    }

    @Override // pf.f
    public pf.f i(boolean z10) {
        this.H = z10;
        this.f16695b0 = true;
        return this;
    }

    @Override // pf.f
    public boolean i0() {
        return q(this.Q0 ? 0 : 400, this.f16704g, (this.f16727r0 + this.f16731t0) / 2.0f, false);
    }

    @Override // pf.f
    public boolean isLoading() {
        return this.J0 == RefreshState.Loading;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.R && (this.L || this.C || this.D);
    }

    @Override // pf.f
    public pf.f j(float f10) {
        return m(uf.c.c(f10));
    }

    @Override // pf.f
    public pf.f j0(boolean z10) {
        this.C = z10;
        return this;
    }

    @Override // pf.f
    public pf.f k(int i10) {
        this.f16726r = i10;
        return this;
    }

    @Override // pf.f
    public pf.f k0() {
        return K(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.L0))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // pf.f
    public pf.f l(boolean z10) {
        this.L = z10;
        return this;
    }

    @Override // pf.f
    public pf.f l0(int i10, boolean z10, boolean z11) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        e eVar = new e(i11, z11, z10);
        if (i12 > 0) {
            this.H0.postDelayed(eVar, i12);
        } else {
            eVar.run();
        }
        return this;
    }

    @Override // pf.f
    public pf.f m(int i10) {
        if (i10 == this.f16719n0) {
            return this;
        }
        qf.a aVar = this.f16721o0;
        qf.a aVar2 = qf.a.f30060l;
        if (aVar.a(aVar2)) {
            this.f16719n0 = i10;
            pf.a aVar3 = this.E0;
            if (aVar3 != null && this.Q0 && this.f16721o0.f30065b) {
                qf.b spinnerStyle = aVar3.getSpinnerStyle();
                if (spinnerStyle != qf.b.f30070h && !spinnerStyle.f30074c) {
                    View view = this.E0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f16691e1;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f16719n0 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i11 = marginLayoutParams.leftMargin;
                    int measuredHeight = ((marginLayoutParams.topMargin + getMeasuredHeight()) - this.f16725q0) - (spinnerStyle != qf.b.f30066d ? this.f16719n0 : 0);
                    view.layout(i11, measuredHeight, view.getMeasuredWidth() + i11, view.getMeasuredHeight() + measuredHeight);
                }
                float f10 = this.f16729s0;
                if (f10 < 10.0f) {
                    f10 *= this.f16719n0;
                }
                this.f16721o0 = aVar2;
                this.E0.d(this.I0, this.f16719n0, (int) f10);
            } else {
                this.f16721o0 = qf.a.f30059k;
            }
        }
        return this;
    }

    @Override // pf.f
    public pf.f m0(@NonNull Interpolator interpolator) {
        this.A = interpolator;
        return this;
    }

    @Override // pf.f
    public pf.f n() {
        return a(false);
    }

    @Override // pf.f
    public pf.f n0(boolean z10) {
        this.T = z10;
        return this;
    }

    @Override // pf.f
    public pf.f o(boolean z10) {
        return l0(z10 ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.L0))), 300) << 16 : 0, z10, false);
    }

    @Override // pf.f
    public pf.f o0(float f10) {
        this.f16716m = f10;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        pf.a aVar;
        sf.c cVar;
        super.onAttachedToWindow();
        boolean z10 = true;
        this.Q0 = true;
        if (!isInEditMode()) {
            if (this.D0 == null && (cVar = f16689c1) != null) {
                pf.d a10 = cVar.a(getContext(), this);
                if (a10 == null) {
                    throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                }
                O(a10);
            }
            if (this.E0 == null) {
                sf.b bVar = f16688b1;
                if (bVar != null) {
                    pf.c a11 = bVar.a(getContext(), this);
                    if (a11 == null) {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                    U(a11);
                }
            } else {
                if (!this.D && this.W) {
                    z10 = false;
                }
                this.D = z10;
            }
            if (this.F0 == null) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    pf.a aVar2 = this.D0;
                    if ((aVar2 == null || childAt != aVar2.getView()) && ((aVar = this.E0) == null || childAt != aVar.getView())) {
                        this.F0 = new vf.a(childAt);
                    }
                }
            }
            if (this.F0 == null) {
                int c10 = uf.c.c(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                vf.a aVar3 = new vf.a(textView);
                this.F0 = aVar3;
                aVar3.getView().setPadding(c10, c10, c10, c10);
            }
            View findViewById = findViewById(this.f16726r);
            View findViewById2 = findViewById(this.f16728s);
            this.F0.c(this.f16703f0);
            this.F0.b(this.Q);
            this.F0.e(this.I0, findViewById, findViewById2);
            if (this.f16696c != 0) {
                Q0(RefreshState.None);
                pf.b bVar2 = this.F0;
                this.f16696c = 0;
                bVar2.h(0, this.f16730t, this.f16732u);
            }
        }
        int[] iArr = this.B;
        if (iArr != null) {
            pf.a aVar4 = this.D0;
            if (aVar4 != null) {
                aVar4.setPrimaryColors(iArr);
            }
            pf.a aVar5 = this.E0;
            if (aVar5 != null) {
                aVar5.setPrimaryColors(this.B);
            }
        }
        pf.b bVar3 = this.F0;
        if (bVar3 != null) {
            super.bringChildToFront(bVar3.getView());
        }
        pf.a aVar6 = this.D0;
        if (aVar6 != null && aVar6.getSpinnerStyle().f30073b) {
            super.bringChildToFront(this.D0.getView());
        }
        pf.a aVar7 = this.E0;
        if (aVar7 == null || !aVar7.getSpinnerStyle().f30073b) {
            return;
        }
        super.bringChildToFront(this.E0.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Q0 = false;
        this.W = true;
        this.Z0 = null;
        ValueAnimator valueAnimator = this.f16693a1;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f16693a1.removeAllUpdateListeners();
            this.f16693a1.setDuration(0L);
            this.f16693a1.cancel();
            this.f16693a1 = null;
        }
        pf.a aVar = this.D0;
        if (aVar != null && this.J0 == RefreshState.Refreshing) {
            aVar.o(this, false);
        }
        pf.a aVar2 = this.E0;
        if (aVar2 != null && this.J0 == RefreshState.Loading) {
            aVar2.o(this, false);
        }
        if (this.f16696c != 0) {
            this.I0.i(0, true);
        }
        RefreshState refreshState = this.J0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            Q0(refreshState2);
        }
        Handler handler = this.H0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.R0 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = super.getChildCount()
            r1 = 3
            if (r0 > r1) goto L9f
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = 0
        Lf:
            r7 = 2
            r8 = 1
            if (r4 >= r0) goto L33
            android.view.View r9 = super.getChildAt(r4)
            boolean r10 = uf.c.e(r9)
            if (r10 == 0) goto L24
            if (r6 < r7) goto L21
            if (r4 != r8) goto L24
        L21:
            r5 = r4
            r6 = 2
            goto L30
        L24:
            boolean r7 = r9 instanceof pf.a
            if (r7 != 0) goto L30
            if (r6 >= r8) goto L30
            if (r4 <= 0) goto L2e
            r6 = 1
            goto L2f
        L2e:
            r6 = 0
        L2f:
            r5 = r4
        L30:
            int r4 = r4 + 1
            goto Lf
        L33:
            if (r5 < 0) goto L4e
            vf.a r4 = new vf.a
            android.view.View r6 = super.getChildAt(r5)
            r4.<init>(r6)
            r11.F0 = r4
            if (r5 != r8) goto L49
            if (r0 != r1) goto L46
            r1 = 0
            goto L50
        L46:
            r1 = 0
        L47:
            r7 = -1
            goto L50
        L49:
            if (r0 != r7) goto L4e
            r1 = -1
            r7 = 1
            goto L50
        L4e:
            r1 = -1
            goto L47
        L50:
            r4 = 0
        L51:
            if (r4 >= r0) goto L9e
            android.view.View r5 = super.getChildAt(r4)
            if (r4 == r1) goto L8c
            if (r4 == r7) goto L66
            if (r1 != r2) goto L66
            pf.a r6 = r11.D0
            if (r6 != 0) goto L66
            boolean r6 = r5 instanceof pf.d
            if (r6 == 0) goto L66
            goto L8c
        L66:
            if (r4 == r7) goto L6e
            if (r7 != r2) goto L9b
            boolean r6 = r5 instanceof pf.c
            if (r6 == 0) goto L9b
        L6e:
            boolean r6 = r11.D
            if (r6 != 0) goto L79
            boolean r6 = r11.W
            if (r6 != 0) goto L77
            goto L79
        L77:
            r6 = 0
            goto L7a
        L79:
            r6 = 1
        L7a:
            r11.D = r6
            boolean r6 = r5 instanceof pf.c
            if (r6 == 0) goto L83
            pf.c r5 = (pf.c) r5
            goto L89
        L83:
            vf.b r6 = new vf.b
            r6.<init>(r5)
            r5 = r6
        L89:
            r11.E0 = r5
            goto L9b
        L8c:
            boolean r6 = r5 instanceof pf.d
            if (r6 == 0) goto L93
            pf.d r5 = (pf.d) r5
            goto L99
        L93:
            vf.c r6 = new vf.c
            r6.<init>(r5)
            r5 = r6
        L99:
            r11.D0 = r5
        L9b:
            int r4 = r4 + 1
            goto L51
        L9e:
            return
        L9f:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = super.getChildAt(i15);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(R.id.srl_tag))) {
                pf.b bVar = this.F0;
                if (bVar != null && bVar.getView() == childAt) {
                    boolean z11 = isInEditMode() && this.J && H0(this.C) && this.D0 != null;
                    View view = this.F0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f16691e1;
                    int i16 = marginLayoutParams.leftMargin + paddingLeft;
                    int i17 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i16;
                    int measuredHeight = view.getMeasuredHeight() + i17;
                    if (z11 && I0(this.G, this.D0)) {
                        int i18 = this.f16715l0;
                        i17 += i18;
                        measuredHeight += i18;
                    }
                    view.layout(i16, i17, measuredWidth, measuredHeight);
                }
                pf.a aVar = this.D0;
                if (aVar != null && aVar.getView() == childAt) {
                    boolean z12 = isInEditMode() && this.J && H0(this.C);
                    View view2 = this.D0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : f16691e1;
                    int i19 = marginLayoutParams2.leftMargin;
                    int i20 = marginLayoutParams2.topMargin + this.f16723p0;
                    int measuredWidth2 = view2.getMeasuredWidth() + i19;
                    int measuredHeight2 = view2.getMeasuredHeight() + i20;
                    if (!z12 && this.D0.getSpinnerStyle() == qf.b.f30066d) {
                        int i21 = this.f16715l0;
                        i20 -= i21;
                        measuredHeight2 -= i21;
                    }
                    view2.layout(i19, i20, measuredWidth2, measuredHeight2);
                }
                pf.a aVar2 = this.E0;
                if (aVar2 != null && aVar2.getView() == childAt) {
                    boolean z13 = isInEditMode() && this.J && H0(this.D);
                    View view3 = this.E0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : f16691e1;
                    qf.b spinnerStyle = this.E0.getSpinnerStyle();
                    int i22 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.f16725q0;
                    if (this.U && this.V && this.I && this.F0 != null && this.E0.getSpinnerStyle() == qf.b.f30066d && H0(this.D)) {
                        View view4 = this.F0.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == qf.b.f30070h) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.f16725q0;
                    } else {
                        if (z13 || spinnerStyle == qf.b.f30069g || spinnerStyle == qf.b.f30068f) {
                            i14 = this.f16719n0;
                        } else if (spinnerStyle.f30074c && this.f16696c < 0) {
                            i14 = Math.max(H0(this.D) ? -this.f16696c : 0, 0);
                        }
                        measuredHeight3 -= i14;
                    }
                    view3.layout(i22, measuredHeight3, view3.getMeasuredWidth() + i22, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0264  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 861
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f10, float f11, boolean z10) {
        return this.f16711j0.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f10, float f11) {
        return (this.R0 && f11 > 0.0f) || T0(-f11) || this.f16711j0.dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr) {
        int i12 = this.f16705g0;
        int i13 = 0;
        if (i11 * i12 > 0) {
            if (Math.abs(i11) > Math.abs(this.f16705g0)) {
                int i14 = this.f16705g0;
                this.f16705g0 = 0;
                i13 = i14;
            } else {
                this.f16705g0 -= i11;
                i13 = i11;
            }
            P0(this.f16705g0);
        } else if (i11 > 0 && this.R0) {
            int i15 = i12 - i11;
            this.f16705g0 = i15;
            P0(i15);
            i13 = i11;
        }
        this.f16711j0.dispatchNestedPreScroll(i10, i11 - i13, iArr, null);
        iArr[1] = iArr[1] + i13;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13) {
        sf.j jVar;
        ViewParent parent;
        sf.j jVar2;
        boolean dispatchNestedScroll = this.f16711j0.dispatchNestedScroll(i10, i11, i12, i13, this.f16709i0);
        int i14 = i13 + this.f16709i0[1];
        if ((i14 < 0 && ((this.C || this.L) && (this.f16705g0 != 0 || (jVar2 = this.f16703f0) == null || jVar2.a(this.F0.getView())))) || (i14 > 0 && ((this.D || this.L) && (this.f16705g0 != 0 || (jVar = this.f16703f0) == null || jVar.b(this.F0.getView()))))) {
            RefreshState refreshState = this.K0;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.I0.o(i14 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!dispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i15 = this.f16705g0 - i14;
            this.f16705g0 = i15;
            P0(i15);
        }
        if (!this.R0 || i11 >= 0) {
            return;
        }
        this.R0 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10) {
        this.f16713k0.onNestedScrollAccepted(view, view2, i10);
        this.f16711j0.startNestedScroll(i10 & 2);
        this.f16705g0 = S0(this.f16696c);
        this.f16707h0 = true;
        G0(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10) {
        return isEnabled() && isNestedScrollingEnabled() && (i10 & 2) != 0 && (this.L || this.C || this.D);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.f16713k0.onStopNestedScroll(view);
        this.f16707h0 = false;
        this.f16705g0 = 0;
        R0();
        this.f16711j0.stopNestedScroll();
    }

    @Override // pf.f
    public pf.f p() {
        return W(true);
    }

    @Override // pf.f
    public pf.f p0(int i10) {
        this.f16723p0 = i10;
        return this;
    }

    @Override // pf.f
    public boolean q(int i10, int i11, float f10, boolean z10) {
        if (this.J0 != RefreshState.None || !H0(this.C)) {
            return false;
        }
        of.a aVar = new Runnable() { // from class: of.a

            /* renamed from: c */
            public final /* synthetic */ int f29171c;

            /* renamed from: d */
            public final /* synthetic */ float f29172d;

            /* renamed from: e */
            public final /* synthetic */ boolean f29173e;

            public /* synthetic */ a(int i112, float f102, boolean z102) {
                i11 = i112;
                f10 = f102;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SmartRefreshLayout.this.N0(i11, f10, z10);
            }
        };
        setViceState(RefreshState.Refreshing);
        if (i10 > 0) {
            this.H0.postDelayed(aVar, i10);
            return true;
        }
        aVar.run();
        return true;
    }

    @Override // pf.f
    public pf.f q0(int i10) {
        this.f16730t = i10;
        return this;
    }

    @Override // pf.f
    public pf.f r(float f10) {
        this.f16725q0 = uf.c.c(f10);
        return this;
    }

    @Override // pf.f
    public pf.f r0(@NonNull pf.d dVar, int i10, int i11) {
        pf.a aVar;
        pf.a aVar2 = this.D0;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.D0 = dVar;
        this.M0 = 0;
        this.O0 = false;
        this.f16717m0 = qf.a.f30051c;
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -2;
        }
        LayoutParams layoutParams = new LayoutParams(i10, i11);
        ViewGroup.LayoutParams layoutParams2 = dVar.getView().getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        if (this.D0.getSpinnerStyle().f30073b) {
            super.addView(this.D0.getView(), getChildCount(), layoutParams);
        } else {
            super.addView(this.D0.getView(), 0, layoutParams);
        }
        int[] iArr = this.B;
        if (iArr != null && (aVar = this.D0) != null) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @SuppressLint({"ObsoleteSdkInt"})
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (ViewCompat.isNestedScrollingEnabled(this.F0.g())) {
            this.f16724q = z10;
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    @Override // pf.f
    public pf.f s(float f10) {
        this.f16723p0 = uf.c.c(f10);
        return this;
    }

    public void setFixTouchEvent(boolean z10) {
        this.Y0 = z10;
        this.X0 = z10 ? (float) Math.tan(Math.toRadians(15.0d)) : 1.0f;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.R = z10;
        this.f16711j0.setNestedScrollingEnabled(z10);
    }

    @Override // pf.f
    public pf.f setPrimaryColors(@ColorInt int... iArr) {
        pf.a aVar = this.D0;
        if (aVar != null) {
            aVar.setPrimaryColors(iArr);
        }
        pf.a aVar2 = this.E0;
        if (aVar2 != null) {
            aVar2.setPrimaryColors(iArr);
        }
        this.B = iArr;
        return this;
    }

    public void setStateDirectLoading(boolean z10) {
        RefreshState refreshState = this.J0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.L0 = System.currentTimeMillis();
            this.R0 = true;
            Q0(refreshState2);
            sf.e eVar = this.f16699d0;
            if (eVar != null) {
                if (z10) {
                    eVar.p(this);
                }
            } else if (this.f16701e0 == null) {
                y(2000);
            }
            pf.a aVar = this.E0;
            if (aVar != null) {
                float f10 = this.f16729s0;
                if (f10 < 10.0f) {
                    f10 *= this.f16719n0;
                }
                aVar.t(this, this.f16719n0, (int) f10);
            }
            sf.f fVar = this.f16701e0;
            if (fVar == null || !(this.E0 instanceof pf.c)) {
                return;
            }
            if (z10) {
                fVar.p(this);
            }
            float f11 = this.f16729s0;
            if (f11 < 10.0f) {
                f11 *= this.f16719n0;
            }
            this.f16701e0.i((pf.c) this.E0, this.f16719n0, (int) f11);
        }
    }

    public void setStateLoading(boolean z10) {
        a aVar = new a(z10);
        Q0(RefreshState.LoadReleased);
        ValueAnimator e10 = this.I0.e(-this.f16719n0);
        if (e10 != null) {
            e10.addListener(aVar);
        }
        pf.a aVar2 = this.E0;
        if (aVar2 != null) {
            float f10 = this.f16729s0;
            if (f10 < 10.0f) {
                f10 *= this.f16719n0;
            }
            aVar2.l(this, this.f16719n0, (int) f10);
        }
        sf.f fVar = this.f16701e0;
        if (fVar != null) {
            pf.a aVar3 = this.E0;
            if (aVar3 instanceof pf.c) {
                float f11 = this.f16729s0;
                if (f11 < 10.0f) {
                    f11 *= this.f16719n0;
                }
                fVar.s((pf.c) aVar3, this.f16719n0, (int) f11);
            }
        }
        if (e10 == null) {
            aVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z10) {
        b bVar = new b(z10);
        Q0(RefreshState.RefreshReleased);
        ValueAnimator e10 = this.I0.e(this.f16715l0);
        if (e10 != null) {
            e10.addListener(bVar);
        }
        pf.a aVar = this.D0;
        if (aVar != null) {
            float f10 = this.f16727r0;
            if (f10 < 10.0f) {
                f10 *= this.f16715l0;
            }
            aVar.l(this, this.f16715l0, (int) f10);
        }
        sf.f fVar = this.f16701e0;
        if (fVar != null) {
            pf.a aVar2 = this.D0;
            if (aVar2 instanceof pf.d) {
                float f11 = this.f16727r0;
                if (f11 < 10.0f) {
                    f11 *= this.f16715l0;
                }
                fVar.h((pf.d) aVar2, this.f16715l0, (int) f11);
            }
        }
        if (e10 == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.J0;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            Q0(RefreshState.None);
        }
        if (this.K0 != refreshState) {
            this.K0 = refreshState;
        }
    }

    @Override // pf.f
    public pf.f t(float f10) {
        this.f16731t0 = f10;
        return this;
    }

    @Override // pf.f
    public pf.f u(boolean z10) {
        this.N = z10;
        return this;
    }

    @Override // pf.f
    public pf.f v(int i10) {
        this.f16728s = i10;
        return this;
    }

    @Override // pf.f
    public pf.f w(int i10) {
        if (i10 == this.f16715l0) {
            return this;
        }
        qf.a aVar = this.f16717m0;
        qf.a aVar2 = qf.a.f30060l;
        if (aVar.a(aVar2)) {
            this.f16715l0 = i10;
            pf.a aVar3 = this.D0;
            if (aVar3 != null && this.Q0 && this.f16717m0.f30065b) {
                qf.b spinnerStyle = aVar3.getSpinnerStyle();
                if (spinnerStyle != qf.b.f30070h && !spinnerStyle.f30074c) {
                    View view = this.D0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f16691e1;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f16715l0 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i11 = marginLayoutParams.leftMargin;
                    int i12 = (marginLayoutParams.topMargin + this.f16723p0) - (spinnerStyle == qf.b.f30066d ? this.f16715l0 : 0);
                    view.layout(i11, i12, view.getMeasuredWidth() + i11, view.getMeasuredHeight() + i12);
                }
                float f10 = this.f16727r0;
                if (f10 < 10.0f) {
                    f10 *= this.f16715l0;
                }
                this.f16717m0 = aVar2;
                this.D0.d(this.I0, this.f16715l0, (int) f10);
            } else {
                this.f16717m0 = qf.a.f30059k;
            }
        }
        return this;
    }

    @Override // pf.f
    public pf.f x(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = ContextCompat.getColor(getContext(), iArr[i10]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // pf.f
    public pf.f y(int i10) {
        return l0(i10, true, false);
    }

    @Override // pf.f
    public boolean z() {
        return q(this.Q0 ? 0 : 400, this.f16704g, (this.f16727r0 + this.f16731t0) / 2.0f, true);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16702f = 300;
        this.f16704g = 300;
        this.f16716m = 0.5f;
        this.f16718n = 'n';
        this.f16726r = -1;
        this.f16728s = -1;
        this.f16730t = -1;
        this.f16732u = -1;
        this.C = true;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = false;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f16692a0 = false;
        this.f16695b0 = false;
        this.f16709i0 = new int[2];
        this.f16711j0 = new NestedScrollingChildHelper(this);
        this.f16713k0 = new NestedScrollingParentHelper(this);
        qf.a aVar = qf.a.f30051c;
        this.f16717m0 = aVar;
        this.f16721o0 = aVar;
        this.f16727r0 = 2.5f;
        this.f16729s0 = 2.5f;
        this.f16731t0 = 1.0f;
        this.f16733u0 = 1.0f;
        this.C0 = 0.16666667f;
        this.I0 = new k();
        RefreshState refreshState = RefreshState.None;
        this.J0 = refreshState;
        this.K0 = refreshState;
        this.L0 = 0L;
        this.M0 = 0;
        this.N0 = 0;
        this.R0 = false;
        this.S0 = 0L;
        this.T0 = 0.0f;
        this.U0 = 0.0f;
        this.V0 = false;
        this.W0 = null;
        this.X0 = 1.0f;
        this.Y0 = false;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.H0 = new Handler(Looper.getMainLooper());
        this.f16737y = new Scroller(context);
        this.f16738z = VelocityTracker.obtain();
        this.f16706h = context.getResources().getDisplayMetrics().heightPixels;
        this.A = new uf.c(uf.c.f31055b);
        this.f16694b = viewConfiguration.getScaledTouchSlop();
        this.f16734v = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f16735w = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f16719n0 = uf.c.c(60.0f);
        this.f16715l0 = uf.c.c(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        sf.d dVar = f16690d1;
        if (dVar != null) {
            dVar.a(context, this);
        }
        this.f16716m = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.f16716m);
        this.f16727r0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.f16727r0);
        this.f16729s0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.f16729s0);
        this.f16731t0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.f16731t0);
        this.f16733u0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.f16733u0);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.C);
        this.f16704g = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f16704g);
        this.D = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.D);
        this.f16715l0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.f16715l0);
        this.f16719n0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.f16719n0);
        this.f16723p0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.f16723p0);
        this.f16725q0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.f16725q0);
        this.S = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.S);
        this.T = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.T);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.G);
        this.H = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.H);
        this.J = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.J);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.M);
        this.K = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.K);
        this.N = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.N);
        this.O = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.O);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.P);
        this.Q = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.Q);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.I);
        this.I = z10;
        this.I = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z10);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.E);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.F);
        this.L = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.L);
        this.f16726r = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.f16726r);
        this.f16728s = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.f16728s);
        this.f16730t = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.f16730t);
        this.f16732u = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.f16732u);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.R);
        this.R = z11;
        this.f16711j0.setNestedScrollingEnabled(z11);
        this.W = this.W || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.f16692a0 = this.f16692a0 || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.f16695b0 = this.f16695b0 || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.f16717m0 = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? qf.a.f30057i : this.f16717m0;
        this.f16721o0 = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? qf.a.f30057i : this.f16721o0;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.B = new int[]{color2, color};
            } else {
                this.B = new int[]{color2};
            }
        } else if (color != 0) {
            this.B = new int[]{0, color};
        }
        if (this.N && !this.W && !this.D) {
            this.D = true;
        }
        obtainStyledAttributes.recycle();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f16739a;

        /* renamed from: b */
        public qf.b f16740b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16739a = 0;
            this.f16740b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f16739a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f16739a);
            if (obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.f16740b = qf.b.f30071i[obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, qf.b.f30066d.f30072a)];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f16739a = 0;
            this.f16740b = null;
        }
    }
}
