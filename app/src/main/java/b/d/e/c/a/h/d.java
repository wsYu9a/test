package b.d.e.c.a.h;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.d.e.c.a.f.b;
import b.d.e.c.a.h.e;
import b.d.e.c.a.l.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.a.p.d;
import com.martian.ttbook.b.a.q.a;
import com.martian.ttbook.b.a.q.b;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes4.dex */
public class d extends b.d.e.c.a.b implements b.d.e.c.a.h.c, b.d.e.c.a.h.e, View.OnClickListener, b.InterfaceC0288b {

    /* renamed from: a */
    static final String f4623a = d.class.getSimpleName();

    /* renamed from: b */
    private b.a.C0022a f4624b;

    /* renamed from: c */
    private b.d.e.c.a.h.f f4625c;

    /* renamed from: d */
    private b.d.e.c.a.f.b f4626d;

    /* renamed from: g */
    private com.martian.ttbook.b.a.q.b f4629g;

    /* renamed from: h */
    private com.martian.ttbook.b.a.p.d f4630h;

    /* renamed from: j */
    private Context f4632j;

    /* renamed from: e */
    private boolean f4627e = false;

    /* renamed from: f */
    private volatile int f4628f = 0;

    /* renamed from: i */
    private volatile long f4631i = 0;

    class a extends f.a {
        a(d dVar, b.d.e.c.a.f.c cVar) {
        }
    }

    class b extends com.martian.ttbook.b.a.i.c {

        /* renamed from: b */
        final /* synthetic */ b.d.e.c.a.f.c f4633b;

        b(b.d.e.c.a.f.c cVar) {
            this.f4633b = cVar;
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void a() {
            super.a();
            b.d.e.c.a.d.k("JHAIMPTAG", "apkIsDownLoading  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void b(long j2) {
            super.b(j2);
            b.d.e.c.a.d.k("JHAIMPTAG", "onApkInstalled  ");
            b.d.e.c.a.k.a.c("onApkInstalled", d.this.f4624b.n(), this.f4633b);
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void c(long j2, int i2, String str) {
            super.c(j2, i2, str);
            b.d.e.c.a.d.k("JHAIMPTAG", "onApkInstalledError  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void d() {
            super.d();
            b.d.e.c.a.d.k("JHAIMPTAG", "onStartDownload  ");
            b.d.e.c.a.k.a.c("onStartDownload", d.this.f4624b.l, this.f4633b);
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void e(long j2) {
            super.e(j2);
            b.d.e.c.a.d.k("JHAIMPTAG", "onDownloadSuccess  ");
            b.d.e.c.a.k.a.c("onDownloadCompleted", d.this.f4624b.f(), this.f4633b);
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void f(long j2, int i2, String str) {
            super.f(j2, i2, str);
            b.d.e.c.a.d.k("JHAIMPTAG", "onDownloadFail  ");
        }

        @Override // com.martian.ttbook.b.a.i.c
        public void g(long j2) {
            super.g(j2);
            b.d.e.c.a.d.k("JHAIMPTAG", "onStartApkInstaller  ");
            b.d.e.c.a.k.a.c("onStartApkInstaller", d.this.f4624b.j(), this.f4633b);
        }
    }

    class c implements d.h {

        /* renamed from: a */
        final /* synthetic */ e.a f4635a;

        c(d dVar, e.a aVar) {
            this.f4635a = aVar;
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void a(MediaPlayer mediaPlayer) {
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void a(boolean z) {
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void b(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4635a;
            if (aVar != null) {
                aVar.f();
            }
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void c(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4635a;
            if (aVar != null) {
                aVar.e();
            }
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void d(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4635a;
            if (aVar != null) {
                aVar.d();
            }
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void e(MediaPlayer mediaPlayer) {
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void f(MediaPlayer mediaPlayer) {
        }

        @Override // com.martian.ttbook.b.a.p.d.h
        public void g(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4635a;
            if (aVar != null) {
                aVar.a();
                this.f4635a.e();
            }
        }
    }

    /* renamed from: b.d.e.c.a.h.d$d */
    class C0025d implements MediaPlayer.OnPreparedListener {

        /* renamed from: a */
        final /* synthetic */ e.a f4636a;

        C0025d(d dVar, e.a aVar) {
            this.f4636a = aVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4636a;
            if (aVar != null) {
                aVar.a(mediaPlayer.getDuration());
                this.f4636a.b();
            }
        }
    }

    class e implements MediaPlayer.OnCompletionListener {

        /* renamed from: a */
        final /* synthetic */ e.a f4637a;

        e(d dVar, e.a aVar) {
            this.f4637a = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4637a;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    class f implements MediaPlayer.OnErrorListener {

        /* renamed from: a */
        final /* synthetic */ e.a f4638a;

        f(d dVar, e.a aVar) {
            this.f4638a = aVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            e.a aVar = this.f4638a;
            if (aVar == null) {
                return false;
            }
            aVar.b(new b.d.e.c.a.f.e(i2, "extra msg: " + i3));
            return false;
        }
    }

    public d(b.d.e.c.a.f.b bVar, b.a.C0022a c0022a) {
        this.f4624b = c0022a;
        this.f4626d = bVar;
        String str = bVar.k().v() + "_" + UUID.randomUUID().toString();
    }

    private void d(b.d.e.c.a.f.c cVar) {
        String str = this.f4624b.f4571b;
        if (TextUtils.isEmpty(str)) {
            this.f4625c.b(new b.d.e.c.a.f.e(50008, "跳转地址异常"));
            return;
        }
        b.d.e.c.a.d.k("JHAIMPTAG", "startWebActivity = " + str);
        String a2 = b.d.e.c.a.k.a.a(str, cVar);
        b.d.e.c.a.d.k("JHAIMPTAG", "startWebActivity final = " + a2);
        com.martian.ttbook.b.a.q.a.a(this.f4626d.k().w(), this.f4624b.f4572c, a2, a.InterfaceC0286a.f15145a);
    }

    private void e(String str, b.d.e.c.a.f.c cVar) {
        try {
            b.a.C0022a c0022a = this.f4624b;
            new com.martian.ttbook.b.a.i.b(this.f4626d.k().w(), this.f4626d.k().v(), new b(cVar)).g(str, c0022a.f4570a, c0022a.f4572c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void f(ArrayList<View> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            View view = arrayList.get(i2);
            if (view != null) {
                view.setFocusable(true);
                view.setClickable(true);
            }
        }
    }

    private boolean g() {
        return this.f4627e && this.f4628f < 2 && System.currentTimeMillis() - this.f4631i > 5000;
    }

    @Override // com.martian.ttbook.b.a.q.b.InterfaceC0288b
    public void a() {
        if (!this.f4627e && com.martian.ttbook.b.a.k.b.d(this.f4629g)) {
            this.f4625c.onADExposed();
            b.d.e.c.a.k.a.d("onAdExposure", this.f4624b.q);
            this.f4627e = true;
        }
        b.d.e.c.a.d.k(f4623a, "dispatchDraw enter , SdkHelper.isShown(nativeAdViewExt) = " + com.martian.ttbook.b.a.k.b.d(this.f4629g));
    }

    @Override // b.d.e.c.a.h.e
    public void a(com.martian.ttbook.b.a.q.d dVar, com.martian.ttbook.b.a.p.c cVar, e.a aVar) {
        String str;
        if (this.f4629g == null) {
            str = "container shouldn't be null!";
        } else if (dVar == null) {
            str = "media view shouldn't be null!";
        } else if (dVar.getVisibility() != 0) {
            str = "media view should be visible!";
        } else if (!isVideoAd()) {
            str = "The native ad doesn't contain video!";
        } else {
            if (com.martian.ttbook.b.a.k.b.e(this.f4629g, dVar)) {
                com.martian.ttbook.b.a.p.d d2 = dVar.d();
                com.martian.ttbook.b.a.p.a a2 = dVar.a();
                if (a2 instanceof com.martian.ttbook.b.a.p.b) {
                    if (cVar == null && this.f4626d.k() != null) {
                        cVar = this.f4626d.k().y();
                    }
                    if (cVar != null) {
                        ((com.martian.ttbook.b.a.p.b) a2).S(cVar.b());
                    }
                }
                if (d2 != null) {
                    this.f4630h = d2;
                    d2.m(new c(this, aVar));
                    d2.i(new C0025d(this, aVar));
                    d2.g(new e(this, aVar));
                    d2.h(new f(this, aVar));
                    String M = this.f4624b.M();
                    if (TextUtils.isEmpty(M)) {
                        return;
                    }
                    d2.o(M);
                    d2.requestFocus();
                    d2.d();
                    return;
                }
                return;
            }
            str = "The media view not in container !";
        }
        b.d.e.c.a.d.k("JHAIMPTAG", str);
    }

    @Override // b.d.e.c.a.h.c
    public View b(View view, List<View> list, b.d.e.c.a.h.f fVar) {
        this.f4632j = view.getContext();
        ArrayList<View> arrayList = new ArrayList<>();
        this.f4625c = fVar;
        if (list != null) {
            if (list.indexOf(view) == -1) {
                b.d.e.c.a.d.k("JHAIMPTAG", "bindView enter, add clickable view");
                arrayList.add(view);
            }
            b.d.e.c.a.d.k("JHAIMPTAG", "bindView enter, view = " + view + " , clickableViews size = " + list.size());
            arrayList.addAll(list);
        } else {
            arrayList.add(view);
        }
        f(arrayList);
        if (view instanceof com.martian.ttbook.b.a.q.b) {
            com.martian.ttbook.b.a.q.b bVar = (com.martian.ttbook.b.a.q.b) view;
            this.f4629g = bVar;
            bVar.d(this);
            return view;
        }
        com.martian.ttbook.b.a.q.b bVar2 = new com.martian.ttbook.b.a.q.b(view.getContext());
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        this.f4629g = bVar2;
        bVar2.d(this);
        this.f4629g.addView(view);
        return this.f4629g;
    }

    @Override // b.d.e.c.a.h.b
    public String getDesc() {
        List<String> v = this.f4624b.v();
        if (v == null || v.size() <= 0) {
            return null;
        }
        return v.get(0);
    }

    @Override // b.d.e.c.a.h.b
    public String getIconUrl() {
        List<String> I = this.f4624b.I();
        if (I == null || I.size() <= 0) {
            return null;
        }
        return I.get(0);
    }

    @Override // b.d.e.c.a.h.b
    public List<String> getImageList() {
        return this.f4624b.K();
    }

    @Override // b.d.e.c.a.h.b
    public String getImageUrl() {
        List<String> K = this.f4624b.K();
        if (K == null || K.size() <= 0) {
            return null;
        }
        return K.get(0);
    }

    @Override // b.d.e.c.a.h.b
    public String getTitle() {
        return this.f4624b.f4572c;
    }

    @Override // b.d.e.c.a.h.e
    public int getVideoCurrentPosition() {
        com.martian.ttbook.b.a.p.d dVar = this.f4630h;
        if (dVar != null) {
            return dVar.f();
        }
        return 0;
    }

    @Override // b.d.e.c.a.h.e
    public int getVideoDuration() {
        com.martian.ttbook.b.a.p.d dVar = this.f4630h;
        if (dVar != null) {
            return dVar.e();
        }
        return 0;
    }

    @Override // b.d.e.c.a.h.c
    public boolean isAppAd() {
        return this.f4624b.P();
    }

    @Override // b.d.e.c.a.h.c
    public boolean isVideoAd() {
        return !TextUtils.isEmpty(this.f4624b.M());
    }

    @Override // android.view.View.OnClickListener, com.martian.ttbook.b.a.q.b.InterfaceC0288b
    public void onClick(View view) {
        Intent a2;
        List<String> b2;
        String str;
        if (!g()) {
            b.d.e.c.a.d.k("JHAIMPTAG", "abort click , reason: hasExporsed = " + this.f4627e + " , isClicked = " + this.f4628f);
            return;
        }
        this.f4631i = System.currentTimeMillis();
        this.f4628f++;
        this.f4625c.onADClicked();
        b.d.e.c.a.f.c cVar = this.f4629g.f15147b;
        String str2 = f4623a;
        b.d.e.c.a.d.k(str2, "feedsListFrameLayout2 juHeApiAdUrlDefine = " + cVar);
        b.d.e.c.a.d.k(str2, "action e x = " + (((float) cVar.f4585a) / ((float) cVar.f4589e)) + " ,y = " + (((float) cVar.f4586b) / ((float) cVar.f4590f)));
        b.d.e.c.a.k.a.c(IAdInterListener.AdCommandType.AD_CLICK, this.f4624b.r, cVar);
        String str3 = this.f4624b.f4573d;
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            try {
                List<b.a.C0022a.C0023a> a3 = this.f4624b.a();
                if (a3 != null) {
                    b.d.e.c.a.d.k(str2, "deepLinkTracks = " + a3.toString());
                }
                Intent intent = new Intent();
                intent.setData(Uri.parse(this.f4624b.f4573d));
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                this.f4626d.k().w().startActivity(intent);
                b.d.e.c.a.k.a.c("onStartAppSuccess", this.f4624b.b(3), cVar);
                b.d.e.c.a.d.k(str2, "onStartAppSuccess");
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                String str4 = f4623a;
                b.d.e.c.a.d.f(str4, "e %s", e2);
                if (e2 instanceof ActivityNotFoundException) {
                    b2 = this.f4624b.b(0);
                    str = "onAppNotExist";
                } else {
                    b2 = this.f4624b.b(2);
                    str = "onStartAppFailed";
                }
                b.d.e.c.a.k.a.c(str, b2, cVar);
                b.d.e.c.a.d.k(str4, str);
            }
        }
        if (!this.f4624b.P()) {
            try {
                d(cVar);
                return;
            } catch (com.martian.ttbook.b.a.q.c e3) {
                e3.printStackTrace();
                return;
            }
        }
        Context applicationContext = this.f4632j.getApplicationContext();
        String L = this.f4624b.L();
        if (com.martian.ttbook.b.a.k.d.d(applicationContext, L) && (a2 = com.martian.ttbook.b.a.k.d.a(applicationContext, L)) != null) {
            b.d.e.c.a.d.k("JHAIMPTAG", "intent = " + a2);
            a2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            applicationContext.startActivity(a2);
            return;
        }
        if (this.f4624b.z() != 2) {
            e(this.f4624b.D(), cVar);
            return;
        }
        String str5 = f4623a;
        b.d.e.c.a.d.k(str5, "clickUrl = " + this.f4624b.r());
        String a4 = b.d.e.c.a.k.a.a(this.f4624b.r(), cVar);
        b.d.e.c.a.d.k(str5, "rClickUrl = " + a4);
        b.d.e.c.a.l.f.a(a4, new a(this, cVar));
    }

    @Override // b.d.e.c.a.h.e
    public void pauseVideo() {
        b.d.e.c.a.d.k("JHAIMPTAG", "pauseVideo");
        com.martian.ttbook.b.a.p.d dVar = this.f4630h;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // b.d.e.c.a.h.c
    public void resume() {
        b.d.e.c.a.d.k("JHAIMPTAG", "resume");
        resumeVideo();
    }

    @Override // b.d.e.c.a.h.e
    public void resumeVideo() {
        b.d.e.c.a.d.k("JHAIMPTAG", "resumeVideo");
        com.martian.ttbook.b.a.p.d dVar = this.f4630h;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // b.d.e.c.a.h.e
    public void startVideo() {
        b.d.e.c.a.d.k("JHAIMPTAG", "startVideo");
        com.martian.ttbook.b.a.p.d dVar = this.f4630h;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // b.d.e.c.a.h.e
    public void stopVideo() {
        b.d.e.c.a.d.k("JHAIMPTAG", "stopVideo");
        com.martian.ttbook.b.a.p.d dVar = this.f4630h;
        if (dVar != null) {
            dVar.Z();
        }
    }
}
