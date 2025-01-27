package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private g rO;

    /* renamed from: wg */
    private b f11818wg;

    /* renamed from: wk */
    @Nullable
    private d f11819wk;

    @Nullable
    private c wl;
    private final long wn;

    @NonNull
    private a wm = new a((byte) 0);

    /* renamed from: hf */
    private Handler f11817hf = new Handler(Looper.getMainLooper());
    private boolean wo = false;
    private boolean wp = false;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            RewardActionBarControl.a(RewardActionBarControl.this, true);
            com.kwad.sdk.core.d.c.d("ActionBarControl", "mHasOutTime");
            if (RewardActionBarControl.this.f11819wk != null && !RewardActionBarControl.this.wp && RewardActionBarControl.this.f11819wk.f(RewardActionBarControl.this.wm)) {
                com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.wn);
            } else {
                com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.wn);
                com.kwad.components.core.o.a.ri().i(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.wn);
                com.kwad.components.ad.reward.monitor.c.a(RewardActionBarControl.this.rO.mAdTemplate, RewardActionBarControl.this.rO.qu, "play_card", com.kwad.sdk.core.response.b.b.cs(RewardActionBarControl.this.rO.mAdTemplate), RewardActionBarControl.this.wn, 1);
                RewardActionBarControl.this.R(true);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ ShowActionBarResult ws;
        final /* synthetic */ View wt;

        public AnonymousClass2(ShowActionBarResult showActionBarResult, View view) {
            showActionBarResult = showActionBarResult;
            view = view;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view);
        }
    }

    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    public static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> wu;
        private ShowActionBarResult wv;

        private a() {
            this.wu = new CopyOnWriteArrayList();
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.wu.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.wu.remove(aVar);
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.wv = showActionBarResult;
            Iterator<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> it = this.wu.iterator();
            while (it.hasNext()) {
                it.next().a(showActionBarResult, view);
            }
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public interface b {
        void a(boolean z10, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface d {
        boolean f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(g gVar, Context context, AdTemplate adTemplate) {
        this.rO = gVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        long ct = com.kwad.sdk.core.response.b.b.ct(adTemplate) > 0 ? com.kwad.sdk.core.response.b.b.ct(adTemplate) : 1000L;
        this.wn = ct > 0 ? ct : 1000L;
    }

    private ShowActionBarResult Q(boolean z10) {
        c cVar;
        if (com.kwad.components.ad.reward.a.b.i(this.mAdInfo) && (cVar = this.wl) != null) {
            cVar.e(this.wm);
            return ShowActionBarResult.SHOW_ORDER;
        }
        if (!com.kwad.sdk.core.response.b.b.cu(this.mAdTemplate) || com.kwad.sdk.core.response.b.a.bd(this.mAdInfo) || this.f11819wk == null) {
            R(z10);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success in " + this.wn);
        return this.f11819wk.f(this.wm) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
    }

    public void R(boolean z10) {
        if (this.f11818wg != null) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "showNativeActionBar");
            this.wp = true;
            this.f11818wg.a(z10, this.wm);
        }
    }

    public final void P(boolean z10) {
        ShowActionBarResult Q = Q(z10);
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showActionBarOnVideoStart result: " + Q);
        if (Q != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.f11817hf.postDelayed(new bd() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.d.c.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.f11819wk != null && !RewardActionBarControl.this.wp && RewardActionBarControl.this.f11819wk.f(RewardActionBarControl.this.wm)) {
                    com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.wn);
                } else {
                    com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.wn);
                    com.kwad.components.core.o.a.ri().i(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.wn);
                    com.kwad.components.ad.reward.monitor.c.a(RewardActionBarControl.this.rO.mAdTemplate, RewardActionBarControl.this.rO.qu, "play_card", com.kwad.sdk.core.response.b.b.cs(RewardActionBarControl.this.rO.mAdTemplate), RewardActionBarControl.this.wn, 1);
                    RewardActionBarControl.this.R(true);
                }
            }
        }, this.wn);
    }

    public final void iA() {
        if (this.wo) {
            com.kwad.sdk.core.d.c.i("ActionBarControl", "showWebActionBar time out on pageStatus");
        } else {
            this.f11817hf.removeCallbacksAndMessages(null);
            Q(true);
        }
    }

    @Nullable
    public final ShowActionBarResult iB() {
        return this.wm.wv;
    }

    public static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z10) {
        rewardActionBarControl.wo = true;
        return true;
    }

    @MainThread
    public final void a(b bVar) {
        this.f11818wg = bVar;
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.wm.d(aVar);
    }

    @MainThread
    public final void a(d dVar) {
        this.f11819wk = dVar;
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.wl = cVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.wm.c(aVar);
    }

    public static void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, View view, ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                final /* synthetic */ ShowActionBarResult ws;
                final /* synthetic */ View wt;

                public AnonymousClass2(ShowActionBarResult showActionBarResult2, View view2) {
                    showActionBarResult = showActionBarResult2;
                    view = view2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view);
                }
            });
        }
    }
}
