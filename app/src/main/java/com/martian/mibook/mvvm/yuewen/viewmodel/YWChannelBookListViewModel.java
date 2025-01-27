package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.yuewen.repository.YWChannelBookListRepository;
import com.umeng.analytics.pro.bt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\"\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002010+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010/R\u001f\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010,0+8F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002010+8F¢\u0006\u0006\u001a\u0004\b6\u00104¨\u00068"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/YWChannelBookListViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/YWChannelBookListRepository;", "<init>", "()V", "v", "()Lcom/martian/mibook/mvvm/yuewen/repository/YWChannelBookListRepository;", "Lcom/martian/mibook/mvvm/net/request/YWBookChannelBooksParams;", "params", "", "showLoading", "isLoadMore", "", "u", "(Lcom/martian/mibook/mvvm/net/request/YWBookChannelBooksParams;ZZ)V", "", "h", "Ljava/lang/String;", bt.aO, "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "title", "i", "n", IAdInterListener.AdReqParam.WIDTH, "ext", "", "j", "I", "q", "()I", "x", "(I)V", "mcid", "k", "s", bt.aJ, "seed", t.f11204d, t.f11211k, "y", "pageIndex", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "m", "Landroidx/lifecycle/MutableLiveData;", "_mChannelBooksLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "_mChannelBooksErrorLiveData", "p", "()Landroidx/lifecycle/MutableLiveData;", "mChannelBooksLiveData", "o", "mChannelBooksErrorLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class YWChannelBookListViewModel extends BaseViewModel<YWChannelBookListRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public String title;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public String ext;

    /* renamed from: j, reason: from kotlin metadata */
    public int mcid;

    /* renamed from: k, reason: from kotlin metadata */
    public int seed;

    /* renamed from: l */
    public int pageIndex;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mChannelBooksLiveData = new MutableLiveData<>();

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mChannelBooksErrorLiveData = new MutableLiveData<>();

    public final void A(@l String str) {
        this.title = str;
    }

    @l
    /* renamed from: n, reason: from getter */
    public final String getExt() {
        return this.ext;
    }

    @k
    public final MutableLiveData<ErrorResult> o() {
        return this._mChannelBooksErrorLiveData;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> p() {
        return this._mChannelBooksLiveData;
    }

    /* renamed from: q, reason: from getter */
    public final int getMcid() {
        return this.mcid;
    }

    /* renamed from: r, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: s, reason: from getter */
    public final int getSeed() {
        return this.seed;
    }

    @l
    /* renamed from: t, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final void u(@k YWBookChannelBooksParams params, boolean showLoading, boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(params, "params");
        j(new YWChannelBookListViewModel$getYWChannelBookList$1(params, this, null), new YWChannelBookListViewModel$getYWChannelBookList$2(isLoadMore, this, null), showLoading);
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: v */
    public YWChannelBookListRepository i() {
        return new YWChannelBookListRepository();
    }

    public final void w(@l String str) {
        this.ext = str;
    }

    public final void x(int i10) {
        this.mcid = i10;
    }

    public final void y(int i10) {
        this.pageIndex = i10;
    }

    public final void z(int i10) {
        this.seed = i10;
    }
}
