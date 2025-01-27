package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.common.i0;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.views.k0;
import com.sigmob.sdk.base.views.n0;
import com.sigmob.sdk.base.views.u0;
import java.util.Map;

/* loaded from: classes4.dex */
public class u extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: m */
    public static com.sigmob.sdk.base.views.v f20041m;

    /* renamed from: n */
    public static i0.b f20042n;

    /* renamed from: a */
    public final int f20043a;

    /* renamed from: b */
    public com.sigmob.sdk.base.views.v f20044b;

    /* renamed from: c */
    public TextView f20045c;

    /* renamed from: d */
    public i0.b f20046d;

    /* renamed from: e */
    public boolean f20047e;

    /* renamed from: f */
    public ClickCommon f20048f;

    /* renamed from: g */
    public com.sigmob.sdk.nativead.b f20049g;

    /* renamed from: h */
    public boolean f20050h;

    /* renamed from: i */
    public int f20051i;

    /* renamed from: j */
    public int f20052j;

    /* renamed from: k */
    public boolean f20053k;

    /* renamed from: l */
    public Boolean f20054l;
    private String title;

    public class a implements i0.c {

        /* renamed from: com.sigmob.sdk.nativead.u$a$a */
        public class RunnableC0615a implements Runnable {
            public RunnableC0615a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                u.this.f20048f.sld = "5";
                u.this.b();
            }
        }

        public a() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(Map<String, Number> map) {
            if (map == null || u.this.f20047e) {
                return;
            }
            u.this.f20047e = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                u.this.f20048f.turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                u.this.f20048f.turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                u.this.f20048f.turn_z = String.valueOf(number3.intValue());
            }
            u.this.f20048f.turn_time = String.valueOf(number4);
            u.this.f20044b.postDelayed(new RunnableC0615a(), 400L);
        }
    }

    public class b implements i0.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f20047e) {
                    return;
                }
                u.this.f20048f.sld = "2";
                u.this.b();
            }
        }

        public b() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(Map<String, Number> map) {
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null && u.this.f20048f != null) {
                u.this.f20048f.x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null && u.this.f20048f != null) {
                u.this.f20048f.y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null && u.this.f20048f != null) {
                u.this.f20048f.z_max_acc = String.valueOf(number3.intValue());
            }
            u.this.f20044b.postDelayed(new a(), 400L);
        }
    }

    public class c implements i0.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f20047e) {
                    return;
                }
                u.this.f20048f.sld = "2";
                u.this.b();
            }
        }

        public c() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(Map<String, Number> map) {
            if (map != null) {
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null && u.this.f20048f != null) {
                    u.this.f20048f.x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null && u.this.f20048f != null) {
                    u.this.f20048f.y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null && u.this.f20048f != null) {
                    u.this.f20048f.z_max_acc = String.valueOf(number3.intValue());
                }
                u.this.f20044b.postDelayed(new a(), 400L);
            }
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(float f10) {
            if (u.this.f20044b instanceof k0) {
                ((k0) u.this.f20044b).a(f10);
            }
        }
    }

    public class d implements i0.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                u.this.f20048f.sld = "2";
                u.this.b();
            }
        }

        public d() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(Map<String, Number> map) {
            if (map == null || u.this.f20047e) {
                return;
            }
            u.this.f20047e = true;
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null && u.this.f20048f != null) {
                u.this.f20048f.x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null && u.this.f20048f != null) {
                u.this.f20048f.y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null && u.this.f20048f != null) {
                u.this.f20048f.z_max_acc = String.valueOf(number3.intValue());
            }
            u.this.f20044b.postDelayed(new a(), 400L);
        }

        @Override // com.sigmob.sdk.base.common.i0.c
        public void a(float f10) {
            if (u.this.f20044b instanceof n0) {
                ((n0) u.this.f20044b).a(f10);
            }
        }
    }

    public u(Context context) {
        super(context);
        this.f20047e = false;
        this.f20054l = null;
        this.f20051i = Dips.dipsToIntPixels(100.0f, context);
        this.f20052j = Dips.dipsToIntPixels(60.0f, context);
        this.f20043a = Dips.dipsToIntPixels(5.0f, getContext());
    }

    public void e() {
        if (this.f20050h && this.f20044b.getVisibility() == 0) {
            com.sigmob.sdk.base.views.v vVar = f20041m;
            if (vVar != null && vVar != this.f20044b) {
                vVar.b();
                f20041m = null;
            }
            i0.b bVar = f20042n;
            if (bVar != null && bVar != this.f20046d) {
                bVar.b();
                f20042n = null;
            }
            this.f20047e = false;
            if (this.f20046d != null && this.f20050h && com.sigmob.sdk.base.utils.e.d(this)) {
                i0.b bVar2 = f20042n;
                i0.b bVar3 = this.f20046d;
                if (bVar2 != bVar3) {
                    f20042n = bVar3;
                    bVar3.c();
                }
                com.sigmob.sdk.base.views.v vVar2 = this.f20044b;
                if (vVar2 == null || vVar2 == f20041m || vVar2.getVisibility() != 0) {
                    return;
                }
                com.sigmob.sdk.base.views.v vVar3 = this.f20044b;
                f20041m = vVar3;
                vVar3.a();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f20050h = true;
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20050h = false;
        this.f20053k = false;
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        d();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        TextView textView;
        if (this.f20053k) {
            this.f20053k = false;
            int min = Math.min(getWidth(), getHeight());
            com.sigmob.sdk.base.utils.e.e(this.f20045c);
            if (min < this.f20052j) {
                com.sigmob.sdk.base.views.v vVar = this.f20044b;
                if (vVar != null) {
                    vVar.b();
                    this.f20044b.setVisibility(4);
                }
                i0.b bVar = this.f20046d;
                if (bVar != null) {
                    bVar.b();
                }
                this.f20054l = Boolean.FALSE;
                return;
            }
            com.sigmob.sdk.base.views.v vVar2 = this.f20044b;
            if (vVar2 != null) {
                ViewGroup.LayoutParams layoutParams = vVar2.getLayoutParams();
                if (layoutParams != null && layoutParams.width != min) {
                    layoutParams.width = min;
                    layoutParams.height = min;
                    this.f20044b.setLayoutParams(layoutParams);
                }
                Boolean bool = this.f20054l;
                if (bool != null && !bool.booleanValue()) {
                    this.f20044b.a();
                    this.f20044b.setVisibility(0);
                    i0.b bVar2 = this.f20046d;
                    if (bVar2 != null) {
                        bVar2.c();
                    }
                }
                if (min < this.f20051i) {
                    return;
                }
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                getLocationOnScreen(iArr2);
                this.f20044b.getLocationOnScreen(iArr);
                int top = getTop() + min + (iArr[1] - iArr2[1]);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup == null || (textView = this.f20045c) == null) {
                    return;
                }
                com.sigmob.sdk.base.utils.e.e(textView);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 1;
                layoutParams2.setMargins(0, top + this.f20043a, 0, 0);
                viewGroup.addView(this.f20045c, layoutParams2);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f20053k = true;
    }

    public void setMotionActionListener(com.sigmob.sdk.nativead.b bVar) {
        this.f20049g = bVar;
    }

    public final void b(int i10) {
        this.f20044b = new k0(getContext());
        this.title = "前倾或点击前往";
        i0.b bVar = new i0.b(getContext(), new c(), i0.d.SLOPE);
        this.f20046d = bVar;
        bVar.b(i10);
    }

    public final void c(int i10) {
        this.f20044b = new n0(getContext());
        this.title = "晃动或点击前往";
        i0.b bVar = new i0.b(getContext(), new d(), i0.d.SWING);
        this.f20046d = bVar;
        bVar.b(i10);
    }

    public final void d(int i10) {
        this.f20044b = new u0(getContext());
        this.title = "扭动或点击前往";
        i0.b bVar = new i0.b(getContext(), new a(), i0.d.WRING);
        this.f20046d = bVar;
        bVar.b(i10);
    }

    public final void a(int i10) {
        this.f20044b = new com.sigmob.sdk.base.views.c0(getContext());
        this.title = "摇一摇或点击前往";
        i0.b bVar = new i0.b(getContext(), new b(), i0.d.SHAKE);
        this.f20046d = bVar;
        bVar.b(i10);
    }

    public final void b() {
        com.sigmob.sdk.nativead.b bVar = this.f20049g;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void c() {
        this.f20053k = true;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void d() {
        com.sigmob.sdk.base.views.v vVar = this.f20044b;
        if (vVar != null) {
            vVar.b();
        }
        i0.b bVar = this.f20046d;
        if (bVar != null) {
            bVar.b();
        }
        com.sigmob.sdk.base.views.v vVar2 = f20041m;
        if (vVar2 != null && vVar2 == this.f20044b) {
            f20041m = null;
        }
        i0.b bVar2 = f20042n;
        if (bVar2 == null || bVar2 != this.f20046d) {
            return;
        }
        f20042n = null;
    }

    public void a() {
        com.sigmob.sdk.base.views.v vVar = f20041m;
        if (vVar != null && vVar == this.f20044b) {
            f20041m = null;
        }
        i0.b bVar = f20042n;
        if (bVar != null && bVar == this.f20046d) {
            f20042n = null;
        }
        com.sigmob.sdk.base.views.v vVar2 = this.f20044b;
        if (vVar2 != null) {
            vVar2.b();
            com.sigmob.sdk.base.utils.e.e(this.f20044b);
            this.f20044b = null;
        }
        TextView textView = this.f20045c;
        if (textView != null) {
            com.sigmob.sdk.base.utils.e.e(textView);
            this.f20045c = null;
        }
        i0.b bVar2 = this.f20046d;
        if (bVar2 != null) {
            bVar2.a();
            this.f20046d = null;
        }
    }

    public boolean a(int i10, int i11, ClickCommon clickCommon) {
        this.f20048f = clickCommon;
        if (i10 == 138731) {
            c(i11);
        } else if (i10 == 138733) {
            b(i11);
        } else if (i10 == 138757) {
            a(i11);
        } else if (i10 == 138758) {
            d(i11);
        }
        if (this.f20044b == null) {
            return false;
        }
        this.f20048f.widget_id = i10;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f20044b.setId(ClientMetadata.generateViewId());
        addView(this.f20044b, layoutParams);
        TextView textView = new TextView(getContext());
        this.f20045c = textView;
        textView.setText(this.title);
        this.f20045c.setTextSize(2, 15.0f);
        this.f20045c.setTextColor(-1);
        this.f20045c.setTypeface(Typeface.DEFAULT_BOLD);
        this.f20045c.setId(ClientMetadata.generateViewId());
        return true;
    }
}
