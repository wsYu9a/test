package com.martian.mibook.mvvm.yuewen.viewmodel;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.XianWanGame;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.TYBonus;
import com.martian.mibook.lib.account.response.WithdrawRankList;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.yuewen.repository.MissionCenterRepository;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t8.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0004J\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u0018J\u001d\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u0018J\u001d\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u0018J\r\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u0004J\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b!\u00103R*\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00107R\u001e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00107R\u001e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00107R\u001c\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001f\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0C8\u0006¢\u0006\f\n\u0004\b\u001e\u0010F\u001a\u0004\bH\u0010IR\u001c\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010MR\u001f\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0K8\u0006¢\u0006\f\n\u0004\b\u001a\u0010M\u001a\u0004\bO\u0010PR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020R0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010FR\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020R0C8\u0006¢\u0006\f\n\u0004\b\u000e\u0010F\u001a\u0004\bT\u0010IR\u001c\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010FR\u001f\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0C8\u0006¢\u0006\f\n\u0004\b\u0019\u0010F\u001a\u0004\bX\u0010I¨\u0006Z"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/MissionCenterRepository;", "<init>", "()V", "G", "()Lcom/martian/mibook/mvvm/yuewen/repository/MissionCenterRepository;", "Lcom/martian/mibook/lib/account/response/MiTaskAccount;", "B", "()Lcom/martian/mibook/lib/account/response/MiTaskAccount;", "", "s", "()I", "coins", bt.aO, "(I)I", "", "L", "M", "Landroid/content/Context;", f.X, "", "Lcom/martian/mibook/lib/account/response/MissionItem;", ExifInterface.LONGITUDE_EAST, "(Landroid/content/Context;)Ljava/util/List;", "v", t.f11211k, "q", "F", TTDownloadField.TT_TAG, "p", "(Landroid/content/Context;I)Lcom/martian/mibook/lib/account/response/MissionItem;", "h", "I", "D", "K", "(I)V", c.f26972i, "", "i", "Ljava/lang/String;", "C", "()Ljava/lang/String;", "J", "(Ljava/lang/String;)V", a.f30751f, "", "j", "Z", IAdInterListener.AdReqParam.WIDTH, "()Z", "(Z)V", "hasBackKey", "", "k", "Ljava/util/List;", "u", "()Ljava/util/List;", "H", "(Ljava/util/List;)V", "freshMissionItemList", t.f11204d, "recommendMissionItemList", "m", "dailyMissionItemList", "n", "commissionMissionItemList", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "Lcom/martian/mibook/lib/account/response/ExchangeMoney;", "o", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mExchangeMoneyLiveData", "y", "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mExchangeMoneyLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/martian/mibook/lib/account/response/WithdrawRankList;", "Landroidx/lifecycle/MutableLiveData;", "_mWithdrawRankListLiveData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Landroidx/lifecycle/MutableLiveData;", "mWithdrawRankListLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "_mExchangeMoneyErrorLiveData", "x", "mExchangeMoneyErrorLiveData", "Lcom/martian/mibook/lib/account/response/TYBonus;", "_mFiveStarLiveData", bt.aJ, "mFiveStarLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class MissionCenterViewModel extends BaseViewModel<MissionCenterRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    public int id.c.i java.lang.String;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public String t8.a.f java.lang.String;

    /* renamed from: j, reason: from kotlin metadata */
    public boolean hasBackKey;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public List<MissionItem> freshMissionItemList = new ArrayList();

    /* renamed from: l */
    @k
    public List<MissionItem> recommendMissionItemList = new ArrayList();

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public List<MissionItem> dailyMissionItemList = new ArrayList();

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public List<MissionItem> commissionMissionItemList = new ArrayList();

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ExchangeMoney> _mExchangeMoneyLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ExchangeMoney> mExchangeMoneyLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final MutableLiveData<WithdrawRankList> _mWithdrawRankListLiveData;

    /* renamed from: r */
    @k
    public final MutableLiveData<WithdrawRankList> mWithdrawRankListLiveData;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mExchangeMoneyErrorLiveData;

    /* renamed from: t */
    @k
    public final NonStickyLiveData<ErrorResult> mExchangeMoneyErrorLiveData;

    /* renamed from: u, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<TYBonus> _mFiveStarLiveData;

    /* renamed from: v, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<TYBonus> mFiveStarLiveData;

    public MissionCenterViewModel() {
        NonStickyLiveData<ExchangeMoney> nonStickyLiveData = new NonStickyLiveData<>();
        this._mExchangeMoneyLiveData = nonStickyLiveData;
        this.mExchangeMoneyLiveData = nonStickyLiveData;
        MutableLiveData<WithdrawRankList> mutableLiveData = new MutableLiveData<>();
        this._mWithdrawRankListLiveData = mutableLiveData;
        this.mWithdrawRankListLiveData = mutableLiveData;
        NonStickyLiveData<ErrorResult> nonStickyLiveData2 = new NonStickyLiveData<>();
        this._mExchangeMoneyErrorLiveData = nonStickyLiveData2;
        this.mExchangeMoneyErrorLiveData = nonStickyLiveData2;
        NonStickyLiveData<TYBonus> nonStickyLiveData3 = new NonStickyLiveData<>();
        this._mFiveStarLiveData = nonStickyLiveData3;
        this.mFiveStarLiveData = nonStickyLiveData3;
    }

    @k
    public final MutableLiveData<WithdrawRankList> A() {
        return this.mWithdrawRankListLiveData;
    }

    @l
    public final MiTaskAccount B() {
        return MiConfigSingleton.b2().p2();
    }

    @l
    /* renamed from: C, reason: from getter */
    public final String getT8.a.f java.lang.String() {
        return this.t8.a.f java.lang.String;
    }

    /* renamed from: D, reason: from getter */
    public final int getId.c.i java.lang.String() {
        return this.id.c.i java.lang.String;
    }

    @k
    public final List<MissionItem> E(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.recommendMissionItemList = new ArrayList();
        if (MiConfigSingleton.b2().e2().p()) {
            this.recommendMissionItemList.add(p(context, 111));
        }
        MiConfigSingleton.b2().e2().i(context, this.recommendMissionItemList);
        return this.recommendMissionItemList;
    }

    public final void F() {
        BaseViewModel.k(this, new MissionCenterViewModel$getWithdrawOrdersRank$1(this, null), null, false, 6, null);
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: G */
    public MissionCenterRepository i() {
        return new MissionCenterRepository();
    }

    public final void H(@k List<MissionItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.freshMissionItemList = list;
    }

    public final void I(boolean z10) {
        this.hasBackKey = z10;
    }

    public final void J(@l String str) {
        this.t8.a.f java.lang.String = str;
    }

    public final void K(int i10) {
        this.id.c.i java.lang.String = i10;
    }

    public final void L() {
        BaseViewModel.k(this, new MissionCenterViewModel$startExchange$1(this, null), new MissionCenterViewModel$startExchange$2(this, null), false, 4, null);
    }

    public final void M() {
        BaseViewModel.k(this, new MissionCenterViewModel$startFiveStar$1(this, null), new MissionCenterViewModel$startFiveStar$2(this, null), false, 4, null);
    }

    @l
    public final MissionItem p(@k Context r22, int r32) {
        Intrinsics.checkNotNullParameter(r22, "context");
        return MiConfigSingleton.b2().e2().E(r22, r32);
    }

    @k
    public final List<MissionItem> q(@k Context r62) {
        Intrinsics.checkNotNullParameter(r62, "context");
        this.commissionMissionItemList = new ArrayList();
        if (MiConfigSingleton.b2().F1()) {
            this.commissionMissionItemList.add(p(r62, 101));
            ac.a.b0(r62, "赚钱-主页-展示");
            List<XianWanGame> T = MiConfigSingleton.b2().e2().T();
            Intrinsics.checkNotNull(T);
            Collections.shuffle(T);
            Iterator<XianWanGame> it = T.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                XianWanGame next = it.next();
                if (i10 >= 2) {
                    ac.a.b0(r62, "赚钱-游戏-展示");
                    break;
                }
                i10++;
                this.commissionMissionItemList.add(MiConfigSingleton.b2().e2().U(next));
            }
        }
        return this.commissionMissionItemList;
    }

    @k
    public final List<MissionItem> r(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        this.dailyMissionItemList = arrayList;
        arrayList.add(p(context, 0));
        this.dailyMissionItemList.add(p(context, 9));
        return this.dailyMissionItemList;
    }

    public final int s() {
        MiTaskAccount B = B();
        if (B == null || B.getCoins() <= 0) {
            return 0;
        }
        return B.getCoins() - (B.getCoins() % (B.getCoinsRate() / 100));
    }

    public final int t(int i10) {
        MiTaskAccount B = B();
        if (B != null && i10 > 0) {
            return (i10 * 100) / B.getCoinsRate();
        }
        return 0;
    }

    @k
    public final List<MissionItem> u() {
        return this.freshMissionItemList;
    }

    @k
    public final List<MissionItem> v(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        this.freshMissionItemList = new ArrayList();
        if (!MiConfigSingleton.b2().e2().g0()) {
            this.freshMissionItemList.add(p(r32, 8));
        }
        if (MiConfigSingleton.b2().E1()) {
            this.freshMissionItemList.add(p(r32, 10));
        }
        return this.freshMissionItemList;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getHasBackKey() {
        return this.hasBackKey;
    }

    @k
    public final NonStickyLiveData<ErrorResult> x() {
        return this.mExchangeMoneyErrorLiveData;
    }

    @k
    public final NonStickyLiveData<ExchangeMoney> y() {
        return this.mExchangeMoneyLiveData;
    }

    @k
    public final NonStickyLiveData<TYBonus> z() {
        return this.mFiveStarLiveData;
    }
}
