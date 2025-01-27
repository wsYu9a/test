package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.h;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.smartrefresh.SmartRefreshHorizontal;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ReaderItemGridBookBinding;
import com.martian.mibook.databinding.ReadingBookLastPageBinding;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.adapter.ReaderBookFriendsRecommendAdapter;
import com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment;
import com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.mvvm.widget.HorizontalSpaceItemDecoration;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.umeng.analytics.pro.f;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import je.i;
import je.v0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import l9.m0;
import l9.o0;
import l9.t0;
import lc.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001lB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0003¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u001f\u0010 \u001a\u00020\b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0003¢\u0006\u0004\b\"\u0010\nJ\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\nJ\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\nJ\u001f\u0010'\u001a\u00020\b2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001dH\u0003¢\u0006\u0004\b'\u0010!J\u0015\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00105\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u0010:\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00109R\u001d\u0010?\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u0010>R\u001d\u0010D\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u00102\u001a\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u0004\u0018\u00010d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0016\u0010k\u001a\u0004\u0018\u00010h8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Q", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "setRecyclerViewTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "tyBookTopUser", "setBookFriendRecommendData", "(Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;)V", "u0", "getBookScoresAndTopComments", "r0", "s0", "", "score", bq.f10843g, "(I)V", "v0", "x0", "", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comments", "setHotCommentData", "(Ljava/util/List;)V", "w0", "t0", "q0", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "books", "setRecommendBooks", "", "isBookOffline", "setView", "(Z)V", "Lcom/martian/mibook/databinding/ReadingBookLastPageBinding;", "b", "Lcom/martian/mibook/databinding/ReadingBookLastPageBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "c", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "d", "getMCommentViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "mCommentViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", e.TAG, "getAppViewModel", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Landroidx/fragment/app/FragmentActivity;", "f", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "g", "I", "notchHeight", "Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter;", "h", "Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter;", "recommendBooksAdapter", "i", "lastPageRecommendPageIndex", "", "j", "Ljava/lang/String;", "commentString", "Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter;", "k", "Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter;", "readerBookFriendsRecommendAdapter", "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", t.f11204d, "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "bookInfo", "m", "Z", "isSwitchRecommend", "n", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "bookTopUser", "Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;", "o", "Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;", "mReaderCommentAdapter", "Lgd/a;", "getReaderSlidingCallBack", "()Lgd/a;", "readerSlidingCallBack", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "GridBookAdapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderBookLastPageLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final ReadingBookLastPageBinding mViewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Lazy mCommentViewModel;

    /* renamed from: e */
    @k
    public final Lazy appViewModel;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: g, reason: from kotlin metadata */
    public final int notchHeight;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public GridBookAdapter recommendBooksAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    public int lastPageRecommendPageIndex;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public String commentString;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public ReaderBookFriendsRecommendAdapter readerBookFriendsRecommendAdapter;

    /* renamed from: l */
    @l
    public BookInfo bookInfo;

    /* renamed from: m, reason: from kotlin metadata */
    public boolean isSwitchRecommend;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public TYBookTopUser bookTopUser;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public ReaderCommentAdapter mReaderCommentAdapter;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u000267B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u0005J#\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010\"R\"\u0010'\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u00070\u00070#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter$BookViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "newData", "", "q", "(Ljava/util/List;)V", "m", "Landroid/view/ViewGroup;", "parent", "", "viewType", "o", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter$BookViewHolder;", "holder", id.c.f26972i, "n", "(Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter$BookViewHolder;I)V", "getItemCount", "()I", "Landroidx/core/widget/NestedScrollView;", "nestedScrollView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "p", "(Landroidx/core/widget/NestedScrollView;Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "c", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "", "d", "Z", "isInitHandleCurrentVisibleItems", "", "", e.TAG, "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "f", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "g", "BookViewHolder", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public static final class GridBookAdapter extends RecyclerView.Adapter<BookViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

        /* renamed from: g, reason: from kotlin metadata */
        @k
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: h */
        public static int f14889h = 4;

        /* renamed from: i */
        public static int f14890i = 2;

        /* renamed from: d, reason: from kotlin metadata */
        public boolean isInitHandleCurrentVisibleItems;

        /* renamed from: f, reason: from kotlin metadata */
        @l
        public RecyclerViewExposeManager recyclerViewExposeManager;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final AsyncListDiffer<TYBookItem> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<TYBookItem>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$GridBookAdapter$mDiffer$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @SuppressLint({"DiffUtilEquals"})
            /* renamed from: a */
            public boolean areContentsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getBookId(), newItem.getBookId()) && Intrinsics.areEqual(oldItem.getBookName(), oldItem.getBookName());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b */
            public boolean areItemsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });

        /* renamed from: e */
        @k
        public final Set<String> sourceIdSet = new HashSet();

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter$BookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ReaderItemGridBookBinding;", "bookBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/widget/ReaderBookLastPageLayout$GridBookAdapter;Lcom/martian/mibook/databinding/ReaderItemGridBookBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "tyBookItem", "", "c", "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Lcom/martian/mibook/databinding/ReaderItemGridBookBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
        public final class BookViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: b, reason: from kotlin metadata */
            @k
            public final ReaderItemGridBookBinding bookBinding;

            /* renamed from: c */
            public final /* synthetic */ GridBookAdapter f14896c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BookViewHolder(@k GridBookAdapter gridBookAdapter, ReaderItemGridBookBinding bookBinding) {
                super(bookBinding.getRoot());
                Intrinsics.checkNotNullParameter(bookBinding, "bookBinding");
                this.f14896c = gridBookAdapter;
                this.bookBinding = bookBinding;
            }

            public static final void d(Context context, TYBookItem tyBookItem, View view) {
                Intrinsics.checkNotNullParameter(tyBookItem, "$tyBookItem");
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null) {
                    ac.a.y(context, "书尾页-推荐-阅读");
                    i.H(activity, tyBookItem);
                }
            }

            public static final void e(Context context, TYBookItem tyBookItem, View view) {
                Intrinsics.checkNotNullParameter(tyBookItem, "$tyBookItem");
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null) {
                    ac.a.y(context, "书尾页-推荐-阅读");
                    i.H(activity, tyBookItem);
                }
            }

            @SuppressLint({"SetTextI18n"})
            public final void c(@k TYBookItem tyBookItem) {
                Intrinsics.checkNotNullParameter(tyBookItem, "tyBookItem");
                Context context = this.bookBinding.getRoot().getContext();
                MiBookManager.u1(context, tyBookItem, this.bookBinding.bookCover);
                this.bookBinding.bsGridBookName.setText(ExtKt.c(tyBookItem.getTitle()));
                if (tyBookItem.getScore() > 0) {
                    this.bookBinding.bsGridBookCategory.setVisibility(8);
                    this.bookBinding.bsBookScore.setVisibility(0);
                    TextView textView = this.bookBinding.bsBookScore;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(tyBookItem.getScore() / 10.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    textView.setText(format + "分");
                } else {
                    if (ba.l.q(tyBookItem.getRecTitle())) {
                        this.bookBinding.bsGridBookCategory.setVisibility(8);
                    } else {
                        this.bookBinding.bsGridBookCategory.setVisibility(0);
                        this.bookBinding.bsGridBookCategory.setText(ExtKt.c(tyBookItem.getRecTitle()));
                    }
                    this.bookBinding.bsBookScore.setVisibility(8);
                }
                this.bookBinding.bookCover.setOnClickListener(new View.OnClickListener() { // from class: hd.c1

                    /* renamed from: b */
                    public final /* synthetic */ Context f26561b;

                    /* renamed from: c */
                    public final /* synthetic */ TYBookItem f26562c;

                    public /* synthetic */ c1(Context context2, TYBookItem tyBookItem2) {
                        context = context2;
                        tyBookItem = tyBookItem2;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReaderBookLastPageLayout.GridBookAdapter.BookViewHolder.d(context, tyBookItem, view);
                    }
                });
                this.bookBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: hd.d1

                    /* renamed from: b */
                    public final /* synthetic */ Context f26567b;

                    /* renamed from: c */
                    public final /* synthetic */ TYBookItem f26568c;

                    public /* synthetic */ d1(Context context2, TYBookItem tyBookItem2) {
                        context = context2;
                        tyBookItem = tyBookItem2;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReaderBookLastPageLayout.GridBookAdapter.BookViewHolder.e(context, tyBookItem, view);
                    }
                });
            }
        }

        /* renamed from: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$GridBookAdapter$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return GridBookAdapter.f14889h;
            }

            public final int b() {
                return GridBookAdapter.f14890i;
            }

            public final void c(int i10) {
                GridBookAdapter.f14889h = i10;
            }

            public final void d(int i10) {
                GridBookAdapter.f14890i = i10;
            }

            public Companion() {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return this.mDiffer.getCurrentList().size();
        }

        public final void m() {
            if (this.isInitHandleCurrentVisibleItems) {
                return;
            }
            RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
            if (recyclerViewExposeManager != null) {
                RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
            }
            this.isInitHandleCurrentVisibleItems = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n */
        public void onBindViewHolder(@k BookViewHolder holder, int r32) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            TYBookItem tYBookItem = this.mDiffer.getCurrentList().get(r32);
            Intrinsics.checkNotNull(tYBookItem);
            holder.c(tYBookItem);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @k
        /* renamed from: o */
        public BookViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ReaderItemGridBookBinding inflate = ReaderItemGridBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new BookViewHolder(this, inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(@k RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onDetachedFromRecyclerView(recyclerView);
            RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
            if (recyclerViewExposeManager != null) {
                recyclerViewExposeManager.removeRecyclerItemExposeListener();
            }
        }

        @Override // com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.OnItemExposeListener
        public void onItemViewVisible(int r92, @l RecyclerView recyclerView) {
            TYBookItem tYBookItem;
            if (this.mDiffer.getCurrentList().isEmpty() || getPageSize() <= r92 || (tYBookItem = this.mDiffer.getCurrentList().get(r92)) == null) {
                return;
            }
            Set<String> set = this.sourceIdSet;
            String sourceId = tYBookItem.getSourceId();
            Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
            if (set.add(sourceId)) {
                if (r92 == 0) {
                    Context context = recyclerView != null ? recyclerView.getContext() : null;
                    ac.a.K(context, tYBookItem.getRecommend() + tYBookItem.getSource(), "展示");
                }
                MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
            }
        }

        public final void p(@l NestedScrollView nestedScrollView, @k RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (this.recyclerViewExposeManager == null) {
                this.recyclerViewExposeManager = new RecyclerViewExposeManager();
            }
            RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
            if (recyclerViewExposeManager != null) {
                recyclerViewExposeManager.setRecyclerItemExposeListener(nestedScrollView, recyclerView, this);
            }
        }

        public final void q(@l List<? extends TYBookItem> newData) {
            List<TYBookItem> emptyList;
            AsyncListDiffer<TYBookItem> asyncListDiffer = this.mDiffer;
            if (newData == null || (emptyList = CollectionsKt.take(newData, f14889h * f14890i)) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            asyncListDiffer.submitList(emptyList);
            RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
            if (recyclerViewExposeManager != null) {
                RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
            }
        }
    }

    public static final class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(@l View view, @l MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 0) {
                return false;
            }
            if (ReaderBookLastPageLayout.this.mViewBinding.switchButtonUpdateNotify.isChecked()) {
                h.b(ReaderBookLastPageLayout.this.getActivity());
                return true;
            }
            v0.U0(ReaderBookLastPageLayout.this.getActivity());
            return true;
        }
    }

    public static final class b implements View.OnTouchListener {

        /* renamed from: b */
        public float f14898b;

        /* renamed from: c */
        public float f14899c;

        /* renamed from: d */
        public final int f14900d = 20;

        /* renamed from: e */
        public boolean f14901e = true;

        public b() {
        }

        public final float a() {
            return this.f14898b;
        }

        public final float b() {
            return this.f14899c;
        }

        public final int c() {
            return this.f14900d;
        }

        public final boolean d() {
            return this.f14901e;
        }

        public final void e(float f10) {
            this.f14898b = f10;
        }

        public final void f(float f10) {
            this.f14899c = f10;
        }

        public final void g(boolean z10) {
            this.f14901e = z10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@l View view, @l MotionEvent motionEvent) {
            float y10 = motionEvent != null ? motionEvent.getY() : 0.0f;
            float x10 = motionEvent != null ? motionEvent.getX() : 0.0f;
            Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                this.f14899c = y10;
                this.f14898b = x10;
            } else if (valueOf != null && valueOf.intValue() == 2) {
                float f10 = y10 - this.f14899c;
                float f11 = x10 - this.f14898b;
                if ((Math.abs(f10) > this.f14900d || Math.abs(f11) > this.f14900d) && this.f14901e) {
                    gd.a readerSlidingCallBack = ReaderBookLastPageLayout.this.getReaderSlidingCallBack();
                    if (readerSlidingCallBack != null) {
                        readerSlidingCallBack.h0(false);
                    }
                    this.f14901e = false;
                }
            } else if (valueOf != null && valueOf.intValue() == 1 && Math.abs(y10 - this.f14899c) < 5.0f && Math.abs(x10 - this.f14898b) < 5.0f) {
                gd.a readerSlidingCallBack2 = ReaderBookLastPageLayout.this.getReaderSlidingCallBack();
                if (readerSlidingCallBack2 != null) {
                    readerSlidingCallBack2.n0();
                }
                this.f14901e = true;
            }
            return false;
        }
    }

    public static final class c implements ReaderPostBookCommentFragment.e {
        public c() {
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void a(@k CommentReply comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void b(@k Comment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            ac.a.L(ReaderBookLastPageLayout.this.getContext(), "写评论-最后一页-成功");
            ReaderBookLastPageLayout.this.commentString = null;
            ReaderBookLastPageLayout.this.getBookScoresAndTopComments();
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            ReaderBookLastPageLayout.this.commentString = comment;
        }
    }

    public static final class d implements ReaderBookFriendsRecommendAdapter.a {
        public d() {
        }

        @Override // com.martian.mibook.mvvm.read.adapter.ReaderBookFriendsRecommendAdapter.a
        public void a(@l TYBookItem tYBookItem, @k TextView tvAddBookShelf) {
            Intrinsics.checkNotNullParameter(tvAddBookShelf, "tvAddBookShelf");
            Context context = ReaderBookLastPageLayout.this.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            ReaderBookLastPageLayout readerBookLastPageLayout = ReaderBookLastPageLayout.this;
            ac.a.y(readerBookLastPageLayout.getContext(), "书尾页-加书架");
            MiConfigSingleton.b2().M1().g(activity, tYBookItem);
            if (tYBookItem != null) {
                tYBookItem.setInBookStore(true);
            }
            tvAddBookShelf.setVisibility(8);
            t0.b(readerBookLastPageLayout.getContext(), "已加入书架");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderBookLastPageLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void R(ReaderBookLastPageLayout this$0, pf.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.v();
        }
    }

    public static final void S(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a readerSlidingCallBack = this$0.getReaderSlidingCallBack();
        if (readerSlidingCallBack != null) {
            readerSlidingCallBack.S();
        }
    }

    public static final void T(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.y(this$0.getContext(), "书尾页-推荐-换一换");
        if (this$0.mViewBinding.tvSwitchMoreProgressbar.getVisibility() != 0) {
            this$0.mViewBinding.tvSwitchMoreProgressbar.setVisibility(0);
            this$0.mViewBinding.tvSwitchMoreLoan.setVisibility(8);
            ReadingViewModel mViewModel = this$0.getMViewModel();
            if (mViewModel != null) {
                mViewModel.J2(0L);
            }
            this$0.q0();
        }
    }

    public static final void U(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.y(this$0.getActivity(), "书尾页-查看全部");
        ReadingViewModel mViewModel = this$0.getMViewModel();
        String sourceName = mViewModel != null ? mViewModel.getSourceName() : null;
        ReadingViewModel mViewModel2 = this$0.getMViewModel();
        kc.b.v(sourceName, mViewModel2 != null ? mViewModel2.getSourceId() : null);
    }

    public static final void V(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.y(this$0.getActivity(), "书尾页-换一换");
        ProgressBar progressBar = this$0.mViewBinding.tvBookFriendSwitchMoreProgressbar;
        if (progressBar == null || progressBar.getVisibility() != 0) {
            ProgressBar progressBar2 = this$0.mViewBinding.tvBookFriendSwitchMoreProgressbar;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
            ReaderThemeImageView readerThemeImageView = this$0.mViewBinding.tvBookFriendSwitchMoreLoan;
            if (readerThemeImageView != null) {
                readerThemeImageView.setVisibility(8);
            }
            this$0.isSwitchRecommend = true;
            ReadingViewModel mViewModel = this$0.getMViewModel();
            if (mViewModel != null) {
                mViewModel.f0(false, true);
            }
        }
    }

    public static final void W(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.d();
        }
    }

    public static final void X(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t0();
    }

    public static final void Y(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t0();
    }

    public static final void Z(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t0();
    }

    public static final void a0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t0();
    }

    public static final void b0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    private final AppViewModel getAppViewModel() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public final void getBookScoresAndTopComments() {
        ReaderCommentViewModel mCommentViewModel = getMCommentViewModel();
        if (mCommentViewModel != null) {
            ReadingViewModel mViewModel = getMViewModel();
            String sourceName = mViewModel != null ? mViewModel.getSourceName() : null;
            ReadingViewModel mViewModel2 = getMViewModel();
            mCommentViewModel.r(sourceName, mViewModel2 != null ? mViewModel2.getSourceId() : null);
        }
    }

    public final ReaderCommentViewModel getMCommentViewModel() {
        return (ReaderCommentViewModel) this.mCommentViewModel.getValue();
    }

    public final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final com.martian.mibook.mvvm.read.widget.a getReadMenuCallBack() {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) activity;
        }
        return null;
    }

    public final gd.a getReaderSlidingCallBack() {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof gd.a) {
            return (gd.a) activity;
        }
        return null;
    }

    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void i0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a readerSlidingCallBack = this$0.getReaderSlidingCallBack();
        if (readerSlidingCallBack != null) {
            readerSlidingCallBack.r0();
        }
    }

    public static final void j0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0(20);
    }

    public static final void k0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0(40);
    }

    public static final void l0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0(60);
    }

    public static final void m0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0(80);
    }

    public static final void n0(ReaderBookLastPageLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0(100);
    }

    public static final void o0(ReaderBookLastPageLayout this$0, View view) {
        BookInfo mBookInfo;
        BookInfo mBookInfo2;
        Integer nComments;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReaderCommentViewModel mCommentViewModel = this$0.getMCommentViewModel();
        int intValue = (mCommentViewModel == null || (mBookInfo2 = mCommentViewModel.getMBookInfo()) == null || (nComments = mBookInfo2.getNComments()) == null) ? 0 : nComments.intValue();
        ReaderCommentViewModel mCommentViewModel2 = this$0.getMCommentViewModel();
        if (((mCommentViewModel2 == null || (mBookInfo = mCommentViewModel2.getMBookInfo()) == null) ? null : mBookInfo.getMyComment()) != null || intValue > 0) {
            this$0.u0();
        } else {
            ac.a.L(this$0.getContext(), "写评论-最后一页");
            this$0.p0(100);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void setBookFriendRecommendData(TYBookTopUser tyBookTopUser) {
        Integer duration;
        List<TYBookItem> readBooks;
        ProgressBar progressBar = this.mViewBinding.tvBookFriendSwitchMoreProgressbar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ReaderThemeImageView readerThemeImageView = this.mViewBinding.tvBookFriendSwitchMoreLoan;
        int i10 = 0;
        if (readerThemeImageView != null) {
            readerThemeImageView.setVisibility(0);
        }
        ac.a.y(getContext(), "书尾页-展示");
        this.bookTopUser = tyBookTopUser;
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.q3(null);
        }
        TYBookTopUser tYBookTopUser = this.bookTopUser;
        if (tYBookTopUser == null || !(tYBookTopUser == null || (readBooks = tYBookTopUser.getReadBooks()) == null || !readBooks.isEmpty())) {
            ReaderThemeLinearLayout readerThemeLinearLayout = this.mViewBinding.bookFriendRecommendView;
            if (readerThemeLinearLayout == null) {
                return;
            }
            readerThemeLinearLayout.setVisibility(8);
            return;
        }
        ReaderThemeLinearLayout readerThemeLinearLayout2 = this.mViewBinding.bookFriendRecommendView;
        if (readerThemeLinearLayout2 != null) {
            readerThemeLinearLayout2.setVisibility(0);
        }
        Context context = getContext();
        TYBookTopUser tYBookTopUser2 = this.bookTopUser;
        m0.l(context, tYBookTopUser2 != null ? tYBookTopUser2.getHeader() : null, this.mViewBinding.ivBookFriendAvatar, R.drawable.day_img_heads);
        ReaderThemeTextView readerThemeTextView = this.mViewBinding.tvBookFriendDes;
        if (readerThemeTextView != null) {
            TYBookTopUser tYBookTopUser3 = this.bookTopUser;
            String nickname = tYBookTopUser3 != null ? tYBookTopUser3.getNickname() : null;
            TYBookTopUser tYBookTopUser4 = this.bookTopUser;
            if (tYBookTopUser4 != null && (duration = tYBookTopUser4.getDuration()) != null) {
                i10 = duration.intValue();
            }
            readerThemeTextView.setText(ExtKt.c(nickname + "·阅读本书" + oe.f.a(i10) + "·TA还看了"));
        }
        if (this.readerBookFriendsRecommendAdapter == null) {
            ReaderBookFriendsRecommendAdapter readerBookFriendsRecommendAdapter = new ReaderBookFriendsRecommendAdapter();
            this.readerBookFriendsRecommendAdapter = readerBookFriendsRecommendAdapter;
            RecyclerView recyclerView = this.mViewBinding.rvBookFriendGridBooks;
            if (recyclerView != null) {
                recyclerView.setAdapter(readerBookFriendsRecommendAdapter);
            }
            ReaderBookFriendsRecommendAdapter readerBookFriendsRecommendAdapter2 = this.readerBookFriendsRecommendAdapter;
            if (readerBookFriendsRecommendAdapter2 != null) {
                readerBookFriendsRecommendAdapter2.n(new d());
            }
        }
        ReaderBookFriendsRecommendAdapter readerBookFriendsRecommendAdapter3 = this.readerBookFriendsRecommendAdapter;
        if (readerBookFriendsRecommendAdapter3 != null) {
            TYBookTopUser tYBookTopUser5 = this.bookTopUser;
            readerBookFriendsRecommendAdapter3.o(tYBookTopUser5 != null ? tYBookTopUser5.getReadBooks() : null);
        }
    }

    private final void setHotCommentData(List<Comment> comments) {
        RecyclerView recyclerView;
        if (!MiConfigSingleton.b2().p3()) {
            ReaderThemeLinearLayout readerThemeLinearLayout = this.mViewBinding.llHotCommentListView;
            if (readerThemeLinearLayout == null) {
                return;
            }
            readerThemeLinearLayout.setVisibility(8);
            return;
        }
        List<Comment> list = comments;
        if (list == null || list.isEmpty()) {
            ReaderThemeLinearLayout readerThemeLinearLayout2 = this.mViewBinding.llHotCommentListView;
            if (readerThemeLinearLayout2 != null) {
                readerThemeLinearLayout2.setVisibility(8);
            }
            LinearLayout linearLayout = this.mViewBinding.llMoreComment;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.mViewBinding.rlCommentEmpty;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            RecyclerView recyclerView2 = this.mViewBinding.rvHotComment;
            if (recyclerView2 == null) {
                return;
            }
            recyclerView2.setVisibility(8);
            return;
        }
        ReaderThemeLinearLayout readerThemeLinearLayout3 = this.mViewBinding.llHotCommentListView;
        if (readerThemeLinearLayout3 != null) {
            readerThemeLinearLayout3.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.mViewBinding.llMoreComment;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = this.mViewBinding.rlCommentEmpty;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        RecyclerView recyclerView3 = this.mViewBinding.rvHotComment;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(0);
        }
        ReaderCommentAdapter readerCommentAdapter = this.mReaderCommentAdapter;
        if (readerCommentAdapter != null) {
            if (readerCommentAdapter != null) {
                readerCommentAdapter.I(comments);
                return;
            }
            return;
        }
        RecyclerView recyclerView4 = this.mViewBinding.rvHotComment;
        if ((recyclerView4 != null ? recyclerView4.getLayoutManager() : null) == null && (recyclerView = this.mViewBinding.rvHotComment) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        ReaderCommentAdapter readerCommentAdapter2 = new ReaderCommentAdapter(getMCommentViewModel(), ReaderCommentViewModel.CommentType.TYPE_BOOK_DETAIL_HOT_COMMENT);
        this.mReaderCommentAdapter = readerCommentAdapter2;
        RecyclerView recyclerView5 = this.mViewBinding.rvHotComment;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(readerCommentAdapter2);
        }
        ReaderCommentAdapter readerCommentAdapter3 = this.mReaderCommentAdapter;
        if (readerCommentAdapter3 != null) {
            readerCommentAdapter3.n(comments);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void setRecommendBooks(List<? extends TYBookItem> books) {
        this.mViewBinding.tvSwitchMoreProgressbar.setVisibility(8);
        this.mViewBinding.tvSwitchMoreLoan.setVisibility(0);
        if (books == null) {
            this.mViewBinding.recommendView.setVisibility(8);
            return;
        }
        this.mViewBinding.recommendView.setVisibility(0);
        if (this.recommendBooksAdapter == null) {
            GridBookAdapter gridBookAdapter = new GridBookAdapter();
            this.recommendBooksAdapter = gridBookAdapter;
            this.mViewBinding.rvGridBooks.setAdapter(gridBookAdapter);
            GridBookAdapter gridBookAdapter2 = this.recommendBooksAdapter;
            if (gridBookAdapter2 != null) {
                ReadingBookLastPageBinding readingBookLastPageBinding = this.mViewBinding;
                NestedScrollView nestedScrollView = readingBookLastPageBinding.nestedScrollview;
                RecyclerView rvGridBooks = readingBookLastPageBinding.rvGridBooks;
                Intrinsics.checkNotNullExpressionValue(rvGridBooks, "rvGridBooks");
                gridBookAdapter2.p(nestedScrollView, rvGridBooks);
            }
        }
        ac.a.y(getContext(), "书尾页-推荐-展示");
        GridBookAdapter gridBookAdapter3 = this.recommendBooksAdapter;
        if (gridBookAdapter3 != null) {
            gridBookAdapter3.q(books);
        }
    }

    private final void setRecyclerViewTouchEvent(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
        if (recyclerView != null) {
            recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$setRecyclerViewTouchEvent$1

                /* renamed from: a, reason: from kotlin metadata */
                public float lastX;

                /* renamed from: b, reason: from kotlin metadata */
                public float lastY;

                /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
                
                    if (r2 != 3) goto L43;
                 */
                @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onInterceptTouchEvent(@xi.k androidx.recyclerview.widget.RecyclerView r6, @xi.k android.view.MotionEvent r7) {
                    /*
                        r5 = this;
                        java.lang.String r0 = "rv"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        java.lang.String r0 = "e"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                        int r0 = r7.getActionIndex()
                        r1 = 0
                        if (r0 < 0) goto L72
                        int r2 = r7.getPointerCount()
                        if (r0 < r2) goto L18
                        goto L72
                    L18:
                        int r2 = r7.getActionMasked()
                        r3 = 1
                        if (r2 == 0) goto L5f
                        if (r2 == r3) goto L52
                        r4 = 2
                        if (r2 == r4) goto L28
                        r7 = 3
                        if (r2 == r7) goto L52
                        goto L72
                    L28:
                        float r2 = r7.getX(r0)
                        float r4 = r5.lastX
                        float r2 = r2 - r4
                        float r7 = r7.getY(r0)
                        float r0 = r5.lastY
                        float r7 = r7 - r0
                        float r0 = java.lang.Math.abs(r2)
                        float r7 = java.lang.Math.abs(r7)
                        int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                        if (r7 >= 0) goto L4a
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r1)
                        goto L72
                    L4a:
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r3)
                        goto L72
                    L52:
                        r7 = 0
                        r5.lastX = r7
                        r5.lastY = r7
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r1)
                        goto L72
                    L5f:
                        float r2 = r7.getX(r0)
                        r5.lastX = r2
                        float r7 = r7.getY(r0)
                        r5.lastY = r7
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r3)
                    L72:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$setRecyclerViewTouchEvent$1.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
                }
            });
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void Q() {
        MutableLiveData<TYBookTopUser> O0;
        MutableLiveData<Pair<String, Integer>> g02;
        MutableLiveData<Pair<Integer, Object>> f02;
        MutableLiveData<BookInfo> B;
        MutableLiveData<Unit> Z0;
        MutableLiveData<List<TYBookItem>> P0;
        this.mViewBinding.getRoot().setNestedScrollView(this.mViewBinding.nestedScrollview);
        this.mViewBinding.getRoot().f0(new sf.e() { // from class: hd.e0
            public /* synthetic */ e0() {
            }

            @Override // sf.e
            public final void p(pf.f fVar) {
                ReaderBookLastPageLayout.R(ReaderBookLastPageLayout.this, fVar);
            }
        });
        this.mViewBinding.nestedScrollview.setOnTouchListener(new b());
        this.mViewBinding.readingEndClose.setOnClickListener(new View.OnClickListener() { // from class: hd.g0
            public /* synthetic */ g0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.b0(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.endGoBookMallView.setOnClickListener(new View.OnClickListener() { // from class: hd.l0
            public /* synthetic */ l0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.i0(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.ivMyCommentVote1.setOnClickListener(new View.OnClickListener() { // from class: hd.m0
            public /* synthetic */ m0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.j0(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.ivMyCommentVote2.setOnClickListener(new View.OnClickListener() { // from class: hd.n0
            public /* synthetic */ n0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.k0(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.ivMyCommentVote3.setOnClickListener(new View.OnClickListener() { // from class: hd.o0
            public /* synthetic */ o0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.l0(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.ivMyCommentVote4.setOnClickListener(new View.OnClickListener() { // from class: hd.q0
            public /* synthetic */ q0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.m0(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.ivMyCommentVote5.setOnClickListener(new View.OnClickListener() { // from class: hd.r0
            public /* synthetic */ r0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.n0(ReaderBookLastPageLayout.this, view);
            }
        });
        ReaderThemeLinearLayout readerThemeLinearLayout = this.mViewBinding.endCommentView;
        if (readerThemeLinearLayout != null) {
            readerThemeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: hd.s0
                public /* synthetic */ s0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookLastPageLayout.o0(ReaderBookLastPageLayout.this, view);
                }
            });
        }
        this.mViewBinding.endGoBookShelfView.setOnClickListener(new View.OnClickListener() { // from class: hd.t0
            public /* synthetic */ t0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.S(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.rlSwitchMore.setOnClickListener(new View.OnClickListener() { // from class: hd.p0
            public /* synthetic */ p0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.T(ReaderBookLastPageLayout.this, view);
            }
        });
        ReaderThemeLinearLayout readerThemeLinearLayout2 = this.mViewBinding.bookFriendRecommendView;
        if (readerThemeLinearLayout2 != null) {
            readerThemeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: hd.u0
                public /* synthetic */ u0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookLastPageLayout.U(ReaderBookLastPageLayout.this, view);
                }
            });
        }
        setRecyclerViewTouchEvent(this.mViewBinding.rvBookFriendGridBooks);
        RelativeLayout relativeLayout = this.mViewBinding.bookFriendSwitchMore;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: hd.v0
                public /* synthetic */ v0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookLastPageLayout.V(ReaderBookLastPageLayout.this, view);
                }
            });
        }
        this.mViewBinding.switchButtonUpdateNotify.setOnTouchListener(new a());
        ReaderThemeLinearLayout readerThemeLinearLayout3 = this.mViewBinding.bookwormRecommendView;
        if (readerThemeLinearLayout3 != null) {
            readerThemeLinearLayout3.setOnClickListener(new View.OnClickListener() { // from class: hd.w0
                public /* synthetic */ w0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookLastPageLayout.W(ReaderBookLastPageLayout.this, view);
                }
            });
        }
        ReaderThemeLinearLayout readerThemeLinearLayout4 = this.mViewBinding.llWholeBookComment;
        if (readerThemeLinearLayout4 != null) {
            readerThemeLinearLayout4.setOnClickListener(new View.OnClickListener() { // from class: hd.x0
                public /* synthetic */ x0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookLastPageLayout.X(ReaderBookLastPageLayout.this, view);
                }
            });
        }
        ReaderThemeLinearLayout readerThemeLinearLayout5 = this.mViewBinding.llHotCommentListView;
        if (readerThemeLinearLayout5 != null) {
            readerThemeLinearLayout5.setOnClickListener(new View.OnClickListener() { // from class: hd.y0
                public /* synthetic */ y0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookLastPageLayout.Y(ReaderBookLastPageLayout.this, view);
                }
            });
        }
        this.mViewBinding.bookCommentNumber.setOnClickListener(new View.OnClickListener() { // from class: hd.z0
            public /* synthetic */ z0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.Z(ReaderBookLastPageLayout.this, view);
            }
        });
        this.mViewBinding.bookVoteScore2.setOnClickListener(new View.OnClickListener() { // from class: hd.a1
            public /* synthetic */ a1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookLastPageLayout.a0(ReaderBookLastPageLayout.this, view);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ReadingViewModel mViewModel = getMViewModel();
            if (mViewModel != null && (P0 = mViewModel.P0()) != null) {
                P0.observe(activity, new Observer() { // from class: hd.b1
                    public /* synthetic */ b1() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookLastPageLayout.c0(Function1.this, obj);
                    }
                });
            }
            ReadingViewModel mViewModel2 = getMViewModel();
            if (mViewModel2 != null && (Z0 = mViewModel2.Z0()) != null) {
                Z0.observe(activity, new Observer() { // from class: hd.f0
                    public /* synthetic */ f0() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookLastPageLayout.d0(Function1.this, obj);
                    }
                });
            }
            ReaderCommentViewModel mCommentViewModel = getMCommentViewModel();
            if (mCommentViewModel != null && (B = mCommentViewModel.B()) != null) {
                B.observe(activity, new Observer() { // from class: hd.h0
                    public /* synthetic */ h0() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookLastPageLayout.e0(Function1.this, obj);
                    }
                });
            }
            AppViewModel appViewModel = getAppViewModel();
            if (appViewModel != null && (f02 = appViewModel.f0()) != null) {
                f02.observe(activity, new Observer() { // from class: hd.i0
                    public /* synthetic */ i0() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookLastPageLayout.f0(Function1.this, obj);
                    }
                });
            }
            AppViewModel appViewModel2 = getAppViewModel();
            if (appViewModel2 != null && (g02 = appViewModel2.g0()) != null) {
                g02.observe(activity, new Observer() { // from class: hd.j0
                    public /* synthetic */ j0() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookLastPageLayout.g0(Function1.this, obj);
                    }
                });
            }
            ReadingViewModel mViewModel3 = getMViewModel();
            if (mViewModel3 == null || (O0 = mViewModel3.O0()) == null) {
                return;
            }
            O0.observe(activity, new Observer() { // from class: hd.k0
                public /* synthetic */ k0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReaderBookLastPageLayout.h0(Function1.this, obj);
                }
            });
        }
    }

    public final void p0(int i10) {
        FragmentActivity activity = getActivity();
        ReadingViewModel mViewModel = getMViewModel();
        ReaderPostBookCommentFragment.q0(activity, mViewModel != null ? mViewModel.w3() : null, i10, this.commentString, new c());
    }

    public final void q0() {
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.A0(this.lastPageRecommendPageIndex, 8);
        }
    }

    public final void r0() {
        RelativeLayout relativeLayout = this.mViewBinding.rlEndComment;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        this.mViewBinding.bookCommentView.setVisibility(8);
        this.mViewBinding.readingEndDesc.setVisibility(8);
        this.mViewBinding.switchButtonUpdateNotify.setVisibility(8);
        this.mViewBinding.readingEndBg.setImageResource(com.martian.mibook.R.drawable.bg_read_end_completion);
        this.mViewBinding.readingEndTitle.setVisibility(0);
        this.mViewBinding.readingEndTitle.setText(getContext().getString(com.martian.mibook.R.string.book_offline));
    }

    public final void s0() {
        String string;
        Book book;
        Book book2;
        ReadingViewModel mViewModel;
        ReadingViewModel mViewModel2;
        Book book3;
        BookInfo mBookInfo;
        ReadingViewModel mViewModel3 = getMViewModel();
        String str = null;
        if (mViewModel3 == null || !mViewModel3.getShowBookComment()) {
            RelativeLayout relativeLayout = this.mViewBinding.rlEndComment;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            this.mViewBinding.bookCommentView.setVisibility(8);
        } else {
            ReaderCommentViewModel mCommentViewModel = getMCommentViewModel();
            if (((mCommentViewModel == null || (mBookInfo = mCommentViewModel.getMBookInfo()) == null) ? null : mBookInfo.getNStars()) == null) {
                this.mViewBinding.bookCommentView.setVisibility(8);
                RelativeLayout relativeLayout2 = this.mViewBinding.rlEndComment;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
                if (this.bookInfo == null) {
                    getBookScoresAndTopComments();
                }
            } else {
                RelativeLayout relativeLayout3 = this.mViewBinding.rlEndComment;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(0);
                }
                this.mViewBinding.bookCommentView.setVisibility(0);
                v0();
                w0();
            }
        }
        this.mViewBinding.readingEndTitle.setVisibility(0);
        ReadingViewModel mViewModel4 = getMViewModel();
        if ((mViewModel4 != null ? mViewModel4.getBook() : null) == null || (((mViewModel = getMViewModel()) == null || (book3 = mViewModel.getBook()) == null || !book3.isSerialEnd()) && ((mViewModel2 = getMViewModel()) == null || !mViewModel2.T1()))) {
            this.mViewBinding.readingEndDesc.setVisibility(0);
            ReadingViewModel mViewModel5 = getMViewModel();
            Date lastUpdated = (mViewModel5 == null || (book2 = mViewModel5.getBook()) == null) ? null : book2.getLastUpdated();
            this.mViewBinding.readingEndTitle.setText(getContext().getString(com.martian.mibook.R.string.reading_update));
            this.mViewBinding.readingEndBg.setImageResource(com.martian.mibook.R.drawable.bg_read_end_wait_update);
            ReaderThemeTextView readerThemeTextView = this.mViewBinding.readingEndDesc;
            if (lastUpdated == null || !o0.J(lastUpdated)) {
                string = getContext().getString(com.martian.mibook.R.string.reading_update_desc);
            } else {
                ReadingViewModel mViewModel6 = getMViewModel();
                if (mViewModel6 != null && (book = mViewModel6.getBook()) != null) {
                    str = book.getUpdateDateString();
                }
                string = "最新章节更新于 " + str;
            }
            readerThemeTextView.setText(string);
        } else {
            this.mViewBinding.readingEndTitle.setText(getContext().getString(com.martian.mibook.R.string.reading_finish));
            this.mViewBinding.readingEndBg.setImageResource(com.martian.mibook.R.drawable.bg_read_end_completion);
            this.mViewBinding.readingEndDesc.setVisibility(8);
        }
        if (h.e(getContext())) {
            this.mViewBinding.switchButtonUpdateNotify.setVisibility(8);
            this.mViewBinding.switchButtonUpdateNotify.setChecked(true);
        } else {
            this.mViewBinding.switchButtonUpdateNotify.setVisibility(0);
            this.mViewBinding.switchButtonUpdateNotify.setChecked(false);
        }
    }

    public final void setView(boolean isBookOffline) {
        GridBookAdapter gridBookAdapter;
        ReadingViewModel mViewModel;
        ReadingViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 != null && mViewModel2.getIsScrollMode()) {
            this.mViewBinding.readingEndClose.setVisibility(8);
        }
        if (isBookOffline) {
            r0();
        } else {
            s0();
        }
        if (this.readerBookFriendsRecommendAdapter == null) {
            ReadingViewModel mViewModel3 = getMViewModel();
            if ((mViewModel3 != null ? mViewModel3.getTyBookTopUser() : null) == null && (mViewModel = getMViewModel()) != null) {
                ReadingViewModel.g0(mViewModel, false, false, 2, null);
            }
        }
        if (this.recommendBooksAdapter == null) {
            ReadingViewModel mViewModel4 = getMViewModel();
            if ((mViewModel4 != null ? mViewModel4.C0() : null) == null) {
                q0();
            }
        }
        ReadingViewModel mViewModel5 = getMViewModel();
        if (mViewModel5 == null || !mViewModel5.S1() || (gridBookAdapter = this.recommendBooksAdapter) == null) {
            return;
        }
        if (gridBookAdapter != null) {
            gridBookAdapter.m();
        }
        ReaderBookFriendsRecommendAdapter readerBookFriendsRecommendAdapter = this.readerBookFriendsRecommendAdapter;
        if (readerBookFriendsRecommendAdapter != null) {
            readerBookFriendsRecommendAdapter.k();
        }
    }

    public final void t0() {
        ac.a.L(getContext(), "书尾页-查看评论");
        ReadingViewModel mViewModel = getMViewModel();
        BookInfo w32 = mViewModel != null ? mViewModel.w3() : null;
        if (w32 != null) {
            RelativeLayout relativeLayout = this.mViewBinding.rlCommentEmpty;
            boolean z10 = false;
            if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                z10 = true;
            }
            w32.setPostComment(Boolean.valueOf(z10));
        }
        ReaderCommentFragment.INSTANCE.b(getActivity(), w32);
    }

    public final void u0() {
        ac.a.L(getContext(), "查看评论");
        ReaderCommentFragment.Companion companion = ReaderCommentFragment.INSTANCE;
        FragmentActivity activity = getActivity();
        ReadingViewModel mViewModel = getMViewModel();
        companion.b(activity, mViewModel != null ? mViewModel.w3() : null);
    }

    @SuppressLint({"SetTextI18n"})
    public final void v0() {
        String str;
        BookInfo mBookInfo;
        BookInfo mBookInfo2;
        BookInfo mBookInfo3;
        Integer nStars;
        BookInfo mBookInfo4;
        Float score;
        int i10 = 0;
        ReaderCommentViewModel mCommentViewModel = getMCommentViewModel();
        float floatValue = (mCommentViewModel == null || (mBookInfo4 = mCommentViewModel.getMBookInfo()) == null || (score = mBookInfo4.getScore()) == null) ? 0.0f : score.floatValue();
        if (floatValue > 0.0f) {
            this.mViewBinding.bookVoteScore1.setVisibility(8);
            this.mViewBinding.bookVoteScore2.setVisibility(0);
            ReaderThemeTextView readerThemeTextView = this.mViewBinding.bookVoteScore2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(floatValue / 10.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            readerThemeTextView.setText(format);
            this.mViewBinding.bookVoteScoreHint.setVisibility(0);
        } else {
            this.mViewBinding.bookVoteScore1.setVisibility(0);
            this.mViewBinding.bookVoteScore2.setVisibility(8);
            this.mViewBinding.bookVoteScoreHint.setVisibility(8);
        }
        ReaderCommentViewModel mCommentViewModel2 = getMCommentViewModel();
        int intValue = (mCommentViewModel2 == null || (mBookInfo3 = mCommentViewModel2.getMBookInfo()) == null || (nStars = mBookInfo3.getNStars()) == null) ? 0 : nStars.intValue();
        ReaderThemeTextView readerThemeTextView2 = this.mViewBinding.bookCommentNumber;
        if (intValue > 0) {
            str = intValue + "人评价";
        } else {
            str = "快来评分吧";
        }
        readerThemeTextView2.setText(str);
        ReaderThemeImageView readerThemeImageView = this.mViewBinding.ivAllComment;
        if (readerThemeImageView != null) {
            readerThemeImageView.setVisibility(intValue > 0 ? 0 : 8);
        }
        ReaderCommentViewModel mCommentViewModel3 = getMCommentViewModel();
        List<Comment> list = null;
        Comment myComment = (mCommentViewModel3 == null || (mBookInfo2 = mCommentViewModel3.getMBookInfo()) == null) ? null : mBookInfo2.getMyComment();
        if (myComment != null) {
            i10 = myComment.getScore();
            this.mViewBinding.bookCommentStatus.setText(getContext().getString(com.martian.mibook.R.string.mine) + getContext().getString(com.martian.mibook.R.string.grade));
        } else {
            this.mViewBinding.bookCommentStatus.setText(getContext().getString(com.martian.mibook.R.string.touch_to_comment));
        }
        x0(i10);
        ReaderCommentViewModel mCommentViewModel4 = getMCommentViewModel();
        if (mCommentViewModel4 != null && (mBookInfo = mCommentViewModel4.getMBookInfo()) != null) {
            list = mBookInfo.getHotCommentList();
        }
        setHotCommentData(list);
    }

    @SuppressLint({"SetTextI18n"})
    public final void w0() {
        String str;
        BookInfo mBookInfo;
        Integer nComments;
        ReaderCommentViewModel mCommentViewModel = getMCommentViewModel();
        int intValue = (mCommentViewModel == null || (mBookInfo = mCommentViewModel.getMBookInfo()) == null || (nComments = mBookInfo.getNComments()) == null) ? 0 : nComments.intValue();
        if (intValue > 0) {
            ReaderThemeTextView readerThemeTextView = this.mViewBinding.tvMoreComment;
            if (readerThemeTextView != null) {
                Context context = getContext();
                readerThemeTextView.setText(intValue + "条" + (context != null ? context.getString(com.martian.mibook.R.string.reader_comment) : null));
            }
        } else {
            ReaderThemeTextView readerThemeTextView2 = this.mViewBinding.tvMoreComment;
            if (readerThemeTextView2 != null) {
                Context context2 = getContext();
                readerThemeTextView2.setText(context2 != null ? context2.getString(com.martian.mibook.R.string.whole_book_comment) : null);
            }
        }
        if (intValue <= 0) {
            ReaderThemeImageView readerThemeImageView = this.mViewBinding.readingEndCommentIcon;
            if (readerThemeImageView != null) {
                readerThemeImageView.setImageResource(com.martian.mibook.R.drawable.reader_end_write_comment);
            }
            ReaderThemeTextView readerThemeTextView3 = this.mViewBinding.readingEndCommentNumber;
            if (readerThemeTextView3 != null) {
                readerThemeTextView3.setVisibility(8);
            }
            ReaderThemeTextView readerThemeTextView4 = this.mViewBinding.readingEndCommentDesc;
            if (readerThemeTextView4 == null) {
                return;
            }
            readerThemeTextView4.setText(getContext().getString(com.martian.mibook.R.string.reader_comment_empty_desc));
            return;
        }
        ReaderThemeImageView readerThemeImageView2 = this.mViewBinding.readingEndCommentIcon;
        if (readerThemeImageView2 != null) {
            readerThemeImageView2.setImageResource(com.martian.mibook.R.drawable.read_icon_book_comment_num);
        }
        ReaderThemeTextView readerThemeTextView5 = this.mViewBinding.readingEndCommentNumber;
        if (readerThemeTextView5 != null) {
            readerThemeTextView5.setVisibility(0);
        }
        ReaderThemeTextView readerThemeTextView6 = this.mViewBinding.readingEndCommentNumber;
        if (readerThemeTextView6 != null) {
            if (intValue < 10000) {
                str = String.valueOf(intValue);
            } else {
                str = (intValue / 10000) + "万+";
            }
            readerThemeTextView6.setText(str);
        }
        ReaderThemeTextView readerThemeTextView7 = this.mViewBinding.readingEndCommentDesc;
        if (readerThemeTextView7 == null) {
            return;
        }
        readerThemeTextView7.setText(getContext().getString(com.martian.mibook.R.string.all_comments));
    }

    public final void x0(int score) {
        this.mViewBinding.ivMyCommentVote1.setImageResource(score < 20 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        this.mViewBinding.ivMyCommentVote2.setImageResource(score < 40 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        this.mViewBinding.ivMyCommentVote3.setImageResource(score < 60 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        this.mViewBinding.ivMyCommentVote4.setImageResource(score < 80 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        this.mViewBinding.ivMyCommentVote5.setImageResource(score < 100 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderBookLastPageLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        ReaderCommentViewModel mCommentViewModel;
        Intrinsics.checkNotNullParameter(context, "context");
        ReadingBookLastPageBinding inflate = ReadingBookLastPageBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$mViewModel$2
            public ReaderBookLastPageLayout$mViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                FragmentActivity activity = ReaderBookLastPageLayout.this.getActivity();
                if (activity != null) {
                    return (ReadingViewModel) new ViewModelProvider(activity).get(ReadingViewModel.class);
                }
                return null;
            }
        });
        this.mCommentViewModel = LazyKt.lazy(new Function0<ReaderCommentViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$mCommentViewModel$2
            public ReaderBookLastPageLayout$mCommentViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReaderCommentViewModel invoke() {
                FragmentActivity activity = ReaderBookLastPageLayout.this.getActivity();
                if (activity != null) {
                    return (ReaderCommentViewModel) new ViewModelProvider(activity).get(ReaderCommentViewModel.class);
                }
                return null;
            }
        });
        this.appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$appViewModel$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReaderBookLastPageLayout$appViewModel$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final AppViewModel invoke() {
                return b.a(context);
            }
        });
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReaderBookLastPageLayout$activity$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final FragmentActivity invoke() {
                Context context2 = context;
                if (context2 instanceof FragmentActivity) {
                    return (FragmentActivity) context2;
                }
                return null;
            }
        });
        gd.a readerSlidingCallBack = getReaderSlidingCallBack();
        boolean z10 = false;
        int l02 = readerSlidingCallBack != null ? readerSlidingCallBack.l0() : 0;
        this.notchHeight = l02;
        this.commentString = "";
        if (ReadingInstance.z().O(context2)) {
            ViewGroup.LayoutParams layoutParams = inflate.lastPageContent.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = l02;
            }
        }
        if (inflate.rvGridBooks.getLayoutManager() == null) {
            inflate.rvGridBooks.setLayoutManager(new GridLayoutManager(context2, GridBookAdapter.INSTANCE.a()));
        }
        ReaderCommentViewModel mCommentViewModel2 = getMCommentViewModel();
        if ((mCommentViewModel2 != null ? mCommentViewModel2.getMBookInfo() : null) == null && (mCommentViewModel = getMCommentViewModel()) != null) {
            ReadingViewModel mViewModel = getMViewModel();
            mCommentViewModel.J(mViewModel != null ? mViewModel.w3() : null);
        }
        RecyclerView recyclerView = inflate.rvBookFriendGridBooks;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context2, 0, false));
        }
        int i10 = ConfigSingleton.i(12.0f);
        RecyclerView recyclerView2 = inflate.rvBookFriendGridBooks;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new HorizontalSpaceItemDecoration(i10));
        }
        SmartRefreshHorizontal root = inflate.getRoot();
        ReadingViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 != null && mViewModel2.getIsScrollMode()) {
            z10 = true;
        }
        root.N(!z10);
        Q();
    }

    public /* synthetic */ ReaderBookLastPageLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
