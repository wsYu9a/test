package b.d.e.c.c.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.d.e.c.a.d;
import b.d.e.c.a.f.e;
import b.d.e.c.a.h.c;
import b.d.e.c.a.h.e;
import b.d.e.c.a.h.f;
import b.d.e.c.c.a.a;
import b.d.e.c.c.d.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.a.q.a;
import com.martian.ttbook.b.a.q.b;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes4.dex */
public class b extends b.d.e.c.a.b implements c, b.InterfaceC0288b {

    /* renamed from: a */
    private a.C0038a.C0039a f4736a;

    /* renamed from: b */
    private f f4737b;

    /* renamed from: c */
    private b.d.e.c.c.a.a f4738c;

    /* renamed from: f */
    private com.martian.ttbook.b.a.q.b f4741f;

    /* renamed from: g */
    private b.d.e.c.c.d.a f4742g;

    /* renamed from: h */
    private boolean f4743h;

    /* renamed from: i */
    private WeakReference<Activity> f4744i;

    /* renamed from: d */
    private volatile boolean f4739d = false;

    /* renamed from: e */
    private boolean f4740e = false;

    /* renamed from: j */
    private a.b f4745j = new C0043b();

    class a extends com.martian.ttbook.b.a.i.c {

        /* renamed from: b */
        final /* synthetic */ b.d.e.c.a.f.c f4746b;

        a(b.d.e.c.a.f.c cVar) {
            this.f4746b = cVar;
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void a() {
            super.a();
            d.k("DSPNVEIFACEIMPL", "apkIsDownLoading  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void b(long j2) {
            super.b(j2);
            d.k("DSPNVEIFACEIMPL", "onApkInstalled  ");
            b.d.e.c.a.k.a.c("onApkInstalled", b.this.f4736a.o, this.f4746b);
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void c(long j2, int i2, String str) {
            super.c(j2, i2, str);
            d.k("DSPNVEIFACEIMPL", "onApkInstalledError  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void d() {
            super.d();
            d.k("DSPNVEIFACEIMPL", "onStartDownload  ");
            b.d.e.c.a.k.a.c("onStartDownload", b.this.f4736a.f4725j, this.f4746b);
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void e(long j2) {
            super.e(j2);
            d.k("DSPNVEIFACEIMPL", "onDownloadSuccess  ");
            b.d.e.c.a.k.a.c("onDownloadCompleted", b.this.f4736a.n, this.f4746b);
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void f(long j2, int i2, String str) {
            super.f(j2, i2, str);
            d.k("DSPNVEIFACEIMPL", "onDownloadFail  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void g(long j2) {
            super.g(j2);
            d.k("DSPNVEIFACEIMPL", "onStartApkInstaller  ");
            b.d.e.c.a.k.a.c("onStartApkInstaller", b.this.f4736a.k, this.f4746b);
        }
    }

    /* renamed from: b.d.e.c.c.b.b$b */
    class C0043b implements a.b {
        C0043b() {
        }

        @Override // b.d.e.c.c.d.a.b
        public void d() {
            b.this.f4743h = true;
        }

        @Override // b.d.e.c.c.d.a.b
        public void e() {
            b bVar = b.this;
            bVar.e(bVar.f4741f.f15147b);
        }

        @Override // b.d.e.c.c.d.a.b
        public void f() {
            if (b.this.f4742g != null) {
                b.this.f4742g.c();
                b.this.f4742g = null;
            }
        }
    }

    public b(b.d.e.c.c.a.a aVar, a.C0038a.C0039a c0039a) {
        this.f4736a = c0039a;
        this.f4738c = aVar;
        String str = aVar.i().u() + "_" + UUID.randomUUID().toString();
    }

    public void e(b.d.e.c.a.f.c cVar) {
        Intent a2;
        Context a3 = com.martian.ttbook.b.a.g.a.f().a();
        String str = this.f4736a.f4724i;
        if (!com.martian.ttbook.b.a.k.d.d(a3, str) || (a2 = com.martian.ttbook.b.a.k.d.a(a3, str)) == null) {
            g(this.f4736a.a(), cVar);
            return;
        }
        d.k("DSPNVEIFACEIMPL", "intent = " + a2);
        a2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        a3.startActivity(a2);
    }

    private void g(String str, b.d.e.c.a.f.c cVar) {
        try {
            a.C0038a.C0039a c0039a = this.f4736a;
            new com.martian.ttbook.b.a.i.b(this.f4738c.i().v(), this.f4738c.i().u(), new a(cVar)).g(str, c0039a.f4724i, c0039a.f4716a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void h(ArrayList<View> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            View view = arrayList.get(i2);
            if (view != null) {
                view.setFocusable(true);
                view.setClickable(true);
            }
        }
    }

    private void k(b.d.e.c.a.f.c cVar) {
        String str = this.f4736a.f4719d;
        if (TextUtils.isEmpty(str)) {
            this.f4737b.b(new e(50008, "跳转地址异常"));
            return;
        }
        d.k("DSPNVEIFACEIMPL", "startWebActivity = " + str);
        String a2 = b.d.e.c.a.k.a.a(str, cVar);
        d.k("DSPNVEIFACEIMPL", "startWebActivity final = " + a2);
        com.martian.ttbook.b.a.q.a.a(this.f4738c.i().v(), this.f4736a.f4716a, a2, a.InterfaceC0286a.f15145a);
    }

    private boolean l() {
        return this.f4739d && !this.f4740e;
    }

    private Activity m() {
        WeakReference<Activity> weakReference = this.f4744i;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.martian.ttbook.b.a.q.b.InterfaceC0288b
    public void a() {
        if (!this.f4739d && com.martian.ttbook.b.a.k.b.d(this.f4741f)) {
            this.f4737b.onADExposed();
            b.d.e.c.a.k.a.d("onAdExposure", this.f4736a.l);
            this.f4739d = true;
        }
        d.k("DSPNVEIFACEIMPL", "dispatchDraw enter , SdkHelper.isShown(nativeAdViewExt) = " + com.martian.ttbook.b.a.k.b.d(this.f4741f));
    }

    @Override // b.d.e.c.a.h.e
    public void a(com.martian.ttbook.b.a.q.d dVar, com.martian.ttbook.b.a.p.c cVar, e.a aVar) {
    }

    @Override // b.d.e.c.a.h.c
    public View b(View view, List<View> list, f fVar) {
        if (!TextUtils.isEmpty(this.f4736a.p)) {
            this.f4742g = new b.d.e.c.c.d.a(this.f4745j);
            Activity m = m();
            if (m == null && (view.getContext() instanceof Activity)) {
                m = (Activity) view.getContext();
            }
            this.f4742g.e(m, this.f4736a.p);
        }
        ArrayList<View> arrayList = new ArrayList<>();
        this.f4737b = fVar;
        if (list != null) {
            if (list.indexOf(view) == -1) {
                d.k("DSPNVEIFACEIMPL", "bindView enter, add clickable view");
                arrayList.add(view);
            }
            d.k("DSPNVEIFACEIMPL", "bindView enter, view = " + view + " , clickableViews size = " + list.size());
            arrayList.addAll(list);
        } else {
            arrayList.add(view);
        }
        h(arrayList);
        if (view instanceof com.martian.ttbook.b.a.q.b) {
            com.martian.ttbook.b.a.q.b bVar = (com.martian.ttbook.b.a.q.b) view;
            this.f4741f = bVar;
            bVar.d(this);
            d.k("DSPNVEIFACEIMPL", "bindView abort, title = " + getTitle());
            return view;
        }
        com.martian.ttbook.b.a.q.b bVar2 = new com.martian.ttbook.b.a.q.b(view.getContext());
        this.f4741f = bVar2;
        bVar2.d(this);
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        this.f4741f.addView(view);
        return this.f4741f;
    }

    @Override // b.d.e.c.a.h.b
    public String getDesc() {
        return this.f4736a.f4717b;
    }

    @Override // b.d.e.c.a.h.b
    public String getIconUrl() {
        String str = this.f4736a.f4718c;
        return (str == null || !str.isEmpty()) ? getImageUrl() : this.f4736a.f4718c;
    }

    @Override // b.d.e.c.a.h.b
    public List<String> getImageList() {
        List<String> list = this.f4736a.f4722g;
        return list == null ? new ArrayList() : list;
    }

    @Override // b.d.e.c.a.h.b
    public String getImageUrl() {
        List<String> list = this.f4736a.f4722g;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // b.d.e.c.a.h.b
    public String getTitle() {
        return this.f4736a.f4716a;
    }

    @Override // b.d.e.c.a.h.e
    public int getVideoCurrentPosition() {
        return 0;
    }

    @Override // b.d.e.c.a.h.e
    public int getVideoDuration() {
        return 0;
    }

    @Override // b.d.e.c.a.h.c
    public boolean isAppAd() {
        return this.f4736a.d();
    }

    @Override // b.d.e.c.a.h.c
    public boolean isVideoAd() {
        return false;
    }

    @Override // com.martian.ttbook.b.a.q.b.InterfaceC0288b
    public void onClick(View view) {
        List<String> b2;
        String str;
        if (!l()) {
            d.k("DSPNVEIFACEIMPL", "abort click , reason: hasExporsed = " + this.f4739d + " , isClicked = " + this.f4740e);
            return;
        }
        this.f4740e = true;
        this.f4737b.onADClicked();
        b.d.e.c.a.f.c cVar = this.f4741f.f15147b;
        d.k("DSPNVEIFACEIMPL", "feedsListFrameLayout2 adUrlDefine = " + cVar);
        d.k("DSPNVEIFACEIMPL", "action e x = " + (((float) cVar.f4585a) / ((float) cVar.f4589e)) + " ,y = " + (((float) cVar.f4586b) / ((float) cVar.f4590f)));
        b.d.e.c.a.k.a.c(IAdInterListener.AdCommandType.AD_CLICK, this.f4736a.m, cVar);
        String str2 = this.f4736a.f4720e;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(this.f4736a.f4720e));
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                this.f4738c.i().v().startActivity(intent);
                b.d.e.c.a.k.a.c("onStartAppSuccess", this.f4736a.b(3), cVar);
                d.k("DSPNVEIFACEIMPL", "onStartAppSuccess");
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof ActivityNotFoundException) {
                    b2 = this.f4736a.b(0);
                    str = "onAppNotExist";
                } else {
                    b2 = this.f4736a.b(2);
                    str = "onStartAppFailed";
                }
                b.d.e.c.a.k.a.c(str, b2, cVar);
                d.k("DSPNVEIFACEIMPL", str);
            }
        }
        if (!this.f4736a.d()) {
            try {
                k(cVar);
                return;
            } catch (com.martian.ttbook.b.a.q.c e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (TextUtils.isEmpty(this.f4736a.p)) {
            e(cVar);
            return;
        }
        if (this.f4742g == null) {
            d.k("DSPNVEIFACEIMPL", "PP null");
            this.f4742g = new b.d.e.c.c.d.a(this.f4745j);
            Activity m = m();
            if (m == null && (view.getContext() instanceof Activity)) {
                m = (Activity) view.getContext();
            }
            this.f4742g.e(m, this.f4736a.p);
        }
        this.f4742g.d(view.getContext(), view);
    }

    @Override // b.d.e.c.a.h.e
    public void pauseVideo() {
    }

    @Override // b.d.e.c.a.h.c
    public void resume() {
    }

    @Override // b.d.e.c.a.h.e
    public void resumeVideo() {
    }

    @Override // b.d.e.c.a.h.e
    public void startVideo() {
    }

    @Override // b.d.e.c.a.h.e
    public void stopVideo() {
    }
}
