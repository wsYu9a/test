package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.net.request.YWBookMallParams;
import com.martian.mibook.mvvm.yuewen.repository.BookMallRepository;
import com.umeng.analytics.pro.bt;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u0018R\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001fR\u001c\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010.R\u001a\u00106\u001a\b\u0012\u0004\u0012\u0002040+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010.R\"\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010.R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u0002040+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010.R\"\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010.R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u0002040+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010.R\u0019\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0+8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001f\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000+8F¢\u0006\u0006\u001a\u0004\bB\u0010@R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u0002040+8F¢\u0006\u0006\u001a\u0004\bD\u0010@R\u001f\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000+8F¢\u0006\u0006\u001a\u0004\bF\u0010@R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u0002040+8F¢\u0006\u0006\u001a\u0004\bH\u0010@R\u001f\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000+8F¢\u0006\u0006\u001a\u0004\bJ\u0010@R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u0002040+8F¢\u0006\u0006\u001a\u0004\bL\u0010@¨\u0006N"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/BookMallRepository;", "<init>", "()V", "H", "()Lcom/martian/mibook/mvvm/yuewen/repository/BookMallRepository;", "Lcom/martian/mibook/mvvm/net/request/YWBookMallParams;", "bookMallParams", "", "showLoading", "isLoadMore", "", bt.aO, "(Lcom/martian/mibook/mvvm/net/request/YWBookMallParams;ZZ)V", "Lcom/martian/mibook/mvvm/net/request/YWBookChannelBooksParams;", "isAddEvent", ExifInterface.LONGITUDE_EAST, "(Lcom/martian/mibook/mvvm/net/request/YWBookChannelBooksParams;Z)V", "v", "s", "(Lcom/martian/mibook/mvvm/net/request/YWBookChannelBooksParams;)V", "", "u", "()I", IAdInterListener.AdReqParam.WIDTH, "J", "h", "I", "G", "M", "(I)V", "tid", "i", "Z", "()Z", "K", "(Z)V", "isHomepage", "j", "F", "L", "speed", "Landroidx/lifecycle/MutableLiveData;", "Lcom/martian/mibook/lib/yuewen/response/YWBookMall;", "k", "Landroidx/lifecycle/MutableLiveData;", "_mYWBookMallLiveData", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", t.f11204d, "_mChannelBooksLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "m", "_mChannelBooksErrorLiveData", "n", "_mChangeABatchBooksLiveData", "o", "_mChangeABatchBooksErrorLiveData", "p", "_mCategoryBooksLiveData", "q", "_mCategoryBooksErrorLiveData", "D", "()Landroidx/lifecycle/MutableLiveData;", "mYWBookMallLiveData", "C", "mChannelBooksLiveData", "B", "mChannelBooksErrorLiveData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mChangeABatchBooksLiveData", bt.aJ, "mChangeABatchBooksErrorLiveData", "y", "mCategoryBooksLiveData", "x", "mCategoryBooksErrorLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookMallViewModel extends BaseViewModel<BookMallRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    public int tid;

    /* renamed from: j, reason: from kotlin metadata */
    public int speed;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean isHomepage = true;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final MutableLiveData<YWBookMall> _mYWBookMallLiveData = new MutableLiveData<>();

    /* renamed from: l */
    @k
    public final MutableLiveData<List<TYBookItem>> _mChannelBooksLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mChannelBooksErrorLiveData = new MutableLiveData<>();

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mChangeABatchBooksLiveData = new MutableLiveData<>();

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mChangeABatchBooksErrorLiveData = new MutableLiveData<>();

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mCategoryBooksLiveData = new MutableLiveData<>();

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mCategoryBooksErrorLiveData = new MutableLiveData<>();

    @k
    public final MutableLiveData<List<TYBookItem>> A() {
        return this._mChangeABatchBooksLiveData;
    }

    @k
    public final MutableLiveData<ErrorResult> B() {
        return this._mChannelBooksErrorLiveData;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> C() {
        return this._mChannelBooksLiveData;
    }

    @k
    public final MutableLiveData<YWBookMall> D() {
        return this._mYWBookMallLiveData;
    }

    public final void E(@k YWBookChannelBooksParams bookMallParams, boolean z10) {
        Intrinsics.checkNotNullParameter(bookMallParams, "bookMallParams");
        j(new BookMallViewModel$getRankTypeCategoryBooks$1(bookMallParams, this, z10, null), new BookMallViewModel$getRankTypeCategoryBooks$2(this, null), false);
    }

    /* renamed from: F, reason: from getter */
    public final int getSpeed() {
        return this.speed;
    }

    /* renamed from: G, reason: from getter */
    public final int getTid() {
        return this.tid;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: H */
    public BookMallRepository i() {
        return new BookMallRepository();
    }

    /* renamed from: I, reason: from getter */
    public final boolean getIsHomepage() {
        return this.isHomepage;
    }

    public final int J() {
        int nextInt = new Random().nextInt(10000);
        this.speed = nextInt;
        return nextInt;
    }

    public final void K(boolean z10) {
        this.isHomepage = z10;
    }

    public final void L(int i10) {
        this.speed = i10;
    }

    public final void M(int i10) {
        this.tid = i10;
    }

    public final void s(@k YWBookChannelBooksParams bookMallParams) {
        Intrinsics.checkNotNullParameter(bookMallParams, "bookMallParams");
        j(new BookMallViewModel$changeABatchBooks$1(bookMallParams, this, null), new BookMallViewModel$changeABatchBooks$2(this, null), false);
    }

    public final void t(@k YWBookMallParams bookMallParams, boolean z10, boolean z11) {
        Intrinsics.checkNotNullParameter(bookMallParams, "bookMallParams");
        j(new BookMallViewModel$getBookMallData$1(bookMallParams, this, z11, null), new BookMallViewModel$getBookMallData$2(z11, this, null), z10);
    }

    public final int u() {
        int i10 = this.tid;
        return (i10 == 1 || i10 == 2) ? i10 : MiConfigSingleton.b2().p();
    }

    public final void v(@k YWBookChannelBooksParams bookMallParams, boolean isAddEvent) {
        Intrinsics.checkNotNullParameter(bookMallParams, "bookMallParams");
        j(new BookMallViewModel$getCategoryTypeCategoryBooks$1(bookMallParams, this, isAddEvent, null), new BookMallViewModel$getCategoryTypeCategoryBooks$2(this, null), false);
    }

    public final int w() {
        return ConfigSingleton.D().t0("MIBOOK_BOOKMALL_" + this.tid);
    }

    @k
    public final MutableLiveData<ErrorResult> x() {
        return this._mCategoryBooksErrorLiveData;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> y() {
        return this._mCategoryBooksLiveData;
    }

    @k
    public final MutableLiveData<ErrorResult> z() {
        return this._mChangeABatchBooksErrorLiveData;
    }
}
