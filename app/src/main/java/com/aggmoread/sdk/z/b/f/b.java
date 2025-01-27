package com.aggmoread.sdk.z.b.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private TextView f4382a;

    /* renamed from: b */
    private TextView f4383b;

    /* renamed from: c */
    private ImageView f4384c;

    /* renamed from: d */
    private ViewTreeObserver.OnScrollChangedListener f4385d;

    /* renamed from: e */
    private ViewTreeObserver.OnGlobalLayoutListener f4386e;

    /* renamed from: f */
    private Context f4387f;

    /* renamed from: g */
    private ImageView f4388g;

    /* renamed from: h */
    private View f4389h;

    /* renamed from: i */
    private com.aggmoread.sdk.z.b.g.g f4390i;

    /* renamed from: j */
    private l f4391j;

    /* renamed from: k */
    private AtomicBoolean f4392k = new AtomicBoolean();

    /* renamed from: l */
    private boolean f4393l = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f4389h != null && b.this.f4389h.getParent() != null) {
                ((ViewGroup) b.this.f4389h.getParent()).removeView(b.this.f4389h);
            }
            if (b.this.f4391j != null) {
                b.this.f4391j.b();
            }
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.f.b$b */
    public class C0070b extends FrameLayout {
        public C0070b(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onWindowVisibilityChanged(int i10) {
            if (i10 != 0 || b.this.f4392k.get()) {
                return;
            }
            b.this.a(this);
        }
    }

    public class c implements ViewTreeObserver.OnScrollChangedListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            b bVar = b.this;
            bVar.a(bVar.f4389h);
        }
    }

    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b bVar = b.this;
            bVar.a(bVar.f4389h);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.e();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f();
        }
    }

    public class g implements a.g {

        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f4401b;

            public a(Bitmap bitmap) {
                this.f4401b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f4388g.setImageBitmap(this.f4401b);
                b.this.d();
            }
        }

        public g() {
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            String str;
            b bVar = b.this;
            if (eVar != null) {
                str = "广告渲染失败：code = " + eVar.a() + ", msg = " + eVar.b();
            } else {
                if (bArr != null) {
                    n.a().post(new a(com.aggmoread.sdk.z.b.n.a.a().a(bVar.f4388g.getWidth(), b.this.f4388g.getHeight(), Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, bArr)));
                    return;
                }
                str = "广告素材为空!";
            }
            bVar.a(str);
        }
    }

    public class h implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f4403b;

        public h(String str) {
            this.f4403b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f4391j != null) {
                b.this.f4391j.a(this.f4403b);
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f4391j != null) {
                b.this.f4391j.onRenderSuccess();
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f4391j != null) {
                b.this.f4391j.a();
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f4391j == null || !b.this.f4392k.get()) {
                return;
            }
            b.this.f4391j.c();
        }
    }

    public interface l {
        void a();

        void a(String str);

        void b();

        void c();

        void onRenderSuccess();
    }

    public b(Context context) {
        this.f4387f = context;
    }

    public void e() {
        n.a().post(new k());
    }

    public View a() {
        if (!this.f4393l) {
            h();
        }
        if (this.f4389h == null) {
            this.f4389h = a(this.f4387f);
        }
        return this.f4389h;
    }

    public int b() {
        return -1;
    }

    public String c() {
        return "";
    }

    public void h() {
        String str;
        if (this.f4393l) {
            return;
        }
        if (this.f4390i == null) {
            a("广告素材为空!");
            return;
        }
        if (this.f4389h == null) {
            this.f4389h = a(this.f4387f);
        }
        this.f4385d = new c();
        this.f4386e = new d();
        this.f4389h.getViewTreeObserver().addOnGlobalLayoutListener(this.f4386e);
        this.f4389h.getViewTreeObserver().addOnScrollChangedListener(this.f4385d);
        if (TextUtils.isEmpty(this.f4390i.f4509e)) {
            str = "";
        } else {
            this.f4383b.setText(this.f4390i.f4509e);
            str = this.f4390i.f4509e;
        }
        if (!TextUtils.isEmpty(this.f4390i.f4508d)) {
            str = this.f4390i.f4508d;
        }
        this.f4382a.setText(str);
        this.f4389h.setOnClickListener(new e());
        this.f4384c.setOnClickListener(new f());
        com.aggmoread.sdk.z.b.p.a.a(this.f4390i.f4505a, null, new g());
    }

    private View a(Context context) {
        C0070b c0070b = new C0070b(context);
        c0070b.setBackgroundColor(-1);
        int a10 = com.aggmoread.sdk.z.b.m.b.a(context, 10.0d);
        c0070b.setPadding(a10, a10, a10, a10);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, com.aggmoread.sdk.z.b.m.b.a(this.f4387f, 48.0d)));
        this.f4388g = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 0.25f;
        layoutParams.rightMargin = a10;
        this.f4388g.setLayoutParams(layoutParams);
        this.f4388g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(this.f4388g);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 0.75f;
        relativeLayout.setLayoutParams(layoutParams2);
        this.f4383b = new TextView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(10);
        layoutParams3.rightMargin = com.aggmoread.sdk.z.b.m.b.a(context, 15.0d);
        this.f4383b.setLayoutParams(layoutParams3);
        this.f4383b.setMaxLines(2);
        this.f4383b.setTextSize(15.0f);
        TextView textView = this.f4383b;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        this.f4383b.setTextColor(-16777216);
        this.f4383b.setText("  ");
        relativeLayout.addView(this.f4383b);
        this.f4382a = new TextView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(12);
        layoutParams4.rightMargin = com.aggmoread.sdk.z.b.m.b.a(context, 30.0d);
        this.f4382a.setLayoutParams(layoutParams4);
        this.f4382a.setMaxLines(1);
        this.f4382a.setTextSize(14.0f);
        this.f4382a.setEllipsize(truncateAt);
        this.f4382a.setTextColor(Color.parseColor("#8a8a8a"));
        this.f4382a.setText("  ");
        relativeLayout.addView(this.f4382a);
        linearLayout.addView(relativeLayout);
        c0070b.addView(linearLayout);
        this.f4384c = new ImageView(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(context, 16.0d), com.aggmoread.sdk.z.b.m.b.a(context, 16.0d));
        layoutParams5.gravity = 53;
        this.f4384c.setLayoutParams(layoutParams5);
        com.aggmoread.sdk.z.b.m.j.a(this.f4384c, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABaklEQVRYR+2VP0vEQBDF31tsBfHTWO5saWOjoOefQq5RK0v9AtpZqYVi4X9QCyutJqn8OqK1OLKSwBHPu9wtEoSkTObN/PJ2ZpZo+GHD9dECtA60Dgx1QFUfAMw457re+6c6Y6uqswBOSL6IyMIgzVCALMveAUwC+DCz+RDC46CEqjpH8h7AhJm9hRCmkgBUtUPyEgDN7JPkmohc9UuaZdmymZ2TdADMzFZCCNdJAFEcEwO4iBBF4m4I4aw3saqukzwtYwCs/gbaqxt6BGVwBQIkN733x/F7nucbZnZUxFrd4jG+NkAfJ+Kr7aLowTjFRwaIgorVvW6O9OelcCQHSlEfiNhwP/qizsj+P4BGj6A6CQB2Cpv3/rwJGx3DRhdRnudLZhZX7/cqds4teu/v6qxiAB0RuU1axSmXEYBXEZlOBdg3swWSWyLyXGe243VM8tDMbkIIu0kAdQqmxIy1iFIKVrUtQOtA68AX4HzJIQMvlE8AAAAASUVORK5CYII=");
        c0070b.addView(this.f4384c);
        return c0070b;
    }

    public void d() {
        this.f4393l = true;
        n.a().post(new i());
    }

    public void f() {
        n.a().post(new a());
    }

    public void g() {
        View view = this.f4389h;
        if (view != null) {
            if (this.f4385d != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener(this.f4385d);
                this.f4385d = null;
            }
            if (this.f4386e != null) {
                this.f4389h.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4386e);
                this.f4386e = null;
            }
        }
    }

    public void a(View view) {
        if (this.f4392k.get() || !com.aggmoread.sdk.z.b.m.b.a(view)) {
            return;
        }
        view.getViewTreeObserver().removeOnScrollChangedListener(this.f4385d);
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4386e);
        this.f4392k.set(true);
        n.a().post(new j());
    }

    public void a(l lVar) {
        this.f4391j = lVar;
    }

    public void a(com.aggmoread.sdk.z.b.g.g gVar) {
        this.f4390i = gVar;
    }

    public void a(String str) {
        n.a().post(new h(str));
    }
}
