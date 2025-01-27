package b.d.e.c.c.c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.d.e.c.a.j.a;
import b.d.e.c.a.l.a;
import b.d.e.c.a.l.g;
import b.d.e.c.c.a.a;
import b.d.e.c.c.d.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.a.k.j;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.a.q.a;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.ic.dm.Constants;
import java.util.List;

/* loaded from: classes4.dex */
public class a implements b.d.e.c.a.a {

    /* renamed from: a */
    private b.d.e.c.c.a.a f4749a;

    /* renamed from: b */
    private b.d.e.c.a.l.c f4750b;

    /* renamed from: c */
    private a.C0038a.C0039a f4751c;

    /* renamed from: d */
    private b.d.e.c.a.l.a f4752d;

    /* renamed from: e */
    private Activity f4753e;

    /* renamed from: f */
    private Context f4754f;

    /* renamed from: g */
    private View f4755g;

    /* renamed from: h */
    private ImageView f4756h;

    /* renamed from: i */
    private ViewGroup f4757i;

    /* renamed from: j */
    private View f4758j;
    private ImageView k;
    private View l;
    private String n;
    private b.d.e.c.c.d.a o;
    private boolean p;
    private byte[] r;
    private boolean m = false;
    private boolean q = false;
    private b.d.e.c.a.l.g s = null;
    private a.b t = new i();

    /* renamed from: b.d.e.c.c.c.a$a */
    class C0044a implements a.g {

        /* renamed from: a */
        final /* synthetic */ b.d.e.c.a.l.c f4759a;

        /* renamed from: b */
        final /* synthetic */ b.d.e.c.c.a.a f4760b;

        /* renamed from: b.d.e.c.c.c.a$a$a */
        class RunnableC0045a implements Runnable {
            RunnableC0045a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0044a c0044a = C0044a.this;
                b.d.e.c.a.l.c cVar = c0044a.f4759a;
                if (cVar instanceof b.d.e.c.a.l.d) {
                    ((b.d.e.c.a.l.d) cVar).l(a.this);
                }
            }
        }

        C0044a(b.d.e.c.a.l.c cVar, b.d.e.c.c.a.a aVar) {
            this.f4759a = cVar;
            this.f4760b = aVar;
        }

        @Override // b.d.e.c.a.j.a.g
        public void a(int i2, byte[] bArr, b.d.e.c.a.f.e eVar) {
            if (eVar != null) {
                b.d.e.c.a.l.b.c(this.f4759a, b.d.e.c.a.f.e.f4606c);
                return;
            }
            a.this.r = bArr;
            if (a.this.r == null) {
                b.d.e.c.a.l.b.c(this.f4759a, b.d.e.c.a.f.e.f4606c);
                return;
            }
            n.a().post(new RunnableC0045a());
            if (this.f4760b.i().y()) {
                a.this.m = true;
            } else {
                a aVar = a.this;
                aVar.g(aVar.f4757i, a.this.f4758j);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f4763a;

        /* renamed from: b */
        final /* synthetic */ View f4764b;

        /* renamed from: b.d.e.c.c.c.a$b$a */
        class RunnableC0046a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f4766a;

            RunnableC0046a(Bitmap bitmap) {
                this.f4766a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f4749a.i().y() && (a.this.f4750b instanceof b.d.e.c.a.l.d)) {
                    ((b.d.e.c.a.l.d) a.this.f4750b).l(a.this);
                }
                a aVar = a.this;
                Bitmap bitmap = this.f4766a;
                ImageView imageView = aVar.f4756h;
                b bVar = b.this;
                aVar.d(bitmap, imageView, bVar.f4763a, bVar.f4764b);
            }
        }

        b(ViewGroup viewGroup, View view) {
            this.f4763a = viewGroup;
            this.f4764b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.f4763a;
            if (viewGroup == null) {
                b.d.e.c.a.l.b.c(a.this.f4750b, b.d.e.c.a.f.e.f4605b);
                return;
            }
            int width = viewGroup.getWidth();
            int height = this.f4763a.getHeight();
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "adcontainer w = " + width + " , h = " + height);
            n.a().post(new RunnableC0046a(b.d.e.c.a.i.a.d().c(width, height, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, a.this.r)));
        }
    }

    class c implements a.InterfaceC0031a {

        /* renamed from: b.d.e.c.c.c.a$c$a */
        class C0047a implements Handler.Callback {
            C0047a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                a.this.v();
                return false;
            }
        }

        c() {
        }

        @Override // b.d.e.c.a.l.a.InterfaceC0031a
        public void a(View view, b.d.e.c.a.f.c cVar) {
            List<String> b2;
            b.d.e.c.a.f.c a2;
            String str;
            a.this.c();
            a.this.t();
            if (a.this.f4751c.f4720e != null && !TextUtils.isEmpty(a.this.f4751c.f4720e)) {
                Intent intent = new Intent();
                try {
                    intent.setData(Uri.parse(a.this.f4751c.f4720e));
                    a.this.f4749a.i().n().startActivity(intent);
                    b.d.e.c.a.k.a.c("onStartAppSuccess", a.this.f4751c.b(3), a.this.f4752d.a());
                    new Handler(new C0047a()).sendEmptyMessageDelayed(0, 1000L);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (e2 instanceof ActivityNotFoundException) {
                        b2 = a.this.f4751c.b(0);
                        a2 = a.this.f4752d.a();
                        str = "onAppNotExist";
                    } else {
                        b2 = a.this.f4751c.b(2);
                        a2 = a.this.f4752d.a();
                        str = "onStartAppFailed";
                    }
                    b.d.e.c.a.k.a.c(str, b2, a2);
                    b.d.e.c.a.d.k("ApiSplashHandler_dsp", str);
                }
            }
            if (!a.this.f4751c.d()) {
                a.this.E();
                return;
            }
            if (TextUtils.isEmpty(a.this.f4751c.p)) {
                a.this.o();
                return;
            }
            if (a.this.o == null) {
                b.d.e.c.a.d.k("ApiSplashHandler_dsp", "DL s");
                a aVar = a.this;
                aVar.o = new b.d.e.c.c.d.a(aVar.t);
                a.this.o.e(a.this.f4753e, a.this.f4751c.p);
            }
            a.this.o.d(a.this.f4753e, a.this.f4758j);
        }
    }

    class d implements a.InterfaceC0286a {
        d() {
        }

        @Override // com.martian.ttbook.b.a.q.a.InterfaceC0286a
        public void onShow() {
            a.this.v();
        }
    }

    class e implements Handler.Callback {
        e() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            a.this.v();
            return false;
        }
    }

    class f extends com.martian.ttbook.b.a.i.c {
        f() {
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void a() {
            super.a();
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "apkIsDownLoading  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void b(long j2) {
            super.b(j2);
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "onApkInstalled  ");
            b.d.e.c.a.k.a.c("onApkInstalled", a.this.f4751c.o, a.this.f4752d.a());
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void c(long j2, int i2, String str) {
            super.c(j2, i2, str);
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "onApkInstalledError  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void d() {
            super.d();
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "onStartDownload  ");
            b.d.e.c.a.k.a.c("onStartDownload", a.this.f4751c.f4725j, a.this.f4752d.a());
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void e(long j2) {
            super.e(j2);
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "onDownloadSuccess  ");
            b.d.e.c.a.k.a.c("onDownloadCompleted", a.this.f4751c.n, a.this.f4752d.a());
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void f(long j2, int i2, String str) {
            super.f(j2, i2, str);
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "onDownloadFail  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void g(long j2) {
            super.g(j2);
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "onStartApkInstaller  ");
            b.d.e.c.a.k.a.c("onStartApkInstaller", a.this.f4751c.k, a.this.f4752d.a());
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect bounds = a.this.f4756h.getDrawable().getBounds();
            int width = bounds.width();
            int height = bounds.height();
            if (width <= 1 || height <= 1) {
                a.this.f4750b.b(b.d.e.c.a.f.e.f4607d);
                return;
            }
            a.this.c();
            if (a.this.f4750b instanceof b.d.e.c.a.l.d) {
                ((b.d.e.c.a.l.d) a.this.f4750b).onAdSkip();
            }
            a.this.v();
        }
    }

    class h implements g.a {
        h() {
        }

        @Override // b.d.e.c.a.l.g.a
        public void a() {
            a.this.v();
        }

        @Override // b.d.e.c.a.l.g.a
        public void a(long j2) {
            if (a.this.f4750b instanceof b.d.e.c.a.l.d) {
                ((b.d.e.c.a.l.d) a.this.f4750b).onAdTick(j2);
            }
        }
    }

    class i implements a.b {

        /* renamed from: b.d.e.c.c.c.a$i$a */
        class RunnableC0048a implements Runnable {
            RunnableC0048a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.v();
            }
        }

        i() {
        }

        @Override // b.d.e.c.c.d.a.b
        public void d() {
            a.this.p = true;
        }

        @Override // b.d.e.c.c.d.a.b
        public void e() {
            a.this.o();
        }

        @Override // b.d.e.c.c.d.a.b
        public void f() {
            if (a.this.o != null) {
                a.this.o.c();
                a.this.o = null;
            }
            n.a().postDelayed(new RunnableC0048a(), 1000L);
        }
    }

    public void E() {
        String str = this.f4751c.f4719d;
        if (TextUtils.isEmpty(str)) {
            b.d.e.c.c.b.a.a(this.f4750b, b.d.e.c.a.f.e.f4608e);
            return;
        }
        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "startWebActivity = " + str);
        String a2 = b.d.e.c.a.k.a.a(str, this.f4752d.a());
        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "startWebActivity final = " + a2);
        com.martian.ttbook.b.a.q.a.a(this.f4753e, this.f4751c.f4716a, a2, new d());
    }

    public void c() {
        b.d.e.c.a.l.g gVar = this.s;
        if (gVar != null) {
            gVar.cancel();
            this.s = null;
        }
    }

    public void d(Bitmap bitmap, ImageView imageView, ViewGroup viewGroup, View view) {
        View view2;
        View view3;
        b.d.e.c.a.l.c cVar;
        b.d.e.c.a.f.e eVar;
        Context context;
        if (bitmap == null) {
            cVar = this.f4750b;
            eVar = b.d.e.c.a.f.e.f4606c;
        } else {
            if (this.f4753e == null && (context = viewGroup.getContext()) != null && (context instanceof Activity)) {
                this.f4753e = (Activity) context;
            }
            if (!TextUtils.isEmpty(this.f4751c.p)) {
                b.d.e.c.c.d.a aVar = new b.d.e.c.c.d.a(this.t);
                this.o = aVar;
                aVar.e(this.f4753e, this.f4751c.p);
            }
            if (!com.martian.ttbook.b.a.k.a.a(this.f4753e)) {
                if (!com.martian.ttbook.b.a.k.b.d(viewGroup)) {
                    b.d.e.c.c.b.a.a(this.f4750b, b.d.e.c.a.f.e.f4604a);
                    return;
                }
                b.d.e.c.a.d.k("ApiSplashHandler_dsp", "isDownload = " + this.f4751c.d() + " , interaction_type = " + this.f4751c.f4723h + " , downloadUrl = " + this.f4751c.a());
                if (!TextUtils.isEmpty(this.f4751c.p) && (view3 = this.l) != null) {
                    view3.setVisibility(0);
                    view2 = this.l;
                    imageView.setClickable(false);
                    if (this.q) {
                        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "CKT");
                    }
                    this.f4752d = b.d.e.c.a.l.a.b(view2, new c());
                    imageView.setImageBitmap(bitmap);
                    if (this.k != null && this.f4749a.i().x()) {
                        this.k.setVisibility(0);
                    }
                    e(view);
                    return;
                }
                view2 = imageView;
                this.f4752d = b.d.e.c.a.l.a.b(view2, new c());
                imageView.setImageBitmap(bitmap);
                if (this.k != null) {
                    this.k.setVisibility(0);
                }
                e(view);
                return;
            }
            cVar = this.f4750b;
            eVar = b.d.e.c.a.f.e.f4604a;
        }
        b.d.e.c.c.b.a.a(cVar, eVar);
    }

    private void e(View view) {
        z();
        w();
        com.martian.ttbook.b.b.b.a i2 = this.f4749a.i();
        if (i2.s() == null) {
            this.f4755g.setVisibility(0);
        } else {
            this.f4755g = i2.s();
        }
        this.f4755g.setOnClickListener(new g());
        b.d.e.c.a.l.g gVar = new b.d.e.c.a.l.g(this.f4755g, new h(), 5200L, 500L);
        this.s = gVar;
        gVar.start();
    }

    private void f(ViewGroup viewGroup) {
        if (this.f4754f != null) {
            FrameLayout frameLayout = new FrameLayout(this.f4754f);
            frameLayout.setBackgroundColor(Color.parseColor("#99ffdd"));
            if (viewGroup != null) {
                viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            ImageView imageView = new ImageView(this.f4754f);
            imageView.setBackgroundColor(Color.parseColor("#Afd1df"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(this.f4754f);
            TextView textView = new TextView(this.f4754f);
            j.f(textView, this.f4754f, 140, 140, 140, 140, 6);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText("跳过");
            textView.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(com.martian.ttbook.b.a.k.b.b(this.f4754f, 84.0d), com.martian.ttbook.b.a.k.b.b(this.f4754f, 34.0d));
            marginLayoutParams.topMargin = com.martian.ttbook.b.a.k.b.b(this.f4754f, 16.0d);
            marginLayoutParams.rightMargin = com.martian.ttbook.b.a.k.b.b(this.f4754f, 6.0d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
            layoutParams.gravity = 5;
            frameLayout2.addView(textView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 8388613;
            frameLayout.addView(frameLayout2, layoutParams2);
            ImageView imageView2 = new ImageView(this.f4754f);
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
            FrameLayout frameLayout3 = new FrameLayout(this.f4754f);
            RelativeLayout relativeLayout = new RelativeLayout(this.f4754f);
            int b2 = com.martian.ttbook.b.a.k.b.b(this.f4754f, 11.0d);
            relativeLayout.setPadding(b2, b2, b2, b2);
            j.f(relativeLayout, this.f4754f, 136, 20, 20, 20, 90);
            frameLayout3.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(this.f4754f);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            relativeLayout.addView(linearLayout, layoutParams4);
            TextView textView2 = new TextView(this.f4754f);
            textView2.setText("点击跳转详情页或第三方应用");
            textView2.setTextSize(17.0f);
            textView2.setTextColor(-1);
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            ImageView imageView3 = new ImageView(this.f4754f);
            j.g(imageView3, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAA1ElEQVRYR9XXwQ3CMAyF4ecJ6ChsACMwAkwGTMAIsJlRpBx6In7xsyJybZX/kw+ualh8bHEf/wFw9yuAk5nd1BMbTsDdLwBePfxQIyKAI4APgEMFYghoUXcvQ4QAlYgwoApBASoQNECNmAIoEdMAFSIFUCDSgCxCAsgg1IA3gK2v7KeZtY/YzyMB9FVNx5ssDcjE04BsPAVQxKcBqvgUQBmnAeo4BaiIhwFV8RCgMh4FtHV6Z9braP3un4c2Yf8xOUd2OxMPTYC9kH0/NAH2Uub95YAvfduAIVC/ymAAAAAASUVORK5CYII=");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(com.martian.ttbook.b.a.k.b.b(this.f4754f, 20.0d), com.martian.ttbook.b.a.k.b.b(this.f4754f, 20.0d));
            marginLayoutParams2.leftMargin = com.martian.ttbook.b.a.k.b.b(this.f4754f, 5.0d);
            linearLayout.addView(imageView3, new LinearLayout.LayoutParams(marginLayoutParams2));
            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams3.leftMargin = com.martian.ttbook.b.a.k.b.b(this.f4754f, 30.0d);
            marginLayoutParams3.rightMargin = com.martian.ttbook.b.a.k.b.b(this.f4754f, 30.0d);
            marginLayoutParams3.bottomMargin = com.martian.ttbook.b.a.k.b.b(this.f4754f, 25.0d);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(marginLayoutParams3);
            layoutParams5.gravity = 80;
            frameLayout.addView(frameLayout3, layoutParams5);
            this.f4758j = frameLayout;
            this.f4756h = imageView;
            this.k = imageView2;
            imageView2.setVisibility(8);
            this.f4755g = textView;
            this.l = frameLayout3;
        }
    }

    public void g(ViewGroup viewGroup, View view) {
        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "showAD enter");
        n.b(new b(viewGroup, view));
    }

    private void k(String str) {
        try {
            a.C0038a.C0039a c0039a = this.f4751c;
            new com.martian.ttbook.b.a.i.b(this.f4754f.getApplicationContext(), this.f4749a.i().u(), new f()).g(str, c0039a.f4724i, c0039a.f4716a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void o() {
        Intent a2;
        Context a3 = com.martian.ttbook.b.a.g.a.f().a();
        String str = this.f4751c.f4724i;
        if (!com.martian.ttbook.b.a.k.d.d(a3, str) || (a2 = com.martian.ttbook.b.a.k.d.a(a3, str)) == null) {
            q(this.f4751c.a());
            return;
        }
        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "intent = " + a2);
        a2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        a3.startActivity(a2);
    }

    private void q(String str) {
        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "DL");
        k(str);
        new Handler(new e()).sendEmptyMessageDelayed(0, 1000L);
    }

    public void t() {
        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "onAdClick = " + this.f4752d.a());
        b.d.e.c.a.k.a.c(IAdInterListener.AdCommandType.AD_CLICK, this.f4751c.m, this.f4752d.a());
        this.f4750b.onAdClicked();
    }

    public void v() {
        this.f4750b.onAdDismissed();
    }

    private void w() {
        b.d.e.c.a.k.a.d("onAdExposure", this.f4751c.l);
        this.f4750b.onAdExposure();
    }

    private void z() {
        this.f4750b.onAdShow();
    }

    public boolean B() {
        if (!this.f4749a.i().y() || !this.m) {
            return false;
        }
        D();
        return true;
    }

    public void D() {
        g(this.f4757i, this.f4758j);
    }

    @Override // b.d.e.c.a.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f4749a.i().y()) {
            return false;
        }
        if (viewGroup != null) {
            View view = this.f4757i;
            if (view == null) {
                view = this.f4758j;
            }
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "show add adContainer tmpView = " + view);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f4757i = viewGroup;
            this.f4753e = activity;
        }
        return B();
    }

    public void h(b.d.e.c.c.a.a aVar, b.d.e.c.a.l.c cVar) {
        b.d.e.c.a.d.k("ApiSplashHandler_dsp", "handle   enter");
        this.f4749a = aVar;
        this.f4750b = cVar;
        this.f4753e = aVar.i().n();
        this.f4754f = aVar.i().v();
        a.C0038a.C0039a a2 = aVar.f4714e.a();
        if (a2 != null) {
            this.f4751c = a2;
            this.n = a2.c();
            a2.a();
            b.d.e.c.a.d.k("ApiSplashHandler_dsp", "imageUrl = " + this.n);
            com.martian.ttbook.b.a.i.g.a(this.n);
            if (!TextUtils.isEmpty(this.n)) {
                ViewGroup r = aVar.i().r();
                this.f4757i = r;
                f(r);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                b.d.e.c.a.j.a.b(this.n, null, new C0044a(cVar, aVar));
                return;
            }
        }
        b.d.e.c.c.b.a.a(cVar, new b.d.e.c.a.f.e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, "广告数据异常"));
    }
}
