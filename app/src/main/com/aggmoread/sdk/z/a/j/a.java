package com.aggmoread.sdk.z.a.j;

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
import com.aggmoread.sdk.z.a.d.a;
import com.aggmoread.sdk.z.b.h.a;
import com.aggmoread.sdk.z.b.m.j;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.aggmoread.sdk.z.b.s.a;
import com.aggmoread.sdk.z.b.s.i;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.c.e.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes.dex */
public class a implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.a.d.a f4335a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.s.e f4336b;

    /* renamed from: c */
    private a.C0052a.C0053a f4337c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f4338d;

    /* renamed from: e */
    private Activity f4339e;

    /* renamed from: f */
    private Context f4340f;

    /* renamed from: g */
    private View f4341g;

    /* renamed from: h */
    private ImageView f4342h;

    /* renamed from: i */
    private ViewGroup f4343i;

    /* renamed from: j */
    private View f4344j;

    /* renamed from: k */
    private ImageView f4345k;

    /* renamed from: l */
    private View f4346l;

    /* renamed from: n */
    private String f4348n;

    /* renamed from: o */
    private String f4349o;

    /* renamed from: p */
    private com.aggmoread.sdk.z.c.e.a f4350p;

    /* renamed from: q */
    private boolean f4351q;

    /* renamed from: s */
    private byte[] f4353s;

    /* renamed from: m */
    private boolean f4347m = false;

    /* renamed from: r */
    private boolean f4352r = false;

    /* renamed from: t */
    private int f4354t = -1;

    /* renamed from: u */
    private com.aggmoread.sdk.z.b.s.i f4355u = null;

    /* renamed from: v */
    private a.b f4356v = new i();

    /* renamed from: com.aggmoread.sdk.z.a.j.a$a */
    public class C0064a implements a.g {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.s.e f4357a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.a.d.a f4358b;

        /* renamed from: com.aggmoread.sdk.z.a.j.a$a$a */
        public class RunnableC0065a implements Runnable {
            public RunnableC0065a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0064a c0064a = C0064a.this;
                com.aggmoread.sdk.z.b.s.e eVar = c0064a.f4357a;
                if (eVar instanceof com.aggmoread.sdk.z.b.s.f) {
                    ((com.aggmoread.sdk.z.b.s.f) eVar).a(a.this);
                }
            }
        }

        public C0064a(com.aggmoread.sdk.z.b.s.e eVar, com.aggmoread.sdk.z.a.d.a aVar) {
            this.f4357a = eVar;
            this.f4358b = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            if (eVar != null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f4357a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            a.this.f4353s = bArr;
            if (a.this.f4353s == null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f4357a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            n.a().post(new RunnableC0065a());
            if (this.f4358b.d().t()) {
                a.this.f4347m = true;
            } else {
                a aVar = a.this;
                aVar.a(aVar.f4343i, a.this.f4344j);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ViewGroup f4361b;

        /* renamed from: c */
        final /* synthetic */ View f4362c;

        /* renamed from: com.aggmoread.sdk.z.a.j.a$b$a */
        public class RunnableC0066a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f4364b;

            public RunnableC0066a(Bitmap bitmap) {
                this.f4364b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f4335a.d().t() && (a.this.f4336b instanceof com.aggmoread.sdk.z.b.s.f)) {
                    ((com.aggmoread.sdk.z.b.s.f) a.this.f4336b).a(a.this);
                }
                a aVar = a.this;
                Bitmap bitmap = this.f4364b;
                ImageView imageView = aVar.f4342h;
                b bVar = b.this;
                aVar.a(bitmap, imageView, bVar.f4361b, bVar.f4362c);
            }
        }

        public b(ViewGroup viewGroup, View view) {
            this.f4361b = viewGroup;
            this.f4362c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.f4361b;
            if (viewGroup == null) {
                com.aggmoread.sdk.z.b.s.b.a(a.this.f4336b, com.aggmoread.sdk.z.b.g.e.f4494d);
                return;
            }
            int width = viewGroup.getWidth();
            int height = this.f4361b.getHeight();
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "adcontainer w = " + width + " , h = " + height);
            n.a().post(new RunnableC0066a(com.aggmoread.sdk.z.b.n.a.a().a(width, height, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, a.this.f4353s)));
        }
    }

    public class c implements a.InterfaceC0091a {

        /* renamed from: com.aggmoread.sdk.z.a.j.a$c$a */
        public class C0067a implements Handler.Callback {
            public C0067a() {
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
            String str;
            a.this.a();
            a.this.f();
            if (a.this.f4337c.f4162g != null && !TextUtils.isEmpty(a.this.f4337c.f4162g)) {
                Intent intent = new Intent();
                try {
                    intent.setData(Uri.parse(a.this.f4337c.f4162g));
                    Activity d10 = a.this.f4335a.d().d();
                    if (d10 != null) {
                        d10.startActivity(intent);
                    } else {
                        a.this.f4335a.d().k().startActivity(intent);
                    }
                    com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onAppStartSuccess");
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(a.this.f4337c.a(14), a.this.f4338d.a(), String.valueOf(a.this.f4337c.f4157b)));
                    new Handler(new C0067a()).sendEmptyMessageDelayed(0, 1000L);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    if (e10 instanceof ActivityNotFoundException) {
                        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(a.this.f4337c.a(11), a.this.f4338d.a(), String.valueOf(a.this.f4337c.f4157b)));
                        str = "onAppNotExist";
                    } else {
                        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(a.this.f4337c.a(12), a.this.f4338d.a(), String.valueOf(a.this.f4337c.f4157b)));
                        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(a.this.f4337c.a(13), a.this.f4338d.a(), String.valueOf(a.this.f4337c.f4157b)));
                        str = "onStartAppFailed";
                    }
                    com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", str);
                }
            }
            if (!a.this.f4337c.c()) {
                a.this.k();
                return;
            }
            if (TextUtils.isEmpty(a.this.f4337c.B)) {
                a.this.e();
                return;
            }
            if (a.this.f4350p == null) {
                com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "DL s");
                a aVar = a.this;
                aVar.f4350p = new com.aggmoread.sdk.z.c.e.a(aVar.f4356v);
                a.this.f4350p.a(a.this.f4339e, a.this.f4337c.B);
            }
            a.this.f4350p.a(a.this.f4339e, a.this.f4344j);
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
        public f(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onStartDownload  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onStartApkInstaller  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onApkInstalled  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onDownloadSuccess  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onDownloadFail  ");
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect bounds = a.this.f4342h.getDrawable().getBounds();
            int width = bounds.width();
            int height = bounds.height();
            if (width <= 1 || height <= 1) {
                a.this.f4336b.a(com.aggmoread.sdk.z.b.g.e.f4496f);
                return;
            }
            a.this.a();
            if (a.this.f4336b instanceof com.aggmoread.sdk.z.b.s.f) {
                ((com.aggmoread.sdk.z.b.s.f) a.this.f4336b).e();
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
            if (a.this.f4336b instanceof com.aggmoread.sdk.z.b.s.f) {
                ((com.aggmoread.sdk.z.b.s.f) a.this.f4336b).onAdTick(j10);
            }
        }
    }

    public class i implements a.b {

        /* renamed from: com.aggmoread.sdk.z.a.j.a$i$a */
        public class RunnableC0068a implements Runnable {
            public RunnableC0068a() {
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
            if (a.this.f4350p != null) {
                a.this.f4350p.a();
                a.this.f4350p = null;
            }
            n.a().postDelayed(new RunnableC0068a(), 1000L);
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            a.this.f4351q = true;
        }
    }

    public void e() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f4337c.f4172q;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f4337c.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    private void i() {
        this.f4336b.onAdShow();
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        return this.f4354t;
    }

    public void j() {
        a(this.f4343i, this.f4344j);
    }

    public void a() {
        com.aggmoread.sdk.z.b.s.i iVar = this.f4355u;
        if (iVar != null) {
            iVar.cancel();
            this.f4355u = null;
        }
    }

    private void b(String str) {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "DL");
        a(str);
        new Handler(new e()).sendEmptyMessageDelayed(0, 1000L);
    }

    public void f() {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onAdClick = " + this.f4338d.a());
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4337c.f4169n, this.f4338d.a(), String.valueOf(this.f4337c.f4157b)));
        this.f4336b.onAdClicked();
    }

    public void g() {
        this.f4336b.a();
    }

    private void h() {
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4337c.f4168m, this.f4338d.a(), String.valueOf(this.f4337c.f4157b)));
        this.f4336b.d();
    }

    public void k() {
        String str = this.f4349o;
        if (TextUtils.isEmpty(str)) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4336b, com.aggmoread.sdk.z.b.g.e.f4497g);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.a.b.a(str, this.f4338d.a(), String.valueOf(this.f4337c.f4157b));
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f4339e, this.f4337c.f4158c, a10, new d());
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        a.C0052a.C0053a c0053a = this.f4337c;
        if (c0053a == null) {
            return null;
        }
        a.C0052a.C0053a.C0054a c0054a = c0053a.f4171p;
        return (c0054a == null || TextUtils.isEmpty(c0054a.f4183b)) ? TextUtils.isEmpty(this.f4337c.f4158c) ? this.f4337c.f4159d : this.f4337c.f4158c : this.f4337c.f4171p.f4183b;
    }

    public void a(Bitmap bitmap, ImageView imageView, ViewGroup viewGroup, View view) {
        View view2;
        View view3;
        com.aggmoread.sdk.z.b.s.e eVar;
        com.aggmoread.sdk.z.b.g.e eVar2;
        Context context;
        if (bitmap == null) {
            eVar = this.f4336b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4495e;
        } else {
            if (this.f4339e == null && (context = viewGroup.getContext()) != null && (context instanceof Activity)) {
                this.f4339e = (Activity) context;
            }
            if (!TextUtils.isEmpty(this.f4337c.B)) {
                com.aggmoread.sdk.z.c.e.a aVar = new com.aggmoread.sdk.z.c.e.a(this.f4356v);
                this.f4350p = aVar;
                aVar.a(this.f4339e, this.f4337c.B);
            }
            if (!com.aggmoread.sdk.z.b.m.a.a(this.f4339e)) {
                if (!com.aggmoread.sdk.z.b.m.b.a(viewGroup)) {
                    com.aggmoread.sdk.z.a.h.a.a(this.f4336b, com.aggmoread.sdk.z.b.g.e.f4493c);
                    return;
                }
                com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "isDownload = " + this.f4337c.c() + " , interaction_type = " + this.f4337c.f4165j + " , downloadUrl = " + this.f4337c.a());
                if (!TextUtils.isEmpty(this.f4337c.B) && (view3 = this.f4346l) != null) {
                    view3.setVisibility(0);
                    view2 = this.f4346l;
                    imageView.setClickable(false);
                    if (this.f4352r) {
                        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "CKT");
                    }
                    this.f4338d = com.aggmoread.sdk.z.b.s.a.a(view2, new c());
                    imageView.setImageBitmap(bitmap);
                    if (this.f4345k != null && this.f4335a.d().s()) {
                        this.f4345k.setVisibility(0);
                    }
                    a(view);
                    return;
                }
                view2 = imageView;
                this.f4338d = com.aggmoread.sdk.z.b.s.a.a(view2, new c());
                imageView.setImageBitmap(bitmap);
                if (this.f4345k != null) {
                    this.f4345k.setVisibility(0);
                }
                a(view);
                return;
            }
            eVar = this.f4336b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4493c;
        }
        com.aggmoread.sdk.z.a.h.a.a(eVar, eVar2);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        if (!this.f4335a.d().t() || !this.f4347m) {
            return false;
        }
        j();
        return true;
    }

    private void a(View view) {
        i();
        h();
        com.aggmoread.sdk.z.a.e.a d10 = this.f4335a.d();
        if (d10.f() == null) {
            this.f4341g.setVisibility(0);
        } else {
            this.f4341g = d10.f();
        }
        this.f4341g.setOnClickListener(new g());
        com.aggmoread.sdk.z.b.s.i iVar = new com.aggmoread.sdk.z.b.s.i(this.f4341g, new h(), 5200L, 500L);
        this.f4355u = iVar;
        iVar.start();
    }

    private void a(ViewGroup viewGroup) {
        if (this.f4340f != null) {
            FrameLayout frameLayout = new FrameLayout(this.f4340f);
            frameLayout.setBackgroundColor(Color.parseColor("#99ffdd"));
            if (viewGroup != null) {
                viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            ImageView imageView = new ImageView(this.f4340f);
            imageView.setBackgroundColor(Color.parseColor("#Afd1df"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(this.f4340f);
            TextView textView = new TextView(this.f4340f);
            j.a(textView, this.f4340f, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 6);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText("跳过");
            textView.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 84.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 34.0d));
            marginLayoutParams.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 16.0d);
            marginLayoutParams.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 6.0d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
            layoutParams.gravity = 5;
            frameLayout2.addView(textView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.END;
            frameLayout.addView(frameLayout2, layoutParams2);
            ImageView imageView2 = new ImageView(this.f4340f);
            com.aggmoread.sdk.z.b.h.a d10 = com.aggmoread.sdk.z.b.h.a.d();
            a.EnumC0075a enumC0075a = a.EnumC0075a.f4525d;
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
            FrameLayout frameLayout3 = new FrameLayout(this.f4340f);
            RelativeLayout relativeLayout = new RelativeLayout(this.f4340f);
            int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 11.0d);
            relativeLayout.setPadding(a10, a10, a10, a10);
            j.a(relativeLayout, this.f4340f, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 20, 20, 20, 90);
            frameLayout3.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(this.f4340f);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            relativeLayout.addView(linearLayout, layoutParams4);
            TextView textView2 = new TextView(this.f4340f);
            textView2.setText("点击跳转详情页或第三方应用");
            textView2.setTextSize(17.0f);
            textView2.setTextColor(-1);
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            ImageView imageView3 = new ImageView(this.f4340f);
            j.a(imageView3, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAA1ElEQVRYR9XXwQ3CMAyF4ecJ6ChsACMwAkwGTMAIsJlRpBx6In7xsyJybZX/kw+ualh8bHEf/wFw9yuAk5nd1BMbTsDdLwBePfxQIyKAI4APgEMFYghoUXcvQ4QAlYgwoApBASoQNECNmAIoEdMAFSIFUCDSgCxCAsgg1IA3gK2v7KeZtY/YzyMB9FVNx5ssDcjE04BsPAVQxKcBqvgUQBmnAeo4BaiIhwFV8RCgMh4FtHV6Z9braP3un4c2Yf8xOUd2OxMPTYC9kH0/NAH2Uub95YAvfduAIVC/ymAAAAAASUVORK5CYII=");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 20.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 20.0d));
            marginLayoutParams2.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 5.0d);
            linearLayout.addView(imageView3, new LinearLayout.LayoutParams(marginLayoutParams2));
            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams3.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 30.0d);
            marginLayoutParams3.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 30.0d);
            marginLayoutParams3.bottomMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4340f, 25.0d);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(marginLayoutParams3);
            layoutParams5.gravity = 80;
            frameLayout.addView(frameLayout3, layoutParams5);
            this.f4344j = frameLayout;
            this.f4342h = imageView;
            this.f4345k = imageView2;
            imageView2.setVisibility(8);
            this.f4341g = textView;
            this.f4346l = frameLayout3;
        }
    }

    public void a(ViewGroup viewGroup, View view) {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "showAD enter");
        n.a(new b(viewGroup, view));
    }

    public void a(com.aggmoread.sdk.z.a.d.a aVar, com.aggmoread.sdk.z.b.s.e eVar) {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "handle   enter");
        this.f4335a = aVar;
        this.f4336b = eVar;
        this.f4339e = aVar.d().d();
        this.f4340f = aVar.d().k();
        a.C0052a.C0053a a10 = aVar.f4153e.a();
        if (a10 != null) {
            this.f4337c = a10;
            this.f4354t = (int) a10.f4157b;
            this.f4348n = a10.b();
            this.f4349o = a10.a();
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "imageUrl = " + this.f4348n);
            com.aggmoread.sdk.z.b.j.g.a(this.f4348n);
            if (!TextUtils.isEmpty(this.f4348n)) {
                ViewGroup e10 = aVar.d().e();
                this.f4343i = e10;
                a(e10);
                this.f4345k.setVisibility(8);
                this.f4346l.setVisibility(8);
                com.aggmoread.sdk.z.b.p.a.a(this.f4348n, null, new C0064a(eVar, aVar));
                return;
            }
        }
        com.aggmoread.sdk.z.a.h.a.a(eVar, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常"));
    }

    private void a(String str) {
        try {
            a.C0052a.C0053a c0053a = this.f4337c;
            new com.aggmoread.sdk.z.b.j.b(this.f4340f.getApplicationContext(), this.f4335a.d().j(), new f(this)).a(str, c0053a.f4172q, c0053a.f4158c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f4335a.d().t()) {
            return false;
        }
        if (viewGroup != null) {
            View view = this.f4343i;
            if (view == null) {
                view = this.f4344j;
            }
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "show add adContainer tmpView = " + view);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f4343i = viewGroup;
            this.f4339e = activity;
        }
        return b();
    }
}
