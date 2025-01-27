package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.yuewen.repository.SimilarityBookRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJC\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00070\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR%\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00070\u00178\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/SimilarityBookViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/SimilarityBookRepository;", "<init>", "()V", "p", "()Lcom/martian/mibook/mvvm/yuewen/repository/SimilarityBookRepository;", "", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "n", "()Ljava/util/List;", "", "pageIndex", "", "sourceName", "sourceId", "bookName", "", "isLoadMore", "showLoading", "", "m", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "h", "Landroidx/lifecycle/MutableLiveData;", "_mRecommendBookListLiveData", "i", "o", "()Landroidx/lifecycle/MutableLiveData;", "mRecommendBookListLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SimilarityBookViewModel extends BaseViewModel<SimilarityBookRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mRecommendBookListLiveData;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> mRecommendBookListLiveData;

    public SimilarityBookViewModel() {
        MutableLiveData<List<TYBookItem>> mutableLiveData = new MutableLiveData<>();
        this._mRecommendBookListLiveData = mutableLiveData;
        this.mRecommendBookListLiveData = mutableLiveData;
    }

    public final void m(int pageIndex, @l String sourceName, @l String sourceId, @l String bookName, boolean isLoadMore, boolean showLoading) {
        j(new SimilarityBookViewModel$getBookRecommendList$1(pageIndex, sourceName, sourceId, bookName, this, null), new SimilarityBookViewModel$getBookRecommendList$2(isLoadMore, this, null), showLoading);
    }

    @k
    public final List<BookWrapper> n() {
        List<BookWrapper> C = MiConfigSingleton.b2().M1().C(false);
        Intrinsics.checkNotNullExpressionValue(C, "filterSecretCategory(...)");
        return C;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> o() {
        return this.mRecommendBookListLiveData;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: p */
    public SimilarityBookRepository i() {
        return new SimilarityBookRepository();
    }
}
