package com.martian.mibook.mvvm.read.viewmodel;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.repository.RecommendBookFriendsRepository;
import com.umeng.analytics.pro.bt;
import java.util.List;
import kotlin.Metadata;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR$\u0010+\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\"\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010/R%\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010-0,8\u0006¢\u0006\f\n\u0004\b1\u0010/\u001a\u0004\b1\u00102R\"\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000204\u0018\u00010-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010/R%\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000204\u0018\u00010-0,8\u0006¢\u0006\f\n\u0004\b)\u0010/\u001a\u0004\b5\u00102¨\u00068"}, d2 = {"Lcom/martian/mibook/mvvm/read/viewmodel/RecommendBookFriendsViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/read/repository/RecommendBookFriendsRepository;", "<init>", "()V", "", "showLoading", "isLoadMore", "", bt.aO, "(ZZ)V", IAdInterListener.AdReqParam.WIDTH, "", "h", "I", t.f11211k, "()I", bt.aJ, "(I)V", "pageIndex", "i", "s", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "pageSize", "", "j", "Ljava/lang/String;", "v", "()Ljava/lang/String;", "C", "(Ljava/lang/String;)V", "sourceName", "k", "u", "B", "sourceId", t.f11204d, "n", "x", "cuid", "m", "q", "y", "nickname", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "Landroidx/lifecycle/MutableLiveData;", "_mRecommendBookFriendsLiveData", "o", "()Landroidx/lifecycle/MutableLiveData;", "mRecommendBookFriendsLiveData", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "p", "_mTopUserBooksLiveData", "mTopUserBooksLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class RecommendBookFriendsViewModel extends BaseViewModel<RecommendBookFriendsRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    public int pageIndex;

    /* renamed from: i, reason: from kotlin metadata */
    public int pageSize = 10;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public String sourceName;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public String sourceId;

    /* renamed from: l */
    @l
    public String cuid;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public String nickname;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookTopUser>> _mRecommendBookFriendsLiveData;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookTopUser>> mRecommendBookFriendsLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mTopUserBooksLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> mTopUserBooksLiveData;

    public RecommendBookFriendsViewModel() {
        MutableLiveData<List<TYBookTopUser>> mutableLiveData = new MutableLiveData<>();
        this._mRecommendBookFriendsLiveData = mutableLiveData;
        this.mRecommendBookFriendsLiveData = mutableLiveData;
        MutableLiveData<List<TYBookItem>> mutableLiveData2 = new MutableLiveData<>();
        this._mTopUserBooksLiveData = mutableLiveData2;
        this.mTopUserBooksLiveData = mutableLiveData2;
    }

    public final void A(int i10) {
        this.pageSize = i10;
    }

    public final void B(@l String str) {
        this.sourceId = str;
    }

    public final void C(@l String str) {
        this.sourceName = str;
    }

    @l
    /* renamed from: n, reason: from getter */
    public final String getCuid() {
        return this.cuid;
    }

    @k
    public final MutableLiveData<List<TYBookTopUser>> o() {
        return this.mRecommendBookFriendsLiveData;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> p() {
        return this.mTopUserBooksLiveData;
    }

    @l
    /* renamed from: q, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: r, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: s, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final void t(boolean z10, boolean z11) {
        if (TextUtils.isEmpty(this.sourceName) || TextUtils.isEmpty(this.sourceId)) {
            return;
        }
        j(new RecommendBookFriendsViewModel$getRecommendBookFriends$1(this, null), new RecommendBookFriendsViewModel$getRecommendBookFriends$2(z11, this, null), z10);
    }

    @l
    /* renamed from: u, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: v, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    public final void w(boolean z10, boolean z11) {
        if (TextUtils.isEmpty(this.sourceName) || TextUtils.isEmpty(this.sourceId) || TextUtils.isEmpty(this.cuid)) {
            return;
        }
        j(new RecommendBookFriendsViewModel$getTopUserBooks$1(this, null), new RecommendBookFriendsViewModel$getTopUserBooks$2(z11, this, null), z10);
    }

    public final void x(@l String str) {
        this.cuid = str;
    }

    public final void y(@l String str) {
        this.nickname = str;
    }

    public final void z(int i10) {
        this.pageIndex = i10;
    }
}
