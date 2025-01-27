package com.aggmoread.sdk.z.b.s;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.g.b;
import com.aggmoread.sdk.z.b.m.j;
import com.aggmoread.sdk.z.b.m.l;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.aggmoread.sdk.z.b.s.a;
import com.aggmoread.sdk.z.b.s.i;
import com.aggmoread.sdk.z.b.u.c;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes.dex */
public class g implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.b.g.b f4865a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.s.e f4866b;

    /* renamed from: c */
    private b.a.C0072a f4867c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f4868d;

    /* renamed from: e */
    private Activity f4869e;

    /* renamed from: f */
    private Context f4870f;

    /* renamed from: g */
    private View f4871g;

    /* renamed from: h */
    private ViewGroup f4872h;

    /* renamed from: i */
    private ImageView f4873i;

    /* renamed from: j */
    private View f4874j;

    /* renamed from: k */
    private ImageView f4875k;

    /* renamed from: m */
    private String f4877m;

    /* renamed from: n */
    private byte[] f4878n;

    /* renamed from: l */
    private boolean f4876l = false;

    /* renamed from: o */
    private i f4879o = null;

    public class a implements a.g {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.s.e f4880a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.b.g.b f4881b;

        /* renamed from: com.aggmoread.sdk.z.b.s.g$a$a */
        public class RunnableC0095a implements Runnable {
            public RunnableC0095a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                com.aggmoread.sdk.z.b.s.e eVar = aVar.f4880a;
                if (eVar instanceof f) {
                    ((f) eVar).a(g.this);
                }
            }
        }

        public a(com.aggmoread.sdk.z.b.s.e eVar, com.aggmoread.sdk.z.b.g.b bVar) {
            this.f4880a = eVar;
            this.f4881b = bVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            if (eVar != null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f4880a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            g.this.f4878n = bArr;
            if (g.this.f4878n == null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f4880a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            n.a().post(new RunnableC0095a());
            if (this.f4881b.d().n()) {
                g.this.f4876l = true;
            } else {
                g gVar = g.this;
                gVar.a(gVar.f4873i, g.this.f4872h, g.this.f4874j);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ViewGroup f4884b;

        /* renamed from: c */
        final /* synthetic */ ImageView f4885c;

        /* renamed from: d */
        final /* synthetic */ View f4886d;

        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f4888b;

            public a(Bitmap bitmap) {
                this.f4888b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.f4865a.d().n() && (g.this.f4866b instanceof f)) {
                    ((f) g.this.f4866b).a(g.this);
                }
                b bVar = b.this;
                g.this.a(this.f4888b, bVar.f4885c, bVar.f4884b, bVar.f4886d);
            }
        }

        public b(ViewGroup viewGroup, ImageView imageView, View view) {
            this.f4884b = viewGroup;
            this.f4885c = imageView;
            this.f4886d = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.f4884b;
            if (viewGroup == null) {
                com.aggmoread.sdk.z.b.s.b.a(g.this.f4866b, com.aggmoread.sdk.z.b.g.e.f4494d);
                return;
            }
            int width = viewGroup.getWidth();
            int height = this.f4884b.getHeight();
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "adcontainer w = " + width + " , h = " + height);
            n.a().post(new a(com.aggmoread.sdk.z.b.n.a.a().a(width, height, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, g.this.f4878n)));
        }
    }

    public class c implements a.InterfaceC0091a {

        public class a implements c.a {
            public a() {
            }

            @Override // com.aggmoread.sdk.z.b.u.c.a
            public void onShow() {
                g.this.f();
            }
        }

        public class b implements l.c {

            public class a implements Handler.Callback {
                public a() {
                }

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    g.this.f();
                    return false;
                }
            }

            /* renamed from: com.aggmoread.sdk.z.b.s.g$c$b$b */
            public class C0096b implements Handler.Callback {
                public C0096b() {
                }

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    g.this.f();
                    return false;
                }
            }

            public b() {
            }

            @Override // com.aggmoread.sdk.z.b.m.l.c
            public void a() {
                g.this.f();
            }

            @Override // com.aggmoread.sdk.z.b.m.l.c
            public void b() {
                new Handler(new a()).sendEmptyMessageDelayed(0, 1000L);
            }

            @Override // com.aggmoread.sdk.z.b.m.l.c
            public void c() {
                new Handler(new C0096b()).sendEmptyMessageDelayed(0, 1000L);
            }

            @Override // com.aggmoread.sdk.z.b.m.l.c
            public void d() {
            }

            @Override // com.aggmoread.sdk.z.b.m.l.c
            public void e() {
            }
        }

        public c() {
        }

        @Override // com.aggmoread.sdk.z.b.s.a.InterfaceC0091a
        public void a(View view, com.aggmoread.sdk.z.b.g.c cVar) {
            g.this.a();
            g.this.e();
            l.a(g.this.f4865a, g.this.f4867c, g.this.f4868d.a(), g.this.f4866b, new a(), new b());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect bounds = g.this.f4873i.getDrawable().getBounds();
            int width = bounds.width();
            int height = bounds.height();
            if (width <= 1 || height <= 1) {
                g.this.f4866b.a(com.aggmoread.sdk.z.b.g.e.f4496f);
                return;
            }
            g.this.a();
            if (g.this.f4866b instanceof f) {
                ((f) g.this.f4866b).e();
            }
            g.this.f();
        }
    }

    public class e implements i.a {
        public e() {
        }

        @Override // com.aggmoread.sdk.z.b.s.i.a
        public void a() {
            g.this.f();
        }

        @Override // com.aggmoread.sdk.z.b.s.i.a
        public void a(long j10) {
            if (g.this.f4866b instanceof f) {
                ((f) g.this.f4866b).onAdTick(j10);
            }
        }
    }

    public void a() {
        i iVar = this.f4879o;
        if (iVar != null) {
            iVar.cancel();
            this.f4879o = null;
        }
    }

    public void e() {
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "onAdClick = " + this.f4868d.a());
        com.aggmoread.sdk.z.b.q.a.a(IAdInterListener.AdCommandType.AD_CLICK, this.f4867c.p(), this.f4868d.a());
        this.f4866b.onAdClicked();
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        b.a.C0072a c0072a = this.f4867c;
        if (c0072a != null) {
            return c0072a.n();
        }
        return -1;
    }

    public void a(Bitmap bitmap, ImageView imageView, ViewGroup viewGroup, View view) {
        com.aggmoread.sdk.z.b.s.e eVar;
        com.aggmoread.sdk.z.b.g.e eVar2;
        Context context;
        if (bitmap == null) {
            eVar = this.f4866b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4495e;
        } else {
            if (this.f4869e == null && (context = viewGroup.getContext()) != null && (context instanceof Activity)) {
                this.f4869e = (Activity) context;
            }
            if (!com.aggmoread.sdk.z.b.m.a.a(this.f4869e)) {
                if (!com.aggmoread.sdk.z.b.m.b.a(viewGroup)) {
                    com.aggmoread.sdk.z.b.s.b.a(this.f4866b, com.aggmoread.sdk.z.b.g.e.f4493c);
                    return;
                }
                com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "isDownload = " + this.f4867c.r() + " , downType = " + this.f4867c.h() + " , downloadUrl = " + this.f4867c.i());
                this.f4868d = com.aggmoread.sdk.z.b.s.a.a(imageView, new c());
                imageView.setImageBitmap(bitmap);
                if (this.f4875k != null && this.f4865a.d().m()) {
                    this.f4875k.setVisibility(0);
                }
                a(view);
                return;
            }
            eVar = this.f4866b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4493c;
        }
        com.aggmoread.sdk.z.b.s.b.a(eVar, eVar2);
    }

    public void f() {
        this.f4866b.a();
    }

    private void g() {
        com.aggmoread.sdk.z.b.q.a.a("onAdExposure", this.f4867c.q());
        this.f4866b.d();
    }

    private void h() {
        this.f4866b.onAdShow();
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        if (!this.f4865a.d().n() || !this.f4876l) {
            return false;
        }
        i();
        return true;
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        b.a.C0072a c0072a = this.f4867c;
        if (c0072a != null) {
            return c0072a.a();
        }
        return null;
    }

    public void i() {
        a(this.f4873i, this.f4872h, this.f4874j);
    }

    private void a(View view) {
        h();
        g();
        com.aggmoread.sdk.z.b.h.c d10 = this.f4865a.d();
        if (d10.g() == null) {
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "getAdSkipView = null");
            this.f4871g.setVisibility(0);
        } else {
            this.f4871g = d10.g();
        }
        this.f4871g.setOnClickListener(new d());
        i iVar = new i(this.f4871g, new e(), 5200L, 500L);
        this.f4879o = iVar;
        iVar.start();
    }

    private void a(ViewGroup viewGroup) {
        if (this.f4870f != null) {
            FrameLayout frameLayout = new FrameLayout(this.f4870f);
            frameLayout.setBackgroundColor(Color.parseColor("#99ffdd"));
            if (viewGroup != null) {
                viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            }
            ImageView imageView = new ImageView(this.f4870f);
            imageView.setBackgroundColor(Color.parseColor("#Afd1df"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(this.f4870f);
            TextView textView = new TextView(this.f4870f);
            j.a(textView, this.f4870f, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 6);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText("跳过");
            textView.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4870f, 84.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4870f, 34.0d));
            marginLayoutParams.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4870f, 16.0d);
            marginLayoutParams.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4870f, 6.0d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
            layoutParams.gravity = 5;
            frameLayout2.addView(textView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.END;
            frameLayout.addView(frameLayout2, layoutParams2);
            ImageView imageView2 = new ImageView(this.f4870f);
            com.aggmoread.sdk.z.b.g.h e10 = com.aggmoread.sdk.z.b.h.a.d().e();
            if (e10.f4511a != 0) {
                imageView2.setImageResource(com.aggmoread.sdk.z.b.h.a.d().e().f4511a);
            } else {
                Bitmap bitmap = e10.f4512b;
                if (bitmap != null) {
                    imageView2.setImageBitmap(bitmap);
                }
            }
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 85;
            frameLayout.addView(imageView2, layoutParams3);
            this.f4874j = frameLayout;
            this.f4873i = imageView;
            this.f4875k = imageView2;
            imageView2.setVisibility(8);
            this.f4871g = textView;
        }
    }

    public void a(ImageView imageView, ViewGroup viewGroup, View view) {
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "showAD enter");
        n.a(new b(viewGroup, imageView, view));
    }

    public void a(com.aggmoread.sdk.z.b.g.b bVar, com.aggmoread.sdk.z.b.s.e eVar) {
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "handle enter");
        this.f4865a = bVar;
        this.f4866b = eVar;
        this.f4869e = bVar.d().e();
        this.f4870f = bVar.d().j();
        b.a.C0072a a10 = bVar.f4443e.get(0).a();
        if (a10 != null) {
            this.f4867c = a10;
            this.f4877m = a10.j();
            a10.i();
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "imageUrl = " + this.f4877m);
            com.aggmoread.sdk.z.b.j.g.a(this.f4877m);
            if (!TextUtils.isEmpty(this.f4877m)) {
                ViewGroup f10 = bVar.d().f();
                this.f4872h = f10;
                a(f10);
                com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "imageView = " + this.f4873i);
                com.aggmoread.sdk.z.b.p.a.a(this.f4877m, null, new a(eVar, bVar));
                return;
            }
        }
        com.aggmoread.sdk.z.b.s.b.a(eVar, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常"));
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f4865a.d().n()) {
            return false;
        }
        if (viewGroup != null) {
            View view = this.f4872h;
            if (view == null) {
                view = this.f4874j;
            }
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_api", "show add adContainer tmpView = " + view);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f4872h = viewGroup;
            this.f4869e = activity;
        }
        return b();
    }
}
