package com.aggmoread.sdk.z.b.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
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
public class c {

    /* renamed from: a */
    private TextView f4659a;

    /* renamed from: b */
    private TextView f4660b;

    /* renamed from: c */
    private ImageView f4661c;

    /* renamed from: d */
    private ViewTreeObserver.OnScrollChangedListener f4662d;

    /* renamed from: e */
    private Context f4663e;

    /* renamed from: f */
    private ImageView f4664f;

    /* renamed from: g */
    private View f4665g;

    /* renamed from: h */
    private com.aggmoread.sdk.z.b.g.g f4666h;

    /* renamed from: i */
    private k f4667i;

    /* renamed from: j */
    private AtomicBoolean f4668j = new AtomicBoolean();

    /* renamed from: k */
    private boolean f4669k = false;

    public class a extends FrameLayout {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onWindowVisibilityChanged(int i10) {
            if (i10 == 0 && !c.this.f4668j.get() && com.aggmoread.sdk.z.b.m.b.a(this)) {
                c.this.a(this);
            }
        }
    }

    public class b implements ViewTreeObserver.OnScrollChangedListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            c cVar = c.this;
            cVar.a(cVar.f4665g);
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.k.c$c */
    public class ViewOnClickListenerC0080c implements View.OnClickListener {
        public ViewOnClickListenerC0080c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.e();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f();
        }
    }

    public class e implements a.g {

        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f4675b;

            public a(Bitmap bitmap) {
                this.f4675b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f4664f.setImageBitmap(this.f4675b);
                c.this.d();
            }
        }

        public e() {
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            String str;
            c cVar = c.this;
            if (eVar != null) {
                str = "广告渲染失败：code = " + eVar.a() + ", msg = " + eVar.b();
            } else {
                if (bArr != null) {
                    n.a().post(new a(com.aggmoread.sdk.z.b.n.a.a().a(cVar.f4664f.getWidth(), c.this.f4664f.getHeight(), Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, bArr)));
                    return;
                }
                str = "广告素材为空!";
            }
            cVar.a(str);
        }
    }

    public class f implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f4677b;

        public f(String str) {
            this.f4677b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f4667i != null) {
                c.this.f4667i.a(this.f4677b);
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f4667i != null) {
                c.this.f4667i.onRenderSuccess();
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f4667i != null) {
                c.this.f4667i.a();
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f4667i == null || !c.this.f4668j.get()) {
                return;
            }
            c.this.f4667i.c();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f4667i != null) {
                c.this.f4667i.b();
            }
        }
    }

    public interface k {
        void a();

        void a(String str);

        void b();

        void c();

        void onRenderSuccess();
    }

    public c(Context context) {
        this.f4663e = context;
    }

    public void e() {
        n.a().post(new i());
    }

    public View a() {
        if (this.f4665g == null) {
            this.f4665g = a(this.f4663e);
        }
        return this.f4665g;
    }

    public int b() {
        return -1;
    }

    public String c() {
        return "";
    }

    public void h() {
        String str;
        if (this.f4669k) {
            return;
        }
        if (this.f4666h == null) {
            a("广告素材为空!");
            return;
        }
        if (this.f4665g == null) {
            this.f4665g = a(this.f4663e);
        }
        this.f4662d = new b();
        this.f4665g.getViewTreeObserver().addOnScrollChangedListener(this.f4662d);
        if (TextUtils.isEmpty(this.f4666h.f4509e)) {
            str = "";
        } else {
            this.f4660b.setText(this.f4666h.f4509e);
            str = this.f4666h.f4509e;
        }
        if (!TextUtils.isEmpty(this.f4666h.f4508d)) {
            str = this.f4666h.f4508d;
        }
        this.f4659a.setText(str);
        this.f4665g.setOnClickListener(new ViewOnClickListenerC0080c());
        this.f4661c.setOnClickListener(new d());
        com.aggmoread.sdk.z.b.p.a.a(this.f4666h.f4505a, null, new e());
    }

    private View a(Context context) {
        a aVar = new a(context);
        aVar.setBackgroundColor(-1);
        int a10 = com.aggmoread.sdk.z.b.m.b.a(context, 10.0d);
        aVar.setPadding(a10, a10, a10, a10);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, com.aggmoread.sdk.z.b.m.b.a(context, 90.0d)));
        this.f4664f = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        layoutParams.rightMargin = a10;
        this.f4664f.setLayoutParams(layoutParams);
        this.f4664f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(this.f4664f);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.leftMargin = a10;
        relativeLayout.setLayoutParams(layoutParams2);
        this.f4660b = new TextView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(10);
        layoutParams3.rightMargin = com.aggmoread.sdk.z.b.m.b.a(context, 15.0d);
        this.f4660b.setLayoutParams(layoutParams3);
        this.f4660b.setMaxLines(2);
        this.f4660b.setTextSize(15.0f);
        TextView textView = this.f4660b;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        this.f4660b.setTextColor(-16777216);
        this.f4660b.setText("广告详细信息广告详细信息广告详细信息广告详细信息广告详细信息");
        relativeLayout.addView(this.f4660b);
        this.f4659a = new TextView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(12);
        layoutParams4.rightMargin = com.aggmoread.sdk.z.b.m.b.a(context, 30.0d);
        this.f4659a.setLayoutParams(layoutParams4);
        this.f4659a.setMaxLines(1);
        this.f4659a.setTextSize(13.0f);
        this.f4659a.setEllipsize(truncateAt);
        this.f4659a.setTextColor(Color.parseColor("#8a8a8a"));
        this.f4659a.setText("广告标题信息广告标题信息");
        relativeLayout.addView(this.f4659a);
        linearLayout.addView(relativeLayout);
        aVar.addView(linearLayout);
        this.f4661c = new ImageView(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(context, 16.0d), com.aggmoread.sdk.z.b.m.b.a(context, 16.0d));
        layoutParams5.gravity = 85;
        this.f4661c.setLayoutParams(layoutParams5);
        com.aggmoread.sdk.z.b.m.j.a(this.f4661c, "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAe9JREFUOE+lk79rVEEQx2du94GdhYlgdxCbiNjGJipJIYIIASuxiNhoYSnHO3Yfw5vlHsHKykpiYZeQgAiSIuKPJoJYKGIViFUK9Q+Q9+ZG97g9ngeK6LYz82H3O59F+M+D0/NE1BWR2wAwDwCXxvVnAPDJGPOAiA7aM78AvPerAPAQEa/Wdf2qqqpvsTnP82NZlp1T1U0AuMnMjxJkAvDeL6rqcgiB/vQq5xwh4i4zv459IwARzYjIITNnzrklAPgcQthvg/I8P2WMOR5CeOG9r40xJ4jo6wjgvb+nqi9DCE/7/f5pY8wHVT2ZIM65OQDYQsRrzPzROXcZEc8z890E2Gma5npVVV8isA2x1n4XkS0RuTUYDN6NM5m11j5m5osJ0DCzbV+5BXlrrb1DRHvtuvd+NJMAdXx/u6HX6x3NsmwHERfaz0k9MYc4kwBPmqa5kdZGREdEZBMR7zdNczidSVyrtXadma8kwBoi7pVluU1EHRHZUNX1GOp0JjHYoihWVPUsM/fSGrvD4XC/LEvjnLsAADMhhCjN5MRMrLXzZVluFEUhnU5nLlrZFmlVVbt/KdJBsnFa5UUAeK6qKyLyJq01z/NZY8wCIm4DwFKycGJi+6pjK3s/xTkDAMvj2i4AvDfGrEX7fvuZ/uVn/wBrwwgg6o7CmAAAAABJRU5ErkJggg==");
        aVar.addView(this.f4661c);
        return aVar;
    }

    public void d() {
        this.f4669k = true;
        n.a().post(new g());
    }

    public void f() {
        n.a().post(new j());
    }

    public void g() {
        View view = this.f4665g;
        if (view == null || this.f4662d == null) {
            return;
        }
        view.getViewTreeObserver().removeOnScrollChangedListener(this.f4662d);
        this.f4662d = null;
    }

    public void a(View view) {
        if (this.f4668j.get() || !com.aggmoread.sdk.z.b.m.b.a(view)) {
            return;
        }
        view.getViewTreeObserver().removeOnScrollChangedListener(this.f4662d);
        this.f4668j.set(true);
        n.a().post(new h());
    }

    public void a(com.aggmoread.sdk.z.b.g.g gVar) {
        this.f4666h = gVar;
    }

    public void a(k kVar) {
        this.f4667i = kVar;
    }

    public void a(String str) {
        n.a().post(new f(str));
    }
}
