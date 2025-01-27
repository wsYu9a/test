package com.aggmoread.sdk.z.e.j;

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
import com.aggmoread.sdk.z.c.e.a;
import com.aggmoread.sdk.z.e.e.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class a implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.e.e.a f6269a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.s.e f6270b;

    /* renamed from: c */
    private a.C0192a.C0193a f6271c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f6272d;

    /* renamed from: e */
    private Activity f6273e;

    /* renamed from: f */
    private Context f6274f;

    /* renamed from: g */
    private View f6275g;

    /* renamed from: h */
    private ImageView f6276h;

    /* renamed from: i */
    private ViewGroup f6277i;

    /* renamed from: j */
    private View f6278j;

    /* renamed from: k */
    private ImageView f6279k;

    /* renamed from: l */
    private View f6280l;

    /* renamed from: n */
    private String f6282n;

    /* renamed from: o */
    private String f6283o;

    /* renamed from: p */
    private com.aggmoread.sdk.z.c.e.a f6284p;

    /* renamed from: q */
    private boolean f6285q;

    /* renamed from: s */
    private byte[] f6287s;

    /* renamed from: m */
    private boolean f6281m = false;

    /* renamed from: r */
    private boolean f6286r = false;

    /* renamed from: t */
    private int f6288t = -1;

    /* renamed from: u */
    private com.aggmoread.sdk.z.b.s.i f6289u = null;

    /* renamed from: v */
    private a.b f6290v = new i();

    /* renamed from: com.aggmoread.sdk.z.e.j.a$a */
    public class C0202a implements a.g {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.s.e f6291a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.e.e.a f6292b;

        /* renamed from: com.aggmoread.sdk.z.e.j.a$a$a */
        public class RunnableC0203a implements Runnable {
            public RunnableC0203a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0202a c0202a = C0202a.this;
                com.aggmoread.sdk.z.b.s.e eVar = c0202a.f6291a;
                if (eVar instanceof com.aggmoread.sdk.z.b.s.f) {
                    ((com.aggmoread.sdk.z.b.s.f) eVar).a(a.this);
                }
            }
        }

        public C0202a(com.aggmoread.sdk.z.b.s.e eVar, com.aggmoread.sdk.z.e.e.a aVar) {
            this.f6291a = eVar;
            this.f6292b = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            if (eVar != null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f6291a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            a.this.f6287s = bArr;
            if (a.this.f6287s == null) {
                com.aggmoread.sdk.z.b.s.b.a(this.f6291a, com.aggmoread.sdk.z.b.g.e.f4495e);
                return;
            }
            n.a().post(new RunnableC0203a());
            if (this.f6292b.d().r()) {
                a.this.f6281m = true;
            } else {
                a aVar = a.this;
                aVar.a(aVar.f6277i, a.this.f6278j);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ViewGroup f6295b;

        /* renamed from: c */
        final /* synthetic */ View f6296c;

        /* renamed from: com.aggmoread.sdk.z.e.j.a$b$a */
        public class RunnableC0204a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f6298b;

            public RunnableC0204a(Bitmap bitmap) {
                this.f6298b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f6269a.d().r() && (a.this.f6270b instanceof com.aggmoread.sdk.z.b.s.f)) {
                    ((com.aggmoread.sdk.z.b.s.f) a.this.f6270b).a(a.this);
                }
                a aVar = a.this;
                Bitmap bitmap = this.f6298b;
                ImageView imageView = aVar.f6276h;
                b bVar = b.this;
                aVar.a(bitmap, imageView, bVar.f6295b, bVar.f6296c);
            }
        }

        public b(ViewGroup viewGroup, View view) {
            this.f6295b = viewGroup;
            this.f6296c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.f6295b;
            if (viewGroup == null) {
                com.aggmoread.sdk.z.b.s.b.a(a.this.f6270b, com.aggmoread.sdk.z.b.g.e.f4494d);
                return;
            }
            int width = viewGroup.getWidth();
            int height = this.f6295b.getHeight();
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "adcontainer w = " + width + " , h = " + height);
            n.a().post(new RunnableC0204a(com.aggmoread.sdk.z.b.n.a.a().a(width, height, Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, a.this.f6287s)));
        }
    }

    public class c implements a.InterfaceC0091a {

        /* renamed from: com.aggmoread.sdk.z.e.j.a$c$a */
        public class C0205a implements Handler.Callback {
            public C0205a() {
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
            a.this.a();
            a.this.f();
            if (a.this.f6271c.f6171g != null && !TextUtils.isEmpty(a.this.f6271c.f6171g)) {
                Intent intent = new Intent();
                try {
                    String str = a.this.f6271c.f6180p;
                    boolean c10 = !TextUtils.isEmpty(str) ? com.aggmoread.sdk.z.b.m.d.c(a.this.f6269a.d().k(), str) : true;
                    com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "isInstalled " + c10 + ", packageName = " + str);
                    if (c10) {
                        intent.setData(Uri.parse(a.this.f6271c.f6171g));
                        Activity d10 = a.this.f6269a.d().d();
                        if (d10 != null) {
                            d10.startActivity(intent);
                        } else {
                            a.this.f6269a.d().k().startActivity(intent);
                        }
                        new Handler(new C0205a()).sendEmptyMessageDelayed(0, 1000L);
                        return;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", e10 instanceof ActivityNotFoundException ? "onAppNotExist" : "onStartAppFailed");
                }
            }
            if (!a.this.f6271c.c()) {
                a.this.k();
                return;
            }
            if (TextUtils.isEmpty(a.this.f6271c.f6181q)) {
                a.this.e();
                return;
            }
            if (a.this.f6284p == null) {
                com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "DL s");
                a aVar = a.this;
                aVar.f6284p = new com.aggmoread.sdk.z.c.e.a(aVar.f6290v);
                a.this.f6284p.a(a.this.f6273e, a.this.f6271c.f6181q);
            }
            a.this.f6284p.a(a.this.f6273e, a.this.f6278j);
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
            Rect bounds = a.this.f6276h.getDrawable().getBounds();
            int width = bounds.width();
            int height = bounds.height();
            if (width <= 1 || height <= 1) {
                a.this.f6270b.a(com.aggmoread.sdk.z.b.g.e.f4496f);
                return;
            }
            a.this.a();
            if (a.this.f6270b instanceof com.aggmoread.sdk.z.b.s.f) {
                ((com.aggmoread.sdk.z.b.s.f) a.this.f6270b).e();
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
            if (a.this.f6270b instanceof com.aggmoread.sdk.z.b.s.f) {
                ((com.aggmoread.sdk.z.b.s.f) a.this.f6270b).onAdTick(j10);
            }
        }
    }

    public class i implements a.b {

        /* renamed from: com.aggmoread.sdk.z.e.j.a$i$a */
        public class RunnableC0206a implements Runnable {
            public RunnableC0206a() {
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
            if (a.this.f6284p != null) {
                a.this.f6284p.a();
                a.this.f6284p = null;
            }
            n.a().postDelayed(new RunnableC0206a(), 1000L);
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            a.this.f6285q = true;
        }
    }

    private void h() {
        com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6271c.f6177m, new BigDecimal(this.f6271c.f6166b)));
        this.f6270b.d();
    }

    private void i() {
        this.f6270b.onAdShow();
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        return this.f6288t;
    }

    public void a() {
        com.aggmoread.sdk.z.b.s.i iVar = this.f6289u;
        if (iVar != null) {
            iVar.cancel();
            this.f6289u = null;
        }
    }

    private void b(String str) {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "DL");
        a(str);
        new Handler(new e()).sendEmptyMessageDelayed(0, 1000L);
    }

    public void e() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f6271c.f6180p;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f6271c.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    public void f() {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "onAdClick = " + this.f6272d.a());
        com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6271c.f6178n, new BigDecimal(this.f6271c.f6166b)));
        this.f6270b.onAdClicked();
    }

    public void g() {
        this.f6270b.a();
    }

    public void k() {
        String str = this.f6283o;
        if (TextUtils.isEmpty(str)) {
            com.aggmoread.sdk.z.e.i.a.a(this.f6270b, com.aggmoread.sdk.z.b.g.e.f4497g);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.b.q.a.a(str, this.f6272d.a());
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "startWebActivity final = " + a10);
        Context context = this.f6273e;
        if (context == null) {
            context = this.f6269a.d().k();
        }
        com.aggmoread.sdk.z.b.u.c.a(context, this.f6271c.f6167c, a10, new d());
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        a.C0192a.C0193a c0193a = this.f6271c;
        if (c0193a != null) {
            return TextUtils.isEmpty(c0193a.f6167c) ? this.f6271c.f6168d : this.f6271c.f6167c;
        }
        return null;
    }

    public void j() {
        a(this.f6277i, this.f6278j);
    }

    public void a(Bitmap bitmap, ImageView imageView, ViewGroup viewGroup, View view) {
        View view2;
        View view3;
        com.aggmoread.sdk.z.b.s.e eVar;
        com.aggmoread.sdk.z.b.g.e eVar2;
        Context context;
        if (bitmap == null) {
            eVar = this.f6270b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4495e;
        } else {
            if (this.f6273e == null && (context = viewGroup.getContext()) != null && (context instanceof Activity)) {
                this.f6273e = (Activity) context;
            }
            if (!TextUtils.isEmpty(this.f6271c.f6181q)) {
                com.aggmoread.sdk.z.c.e.a aVar = new com.aggmoread.sdk.z.c.e.a(this.f6290v);
                this.f6284p = aVar;
                aVar.a(this.f6273e, this.f6271c.f6181q);
            }
            if (!com.aggmoread.sdk.z.b.m.a.a(this.f6273e)) {
                if (!com.aggmoread.sdk.z.b.m.b.a(viewGroup)) {
                    com.aggmoread.sdk.z.e.i.a.a(this.f6270b, com.aggmoread.sdk.z.b.g.e.f4493c);
                    return;
                }
                com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "isDownload = " + this.f6271c.c() + " , interaction_type = " + this.f6271c.f6174j + " , downloadUrl = " + this.f6271c.a());
                if (!TextUtils.isEmpty(this.f6271c.f6181q) && (view3 = this.f6280l) != null) {
                    view3.setVisibility(0);
                    view2 = this.f6280l;
                    imageView.setClickable(false);
                    if (this.f6286r) {
                        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "CKT");
                    }
                    this.f6272d = com.aggmoread.sdk.z.b.s.a.a(view2, new c());
                    imageView.setImageBitmap(bitmap);
                    if (this.f6279k != null && this.f6269a.d().q()) {
                        this.f6279k.setVisibility(0);
                    }
                    a(view);
                    return;
                }
                view2 = imageView;
                this.f6272d = com.aggmoread.sdk.z.b.s.a.a(view2, new c());
                imageView.setImageBitmap(bitmap);
                if (this.f6279k != null) {
                    this.f6279k.setVisibility(0);
                }
                a(view);
                return;
            }
            eVar = this.f6270b;
            eVar2 = com.aggmoread.sdk.z.b.g.e.f4493c;
        }
        com.aggmoread.sdk.z.e.i.a.a(eVar, eVar2);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        if (!this.f6269a.d().r() || !this.f6281m) {
            return false;
        }
        j();
        return true;
    }

    private void a(View view) {
        i();
        h();
        com.aggmoread.sdk.z.e.f.a d10 = this.f6269a.d();
        if (d10.f() == null) {
            this.f6275g.setVisibility(0);
        } else {
            this.f6275g = d10.f();
        }
        this.f6275g.setOnClickListener(new g());
        com.aggmoread.sdk.z.b.s.i iVar = new com.aggmoread.sdk.z.b.s.i(this.f6275g, new h(), 5200L, 500L);
        this.f6289u = iVar;
        iVar.start();
    }

    private void a(ViewGroup viewGroup) {
        if (this.f6274f != null) {
            FrameLayout frameLayout = new FrameLayout(this.f6274f);
            frameLayout.setBackgroundColor(Color.parseColor("#99ffdd"));
            if (viewGroup != null) {
                viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            ImageView imageView = new ImageView(this.f6274f);
            imageView.setBackgroundColor(Color.parseColor("#Afd1df"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(this.f6274f);
            TextView textView = new TextView(this.f6274f);
            j.a(textView, this.f6274f, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 6);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText("跳过");
            textView.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 84.0d), com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 34.0d));
            marginLayoutParams.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 16.0d);
            marginLayoutParams.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 6.0d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
            layoutParams.gravity = 5;
            frameLayout2.addView(textView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.END;
            frameLayout.addView(frameLayout2, layoutParams2);
            ImageView imageView2 = new ImageView(this.f6274f);
            com.aggmoread.sdk.z.b.h.a d10 = com.aggmoread.sdk.z.b.h.a.d();
            a.EnumC0075a enumC0075a = a.EnumC0075a.f4526e;
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
            FrameLayout frameLayout3 = new FrameLayout(this.f6274f);
            RelativeLayout relativeLayout = new RelativeLayout(this.f6274f);
            int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 11.0d);
            relativeLayout.setPadding(a10, a10, a10, a10);
            j.a(relativeLayout, this.f6274f, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 20, 20, 20, 90);
            frameLayout3.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(this.f6274f);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            relativeLayout.addView(linearLayout, layoutParams4);
            TextView textView2 = new TextView(this.f6274f);
            textView2.setText("点击跳转详情页或第三方应用");
            textView2.setTextSize(17.0f);
            textView2.setTextColor(-1);
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            ImageView imageView3 = new ImageView(this.f6274f);
            j.a(imageView3, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAA1ElEQVRYR9XXwQ3CMAyF4ecJ6ChsACMwAkwGTMAIsJlRpBx6In7xsyJybZX/kw+ualh8bHEf/wFw9yuAk5nd1BMbTsDdLwBePfxQIyKAI4APgEMFYghoUXcvQ4QAlYgwoApBASoQNECNmAIoEdMAFSIFUCDSgCxCAsgg1IA3gK2v7KeZtY/YzyMB9FVNx5ssDcjE04BsPAVQxKcBqvgUQBmnAeo4BaiIhwFV8RCgMh4FtHV6Z9braP3un4c2Yf8xOUd2OxMPTYC9kH0/NAH2Uub95YAvfduAIVC/ymAAAAAASUVORK5CYII=");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 20.0d), com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 20.0d));
            marginLayoutParams2.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 5.0d);
            linearLayout.addView(imageView3, new LinearLayout.LayoutParams(marginLayoutParams2));
            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams3.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 30.0d);
            marginLayoutParams3.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 30.0d);
            marginLayoutParams3.bottomMargin = com.aggmoread.sdk.z.b.m.b.a(this.f6274f, 25.0d);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(marginLayoutParams3);
            layoutParams5.gravity = 80;
            frameLayout.addView(frameLayout3, layoutParams5);
            this.f6278j = frameLayout;
            this.f6276h = imageView;
            this.f6279k = imageView2;
            imageView2.setVisibility(8);
            this.f6275g = textView;
            this.f6280l = frameLayout3;
        }
    }

    public void a(ViewGroup viewGroup, View view) {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "showAD enter");
        n.a(new b(viewGroup, view));
    }

    public void a(com.aggmoread.sdk.z.e.e.a aVar, com.aggmoread.sdk.z.b.s.e eVar) {
        com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "handle   enter");
        this.f6269a = aVar;
        this.f6270b = eVar;
        this.f6273e = aVar.d().d();
        this.f6274f = aVar.d().k();
        a.C0192a.C0193a a10 = aVar.f6163g.a();
        if (a10 != null) {
            this.f6271c = a10;
            this.f6288t = a10.f6166b;
            this.f6282n = a10.b();
            this.f6283o = a10.a();
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "imageUrl = " + this.f6282n);
            com.aggmoread.sdk.z.b.j.g.a(this.f6282n);
            if (!TextUtils.isEmpty(this.f6282n)) {
                ViewGroup e10 = aVar.d().e();
                this.f6277i = e10;
                a(e10);
                this.f6279k.setVisibility(8);
                this.f6280l.setVisibility(8);
                com.aggmoread.sdk.z.b.p.a.a(this.f6282n, null, new C0202a(eVar, aVar));
                return;
            }
        }
        com.aggmoread.sdk.z.e.i.a.a(eVar, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常"));
    }

    private void a(String str) {
        try {
            a.C0192a.C0193a c0193a = this.f6271c;
            new com.aggmoread.sdk.z.b.j.b(this.f6274f.getApplicationContext(), this.f6269a.d().j(), new f(this)).a(str, c0193a.f6180p, c0193a.f6167c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f6269a.d().r()) {
            return false;
        }
        if (viewGroup != null) {
            View view = this.f6277i;
            if (view == null) {
                view = this.f6278j;
            }
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            com.aggmoread.sdk.z.b.d.c("RhSplashHandler_dsp", "show add adContainer tmpView = " + view);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f6277i = viewGroup;
            this.f6273e = activity;
        }
        return b();
    }
}
