package com.kwad.components.ad.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.c.c.b;
import com.kwad.components.ad.c.d;
import com.kwad.components.ad.c.e;
import com.kwad.components.core.l.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public final class a extends c<com.kwad.components.ad.c.c> implements View.OnClickListener, com.kwad.sdk.widget.c {
    private KsAdVideoPlayConfig bS;

    /* renamed from: cc */
    private e f11400cc;

    /* renamed from: ci */
    private List<Integer> f11401ci;

    /* renamed from: cj */
    private FrameLayout f11402cj;

    /* renamed from: ck */
    private ImageView f11403ck;
    private LinearLayout cl;
    private ImageView cm;

    /* renamed from: cn */
    private boolean f11404cn;
    private com.kwad.sdk.core.video.videoview.a co;
    private d cp;
    private LinearLayout cq;
    private TextView cr;
    private TextView cs;
    private TextView ct;
    private ImageView cu;
    private KsLogoView cv;
    public InterfaceC0362a cw;
    private a.b cx;
    private OfflineOnAudioConflictListener cy;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;

    /* renamed from: com.kwad.components.ad.c.b.a$1 */
    public class AnonymousClass1 implements a.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void ap() {
            com.kwad.sdk.core.video.videoview.a aVar = a.this.co;
            a aVar2 = a.this;
            aVar.setVideoSoundEnable(aVar2.f(aVar2.mIsAudioEnable));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void aq() {
            com.kwad.sdk.core.adlog.c.bT(((com.kwad.components.ad.c.c) a.this.Ox).mAdTemplate);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j10) {
            a.this.c(j10);
        }

        @Override // com.kwad.components.core.video.a.b
        public final void onVideoPlayError(int i10, int i11) {
            InterfaceC0362a interfaceC0362a = a.this.cw;
            if (interfaceC0362a != null) {
                interfaceC0362a.ar();
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            com.kwad.sdk.core.adlog.c.bS(a.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.c.b.a$2 */
    public class AnonymousClass2 implements OfflineOnAudioConflictListener {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.b(a.this, false);
            if (a.this.co != null) {
                a.this.co.setVideoSoundEnable(false);
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.c.b.a$3 */
    public class AnonymousClass3 extends SimpleImageLoadingListener {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BitmapFactory.decodeStream(inputStream);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.c.b.a$4 */
    public class AnonymousClass4 extends SimpleImageLoadingListener {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.c.b.a$5 */
    public class AnonymousClass5 extends SimpleImageLoadingListener {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.c.b.a$a */
    public interface InterfaceC0362a {
        void a(int i10, int i11, AdTemplate adTemplate);

        void ar();

        void c(AdTemplate adTemplate);

        void d(AdTemplate adTemplate);
    }

    public a(Context context, AdTemplate adTemplate, InterfaceC0362a interfaceC0362a) {
        super(context);
        this.mIsAudioEnable = true;
        this.cx = new a.b() { // from class: com.kwad.components.ad.c.b.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
                com.kwad.sdk.core.video.videoview.a aVar = a.this.co;
                a aVar2 = a.this;
                aVar.setVideoSoundEnable(aVar2.f(aVar2.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.adlog.c.bT(((com.kwad.components.ad.c.c) a.this.Ox).mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j10) {
                a.this.c(j10);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i10, int i11) {
                InterfaceC0362a interfaceC0362a2 = a.this.cw;
                if (interfaceC0362a2 != null) {
                    interfaceC0362a2.ar();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.bS(a.this.mAdTemplate);
            }
        };
        this.cy = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.c.b.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.b(a.this, false);
                if (a.this.co != null) {
                    a.this.co.setVideoSoundEnable(false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        this.cw = interfaceC0362a;
        this.mContext = getContext();
        py();
    }

    @Override // com.kwad.components.core.l.c
    /* renamed from: al */
    public com.kwad.components.ad.c.c ak() {
        e eVar = new e(this.mR, com.kwad.sdk.core.response.b.a.cH(this.mAdInfo));
        this.f11400cc = eVar;
        eVar.uE();
        com.kwad.components.ad.c.c cVar = new com.kwad.components.ad.c.c();
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.mAdScene = this.mAdScene;
        cVar.mApkDownloadHelper = this.mApkDownloadHelper;
        return cVar;
    }

    private static Presenter am() {
        Presenter presenter = new Presenter();
        presenter.a(new b());
        return presenter;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ao() {
        /*
            r3 = this;
            boolean r0 = com.kwad.sdk.core.config.d.DO()
            r1 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r3.mContext
            com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.av(r0)
            boolean r0 = r0.sa()
            if (r0 == 0) goto L14
            goto L34
        L14:
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bS
            boolean r2 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
            if (r2 == 0) goto L2a
            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
            int r0 = r0.getVideoSoundValue()
            if (r0 == 0) goto L2a
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bS
            boolean r0 = r0.isVideoSoundEnable()
            r0 = r0 ^ r1
            goto L35
        L2a:
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.bW(r0)
            if (r0 != 0) goto L33
            goto L34
        L33:
            r1 = 0
        L34:
            r0 = r1
        L35:
            com.kwad.sdk.core.response.model.AdTemplate r1 = r3.mAdTemplate
            if (r1 == 0) goto L3d
            r2 = r0 ^ 1
            r1.mIsAudioEnable = r2
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.b.a.ao():boolean");
    }

    public boolean f(boolean z10) {
        if (!z10) {
            return false;
        }
        if (!com.kwad.sdk.core.config.d.DO()) {
            return !com.kwad.components.core.s.a.av(this.mContext).sb() ? com.kwad.components.core.s.a.av(this.mContext).aO(false) : !com.kwad.components.core.s.a.av(this.mContext).sa();
        }
        if (!this.f11404cn) {
            this.f11404cn = com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        return this.f11404cn;
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
    }

    @Override // com.kwad.components.core.l.c
    public final boolean ah() {
        return true;
    }

    @Override // com.kwad.components.core.l.c
    public final void aj() {
        FrameLayout frameLayout = (FrameLayout) this.mR.findViewById(R.id.ksad_banner_item_content);
        this.f11402cj = frameLayout;
        frameLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.mR.findViewById(R.id.ksad_banner_item_info);
        this.cq = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.mR.findViewById(R.id.ksad_banner_item_des);
        this.cr = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.cr.setOnClickListener(this);
        TextView textView2 = (TextView) this.mR.findViewById(R.id.ksad_banner_item_title);
        this.cs = textView2;
        textView2.setText(com.kwad.sdk.core.response.b.a.cj(this.mAdInfo));
        this.cs.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.mR.findViewById(R.id.ksad_banner_button_base);
        this.cl = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView3 = (TextView) this.mR.findViewById(R.id.ksad_banner_item_button);
        this.ct = textView3;
        textView3.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.ct.setOnClickListener(this);
        ImageView imageView = (ImageView) this.mR.findViewById(R.id.ksad_banner_item_close);
        this.cu = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.mR.findViewById(R.id.ksad_banner_item_image);
        this.f11403ck = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.mR.findViewById(R.id.ksad_banner_item_image_bg);
        this.cm = imageView3;
        imageView3.setOnClickListener(this);
        this.cv = (KsLogoView) this.mR.findViewById(R.id.ksad_banner_logo);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(this.mAdInfo)) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl)) {
            int i10 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i10, i10);
            layoutParams.gravity = 17;
            this.f11403ck.setLayoutParams(layoutParams);
            KSImageLoader.loadImage(this.f11403ck, com.kwad.sdk.core.response.b.a.cm(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setCornerRound(8).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BitmapFactory.decodeStream(inputStream);
                    return true;
                }
            });
        } else if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            AdInfo.AdMaterialInfo.MaterialFeature aU = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo);
            if (!TextUtils.isEmpty(aU.materialUrl)) {
                int i11 = aU.width;
                int i12 = aU.height;
                if (i11 > 0 && i11 < i12) {
                    this.cm.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.O(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.5
                        public AnonymousClass5() {
                        }

                        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                            return true;
                        }
                    });
                    int i13 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((i13 / 16) * 9, i13);
                    layoutParams2.gravity = 5;
                    layoutParams2.rightMargin = (int) ((displayMetrics.density * 14.0f) + 0.5f);
                    this.f11403ck.setLayoutParams(layoutParams2);
                }
            }
            KSImageLoader.loadImage(this.f11403ck, com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl, this.mAdTemplate);
        } else {
            this.f11403ck.setScaleType(ImageView.ScaleType.CENTER_CROP);
            KSImageLoader.loadImage(this.f11403ck, com.kwad.sdk.core.response.b.a.bt(this.mAdInfo).getUrl(), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.4
                public AnonymousClass4() {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.f11403ck.setOnClickListener(this);
        }
        this.cv.aK(this.mAdTemplate);
        this.f11402cj.setVisibility(4);
    }

    public final void an() {
        this.f11402cj.setVisibility(0);
        this.cw.c(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels > displayMetrics.heightPixels ? R.layout.ksad_banner_item_land : R.layout.ksad_banner_item;
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f11402cj || view == this.f11403ck || view == this.co || view == this.cm) {
            this.cw.a(100, 3, this.mAdTemplate);
            return;
        }
        if (view == this.cq || view == this.cl) {
            this.cw.a(53, 2, this.mAdTemplate);
            return;
        }
        if (view == this.cr) {
            this.cw.a(32, 2, this.mAdTemplate);
            return;
        }
        if (view == this.cs) {
            this.cw.a(31, 2, this.mAdTemplate);
        } else if (view == this.ct) {
            this.cw.a(29, 1, this.mAdTemplate);
        } else if (view == this.cu) {
            this.cw.d(this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return am();
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        aVar.f11404cn = false;
        return false;
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11401ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f11401ci.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            onClick(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.kwad.sdk.api.KsAdVideoPlayConfig r10) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.b.a.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }
}
