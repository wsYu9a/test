package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import ba.m;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.m.e;
import com.martian.free.response.TFBook;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.FoldedTextView;
import com.martian.libmars.widget.smartrefresh.SmartRefreshHorizontal;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.databinding.ItemBookCoverHotCommentBinding;
import com.martian.mibook.databinding.ReadingBookCoverLayoutBinding;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.mvvm.book.activity.BookDetailActivity;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.dialog.ReadingBookIntroductionDialogFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReaderBookCoverLayout;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import l9.m0;
import lc.b;
import sf.g;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0003¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u0011\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J'\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010\nR\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010-\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\u001d\u00107\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\u001cR\u0014\u0010;\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010\u001cR\u0016\u0010?\u001a\u0004\u0018\u00010<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010C\u001a\u0004\u0018\u00010@8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderBookCoverLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "s", "()V", bt.aO, "F", "H", "", "", "tagList", "setCategoryView", "(Ljava/util/List;)V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comments", "setHotCommentsData", "Landroid/view/ViewGroup;", "parentView", "", ExifInterface.LONGITUDE_EAST, "(Ljava/util/List;Landroid/view/ViewGroup;)I", TTDownloadField.TT_TAG, "I", "(Ljava/lang/String;)V", "getFreeType", "()I", "getReaderBookInfo", "b", "Ljava/lang/String;", "introduction", "Lcom/martian/mibook/databinding/ReadingBookCoverLayoutBinding;", "c", "Lcom/martian/mibook/databinding/ReadingBookCoverLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "d", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", e.TAG, "getAppViewModel", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Landroidx/fragment/app/FragmentActivity;", "f", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "g", "notchHeight", "h", "verticalMargin", "Lgd/a;", "getReaderSlidingCallBack", "()Lgd/a;", "readerSlidingCallBack", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReaderBookCoverLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReaderBookCoverLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReaderBookCoverLayout\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,435:1\n1855#2,2:436\n*S KotlinDebug\n*F\n+ 1 ReaderBookCoverLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReaderBookCoverLayout\n*L\n348#1:436,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReaderBookCoverLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public String introduction;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final ReadingBookCoverLayoutBinding mViewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: e */
    @k
    public final Lazy appViewModel;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: g, reason: from kotlin metadata */
    public final int notchHeight;

    /* renamed from: h, reason: from kotlin metadata */
    public final int verticalMargin;

    public static final class a implements FoldedTextView.c {
        public a() {
        }

        @Override // com.martian.libmars.widget.FoldedTextView.c
        public void onClick() {
            FragmentActivity activity = ReaderBookCoverLayout.this.getActivity();
            if (activity != null) {
                ReadingBookIntroductionDialogFragment.INSTANCE.a(activity, ReaderBookCoverLayout.this.introduction);
            }
        }
    }

    public static final class b implements FlexboxTagLayout.a {
        public b() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            ReaderBookCoverLayout.this.I(title);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderBookCoverLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void A(ReaderBookCoverLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a readerSlidingCallBack = this$0.getReaderSlidingCallBack();
        if (readerSlidingCallBack != null) {
            readerSlidingCallBack.B();
        }
    }

    public static final void B(ReaderBookCoverLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a readerSlidingCallBack = this$0.getReaderSlidingCallBack();
        if (readerSlidingCallBack != null) {
            readerSlidingCallBack.n0();
        }
    }

    public static final void C(ReaderBookCoverLayout this$0, View view) {
        ReadingInfo readingInfo;
        Integer freeType;
        Book book;
        ReadingInfo readingInfo2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadingViewModel mViewModel = this$0.getMViewModel();
        if (mViewModel == null || (readingInfo = mViewModel.getReadingInfo()) == null || (freeType = readingInfo.getFreeType()) == null) {
            return;
        }
        int intValue = freeType.intValue();
        ReadingViewModel mViewModel2 = this$0.getMViewModel();
        String str = null;
        Integer brtype = (mViewModel2 == null || (readingInfo2 = mViewModel2.getReadingInfo()) == null) ? null : readingInfo2.getBrtype();
        ReadingViewModel mViewModel3 = this$0.getMViewModel();
        if (mViewModel3 != null && (book = mViewModel3.getBook()) != null) {
            str = book.getCategory();
        }
        kc.b.i(intValue, brtype, str, "阅读页-");
    }

    public static final void D(ReaderBookCoverLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.w("封面页");
        }
        this$0.mViewBinding.addShelfGuideView.setVisibility(8);
    }

    public static final void G(ReaderBookCoverLayout this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout llHotCommentList = this$0.mViewBinding.llHotCommentList;
        Intrinsics.checkNotNullExpressionValue(llHotCommentList, "llHotCommentList");
        this$0.E(list, llHotCommentList);
    }

    public final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    private final AppViewModel getAppViewModel() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    private final int getFreeType() {
        Book book;
        ReadingViewModel mViewModel = getMViewModel();
        Book book2 = mViewModel != null ? mViewModel.getBook() : null;
        if (book2 instanceof YWBook) {
            ReadingViewModel mViewModel2 = getMViewModel();
            book = mViewModel2 != null ? mViewModel2.getBook() : null;
            Intrinsics.checkNotNull(book, "null cannot be cast to non-null type com.martian.mibook.lib.yuewen.response.YWBook");
            return ((YWBook) book).getFreeType();
        }
        if (!(book2 instanceof TFBook)) {
            return MiConfigSingleton.b2().p();
        }
        try {
            ReadingViewModel mViewModel3 = getMViewModel();
            book = mViewModel3 != null ? mViewModel3.getBook() : null;
            Intrinsics.checkNotNull(book, "null cannot be cast to non-null type com.martian.free.response.TFBook");
            String freeType = ((TFBook) book).getFreeType();
            Intrinsics.checkNotNullExpressionValue(freeType, "getFreeType(...)");
            return Integer.parseInt(freeType);
        } catch (Exception unused) {
            return MiConfigSingleton.b2().p();
        }
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

    private final void getReaderBookInfo() {
        ReadingInfo readingInfo;
        ReadingViewModel mViewModel = getMViewModel();
        if (((mViewModel == null || (readingInfo = mViewModel.getReadingInfo()) == null) ? null : readingInfo.getTagList()) != null) {
            H();
            return;
        }
        ReadingViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 != null) {
            mViewModel2.o1();
        }
    }

    private final gd.a getReaderSlidingCallBack() {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof gd.a) {
            return (gd.a) activity;
        }
        return null;
    }

    private final void setCategoryView(List<String> tagList) {
        List<String> list = tagList;
        if (list == null || list.isEmpty()) {
            this.mViewBinding.flexboxCategory.setVisibility(8);
            return;
        }
        if (this.mViewBinding.flexboxCategory.getChildCount() == 0) {
            this.mViewBinding.flexboxCategory.O();
            this.mViewBinding.flexboxCategory.setData(tagList);
            this.mViewBinding.flexboxCategory.setVisibility(0);
        }
        this.mViewBinding.horizontalScrollview.smoothScrollTo(0, 0);
        this.mViewBinding.flexboxCategory.setOnItemTitleClickListener(new b());
    }

    private final void setHotCommentsData(List<Comment> comments) {
        if (m.h(getActivity()) <= ConfigSingleton.i(640.0f)) {
            comments = null;
        }
        List<Comment> list = comments;
        this.mViewBinding.hotCommentsView.setVisibility((list == null || list.isEmpty()) ? 4 : 0);
        ReadingBookCoverLayoutBinding readingBookCoverLayoutBinding = this.mViewBinding;
        readingBookCoverLayoutBinding.foldTextviewIntroduction.E(readingBookCoverLayoutBinding.hotCommentsView.getVisibility() == 0 ? 2 : 6).q();
        this.mViewBinding.llHotCommentList.postDelayed(new Runnable() { // from class: hd.t

            /* renamed from: c */
            public final /* synthetic */ List f26649c;

            public /* synthetic */ t(List comments2) {
                comments = comments2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReaderBookCoverLayout.G(ReaderBookCoverLayout.this, comments);
            }
        }, 300L);
    }

    public static final void u(ReaderBookCoverLayout this$0, pf.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.v();
        }
    }

    public static final void v(ReaderBookCoverLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a readerSlidingCallBack = this$0.getReaderSlidingCallBack();
        if (readerSlidingCallBack != null) {
            readerSlidingCallBack.N();
        }
    }

    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    public final int E(List<Comment> list, ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0 && list != null && (!list.isEmpty())) {
            viewGroup.removeAllViews();
        }
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (list == null) {
            return height;
        }
        int i10 = height;
        for (Comment comment : list) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_book_cover_hot_comment, viewGroup, false);
            ItemBookCoverHotCommentBinding bind = ItemBookCoverHotCommentBinding.bind(inflate);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            m0.l(getActivity(), comment.getHeader(), bind.hotCommentHeader, com.martian.mibook.lib.account.R.drawable.day_img_heads);
            bind.hotCommentContent.setText(ExtKt.c(comment.getContent()));
            int score = comment.getScore();
            bind.hotCommentStar1.setAlpha(0.8f);
            bind.hotCommentStar2.setAlpha(score > 20 ? 0.8f : 0.3f);
            bind.hotCommentStar3.setAlpha(score > 40 ? 0.8f : 0.3f);
            bind.hotCommentStar4.setAlpha(score > 60 ? 0.8f : 0.3f);
            bind.hotCommentStar5.setAlpha(score <= 80 ? 0.3f : 0.8f);
            if (comment.getReadDuration() > 0) {
                bind.hotCommentNickname.setText(ExtKt.c("阅读" + oe.f.j(comment.getReadDuration()) + "点评"));
            } else {
                bind.hotCommentNickname.setText(ExtKt.c(comment.getNickname()));
            }
            inflate.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            int i11 = ConfigSingleton.i(viewGroup.getChildCount() > 0 ? 20.0f : 12.0f);
            int measuredHeight = inflate.getMeasuredHeight() + i11;
            if (i10 < measuredHeight) {
                return i10;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = i11;
            viewGroup.addView(inflate, marginLayoutParams);
            i10 -= measuredHeight;
        }
        return i10;
    }

    public final void F() {
        boolean H0 = MiConfigSingleton.b2().H0();
        this.mViewBinding.bgBookCover.setAlpha(H0 ? 0.3f : 0.5f);
        this.mViewBinding.openBookCoverShadow.setAlpha(H0 ? 0.01f : 0.03f);
    }

    @SuppressLint({"SetTextI18n"})
    public final void H() {
        ReadingInfo readingInfo;
        ReadingInfo readingInfo2;
        ReadingInfo readingInfo3;
        Book book;
        Book book2;
        ReadingInfo readingInfo4;
        Integer allWords;
        ReadingInfo readingInfo5;
        ReadingInfo readingInfo6;
        Integer nComments;
        ReadingInfo readingInfo7;
        Integer score;
        Integer brtype;
        Integer rank;
        Book book3;
        setVisibility(0);
        FragmentActivity activity = getActivity();
        ReadingViewModel mViewModel = getMViewModel();
        List<Comment> list = null;
        MiBookManager.u1(activity, mViewModel != null ? mViewModel.getBook() : null, this.mViewBinding.bookCover);
        ReaderThemeTextView readerThemeTextView = this.mViewBinding.openBookName;
        ReadingViewModel mViewModel2 = getMViewModel();
        readerThemeTextView.setText(ExtKt.c(mViewModel2 != null ? mViewModel2.e0() : null));
        ReaderThemeTextView readerThemeTextView2 = this.mViewBinding.openBookAuthor;
        ReadingViewModel mViewModel3 = getMViewModel();
        readerThemeTextView2.setText(ExtKt.c((mViewModel3 == null || (book3 = mViewModel3.getBook()) == null) ? null : book3.getReadingInfo()));
        ReadingViewModel mViewModel4 = getMViewModel();
        ReadingInfo readingInfo8 = mViewModel4 != null ? mViewModel4.getReadingInfo() : null;
        int intValue = (readingInfo8 == null || (rank = readingInfo8.getRank()) == null) ? 0 : rank.intValue();
        String categoryName = readingInfo8 != null ? readingInfo8.getCategoryName() : null;
        int intValue2 = (readingInfo8 == null || (brtype = readingInfo8.getBrtype()) == null) ? 0 : brtype.intValue();
        if (intValue <= 0 || TextUtils.isEmpty(categoryName)) {
            this.mViewBinding.bookRankView.setVisibility(8);
        } else {
            String N1 = MiConfigSingleton.b2().N1(getActivity(), intValue2);
            this.mViewBinding.bookRankView.setVisibility(0);
            this.mViewBinding.tvRankName.setText(categoryName + N1 + "榜");
            this.mViewBinding.tvRanking.setText(ExtKt.c(" 第" + intValue + "名"));
        }
        ViewGroup.LayoutParams layoutParams = this.mViewBinding.rlCover.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mViewBinding.bookRankView.getVisibility() == 8 ? ConfigSingleton.i(48.0f) : ConfigSingleton.i(20.0f);
        if (!ReadingInstance.z().O(getContext())) {
            this.mViewBinding.bottomLayout.setVisibility(8);
            ReaderThemeLinearLayout readerThemeLinearLayout = this.mViewBinding.coverHeaderView;
            readerThemeLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            readerThemeLinearLayout.setGravity(17);
            this.mViewBinding.headerLayout.setVisibility(0);
            return;
        }
        this.mViewBinding.bottomLayout.setVisibility(0);
        this.mViewBinding.headerLayout.setVisibility(0);
        int max = (int) Math.max(this.notchHeight, this.verticalMargin);
        ReaderThemeLinearLayout readerThemeLinearLayout2 = this.mViewBinding.coverHeaderView;
        readerThemeLinearLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        readerThemeLinearLayout2.setGravity(81);
        readerThemeLinearLayout2.setPadding(readerThemeLinearLayout2.getPaddingLeft(), max, readerThemeLinearLayout2.getPaddingRight(), ConfigSingleton.i(16.0f));
        this.mViewBinding.slideGuideView.setVisibility(MiConfigSingleton.b2().Y() == 1 ? 0 : 8);
        ReadingViewModel mViewModel5 = getMViewModel();
        if (mViewModel5 != null && !mViewModel5.R1() && this.mViewBinding.slideGuideView.getVisibility() != 0) {
            this.mViewBinding.addShelfGuideView.setVisibility(0);
        }
        Context context = getContext();
        ReadingViewModel mViewModel6 = getMViewModel();
        MiBookManager.s1(context, mViewModel6 != null ? mViewModel6.getBook() : null, this.mViewBinding.openBookCoverShadow);
        ReadingViewModel mViewModel7 = getMViewModel();
        int intValue3 = (mViewModel7 == null || (readingInfo7 = mViewModel7.getReadingInfo()) == null || (score = readingInfo7.getScore()) == null) ? 0 : score.intValue();
        if (intValue3 > 0) {
            ReaderThemeTextView readerThemeTextView3 = this.mViewBinding.openBookScore;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.CHINA, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(intValue3 / 10.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            readerThemeTextView3.setText(format);
            this.mViewBinding.openBookScoreUnit.setVisibility(0);
        } else {
            this.mViewBinding.openBookScore.setText("--");
            this.mViewBinding.openBookScoreUnit.setVisibility(4);
        }
        ReadingViewModel mViewModel8 = getMViewModel();
        int intValue4 = (mViewModel8 == null || (readingInfo6 = mViewModel8.getReadingInfo()) == null || (nComments = readingInfo6.getNComments()) == null) ? 0 : nComments.intValue();
        this.mViewBinding.tvMoreComment.setText(intValue4 + "条" + getContext().getString(R.string.reader_comment));
        ReadingViewModel mViewModel9 = getMViewModel();
        Integer readingCount = (mViewModel9 == null || (readingInfo5 = mViewModel9.getReadingInfo()) == null) ? null : readingInfo5.getReadingCount();
        if (readingCount != null) {
            ReadingBookCoverLayoutBinding readingBookCoverLayoutBinding = this.mViewBinding;
            ReaderThemeTextView readerThemeTextView4 = readingBookCoverLayoutBinding.openBookClickCount;
            BookDetailActivity.Companion companion = BookDetailActivity.INSTANCE;
            ReaderThemeTextView openBookClickCountUnit = readingBookCoverLayoutBinding.openBookClickCountUnit;
            Intrinsics.checkNotNullExpressionValue(openBookClickCountUnit, "openBookClickCountUnit");
            readerThemeTextView4.setText(companion.a(readingCount, openBookClickCountUnit, "人"));
            this.mViewBinding.openBookClickCountUnit.setVisibility(0);
        } else {
            this.mViewBinding.openBookClickCount.setText("--");
            this.mViewBinding.openBookClickCountUnit.setVisibility(4);
        }
        ReadingViewModel mViewModel10 = getMViewModel();
        int intValue5 = (mViewModel10 == null || (readingInfo4 = mViewModel10.getReadingInfo()) == null || (allWords = readingInfo4.getAllWords()) == null) ? 0 : allWords.intValue();
        if (intValue5 > 0) {
            this.mViewBinding.openBookReadingCountView.setVisibility(0);
            ReaderThemeTextView readerThemeTextView5 = this.mViewBinding.openBookAuthor;
            ReadingViewModel mViewModel11 = getMViewModel();
            readerThemeTextView5.setText(ExtKt.c(((mViewModel11 == null || (book2 = mViewModel11.getBook()) == null) ? null : book2.getAuthor()) + "·著"));
            if (intValue5 >= 10000) {
                this.mViewBinding.openBookReadingCount.setText(String.valueOf(intValue5 / 10000));
                this.mViewBinding.openBookReadingCountUnit.setVisibility(0);
            } else {
                this.mViewBinding.openBookReadingCount.setText(String.valueOf(intValue5));
                this.mViewBinding.openBookReadingCountUnit.setVisibility(8);
            }
            ReaderThemeTextView readerThemeTextView6 = this.mViewBinding.openBookReadingCountHint;
            ReadingViewModel mViewModel12 = getMViewModel();
            readerThemeTextView6.setText(ExtKt.c((mViewModel12 == null || (book = mViewModel12.getBook()) == null) ? null : book.getStatus()));
        } else {
            this.mViewBinding.openBookReadingCountView.setVisibility(4);
        }
        ReadingViewModel mViewModel13 = getMViewModel();
        String z10 = ba.l.z((mViewModel13 == null || (readingInfo3 = mViewModel13.getReadingInfo()) == null) ? null : readingInfo3.getIntro());
        String c10 = z10 != null ? ExtKt.c(z10) : null;
        this.introduction = c10;
        this.mViewBinding.foldTextviewIntroduction.setText(c10);
        ReadingViewModel mViewModel14 = getMViewModel();
        setCategoryView((mViewModel14 == null || (readingInfo2 = mViewModel14.getReadingInfo()) == null) ? null : readingInfo2.getTagList());
        if (!MiConfigSingleton.b2().p3()) {
            setHotCommentsData(null);
            return;
        }
        ReadingViewModel mViewModel15 = getMViewModel();
        if (mViewModel15 != null && (readingInfo = mViewModel15.getReadingInfo()) != null) {
            list = readingInfo.getHotComments();
        }
        setHotCommentsData(list);
    }

    public final void I(String r32) {
        i.b0(getFreeType(), r32, 7);
    }

    public final void s() {
        getReaderBookInfo();
    }

    public final void t() {
        MutableLiveData<Unit> h02;
        MutableLiveData<Unit> Z0;
        MutableLiveData<ReadingInfo> H0;
        MutableLiveData<ReadingInfo> Y0;
        this.mViewBinding.getRoot().E(new g() { // from class: hd.v
            public /* synthetic */ v() {
            }

            @Override // sf.g
            public final void b(pf.f fVar) {
                ReaderBookCoverLayout.u(ReaderBookCoverLayout.this, fVar);
            }
        });
        this.mViewBinding.bookCover.setOnClickListener(new View.OnClickListener() { // from class: hd.w
            public /* synthetic */ w() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookCoverLayout.v(ReaderBookCoverLayout.this, view);
            }
        });
        this.mViewBinding.tvMoreComment.setOnClickListener(new View.OnClickListener() { // from class: hd.x
            public /* synthetic */ x() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookCoverLayout.A(ReaderBookCoverLayout.this, view);
            }
        });
        this.mViewBinding.foldTextviewIntroduction.setOnExpandBtnClickListener(new a());
        this.mViewBinding.foldTextviewIntroduction.setOnClickListener(new View.OnClickListener() { // from class: hd.y
            public /* synthetic */ y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookCoverLayout.B(ReaderBookCoverLayout.this, view);
            }
        });
        this.mViewBinding.bookRankView.setOnClickListener(new View.OnClickListener() { // from class: hd.z
            public /* synthetic */ z() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookCoverLayout.C(ReaderBookCoverLayout.this, view);
            }
        });
        this.mViewBinding.addShelfGuideView.setOnClickListener(new View.OnClickListener() { // from class: hd.a0
            public /* synthetic */ a0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderBookCoverLayout.D(ReaderBookCoverLayout.this, view);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ReadingViewModel mViewModel = getMViewModel();
            if (mViewModel != null && (Y0 = mViewModel.Y0()) != null) {
                Y0.observe(activity, new Observer() { // from class: hd.b0
                    public /* synthetic */ b0() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookCoverLayout.x(Function1.this, obj);
                    }
                });
            }
            ReadingViewModel mViewModel2 = getMViewModel();
            if (mViewModel2 != null && (H0 = mViewModel2.H0()) != null) {
                H0.observe(activity, new Observer() { // from class: hd.c0
                    public /* synthetic */ c0() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookCoverLayout.y(Function1.this, obj);
                    }
                });
            }
            ReadingViewModel mViewModel3 = getMViewModel();
            if (mViewModel3 != null && (Z0 = mViewModel3.Z0()) != null) {
                Z0.observe(activity, new Observer() { // from class: hd.d0
                    public /* synthetic */ d0() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReaderBookCoverLayout.z(Function1.this, obj);
                    }
                });
            }
            AppViewModel appViewModel = getAppViewModel();
            if (appViewModel == null || (h02 = appViewModel.h0()) == null) {
                return;
            }
            h02.observe(activity, new Observer() { // from class: hd.u
                public /* synthetic */ u() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReaderBookCoverLayout.w(Function1.this, obj);
                }
            });
        }
    }

    public /* synthetic */ ReaderBookCoverLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderBookCoverLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ReadingBookCoverLayoutBinding inflate = ReadingBookCoverLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookCoverLayout$mViewModel$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReaderBookCoverLayout$mViewModel$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                Object obj = context;
                if (obj instanceof FragmentActivity) {
                    return (ReadingViewModel) new ViewModelProvider((ViewModelStoreOwner) obj).get(ReadingViewModel.class);
                }
                return null;
            }
        });
        this.appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookCoverLayout$appViewModel$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReaderBookCoverLayout$appViewModel$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final AppViewModel invoke() {
                return b.a(context);
            }
        });
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderBookCoverLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReaderBookCoverLayout$activity$2(Context context2) {
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
        int l02 = (readerSlidingCallBack != null ? readerSlidingCallBack.l0() : 0) + ConfigSingleton.i(12.0f);
        this.notchHeight = l02;
        int i10 = ConfigSingleton.i(24.0f);
        this.verticalMargin = i10;
        if (ReadingInstance.z().O(context2)) {
            inflate.bgBookCover.setPadding(0, Math.max(0, l02 - i10), 0, 0);
        }
        SmartRefreshHorizontal root = inflate.getRoot();
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null && mViewModel.getIsScrollMode()) {
            z10 = true;
        }
        root.j0(!z10);
        F();
        t();
        s();
    }
}
