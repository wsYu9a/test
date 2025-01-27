package com.vivo.ad.view;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import com.martian.libmars.activity.h1;
import com.vivo.ic.webview.NestedScrollWebView;
import com.vivo.ic.webview.WebViewScrollView;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class p extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener {

    /* renamed from: a */
    private com.vivo.ad.model.b f27050a;

    /* renamed from: b */
    private Context f27051b;

    /* renamed from: c */
    private String f27052c;

    /* renamed from: d */
    private h f27053d;

    /* renamed from: e */
    private NestedScrollWebView f27054e;

    /* renamed from: f */
    private View f27055f;

    /* renamed from: g */
    private TextView f27056g;

    /* renamed from: h */
    private TextView f27057h;

    /* renamed from: i */
    private WebViewScrollView f27058i;

    /* renamed from: j */
    private View f27059j;
    private View k;
    private float[] l;
    private float m;
    private LinearLayout n;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.b(false);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.b(true);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.dismiss();
        }
    }

    class d extends WebViewClient {
        d(p pVar) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    }

    class e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ NestedScrollWebView f27063a;

        e(NestedScrollWebView nestedScrollWebView) {
            this.f27063a = nestedScrollWebView;
        }

        @Override // java.lang.Runnable
        public void run() {
            NestedScrollWebView nestedScrollWebView = this.f27063a;
            if (nestedScrollWebView != null) {
                ViewGroup.LayoutParams layoutParams = nestedScrollWebView.getLayoutParams();
                layoutParams.height = com.vivo.mobilead.util.m.b(p.this.getContext(), 800.0f);
                this.f27063a.setLayoutParams(layoutParams);
                p.this.f27058i.smoothScrollTo(0, 800);
                p.this.f27058i.smoothScrollTo(0, 0);
            }
        }
    }

    class f implements NestedScrollWebView.OnOverScrollListener {
        f() {
        }

        @Override // com.vivo.ic.webview.NestedScrollWebView.OnOverScrollListener
        public void onOverScrolled(NestedScrollWebView nestedScrollWebView, boolean z) {
            p.this.f27058i.setIsWebViewOnTop(z);
        }
    }

    class g implements NestedScrollView.OnScrollChangeListener {
        g() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            Rect rect = new Rect();
            p.this.f27058i.getHitRect(rect);
            p.this.f27058i.setIsRecLayoutShow(p.this.n.getLocalVisibleRect(rect));
        }
    }

    public interface h {
        void dismiss();

        void onShow();
    }

    public p(@NonNull Context context, com.vivo.ad.model.b bVar, String str) {
        this(context, 0, bVar, str);
    }

    private View c() {
        ListView listView = new ListView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, com.vivo.mobilead.util.m.b(getContext(), 20.0f), com.vivo.mobilead.util.m.b(getContext(), 10.0f));
        listView.addHeaderView(a());
        com.vivo.ad.b.b bVar = new com.vivo.ad.b.b(this.f27050a.y().n(), getContext());
        listView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        listView.setDividerHeight(0);
        listView.setSelector(R.color.transparent);
        listView.setAdapter((ListAdapter) bVar);
        listView.setLayoutParams(layoutParams);
        return listView;
    }

    private NestedScrollWebView d() {
        NestedScrollWebView nestedScrollWebView = new NestedScrollWebView(getContext());
        WebSettings settings = nestedScrollWebView.getSettings();
        if (settings != null) {
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setLoadWithOverviewMode(true);
        }
        nestedScrollWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        nestedScrollWebView.setWebViewClient(new d(this));
        nestedScrollWebView.post(new e(nestedScrollWebView));
        nestedScrollWebView.setOnOverScrollListener(new f());
        com.vivo.ad.model.b bVar = this.f27050a;
        if (bVar != null && bVar.y() != null) {
            nestedScrollWebView.loadUrl(this.f27050a.y().o());
        }
        return nestedScrollWebView;
    }

    private View e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundDrawable(a(Color.parseColor("#ffffff"), this.l));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int b2 = com.vivo.mobilead.util.m.b(getContext(), 20.0f);
        int b3 = com.vivo.mobilead.util.m.b(getContext(), 23.33f);
        int b4 = com.vivo.mobilead.util.m.b(getContext(), 26.0f);
        int b5 = com.vivo.mobilead.util.m.b(getContext(), 23.33f);
        TextView textView = new TextView(getContext());
        this.f27056g = textView;
        textView.setTextSize(1, 16.0f);
        this.f27056g.setText("隐私政策");
        this.f27056g.setId(View.generateViewId());
        this.f27056g.setTextColor(Color.parseColor("#5C81FF"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = b2;
        layoutParams2.topMargin = b3;
        layoutParams2.bottomMargin = b5;
        layoutParams2.addRule(20);
        relativeLayout.addView(this.f27056g, layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.f27057h = textView2;
        textView2.setText("权限列表");
        this.f27057h.setTextSize(1, 16.0f);
        this.f27057h.setTextColor(Color.parseColor("#000000"));
        this.f27057h.setId(y0.a());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = b2;
        layoutParams3.topMargin = b3;
        layoutParams3.bottomMargin = b5;
        layoutParams3.addRule(1, this.f27056g.getId());
        relativeLayout.addView(this.f27057h, layoutParams3);
        ImageView imageView = new ImageView(getContext());
        imageView.setBackground(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_biz_webview_closebt.png"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.a(getContext(), 25.0f), com.vivo.mobilead.util.m.a(getContext(), 25.0f));
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = b4;
        relativeLayout.addView(imageView, layoutParams4);
        relativeLayout.setId(y0.a());
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        ViewGroup.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        relativeLayout2.addView(relativeLayout, layoutParams);
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#eeeeee"));
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.vivo.mobilead.util.m.b(getContext(), 1.0f));
        layoutParams6.addRule(3, relativeLayout.getId());
        relativeLayout2.addView(view, layoutParams6);
        View view2 = new View(getContext());
        this.f27059j = view2;
        view2.setBackgroundColor(Color.parseColor("#5C81FF"));
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 55.0f), com.vivo.mobilead.util.m.b(getContext(), 1.0f));
        layoutParams7.addRule(3, relativeLayout.getId());
        layoutParams7.leftMargin = com.vivo.mobilead.util.m.b(getContext(), 20.0f);
        relativeLayout2.addView(this.f27059j, layoutParams7);
        View view3 = new View(getContext());
        this.k = view3;
        view3.setBackgroundColor(Color.parseColor("#eeeeee"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 55.0f), com.vivo.mobilead.util.m.b(getContext(), 1.0f));
        layoutParams8.addRule(3, relativeLayout.getId());
        layoutParams8.leftMargin = com.vivo.mobilead.util.m.b(getContext(), 108.0f);
        relativeLayout2.addView(this.k, layoutParams8);
        linearLayout.addView(relativeLayout2, layoutParams5);
        this.f27058i = new WebViewScrollView(getContext());
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.setMargins(com.vivo.mobilead.util.m.b(getContext(), 20.0f), 0, com.vivo.mobilead.util.m.b(getContext(), 8.0f), 0);
        this.f27054e = d();
        this.f27055f = c();
        LinearLayout linearLayout2 = new LinearLayout(this.f27051b);
        linearLayout2.setFocusableInTouchMode(true);
        linearLayout2.setFocusable(true);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(1);
        linearLayout2.addView(b());
        linearLayout2.addView(this.f27054e);
        this.f27058i.addView(linearLayout2, layoutParams10);
        linearLayout.addView(this.f27058i, layoutParams9);
        linearLayout.addView(this.f27055f);
        this.f27056g.setOnClickListener(new a());
        this.f27057h.setOnClickListener(new b());
        imageView.setOnClickListener(new c());
        return linearLayout;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        h hVar = this.f27053d;
        if (hVar != null) {
            hVar.dismiss();
        }
        k0.b(this.f27050a, this.f27052c);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        h hVar = this.f27053d;
        if (hVar != null) {
            hVar.onShow();
        }
        k0.c(this.f27050a, this.f27052c);
    }

    private p(@NonNull Context context, int i2, com.vivo.ad.model.b bVar, String str) {
        super(context, i2);
        this.m = com.vivo.mobilead.util.m.b(getContext(), 20.0f);
        this.f27051b = context;
        this.f27050a = bVar;
        this.f27052c = str;
        requestWindowFeature(1);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.getDecorView().setFitsSystemWindows(true);
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.addFlags(67108864);
        window.addFlags(1024);
        attributes.gravity = 80;
        if (com.vivo.mobilead.util.m.c(context) == 1) {
            attributes.width = -1;
            attributes.height = com.vivo.mobilead.util.m.b(context, 360.0f);
            float f2 = this.m;
            this.l = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        } else {
            attributes.gravity = 5;
            attributes.width = com.vivo.mobilead.util.m.a(getContext(), 360.0f);
            attributes.height = -1;
            float f3 = this.m;
            this.l = new float[]{f3, f3, 0.0f, 0.0f, 0.0f, 0.0f, f3, f3};
            window.getDecorView().setSystemUiVisibility(h1.f9782d);
        }
        window.setBackgroundDrawable(a(0, this.l));
        setContentView(e());
        window.setAttributes(attributes);
        setOnDismissListener(this);
        setOnShowListener(this);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    private View b() {
        this.n = new LinearLayout(getContext());
        this.n.setLayoutParams(new LinearLayout.LayoutParams(-2, com.vivo.mobilead.util.m.b(getContext(), 50.0f)));
        this.n.setGravity(16);
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.vivo.mobilead.util.m.b(getContext(), 8.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        a(textView);
        a(textView2);
        com.vivo.ad.model.b bVar = this.f27050a;
        if (bVar != null && bVar.y() != null) {
            com.vivo.ad.model.q y = this.f27050a.y();
            textView.setText(y.d() + " V" + y.s() + " " + (y.q() / 1024) + "MB");
            textView2.setText(y.g());
        }
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        this.n.addView(linearLayout);
        return this.n;
    }

    public Drawable a(int i2, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    private View a() {
        int b2 = com.vivo.mobilead.util.m.b(getContext(), 20.0f);
        int b3 = com.vivo.mobilead.util.m.b(getContext(), 8.0f);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(b2, b2, b2, b3);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        a(textView);
        a(textView2);
        com.vivo.ad.model.b bVar = this.f27050a;
        if (bVar != null && bVar.y() != null) {
            com.vivo.ad.model.q y = this.f27050a.y();
            textView.setText(y.d() + " V" + y.s() + " " + (y.q() / 1024) + "MB");
            textView2.setText(y.g());
        }
        linearLayout2.addView(textView);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        return linearLayout;
    }

    public void b(boolean z) {
        if (z) {
            this.f27057h.setTextColor(Color.parseColor("#5C81FF"));
            this.f27056g.setTextColor(Color.parseColor("#000000"));
            this.f27055f.setVisibility(0);
            this.f27058i.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setBackgroundColor(Color.parseColor("#5C81FF"));
            this.f27059j.setVisibility(4);
            return;
        }
        this.f27056g.setTextColor(Color.parseColor("#5C81FF"));
        this.f27057h.setTextColor(Color.parseColor("#000000"));
        this.f27055f.setVisibility(8);
        this.f27058i.setVisibility(0);
        this.f27059j.setVisibility(0);
        this.f27059j.setBackgroundColor(Color.parseColor("#5C81FF"));
        this.k.setVisibility(4);
        this.f27058i.setOnScrollChangeListener(new g());
    }

    private void a(TextView textView) {
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setTextSize(1, 11.0f);
    }

    public void a(h hVar) {
        this.f27053d = hVar;
    }

    public void a(boolean z) {
        this.f27058i.setIsRecLayoutShow(true);
        b(z);
        show();
    }
}
