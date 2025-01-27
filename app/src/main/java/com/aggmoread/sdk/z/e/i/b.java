package com.aggmoread.sdk.z.e.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.l.e;
import com.aggmoread.sdk.z.b.l.f;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.b.u.d;
import com.aggmoread.sdk.z.b.u.g;
import com.aggmoread.sdk.z.c.e.a;
import com.aggmoread.sdk.z.e.e.a;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.b.b implements com.aggmoread.sdk.z.b.l.c, d.c {

    /* renamed from: a */
    private a.C0192a.C0193a f6257a;

    /* renamed from: b */
    private f f6258b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.e.e.a f6259c;

    /* renamed from: f */
    private d f6262f;

    /* renamed from: g */
    private com.aggmoread.sdk.z.c.e.a f6263g;

    /* renamed from: h */
    private boolean f6264h;

    /* renamed from: i */
    private WeakReference<Activity> f6265i;

    /* renamed from: d */
    private volatile boolean f6260d = false;

    /* renamed from: e */
    private boolean f6261e = false;

    /* renamed from: j */
    private a.b f6266j = new c();

    public class a implements c.b {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.b.u.c.b
        public void a(String str) {
            if (b.this.f6258b != null) {
                b.this.f6258b.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "落地页打开失败： " + str));
            }
        }

        @Override // com.aggmoread.sdk.z.b.u.c.a
        public void onShow() {
        }
    }

    /* renamed from: com.aggmoread.sdk.z.e.i.b$b */
    public class C0201b extends com.aggmoread.sdk.z.b.j.c {
        public C0201b(b bVar) {
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

    public class c implements a.b {
        public c() {
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void a() {
            b.this.e();
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void b() {
            if (b.this.f6263g != null) {
                b.this.f6263g.a();
                b.this.f6263g = null;
            }
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            b.this.f6264h = true;
        }
    }

    public b(com.aggmoread.sdk.z.e.e.a aVar, a.C0192a.C0193a c0193a) {
        this.f6257a = c0193a;
        this.f6259c = aVar;
        aVar.d().j();
        UUID.randomUUID().toString();
    }

    private boolean d() {
        return com.aggmoread.sdk.z.b.h.a.d().g() ? this.f6260d && !this.f6261e : this.f6260d;
    }

    public void e() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f6257a.f6180p;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            a(this.f6257a.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    private Activity f() {
        WeakReference<Activity> weakReference = this.f6265i;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void h() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "retry shown = " + com.aggmoread.sdk.z.b.m.b.a(this.f6262f) + ", has " + this.f6260d);
        if (this.f6260d || !com.aggmoread.sdk.z.b.m.b.a(this.f6262f)) {
            return;
        }
        this.f6258b.onADExposed();
        com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6257a.f6177m, new BigDecimal(this.f6257a.f6166b)));
        this.f6260d = true;
        this.f6262f.a();
    }

    private void i() {
        String a10 = this.f6257a.a();
        if (TextUtils.isEmpty(a10)) {
            this.f6258b.a(new e(50008, "跳转地址异常"));
            return;
        }
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f6259c.d().k(), this.f6257a.f6167c, a10, new a());
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public View a(View view, List<View> list, f fVar) {
        if (!TextUtils.isEmpty(this.f6257a.f6181q)) {
            this.f6263g = new com.aggmoread.sdk.z.c.e.a(this.f6266j);
            Activity f10 = f();
            if (f10 == null && (view.getContext() instanceof Activity)) {
                f10 = (Activity) view.getContext();
            }
            this.f6263g.a(f10, this.f6257a.f6181q);
        }
        ArrayList<View> arrayList = new ArrayList<>();
        this.f6258b = fVar;
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
            this.f6262f = dVar;
            dVar.a(this);
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            this.f6262f.addView(view);
            return this.f6262f;
        }
        d dVar2 = (d) view;
        this.f6262f = dVar2;
        dVar2.a(this);
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "bindView abort, title = " + getTitle());
        h();
        return view;
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void c() {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "dispatchDraw enter , SdkHelper.isShown(nativeAdViewExt) = " + com.aggmoread.sdk.z.b.m.b.a(this.f6262f));
        h();
    }

    public int g() {
        return this.f6257a.f6166b;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getDesc() {
        return this.f6257a.f6168d;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getIconUrl() {
        String str = this.f6257a.f6169e;
        return (str == null || !str.isEmpty()) ? getImageUrl() : this.f6257a.f6169e;
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
        return this.f6257a.f6167c;
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
        return this.f6257a.c();
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public boolean isVideoAd() {
        return false;
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void onClick(View view) {
        if (!d()) {
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "abort click , reason: hasExporsed = " + this.f6260d + " , isClicked = " + this.f6261e);
            return;
        }
        this.f6261e = true;
        this.f6258b.onADClicked();
        com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6257a.f6178n, new BigDecimal(this.f6257a.f6166b)));
        String str = this.f6257a.f6171g;
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                String str2 = this.f6257a.f6180p;
                boolean c10 = TextUtils.isEmpty(str2) ? true : com.aggmoread.sdk.z.b.m.d.c(this.f6259c.d().k(), str2);
                com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "isInstalled " + c10 + ", packageName = " + str2);
                if (c10) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(this.f6257a.f6171g));
                    intent.addFlags(268435456);
                    this.f6259c.d().k().startActivity(intent);
                    com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onStartAppSuccess");
                    return;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (!this.f6257a.c()) {
            try {
                i();
                return;
            } catch (com.aggmoread.sdk.z.b.u.f e11) {
                e11.printStackTrace();
                this.f6258b.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "activity err"));
                return;
            }
        }
        if (TextUtils.isEmpty(this.f6257a.f6181q)) {
            e();
            return;
        }
        if (this.f6263g == null) {
            com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "PP null");
            this.f6263g = new com.aggmoread.sdk.z.c.e.a(this.f6266j);
            Activity f10 = f();
            if (f10 == null && (view.getContext() instanceof Activity)) {
                f10 = (Activity) view.getContext();
            }
            this.f6263g.a(f10, this.f6257a.f6181q);
        }
        this.f6263g.a(view.getContext(), view);
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

    @Override // com.aggmoread.sdk.z.b.l.b
    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        List<a.C0192a.C0193a.C0194a> list = this.f6257a.f6176l;
        if (list != null) {
            Iterator<a.C0192a.C0193a.C0194a> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f6183a);
            }
        }
        return arrayList;
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void a(int i10) {
        com.aggmoread.sdk.z.b.d.c("DSPNVEIFACEIMPL", "onWindowVisibilityChanged = " + i10);
        if (this.f6260d || i10 != 0) {
            return;
        }
        h();
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void a(g gVar, com.aggmoread.sdk.z.b.t.e eVar, e.a aVar) {
    }

    private void a(String str) {
        try {
            a.C0192a.C0193a c0193a = this.f6257a;
            new com.aggmoread.sdk.z.b.j.b(this.f6259c.d().k(), this.f6259c.d().j(), new C0201b(this)).a(str, c0193a.f6180p, c0193a.f6167c);
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
