package com.kwad.components.ad.reward.n;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* loaded from: classes2.dex */
public final class c extends com.kwad.sdk.core.download.a.a implements com.kwad.sdk.widget.c {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private View zC;
    private View zD;
    private Button zE;
    private Button zF;
    private TextView zG;
    private ImageView zH;
    private TextView zI;
    private TextView zJ;
    private KSRatingBar zK;
    private KsAppTagsView zL;
    private a zM;
    private volatile boolean zN = false;
    private com.kwad.components.ad.k.a zO;
    private Runnable zP;

    /* renamed from: com.kwad.components.ad.reward.n.c$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + c.this.zD.getHeight());
            if (c.this.zN) {
                return;
            }
            c.this.zO.io();
        }
    }

    public interface a {
        void d(boolean z10, int i10);
    }

    public static class b {
        private String appName;
        private String ry;
        private String rz;
        private float zR;
        private List<String> zS;
        private int zT = 15;
        private String zU;

        public static b T(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
            b bVar = new b();
            if (com.kwad.sdk.core.response.b.e.J(adTemplate)) {
                bVar.appName = com.kwad.sdk.core.response.b.a.ax(eb2);
            } else {
                bVar.appName = com.kwad.sdk.core.response.b.a.av(eb2);
            }
            bVar.zR = com.kwad.sdk.core.response.b.a.aC(eb2);
            bVar.rz = com.kwad.sdk.core.response.b.a.au(eb2);
            if (com.kwad.sdk.core.response.b.e.J(adTemplate)) {
                bVar.ry = com.kwad.sdk.core.response.b.a.cP(eb2);
            } else {
                bVar.ry = com.kwad.sdk.core.response.b.a.cm(eb2);
            }
            if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eb(adTemplate)))) {
                bVar.zT = com.kwad.components.ad.reward.a.b.gM();
                bVar.zU = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.zT = com.kwad.sdk.core.config.d.DG();
                bVar.zU = "浏览详情页%s秒，领取奖励";
            }
            bVar.zS = com.kwad.sdk.core.response.b.d.dS(adTemplate);
            return bVar;
        }

        public final String km() {
            return String.format(this.zU, Integer.valueOf(this.zT));
        }
    }

    public c(View view) {
        this.zC = view;
        initView();
        this.zO = new com.kwad.components.ad.k.a(view);
    }

    private void initView() {
        this.zE = (Button) this.zC.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.zF = (Button) this.zC.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.zD = this.zC.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.zH = (ImageView) this.zC.findViewById(R.id.ksad_reward_apk_info_icon);
        this.zG = (TextView) this.zC.findViewById(R.id.ksad_reward_apk_info_name);
        this.zI = (TextView) this.zC.findViewById(R.id.ksad_reward_apk_info_desc);
        this.zK = (KSRatingBar) this.zC.findViewById(R.id.ksad_reward_apk_info_score);
        this.zL = (KsAppTagsView) this.zC.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    public final void j(String str, int i10) {
        Button button = this.zF;
        if (button == null || str == null || i10 == 0) {
            return;
        }
        button.setText(str);
    }

    public final void kk() {
        Runnable runnable;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.k.a aVar = this.zO;
        if (aVar != null) {
            aVar.kk();
        }
        View view = this.zD;
        if (view == null || (runnable = this.zP) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.zP = null;
    }

    public final void kl() {
        this.zO.mS();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.zF.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.zF.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.cg(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.zF.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.zF.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.eb(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i10) {
        super.onPaused(i10);
        if (i10 != 0) {
            this.zO.mS();
            this.zF.setText(com.kwad.sdk.core.response.b.a.dp(i10));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i10) {
        if (i10 != 0) {
            this.zO.mS();
            this.zF.setText(com.kwad.sdk.core.response.b.a.m36do(i10));
        }
    }

    public final void a(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            c(view, false);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z10) {
        this.mAdTemplate = adTemplate;
        b T = b.T(adTemplate);
        if (T == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.zH, T.ry, adTemplate, 12);
        this.zG.setText(T.appName);
        this.zI.setText(T.rz);
        this.zK.setStar(T.zR);
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eb(adTemplate)))) {
            this.zF.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
            this.zK.setVisibility(0);
        } else {
            this.zF.setText("查看详情");
            this.zK.setVisibility(8);
        }
        this.zE.setText(T.km());
        this.zE.setClickable(true);
        this.zF.setClickable(true);
        this.zD.setClickable(true);
        new com.kwad.sdk.widget.f(this.zE, this);
        new com.kwad.sdk.widget.f(this.zF, this);
        new com.kwad.sdk.widget.f(this.zD, this);
        List<String> list = T.zS;
        if (z10 && list.size() == 0) {
            this.zI.setVisibility(8);
            TextView textView = (TextView) this.zC.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.zJ = textView;
            textView.setVisibility(0);
            this.zJ.setText(T.rz);
        }
        if (list.size() == 0) {
            this.zL.setVisibility(8);
        }
        this.zL.setAppTags(list);
        if (this.zP == null) {
            this.zP = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + c.this.zD.getHeight());
                    if (c.this.zN) {
                        return;
                    }
                    c.this.zO.io();
                }
            };
        }
        this.zD.postDelayed(this.zP, 1600L);
    }

    public final void a(a aVar) {
        this.zM = aVar;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }

    private void c(View view, boolean z10) {
        int id2 = view.getId();
        if (id2 == R.id.ksad_reward_apk_info_install_container || id2 == R.id.ksad_reward_apk_info_install_action || id2 == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", "onClick install");
            this.zN = true;
            a aVar = this.zM;
            if (aVar != null) {
                aVar.d(z10, 1);
            }
        }
    }
}
