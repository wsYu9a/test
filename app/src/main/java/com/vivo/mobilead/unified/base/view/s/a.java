package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vivo.ad.e.a;
import com.vivo.ad.model.q;
import com.vivo.ad.view.s;
import com.vivo.ad.view.v;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public abstract class a extends FrameLayout implements com.vivo.mobilead.unified.base.callback.c {
    private boolean A;
    protected com.vivo.mobilead.unified.base.view.u.b B;
    protected View C;
    private boolean D;
    private ViewTreeObserver.OnPreDrawListener E;
    private DialogInterface.OnShowListener F;
    private DialogInterface.OnDismissListener G;

    /* renamed from: a */
    private boolean f30031a;

    /* renamed from: b */
    private boolean f30032b;

    /* renamed from: c */
    private boolean f30033c;

    /* renamed from: d */
    private boolean f30034d;

    /* renamed from: e */
    private int f30035e;

    /* renamed from: f */
    private int f30036f;

    /* renamed from: g */
    private int f30037g;

    /* renamed from: h */
    private int f30038h;

    /* renamed from: i */
    protected Context f30039i;

    /* renamed from: j */
    protected LinearLayout f30040j;
    protected com.vivo.ad.view.l k;
    private com.vivo.mobilead.unified.base.callback.d l;
    private View.OnClickListener m;
    protected MediaListener n;
    protected f o;
    protected int p;
    protected float q;
    private com.vivo.ad.view.i r;
    private com.vivo.mobilead.unified.nativead.a s;
    protected com.vivo.mobilead.unified.interstitial.m.a t;
    protected com.vivo.mobilead.unified.base.view.a u;
    protected com.vivo.ad.model.b v;
    private int w;
    private float x;
    private float y;
    private boolean z;

    /* renamed from: com.vivo.mobilead.unified.base.view.s.a$a */
    class ViewOnClickListenerC0627a implements View.OnClickListener {
        ViewOnClickListenerC0627a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.k != null) {
                view.setTag(8);
                a aVar = a.this;
                aVar.k.a(aVar, aVar.f30037g, a.this.f30038h, a.this.f30035e, a.this.f30036f, false);
            }
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f30042a;

        /* renamed from: b */
        final /* synthetic */ AdParams f30043b;

        b(com.vivo.ad.model.b bVar, AdParams adParams) {
            this.f30042a = bVar;
            this.f30043b = adParams;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.c a2 = new a.c(a.this.getContext()).a(this.f30042a);
            AdParams adParams = this.f30043b;
            a2.a(adParams == null ? "" : adParams.getSourceAppend()).a(a.this.F).a(a.this.G).a();
        }
    }

    class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!a.this.f30031a || !a.this.f30032b || a.this.l == null) {
                return true;
            }
            a.this.l.a();
            return true;
        }
    }

    class d implements DialogInterface.OnShowListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            a.this.f30034d = true;
            a.this.j();
        }
    }

    class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.f30034d = false;
            a.this.j();
        }
    }

    public interface f {
        void a(a aVar);
    }

    public a(@NonNull Context context) {
        this(context, null);
    }

    private void k() {
        this.w = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
        this.p = com.vivo.mobilead.util.m.b(this.f30039i, 10.0f);
        setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f30040j = linearLayout;
        linearLayout.setOrientation(1);
        setOnClickListener(new ViewOnClickListenerC0627a());
    }

    private boolean l() {
        for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            boolean canScrollHorizontally = viewGroup.canScrollHorizontally(1);
            boolean canScrollHorizontally2 = viewGroup.canScrollHorizontally(-1);
            boolean canScrollVertically = viewGroup.canScrollVertically(1);
            boolean canScrollVertically2 = viewGroup.canScrollVertically(-1);
            if (canScrollHorizontally || canScrollHorizontally2 || canScrollVertically || canScrollVertically2) {
                return true;
            }
        }
        return false;
    }

    protected abstract void c(com.vivo.ad.model.b bVar, AdParams adParams);

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A = false;
            this.z = false;
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
            com.vivo.ad.model.b bVar = this.v;
            if (bVar != null && bVar.c() != null && this.v.c().w() == 1) {
                b(true);
                this.A = true;
            }
        } else if (action != 1) {
            if (action == 2 && !this.z && this.A) {
                float x = motionEvent.getX();
                float abs = Math.abs(x - this.x);
                float y = motionEvent.getY();
                float abs2 = Math.abs(y - this.y);
                float f2 = this.w;
                if (abs > f2 || abs2 > f2) {
                    this.x = x;
                    this.y = y;
                    this.z = true;
                }
            }
        } else if (this.A) {
            b(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public Rect getBounds() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + getWidth(), iArr[1] + getHeight());
    }

    protected abstract int getMaterialContainerHeight();

    protected abstract int getMaterialContainerWidth();

    protected abstract int[] getMinSize();

    public com.vivo.ad.view.k getOnADWidgetClickListener() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public int getPrice() {
        com.vivo.mobilead.unified.nativead.a aVar = this.s;
        if (aVar == null) {
            return -3;
        }
        return aVar.i();
    }

    public String getPriceLevel() {
        com.vivo.mobilead.unified.nativead.a aVar = this.s;
        return aVar == null ? "" : aVar.j();
    }

    public void h() {
    }

    public void i() {
    }

    public abstract void j();

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f30031a = true;
        this.f30032b = isShown();
        getViewTreeObserver().addOnPreDrawListener(this.E);
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f30031a = false;
        getViewTreeObserver().removeOnPreDrawListener(this.E);
        j();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f30037g = (int) motionEvent.getRawX();
            this.f30038h = (int) motionEvent.getRawY();
            this.f30036f = (int) motionEvent.getX();
            this.f30035e = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        this.f30032b = i2 == 0;
        j();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f30033c = z;
        j();
    }

    public void setBiddingImpl(com.vivo.mobilead.unified.nativead.a aVar) {
        this.s = aVar;
    }

    public void setIsFeedbackShow(boolean z) {
        this.f30034d = z;
    }

    public void setMediaListener(MediaListener mediaListener) {
        this.n = mediaListener;
    }

    public a(com.vivo.mobilead.model.b bVar, @NonNull Context context, com.vivo.ad.model.b bVar2, AdParams adParams, boolean z) {
        super(context);
        this.f30031a = false;
        this.f30032b = false;
        this.f30033c = true;
        this.f30034d = false;
        this.D = false;
        this.E = new c();
        this.F = new d();
        this.G = new e();
        this.f30039i = context;
        this.D = z;
        if (z) {
            return;
        }
        k();
    }

    private void b(boolean z) {
        ViewParent parent;
        ViewParent parent2 = getParent();
        if (!(parent2 instanceof VivoNativeExpressView) || (parent = parent2.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    protected com.vivo.mobilead.unified.interstitial.m.a c() {
        com.vivo.mobilead.unified.interstitial.m.a aVar = new com.vivo.mobilead.unified.interstitial.m.a(getContext());
        aVar.setBackgroundColor(-16777216);
        View view = new View(getContext());
        view.setBackground(new ColorDrawable(Color.parseColor("#51000000")));
        aVar.addView(view);
        aVar.setRadius(this.p);
        return aVar;
    }

    protected s d() {
        s sVar = new s(this.f30039i, this.p);
        sVar.setScaleType(ImageView.ScaleType.FIT_XY);
        sVar.setOnADWidgetClickListener(this.k);
        sVar.setTag(8);
        return sVar;
    }

    public void e() {
        removeAllViews();
        this.k = null;
        this.l = null;
        this.n = null;
    }

    public boolean f() {
        return l() && this.z;
    }

    protected boolean g() {
        return this.f30031a && this.f30032b && this.f30033c && !this.f30034d;
    }

    protected RelativeLayout a() {
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 6.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setPadding(a2, a2, a2, a2);
        relativeLayout.setContentDescription("closeContainer");
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_express_close.png"));
        relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 8.0f), com.vivo.mobilead.util.m.b(getContext(), 8.0f)));
        relativeLayout.setOnClickListener(this.m);
        return relativeLayout;
    }

    protected ImageView b() {
        ImageView imageView = new ImageView(this.f30039i);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    private String b(q qVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.j())) {
            return "1万人";
        }
        return qVar.j() + "人";
    }

    public void b(com.vivo.ad.model.b bVar, AdParams adParams) {
        this.v = bVar;
        if (bVar == null || com.vivo.mobilead.util.d.e(bVar) == -1) {
            return;
        }
        this.v = bVar;
        a(adParams);
        c(bVar, adParams);
    }

    protected LinearLayout a(com.vivo.ad.model.b bVar, AdParams adParams) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFe6e6e6"));
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.a(getContext(), 4.0f));
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(getContext());
        cVar.a(10, -1);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 5.0f);
        int a3 = com.vivo.mobilead.util.m.a(getContext(), 2.0f);
        cVar.setPadding(a2, a3, a2, a3);
        cVar.setTagBackground(gradientDrawable);
        if (bVar != null) {
            if (bVar.r() != null && !bVar.r().isEmpty()) {
                cVar.b(com.vivo.mobilead.h.b.a().a(bVar.e()), bVar.k(), bVar.O(), true);
            } else {
                cVar.a(com.vivo.mobilead.h.b.a().a(bVar.e()), bVar.k(), bVar.O());
            }
            cVar.setOnClickListener(new b(bVar, adParams));
        } else {
            cVar.a(null, "", "广告");
        }
        return cVar;
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30031a = false;
        this.f30032b = false;
        this.f30033c = true;
        this.f30034d = false;
        this.D = false;
        this.E = new c();
        this.F = new d();
        this.G = new e();
        this.f30039i = context;
        k();
    }

    protected TextView a(int i2, String str) {
        TextView textView = new TextView(this.f30039i);
        textView.setTextSize(1, 16.0f);
        textView.setTextColor(-16777216);
        textView.setGravity(3);
        textView.setText(str);
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(i2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    protected void a(String str) {
        int i2;
        int[] b2 = com.vivo.mobilead.h.b.a().b(str);
        if (b2 == null || b2.length != 2) {
            i2 = 1;
        } else {
            double d2 = b2[0];
            double materialContainerWidth = getMaterialContainerWidth();
            Double.isNaN(d2);
            Double.isNaN(materialContainerWidth);
            i2 = (int) Math.floor(d2 / materialContainerWidth);
        }
        com.vivo.mobilead.h.b.a().a(str, i2, this);
    }

    protected View a(com.vivo.ad.model.b bVar) {
        View a2 = new v(getContext(), bVar, this.k, this.B).a();
        this.C = a2;
        if (a2 != null && (a2.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) this.C.getLayoutParams()).addRule(12);
        }
        return this.C;
    }

    protected LinearLayout a(com.vivo.ad.model.b bVar, AdParams adParams, boolean z) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(a(bVar, adParams), new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(getContext());
        if (!com.vivo.mobilead.util.q.a(bVar)) {
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setTextSize(1, 11.0f);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setIncludeFontPadding(false);
            textView.setText(com.vivo.mobilead.util.d.d(bVar));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.setMargins(com.vivo.mobilead.util.m.a(getContext(), 10.0f), 0, com.vivo.mobilead.util.m.a(getContext(), 10.0f), 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(textView, layoutParams);
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
        this.u = aVar;
        aVar.e();
        this.u.setText(bVar);
        this.u.setOnAWClickListener(this.k);
        this.u.setTag(9);
        linearLayout.addView(this.u);
        if (z) {
            int b2 = com.vivo.mobilead.util.m.b(getContext(), 20.0f);
            int a2 = com.vivo.mobilead.util.m.a(getContext(), 14.0f);
            RelativeLayout a3 = a();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, b2);
            layoutParams2.setMargins(a2, 0, 0, 0);
            linearLayout.addView(a3, layoutParams2);
        }
        return linearLayout;
    }

    protected LinearLayout a(q qVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(16);
        com.vivo.ad.h.b.o oVar = new com.vivo.ad.h.b.o(getContext());
        oVar.setFirstNoMargin(true);
        oVar.a(10, 10);
        oVar.setRating(Math.max(qVar.p(), 4.0f));
        linearLayout.addView(oVar);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#FDAB19"));
        textView.setTextSize(1, 12.0f);
        textView.setText(String.valueOf(Math.round(qVar.p() * 10.0f) / 10.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.vivo.mobilead.util.m.a(getContext(), 3.0f), 0, 0, 0);
        linearLayout.addView(textView, layoutParams);
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#ECECEC"));
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 8.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(getContext(), 0.34f), a2);
        layoutParams2.setMargins(a2, 0, a2, 0);
        linearLayout.addView(view, layoutParams2);
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(Color.parseColor("#B3999999"));
        textView2.setTextSize(1, 11.0f);
        textView2.setText(b(qVar));
        textView2.setLines(1);
        Drawable b2 = com.vivo.mobilead.util.g.b(this.f30039i, "vivo_module_biz_ui_download_gray.png");
        if (b2 != null) {
            b2.setBounds(0, 0, com.vivo.mobilead.util.m.a(getContext(), b2.getMinimumWidth()), com.vivo.mobilead.util.m.a(getContext(), b2.getIntrinsicHeight()));
            textView2.setCompoundDrawables(null, null, b2, null);
            textView2.setCompoundDrawablePadding(com.vivo.mobilead.util.m.a(getContext(), 4.0f));
        }
        linearLayout.addView(textView2);
        return linearLayout;
    }

    protected void a(boolean z) {
        f fVar = this.o;
        if (fVar != null) {
            if (z) {
                fVar.a(this);
            } else {
                fVar.a(null);
                e();
            }
        }
    }

    public void a(View.OnClickListener onClickListener, com.vivo.ad.view.l lVar, com.vivo.mobilead.unified.base.callback.d dVar, com.vivo.mobilead.unified.base.view.u.b bVar, f fVar) {
        this.m = onClickListener;
        this.k = lVar;
        this.l = dVar;
        this.o = fVar;
        this.B = bVar;
    }

    public void a(int i2) {
        com.vivo.mobilead.unified.nativead.a aVar = this.s;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public void a(int i2, int i3) {
        com.vivo.mobilead.unified.nativead.a aVar = this.s;
        if (aVar != null) {
            aVar.b(i2, i3);
        }
    }

    private void a(AdParams adParams) {
        int c2;
        int i2;
        if (this.D) {
            c2 = com.vivo.mobilead.util.m.c(getContext(), com.vivo.mobilead.util.n.b(this.f30039i));
        } else {
            c2 = com.vivo.mobilead.util.m.c(getContext(), com.vivo.mobilead.util.n.f());
        }
        int[] minSize = getMinSize();
        int nativeExpressWidth = (adParams == null || adParams.getNativeExpressWidth() == -1) ? 360 : adParams.getNativeExpressWidth();
        if (nativeExpressWidth > c2) {
            nativeExpressWidth = c2;
        } else if (nativeExpressWidth < minSize[0]) {
            nativeExpressWidth = minSize[0];
        }
        if (this.D && c2 != 0) {
            this.q = nativeExpressWidth / c2;
        } else {
            this.q = nativeExpressWidth / 360.0f;
        }
        int b2 = com.vivo.mobilead.util.m.b(getContext(), nativeExpressWidth);
        if (adParams == null || adParams.getNativeExpressHegiht() == -1) {
            i2 = -2;
        } else {
            int nativeExpressHegiht = adParams.getNativeExpressHegiht();
            if (nativeExpressHegiht < minSize[1]) {
                nativeExpressHegiht = minSize[1];
            }
            i2 = com.vivo.mobilead.util.m.b(getContext(), nativeExpressHegiht);
        }
        if (!this.D) {
            int b3 = com.vivo.mobilead.util.m.b(this.f30039i, this.q * 13.33f);
            addView(this.f30040j, new FrameLayout.LayoutParams(b2 - (b3 * 2), -2));
            setPadding(b3, b3, b3, b3);
            setLayoutParams(new FrameLayout.LayoutParams(b2, i2));
            return;
        }
        setLayoutParams(new FrameLayout.LayoutParams(b2, i2));
    }

    protected View a(com.vivo.ad.model.b bVar, String str, ViewGroup.LayoutParams layoutParams) {
        q y = bVar.y();
        com.vivo.ad.view.i iVar = new com.vivo.ad.view.i(getContext());
        this.r = iVar;
        iVar.setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        textView.setId(y0.a());
        textView.setTextSize(1, 11.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        textView.setText(y.d() + " V" + y.s() + " " + (y.q() / 1024) + "MB");
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        linearLayout.addView(textView);
        com.vivo.ad.view.o oVar = new com.vivo.ad.view.o(getContext());
        oVar.a(bVar, str);
        oVar.setId(y0.a());
        oVar.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        linearLayout.addView(oVar);
        this.r.addView(linearLayout, -2, com.vivo.mobilead.util.m.a(getContext(), 16.0f));
        TextView textView2 = new TextView(getContext());
        textView2.setTextSize(1, 11.0f);
        textView2.setSingleLine();
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(Color.parseColor("#999999"));
        textView2.setText(y.g());
        this.r.addView(textView2, -2, com.vivo.mobilead.util.m.a(getContext(), 16.0f));
        this.r.setLayoutParams(layoutParams);
        this.r.setTag(8);
        this.r.setOnADWidgetClickListener(this.k);
        return this.r;
    }
}
