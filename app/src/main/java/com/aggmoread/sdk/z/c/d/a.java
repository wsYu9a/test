package com.aggmoread.sdk.z.c.d;

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
import androidx.core.view.GravityCompat;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.h.a;
import com.aggmoread.sdk.z.b.m.j;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.aggmoread.sdk.z.b.s.a;
import com.aggmoread.sdk.z.b.s.i;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.c.a.a;
import com.aggmoread.sdk.z.c.e.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* loaded from: classes.dex */
public class a implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.c.a.a f5153a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.s.e f5154b;

    /* renamed from: c */
    private a.C0101a.C0102a f5155c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f5156d;

    /* renamed from: e */
    private Activity f5157e;

    /* renamed from: f */
    private Context f5158f;

    /* renamed from: g */
    private View f5159g;

    /* renamed from: h */
    private ImageView f5160h;

    /* renamed from: i */
    private ViewGroup f5161i;

    /* renamed from: j */
    private View f5162j;

    /* renamed from: k */
    private ImageView f5163k;

    /* renamed from: l */
    private View f5164l;

    /* renamed from: n */
    private String f5166n;

    /* renamed from: o */
    private com.aggmoread.sdk.z.c.e.a f5167o;

    /* renamed from: p */
    private boolean f5168p;

    /* renamed from: r */
    private byte[] f5170r;

    /* renamed from: m */
    private boolean f5165m = false;

    /* renamed from: q */
    private boolean f5169q = false;

    /* renamed from: s */
    private com.aggmoread.sdk.z.b.s.i f5171s = null;

    /* renamed from: t */
    private a.b f5172t = new i();

    /* renamed from: com.aggmoread.sdk.z.c.d.a$a */
    public class C0108a implements a.g {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.s.e f5173a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.c.a.a f5174b;

        /* renamed from: com.aggmoread.sdk.z.c.d.a$a$a */
        public class RunnableC0109a implements Runnable {
            public RunnableC0109a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0108a c0108a = C0108a.this;
                com.aggmoread.sdk.z.b.s.e eVar = c0108a.f5173a;
                if (eVar instanceof com.aggmoread.sdk.z.b.s.f) {
                    ((com.aggmoread.sdk.z.b.s.f) eVar).a(a.this);
                }
            }
        }

        public C0108a(com.aggmoread.sdk.z.b.s.e eVar, com.aggmoread.sdk.z.c.a.a aVar) {
            this.f5173a = eVar;
            this.f5174b = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            if (eVar != null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f5173a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            a.this.f5170r = bArr;
            if (a.this.f5170r == null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f5173a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            n.a().post(new RunnableC0109a());
            if (this.f5174b.d().l()) {
                a.this.f5165m = true;
            } else {
                a aVar = a.this;
                aVar.a(aVar.f5161i, a.this.f5162j);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ViewGroup f5177b;

        /* renamed from: c */
        final /* synthetic */ View f5178c;

        /* renamed from: com.aggmoread.sdk.z.c.d.a$b$a */
        public class RunnableC0110a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f5180b;

            public RunnableC0110a(Bitmap bitmap) {
                this.f5180b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f5153a.d().l() && (a.this.f5154b instanceof com.aggmoread.sdk.z.b.s.f)) {
                    ((com.aggmoread.sdk.z.b.s.f) a.this.f5154b).a(a.this);
                }
                a aVar = a.this;
                Bitmap bitmap = this.f5180b;
                ImageView imageView = aVar.f5160h;
                b bVar = b.this;
                aVar.a(bitmap, imageView, bVar.f5177b, bVar.f5178c);
            }
        }

        public b(ViewGroup viewGroup, View view) {
            this.f5177b = viewGroup;
            this.f5178c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.f5177b;
            if (viewGroup == null) {
                com.aggmoread.sdk.z.b.s.b.a(a.this.f5154b, com.aggmoread.sdk.z.b.g.e.f4494d);
                return;
            }
            int width = viewGroup.getWidth();
            int height = this.f5177b.getHeight();
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "adcontainer w = " + width + " , h = " + height);
            n.a().post(new RunnableC0110a(com.aggmoread.sdk.z.b.n.a.a().a(width, height, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, a.this.f5170r)));
        }
    }

    public class c implements a.InterfaceC0091a {

        /* renamed from: com.aggmoread.sdk.z.c.d.a$c$a */
        public class C0111a implements Handler.Callback {
            public C0111a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                a.this.g();
                return false;
            }
        }

        public c() {
        }

        @Override // com.aggmoread.sdk.z.b.s.a.InterfaceC0091a
        public void a(View view, com.aggmoread.sdk.z.b.g.c cVar) {
            List<String> a10;
            com.aggmoread.sdk.z.b.g.c a11;
            String str;
            a.this.a();
            a.this.f();
            if (a.this.f5155c.f5096e != null && !TextUtils.isEmpty(a.this.f5155c.f5096e)) {
                Intent intent = new Intent();
                try {
                    intent.setData(Uri.parse(a.this.f5155c.f5096e));
                    a.this.f5153a.d().d().startActivity(intent);
                    com.aggmoread.sdk.z.b.q.a.a("onStartAppSuccess", a.this.f5155c.a(3), a.this.f5156d.a());
                    new Handler(new C0111a()).sendEmptyMessageDelayed(0, 1000L);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    if (e10 instanceof ActivityNotFoundException) {
                        a10 = a.this.f5155c.a(0);
                        a11 = a.this.f5156d.a();
                        str = "onAppNotExist";
                    } else {
                        a10 = a.this.f5155c.a(2);
                        a11 = a.this.f5156d.a();
                        str = "onStartAppFailed";
                    }
                    com.aggmoread.sdk.z.b.q.a.a(str, a10, a11);
                    com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", str);
                }
            }
            if (!a.this.f5155c.c()) {
                a.this.k();
                return;
            }
            if (TextUtils.isEmpty(a.this.f5155c.f5107p)) {
                a.this.e();
                return;
            }
            if (a.this.f5167o == null) {
                com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "DL s");
                a aVar = a.this;
                aVar.f5167o = new com.aggmoread.sdk.z.c.e.a(aVar.f5172t);
                a.this.f5167o.a(a.this.f5157e, a.this.f5155c.f5107p);
            }
            a.this.f5167o.a(a.this.f5157e, a.this.f5162j);
        }
    }

    public class d implements c.a {
        public d() {
        }

        @Override // com.aggmoread.sdk.z.b.u.c.a
        public void onShow() {
            a.this.g();
        }
    }

    public class e implements Handler.Callback {
        public e() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            a.this.g();
            return false;
        }
    }

    public class f extends com.aggmoread.sdk.z.b.j.c {
        public f() {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "onStartDownload  ");
            com.aggmoread.sdk.z.b.q.a.a("onStartDownload", a.this.f5155c.f5101j, a.this.f5156d.a());
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "onStartApkInstaller  ");
            com.aggmoread.sdk.z.b.q.a.a("onStartApkInstaller", a.this.f5155c.f5102k, a.this.f5156d.a());
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "onApkInstalled  ");
            com.aggmoread.sdk.z.b.q.a.a("onApkInstalled", a.this.f5155c.f5106o, a.this.f5156d.a());
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "onDownloadSuccess  ");
            com.aggmoread.sdk.z.b.q.a.a("onDownloadCompleted", a.this.f5155c.f5105n, a.this.f5156d.a());
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "onDownloadFail  ");
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect bounds = a.this.f5160h.getDrawable().getBounds();
            int width = bounds.width();
            int height = bounds.height();
            if (width <= 1 || height <= 1) {
                a.this.f5154b.a(com.aggmoread.sdk.z.b.g.e.f4496f);
                return;
            }
            a.this.a();
            if (a.this.f5154b instanceof com.aggmoread.sdk.z.b.s.f) {
                ((com.aggmoread.sdk.z.b.s.f) a.this.f5154b).e();
            }
            a.this.g();
        }
    }

    public class h implements i.a {
        public h() {
        }

        @Override // com.aggmoread.sdk.z.b.s.i.a
        public void a() {
            a.this.g();
        }

        @Override // com.aggmoread.sdk.z.b.s.i.a
        public void a(long j10) {
            if (a.this.f5154b instanceof com.aggmoread.sdk.z.b.s.f) {
                ((com.aggmoread.sdk.z.b.s.f) a.this.f5154b).onAdTick(j10);
            }
        }
    }

    public class i implements a.b {

        /* renamed from: com.aggmoread.sdk.z.c.d.a$i$a */
        public class RunnableC0112a implements Runnable {
            public RunnableC0112a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.g();
            }
        }

        public i() {
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void a() {
            a.this.e();
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void b() {
            if (a.this.f5167o != null) {
                a.this.f5167o.a();
                a.this.f5167o = null;
            }
            n.a().postDelayed(new RunnableC0112a(), 1000L);
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            a.this.f5168p = true;
        }
    }

    public void e() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f5155c.f5100i;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f5155c.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    private void i() {
        this.f5154b.onAdShow();
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        return -1;
    }

    public void j() {
        a(this.f5161i, this.f5162j);
    }

    public void a() {
        com.aggmoread.sdk.z.b.s.i iVar = this.f5171s;
        if (iVar != null) {
            iVar.cancel();
            this.f5171s = null;
        }
    }

    private void b(String str) {
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "DL");
        a(str);
        new Handler(new e()).sendEmptyMessageDelayed(0, 1000L);
    }

    public void f() {
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "onAdClick = " + this.f5156d.a());
        com.aggmoread.sdk.z.b.q.a.a(IAdInterListener.AdCommandType.AD_CLICK, this.f5155c.f5104m, this.f5156d.a());
        this.f5154b.onAdClicked();
    }

    public void g() {
        this.f5154b.a();
    }

    private void h() {
        com.aggmoread.sdk.z.b.q.a.a("onAdExposure", this.f5155c.f5103l);
        this.f5154b.d();
    }

    public void k() {
        String str = this.f5155c.f5095d;
        if (TextUtils.isEmpty(str)) {
            com.aggmoread.sdk.z.c.c.a.a(this.f5154b, com.aggmoread.sdk.z.b.g.e.f4497g);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.b.q.a.a(str, this.f5156d.a());
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f5157e, this.f5155c.f5092a, a10, new d());
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        a.C0101a.C0102a c0102a = this.f5155c;
        if (c0102a != null) {
            return TextUtils.isEmpty(c0102a.f5092a) ? this.f5155c.f5093b : this.f5155c.f5092a;
        }
        return null;
    }

    public void a(Bitmap bitmap, ImageView imageView, ViewGroup viewGroup, View view) {
        View view2;
        View view3;
        com.aggmoread.sdk.z.b.s.e eVar;
        com.aggmoread.sdk.z.b.g.e eVar2;
        Context context;
        if (bitmap == null) {
            eVar = this.f5154b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4495e;
        } else {
            if (this.f5157e == null && (context = viewGroup.getContext()) != null && (context instanceof Activity)) {
                this.f5157e = (Activity) context;
            }
            if (!TextUtils.isEmpty(this.f5155c.f5107p)) {
                com.aggmoread.sdk.z.c.e.a aVar = new com.aggmoread.sdk.z.c.e.a(this.f5172t);
                this.f5167o = aVar;
                aVar.a(this.f5157e, this.f5155c.f5107p);
            }
            if (!com.aggmoread.sdk.z.b.m.a.a(this.f5157e)) {
                if (!com.aggmoread.sdk.z.b.m.b.a(viewGroup)) {
                    com.aggmoread.sdk.z.c.c.a.a(this.f5154b, com.aggmoread.sdk.z.b.g.e.f4493c);
                    return;
                }
                com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "isDownload = " + this.f5155c.c() + " , interaction_type = " + this.f5155c.f5099h + " , downloadUrl = " + this.f5155c.a());
                if (!TextUtils.isEmpty(this.f5155c.f5107p) && (view3 = this.f5164l) != null) {
                    view3.setVisibility(0);
                    view2 = this.f5164l;
                    imageView.setClickable(false);
                    if (this.f5169q) {
                        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "CKT");
                    }
                    this.f5156d = com.aggmoread.sdk.z.b.s.a.a(view2, new c());
                    imageView.setImageBitmap(bitmap);
                    if (this.f5163k != null && this.f5153a.d().k()) {
                        this.f5163k.setVisibility(0);
                    }
                    a(view);
                    return;
                }
                view2 = imageView;
                this.f5156d = com.aggmoread.sdk.z.b.s.a.a(view2, new c());
                imageView.setImageBitmap(bitmap);
                if (this.f5163k != null) {
                    this.f5163k.setVisibility(0);
                }
                a(view);
                return;
            }
            eVar = this.f5154b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4493c;
        }
        com.aggmoread.sdk.z.c.c.a.a(eVar, eVar2);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        if (!this.f5153a.d().l() || !this.f5165m) {
            return false;
        }
        j();
        return true;
    }

    private void a(View view) {
        i();
        h();
        com.aggmoread.sdk.z.c.b.a d10 = this.f5153a.d();
        if (d10.f() == null) {
            this.f5159g.setVisibility(0);
        } else {
            this.f5159g = d10.f();
        }
        this.f5159g.setOnClickListener(new g());
        com.aggmoread.sdk.z.b.s.i iVar = new com.aggmoread.sdk.z.b.s.i(this.f5159g, new h(), 5200L, 500L);
        this.f5171s = iVar;
        iVar.start();
    }

    private void a(ViewGroup viewGroup) {
        if (this.f5158f != null) {
            FrameLayout frameLayout = new FrameLayout(this.f5158f);
            frameLayout.setBackgroundColor(Color.parseColor("#99ffdd"));
            if (viewGroup != null) {
                viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            ImageView imageView = new ImageView(this.f5158f);
            imageView.setBackgroundColor(Color.parseColor("#Afd1df"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(this.f5158f);
            TextView textView = new TextView(this.f5158f);
            j.a(textView, this.f5158f, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 6);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText("跳过");
            textView.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 84.0d), com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 34.0d));
            marginLayoutParams.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 16.0d);
            marginLayoutParams.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 6.0d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
            layoutParams.gravity = 5;
            frameLayout2.addView(textView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.END;
            frameLayout.addView(frameLayout2, layoutParams2);
            ImageView imageView2 = new ImageView(this.f5158f);
            com.aggmoread.sdk.z.b.h.a d10 = com.aggmoread.sdk.z.b.h.a.d();
            a.EnumC0075a enumC0075a = a.EnumC0075a.f4524c;
            com.aggmoread.sdk.z.b.g.h b10 = d10.b(enumC0075a);
            if (b10.f4511a != 0) {
                imageView2.setImageResource(com.aggmoread.sdk.z.b.h.a.d().b(enumC0075a).f4511a);
            } else {
                Bitmap bitmap = b10.f4512b;
                if (bitmap != null) {
                    imageView2.setImageBitmap(bitmap);
                }
            }
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 85;
            frameLayout.addView(imageView2, layoutParams3);
            FrameLayout frameLayout3 = new FrameLayout(this.f5158f);
            RelativeLayout relativeLayout = new RelativeLayout(this.f5158f);
            int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 11.0d);
            relativeLayout.setPadding(a10, a10, a10, a10);
            j.a(relativeLayout, this.f5158f, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 20, 20, 20, 90);
            frameLayout3.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(this.f5158f);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            relativeLayout.addView(linearLayout, layoutParams4);
            TextView textView2 = new TextView(this.f5158f);
            textView2.setText("点击跳转详情页或第三方应用");
            textView2.setTextSize(17.0f);
            textView2.setTextColor(-1);
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            ImageView imageView3 = new ImageView(this.f5158f);
            j.a(imageView3, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAA1ElEQVRYR9XXwQ3CMAyF4ecJ6ChsACMwAkwGTMAIsJlRpBx6In7xsyJybZX/kw+ualh8bHEf/wFw9yuAk5nd1BMbTsDdLwBePfxQIyKAI4APgEMFYghoUXcvQ4QAlYgwoApBASoQNECNmAIoEdMAFSIFUCDSgCxCAsgg1IA3gK2v7KeZtY/YzyMB9FVNx5ssDcjE04BsPAVQxKcBqvgUQBmnAeo4BaiIhwFV8RCgMh4FtHV6Z9braP3un4c2Yf8xOUd2OxMPTYC9kH0/NAH2Uub95YAvfduAIVC/ymAAAAAASUVORK5CYII=");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 20.0d), com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 20.0d));
            marginLayoutParams2.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 5.0d);
            linearLayout.addView(imageView3, new LinearLayout.LayoutParams(marginLayoutParams2));
            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams3.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 30.0d);
            marginLayoutParams3.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 30.0d);
            marginLayoutParams3.bottomMargin = com.aggmoread.sdk.z.b.m.b.a(this.f5158f, 25.0d);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(marginLayoutParams3);
            layoutParams5.gravity = 80;
            frameLayout.addView(frameLayout3, layoutParams5);
            this.f5162j = frameLayout;
            this.f5160h = imageView;
            this.f5163k = imageView2;
            imageView2.setVisibility(8);
            this.f5159g = textView;
            this.f5164l = frameLayout3;
        }
    }

    public void a(ViewGroup viewGroup, View view) {
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "showAD enter");
        n.a(new b(viewGroup, view));
    }

    public void a(com.aggmoread.sdk.z.c.a.a aVar, com.aggmoread.sdk.z.b.s.e eVar) {
        com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "handle   enter");
        this.f5153a = aVar;
        this.f5154b = eVar;
        this.f5157e = aVar.d().d();
        this.f5158f = aVar.d().i();
        a.C0101a.C0102a a10 = aVar.f5090e.a();
        if (a10 != null) {
            this.f5155c = a10;
            this.f5166n = a10.b();
            a10.a();
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "imageUrl = " + this.f5166n);
            com.aggmoread.sdk.z.b.j.g.a(this.f5166n);
            if (!TextUtils.isEmpty(this.f5166n)) {
                ViewGroup e10 = aVar.d().e();
                this.f5161i = e10;
                a(e10);
                this.f5163k.setVisibility(8);
                this.f5164l.setVisibility(8);
                com.aggmoread.sdk.z.b.p.a.a(this.f5166n, null, new C0108a(eVar, aVar));
                return;
            }
        }
        com.aggmoread.sdk.z.c.c.a.a(eVar, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常"));
    }

    private void a(String str) {
        try {
            a.C0101a.C0102a c0102a = this.f5155c;
            new com.aggmoread.sdk.z.b.j.b(this.f5158f.getApplicationContext(), this.f5153a.d().h(), new f()).a(str, c0102a.f5100i, c0102a.f5092a);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f5153a.d().l()) {
            return false;
        }
        if (viewGroup != null) {
            View view = this.f5161i;
            if (view == null) {
                view = this.f5162j;
            }
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            com.aggmoread.sdk.z.b.d.c("ApiSplashHandler_dsp", "show add adContainer tmpView = " + view);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f5161i = viewGroup;
            this.f5157e = activity;
        }
        return b();
    }
}
