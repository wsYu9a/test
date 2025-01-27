package com.aggmoread.sdk.z.b.r;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.common.C;
import com.aggmoread.sdk.z.b.t.a;
import com.aggmoread.sdk.z.b.t.c;
import com.aggmoread.sdk.z.b.t.f;
import com.sigmob.sdk.base.common.y;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class c {
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private TextView J;

    /* renamed from: a */
    private Activity f4798a;

    /* renamed from: b */
    private c.b f4799b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.b.t.f f4800c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.t.b f4801d;

    /* renamed from: f */
    private com.aggmoread.sdk.z.b.m.m f4803f;

    /* renamed from: g */
    private CountDownTimer f4804g;

    /* renamed from: h */
    private TextView f4805h;

    /* renamed from: i */
    private TextView f4806i;

    /* renamed from: j */
    private TextView f4807j;

    /* renamed from: k */
    private ViewGroup f4808k;

    /* renamed from: l */
    private ViewGroup f4809l;

    /* renamed from: m */
    private ViewGroup f4810m;

    /* renamed from: n */
    private ViewGroup f4811n;

    /* renamed from: o */
    private View f4812o;

    /* renamed from: p */
    private View f4813p;

    /* renamed from: q */
    private View f4814q;

    /* renamed from: y */
    private com.aggmoread.sdk.z.b.t.d f4822y;

    /* renamed from: z */
    private com.aggmoread.sdk.z.b.s.a f4823z;

    /* renamed from: e */
    private boolean f4802e = true;

    /* renamed from: r */
    private boolean f4815r = false;

    /* renamed from: s */
    private boolean f4816s = false;

    /* renamed from: t */
    private final AtomicBoolean f4817t = new AtomicBoolean();

    /* renamed from: u */
    private final AtomicBoolean f4818u = new AtomicBoolean();

    /* renamed from: v */
    private final AtomicBoolean f4819v = new AtomicBoolean();

    /* renamed from: w */
    private AtomicBoolean f4820w = new AtomicBoolean();

    /* renamed from: x */
    private long f4821x = 0;
    private boolean K = true;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.u();
        }
    }

    public class b implements p<Bitmap> {
        public b() {
        }

        @Override // com.aggmoread.sdk.z.b.r.c.p
        public void a(Bitmap bitmap) {
            if (bitmap == null || c.this.f4820w == null || !c.this.f4820w.compareAndSet(false, true)) {
                return;
            }
            c.this.C.setImageBitmap(bitmap);
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.r.c$c */
    public class ViewOnClickListenerC0090c implements View.OnClickListener {
        public ViewOnClickListenerC0090c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f4799b != null) {
                c.this.f4799b.a();
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f4827b;

        /* renamed from: c */
        final /* synthetic */ p f4828c;

        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f4829b;

            public a(Bitmap bitmap) {
                this.f4829b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                p pVar = d.this.f4828c;
                if (pVar != null) {
                    pVar.a(this.f4829b);
                }
            }
        }

        public d(c cVar, String str, p pVar) {
            this.f4827b = str;
            this.f4828c = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                URL url = new URL(this.f4827b);
                com.aggmoread.sdk.z.b.d.a("ApiRewardVideoViewTAG", "DD", url.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.getDoInput();
                httpURLConnection.connect();
                new Handler(Looper.getMainLooper()).post(new a(BitmapFactory.decodeStream(httpURLConnection.getInputStream())));
            } catch (MalformedURLException | IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    public class e implements p<Bitmap> {

        /* renamed from: a */
        final /* synthetic */ ImageView f4831a;

        public e(c cVar, ImageView imageView) {
            this.f4831a = imageView;
        }

        @Override // com.aggmoread.sdk.z.b.r.c.p
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                this.f4831a.setImageBitmap(bitmap);
            }
        }
    }

    public class f extends CountDownTimer {
        public f(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "startTimeOutCountDown onTimerFinish");
            c.this.a();
            if (c.this.f4799b != null) {
                c.this.f4799b.a("视频资源加载超时，广告播放失败!");
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f4800c.a(c.this.m());
            c.this.f4800c.d();
            c.this.E();
        }
    }

    public class h implements a.h {
        public h() {
        }

        @Override // com.aggmoread.sdk.z.b.t.a.h
        public void a(float f10) {
            if (c.this.f4799b != null) {
                c.this.f4799b.a(f10);
            }
        }
    }

    public class i implements MediaPlayer.OnCompletionListener {
        public i() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (c.this.f4799b != null) {
                c.this.f4799b.onVideoComplete();
            }
            c.this.f4816s = true;
            c.this.a();
        }
    }

    public class j implements MediaPlayer.OnErrorListener {
        public j() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            if (c.this.f4799b == null) {
                return false;
            }
            c.this.f4799b.a("视频播放失败: " + i10);
            return false;
        }
    }

    public class k implements f.j {

        public class a extends com.aggmoread.sdk.z.b.m.m {

            /* renamed from: f */
            final /* synthetic */ long f4838f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j10, long j11, long j12) {
                super(j10, j11);
                this.f4838f = j12;
            }

            @Override // com.aggmoread.sdk.z.b.m.m
            public void a(long j10, long j11) {
                com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onTimerTick millisUntilFinished " + j10 + ", duration " + j11 + ", videoCountDownTimer = " + c.this.f4803f);
                if (j11 >= y.f.f18076n && c.this.f4799b != null && c.this.f4819v.compareAndSet(false, true)) {
                    c.this.f4799b.d();
                }
                if (j10 <= 1000) {
                    c.this.f4805h.setVisibility(4);
                } else {
                    c.this.f4805h.setText(String.format("%ss", Long.valueOf(j10 / 1000)));
                }
                c.this.b(j11);
                if (c.this.f4815r) {
                    return;
                }
                long j12 = c.this.j();
                if (j12 <= this.f4838f && j12 > 0) {
                    j10 = j12 - j11;
                }
                if (j10 >= 1000) {
                    c.this.a(j10);
                } else {
                    c.this.K();
                }
            }

            @Override // com.aggmoread.sdk.z.b.m.m
            public void c() {
                com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onTimerFinish ");
                c.this.H();
            }
        }

        public k() {
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void a(MediaPlayer mediaPlayer) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onStart");
            c.this.K = true;
            long e10 = c.this.f4800c.e();
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "videoDuration " + e10);
            c.this.G();
            if (c.this.f4818u.compareAndSet(false, true) && c.this.f4799b != null) {
                c.this.f4799b.a(c.this.f4823z);
            }
            if (c.this.f4803f == null) {
                c.this.f4803f = new a(e10, 1000L, e10);
            }
            c.this.F();
            c.this.I();
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void b(MediaPlayer mediaPlayer) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onBufferingEnd");
            c.this.C();
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void c(MediaPlayer mediaPlayer) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onBufferingStart");
            c.this.w();
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void d(MediaPlayer mediaPlayer) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onStartLoading");
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void e(MediaPlayer mediaPlayer) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onResume");
            c.this.K = true;
            c.this.C();
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void f(MediaPlayer mediaPlayer) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onPause");
            c.this.K = false;
            c.this.w();
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void g(MediaPlayer mediaPlayer) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onCached");
            if (c.this.f4799b != null) {
                c.this.f4799b.onVideoCached();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void a(boolean z10) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "onScaleChange ");
        }
    }

    public class l implements MediaPlayer.OnInfoListener {
        public l() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            if (i10 != 805) {
                return false;
            }
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "ApiVideoViewTAG MEDIA_INFO_VIDEO_NOT_PLAYING ");
            c.this.f4800c.b();
            c.this.f4800c.q();
            if (c.this.f4799b == null) {
                return false;
            }
            c.this.f4799b.a("视频素材播放失败!");
            return false;
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.u();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f4802e = !r2.f4802e;
            c.this.L();
        }
    }

    public interface p<T> {
        void a(T t10);
    }

    private void A() {
        TextView textView;
        int i10;
        this.f4807j.setVisibility(4);
        this.f4807j.setOnClickListener(new n());
        this.A.setOnClickListener(new o());
        L();
        if (t()) {
            textView = this.f4805h;
            i10 = 0;
        } else {
            textView = this.f4805h;
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    public void C() {
        com.aggmoread.sdk.z.b.m.m mVar = this.f4803f;
        if (mVar == null || !this.K) {
            return;
        }
        mVar.e();
    }

    public void E() {
        com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "startTimeOutCountDown");
        CountDownTimer countDownTimer = this.f4804g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        f fVar = new f(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, 1000L);
        this.f4804g = fVar;
        fVar.start();
    }

    public void F() {
        com.aggmoread.sdk.z.b.m.m mVar = this.f4803f;
        if (mVar != null) {
            mVar.f();
        }
    }

    public void G() {
        com.aggmoread.sdk.z.b.d.c("ApiRewardVideoViewTAG", "stopTimeOutCountDown");
        CountDownTimer countDownTimer = this.f4804g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f4804g = null;
        }
    }

    public void H() {
        com.aggmoread.sdk.z.b.m.m mVar = this.f4803f;
        if (mVar != null) {
            mVar.g();
            this.f4803f = null;
        }
        TextView textView = this.f4805h;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    public void I() {
        if (this.f4814q.getVisibility() != 0) {
            this.f4814q.setVisibility(0);
        }
    }

    private void J() {
        AtomicBoolean atomicBoolean;
        if (this.C != null && (atomicBoolean = this.f4820w) != null) {
            if (atomicBoolean.get()) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(4);
                this.f4820w = null;
            }
        }
        ViewGroup viewGroup = this.f4811n;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f4809l;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
            this.f4809l.removeAllViews();
        }
    }

    public void K() {
        this.f4815r = true;
        if (this.f4813p.getVisibility() != 0) {
            this.f4813p.setVisibility(0);
        }
        ViewGroup viewGroup = this.f4810m;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        View view = this.f4812o;
        if (view != null) {
            view.setVisibility(0);
        }
        c.b bVar = this.f4799b;
        if (bVar != null) {
            bVar.a(new HashMap());
        }
    }

    public void L() {
        ImageView imageView;
        String str;
        if (this.f4802e) {
            imageView = this.A;
            str = "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAe1JREFUWEftlj1oVEEUhb9T2QexkQSxE8UmoE0QG0ljG/wBRQhooRb+lCoK2ihqIYhgoaJiEAtL2SadiGCn2ETsYiF2Wsox9zELw8t7mQ2bvLXYgYXdnTf3fHvuz6wY8dKI9RkDjB1YtwO2LwLngT/AG0nXhynkdQHYvgdcyAS/SNrTCYDtk8CzJHYKeBrvtWLBpgPY3gt8BLYAVyTdsu0uAT4A+4EXkk6EcGcAth8BZ4BlSdv7ducAtg8CT4Dnkq7VU2J7DngNXJZ0N99flT/bO1by23/NAzPpwFZJv1oA4vnvae++pOiUamXi8fFGvWuaAD4DuzPKZWBO0vucvJ6CmtBjSadL4lUNNdhVFRfwFngHvJT0u+25vAtqggvA0XRu1S/vx2sFKLVXWxHWIBptL9XAQO31XwJsaAqAA8CSpB9Nk24zizBabSITXZB0bK0iTHNgcaPa8BJwGJgCdqagPUmzbW1oezpuxsIguh13SXEO1ESOAHeASeCmpKtNg6gpRYN+V7zJbB8CeingcUmv0oQbqFtKIEWAJHYOeJCCzUrqdXYZZZYHQID8BfYBn6pR2sX/gQwiUhEp+QrsAn5K2layea39gVKQAUQxRlFGccZ6KOlsZwAZSLRnuP9tGPEqhcMGGPb8GGDkDvwD88z/ISmS/mAAAAAASUVORK5CYII=";
        } else {
            imageView = this.A;
            str = "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAqNJREFUWEftlk2ITlEYx3//lZVEYhBJUT43JjYSRWMhFkKIRA2FBVKzIB+RGrIRMRvUiKLIhmZDTSRMSWSDrAb5SBoLCz3uM513Ol736503vZv31K3bvfec53f+z/95zhUNHmpwfJoATQVqVsDM9gF7gJ/ATUlH6jFyTQBmdgbYGwV8JWlONYCZzQBOA2+Bo5K+Z0GWBjCzLcCVsNBW4LLfK5EgBWA88DE8fx4gbqdBlAIws3nAE2AEcFDSCTOzLAB/bmarglpLQuB1km5UQ5QFeAwsBLolbQ4BcgEqgczsJNCRBVEIYGYXgB1Av6RJ0cL/AJjZTqCl2phm5qnzFPZJao1VSMvf1CS/lWs7sChMGCvpawHAfcAlv5UAt0v6EtSaADwDJvpmJHVV1kkDeAnMjij7gbWSHsXkaR4ws1nAMWAN8FTSggjYy/Uw0CtpcR7AoLSAu/YecFXSQIrTMz1gZt3AJmCppAdBhflBhTeSphcCpJVXkQLRbr1MLwHnJe0KAKOBb8CApJGNABgFeEP6JKnlfwOkpWAu8ALokdRWCAC4UTxfH9I62DBM2A5c9BYt6UAegJfamCjodUkbypjQzCpl2Ot1L+l95AsvQzdiq6S+PID9iVtXAlOAaeHDv2QLpspqRMuAbZJ+pJRgV6KoN7WhkdsJzWw9cAqYDByXdChatGwrrtT/O2C1JO8z5QDCTpe7ccKMjZKuZSlQVaaec79c9l/AikpPqAkgBNsNnA0T2yT15J2GZubt2P3g4yHQKelOmpkLD6NIcgdwkN+At9hBI2X8D3hLPpecoHcldaYFzjRh3sdm5qnwlLwGZgKfJY3Lm1P0rrQCIRVuRjelm9PHUKstCpT1viaAKB1enq6+//PVNYYFUFfEqslNgIYr8Ad+qj8wE2M/IAAAAABJRU5ErkJggg==";
        }
        com.aggmoread.sdk.z.b.m.j.a(imageView, str);
        com.aggmoread.sdk.z.b.t.f fVar = this.f4800c;
        if (fVar != null) {
            fVar.b(this.f4802e);
        }
    }

    private String e() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.d() : "";
    }

    private String g() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.e() : "";
    }

    private String i() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.b() : "";
    }

    public long j() {
        if (this.f4822y != null) {
            return r0.h() * 1000;
        }
        return 0L;
    }

    private int l() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        if (dVar != null) {
            return dVar.i();
        }
        return 0;
    }

    public String m() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.j() : "";
    }

    private View n() {
        LinearLayout linearLayout = new LinearLayout(this.f4798a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d);
        layoutParams.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d);
        layoutParams.bottomMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d);
        int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 15.0d);
        linearLayout.setPadding(a10, a10, a10, a10);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(com.aggmoread.sdk.z.b.m.b.a(Color.parseColor("#ffffff"), 1.0f, com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d), 0, 0));
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.f4798a);
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.f4798a);
        this.B = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.B.setLayoutParams(new ViewGroup.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 80.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 80.0d)));
        com.aggmoread.sdk.z.b.m.j.a(this.B, "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");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#707070"));
        colorDrawable.setAlpha(33);
        this.B.setBackground(colorDrawable);
        linearLayout2.addView(this.B);
        LinearLayout linearLayout3 = new LinearLayout(this.f4798a);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 8.0d);
        linearLayout3.setLayoutParams(layoutParams2);
        this.E = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        this.E.setSingleLine();
        this.E.setTextSize(16.0f);
        this.E.setGravity(16);
        this.E.setTextColor(Color.parseColor("#515151"));
        this.E.setText("Title");
        this.E.setLayoutParams(layoutParams3);
        linearLayout3.addView(this.E);
        this.F = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        this.F.setSingleLine();
        this.F.setTextSize(14.0f);
        this.F.setGravity(16);
        this.F.setTextColor(Color.parseColor("#8a8a8a"));
        this.F.setText("Desc");
        this.F.setLayoutParams(layoutParams4);
        linearLayout3.addView(this.F);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int a11 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 10.0d);
        layoutParams5.topMargin = a11;
        textView.setLayoutParams(layoutParams5);
        textView.setText("查看详情");
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setTextSize(15.0f);
        textView.setPadding(a11, a11, a11, a11);
        textView.setGravity(17);
        textView.setBackground(com.aggmoread.sdk.z.b.m.b.a(Color.parseColor("#0a81fc"), 1.0f, com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 6.0d), 0, 0));
        linearLayout.addView(textView);
        return linearLayout;
    }

    private ViewGroup o() {
        int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 10.0d);
        int a11 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d);
        FrameLayout frameLayout = new FrameLayout(this.f4798a);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#000000"));
        ImageView imageView = new ImageView(this.f4798a);
        this.C = imageView;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.C.setScaleType(ImageView.ScaleType.CENTER_CROP);
        frameLayout.addView(this.C);
        RelativeLayout relativeLayout = new RelativeLayout(this.f4798a);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        colorDrawable.setAlpha(216);
        relativeLayout.setBackground(colorDrawable);
        relativeLayout.setPadding(a11, a11, a11, a11);
        this.D = new ImageView(this.f4798a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 24.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 24.0d));
        layoutParams.addRule(11, -1);
        this.D.setLayoutParams(layoutParams);
        com.aggmoread.sdk.z.b.m.j.a(this.D, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAmZJREFUWEfVlzloFmEQhp+30FIQQVAUBK9ORLQQDyKS1IKaWkjpFQUbU6igQbTQJJYGe2PAq9LCI9opqJ0HaCEKKe3ldT+ZHzabvRIDiwvbfNc8O/POzLei40cd2+f/ArC9ExgA+oG1wJrw4E/gB3APmJH0oa1nW3nA9j7gNHC4cPA34DewsTA+DYxJmmkCaQSwfQU4Hwe9A14Bb4HnkhIAttcBu+M9CGyL9ROSTtVB1ALYTsb2xAHXgcuSftUdaHs1cAs4Guu+SNpctacSwPZnYFNsHJD0tMmd+XnbKWQ3Y+y1pL1l+0sBbI8DJ9MGSY1havCIY35U0khx7bzDQ3AvY+GwpLGFfHlxre2UMU9ifH9RmGUAKZWS2qckDfYOtN2XCa8vc8jFhi8eBu73BBoivQacA6YlHcnvnwNgO6n3PZDyuF/SbA4gGb5QBCvE/W6I71Ie1PYK4EUGth3YJelNb18R4Hgo+Eam9rMl7uwZmOOd+MrKuZifAE4AI5JGqwCeJTcDg5Kmylxte56hsrES+GPAnagfB6oAPgJbgPWSvlfFOm8w1qScn+eVQng2AF+BT5K2VgGkIjMrqZf/lXrLQaQ1tcZzOkoAqyQlTfx9ihroHGAxIVgGHGrygu1WIViwCG0vBx5Fm64Mhe1WIlxUGtpeCTwEUr0vhbDdKg3rCtEQcLvGQGrJDzKQHcAZSb1GlNp1u0IUBaO0FMfckKTJmvRM6XU1S+NJSY9z6m9XisNIuv1014wCort2nHNbdxeSHER3V7IcRHeX0hxEd9fyQkfr5seksiUuwcQ/3XiXwH73P6d/AMNtZjBWZp4QAAAAAElFTkSuQmCC");
        relativeLayout.addView(this.D);
        LinearLayout linearLayout = new LinearLayout(this.f4798a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 50.0d);
        layoutParams2.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 50.0d);
        layoutParams2.addRule(13, -1);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(0);
        ImageView imageView2 = new ImageView(this.f4798a);
        this.G = imageView2;
        imageView2.setLayoutParams(new ViewGroup.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 64.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 64.0d)));
        this.G.setScaleType(ImageView.ScaleType.FIT_XY);
        com.aggmoread.sdk.z.b.m.j.a(this.G, "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");
        linearLayout.addView(this.G);
        this.H = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = a11;
        this.H.setLayoutParams(layoutParams3);
        this.H.setGravity(17);
        this.H.setTextSize(20.0f);
        this.H.setTextColor(Color.parseColor("#ffffff"));
        linearLayout.addView(this.H);
        this.I = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = a11;
        this.I.setLayoutParams(layoutParams4);
        this.I.setGravity(17);
        this.I.setTextSize(15.0f);
        this.I.setTextColor(Color.parseColor("#BFBDBD"));
        linearLayout.addView(this.I);
        this.J = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.topMargin = a11;
        this.J.setLayoutParams(layoutParams5);
        this.J.setGravity(17);
        this.J.setPadding(a10, a10, a10, a10);
        this.J.setText("立即查看");
        this.J.setTextColor(Color.parseColor("#ffffff"));
        this.J.setBackground(com.aggmoread.sdk.z.b.m.b.a(Color.parseColor("#0a81fc"), 1.0f, com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 30.0d), 0, 0));
        linearLayout.addView(this.J);
        relativeLayout.addView(linearLayout);
        frameLayout.addView(relativeLayout);
        return frameLayout;
    }

    private View p() {
        int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 8.0d);
        FrameLayout frameLayout = new FrameLayout(this.f4798a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d);
        layoutParams.setMarginStart(com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 60.0d));
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setPadding(a10, a10, a10, a10);
        frameLayout.setBackground(com.aggmoread.sdk.z.b.m.b.a(Color.parseColor("#000000"), 0.5f, com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 40.0d), 0, 0));
        LinearLayout linearLayout = new LinearLayout(this.f4798a);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(this.f4798a);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.aggmoread.sdk.z.b.m.j.a(imageView, "iVBORw0KGgoAAAANSUhEUgAAACMAAAAgCAYAAACYTcH3AAAAAXNSR0IArs4c6QAAAoZJREFUWEftljtoU2EUx38n98akD5qhFAS1vgVBoQ/TFrRNOzhUUKuCixW1g1u3Tk5dHBwU8TE4KahLhyIIDlW0Jm2hiYo66qiIUDXWtkmaxz0S04c3t4mli4L3wOHyfedx//d/vnO+K5QR1UEPsafXQUKgm4BxLK5KW3ikXNyiTaOh86C3gI/AB5QRaQ0PloqVsmDed/uIz6UcPqL9EozcKBsbDd0GPVvk81BawkfWBuZZZzVV1syKwarHpDXyYCWbTrZfROSC8yP4JMHwhj+C0ckDu6R17N3vjvq4qQ3J3cQihdeTxlexFdPcvODzGq+nSxpHv9tiYqFuVB/92lOF+fkY6fkUllWL6U0SqOqT5sjbpVK+aq+TpshUfm0rk8Y6+rDoxUMUlXHi8Q7UGrB9iWm8JBDYg+IDeYNoxGZXbQTZTzrzhLnZHahusdmrqw/hW1cPBFHZJy3PGxbtjjOjk+3XEOlfSjA9nSGX8xZRG6cm8A3TqALWO2hPJodIJk869isqIK/L0ist4fsOMBrtbECsMyingDpbonQaEgmwLHv+QGAKw7D7JpIxUsmgzdHrhcpKMIxifBN49C4zxj3pGp0V7el9AdKM34JAdln9ag/M5pdZEAtyUtDdCdiYA1kgOJuBsQBkPGBoQTNeMAWKccwY8N2EabPwVBDtOV301nINW2Q7/BX2zto3L9UXgK5BXDAl54xbphLU/HNnZsg2VwzTv+pGOP55Ozvn7HPmyrYomXz/r0JyWdsl7JzA5wa+ALWrSAVHJ8D/w+46fBAyjuG2cjrVE3Ln8nDp68AFU+DGLdPSAXLPTKnWdJlxmckz4E7gPAvu3VSqG/43ZqaBmr/xP/MTU9yfSEAUaIgAAAAASUVORK5CYII=");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 20.0d));
        layoutParams2.gravity = 16;
        imageView.setLayoutParams(layoutParams2);
        linearLayout.addView(imageView);
        this.f4806i = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 5.0d);
        this.f4806i.setLayoutParams(layoutParams3);
        this.f4806i.setText("Xs后可领取奖励");
        this.f4806i.setTextColor(Color.parseColor("#ffffff"));
        linearLayout.addView(this.f4806i);
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(this.f4798a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 5.0d);
        textView.setLayoutParams(layoutParams4);
        textView.setText("已领取奖励");
        textView.setTextColor(Color.parseColor("#E3E1E1"));
        frameLayout.addView(textView);
        this.f4810m = linearLayout;
        this.f4812o = textView;
        return frameLayout;
    }

    private void q() {
        this.f4801d.a(0);
        this.f4801d.a("素材加载中...");
        this.f4801d.b(false);
        this.f4801d.setEnabled(false);
        this.f4801d.a(new h());
        this.f4800c.a(this.f4801d);
        this.f4800c.e(true);
        this.f4800c.a(this.f4802e ? 0.0f : 1.0f);
        this.f4800c.a(f.i.TYPE_CLIP_VIDEO);
        this.f4800c.a(new i());
        this.f4800c.a(new j());
        this.f4800c.a(new k());
        this.f4800c.a(new l());
    }

    private View r() {
        LinearLayout linearLayout = new LinearLayout(this.f4798a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this.f4798a);
        int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 8.0d);
        int a11 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 15.0d);
        int a12 = com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 24.0d);
        int i10 = a11 + a10;
        relativeLayout.setPadding(i10, a10, i10, a10);
        ImageView imageView = new ImageView(this.f4798a);
        this.A = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.aggmoread.sdk.z.b.m.j.a(this.A, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAqNJREFUWEftlk2ITlEYx3//lZVEYhBJUT43JjYSRWMhFkKIRA2FBVKzIB+RGrIRMRvUiKLIhmZDTSRMSWSDrAb5SBoLCz3uM513Ol736503vZv31K3bvfec53f+z/95zhUNHmpwfJoATQVqVsDM9gF7gJ/ATUlH6jFyTQBmdgbYGwV8JWlONYCZzQBOA2+Bo5K+Z0GWBjCzLcCVsNBW4LLfK5EgBWA88DE8fx4gbqdBlAIws3nAE2AEcFDSCTOzLAB/bmarglpLQuB1km5UQ5QFeAwsBLolbQ4BcgEqgczsJNCRBVEIYGYXgB1Av6RJ0cL/AJjZTqCl2phm5qnzFPZJao1VSMvf1CS/lWs7sChMGCvpawHAfcAlv5UAt0v6EtSaADwDJvpmJHVV1kkDeAnMjij7gbWSHsXkaR4ws1nAMWAN8FTSggjYy/Uw0CtpcR7AoLSAu/YecFXSQIrTMz1gZt3AJmCppAdBhflBhTeSphcCpJVXkQLRbr1MLwHnJe0KAKOBb8CApJGNABgFeEP6JKnlfwOkpWAu8ALokdRWCAC4UTxfH9I62DBM2A5c9BYt6UAegJfamCjodUkbypjQzCpl2Ot1L+l95AsvQzdiq6S+PID9iVtXAlOAaeHDv2QLpspqRMuAbZJ+pJRgV6KoN7WhkdsJzWw9cAqYDByXdChatGwrrtT/O2C1JO8z5QDCTpe7ccKMjZKuZSlQVaaec79c9l/AikpPqAkgBNsNnA0T2yT15J2GZubt2P3g4yHQKelOmpkLD6NIcgdwkN+At9hBI2X8D3hLPpecoHcldaYFzjRh3sdm5qnwlLwGZgKfJY3Lm1P0rrQCIRVuRjelm9PHUKstCpT1viaAKB1enq6+//PVNYYFUFfEqslNgIYr8Ad+qj8wE2M/IAAAAABJRU5ErkJggg==");
        relativeLayout.addView(this.A, new RelativeLayout.LayoutParams(a12, a12));
        LinearLayout linearLayout2 = new LinearLayout(this.f4798a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21, -1);
        layoutParams.addRule(15, -1);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(this.f4798a);
        this.f4805h = textView;
        textView.setText("60s");
        this.f4805h.setTextSize(15.0f);
        this.f4805h.setTextColor(Color.parseColor("#ffffff"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginEnd(com.aggmoread.sdk.z.b.m.b.a(this.f4798a, 6.0d));
        linearLayout2.addView(this.f4805h, layoutParams2);
        TextView textView2 = new TextView(this.f4798a);
        this.f4807j = textView2;
        textView2.setText("跳过");
        this.f4807j.setTextSize(15.0f);
        this.f4807j.setTextColor(Color.parseColor("#ffffff"));
        linearLayout2.addView(this.f4807j, new LinearLayout.LayoutParams(-2, -2));
        relativeLayout.addView(linearLayout2);
        linearLayout.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.f4798a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        frameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        frameLayout.getBackground().setAlpha(127);
        frameLayout.setLayoutParams(layoutParams3);
        this.f4800c = new com.aggmoread.sdk.z.b.t.f(this.f4798a);
        frameLayout.addView(this.f4800c, new FrameLayout.LayoutParams(-1, -1));
        this.f4801d = new com.aggmoread.sdk.z.b.t.b(this.f4798a);
        frameLayout.addView(this.f4801d, new FrameLayout.LayoutParams(-1, -1));
        linearLayout.addView(frameLayout);
        return linearLayout;
    }

    public void u() {
        if (this.f4799b == null || !this.f4819v.get() || System.currentTimeMillis() - this.f4821x <= 5000) {
            return;
        }
        this.f4799b.a(this.f4798a);
        this.f4821x = System.currentTimeMillis();
    }

    public void w() {
        com.aggmoread.sdk.z.b.m.m mVar = this.f4803f;
        if (mVar != null) {
            mVar.d();
        }
    }

    private void y() {
        this.f4811n.setVisibility(8);
        this.C.setVisibility(8);
        if (TextUtils.isEmpty(f())) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
            a(this.G, f());
        }
        this.H.setText(h());
        this.I.setText(e());
        this.f4811n.setOnClickListener(new a());
        a(g(), new b());
        this.D.setOnClickListener(new ViewOnClickListenerC0090c());
    }

    private void z() {
        this.f4813p.setVisibility(4);
        this.f4812o.setVisibility(8);
    }

    public void B() {
        com.aggmoread.sdk.z.b.t.f fVar = this.f4800c;
        if (fVar != null) {
            fVar.p();
        }
    }

    public void D() {
        if (this.f4817t.get()) {
            this.f4800c.post(new g());
        }
    }

    public View k() {
        s();
        return this.f4808k;
    }

    public void v() {
        com.aggmoread.sdk.z.b.t.f fVar = this.f4800c;
        if (fVar == null || !fVar.a()) {
            return;
        }
        this.f4800c.b();
    }

    private String c() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.a() : "";
    }

    private String d() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.c() : "";
    }

    private String f() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.g() : "";
    }

    private String h() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        return dVar != null ? dVar.f() : "";
    }

    private void s() {
        FrameLayout frameLayout = new FrameLayout(this.f4798a);
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4808k = frameLayout;
        this.f4823z = com.aggmoread.sdk.z.b.s.a.a(frameLayout, null);
        FrameLayout frameLayout2 = new FrameLayout(this.f4798a);
        this.f4809l = frameLayout2;
        frameLayout2.setBackgroundColor(-16777216);
        this.f4808k.addView(this.f4809l, new FrameLayout.LayoutParams(-1, -1));
        this.f4809l.addView(r());
        View p10 = p();
        this.f4813p = p10;
        p10.setVisibility(0);
        this.f4809l.addView(this.f4813p);
        View n10 = n();
        this.f4814q = n10;
        this.f4809l.addView(n10);
        ViewGroup o10 = o();
        this.f4811n = o10;
        this.f4808k.addView(o10);
    }

    private boolean t() {
        com.aggmoread.sdk.z.b.t.d dVar = this.f4822y;
        if (dVar != null) {
            return dVar.k();
        }
        return true;
    }

    private void x() {
        this.f4814q.setVisibility(8);
        if (TextUtils.isEmpty(i())) {
            this.B.setVisibility(8);
        } else {
            this.B.setVisibility(0);
            a(this.B, i());
        }
        this.E.setText(d());
        this.F.setText(c());
        this.f4814q.setOnClickListener(new m());
    }

    public void b() {
        a();
    }

    public void a() {
        J();
        com.aggmoread.sdk.z.b.t.f fVar = this.f4800c;
        if (fVar != null) {
            if (fVar.a()) {
                this.f4800c.b();
            }
            this.f4800c.q();
        }
        H();
        c.b bVar = this.f4799b;
        if (bVar != null) {
            if (this.f4816s) {
                bVar.c();
            } else {
                bVar.b();
            }
        }
    }

    public void b(long j10) {
        if (this.f4807j.getVisibility() == 0 || j10 <= l()) {
            return;
        }
        this.f4807j.setVisibility(0);
    }

    public void a(long j10) {
        this.f4806i.setText(String.format("%s后可领取奖励", Long.valueOf(j10 / 1000)));
        if (this.f4813p.getVisibility() != 0) {
            this.f4813p.setVisibility(0);
        }
    }

    public void a(Activity activity) {
        this.f4798a = activity;
    }

    private void a(ImageView imageView, String str) {
        a(str, new e(this, imageView));
    }

    public void a(c.b bVar) {
        this.f4799b = bVar;
        if (this.f4817t.compareAndSet(false, true)) {
            q();
            x();
            A();
            z();
            y();
        }
    }

    public void a(com.aggmoread.sdk.z.b.t.d dVar) {
        this.f4822y = dVar;
    }

    private void a(String str, p<Bitmap> pVar) {
        if (TextUtils.isEmpty(str) || pVar == null) {
            return;
        }
        new Thread(new d(this, str, pVar)).start();
    }

    public void a(boolean z10) {
        this.f4802e = z10;
    }
}
