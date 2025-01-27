package com.aggmoread.sdk.z.a.h;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.aggmoread.sdk.z.a.d.a;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.l.c;
import com.aggmoread.sdk.z.b.l.e;
import com.aggmoread.sdk.z.b.l.f;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.b.u.d;
import com.aggmoread.sdk.z.b.u.g;
import com.aggmoread.sdk.z.c.e.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.b.b implements c, d.c {

    /* renamed from: a */
    private a.C0052a.C0053a f4303a;

    /* renamed from: b */
    private f f4304b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.a.d.a f4305c;

    /* renamed from: f */
    private d f4308f;

    /* renamed from: g */
    private com.aggmoread.sdk.z.c.e.a f4309g;

    /* renamed from: h */
    private boolean f4310h;

    /* renamed from: i */
    private WeakReference<Activity> f4311i;

    /* renamed from: d */
    private volatile boolean f4306d = false;

    /* renamed from: e */
    private boolean f4307e = false;

    /* renamed from: j */
    private a.b f4312j = new C0061b();

    public class a extends com.aggmoread.sdk.z.b.j.c {
        public a(b bVar) {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onStartDownload  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onStartApkInstaller  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onApkInstalled  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onDownloadSuccess  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onDownloadFail  ");
        }
    }

    /* renamed from: com.aggmoread.sdk.z.a.h.b$b */
    public class C0061b implements a.b {
        public C0061b() {
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void a() {
            b.this.e();
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void b() {
            if (b.this.f4309g != null) {
                b.this.f4309g.a();
                b.this.f4309g = null;
            }
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            b.this.f4310h = true;
        }
    }

    public b(com.aggmoread.sdk.z.a.d.a aVar, a.C0052a.C0053a c0053a) {
        this.f4303a = c0053a;
        this.f4305c = aVar;
        aVar.d().j();
        UUID.randomUUID().toString();
    }

    private boolean d() {
        return com.aggmoread.sdk.z.b.h.a.d().g() ? this.f4306d && !this.f4307e : this.f4306d;
    }

    public void e() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f4303a.f4172q;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            a(this.f4303a.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    private Activity f() {
        WeakReference<Activity> weakReference = this.f4311i;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void h() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "retry shown = " + com.aggmoread.sdk.z.b.m.b.a(this.f4308f) + ", has " + this.f4306d);
        if (this.f4306d || !com.aggmoread.sdk.z.b.m.b.a(this.f4308f)) {
            return;
        }
        this.f4304b.onADExposed();
        a.C0052a.C0053a c0053a = this.f4303a;
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(c0053a.f4168m, this.f4308f.f5046c, String.valueOf(c0053a.f4157b)));
        this.f4306d = true;
        this.f4308f.a();
    }

    private void i() {
        String a10 = this.f4303a.a();
        if (TextUtils.isEmpty(a10)) {
            this.f4304b.a(new e(50008, "跳转地址异常"));
            return;
        }
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f4305c.d().k(), this.f4303a.f4158c, a10, c.a.f5043a);
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public View a(View view, List<View> list, f fVar) {
        if (!TextUtils.isEmpty(this.f4303a.B)) {
            this.f4309g = new com.aggmoread.sdk.z.c.e.a(this.f4312j);
            Activity f10 = f();
            if (f10 == null && (view.getContext() instanceof Activity)) {
                f10 = (Activity) view.getContext();
            }
            this.f4309g.a(f10, this.f4303a.B);
        }
        ArrayList<View> arrayList = new ArrayList<>();
        this.f4304b = fVar;
        if (list != null) {
            if (list.indexOf(view) == -1) {
                com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "bindView enter, add clickable view");
                arrayList.add(view);
            }
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "bindView enter, view = " + view + " , clickableViews size = " + list.size());
            arrayList.addAll(list);
        } else {
            arrayList.add(view);
        }
        a(arrayList);
        if (!(view instanceof d)) {
            d dVar = new d(view.getContext());
            this.f4308f = dVar;
            dVar.a(this);
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            this.f4308f.addView(view);
            return this.f4308f;
        }
        d dVar2 = (d) view;
        this.f4308f = dVar2;
        dVar2.a(this);
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "bindView abort, title = " + getTitle());
        h();
        return view;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        List<a.C0052a.C0053a.c> list = this.f4303a.f4167l;
        if (list != null) {
            Iterator<a.C0052a.C0053a.c> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f4200a);
            }
        }
        return arrayList;
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void c() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "dispatchDraw enter , SdkHelper.isShown(nativeAdViewExt) = " + com.aggmoread.sdk.z.b.m.b.a(this.f4308f));
        h();
    }

    public int g() {
        return (int) this.f4303a.f4157b;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getDesc() {
        return this.f4303a.f4159d;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getIconUrl() {
        String str = this.f4303a.f4160e;
        return (str == null || !str.isEmpty()) ? getImageUrl() : this.f4303a.f4160e;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getImageUrl() {
        List<String> b10 = b();
        if (b10 == null || b10.size() <= 0) {
            return null;
        }
        return b10.get(0);
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getTitle() {
        return this.f4303a.f4158c;
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public int getVideoCurrentPosition() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public int getVideoDuration() {
        return 0;
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public boolean isAppAd() {
        return this.f4303a.c();
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public boolean isVideoAd() {
        return false;
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void onClick(View view) {
        String str;
        if (!d()) {
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "abort click , reason: hasExporsed = " + this.f4306d + " , isClicked = " + this.f4307e);
            return;
        }
        this.f4307e = true;
        this.f4304b.onADClicked();
        a.C0052a.C0053a c0053a = this.f4303a;
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(c0053a.f4169n, this.f4308f.f5046c, String.valueOf(c0053a.f4157b)));
        String str2 = this.f4303a.f4162g;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(this.f4303a.f4162g));
                intent.addFlags(268435456);
                this.f4305c.d().k().startActivity(intent);
                com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4303a.a(14), this.f4308f.f5046c, String.valueOf(this.f4303a.f4157b)));
                com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onStartAppSuccess");
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof ActivityNotFoundException) {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4303a.a(11), this.f4308f.f5046c, String.valueOf(this.f4303a.f4157b)));
                    str = "onAppNotExist";
                } else {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4303a.a(12), this.f4308f.f5046c, String.valueOf(this.f4303a.f4157b)));
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4303a.a(13), this.f4308f.f5046c, String.valueOf(this.f4303a.f4157b)));
                    str = "onStartAppFailed";
                }
                com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", str);
            }
        }
        if (!this.f4303a.c()) {
            try {
                i();
                return;
            } catch (com.aggmoread.sdk.z.b.u.f e11) {
                e11.printStackTrace();
                return;
            }
        }
        if (TextUtils.isEmpty(this.f4303a.B)) {
            e();
            return;
        }
        if (this.f4309g == null) {
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "PP null");
            this.f4309g = new com.aggmoread.sdk.z.c.e.a(this.f4312j);
            Activity f10 = f();
            if (f10 == null && (view.getContext() instanceof Activity)) {
                f10 = (Activity) view.getContext();
            }
            this.f4309g.a(f10, this.f4303a.B);
        }
        this.f4309g.a(view.getContext(), view);
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void onScrollChanged() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "scroll ");
        h();
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void pauseVideo() {
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public void resume() {
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void resumeVideo() {
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void startVideo() {
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void stopVideo() {
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void a(int i10) {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onWindowVisibilityChanged = " + i10);
        if (this.f4306d || i10 != 0) {
            return;
        }
        h();
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void a(g gVar, com.aggmoread.sdk.z.b.t.e eVar, e.a aVar) {
    }

    private void a(String str) {
        try {
            a.C0052a.C0053a c0053a = this.f4303a;
            new com.aggmoread.sdk.z.b.j.b(this.f4305c.d().k(), this.f4305c.d().j(), new a(this)).a(str, c0053a.f4172q, c0053a.f4158c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(ArrayList<View> arrayList) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            View view = arrayList.get(i10);
            if (view != null) {
                view.setFocusable(true);
                view.setClickable(true);
            }
        }
    }
}
