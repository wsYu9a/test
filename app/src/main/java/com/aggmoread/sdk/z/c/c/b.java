package com.aggmoread.sdk.z.c.c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.l.c;
import com.aggmoread.sdk.z.b.l.e;
import com.aggmoread.sdk.z.b.l.f;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.b.u.d;
import com.aggmoread.sdk.z.b.u.g;
import com.aggmoread.sdk.z.c.a.a;
import com.aggmoread.sdk.z.c.e.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.b.b implements c, d.c {

    /* renamed from: a */
    private a.C0101a.C0102a f5140a;

    /* renamed from: b */
    private f f5141b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.c.a.a f5142c;

    /* renamed from: f */
    private d f5145f;

    /* renamed from: g */
    private com.aggmoread.sdk.z.c.e.a f5146g;

    /* renamed from: h */
    private boolean f5147h;

    /* renamed from: i */
    private WeakReference<Activity> f5148i;

    /* renamed from: d */
    private volatile boolean f5143d = false;

    /* renamed from: e */
    private boolean f5144e = false;

    /* renamed from: j */
    private a.b f5149j = new C0107b();

    public class a extends com.aggmoread.sdk.z.b.j.c {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.b.g.c f5150b;

        public a(com.aggmoread.sdk.z.b.g.c cVar) {
            this.f5150b = cVar;
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
            com.aggmoread.sdk.z.b.q.a.a("onStartDownload", b.this.f5140a.f5101j, this.f5150b);
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onStartApkInstaller  ");
            com.aggmoread.sdk.z.b.q.a.a("onStartApkInstaller", b.this.f5140a.f5102k, this.f5150b);
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onApkInstalled  ");
            com.aggmoread.sdk.z.b.q.a.a("onApkInstalled", b.this.f5140a.f5106o, this.f5150b);
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onDownloadSuccess  ");
            com.aggmoread.sdk.z.b.q.a.a("onDownloadCompleted", b.this.f5140a.f5105n, this.f5150b);
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

    /* renamed from: com.aggmoread.sdk.z.c.c.b$b */
    public class C0107b implements a.b {
        public C0107b() {
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void a() {
            b bVar = b.this;
            bVar.a(bVar.f5145f.f5046c);
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void b() {
            if (b.this.f5146g != null) {
                b.this.f5146g.a();
                b.this.f5146g = null;
            }
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            b.this.f5147h = true;
        }
    }

    public b(com.aggmoread.sdk.z.c.a.a aVar, a.C0101a.C0102a c0102a) {
        this.f5140a = c0102a;
        this.f5142c = aVar;
        aVar.d().h();
        UUID.randomUUID().toString();
    }

    private boolean d() {
        return com.aggmoread.sdk.z.b.h.a.d().g() ? this.f5143d && !this.f5144e : this.f5143d;
    }

    private Activity e() {
        WeakReference<Activity> weakReference = this.f5148i;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void f() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "retry shown = " + com.aggmoread.sdk.z.b.m.b.a(this.f5145f) + ", has " + this.f5143d);
        if (this.f5143d || !com.aggmoread.sdk.z.b.m.b.a(this.f5145f)) {
            return;
        }
        this.f5141b.onADExposed();
        com.aggmoread.sdk.z.b.q.a.a("onAdExposure", this.f5140a.f5103l);
        this.f5143d = true;
        this.f5145f.a();
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public View a(View view, List<View> list, f fVar) {
        if (!TextUtils.isEmpty(this.f5140a.f5107p)) {
            this.f5146g = new com.aggmoread.sdk.z.c.e.a(this.f5149j);
            Activity e10 = e();
            if (e10 == null && (view.getContext() instanceof Activity)) {
                e10 = (Activity) view.getContext();
            }
            this.f5146g.a(e10, this.f5140a.f5107p);
        }
        ArrayList<View> arrayList = new ArrayList<>();
        this.f5141b = fVar;
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
            this.f5145f = dVar;
            dVar.a(this);
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            this.f5145f.addView(view);
            return this.f5145f;
        }
        d dVar2 = (d) view;
        this.f5145f = dVar2;
        dVar2.a(this);
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "bindView abort, title = " + getTitle());
        f();
        return view;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getDesc() {
        return this.f5140a.f5093b;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getIconUrl() {
        String str = this.f5140a.f5094c;
        return (str == null || !str.isEmpty()) ? getImageUrl() : this.f5140a.f5094c;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getImageUrl() {
        List<String> list = this.f5140a.f5098g;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getTitle() {
        return this.f5140a.f5092a;
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
        return this.f5140a.c();
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public boolean isVideoAd() {
        return false;
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void onClick(View view) {
        List<String> a10;
        String str;
        if (!d()) {
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "abort click , reason: hasExporsed = " + this.f5143d + " , isClicked = " + this.f5144e);
            return;
        }
        this.f5144e = true;
        this.f5141b.onADClicked();
        com.aggmoread.sdk.z.b.g.c cVar = this.f5145f.f5046c;
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "feedsListFrameLayout2 adUrlDefine = " + cVar);
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "action e x = " + (((float) cVar.f4469a) / ((float) cVar.f4473e)) + " ,y = " + (((float) cVar.f4470b) / ((float) cVar.f4474f)));
        com.aggmoread.sdk.z.b.q.a.a(IAdInterListener.AdCommandType.AD_CLICK, this.f5140a.f5104m, cVar);
        String str2 = this.f5140a.f5096e;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(this.f5140a.f5096e));
                intent.addFlags(268435456);
                this.f5142c.d().i().startActivity(intent);
                com.aggmoread.sdk.z.b.q.a.a("onStartAppSuccess", this.f5140a.a(3), cVar);
                com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onStartAppSuccess");
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof ActivityNotFoundException) {
                    a10 = this.f5140a.a(0);
                    str = "onAppNotExist";
                } else {
                    a10 = this.f5140a.a(2);
                    str = "onStartAppFailed";
                }
                com.aggmoread.sdk.z.b.q.a.a(str, a10, cVar);
                com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", str);
            }
        }
        if (!this.f5140a.c()) {
            try {
                b(cVar);
                return;
            } catch (com.aggmoread.sdk.z.b.u.f e11) {
                e11.printStackTrace();
                return;
            }
        }
        if (TextUtils.isEmpty(this.f5140a.f5107p)) {
            a(cVar);
            return;
        }
        if (this.f5146g == null) {
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "PP null");
            this.f5146g = new com.aggmoread.sdk.z.c.e.a(this.f5149j);
            Activity e12 = e();
            if (e12 == null && (view.getContext() instanceof Activity)) {
                e12 = (Activity) view.getContext();
            }
            this.f5146g.a(e12, this.f5140a.f5107p);
        }
        this.f5146g.a(view.getContext(), view);
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void onScrollChanged() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "scroll ");
        f();
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

    @Override // com.aggmoread.sdk.z.b.l.b
    public List<String> b() {
        List<String> list = this.f5140a.f5098g;
        return list == null ? new ArrayList() : list;
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void c() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "dispatchDraw enter , SdkHelper.isShown(nativeAdViewExt) = " + com.aggmoread.sdk.z.b.m.b.a(this.f5145f));
        f();
    }

    private void b(com.aggmoread.sdk.z.b.g.c cVar) {
        String str = this.f5140a.f5095d;
        if (TextUtils.isEmpty(str)) {
            this.f5141b.a(new e(50008, "跳转地址异常"));
            return;
        }
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.b.q.a.a(str, cVar);
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f5142c.d().i(), this.f5140a.f5092a, a10, c.a.f5043a);
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void a(int i10) {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onWindowVisibilityChanged = " + i10);
        if (this.f5143d || i10 != 0) {
            return;
        }
        f();
    }

    public void a(com.aggmoread.sdk.z.b.g.c cVar) {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f5140a.f5100i;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            a(this.f5140a.a(), cVar);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void a(g gVar, com.aggmoread.sdk.z.b.t.e eVar, e.a aVar) {
    }

    private void a(String str, com.aggmoread.sdk.z.b.g.c cVar) {
        try {
            a.C0101a.C0102a c0102a = this.f5140a;
            new com.aggmoread.sdk.z.b.j.b(this.f5142c.d().i(), this.f5142c.d().h(), new a(cVar)).a(str, c0102a.f5100i, c0102a.f5092a);
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
