package b.d.e.c.a.l;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.d.e.c.a.f.b;
import b.d.e.c.a.j.a;
import b.d.e.c.a.l.a;
import b.d.e.c.a.l.f;
import b.d.e.c.a.l.g;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.a.k.j;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.a.q.a;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.ic.dm.Constants;
import java.util.List;

/* loaded from: classes4.dex */
public class e implements b.d.e.c.a.a {

    /* renamed from: a */
    private b.d.e.c.a.f.b f4682a;

    /* renamed from: b */
    private b.d.e.c.a.l.c f4683b;

    /* renamed from: c */
    private b.a.C0022a f4684c;

    /* renamed from: d */
    private b.d.e.c.a.l.a f4685d;

    /* renamed from: e */
    private Activity f4686e;

    /* renamed from: f */
    private Context f4687f;

    /* renamed from: g */
    private View f4688g;

    /* renamed from: h */
    private ViewGroup f4689h;

    /* renamed from: i */
    private ImageView f4690i;

    /* renamed from: j */
    private View f4691j;
    private ImageView k;
    private String m;
    private byte[] n;
    private boolean l = false;
    private b.d.e.c.a.l.g o = null;

    class a implements a.g {

        /* renamed from: a */
        final /* synthetic */ b.d.e.c.a.l.c f4692a;

        /* renamed from: b */
        final /* synthetic */ b.d.e.c.a.f.b f4693b;

        /* renamed from: b.d.e.c.a.l.e$a$a */
        class RunnableC0035a implements Runnable {
            RunnableC0035a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                b.d.e.c.a.l.c cVar = aVar.f4692a;
                if (cVar instanceof b.d.e.c.a.l.d) {
                    ((b.d.e.c.a.l.d) cVar).l(e.this);
                }
            }
        }

        a(b.d.e.c.a.l.c cVar, b.d.e.c.a.f.b bVar) {
            this.f4692a = cVar;
            this.f4693b = bVar;
        }

        @Override // b.d.e.c.a.j.a.g
        public void a(int i2, byte[] bArr, b.d.e.c.a.f.e eVar) {
            if (eVar != null) {
                b.d.e.c.a.l.b.c(this.f4692a, b.d.e.c.a.f.e.f4606c);
                return;
            }
            e.this.n = bArr;
            if (e.this.n == null) {
                b.d.e.c.a.l.b.c(this.f4692a, b.d.e.c.a.f.e.f4606c);
                return;
            }
            n.a().post(new RunnableC0035a());
            if (this.f4693b.k().A()) {
                e.this.l = true;
            } else {
                e eVar2 = e.this;
                eVar2.f(eVar2.f4690i, e.this.f4689h, e.this.f4691j);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f4696a;

        /* renamed from: b */
        final /* synthetic */ ImageView f4697b;

        /* renamed from: c */
        final /* synthetic */ View f4698c;

        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f4700a;

            a(Bitmap bitmap) {
                this.f4700a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!e.this.f4682a.k().A() && (e.this.f4683b instanceof b.d.e.c.a.l.d)) {
                    ((b.d.e.c.a.l.d) e.this.f4683b).l(e.this);
                }
                b bVar = b.this;
                e.this.c(this.f4700a, bVar.f4697b, bVar.f4696a, bVar.f4698c);
            }
        }

        b(ViewGroup viewGroup, ImageView imageView, View view) {
            this.f4696a = viewGroup;
            this.f4697b = imageView;
            this.f4698c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.f4696a;
            if (viewGroup == null) {
                b.d.e.c.a.l.b.c(e.this.f4683b, b.d.e.c.a.f.e.f4605b);
                return;
            }
            int width = viewGroup.getWidth();
            int height = this.f4696a.getHeight();
            b.d.e.c.a.d.k("ApiSplashHandler_api", "adcontainer w = " + width + " , h = " + height);
            n.a().post(new a(b.d.e.c.a.i.a.d().c(width, height, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, e.this.n)));
        }
    }

    class c implements a.InterfaceC0031a {

        class a implements Handler.Callback {
            a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                e.this.r();
                return false;
            }
        }

        class b extends f.a {
            b(c cVar, b.d.e.c.a.f.c cVar2) {
            }
        }

        /* renamed from: b.d.e.c.a.l.e$c$c */
        class C0036c implements Handler.Callback {
            C0036c() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                e.this.r();
                return false;
            }
        }

        c() {
        }

        @Override // b.d.e.c.a.l.a.InterfaceC0031a
        public void a(View view, b.d.e.c.a.f.c cVar) {
            Intent a2;
            List<String> b2;
            b.d.e.c.a.f.c a3;
            String str;
            e.this.b();
            e.this.o();
            if (e.this.f4684c.f4573d != null && !TextUtils.isEmpty(e.this.f4684c.f4573d)) {
                List<b.a.C0022a.C0023a> a4 = e.this.f4684c.a();
                if (a4 != null) {
                    b.d.e.c.a.d.k("ApiSplashHandler_api", "deepLinkTracks = " + a4.toString());
                }
                Intent intent = new Intent();
                intent.setData(Uri.parse(e.this.f4684c.f4573d));
                try {
                    e.this.f4686e.startActivity(intent);
                    b.d.e.c.a.k.a.c("onStartAppSuccess", e.this.f4684c.b(3), e.this.f4685d.a());
                    new Handler(new a()).sendEmptyMessageDelayed(0, 1000L);
                    return;
                } catch (Exception e2) {
                    b.d.e.c.a.d.f("ApiSplashHandler_api", "ck e %s", e2);
                    if (e2 instanceof ActivityNotFoundException) {
                        b2 = e.this.f4684c.b(0);
                        a3 = e.this.f4685d.a();
                        str = "onAppNotExist";
                    } else {
                        b2 = e.this.f4684c.b(2);
                        a3 = e.this.f4685d.a();
                        str = "onStartAppFailed";
                    }
                    b.d.e.c.a.k.a.c(str, b2, a3);
                    b.d.e.c.a.d.k("ApiSplashHandler_api", str);
                }
            }
            if (!e.this.f4684c.P()) {
                e.this.B();
                return;
            }
            Context a5 = com.martian.ttbook.b.a.g.a.f().a();
            String L = e.this.f4684c.L();
            if (com.martian.ttbook.b.a.k.d.d(a5, L) && (a2 = com.martian.ttbook.b.a.k.d.a(a5, L)) != null) {
                b.d.e.c.a.d.k("ApiSplashHandler_api", "intent = " + a2);
                a2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                a5.startActivity(a2);
                return;
            }
            if (e.this.f4684c.z() != 2) {
                e eVar = e.this;
                eVar.k(eVar.f4684c.D());
                new Handler(new C0036c()).sendEmptyMessageDelayed(0, 1000L);
            } else {
                String a6 = b.d.e.c.a.k.a.a(e.this.f4684c.r(), e.this.f4685d.a());
                b.d.e.c.a.d.k("ApiSplashHandler_api", "rClickUrl = " + a6);
                b.d.e.c.a.l.f.a(a6, new b(this, cVar));
            }
        }
    }

    class d implements a.InterfaceC0286a {
        d() {
        }

        @Override // com.martian.ttbook.b.a.q.a.InterfaceC0286a
        public void onShow() {
            e.this.r();
        }
    }

    /* renamed from: b.d.e.c.a.l.e$e */
    class C0037e extends com.martian.ttbook.b.a.i.c {
        C0037e() {
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void a() {
            super.a();
            b.d.e.c.a.d.k("ApiSplashHandler_api", "apkIsDownLoading  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void b(long j2) {
            super.b(j2);
            b.d.e.c.a.d.k("ApiSplashHandler_api", "onApkInstalled  ");
            b.d.e.c.a.k.a.c("onApkInstalled", e.this.f4684c.n(), e.this.f4685d.a());
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void c(long j2, int i2, String str) {
            super.c(j2, i2, str);
            b.d.e.c.a.d.k("ApiSplashHandler_api", "onApkInstalledError  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void d() {
            super.d();
            b.d.e.c.a.d.k("ApiSplashHandler_api", "onStartDownload  ");
            b.d.e.c.a.k.a.c("onStartDownload", e.this.f4684c.l, e.this.f4685d.a());
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void e(long j2) {
            super.e(j2);
            b.d.e.c.a.d.k("ApiSplashHandler_api", "onDownloadSuccess  ");
            b.d.e.c.a.k.a.c("onDownloadCompleted", e.this.f4684c.f(), e.this.f4685d.a());
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void f(long j2, int i2, String str) {
            super.f(j2, i2, str);
            b.d.e.c.a.d.k("ApiSplashHandler_api", "onDownloadFail  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void g(long j2) {
            super.g(j2);
            b.d.e.c.a.d.k("ApiSplashHandler_api", "onStartApkInstaller  ");
            b.d.e.c.a.k.a.c("onStartApkInstaller", e.this.f4684c.j(), e.this.f4685d.a());
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect bounds = e.this.f4690i.getDrawable().getBounds();
            int width = bounds.width();
            int height = bounds.height();
            if (width <= 1 || height <= 1) {
                e.this.f4683b.b(b.d.e.c.a.f.e.f4607d);
                return;
            }
            e.this.b();
            if (e.this.f4683b instanceof b.d.e.c.a.l.d) {
                ((b.d.e.c.a.l.d) e.this.f4683b).onAdSkip();
            }
            e.this.r();
        }
    }

    class g implements g.a {
        g() {
        }

        @Override // b.d.e.c.a.l.g.a
        public void a() {
            e.this.r();
        }

        @Override // b.d.e.c.a.l.g.a
        public void a(long j2) {
            if (e.this.f4683b instanceof b.d.e.c.a.l.d) {
                ((b.d.e.c.a.l.d) e.this.f4683b).onAdTick(j2);
            }
        }
    }

    public void B() {
        String str = this.f4684c.f4571b;
        if (TextUtils.isEmpty(str)) {
            b.d.e.c.a.l.b.c(this.f4683b, b.d.e.c.a.f.e.f4608e);
            return;
        }
        b.d.e.c.a.d.k("ApiSplashHandler_api", "startWebActivity = " + str);
        String a2 = b.d.e.c.a.k.a.a(str, this.f4685d.a());
        b.d.e.c.a.d.k("ApiSplashHandler_api", "startWebActivity final = " + a2);
        com.martian.ttbook.b.a.q.a.a(this.f4686e, this.f4684c.f4572c, a2, new d());
    }

    public void b() {
        b.d.e.c.a.l.g gVar = this.o;
        if (gVar != null) {
            gVar.cancel();
            this.o = null;
        }
    }

    public void c(Bitmap bitmap, ImageView imageView, ViewGroup viewGroup, View view) {
        b.d.e.c.a.l.c cVar;
        b.d.e.c.a.f.e eVar;
        Context context;
        if (bitmap == null) {
            cVar = this.f4683b;
            eVar = b.d.e.c.a.f.e.f4606c;
        } else {
            if (this.f4686e == null && (context = viewGroup.getContext()) != null && (context instanceof Activity)) {
                this.f4686e = (Activity) context;
            }
            if (!com.martian.ttbook.b.a.k.a.a(this.f4686e)) {
                if (!com.martian.ttbook.b.a.k.b.d(viewGroup)) {
                    b.d.e.c.a.l.b.c(this.f4683b, b.d.e.c.a.f.e.f4604a);
                    return;
                }
                b.d.e.c.a.d.k("ApiSplashHandler_api", "isDownload = " + this.f4684c.P() + " , downType = " + this.f4684c.z() + " , downloadUrl = " + this.f4684c.D());
                this.f4685d = b.d.e.c.a.l.a.b(imageView, new c());
                imageView.setImageBitmap(bitmap);
                if (this.k != null && this.f4682a.k().z()) {
                    this.k.setVisibility(0);
                }
                d(view);
                return;
            }
            cVar = this.f4683b;
            eVar = b.d.e.c.a.f.e.f4604a;
        }
        b.d.e.c.a.l.b.c(cVar, eVar);
    }

    private void d(View view) {
        v();
        t();
        com.martian.ttbook.b.a.g.c k = this.f4682a.k();
        if (k.t() == null) {
            b.d.e.c.a.d.k("ApiSplashHandler_api", "getAdSkipView = null");
            this.f4688g.setVisibility(0);
        } else {
            this.f4688g = k.t();
        }
        this.f4688g.setOnClickListener(new f());
        b.d.e.c.a.l.g gVar = new b.d.e.c.a.l.g(this.f4688g, new g(), 5200L, 500L);
        this.o = gVar;
        gVar.start();
    }

    private void e(ViewGroup viewGroup) {
        if (this.f4687f != null) {
            FrameLayout frameLayout = new FrameLayout(this.f4687f);
            frameLayout.setBackgroundColor(Color.parseColor("#99ffdd"));
            if (viewGroup != null) {
                viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            }
            ImageView imageView = new ImageView(this.f4687f);
            imageView.setBackgroundColor(Color.parseColor("#Afd1df"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(this.f4687f);
            TextView textView = new TextView(this.f4687f);
            j.f(textView, this.f4687f, 140, 140, 140, 140, 6);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText("跳过");
            textView.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(com.martian.ttbook.b.a.k.b.b(this.f4687f, 84.0d), com.martian.ttbook.b.a.k.b.b(this.f4687f, 34.0d));
            marginLayoutParams.topMargin = com.martian.ttbook.b.a.k.b.b(this.f4687f, 16.0d);
            marginLayoutParams.rightMargin = com.martian.ttbook.b.a.k.b.b(this.f4687f, 6.0d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
            layoutParams.gravity = 5;
            frameLayout2.addView(textView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 8388613;
            frameLayout.addView(frameLayout2, layoutParams2);
            ImageView imageView2 = new ImageView(this.f4687f);
            b.d.e.c.a.f.g g2 = com.martian.ttbook.b.a.g.a.f().g();
            if (g2.f4616b != 0) {
                imageView2.setImageResource(com.martian.ttbook.b.a.g.a.f().g().f4616b);
            } else {
                Bitmap bitmap = g2.f4617c;
                if (bitmap != null) {
                    imageView2.setImageBitmap(bitmap);
                }
            }
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 85;
            frameLayout.addView(imageView2, layoutParams3);
            this.f4691j = frameLayout;
            this.f4690i = imageView;
            this.k = imageView2;
            imageView2.setVisibility(8);
            this.f4688g = textView;
        }
    }

    public void f(ImageView imageView, ViewGroup viewGroup, View view) {
        b.d.e.c.a.d.k("ApiSplashHandler_api", "showAD enter");
        n.b(new b(viewGroup, imageView, view));
    }

    public void k(String str) {
        try {
            b.a.C0022a c0022a = this.f4684c;
            new com.martian.ttbook.b.a.i.b(this.f4682a.k().r().getApplicationContext(), this.f4682a.k().v(), new C0037e()).g(str, c0022a.f4570a, c0022a.f4572c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void o() {
        b.d.e.c.a.d.k("ApiSplashHandler_api", "onAdClick = " + this.f4685d.a());
        b.d.e.c.a.k.a.c(IAdInterListener.AdCommandType.AD_CLICK, this.f4684c.N(), this.f4685d.a());
        this.f4683b.onAdClicked();
    }

    public void r() {
        this.f4683b.onAdDismissed();
    }

    private void t() {
        b.d.e.c.a.k.a.d("onAdExposure", this.f4684c.O());
        this.f4683b.onAdExposure();
    }

    private void v() {
        this.f4683b.onAdShow();
    }

    @Override // b.d.e.c.a.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f4682a.k().A()) {
            return false;
        }
        if (viewGroup != null) {
            View view = this.f4689h;
            if (view == null) {
                view = this.f4691j;
            }
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            b.d.e.c.a.d.k("ApiSplashHandler_api", "show add adContainer tmpView = " + view);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f4689h = viewGroup;
            this.f4686e = activity;
        }
        return x();
    }

    public void g(b.d.e.c.a.f.b bVar, b.d.e.c.a.l.c cVar) {
        b.d.e.c.a.d.k("ApiSplashHandler_api", "handle enter");
        this.f4682a = bVar;
        this.f4683b = cVar;
        this.f4686e = bVar.k().r();
        this.f4687f = bVar.k().w();
        b.a.C0022a a2 = bVar.f4568e.get(0).a();
        if (a2 != null) {
            this.f4684c = a2;
            this.m = a2.G();
            a2.D();
            b.d.e.c.a.d.k("ApiSplashHandler_api", "imageUrl = " + this.m);
            com.martian.ttbook.b.a.i.g.a(this.m);
            if (!TextUtils.isEmpty(this.m)) {
                ViewGroup s = bVar.k().s();
                this.f4689h = s;
                e(s);
                b.d.e.c.a.d.k("ApiSplashHandler_api", "imageView = " + this.f4690i);
                b.d.e.c.a.j.a.b(this.m, null, new a(cVar, bVar));
                return;
            }
        }
        b.d.e.c.a.l.b.c(cVar, new b.d.e.c.a.f.e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, "广告数据异常"));
    }

    public boolean x() {
        if (!this.f4682a.k().A() || !this.l) {
            return false;
        }
        y();
        return true;
    }

    public void y() {
        f(this.f4690i, this.f4689h, this.f4691j);
    }
}
