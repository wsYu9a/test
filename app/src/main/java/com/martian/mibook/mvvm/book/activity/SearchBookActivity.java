package com.martian.mibook.mvvm.book.activity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.utils.tablayout.ClipPagerTitleView;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.AuthorBooksActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivitySearchBookBinding;
import com.martian.mibook.databinding.LayoutSearchFilterViewBinding;
import com.martian.mibook.databinding.SearchCustomViewBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.TYSearchRecommedInfo;
import com.martian.mibook.lib.yuewen.response.TYSearchTag;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.book.activity.SearchBookActivity;
import com.martian.mibook.mvvm.book.adapter.SearchBooksResultAdapter;
import com.martian.mibook.mvvm.book.adapter.SearchRecommendItemAdapter;
import com.martian.mibook.mvvm.book.viewmodel.SearchViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.SearchBooksParams;
import com.martian.mibook.mvvm.net.request.YWCategoryBookListParams;
import com.martian.mibook.mvvm.net.result.SearchBooksResult;
import com.martian.mibook.mvvm.widget.DropDownMenuLayout;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.martian.mibook.ui.FlowLayout;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import l9.i0;
import l9.t0;
import m9.f;
import m9.g;
import xi.k;
import xi.l;
import ya.e0;

@Route(path = kc.a.f27756l)
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\b\u0006*\u0001}\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0081\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010#\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0005J\u0019\u0010&\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b&\u0010\u0019J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010\u0019J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u0005J\u0019\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100J\u0019\u00103\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0006H\u0014¢\u0006\u0004\b5\u0010\u0005R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000f0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010^\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010]R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010XR\u0016\u0010l\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010XR\u0016\u0010n\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010XR!\u0010s\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR!\u0010v\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010p\u001a\u0004\bu\u0010rR!\u0010y\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010p\u001a\u0004\bx\u0010rR#\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010p\u001a\u0004\b{\u0010rR\u0015\u0010\u0080\u0001\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007f¨\u0006\u0082\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/book/activity/SearchBookActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivitySearchBookBinding;", "Lcom/martian/mibook/mvvm/book/viewmodel/SearchViewModel;", "<init>", "()V", "", r3.c.f30242e, "Z2", "W2", "initView", "Lcom/martian/mibook/lib/yuewen/response/TYSearchRecommedInfo;", "searchRecommendInfo", "P2", "(Lcom/martian/mibook/lib/yuewen/response/TYSearchRecommedInfo;)V", "", "keyword", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "O2", "(Ljava/lang/String;Ljava/util/List;)V", "G2", "content", "T2", "(Ljava/lang/String;)V", "", "isLoadMore", "showLoading", "U2", "(ZZ)V", "Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;", "first", "Lcom/martian/mibook/mvvm/net/result/SearchBooksResult;", "second", "S2", "(Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;Lcom/martian/mibook/mvvm/net/result/SearchBooksResult;)V", "q2", "N2", "M2", "Lcom/martian/mibook/mvvm/book/activity/SearchBookActivity$SearchStatus;", "status", "a3", "(Lcom/martian/mibook/mvvm/book/activity/SearchBookActivity$SearchStatus;)V", "p1", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "onStart", "Lcom/martian/mibook/databinding/SearchCustomViewBinding;", "h", "Lcom/martian/mibook/databinding/SearchCustomViewBinding;", "searchCustomViewBinding", "i", "Lcom/martian/mibook/mvvm/book/activity/SearchBookActivity$SearchStatus;", "searchStatus", "", "j", "Ljava/util/List;", "suggestion", "Lnc/b;", "k", "Lnc/b;", "searchRankItemAdapter", "Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter;", t.f11204d, "Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter;", "searchRecommendItemAdapter", "Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter;", "m", "Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter;", "searchBookResultAdapter", "", "n", "[Ljava/lang/String;", "filterOrderTab", "o", "Ljava/lang/String;", "searchKeyword", "p", "simpleSearchKeyword", "", "q", "I", "searchBookOrder", t.f11211k, "pageIndex", "s", "Z", "loadMoreFail", bt.aO, "isLoading", "Lcom/martian/mibook/databinding/LayoutSearchFilterViewBinding;", "u", "Lcom/martian/mibook/databinding/LayoutSearchFilterViewBinding;", "searchFilterViewBinding", "Lm9/d;", "v", "Lm9/d;", "filterOrderHelper", IAdInterListener.AdReqParam.WIDTH, "flexboxWordNumberPosition", "x", "flexboxStatusPosition", "y", "flexboxChannelPosition", bt.aJ, "Lkotlin/Lazy;", "u2", "()Ljava/util/List;", "wordNumberList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t2", "statusList", "B", "r2", "channelList", "C", "s2", "channelTypeList", "com/martian/mibook/mvvm/book/activity/SearchBookActivity$c", "D", "Lcom/martian/mibook/mvvm/book/activity/SearchBookActivity$c;", "textWatcher", "SearchStatus", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSearchBookActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchBookActivity.kt\ncom/martian/mibook/mvvm/book/activity/SearchBookActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,753:1\n1549#2:754\n1620#2,3:755\n777#2:758\n788#2:759\n1864#2,2:760\n789#2,2:762\n1866#2:764\n791#2:765\n1#3:766\n*S KotlinDebug\n*F\n+ 1 SearchBookActivity.kt\ncom/martian/mibook/mvvm/book/activity/SearchBookActivity\n*L\n410#1:754\n410#1:755,3\n472#1:758\n472#1:759\n472#1:760,2\n472#1:762,2\n472#1:764\n472#1:765\n*E\n"})
/* loaded from: classes3.dex */
public final class SearchBookActivity extends BaseMVVMActivity<ActivitySearchBookBinding, SearchViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public SearchCustomViewBinding searchCustomViewBinding;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public nc.b searchRankItemAdapter;

    /* renamed from: l */
    @l
    public SearchRecommendItemAdapter searchRecommendItemAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public SearchBooksResultAdapter searchBookResultAdapter;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public String searchKeyword;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public String simpleSearchKeyword;

    /* renamed from: q, reason: from kotlin metadata */
    public int searchBookOrder;

    /* renamed from: r */
    public int pageIndex;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean loadMoreFail;

    /* renamed from: t */
    public boolean isLoading;

    /* renamed from: u, reason: from kotlin metadata */
    @l
    public LayoutSearchFilterViewBinding searchFilterViewBinding;

    /* renamed from: v, reason: from kotlin metadata */
    @l
    public m9.d filterOrderHelper;

    /* renamed from: w */
    public int flexboxWordNumberPosition;

    /* renamed from: x, reason: from kotlin metadata */
    public int flexboxStatusPosition;

    /* renamed from: y, reason: from kotlin metadata */
    public int flexboxChannelPosition;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public SearchStatus searchStatus = SearchStatus.IDLE;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public List<String> suggestion = new ArrayList();

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final String[] filterOrderTab = {"综合", "最新", "评分", "字数"};

    /* renamed from: z */
    @k
    public final Lazy wordNumberList = LazyKt.lazy(new Function0<List<? extends String>>() { // from class: com.martian.mibook.mvvm.book.activity.SearchBookActivity$wordNumberList$2
        public SearchBookActivity$wordNumberList$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final List<? extends String> invoke() {
            return CollectionsKt.listOf((Object[]) new String[]{SearchBookActivity.this.getString(R.string.unlimited), SearchBookActivity.this.getString(R.string.number_word1), SearchBookActivity.this.getString(R.string.number_word2), SearchBookActivity.this.getString(R.string.number_word3)});
        }
    });

    /* renamed from: A */
    @k
    public final Lazy statusList = LazyKt.lazy(new Function0<List<? extends String>>() { // from class: com.martian.mibook.mvvm.book.activity.SearchBookActivity$statusList$2
        public SearchBookActivity$statusList$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final List<? extends String> invoke() {
            return CollectionsKt.listOf((Object[]) new String[]{SearchBookActivity.this.getString(R.string.unlimited), SearchBookActivity.this.getString(R.string.bookstores_finish), SearchBookActivity.this.getString(R.string.serialise)});
        }
    });

    /* renamed from: B, reason: from kotlin metadata */
    @k
    public final Lazy channelList = LazyKt.lazy(new Function0<List<? extends String>>() { // from class: com.martian.mibook.mvvm.book.activity.SearchBookActivity$channelList$2
        public SearchBookActivity$channelList$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final List<? extends String> invoke() {
            return MiConfigSingleton.b2().p() == 2 ? CollectionsKt.listOf((Object[]) new String[]{SearchBookActivity.this.getString(R.string.unlimited), SearchBookActivity.this.getString(R.string.female), SearchBookActivity.this.getString(R.string.male)}) : CollectionsKt.listOf((Object[]) new String[]{SearchBookActivity.this.getString(R.string.unlimited), SearchBookActivity.this.getString(R.string.male), SearchBookActivity.this.getString(R.string.female)});
        }
    });

    /* renamed from: C, reason: from kotlin metadata */
    @k
    public final Lazy channelTypeList = LazyKt.lazy(SearchBookActivity$channelTypeList$2.INSTANCE);

    /* renamed from: D, reason: from kotlin metadata */
    @k
    public final c textWatcher = new c();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/martian/mibook/mvvm/book/activity/SearchBookActivity$SearchStatus;", "", "(Ljava/lang/String;I)V", "IDLE", "TIPS", "RESULT", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SearchStatus extends Enum<SearchStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SearchStatus[] $VALUES;
        public static final SearchStatus IDLE = new SearchStatus("IDLE", 0);
        public static final SearchStatus TIPS = new SearchStatus("TIPS", 1);
        public static final SearchStatus RESULT = new SearchStatus("RESULT", 2);

        private static final /* synthetic */ SearchStatus[] $values() {
            return new SearchStatus[]{IDLE, TIPS, RESULT};
        }

        static {
            SearchStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private SearchStatus(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<SearchStatus> getEntries() {
            return $ENTRIES;
        }

        public static SearchStatus valueOf(String str) {
            return (SearchStatus) Enum.valueOf(SearchStatus.class, str);
        }

        public static SearchStatus[] values() {
            return (SearchStatus[]) $VALUES.clone();
        }
    }

    public static final class a extends m9.b {

        /* renamed from: c */
        public final /* synthetic */ int f14080c;

        /* renamed from: d */
        public final /* synthetic */ int f14081d;

        public a(int i10, int i11) {
            this.f14080c = i10;
            this.f14081d = i11;
        }

        public static final void j(SearchBookActivity this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            m9.d dVar = this$0.filterOrderHelper;
            if (dVar != null) {
                dVar.j(i10, true);
            }
            this$0.searchBookOrder = i10;
            SearchBookActivity.V2(this$0, false, false, 3, null);
        }

        @Override // m9.b
        public int a() {
            return SearchBookActivity.this.filterOrderTab.length;
        }

        @Override // m9.b
        @l
        public m9.e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
            clipPagerTitleView.setText(ExtKt.c(SearchBookActivity.this.filterOrderTab[i10]));
            clipPagerTitleView.setTextSize(ConfigSingleton.o1(16));
            clipPagerTitleView.setTextColor(ConfigSingleton.D().j0());
            clipPagerTitleView.setClipColor(ConfigSingleton.D().h0());
            int i11 = this.f14080c;
            clipPagerTitleView.setPadding(i11, this.f14081d, i11, i11);
            clipPagerTitleView.setTextStyleMode(1);
            clipPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: mc.c1

                /* renamed from: c */
                public final /* synthetic */ int f28569c;

                public /* synthetic */ c1(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchBookActivity.a.j(SearchBookActivity.this, i10, view);
                }
            });
            return clipPagerTitleView;
        }
    }

    public static final class b implements SearchRecommendItemAdapter.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.book.adapter.SearchRecommendItemAdapter.a
        public void a(@l TYBookItem tYBookItem, @k String keyword) {
            String author;
            String bookName;
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            if (tYBookItem != null && (bookName = tYBookItem.getBookName()) != null && StringsKt.contains$default((CharSequence) bookName, (CharSequence) keyword, false, 2, (Object) null)) {
                i.H(SearchBookActivity.this, tYBookItem);
            } else if (tYBookItem != null && (author = tYBookItem.getAuthor()) != null && StringsKt.contains$default((CharSequence) author, (CharSequence) keyword, false, 2, (Object) null)) {
                AuthorBooksActivity.L2(SearchBookActivity.this, tYBookItem, AuthorBooksActivity.J, 0);
            }
            SearchBookActivity.this.M2(keyword);
        }
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@k Editable s10) {
            Intrinsics.checkNotNullParameter(s10, "s");
            SearchBookActivity.this.a3(SearchStatus.TIPS);
            SearchBookActivity.this.T2(s10.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@l CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@k CharSequence s10, int i10, int i11, int i12) {
            ThemeImageView themeImageView;
            Intrinsics.checkNotNullParameter(s10, "s");
            SearchCustomViewBinding searchCustomViewBinding = SearchBookActivity.this.searchCustomViewBinding;
            if (searchCustomViewBinding == null || (themeImageView = searchCustomViewBinding.btnClearSearchText) == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) s10);
            themeImageView.setVisibility(!TextUtils.isEmpty(sb2.toString()) ? 0 : 8);
        }
    }

    public static final class d implements FlexboxTagLayout.a {
        public d() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            SearchBookActivity.this.flexboxWordNumberPosition = i10;
        }
    }

    public static final class e implements FlexboxTagLayout.a {
        public e() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            SearchBookActivity.this.flexboxStatusPosition = i10;
        }
    }

    public static final class f implements FlexboxTagLayout.a {
        public f() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            SearchBookActivity.this.flexboxChannelPosition = i10;
        }
    }

    public static final void A2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void C2(SearchBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i0.z0(this$0, this$0.getResources().getString(R.string.delete_history), this$0.getResources().getString(R.string.delete_history_hint), new i0.l() { // from class: mc.s0
            public /* synthetic */ s0() {
            }

            @Override // l9.i0.l
            public final void a() {
                SearchBookActivity.D2(SearchBookActivity.this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void D2(SearchBookActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().n2().a();
        ((ActivitySearchBookBinding) this$0.a1()).flSearchSearchHistory.k();
        ((ActivitySearchBookBinding) this$0.a1()).searchHistoryView.setVisibility(8);
    }

    public static final void E2(SearchBookActivity this$0, String str, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N2(str);
        V2(this$0, false, false, 3, null);
    }

    public static final void F2(SearchBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.O(this$0, "热搜榜-查看全部");
        kc.b.i(MiConfigSingleton.b2().p(), 80, "", "搜索-");
    }

    public static final void H2(SearchBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        V2(this$0, false, false, 3, null);
    }

    public static final void I2(SearchBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N2(null);
        this$0.a3(SearchStatus.IDLE);
    }

    public static final void J2(SearchBookActivity this$0, SearchCustomViewBinding this_run, View view, boolean z10) {
        ThemeImageView themeImageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        SearchCustomViewBinding searchCustomViewBinding = this$0.searchCustomViewBinding;
        if (searchCustomViewBinding == null || (themeImageView = searchCustomViewBinding.btnClearSearchText) == null) {
            return;
        }
        themeImageView.setVisibility((!z10 || TextUtils.isEmpty(this_run.scEditText.getText())) ? 8 : 0);
    }

    public static final boolean K2(SearchBookActivity this$0, SearchCustomViewBinding this_run, TextView textView, int i10, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        if (i10 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        i.n(this$0, this_run.scEditText);
        V2(this$0, false, false, 3, null);
        return true;
    }

    public static final void L2(SearchBookActivity this$0, pf.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.loadMoreFail) {
            this$0.pageIndex++;
        }
        V2(this$0, true, false, 2, null);
    }

    public static final void Q2(List hotTags, SearchBookActivity this$0, String str, int i10) {
        Object obj;
        Intrinsics.checkNotNullParameter(hotTags, "$hotTags");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = hotTags.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (StringsKt.equals(((TYSearchTag) obj).getName(), str, true)) {
                    break;
                }
            }
        }
        TYSearchTag tYSearchTag = (TYSearchTag) obj;
        if (tYSearchTag != null) {
            if (i8.g.h(this$0, tYSearchTag.getDplink())) {
                i8.g.A(this$0, tYSearchTag.getDplink(), "", "", true);
            } else if (ba.l.q(tYSearchTag.getUrl())) {
                i.b0(tYSearchTag.getCtype(), str, 5);
            } else {
                MiWebViewActivity.startWebViewActivity(this$0, tYSearchTag.getUrl());
            }
        }
    }

    public static final void R2(SearchBookActivity this$0, AdapterView adapterView, View view, int i10, long j10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nc.b bVar = this$0.searchRankItemAdapter;
        i.H(this$0, bVar != null ? bVar.b(i10) : null);
    }

    public static /* synthetic */ void V2(SearchBookActivity searchBookActivity, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            SearchBooksResultAdapter searchBooksResultAdapter = searchBookActivity.searchBookResultAdapter;
            z11 = (searchBooksResultAdapter != null ? searchBooksResultAdapter.getPageSize() : 0) <= 0;
        }
        searchBookActivity.U2(z10, z11);
    }

    public static final void X2(LayoutSearchFilterViewBinding it, SearchBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.flexboxWordNumber.setSelectPosition(0);
        it.flexboxStatus.setSelectPosition(0);
        it.flexboxChannel.setSelectPosition(0);
        this$0.flexboxWordNumberPosition = 0;
        this$0.flexboxStatusPosition = 0;
        this$0.flexboxChannelPosition = 0;
    }

    public static final void Y2(SearchBookActivity this$0, View view) {
        DropDownMenuLayout root;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LayoutSearchFilterViewBinding layoutSearchFilterViewBinding = this$0.searchFilterViewBinding;
        if (layoutSearchFilterViewBinding != null && (root = layoutSearchFilterViewBinding.getRoot()) != null) {
            root.g();
        }
        V2(this$0, false, false, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivitySearchBookBinding a2(SearchBookActivity searchBookActivity) {
        return (ActivitySearchBookBinding) searchBookActivity.a1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ActivitySearchBookBinding) a1()).refreshLayout.j0(false);
        ((ActivitySearchBookBinding) a1()).refreshLayout.U(new MiClassicsFooter(this, 1, false, 4, null));
        ((ActivitySearchBookBinding) a1()).refreshLayout.f0(new sf.e() { // from class: mc.r0
            public /* synthetic */ r0() {
            }

            @Override // sf.e
            public final void p(pf.f fVar) {
                SearchBookActivity.L2(SearchBookActivity.this, fVar);
            }
        });
        CommonNavigator commonNavigator = new CommonNavigator(this);
        int i10 = ConfigSingleton.i(10.0f);
        int i11 = ConfigSingleton.i(8.0f);
        commonNavigator.setMarginHorizontal(0);
        this.filterOrderHelper = new m9.d();
        commonNavigator.setAdapter(new a(i10, i11));
        ((ActivitySearchBookBinding) a1()).filterOrder.setNavigator(commonNavigator);
        m9.d dVar = this.filterOrderHelper;
        if (dVar != null) {
            dVar.d(((ActivitySearchBookBinding) a1()).filterOrder);
        }
        ((ActivitySearchBookBinding) a1()).rvSearchBooks.setLayoutManager(new LinearLayoutManager(this));
        ((ActivitySearchBookBinding) a1()).flSearchSearchHistory.setConvertToTraditional(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v2() {
        ((ActivitySearchBookBinding) a1()).spClear.setOnClickListener(new View.OnClickListener() { // from class: mc.j0
            public /* synthetic */ j0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchBookActivity.C2(SearchBookActivity.this, view);
            }
        });
        ((ActivitySearchBookBinding) a1()).flSearchSearchHistory.setOnItemTitleClickListener(new FlowLayout.a() { // from class: mc.t0
            public /* synthetic */ t0() {
            }

            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i10) {
                SearchBookActivity.E2(SearchBookActivity.this, str, i10);
            }
        });
        ((ActivitySearchBookBinding) a1()).llHotSearchRank.setOnClickListener(new View.OnClickListener() { // from class: mc.u0
            public /* synthetic */ u0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchBookActivity.F2(SearchBookActivity.this, view);
            }
        });
        ((ActivitySearchBookBinding) a1()).buttonFilter.setOnClickListener(new View.OnClickListener() { // from class: mc.v0
            public /* synthetic */ v0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchBookActivity.w2(SearchBookActivity.this, view);
            }
        });
        ((ActivitySearchBookBinding) a1()).loadingTipSearchBooks.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.book.activity.SearchBookActivity$initListener$5
            public SearchBookActivity$initListener$5() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                SearchBookActivity.V2(SearchBookActivity.this, false, false, 3, null);
            }
        });
        m1().h().observe(this, new Observer() { // from class: mc.w0
            public /* synthetic */ w0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchBookActivity.x2(Function1.this, obj);
            }
        });
        m1().H().observe(this, new Observer() { // from class: mc.x0
            public /* synthetic */ x0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchBookActivity.y2(Function1.this, obj);
            }
        });
        m1().G().observe(this, new Observer() { // from class: mc.y0
            public /* synthetic */ y0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchBookActivity.z2(Function1.this, obj);
            }
        });
        m1().F().observe(this, new Observer() { // from class: mc.z0
            public /* synthetic */ z0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchBookActivity.A2(Function1.this, obj);
            }
        });
        m1().E().observe(this, new Observer() { // from class: mc.a1
            public /* synthetic */ a1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchBookActivity.B2(Function1.this, obj);
            }
        });
    }

    public static final void w2(SearchBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W2();
    }

    public static final void x2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G2() {
        SearchManager searchManager = (SearchManager) getSystemService(BaseConstants.MARKET_URI_AUTHORITY_SEARCH);
        if (searchManager == null) {
            ((ActivitySearchBookBinding) a1()).searchHistoryView.setVisibility(8);
            return;
        }
        Unit unit = null;
        Cursor f10 = MiConfigSingleton.b2().n2().f(searchManager.getSearchableInfo(new ComponentName(this, (Class<?>) SearchBookActivity.class)), null);
        if (f10 != null) {
            Cursor cursor = f10;
            try {
                Cursor cursor2 = cursor;
                this.suggestion.clear();
                ((ActivitySearchBookBinding) a1()).flSearchSearchHistory.removeAllViews();
                while (cursor2.moveToNext()) {
                    String string = cursor2.getString(Math.max(0, cursor2.getColumnIndex(MiConfigSingleton.b2().n2().b(cursor2))));
                    if (!TextUtils.isEmpty(string)) {
                        this.suggestion.add(string);
                    }
                }
                if (this.suggestion.isEmpty()) {
                    ((ActivitySearchBookBinding) a1()).searchHistoryView.setVisibility(8);
                    CloseableKt.closeFinally(cursor, null);
                    return;
                }
                ((ActivitySearchBookBinding) a1()).searchHistoryView.setVisibility(0);
                if (this.suggestion.size() > 20) {
                    this.suggestion = CollectionsKt.toMutableList((Collection) CollectionsKt.take(this.suggestion, 20));
                }
                ((ActivitySearchBookBinding) a1()).flSearchSearchHistory.setData(this.suggestion);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                unit = unit2;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(cursor, th2);
                    throw th3;
                }
            }
        }
        if (unit == null) {
            ((ActivitySearchBookBinding) a1()).searchHistoryView.setVisibility(8);
        }
    }

    public final void M2(String keyword) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SearchBookActivity$saveQuery$1(keyword, this, null), 3, null);
    }

    public final void N2(String content) {
        ThemeEditText themeEditText;
        SearchCustomViewBinding searchCustomViewBinding;
        ThemeImageView themeImageView;
        SearchCustomViewBinding searchCustomViewBinding2 = this.searchCustomViewBinding;
        if (searchCustomViewBinding2 == null || (themeEditText = searchCustomViewBinding2.scEditText) == null) {
            return;
        }
        themeEditText.removeTextChangedListener(this.textWatcher);
        themeEditText.setText(ExtKt.c(content));
        themeEditText.setSelection(content != null ? content.length() : 0);
        themeEditText.addTextChangedListener(this.textWatcher);
        if (!TextUtils.isEmpty(content) || (searchCustomViewBinding = this.searchCustomViewBinding) == null || (themeImageView = searchCustomViewBinding.btnClearSearchText) == null) {
            return;
        }
        themeImageView.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r14, false, 2, (java.lang.Object) null) != false) goto L163;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void O2(java.lang.String r14, java.util.List<? extends com.martian.mibook.lib.model.data.TYBookItem> r15) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.book.activity.SearchBookActivity.O2(java.lang.String, java.util.List):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P2(TYSearchRecommedInfo searchRecommendInfo) {
        List<TYBookItem> books;
        List<TYSearchTag> tags;
        Unit unit = null;
        if (TextUtils.isEmpty(m1().getRecommendSearchKeyword())) {
            if (!TextUtils.isEmpty(searchRecommendInfo != null ? searchRecommendInfo.getTip() : null)) {
                SearchCustomViewBinding searchCustomViewBinding = this.searchCustomViewBinding;
                ThemeEditText themeEditText = searchCustomViewBinding != null ? searchCustomViewBinding.scEditText : null;
                if (themeEditText != null) {
                    themeEditText.setHint(searchRecommendInfo != null ? searchRecommendInfo.getTip() : null);
                }
            }
            SearchCustomViewBinding searchCustomViewBinding2 = this.searchCustomViewBinding;
            ThemeEditText themeEditText2 = searchCustomViewBinding2 != null ? searchCustomViewBinding2.scEditText : null;
            if (themeEditText2 != null) {
                themeEditText2.setTag(searchRecommendInfo != null ? searchRecommendInfo.getTip() : null);
            }
        }
        if (searchRecommendInfo != null && (tags = searchRecommendInfo.getTags()) != null && (!tags.isEmpty())) {
            List<TYSearchTag> list = tags;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((TYSearchTag) it.next()).getName());
            }
            ((ActivitySearchBookBinding) a1()).hotTagsView.setVisibility(0);
            ((ActivitySearchBookBinding) a1()).flSearchTags.setData(arrayList);
            ((ActivitySearchBookBinding) a1()).flSearchTags.setOnItemTitleClickListener(new FlowLayout.a() { // from class: mc.p0

                /* renamed from: a */
                public final /* synthetic */ List f28597a;

                /* renamed from: b */
                public final /* synthetic */ SearchBookActivity f28598b;

                public /* synthetic */ p0(List tags2, SearchBookActivity this) {
                    tags = tags2;
                    this = this;
                }

                @Override // com.martian.mibook.ui.FlowLayout.a
                public final void a(String str, int i10) {
                    SearchBookActivity.Q2(tags, this, str, i10);
                }
            });
        }
        if (searchRecommendInfo != null && (books = searchRecommendInfo.getBooks()) != null) {
            ((ActivitySearchBookBinding) a1()).searchFindView.setVisibility(0);
            if (this.searchRankItemAdapter == null) {
                this.searchRankItemAdapter = new nc.b(this, books);
                ((ActivitySearchBookBinding) a1()).gvHotBooks.setAdapter((ListAdapter) this.searchRankItemAdapter);
                ((ActivitySearchBookBinding) a1()).gvHotBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: mc.q0
                    public /* synthetic */ q0() {
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                        SearchBookActivity.R2(SearchBookActivity.this, adapterView, view, i10, j10);
                    }
                });
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ((ActivitySearchBookBinding) a1()).searchFindView.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S2(YWCategoryBookList first, SearchBooksResult second) {
        q2();
        if (this.searchBookResultAdapter == null) {
            this.searchBookResultAdapter = new SearchBooksResultAdapter();
            ((ActivitySearchBookBinding) a1()).rvSearchBooks.setAdapter(this.searchBookResultAdapter);
        }
        if (this.pageIndex != 0) {
            List<TYBookItem> bookList = second != null ? second.getBookList() : null;
            if (bookList == null || bookList.isEmpty()) {
                ((ActivitySearchBookBinding) a1()).refreshLayout.a(true);
                return;
            }
            SearchBooksResultAdapter searchBooksResultAdapter = this.searchBookResultAdapter;
            if (searchBooksResultAdapter != null) {
                searchBooksResultAdapter.q(second != null ? second.getBookList() : null);
                return;
            }
            return;
        }
        List<TYBookItem> bookList2 = second != null ? second.getBookList() : null;
        if (bookList2 == null || bookList2.isEmpty()) {
            List<TYBookItem> bookList3 = first != null ? first.getBookList() : null;
            if (bookList3 == null || bookList3.isEmpty()) {
                ((ActivitySearchBookBinding) a1()).refreshLayout.setVisibility(8);
                ((ActivitySearchBookBinding) a1()).refreshLayout.N(false);
                z1(null, ((ActivitySearchBookBinding) a1()).loadingTipSearchBooks);
                return;
            }
        }
        ((ActivitySearchBookBinding) a1()).refreshLayout.setVisibility(0);
        C1(((ActivitySearchBookBinding) a1()).loadingTipSearchBooks);
        ((ActivitySearchBookBinding) a1()).refreshLayout.N(true);
        SearchBooksResultAdapter searchBooksResultAdapter2 = this.searchBookResultAdapter;
        if (searchBooksResultAdapter2 != null) {
            searchBooksResultAdapter2.r(this.simpleSearchKeyword, first != null ? first.getBookList() : null, second != null ? second.getBookList() : null, m1().getSearchCategoryTag(), m1().getSearchCategoryTagFreetype(), m1().getSearchCategory());
        }
    }

    public final void T2(String content) {
        if (TextUtils.isEmpty(content)) {
            m1().A();
            a3(SearchStatus.IDLE);
        } else if (this.searchStatus == SearchStatus.TIPS) {
            m1().Q(ExtKt.d(content));
        }
    }

    public final void U2(boolean isLoadMore, boolean showLoading) {
        ThemeEditText themeEditText;
        ThemeEditText themeEditText2;
        Editable text;
        YWCategoryBookListParams yWCategoryBookListParams = null;
        if (!isLoadMore) {
            SearchCustomViewBinding searchCustomViewBinding = this.searchCustomViewBinding;
            String obj = (searchCustomViewBinding == null || (themeEditText2 = searchCustomViewBinding.scEditText) == null || (text = themeEditText2.getText()) == null) ? null : text.toString();
            this.searchKeyword = obj;
            if (TextUtils.isEmpty(obj)) {
                SearchCustomViewBinding searchCustomViewBinding2 = this.searchCustomViewBinding;
                Object tag = (searchCustomViewBinding2 == null || (themeEditText = searchCustomViewBinding2.scEditText) == null) ? null : themeEditText.getTag();
                this.searchKeyword = tag instanceof String ? (String) tag : null;
            }
            String str = this.searchKeyword;
            if (TextUtils.isEmpty(str != null ? StringsKt.trim((CharSequence) str).toString() : null)) {
                t0.b(this, "请输入搜索关键字");
                return;
            }
            this.simpleSearchKeyword = ExtKt.d(this.searchKeyword);
            N2(this.searchKeyword);
            if (this.isLoading) {
                return;
            }
            String str2 = this.searchKeyword;
            if (str2 != null) {
                M2(str2);
                if (StringsKt.startsWith$default(str2, "http", false, 2, (Object) null) || StringsKt.startsWith$default(str2, "www", false, 2, (Object) null)) {
                    this.isLoading = true;
                    MiWebViewActivity.startWebViewActivity(this, str2);
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SearchBookActivity$startSearchBooks$1$1(this, null), 3, null);
                    return;
                }
            }
            a3(SearchStatus.RESULT);
            this.pageIndex = 0;
            ac.a.O(this, this.searchKeyword);
            SearchCustomViewBinding searchCustomViewBinding3 = this.searchCustomViewBinding;
            i.n(this, searchCustomViewBinding3 != null ? searchCustomViewBinding3.scEditText : null);
        }
        m1().z(this.flexboxWordNumberPosition);
        m1().y(this.flexboxStatusPosition);
        m1().x(this.flexboxChannelPosition, s2().get(this.flexboxChannelPosition));
        if (!isLoadMore) {
            yWCategoryBookListParams = new YWCategoryBookListParams(null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, 16383, null);
            yWCategoryBookListParams.setTags(this.simpleSearchKeyword);
            yWCategoryBookListParams.setPage(0);
            yWCategoryBookListParams.setOrder(Integer.valueOf(this.searchBookOrder));
            yWCategoryBookListParams.setWordCountLower(m1().getSearchBookMinWords());
            yWCategoryBookListParams.setWordCountUpper(m1().getSearchBookMaxWords());
            yWCategoryBookListParams.setStatus(m1().getSearchBookStatus());
            yWCategoryBookListParams.setFreeType(m1().getSearchBookFreeType());
        }
        SearchBooksParams searchBooksParams = new SearchBooksParams(null, 0, 0, 0, 0, null, null, null, null, null, null, 0, 4095, null);
        searchBooksParams.setKeywords(this.simpleSearchKeyword);
        searchBooksParams.setPage(this.pageIndex);
        searchBooksParams.setSearchType(MiBookManager.M);
        searchBooksParams.setOrder(this.searchBookOrder);
        searchBooksParams.setMinWords(m1().getSearchBookMinWords());
        searchBooksParams.setMaxWords(m1().getSearchBookMaxWords());
        searchBooksParams.setStatus(m1().getSearchBookStatus());
        searchBooksParams.setFreeType(m1().getSearchBookFreeType());
        m1().g0(yWCategoryBookListParams, searchBooksParams, isLoadMore, showLoading);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W2() {
        DropDownMenuLayout root;
        LayoutSearchFilterViewBinding layoutSearchFilterViewBinding = this.searchFilterViewBinding;
        if (layoutSearchFilterViewBinding == null) {
            ((ActivitySearchBookBinding) a1()).viewStubFilterView.setLayoutResource(R.layout.layout_search_filter_view);
            LayoutSearchFilterViewBinding bind = LayoutSearchFilterViewBinding.bind(((ActivitySearchBookBinding) a1()).viewStubFilterView.inflate());
            this.searchFilterViewBinding = bind;
            if (bind != null) {
                bind.flexboxWordNumber.setData(u2());
                bind.flexboxStatus.setData(t2());
                bind.flexboxChannel.setData(r2());
                bind.flexboxWordNumber.setOnItemTitleClickListener(new d());
                bind.flexboxStatus.setOnItemTitleClickListener(new e());
                bind.flexboxChannel.setOnItemTitleClickListener(new f());
                bind.tvReset.setOnClickListener(new View.OnClickListener() { // from class: mc.n0

                    /* renamed from: c */
                    public final /* synthetic */ SearchBookActivity f28593c;

                    public /* synthetic */ n0(SearchBookActivity this) {
                        this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchBookActivity.X2(LayoutSearchFilterViewBinding.this, this, view);
                    }
                });
                bind.tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: mc.o0
                    public /* synthetic */ o0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchBookActivity.Y2(SearchBookActivity.this, view);
                    }
                });
            }
        } else if (layoutSearchFilterViewBinding != null) {
            layoutSearchFilterViewBinding.flexboxWordNumber.setSelectPosition(m1().getFlexboxWordNumberPosition());
            layoutSearchFilterViewBinding.flexboxStatus.setSelectPosition(m1().getFlexboxStatusPosition());
            layoutSearchFilterViewBinding.flexboxChannel.setSelectPosition(m1().getFlexboxChannelPosition());
        }
        LayoutSearchFilterViewBinding layoutSearchFilterViewBinding2 = this.searchFilterViewBinding;
        if (layoutSearchFilterViewBinding2 == null || (root = layoutSearchFilterViewBinding2.getRoot()) == null) {
            return;
        }
        root.j(new Function1<Boolean, Unit>() { // from class: com.martian.mibook.mvvm.book.activity.SearchBookActivity$toggleSearchFilterView$3
            public SearchBookActivity$toggleSearchFilterView$3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z10) {
                LinearLayout titleContainer;
                Sequence<View> children;
                f navigator = SearchBookActivity.a2(SearchBookActivity.this).filterOrder.getNavigator();
                CommonNavigator commonNavigator = navigator instanceof CommonNavigator ? (CommonNavigator) navigator : null;
                if (commonNavigator == null || (titleContainer = commonNavigator.getTitleContainer()) == null || (children = ViewGroupKt.getChildren(titleContainer)) == null) {
                    return;
                }
                Iterator<View> it = children.iterator();
                while (it.hasNext()) {
                    it.next().setEnabled(!z10);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void Z2() {
        if (this.searchFilterViewBinding != null) {
            int i10 = (this.flexboxWordNumberPosition > 0 ? 1 : 0) + (this.flexboxStatusPosition > 0 ? 1 : 0) + (this.flexboxChannelPosition <= 0 ? 0 : 1);
            ((ActivitySearchBookBinding) a1()).tvFilterCount.setText(String.valueOf(i10));
            ((ActivitySearchBookBinding) a1()).tvFilterCount.setVisibility(i10 > 0 ? 0 : 8);
            ((ActivitySearchBookBinding) a1()).ivFilter.setVisibility(i10 > 0 ? 8 : 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a3(SearchStatus status) {
        SearchRecommendItemAdapter searchRecommendItemAdapter;
        DropDownMenuLayout root;
        SearchStatus searchStatus = SearchStatus.RESULT;
        if (status == searchStatus) {
            if (this.searchStatus != searchStatus) {
                m9.d dVar = this.filterOrderHelper;
                if (dVar != null) {
                    dVar.i(0);
                }
                m1().X(0);
                m1().W(0);
                m1().V(0);
                this.flexboxWordNumberPosition = 0;
                this.flexboxStatusPosition = 0;
                this.flexboxChannelPosition = 0;
            } else {
                ((ActivitySearchBookBinding) a1()).rvSearchBooks.scrollToPosition(0);
            }
            Z2();
        } else {
            LayoutSearchFilterViewBinding layoutSearchFilterViewBinding = this.searchFilterViewBinding;
            if (layoutSearchFilterViewBinding != null && (root = layoutSearchFilterViewBinding.getRoot()) != null) {
                root.f();
            }
            SearchBooksResultAdapter searchBooksResultAdapter = this.searchBookResultAdapter;
            if (searchBooksResultAdapter != null) {
                searchBooksResultAdapter.clear();
            }
            if (status == SearchStatus.IDLE && (searchRecommendItemAdapter = this.searchRecommendItemAdapter) != null) {
                searchRecommendItemAdapter.clear();
            }
        }
        this.searchStatus = status;
        ((ActivitySearchBookBinding) a1()).nsvContent.setVisibility(this.searchStatus == SearchStatus.IDLE ? 0 : 8);
        ((ActivitySearchBookBinding) a1()).rvSearchRecommendKeywords.setVisibility(this.searchStatus == SearchStatus.TIPS ? 0 : 8);
        ((ActivitySearchBookBinding) a1()).rlSearchBooksView.setVisibility(this.searchStatus != searchStatus ? 8 : 0);
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        v2();
        initView();
        m1().R();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        G2();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void p1() {
        super.p1();
        SearchViewModel m12 = m1();
        Bundle extras = getIntent().getExtras();
        m12.Y(extras != null ? extras.getString(e0.N0) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q2() {
        this.loadMoreFail = false;
        ((ActivitySearchBookBinding) a1()).refreshLayout.S();
        ((ActivitySearchBookBinding) a1()).refreshLayout.n();
    }

    public final List<String> r2() {
        return (List) this.channelList.getValue();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        if (toolbarBinding != null) {
            toolbarBinding.f12243c.setVisibility(0);
            toolbarBinding.f12243c.setText(getString(R.string.cd_search));
            toolbarBinding.f12243c.setTextSize(16.0f);
            toolbarBinding.f12243c.setOnClickListener(new View.OnClickListener() { // from class: mc.b1
                public /* synthetic */ b1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchBookActivity.H2(SearchBookActivity.this, view);
                }
            });
            toolbarBinding.f12246f.setLayoutResource(R.layout.search_custom_view);
            this.searchCustomViewBinding = SearchCustomViewBinding.bind(toolbarBinding.f12246f.inflate());
            toolbarBinding.f12246f.setVisibility(0);
            SearchCustomViewBinding searchCustomViewBinding = this.searchCustomViewBinding;
            if (searchCustomViewBinding != null) {
                searchCustomViewBinding.btnClearSearchText.setOnClickListener(new View.OnClickListener() { // from class: mc.k0
                    public /* synthetic */ k0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchBookActivity.I2(SearchBookActivity.this, view);
                    }
                });
                if (!TextUtils.isEmpty(m1().getRecommendSearchKeyword())) {
                    searchCustomViewBinding.scEditText.setHint(m1().getRecommendSearchKeyword());
                    searchCustomViewBinding.scEditText.setTag(m1().getRecommendSearchKeyword());
                }
                searchCustomViewBinding.scEditText.addTextChangedListener(this.textWatcher);
                searchCustomViewBinding.scEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: mc.l0

                    /* renamed from: c */
                    public final /* synthetic */ SearchCustomViewBinding f28587c;

                    public /* synthetic */ l0(SearchCustomViewBinding searchCustomViewBinding2) {
                        searchCustomViewBinding = searchCustomViewBinding2;
                    }

                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z10) {
                        SearchBookActivity.J2(SearchBookActivity.this, searchCustomViewBinding, view, z10);
                    }
                });
                searchCustomViewBinding2.scEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: mc.m0

                    /* renamed from: b */
                    public final /* synthetic */ SearchCustomViewBinding f28590b;

                    public /* synthetic */ m0(SearchCustomViewBinding searchCustomViewBinding2) {
                        searchCustomViewBinding = searchCustomViewBinding2;
                    }

                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                        boolean K2;
                        K2 = SearchBookActivity.K2(SearchBookActivity.this, searchCustomViewBinding, textView, i10, keyEvent);
                        return K2;
                    }
                });
            }
        }
    }

    public final List<Integer> s2() {
        return (List) this.channelTypeList.getValue();
    }

    public final List<String> t2() {
        return (List) this.statusList.getValue();
    }

    public final List<String> u2() {
        return (List) this.wordNumberList.getValue();
    }
}
