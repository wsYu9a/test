package com.martian.mibook.mvvm.book.viewmodel;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.TYSearchRecommedInfo;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.TYTagAlias;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.book.repository.SearchRepository;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.SearchBooksParams;
import com.martian.mibook.mvvm.net.request.YWCategoryBookListParams;
import com.martian.mibook.mvvm.net.result.SearchBooksResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.umeng.analytics.pro.bt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import x8.c;
import xb.h;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0083@¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J6\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\u0004J\u0017\u0010\"\u001a\u00020 2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020 ¢\u0006\u0004\b$\u0010\u0004J/\u0010(\u001a\u00020 2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020 2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020 2\u0006\u0010.\u001a\u00020*¢\u0006\u0004\b/\u0010-J\u001f\u00102\u001a\u00020 2\u0006\u00100\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010*¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020 H\u0014¢\u0006\u0004\b4\u0010\u0004R$\u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010#R\u001c\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001f\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;8\u0006¢\u0006\f\n\u0004\b@\u0010>\u001a\u0004\bA\u0010BR0\u0010H\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR3\u0010L\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070E0D8\u0006¢\u0006\f\n\u0004\bI\u0010G\u001a\u0004\bJ\u0010KR*\u0010N\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r0E0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010>R-\u0010Q\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r0E0;8\u0006¢\u0006\f\n\u0004\bO\u0010>\u001a\u0004\bP\u0010BR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020R0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010>R\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020R0;8\u0006¢\u0006\f\n\u0004\bU\u0010>\u001a\u0004\bV\u0010BR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR$\u0010_\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u00106\u001a\u0004\b]\u00108\"\u0004\b^\u0010#R$\u0010f\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010m\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00107\u001a\u0004\bn\u0010o\"\u0004\bp\u0010-R\"\u0010.\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00107\u001a\u0004\bq\u0010o\"\u0004\br\u0010-R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00107\u001a\u0004\bs\u0010o\"\u0004\bt\u0010-R$\u0010w\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010a\u001a\u0004\bu\u0010c\"\u0004\bv\u0010eR$\u0010z\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010a\u001a\u0004\bx\u0010c\"\u0004\by\u0010eR$\u0010}\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010a\u001a\u0004\b{\u0010c\"\u0004\b|\u0010eR$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010a\u001a\u0004\b~\u0010c\"\u0004\b\u007f\u0010e¨\u0006\u0080\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/book/viewmodel/SearchViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/book/repository/SearchRepository;", "<init>", "()V", "", "keyword", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "v", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/mvvm/net/request/SearchBooksParams;", "searchBooksParams", "Lcom/martian/mibook/mvvm/net/result/SearchBooksResult;", "u", "(Lcom/martian/mibook/mvvm/net/request/SearchBooksParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;", "categoryBookListParams", "Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;", ExifInterface.LATITUDE_SOUTH, "(Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/lib/yuewen/response/YWFreeType;", "ywFreeTypeList", "", "Lcom/martian/mibook/lib/yuewen/response/TYTagAlias;", "tyTagList", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/martian/mibook/lib/yuewen/response/YWCategory;", "ywCategory", IAdInterListener.AdReqParam.WIDTH, "(Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;Lcom/martian/mibook/lib/yuewen/response/YWCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "R", "Q", "(Ljava/lang/String;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isLoadMore", "showLoading", "g0", "(Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;Lcom/martian/mibook/mvvm/net/request/SearchBooksParams;ZZ)V", "", "flexboxWordNumberPosition", bt.aJ, "(I)V", "flexboxStatusPosition", "y", "flexboxChannelPosition", "searchBookFreeType", "x", "(ILjava/lang/Integer;)V", "onCleared", "h", "Ljava/lang/String;", "I", "()Ljava/lang/String;", "Y", "recommendSearchKeyword", "Landroidx/lifecycle/MutableLiveData;", "Lcom/martian/mibook/lib/yuewen/response/TYSearchRecommedInfo;", "i", "Landroidx/lifecycle/MutableLiveData;", "_mSearchRecommendInfoLiveData", "j", "H", "()Landroidx/lifecycle/MutableLiveData;", "mSearchRecommendInfoLiveData", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "Lkotlin/Pair;", "k", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mSearchRecommendBooksLiveData", t.f11204d, "G", "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mSearchRecommendBooksLiveData", "m", "_mSearchBooksResultLiveData", "n", "F", "mSearchBooksResultLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "o", "_mSearchBooksResultErrorLiveData", "p", ExifInterface.LONGITUDE_EAST, "mSearchBooksResultErrorLiveData", "Lkotlinx/coroutines/Job;", "q", "Lkotlinx/coroutines/Job;", "currentSearchJob", t.f11211k, "O", "e0", "searchCategoryTag", "s", "Ljava/lang/Integer;", "P", "()Ljava/lang/Integer;", "f0", "(Ljava/lang/Integer;)V", "searchCategoryTagFreetype", bt.aO, "Lcom/martian/mibook/lib/yuewen/response/YWCategory;", "N", "()Lcom/martian/mibook/lib/yuewen/response/YWCategory;", "d0", "(Lcom/martian/mibook/lib/yuewen/response/YWCategory;)V", "searchCategory", "D", "()I", "X", "C", ExifInterface.LONGITUDE_WEST, "B", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "L", "b0", "searchBookMinWords", "K", "a0", "searchBookMaxWords", "M", "c0", "searchBookStatus", "J", "Z", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSearchViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchViewModel.kt\ncom/martian/mibook/mvvm/book/viewmodel/SearchViewModel\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,357:1\n314#2,11:358\n1855#3,2:369\n1855#3:371\n1855#3,2:372\n1856#3:374\n*S KotlinDebug\n*F\n+ 1 SearchViewModel.kt\ncom/martian/mibook/mvvm/book/viewmodel/SearchViewModel\n*L\n100#1:358,11\n244#1:369,2\n195#1:371\n200#1:372,2\n195#1:374\n*E\n"})
/* loaded from: classes3.dex */
public final class SearchViewModel extends BaseViewModel<SearchRepository> {

    /* renamed from: A */
    @l
    public Integer searchBookFreeType;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public String recommendSearchKeyword;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final MutableLiveData<TYSearchRecommedInfo> _mSearchRecommendInfoLiveData;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final MutableLiveData<TYSearchRecommedInfo> mSearchRecommendInfoLiveData;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<Pair<String, List<TYBookItem>>> _mSearchRecommendBooksLiveData;

    /* renamed from: l */
    @k
    public final NonStickyLiveData<Pair<String, List<TYBookItem>>> mSearchRecommendBooksLiveData;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Pair<YWCategoryBookList, SearchBooksResult>> _mSearchBooksResultLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Pair<YWCategoryBookList, SearchBooksResult>> mSearchBooksResultLiveData;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mSearchBooksResultErrorLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mSearchBooksResultErrorLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @l
    public Job currentSearchJob;

    /* renamed from: r */
    @l
    public String searchCategoryTag;

    /* renamed from: s, reason: from kotlin metadata */
    @l
    public Integer searchCategoryTagFreetype;

    /* renamed from: t */
    @l
    public YWCategory searchCategory;

    /* renamed from: u, reason: from kotlin metadata */
    public int flexboxWordNumberPosition;

    /* renamed from: v, reason: from kotlin metadata */
    public int flexboxStatusPosition;

    /* renamed from: w */
    public int flexboxChannelPosition;

    /* renamed from: x, reason: from kotlin metadata */
    @l
    public Integer searchBookMinWords;

    /* renamed from: y, reason: from kotlin metadata */
    @l
    public Integer searchBookMaxWords;

    /* renamed from: z */
    @l
    public Integer searchBookStatus;

    public static final class a extends h {

        /* renamed from: a */
        public final /* synthetic */ CancellableContinuation<List<? extends TYBookItem>> f14181a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CancellableContinuation<? super List<? extends TYBookItem>> cancellableContinuation) {
            this.f14181a = cancellableContinuation;
        }

        @Override // xb.h
        public void a(boolean z10) {
        }

        @Override // xb.h
        public void b(@k List<? extends TYBookItem> books) {
            Intrinsics.checkNotNullParameter(books, "books");
        }

        @Override // xb.h
        public void c(@l List<? extends TYBookItem> list) {
            if (this.f14181a.isActive()) {
                this.f14181a.resume(list, null);
            }
        }

        @Override // xb.h
        public void d(@l c cVar) {
            if (this.f14181a.isActive()) {
                this.f14181a.resume(null, null);
            }
        }
    }

    public SearchViewModel() {
        MutableLiveData<TYSearchRecommedInfo> mutableLiveData = new MutableLiveData<>();
        this._mSearchRecommendInfoLiveData = mutableLiveData;
        this.mSearchRecommendInfoLiveData = mutableLiveData;
        NonStickyLiveData<Pair<String, List<TYBookItem>>> nonStickyLiveData = new NonStickyLiveData<>();
        this._mSearchRecommendBooksLiveData = nonStickyLiveData;
        this.mSearchRecommendBooksLiveData = nonStickyLiveData;
        MutableLiveData<Pair<YWCategoryBookList, SearchBooksResult>> mutableLiveData2 = new MutableLiveData<>();
        this._mSearchBooksResultLiveData = mutableLiveData2;
        this.mSearchBooksResultLiveData = mutableLiveData2;
        MutableLiveData<ErrorResult> mutableLiveData3 = new MutableLiveData<>();
        this._mSearchBooksResultErrorLiveData = mutableLiveData3;
        this.mSearchBooksResultErrorLiveData = mutableLiveData3;
    }

    public static final Pair<YWCategoryBookListParams, YWCategory> U(String str, YWCategoryBookListParams yWCategoryBookListParams, YWFreeType yWFreeType) {
        List<YWCategory> categoryList = yWFreeType.getCategoryList();
        if (categoryList != null) {
            for (YWCategory yWCategory : categoryList) {
                if (StringsKt.equals(str, yWCategory.getCategoryName(), true)) {
                    yWCategoryBookListParams.setFreeType(Integer.valueOf(yWFreeType.getFreeType()));
                    return new Pair<>(yWCategoryBookListParams, yWCategory);
                }
                List<TYTag> tagList = yWCategory.getTagList();
                Intrinsics.checkNotNullExpressionValue(tagList, "getTagList(...)");
                Iterator<T> it = tagList.iterator();
                while (it.hasNext()) {
                    if (StringsKt.equals(str, ((TYTag) it.next()).getTag(), true)) {
                        yWCategoryBookListParams.setFreeType(Integer.valueOf(yWFreeType.getFreeType()));
                        return new Pair<>(yWCategoryBookListParams, null);
                    }
                }
            }
        }
        return null;
    }

    public final void A() {
        Job job = this.currentSearchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* renamed from: B, reason: from getter */
    public final int getFlexboxChannelPosition() {
        return this.flexboxChannelPosition;
    }

    /* renamed from: C, reason: from getter */
    public final int getFlexboxStatusPosition() {
        return this.flexboxStatusPosition;
    }

    /* renamed from: D, reason: from getter */
    public final int getFlexboxWordNumberPosition() {
        return this.flexboxWordNumberPosition;
    }

    @k
    public final MutableLiveData<ErrorResult> E() {
        return this.mSearchBooksResultErrorLiveData;
    }

    @k
    public final MutableLiveData<Pair<YWCategoryBookList, SearchBooksResult>> F() {
        return this.mSearchBooksResultLiveData;
    }

    @k
    public final NonStickyLiveData<Pair<String, List<TYBookItem>>> G() {
        return this.mSearchRecommendBooksLiveData;
    }

    @k
    public final MutableLiveData<TYSearchRecommedInfo> H() {
        return this.mSearchRecommendInfoLiveData;
    }

    @l
    /* renamed from: I, reason: from getter */
    public final String getRecommendSearchKeyword() {
        return this.recommendSearchKeyword;
    }

    @l
    /* renamed from: J, reason: from getter */
    public final Integer getSearchBookFreeType() {
        return this.searchBookFreeType;
    }

    @l
    /* renamed from: K, reason: from getter */
    public final Integer getSearchBookMaxWords() {
        return this.searchBookMaxWords;
    }

    @l
    /* renamed from: L, reason: from getter */
    public final Integer getSearchBookMinWords() {
        return this.searchBookMinWords;
    }

    @l
    /* renamed from: M, reason: from getter */
    public final Integer getSearchBookStatus() {
        return this.searchBookStatus;
    }

    @l
    /* renamed from: N, reason: from getter */
    public final YWCategory getSearchCategory() {
        return this.searchCategory;
    }

    @l
    /* renamed from: O, reason: from getter */
    public final String getSearchCategoryTag() {
        return this.searchCategoryTag;
    }

    @l
    /* renamed from: P, reason: from getter */
    public final Integer getSearchCategoryTagFreetype() {
        return this.searchCategoryTagFreetype;
    }

    public final void Q(@l String keyword) {
        Job launch$default;
        Job job = this.currentSearchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new SearchViewModel$getSearchRecommendBooksByKeyword$1(this, keyword, null), 2, null);
        this.currentSearchJob = launch$default;
    }

    public final void R() {
        BaseViewModel.k(this, new SearchViewModel$getSearchRecommendInfo$1(this, null), new SearchViewModel$getSearchRecommendInfo$2(this, null), false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S(com.martian.mibook.mvvm.net.request.YWCategoryBookListParams r8, kotlin.coroutines.Continuation<? super com.martian.mibook.lib.yuewen.response.YWCategoryBookList> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$searchBooksByCategory$1
            if (r0 == 0) goto L13
            r0 = r9
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$searchBooksByCategory$1 r0 = (com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$searchBooksByCategory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$searchBooksByCategory$1 r0 = new com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$searchBooksByCategory$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8a
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            goto Le0
        L3c:
            java.lang.Object r8 = r0.L$1
            com.martian.mibook.mvvm.net.request.YWCategoryBookListParams r8 = (com.martian.mibook.mvvm.net.request.YWCategoryBookListParams) r8
            java.lang.Object r2 = r0.L$0
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel r2 = (com.martian.mibook.mvvm.book.viewmodel.SearchViewModel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L9f
        L48:
            kotlin.ResultKt.throwOnFailure(r9)
            com.martian.mibook.application.MiConfigSingleton r9 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.MiBookManager r9 = r9.M1()
            java.util.List r9 = r9.G1()
            com.martian.mibook.application.MiConfigSingleton r2 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.MiBookManager r2 = r2.M1()
            java.util.List r2 = r2.N1()
            r6 = r9
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L8b
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L6f
            goto L8b
        L6f:
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L8b
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L7b
            goto L8b
        L7b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.label = r3
            java.lang.Object r9 = r7.T(r8, r9, r2, r0)
            if (r9 != r1) goto L8a
            return r1
        L8a:
            return r9
        L8b:
            com.martian.mibook.mvvm.base.BaseRepository r9 = r7.f()
            com.martian.mibook.mvvm.book.repository.SearchRepository r9 = (com.martian.mibook.mvvm.book.repository.SearchRepository) r9
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r9.i(r0)
            if (r9 != r1) goto L9e
            return r1
        L9e:
            r2 = r7
        L9f:
            com.martian.mibook.lib.yuewen.response.YWFreeTypeList r9 = (com.martian.mibook.lib.yuewen.response.YWFreeTypeList) r9
            r3 = 0
            if (r9 == 0) goto La9
            java.util.List r5 = r9.getFreeTypeList()
            goto Laa
        La9:
            r5 = r3
        Laa:
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto Le1
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto Lb6
            goto Le1
        Lb6:
            java.util.List r9 = r9.getTyTagList()
            com.martian.mibook.application.MiConfigSingleton r6 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.MiBookManager r6 = r6.M1()
            r6.I2(r9)
            com.martian.mibook.application.MiConfigSingleton r6 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.MiBookManager r6 = r6.M1()
            r6.H2(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r0.L$0 = r3
            r0.L$1 = r3
            r0.label = r4
            java.lang.Object r9 = r2.T(r8, r5, r9, r0)
            if (r9 != r1) goto Le0
            return r1
        Le0:
            return r9
        Le1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.book.viewmodel.SearchViewModel.S(com.martian.mibook.mvvm.net.request.YWCategoryBookListParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object T(YWCategoryBookListParams yWCategoryBookListParams, List<? extends YWFreeType> list, List<TYTagAlias> list2, Continuation<? super YWCategoryBookList> continuation) {
        Pair<YWCategoryBookListParams, YWCategory> pair;
        String tags = yWCategoryBookListParams.getTags();
        String str = "";
        if (tags == null) {
            tags = "";
        }
        Integer freeType = yWCategoryBookListParams.getFreeType();
        if (!list.isEmpty()) {
            if (freeType != null && freeType.intValue() == 1) {
                pair = U(tags, yWCategoryBookListParams, list.get(0));
            } else if (freeType != null && freeType.intValue() == 2 && list.size() > 1) {
                pair = U(tags, yWCategoryBookListParams, list.get(1));
            } else if (freeType == null) {
                int i10 = MiConfigSingleton.b2().p() == 2 ? 1 : 0;
                Pair<YWCategoryBookListParams, YWCategory> U = list.size() > i10 ? U(tags, yWCategoryBookListParams, list.get(i10)) : null;
                if (U == null) {
                    int size = list.size();
                    for (int i11 = 0; i11 < size && (i11 == i10 || (U = U(tags, yWCategoryBookListParams, list.get(i11))) == null); i11++) {
                    }
                }
                pair = U;
            } else {
                pair = null;
            }
            if (pair != null) {
                return w(pair.getFirst(), pair.getSecond(), continuation);
            }
        }
        if (!list2.isEmpty()) {
            int p10 = MiConfigSingleton.b2().p();
            int i12 = p10;
            for (TYTagAlias tYTagAlias : list2) {
                String maleAlias = tYTagAlias.getMaleAlias();
                String femaleAlias = tYTagAlias.getFemaleAlias();
                if (!ba.l.q(maleAlias)) {
                    Intrinsics.checkNotNull(maleAlias);
                    if (StringsKt.contains((CharSequence) maleAlias, (CharSequence) tags, true)) {
                        str = tYTagAlias.getTag();
                        Intrinsics.checkNotNullExpressionValue(str, "getTag(...)");
                        i12 = 1;
                    }
                }
                if (!ba.l.q(femaleAlias)) {
                    Intrinsics.checkNotNull(femaleAlias);
                    if (StringsKt.contains((CharSequence) femaleAlias, (CharSequence) tags, true)) {
                        str = tYTagAlias.getTag();
                        Intrinsics.checkNotNullExpressionValue(str, "getTag(...)");
                        i12 = 2;
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                yWCategoryBookListParams.setTags(str);
                yWCategoryBookListParams.setFreeType(Boxing.boxInt(i12));
                return w(yWCategoryBookListParams, null, continuation);
            }
        }
        return null;
    }

    public final void V(int i10) {
        this.flexboxChannelPosition = i10;
    }

    public final void W(int i10) {
        this.flexboxStatusPosition = i10;
    }

    public final void X(int i10) {
        this.flexboxWordNumberPosition = i10;
    }

    public final void Y(@l String str) {
        this.recommendSearchKeyword = str;
    }

    public final void Z(@l Integer num) {
        this.searchBookFreeType = num;
    }

    public final void a0(@l Integer num) {
        this.searchBookMaxWords = num;
    }

    public final void b0(@l Integer num) {
        this.searchBookMinWords = num;
    }

    public final void c0(@l Integer num) {
        this.searchBookStatus = num;
    }

    public final void d0(@l YWCategory yWCategory) {
        this.searchCategory = yWCategory;
    }

    public final void e0(@l String str) {
        this.searchCategoryTag = str;
    }

    public final void f0(@l Integer num) {
        this.searchCategoryTagFreetype = num;
    }

    public final void g0(@l YWCategoryBookListParams categoryBookListParams, @k SearchBooksParams searchBooksParams, boolean isLoadMore, boolean showLoading) {
        Intrinsics.checkNotNullParameter(searchBooksParams, "searchBooksParams");
        j(new SearchViewModel$startSearchBooks$1(this, searchBooksParams, isLoadMore, categoryBookListParams, null), new SearchViewModel$startSearchBooks$2(isLoadMore, this, null), showLoading);
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        A();
    }

    public final Object u(SearchBooksParams searchBooksParams, Continuation<? super SearchBooksResult> continuation) {
        return f().g(ExtKt.f(searchBooksParams), continuation);
    }

    @ExperimentalCoroutinesApi
    public final Object v(String str, Continuation<? super List<? extends TYBookItem>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        MiConfigSingleton.b2().M1().l1(str, 0, MiBookManager.P, new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(com.martian.mibook.mvvm.net.request.YWCategoryBookListParams r5, com.martian.mibook.lib.yuewen.response.YWCategory r6, kotlin.coroutines.Continuation<? super com.martian.mibook.lib.yuewen.response.YWCategoryBookList> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$asyncSearchBooksByCategory$1
            if (r0 == 0) goto L13
            r0 = r7
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$asyncSearchBooksByCategory$1 r0 = (com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$asyncSearchBooksByCategory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$asyncSearchBooksByCategory$1 r0 = new com.martian.mibook.mvvm.book.viewmodel.SearchViewModel$asyncSearchBooksByCategory$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            r6 = r5
            com.martian.mibook.lib.yuewen.response.YWCategory r6 = (com.martian.mibook.lib.yuewen.response.YWCategory) r6
            java.lang.Object r5 = r0.L$1
            com.martian.mibook.mvvm.net.request.YWCategoryBookListParams r5 = (com.martian.mibook.mvvm.net.request.YWCategoryBookListParams) r5
            java.lang.Object r0 = r0.L$0
            com.martian.mibook.mvvm.book.viewmodel.SearchViewModel r0 = (com.martian.mibook.mvvm.book.viewmodel.SearchViewModel) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.Map r7 = com.martian.mibook.mvvm.extensions.ExtKt.f(r5)
            com.martian.mibook.mvvm.base.BaseRepository r2 = r4.f()
            com.martian.mibook.mvvm.book.repository.SearchRepository r2 = (com.martian.mibook.mvvm.book.repository.SearchRepository) r2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r2.h(r7, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r0 = r4
        L5b:
            com.martian.mibook.lib.yuewen.response.YWCategoryBookList r7 = (com.martian.mibook.lib.yuewen.response.YWCategoryBookList) r7
            java.lang.String r1 = r5.getTags()
            r0.searchCategoryTag = r1
            java.lang.Integer r5 = r5.getFreeType()
            r0.searchCategoryTagFreetype = r5
            r0.searchCategory = r6
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.book.viewmodel.SearchViewModel.w(com.martian.mibook.mvvm.net.request.YWCategoryBookListParams, com.martian.mibook.lib.yuewen.response.YWCategory, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void x(int flexboxChannelPosition, @l Integer searchBookFreeType) {
        this.flexboxChannelPosition = flexboxChannelPosition;
        this.searchBookFreeType = searchBookFreeType;
    }

    public final void y(int flexboxStatusPosition) {
        this.flexboxStatusPosition = flexboxStatusPosition;
        if (flexboxStatusPosition == 0) {
            this.searchBookStatus = null;
        } else if (flexboxStatusPosition == 1) {
            this.searchBookStatus = 50;
        } else {
            if (flexboxStatusPosition != 2) {
                return;
            }
            this.searchBookStatus = 30;
        }
    }

    public final void z(int i10) {
        this.flexboxWordNumberPosition = i10;
        if (i10 == 0) {
            this.searchBookMinWords = null;
            this.searchBookMaxWords = null;
            return;
        }
        if (i10 == 1) {
            this.searchBookMinWords = null;
            this.searchBookMaxWords = 1000000;
        } else if (i10 == 2) {
            this.searchBookMinWords = 1000000;
            this.searchBookMaxWords = 3000000;
        } else {
            if (i10 != 3) {
                return;
            }
            this.searchBookMinWords = 3000000;
            this.searchBookMaxWords = null;
        }
    }
}
