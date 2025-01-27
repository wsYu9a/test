package com.martian.mibook.mvvm.yuewen.viewmodel;

import android.content.Context;
import com.kuaishou.weapon.p0.t;
import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.yuewen.repository.AccountRepository;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.c;
import l9.t0;
import xi.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u001bR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0\u00148\u0006¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u001b¨\u0006("}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/AccountViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/AccountRepository;", "<init>", "()V", "v", "()Lcom/martian/mibook/mvvm/yuewen/repository/AccountRepository;", "Landroid/content/Context;", f.X, "", "p", "(Landroid/content/Context;)V", "", "manual", "o", "(Z)V", t.f11211k, "h", "Z", "cacheClearing", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "Lcom/martian/libugrowth/data/UpgradeInfo;", "i", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mUpgradeInfoLiveData", "j", "u", "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mUpgradeInfoLiveData", "k", "_mChangeChargeUserLiveData", t.f11204d, "s", "mChangeChargeUserLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "m", "_mUpgradeErrorLiveData", "n", bt.aO, "mUpgradeErrorLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AccountViewModel extends BaseViewModel<AccountRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    public boolean cacheClearing;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<UpgradeInfo> _mUpgradeInfoLiveData;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<UpgradeInfo> mUpgradeInfoLiveData;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Boolean> _mChangeChargeUserLiveData;

    /* renamed from: l */
    @k
    public final NonStickyLiveData<Boolean> mChangeChargeUserLiveData;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> _mUpgradeErrorLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ErrorResult> mUpgradeErrorLiveData;

    public AccountViewModel() {
        NonStickyLiveData<UpgradeInfo> nonStickyLiveData = new NonStickyLiveData<>();
        this._mUpgradeInfoLiveData = nonStickyLiveData;
        this.mUpgradeInfoLiveData = nonStickyLiveData;
        NonStickyLiveData<Boolean> nonStickyLiveData2 = new NonStickyLiveData<>();
        this._mChangeChargeUserLiveData = nonStickyLiveData2;
        this.mChangeChargeUserLiveData = nonStickyLiveData2;
        NonStickyLiveData<ErrorResult> nonStickyLiveData3 = new NonStickyLiveData<>();
        this._mUpgradeErrorLiveData = nonStickyLiveData3;
        this.mUpgradeErrorLiveData = nonStickyLiveData3;
    }

    public static final void q(long j10, Context context, AccountViewModel this$0) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        t0.b(context, "共清理" + c.e(j10) + "缓存");
        this$0.cacheClearing = false;
    }

    public final void o(boolean manual) {
        if (!MiConfigSingleton.b2().C2()) {
            j(new AccountViewModel$checkUpgrade$1(this, manual, null), new AccountViewModel$checkUpgrade$2(manual, this, null), false);
            return;
        }
        ErrorResult errorResult = new ErrorResult(-1, "您已经是最新版本", null, 4, null);
        errorResult.setObj(Boolean.valueOf(manual));
        this._mUpgradeErrorLiveData.postValue(errorResult);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: xd.a.<init>(long, android.content.Context, com.martian.mibook.mvvm.yuewen.viewmodel.AccountViewModel):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public final void p(@xi.k android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            long r0 = l9.c.f(r7)
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 > 0) goto L12
            r2 = 1
            goto L13
        L12:
            r2 = 0
        L13:
            boolean r3 = r6.cacheClearing
            if (r3 == 0) goto L1a
            java.lang.String r3 = "正在清除中"
            goto L21
        L1a:
            if (r2 == 0) goto L1f
            java.lang.String r3 = "已经很干净啦"
            goto L21
        L1f:
            java.lang.String r3 = "清除中..."
        L21:
            l9.t0.b(r7, r3)
            boolean r3 = r6.cacheClearing
            if (r3 != 0) goto L34
            if (r2 != 0) goto L34
            r6.cacheClearing = r4
            xd.a r2 = new xd.a
            r2.<init>()
            l9.c.b(r7, r2)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.viewmodel.AccountViewModel.p(android.content.Context):void");
    }

    public final void r() {
        j(new AccountViewModel$freeReadWithAd$1(this, null), new AccountViewModel$freeReadWithAd$2(this, null), false);
    }

    @k
    public final NonStickyLiveData<Boolean> s() {
        return this.mChangeChargeUserLiveData;
    }

    @k
    public final NonStickyLiveData<ErrorResult> t() {
        return this.mUpgradeErrorLiveData;
    }

    @k
    public final NonStickyLiveData<UpgradeInfo> u() {
        return this.mUpgradeInfoLiveData;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: v */
    public AccountRepository i() {
        return new AccountRepository();
    }
}
