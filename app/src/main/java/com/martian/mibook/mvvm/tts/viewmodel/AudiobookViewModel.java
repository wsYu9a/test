package com.martian.mibook.mvvm.tts.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.base.SingleLiveEvent;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.tts.repository.AudiobookRepository;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.rpauth.response.MartianRPAccount;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x8.c;
import xb.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0004J\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u00101\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\"\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000204\u0018\u000103028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R%\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000204\u0018\u000103028\u0006¢\u0006\f\n\u0004\b8\u00106\u001a\u0004\b9\u0010:R\u001c\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010>R\u001f\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0<8\u0006¢\u0006\f\n\u0004\b\u0015\u0010>\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001a0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010>R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001a0<8\u0006¢\u0006\f\n\u0004\b+\u0010>\u001a\u0004\bD\u0010AR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120F8\u0006¢\u0006\f\n\u0004\bJ\u0010H\u001a\u0004\bJ\u0010KR\u001c\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010HR\u001f\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0F8\u0006¢\u0006\f\n\u0004\bD\u0010H\u001a\u0004\bG\u0010KR$\u0010T\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010P\u001a\u0004\bQ\u0010R\"\u0004\b$\u0010S¨\u0006U"}, d2 = {"Lcom/martian/mibook/mvvm/tts/viewmodel/AudiobookViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/tts/repository/AudiobookRepository;", "<init>", "()V", "x", "()Lcom/martian/mibook/mvvm/tts/repository/AudiobookRepository;", "", "sourceId", "sourceName", "", "B", "(Ljava/lang/String;Ljava/lang/String;)V", "o", "Landroid/content/Context;", f.X, "C", "(Landroid/content/Context;)V", "Lcom/martian/mibook/lib/model/data/abs/Book;", "h", "Lcom/martian/mibook/lib/model/data/abs/Book;", "p", "()Lcom/martian/mibook/lib/model/data/abs/Book;", "D", "(Lcom/martian/mibook/lib/model/data/abs/Book;)V", "book", "", "i", "Z", "y", "()Z", "G", "(Z)V", "isRestartAudiobook", "", "j", "I", "q", "()I", ExifInterface.LONGITUDE_EAST, "(I)V", BaseReadAloudService.f15168x, "k", t.f11211k, "F", BaseReadAloudService.f15169y, t.f11204d, bt.aJ, "H", "isRestarting", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "m", "Landroidx/lifecycle/MutableLiveData;", "_mRecommendBookListLiveData", "n", IAdInterListener.AdReqParam.WIDTH, "()Landroidx/lifecycle/MutableLiveData;", "mRecommendBookListLiveData", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "Lcom/martian/rpauth/response/MartianRPAccount;", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mMiAccountLiveData", "u", "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mMiAccountLiveData", "_mPlayerLoadingLiveData", "v", "mPlayerLoadingLiveData", "Lcom/martian/mibook/mvvm/base/SingleLiveEvent;", "s", "Lcom/martian/mibook/mvvm/base/SingleLiveEvent;", "_mLoadBookLiveData", bt.aO, "()Lcom/martian/mibook/mvvm/base/SingleLiveEvent;", "mLoadBookLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "_mLoadBookErrorLiveData", "mLoadBookErrorLiveData", "Ljava/lang/Boolean;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "isVip", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AudiobookViewModel extends BaseViewModel<AudiobookRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public Book book;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean isRestartAudiobook;

    /* renamed from: j, reason: from kotlin metadata */
    public int com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;

    /* renamed from: k, reason: from kotlin metadata */
    public int com.martian.mibook.mvvm.tts.service.BaseReadAloudService.y java.lang.String;

    /* renamed from: l */
    public boolean isRestarting;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mRecommendBookListLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> mRecommendBookListLiveData;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<MartianRPAccount> _mMiAccountLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<MartianRPAccount> mMiAccountLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Boolean> _mPlayerLoadingLiveData;

    /* renamed from: r */
    @k
    public final NonStickyLiveData<Boolean> mPlayerLoadingLiveData;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public final SingleLiveEvent<Book> _mLoadBookLiveData;

    /* renamed from: t */
    @k
    public final SingleLiveEvent<Book> mLoadBookLiveData;

    /* renamed from: u, reason: from kotlin metadata */
    @k
    public final SingleLiveEvent<ErrorResult> _mLoadBookErrorLiveData;

    /* renamed from: v, reason: from kotlin metadata */
    @k
    public final SingleLiveEvent<ErrorResult> mLoadBookErrorLiveData;

    /* renamed from: w */
    @l
    public Boolean isVip;

    public static final class a implements b {
        public a() {
        }

        @Override // xb.b
        @SuppressLint({"NullSafeMutableLiveData"})
        public void a(@l Book book) {
            if (book != null) {
                AudiobookViewModel.this.D(book);
                AudiobookViewModel.this._mLoadBookLiveData.postValue(book);
            } else {
                AudiobookViewModel.this._mLoadBookErrorLiveData.postValue(new ErrorResult(-1, "信息获取失败", null, 4, null));
            }
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(@l c cVar) {
            ErrorResult errorResult = new ErrorResult(-1, "信息获取失败", null, 4, null);
            if (cVar != null) {
                errorResult.setErrorCode(cVar.c());
                String d10 = cVar.d();
                Intrinsics.checkNotNullExpressionValue(d10, "getErrorMsg(...)");
                errorResult.setErrorMsg(d10);
            }
            AudiobookViewModel.this._mLoadBookErrorLiveData.postValue(errorResult);
        }
    }

    public AudiobookViewModel() {
        MutableLiveData<List<TYBookItem>> mutableLiveData = new MutableLiveData<>();
        this._mRecommendBookListLiveData = mutableLiveData;
        this.mRecommendBookListLiveData = mutableLiveData;
        NonStickyLiveData<MartianRPAccount> nonStickyLiveData = new NonStickyLiveData<>();
        this._mMiAccountLiveData = nonStickyLiveData;
        this.mMiAccountLiveData = nonStickyLiveData;
        NonStickyLiveData<Boolean> nonStickyLiveData2 = new NonStickyLiveData<>();
        this._mPlayerLoadingLiveData = nonStickyLiveData2;
        this.mPlayerLoadingLiveData = nonStickyLiveData2;
        SingleLiveEvent<Book> singleLiveEvent = new SingleLiveEvent<>();
        this._mLoadBookLiveData = singleLiveEvent;
        this.mLoadBookLiveData = singleLiveEvent;
        SingleLiveEvent<ErrorResult> singleLiveEvent2 = new SingleLiveEvent<>();
        this._mLoadBookErrorLiveData = singleLiveEvent2;
        this.mLoadBookErrorLiveData = singleLiveEvent2;
    }

    @l
    /* renamed from: A, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    public final void B(@l String sourceId, @l String sourceName) {
        if (TextUtils.isEmpty(sourceId) || TextUtils.isEmpty(sourceName)) {
            ErrorResult errorResult = new ErrorResult(-1, "信息获取失败", null, 4, null);
            errorResult.setObj(Boolean.TRUE);
            this._mLoadBookErrorLiveData.postValue(errorResult);
        } else {
            Book I = MiConfigSingleton.b2().M1().I(new Source(sourceName, sourceId));
            if (I == null) {
                MiConfigSingleton.b2().M1().k(new Source(sourceName, sourceId), new a());
            } else {
                this.book = I;
                this._mLoadBookLiveData.postValue(I);
            }
        }
    }

    public final void C(@k Context r42) {
        Intrinsics.checkNotNullParameter(r42, "context");
        Book book = this.book;
        if (TextUtils.isEmpty(book != null ? book.getSourceString() : null)) {
            return;
        }
        this.isRestarting = true;
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = readAloudBook.c();
        this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.y java.lang.String = readAloudBook.f();
        this._mPlayerLoadingLiveData.postValue(Boolean.TRUE);
        Book book2 = this.book;
        String sourceString = book2 != null ? book2.getSourceString() : null;
        Intrinsics.checkNotNull(sourceString);
        TTSReadManager.k(r42, sourceString, this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String, this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.y java.lang.String);
    }

    public final void D(@l Book book) {
        this.book = book;
    }

    public final void E(int i10) {
        this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = i10;
    }

    public final void F(int i10) {
        this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.y java.lang.String = i10;
    }

    public final void G(boolean z10) {
        this.isRestartAudiobook = z10;
    }

    public final void H(boolean z10) {
        this.isRestarting = z10;
    }

    public final void I(@l Boolean bool) {
        this.isVip = bool;
    }

    public final void o() {
        j(new AudiobookViewModel$getAudioBookRecommendList$1(this, null), new AudiobookViewModel$getAudioBookRecommendList$2(this, null), false);
    }

    @l
    /* renamed from: p, reason: from getter */
    public final Book getBook() {
        return this.book;
    }

    /* renamed from: q, reason: from getter */
    public final int getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() {
        return this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;
    }

    /* renamed from: r, reason: from getter */
    public final int getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.y java.lang.String() {
        return this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.y java.lang.String;
    }

    @k
    public final SingleLiveEvent<ErrorResult> s() {
        return this.mLoadBookErrorLiveData;
    }

    @k
    public final SingleLiveEvent<Book> t() {
        return this.mLoadBookLiveData;
    }

    @k
    public final NonStickyLiveData<MartianRPAccount> u() {
        return this.mMiAccountLiveData;
    }

    @k
    public final NonStickyLiveData<Boolean> v() {
        return this.mPlayerLoadingLiveData;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> w() {
        return this.mRecommendBookListLiveData;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: x */
    public AudiobookRepository i() {
        return new AudiobookRepository();
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsRestartAudiobook() {
        return this.isRestartAudiobook;
    }

    /* renamed from: z, reason: from getter */
    public final boolean getIsRestarting() {
        return this.isRestarting;
    }
}
