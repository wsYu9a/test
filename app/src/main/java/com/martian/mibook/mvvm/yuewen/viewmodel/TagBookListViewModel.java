package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.net.request.YWCategoryBookListParams;
import com.martian.mibook.mvvm.yuewen.repository.TagBookListRepository;
import com.umeng.analytics.pro.bt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\t2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020+\u0018\u00010*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R%\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020+\u0018\u00010*0)8\u0006¢\u0006\f\n\u0004\b/\u0010-\u001a\u0004\b0\u00101R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010-R\u001f\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030)8\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b6\u00101¨\u00068"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/TagBookListViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/TagBookListRepository;", "<init>", "()V", "u", "()Lcom/martian/mibook/mvvm/yuewen/repository/TagBookListRepository;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "followBlock", "o", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;", "bookListParams", "", "showLoading", "isLoadMore", "p", "(Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;ZZ)V", "", "h", "I", "n", "()I", "v", "(I)V", "cType", "i", "q", IAdInterListener.AdReqParam.WIDTH, "exposeType", "", "j", "Ljava/lang/String;", bt.aO, "()Ljava/lang/String;", "x", "(Ljava/lang/String;)V", TTDownloadField.TT_TAG, "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/martian/mibook/lib/yuewen/response/TYTag;", "k", "Landroidx/lifecycle/MutableLiveData;", "_mCategoryListByTagLiveData", t.f11204d, "s", "()Landroidx/lifecycle/MutableLiveData;", "mCategoryListByTagLiveData", "Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;", "m", "_mCategoryBookListLiveData", t.f11211k, "mCategoryBookListLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class TagBookListViewModel extends BaseViewModel<TagBookListRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    public int cType = 1;

    /* renamed from: i, reason: from kotlin metadata */
    public int exposeType;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public String com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYTag>> _mCategoryListByTagLiveData;

    /* renamed from: l */
    @k
    public final MutableLiveData<List<TYTag>> mCategoryListByTagLiveData;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final MutableLiveData<YWCategoryBookList> _mCategoryBookListLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MutableLiveData<YWCategoryBookList> mCategoryBookListLiveData;

    public TagBookListViewModel() {
        MutableLiveData<List<TYTag>> mutableLiveData = new MutableLiveData<>();
        this._mCategoryListByTagLiveData = mutableLiveData;
        this.mCategoryListByTagLiveData = mutableLiveData;
        MutableLiveData<YWCategoryBookList> mutableLiveData2 = new MutableLiveData<>();
        this._mCategoryBookListLiveData = mutableLiveData2;
        this.mCategoryBookListLiveData = mutableLiveData2;
    }

    /* renamed from: n, reason: from getter */
    public final int getCType() {
        return this.cType;
    }

    public final void o(@k Function1<? super Continuation<? super Unit>, ? extends Object> followBlock) {
        Intrinsics.checkNotNullParameter(followBlock, "followBlock");
        j(new TagBookListViewModel$getCategoriesByTag$1(this, followBlock, null), new TagBookListViewModel$getCategoriesByTag$2(null), false);
    }

    public final void p(@k YWCategoryBookListParams bookListParams, boolean showLoading, boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(bookListParams, "bookListParams");
        j(new TagBookListViewModel$getCategoryBookList$1(bookListParams, this, null), new TagBookListViewModel$getCategoryBookList$2(isLoadMore, this, null), showLoading);
    }

    /* renamed from: q, reason: from getter */
    public final int getExposeType() {
        return this.exposeType;
    }

    @k
    public final MutableLiveData<YWCategoryBookList> r() {
        return this.mCategoryBookListLiveData;
    }

    @k
    public final MutableLiveData<List<TYTag>> s() {
        return this.mCategoryListByTagLiveData;
    }

    @l
    /* renamed from: t, reason: from getter */
    public final String getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String() {
        return this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: u */
    public TagBookListRepository i() {
        return new TagBookListRepository();
    }

    public final void v(int i10) {
        this.cType = i10;
    }

    public final void w(int i10) {
        this.exposeType = i10;
    }

    public final void x(@l String str) {
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String = str;
    }
}
