package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private j qt;
    private b tZ;

    @Nullable
    private e uc;

    @Nullable
    private c ud;

    @Nullable
    private d ue;
    private final long ug;

    @NonNull
    private a uf = new a((byte) 0);
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean uh = false;
    private boolean ui = false;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RewardActionBarControl.a(RewardActionBarControl.this, true);
            com.kwad.sdk.core.d.b.d("ActionBarControl", "mHasOutTime");
            if (RewardActionBarControl.this.uc != null && !RewardActionBarControl.this.ui && RewardActionBarControl.this.uc.g(RewardActionBarControl.this.uf)) {
                com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.ug);
            } else {
                com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.ug);
                com.kwad.components.core.m.a.pb().e(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.ug);
                com.kwad.components.ad.reward.monitor.a.a(RewardActionBarControl.this.qt.pf, "play_card", com.kwad.sdk.core.response.a.b.aP(RewardActionBarControl.this.qt.mAdTemplate), RewardActionBarControl.this.ug, 1);
                RewardActionBarControl.this.U(true);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ ShowActionBarResult ul;
        final /* synthetic */ View um;

        AnonymousClass2(ShowActionBarResult showActionBarResult, View view) {
            showActionBarResult = showActionBarResult;
            view = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view);
        }
    }

    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        TK,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> un;
        private ShowActionBarResult uo;

        private a() {
            this.un = new CopyOnWriteArrayList();
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.d.b.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.uo = showActionBarResult;
            Iterator<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> it = this.un.iterator();
            while (it.hasNext()) {
                it.next().a(showActionBarResult, view);
            }
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.un.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.un.remove(aVar);
        }
    }

    public interface b {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface d {
        void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface e {
        boolean g(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(j jVar, Context context, AdTemplate adTemplate) {
        this.qt = jVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        long aQ = !com.kwad.sdk.core.response.a.a.ck(this.mAdInfo) ? com.kwad.sdk.core.response.a.b.aQ(adTemplate) : 1000L;
        this.ug = aQ > 0 ? aQ : 1000L;
    }

    private ShowActionBarResult T(boolean z) {
        c cVar;
        d dVar;
        if (j.d(this.qt) && (dVar = this.ue) != null) {
            dVar.f(this.uf);
            return ShowActionBarResult.TK;
        }
        if (com.kwad.components.ad.reward.kwai.b.j(this.mAdInfo) && (cVar = this.ud) != null) {
            cVar.e(this.uf);
            return ShowActionBarResult.SHOW_ORDER;
        }
        if (!com.kwad.sdk.core.response.a.b.aR(this.mAdTemplate) || this.uc == null) {
            U(z);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
        com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar success in " + this.ug);
        return this.uc.g(this.uf) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
    }

    public void U(boolean z) {
        if (this.tZ != null) {
            com.kwad.sdk.core.d.b.d("ActionBarControl", "showNativeActionBar");
            this.ui = true;
            this.tZ.a(z, this.uf);
        }
    }

    public static void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, View view, ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                final /* synthetic */ ShowActionBarResult ul;
                final /* synthetic */ View um;

                AnonymousClass2(ShowActionBarResult showActionBarResult2, View view2) {
                    showActionBarResult = showActionBarResult2;
                    view = view2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view);
                }
            });
        }
    }

    static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z) {
        rewardActionBarControl.uh = true;
        return true;
    }

    public final void S(boolean z) {
        ShowActionBarResult T = T(z);
        com.kwad.sdk.core.d.b.d("ActionBarControl", "showActionBarOnVideoStart result: " + T);
        if (T != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.d.b.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.uc != null && !RewardActionBarControl.this.ui && RewardActionBarControl.this.uc.g(RewardActionBarControl.this.uf)) {
                    com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.ug);
                } else {
                    com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.ug);
                    com.kwad.components.core.m.a.pb().e(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.ug);
                    com.kwad.components.ad.reward.monitor.a.a(RewardActionBarControl.this.qt.pf, "play_card", com.kwad.sdk.core.response.a.b.aP(RewardActionBarControl.this.qt.mAdTemplate), RewardActionBarControl.this.ug, 1);
                    RewardActionBarControl.this.U(true);
                }
            }
        }, this.ug);
    }

    @MainThread
    public final void a(b bVar) {
        this.tZ = bVar;
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.ud = cVar;
    }

    public final void a(@Nullable d dVar) {
        this.ue = dVar;
    }

    @MainThread
    public final void a(e eVar) {
        this.uc = eVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uf.c(aVar);
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uf.d(aVar);
    }

    public final void hZ() {
        if (this.uh) {
            com.kwad.sdk.core.d.b.i("ActionBarControl", "showWebActionBar time out on pageStatus");
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
            T(true);
        }
    }

    @Nullable
    public final ShowActionBarResult ia() {
        return this.uf.uo;
    }
}
