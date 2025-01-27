package com.martian.mibook.mvvm.book.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.free.response.TFBook;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.AuthorBooksActivity;
import com.martian.mibook.application.EventManager;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityBookDetailBinding;
import com.martian.mibook.fragment.dialog.CommentFragment;
import com.martian.mibook.fragment.dialog.PostBookCommentFragment;
import com.martian.mibook.lib.account.response.TYChapterContent;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.original.data.ORBook;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.book.activity.BookDetailActivity;
import com.martian.mibook.mvvm.book.fragment.BookChapterListFragment;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.book.viewmodel.BookViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.read.adapter.CommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.yuewen.adapter.GridBookAdapter;
import com.martian.mibook.ui.FlexboxTagLayout;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import je.i;
import je.v0;
import kc.a;
import kc.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import l9.t0;
import xi.k;
import xi.l;

@Route(path = a.f27755k)
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 y2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001zB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0019\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0003¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020\u00062\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0014H\u0002¢\u0006\u0004\b*\u0010\u0018J\u0019\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0003¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\u0006H\u0003¢\u0006\u0004\b1\u0010\u0005J\u001f\u00104\u001a\u00020\u00062\u000e\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u0014H\u0002¢\u0006\u0004\b4\u0010\u0018J)\u00108\u001a\u00020\u00062\u0006\u00105\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u0001022\u0006\u00107\u001a\u00020$H\u0003¢\u0006\u0004\b8\u00109J/\u0010@\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020$H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010\u0005J\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\u0005J\u000f\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bF\u0010\u0005J\u000f\u0010G\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010\u0005J\u000f\u0010H\u001a\u00020\u0006H\u0002¢\u0006\u0004\bH\u0010\u0005J\u0017\u0010I\u001a\u00020\u00062\u0006\u0010=\u001a\u00020$H\u0002¢\u0006\u0004\bI\u0010'J\u0019\u0010L\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010JH\u0017¢\u0006\u0004\bL\u0010MJ\u0019\u0010P\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u00010NH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u0006H\u0014¢\u0006\u0004\bR\u0010\u0005J\u000f\u0010S\u001a\u00020\u0006H\u0016¢\u0006\u0004\bS\u0010\u0005J\u000f\u0010T\u001a\u00020\u0006H\u0014¢\u0006\u0004\bT\u0010\u0005J)\u0010Y\u001a\u00020\u00062\u0006\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020$2\b\u0010X\u001a\u0004\u0018\u00010WH\u0014¢\u0006\u0004\bY\u0010ZR\u001d\u0010`\u001a\u0004\u0018\u00010[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010fR\u0016\u0010k\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010fR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010nR\u0018\u0010t\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010w¨\u0006{"}, d2 = {"Lcom/martian/mibook/mvvm/book/activity/BookDetailActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityBookDetailBinding;", "Lcom/martian/mibook/mvvm/book/viewmodel/BookViewModel;", "<init>", "()V", "", "initView", "n3", "L3", "M3", "J2", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "errorResult", "I3", "(Lcom/martian/mibook/mvvm/net/ErrorResult;)V", "Lcom/martian/mibook/lib/account/response/TYChapterContent;", "chapterContent", "C3", "(Lcom/martian/mibook/lib/account/response/TYChapterContent;)V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "H3", "(Ljava/util/List;)V", "x3", "q3", "s3", "r3", "o3", "p3", "t3", "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "bookInfo", "O3", "(Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;)V", "", "myCommentScore", "R3", "(I)V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "commentList", "F3", "Lcom/martian/mibook/lib/model/data/abs/Book;", "book", "y3", "(Lcom/martian/mibook/lib/model/data/abs/Book;)V", "F2", "E2", "G3", "", "tagList", "B3", "rank", "category", "brType", "N3", "(ILjava/lang/String;I)V", "Landroid/widget/ImageView;", "imageView", "", "score", "gradeOne", "gradeTwo", "Q3", "(Landroid/widget/ImageView;FFF)V", "H2", "()I", "v3", "P3", "K3", "u3", "G2", "J3", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "onResume", "A0", "onDestroy", "requestCode", "resultCode", "Landroid/content/Intent;", "intent", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "h", "Lkotlin/Lazy;", "I2", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "mCommentViewModel", "Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter;", "i", "Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter;", "commentAdapter", "j", "I", "chatContentIndex", "k", BaseReadAloudService.f15168x, t.f11204d, BaseReadAloudService.f15169y, "Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter;", "m", "Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter;", "recommendBooksAdapter", "n", "authorBooksAdapter", "o", "Ljava/lang/String;", "commentString", "Landroidx/fragment/app/DialogFragment;", "p", "Landroidx/fragment/app/DialogFragment;", "bookChapterListDialogFragment", "q", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookDetailActivity.kt\ncom/martian/mibook/mvvm/book/activity/BookDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1087:1\n1#2:1088\n*E\n"})
/* loaded from: classes3.dex */
public final class BookDetailActivity extends BaseMVVMActivity<ActivityBookDetailBinding, BookViewModel> {

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r */
    public static final int f14047r = 205;

    /* renamed from: s */
    public static final int f14048s = 777;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public CommentAdapter commentAdapter;

    /* renamed from: k, reason: from kotlin metadata */
    public int com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;

    /* renamed from: l */
    public int contentPos;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public GridBookAdapter recommendBooksAdapter;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public GridBookAdapter authorBooksAdapter;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public String commentString;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public DialogFragment bookChapterListDialogFragment;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy mCommentViewModel = LazyKt.lazy(new Function0<ReaderCommentViewModel>() { // from class: com.martian.mibook.mvvm.book.activity.BookDetailActivity$mCommentViewModel$2
        public BookDetailActivity$mCommentViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReaderCommentViewModel invoke() {
            ReaderCommentViewModel readerCommentViewModel = (ReaderCommentViewModel) new ViewModelProvider(BookDetailActivity.this).get(ReaderCommentViewModel.class);
            readerCommentViewModel.J(BookDetailActivity.this.m1().getBookInfo());
            return readerCommentViewModel;
        }
    });

    /* renamed from: j, reason: from kotlin metadata */
    public int chatContentIndex = 1;

    /* renamed from: com.martian.mibook.mvvm.book.activity.BookDetailActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String b(Companion companion, Integer num, TextView textView, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                num = null;
            }
            return companion.a(num, textView, str);
        }

        @JvmStatic
        @k
        public final String a(@l Integer num, @k TextView view, @k String unit) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(unit, "unit");
            String str = "";
            if (num == null || num.intValue() <= 0) {
                view.setText("");
                return "--";
            }
            if (num.intValue() < 10000) {
                view.setText(unit);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(num);
                return sb2.toString();
            }
            view.setText("万");
            int intValue = num.intValue() / 10000;
            int intValue2 = (num.intValue() - (intValue * 10000)) / 1000;
            if (intValue2 > 0) {
                str = p1.b.f29697h + intValue2;
            }
            return intValue + str;
        }

        public Companion() {
        }
    }

    public static final class b implements FlexboxTagLayout.a {
        public b() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            i.b0(BookDetailActivity.this.H2(), title, 7);
        }
    }

    public static final class c implements PostBookCommentFragment.e {
        public c() {
        }

        @Override // com.martian.mibook.fragment.dialog.PostBookCommentFragment.e
        public void a(@k CommentReply comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.fragment.dialog.PostBookCommentFragment.e
        @SuppressLint({"SetTextI18n"})
        public void b(@k Comment comment) {
            Integer nComments;
            Intrinsics.checkNotNullParameter(comment, "comment");
            int i10 = 0;
            if (BookDetailActivity.this.commentAdapter != null) {
                CommentAdapter commentAdapter = BookDetailActivity.this.commentAdapter;
                if (commentAdapter != null) {
                    commentAdapter.b0(0, comment);
                }
            } else {
                BookDetailActivity.this.F3(CollectionsKt.arrayListOf(comment));
            }
            BookDetailActivity.this.commentString = null;
            BookInfo bookInfo = BookDetailActivity.this.m1().getBookInfo();
            if (bookInfo != null) {
                BookInfo bookInfo2 = BookDetailActivity.this.m1().getBookInfo();
                if (bookInfo2 != null && (nComments = bookInfo2.getNComments()) != null) {
                    i10 = nComments.intValue();
                }
                bookInfo.setNComments(Integer.valueOf(i10 + 1));
            }
            ThemeTextView themeTextView = BookDetailActivity.s2(BookDetailActivity.this).tvCommentNumber;
            BookInfo bookInfo3 = BookDetailActivity.this.m1().getBookInfo();
            Integer nComments2 = bookInfo3 != null ? bookInfo3.getNComments() : null;
            themeTextView.setText(nComments2 + "条" + BookDetailActivity.this.getString(R.string.reader_comment));
            BookDetailActivity.this.M3();
        }

        @Override // com.martian.mibook.fragment.dialog.PostBookCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            BookDetailActivity.this.commentString = comment;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void A3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((ActivityBookDetailBinding) this$0.a1()).tvIntroMoreView.getVisibility() == 0) {
            boolean z10 = !((ActivityBookDetailBinding) this$0.a1()).tvIntroText.f();
            ((ActivityBookDetailBinding) this$0.a1()).tvIntroText.setMaxLines(z10 ? Integer.MAX_VALUE : 4);
            ((ActivityBookDetailBinding) this$0.a1()).tvIntroText.g(z10, z10 ? ConfigSingleton.i(20.0f) : 0);
            ((ActivityBookDetailBinding) this$0.a1()).tvIntroMoreView.setText(this$0.getString(((ActivityBookDetailBinding) this$0.a1()).tvIntroText.f() ? R.string.fold : R.string.expand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void D3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThemeTextView themeTextView = ((ActivityBookDetailBinding) this$0.a1()).tvBookChapterContent;
        if (themeTextView.getLayout().getEllipsisCount(themeTextView.getLineCount() - 1) <= 0) {
            i.S(this$0, this$0.m1().getBook(), 1, 0, 0, true);
            return;
        }
        ac.a.u(this$0, "抢先阅读第一章-" + this$0.chatContentIndex + "次");
        ((ActivityBookDetailBinding) this$0.a1()).scrollviewChapterContent.getLayoutParams().height = -2;
        themeTextView.setMaxLines((this$0.chatContentIndex * 41) + 11);
        this$0.chatContentIndex = this$0.chatContentIndex + 1;
        this$0.v3();
        themeTextView.post(new Runnable() { // from class: mc.w

            /* renamed from: c */
            public final /* synthetic */ BookDetailActivity f28612c;

            public /* synthetic */ w(BookDetailActivity this$02) {
                this$0 = this$02;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BookDetailActivity.E3(ThemeTextView.this, this$0);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void E3(ThemeTextView it, BookDetailActivity this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it.getLayout().getEllipsisCount(it.getLineCount() - 1) <= 0) {
            ((ActivityBookDetailBinding) this$0.a1()).bookChapterReadingNext.setText(this$0.getString(R.string.book_read_chapter_next));
            ((ActivityBookDetailBinding) this$0.a1()).bookChapterIcon.setImageResource(R.drawable.loan_more);
            ((ActivityBookDetailBinding) this$0.a1()).bookChapterIcon.p();
        }
    }

    public static final void K2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J3(80);
    }

    public static final void L2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J3(100);
    }

    public static final void M2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J3(20);
    }

    public static final void N2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J3(40);
    }

    public static final void O2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J3(60);
    }

    public static final void P2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K3();
    }

    public static final void Q2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K3();
    }

    public static final void R2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u3();
    }

    public static final void S2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G2();
    }

    @JvmStatic
    @k
    public static final String S3(@l Integer num, @k TextView textView, @k String str) {
        return INSTANCE.a(num, textView, str);
    }

    public static final void T2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o3();
    }

    public static final void U2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p3();
    }

    public static final void V2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t3();
    }

    public static final void W2(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t3();
    }

    public static final boolean X2(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void Y2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Z2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void a3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void b3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void c3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void d3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void e3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void f3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void g3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q3();
    }

    public static final void h3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s3();
    }

    public static final void i3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        if (((ActivityBookDetailBinding) a1()).rvHotComment.getLayoutManager() == null) {
            ((ActivityBookDetailBinding) a1()).rvHotComment.setLayoutManager(new LinearLayoutManager(this));
        }
        if (((ActivityBookDetailBinding) a1()).rvRecommendBooks.getLayoutManager() == null) {
            ((ActivityBookDetailBinding) a1()).rvRecommendBooks.setLayoutManager(new GridLayoutManager(this, GridBookAdapter.INSTANCE.a()));
        }
        if (((ActivityBookDetailBinding) a1()).rvAuthorBooks.getLayoutManager() == null) {
            ((ActivityBookDetailBinding) a1()).rvAuthorBooks.setLayoutManager(new GridLayoutManager(this, GridBookAdapter.INSTANCE.a()));
        }
        ((ActivityBookDetailBinding) a1()).newBookView.setBackgroundResource(ConfigSingleton.D().A0() ? R.drawable.bg_new_book_view_night : R.drawable.bg_new_book_view_day);
    }

    public static final void j3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v0.T0(this$0, ((ActivityBookDetailBinding) this$0.a1()).rlMore, this$0.m1().getBook(), null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l3(BookDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v0.T0(this$0, ((ActivityBookDetailBinding) this$0.a1()).rlMore, this$0.m1().getBook(), null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m3(BookDetailActivity this$0, View view, int i10, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i11 <= 100) {
            float f10 = i11 / 100;
            ((ActivityBookDetailBinding) this$0.a1()).actionbarTitle.setAlpha(f10);
            ((ActivityBookDetailBinding) this$0.a1()).actionbarTopView.setAlpha(f10);
            ((ActivityBookDetailBinding) this$0.a1()).ivToolbarBg.setAlpha(f10);
            ((ActivityBookDetailBinding) this$0.a1()).actionbarDivider.setVisibility(4);
            return;
        }
        if (((ActivityBookDetailBinding) this$0.a1()).actionbarDivider.getVisibility() == 4) {
            ((ActivityBookDetailBinding) this$0.a1()).actionbarTitle.setAlpha(1.0f);
            ((ActivityBookDetailBinding) this$0.a1()).actionbarTopView.setAlpha(1.0f);
            ((ActivityBookDetailBinding) this$0.a1()).ivToolbarBg.setAlpha(1.0f);
            ((ActivityBookDetailBinding) this$0.a1()).actionbarDivider.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityBookDetailBinding s2(BookDetailActivity bookDetailActivity) {
        return (ActivityBookDetailBinding) bookDetailActivity.a1();
    }

    public static final void w3(NestedScrollView this_apply) {
        int height;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        int height2 = this_apply.getChildAt(0).getHeight();
        if (height2 <= this_apply.getVerticalFadingEdgeLength() || height2 <= (height = this_apply.getHeight() - this_apply.getVerticalFadingEdgeLength())) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this_apply.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
        layoutParams.height = height;
        this_apply.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void z3(BookDetailActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ActivityBookDetailBinding) this$0.a1()).tvIntroMoreView.setVisibility(((ActivityBookDetailBinding) this$0.a1()).tvIntroText.getLineCount() > 4 ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, k9.b
    public void A0() {
        ((ActivityBookDetailBinding) a1()).ivTopBg.setAlpha(ConfigSingleton.D().A0() ? 0.0f : 1.0f);
        ((ActivityBookDetailBinding) a1()).newBookView.setBackgroundResource(ConfigSingleton.D().A0() ? R.drawable.bg_new_book_view_night : R.drawable.bg_new_book_view_day);
        super.A0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B3(List<String> tagList) {
        List<String> list = tagList;
        if (list == null || list.isEmpty() || MiConfigSingleton.b2().y0()) {
            ((ActivityBookDetailBinding) a1()).flexboxCategory.setVisibility(8);
            return;
        }
        if (((ActivityBookDetailBinding) a1()).flexboxCategory.getChildCount() == 0) {
            ((ActivityBookDetailBinding) a1()).flexboxCategory.setData(tagList);
            ((ActivityBookDetailBinding) a1()).flexboxCategory.setVisibility(0);
        }
        ((ActivityBookDetailBinding) a1()).flexboxCategory.setOnItemTitleClickListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C3(TYChapterContent chapterContent) {
        String content = chapterContent != null ? chapterContent.getContent() : null;
        if (TextUtils.isEmpty(content)) {
            ((ActivityBookDetailBinding) a1()).llBookChapterView.setVisibility(8);
            return;
        }
        ((ActivityBookDetailBinding) a1()).llBookChapterView.setVisibility(0);
        String chapterTitle = chapterContent != null ? chapterContent.getChapterTitle() : null;
        ThemeTextView themeTextView = ((ActivityBookDetailBinding) a1()).bookChapterTitle;
        if (TextUtils.isEmpty(chapterTitle)) {
            chapterTitle = "快速阅读";
        }
        themeTextView.setText(ExtKt.c(chapterTitle));
        ((ActivityBookDetailBinding) a1()).tvBookChapterContent.setText(ExtKt.c(content));
        v3();
        ((ActivityBookDetailBinding) a1()).bookChapterReadingNext.setText(getString(R.string.book_read_chapter_first));
        ((ActivityBookDetailBinding) a1()).bookChapterNext.setOnClickListener(new View.OnClickListener() { // from class: mc.l
            public /* synthetic */ l() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.D3(BookDetailActivity.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E2() {
        if (MiConfigSingleton.b2().y0()) {
            ((ActivityBookDetailBinding) a1()).llAudioBook.setVisibility(8);
            return;
        }
        BookViewModel m12 = m1();
        Book book = m1().getBook();
        String author = book != null ? book.getAuthor() : null;
        Book book2 = m1().getBook();
        m12.u(author, book2 != null ? book2.getBookName() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F2() {
        BookInfo bookInfo = m1().getBookInfo();
        if (TextUtils.isEmpty(bookInfo != null ? bookInfo.getBookName() : null) || ConfigSingleton.D().y0() || MiConfigSingleton.b2().J2()) {
            ((ActivityBookDetailBinding) a1()).llRecommendBooks.setVisibility(8);
        } else {
            BookViewModel.H(m1(), 0, 0, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F3(List<Comment> commentList) {
        CommentAdapter commentAdapter = this.commentAdapter;
        if (commentAdapter != null) {
            if (commentAdapter != null) {
                commentAdapter.I(commentList);
                return;
            }
            return;
        }
        CommentAdapter commentAdapter2 = new CommentAdapter(I2(), ReaderCommentViewModel.CommentType.TYPE_BOOK_DETAIL_HOT_COMMENT);
        this.commentAdapter = commentAdapter2;
        commentAdapter2.l0(1);
        ((ActivityBookDetailBinding) a1()).rvHotComment.setAdapter(this.commentAdapter);
        CommentAdapter commentAdapter3 = this.commentAdapter;
        if (commentAdapter3 != null) {
            commentAdapter3.n(commentList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G2() {
        if (((ActivityBookDetailBinding) a1()).llAuthorBooksMore.getVisibility() != 0) {
            return;
        }
        if (m1().getBook() == null) {
            t0.b(this, "书籍加载中，请稍后");
        } else {
            ac.a.u(this, "同作者作品-查看全部");
            AuthorBooksActivity.L2(this, m1().getBook(), AuthorBooksActivity.I, m1().getSeed());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void G3() {
        String sourceUrl;
        ((ActivityBookDetailBinding) a1()).tvBookSource.setVisibility(8);
        Book book = m1().getBook();
        if (book instanceof YWBook) {
            Book book2 = m1().getBook();
            Intrinsics.checkNotNull(book2, "null cannot be cast to non-null type com.martian.mibook.lib.yuewen.response.YWBook");
            ThemeTextView themeTextView = ((ActivityBookDetailBinding) a1()).tvBookSource;
            themeTextView.setText(getString(R.string.book_source_info));
            themeTextView.setVisibility(0);
            return;
        }
        if (book instanceof TFBook) {
            Book book3 = m1().getBook();
            Intrinsics.checkNotNull(book3, "null cannot be cast to non-null type com.martian.free.response.TFBook");
            TFBook tFBook = (TFBook) book3;
            if (ba.l.q(tFBook.getCpName())) {
                return;
            }
            ThemeTextView themeTextView2 = ((ActivityBookDetailBinding) a1()).tvBookSource;
            themeTextView2.setText(getString(R.string.book_source_info_1) + ExtKt.c(tFBook.getCpName()) + getString(R.string.book_source_info_2));
            themeTextView2.setVisibility(0);
            return;
        }
        if (book instanceof ORBook) {
            ThemeTextView themeTextView3 = ((ActivityBookDetailBinding) a1()).tvBookSource;
            themeTextView3.setText(getString(R.string.book_source_txs_info));
            themeTextView3.setVisibility(0);
            return;
        }
        Book book4 = m1().getBook();
        if (book4 == null || (sourceUrl = book4.getSourceUrl()) == null) {
            return;
        }
        if (sourceUrl.length() <= 0) {
            sourceUrl = null;
        }
        if (sourceUrl != null) {
            ((ActivityBookDetailBinding) a1()).tvCategory.setVisibility(0);
            String c10 = ExtKt.c("来源：" + sourceUrl);
            CharSequence text = ((ActivityBookDetailBinding) a1()).tvCategory.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            List split$default = StringsKt.split$default(text, new String[]{"·"}, false, 0, 6, (Object) null);
            ((ActivityBookDetailBinding) a1()).tvCategory.setText(split$default.get(0) + "·" + c10);
        }
    }

    public final int H2() {
        Book book = m1().getBook();
        if (book instanceof YWBook) {
            Book book2 = m1().getBook();
            Intrinsics.checkNotNull(book2, "null cannot be cast to non-null type com.martian.mibook.lib.yuewen.response.YWBook");
            return ((YWBook) book2).getFreeType();
        }
        if (!(book instanceof TFBook)) {
            return MiConfigSingleton.b2().p();
        }
        try {
            Book book3 = m1().getBook();
            Intrinsics.checkNotNull(book3, "null cannot be cast to non-null type com.martian.free.response.TFBook");
            String freeType = ((TFBook) book3).getFreeType();
            Intrinsics.checkNotNullExpressionValue(freeType, "getFreeType(...)");
            return Integer.parseInt(freeType);
        } catch (Exception unused) {
            return MiConfigSingleton.b2().p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H3(List<? extends TYBookItem> bookList) {
        List<? extends TYBookItem> list = bookList;
        if (list == null || list.isEmpty()) {
            ((ActivityBookDetailBinding) a1()).llRecommendBooks.setVisibility(8);
            return;
        }
        Iterator it = CollectionsKt.toMutableList((Collection) list).iterator();
        while (it.hasNext()) {
            TYBookItem tYBookItem = (TYBookItem) it.next();
            if (m1().getBook() != null) {
                String sourceString = tYBookItem.getSourceString();
                Book book = m1().getBook();
                if (Intrinsics.areEqual(sourceString, book != null ? book.getSourceString() : null)) {
                    it.remove();
                }
            }
        }
        ((ActivityBookDetailBinding) a1()).llRecommendMore.setVisibility(bookList.size() >= 8 ? 0 : 8);
        if (this.recommendBooksAdapter == null) {
            this.recommendBooksAdapter = new GridBookAdapter();
            ((ActivityBookDetailBinding) a1()).rvRecommendBooks.setAdapter(this.recommendBooksAdapter);
        }
        GridBookAdapter gridBookAdapter = this.recommendBooksAdapter;
        if (gridBookAdapter != null) {
            gridBookAdapter.o(bookList);
        }
    }

    public final ReaderCommentViewModel I2() {
        return (ReaderCommentViewModel) this.mCommentViewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I3(ErrorResult errorResult) {
        ((ActivityBookDetailBinding) a1()).llBookInfo.setVisibility(8);
        A1(errorResult, ((ActivityBookDetailBinding) a1()).loadingTip);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void J2() {
        MutableLiveData<Pair<String, Integer>> g02;
        MutableLiveData<Pair<Integer, Object>> f02;
        MutableLiveData<BookInfo> B;
        ((ActivityBookDetailBinding) a1()).loadingTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.book.activity.BookDetailActivity$initListener$1
            public BookDetailActivity$initListener$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                BookDetailActivity.this.n3();
            }
        });
        ((ActivityBookDetailBinding) a1()).bookRankView.setOnClickListener(new View.OnClickListener() { // from class: mc.h0
            public /* synthetic */ h0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.g3(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).newBookView.setOnClickListener(new View.OnClickListener() { // from class: mc.k
            public /* synthetic */ k() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.h3(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).llDir.setOnClickListener(new View.OnClickListener() { // from class: mc.r
            public /* synthetic */ r() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.i3(BookDetailActivity.this, view);
            }
        });
        ActivityBookDetailBinding activityBookDetailBinding = (ActivityBookDetailBinding) a1();
        activityBookDetailBinding.ivMyCommentVote1.setOnClickListener(new View.OnClickListener() { // from class: mc.s
            public /* synthetic */ s() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.M2(BookDetailActivity.this, view);
            }
        });
        activityBookDetailBinding.ivMyCommentVote2.setOnClickListener(new View.OnClickListener() { // from class: mc.t
            public /* synthetic */ t() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.N2(BookDetailActivity.this, view);
            }
        });
        activityBookDetailBinding.ivMyCommentVote3.setOnClickListener(new View.OnClickListener() { // from class: mc.u
            public /* synthetic */ u() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.O2(BookDetailActivity.this, view);
            }
        });
        activityBookDetailBinding.ivMyCommentVote4.setOnClickListener(new View.OnClickListener() { // from class: mc.v
            public /* synthetic */ v() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.K2(BookDetailActivity.this, view);
            }
        });
        activityBookDetailBinding.ivMyCommentVote5.setOnClickListener(new View.OnClickListener() { // from class: mc.x
            public /* synthetic */ x() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.L2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).myCommentView.setOnClickListener(null);
        ((ActivityBookDetailBinding) a1()).llWholeBookComment.setOnClickListener(new View.OnClickListener() { // from class: mc.y
            public /* synthetic */ y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.P2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).bookCommentView.setOnClickListener(new View.OnClickListener() { // from class: mc.z
            public /* synthetic */ z() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.Q2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).llRecommendBooks.setOnClickListener(new View.OnClickListener() { // from class: mc.i0
            public /* synthetic */ i0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.R2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).llAuthorBooks.setOnClickListener(new View.OnClickListener() { // from class: mc.b
            public /* synthetic */ b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.S2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).llAddBookshelf.setOnClickListener(new View.OnClickListener() { // from class: mc.c
            public /* synthetic */ c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.T2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).llAudioBook.setOnClickListener(new View.OnClickListener() { // from class: mc.d
            public /* synthetic */ d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.U2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).ivBookCover.setOnClickListener(new View.OnClickListener() { // from class: mc.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.V2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).tvReading.setOnClickListener(new View.OnClickListener() { // from class: mc.f
            public /* synthetic */ f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.W2(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).scrollviewChapterContent.setOnTouchListener(new View.OnTouchListener() { // from class: mc.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean X2;
                X2 = BookDetailActivity.X2(view, motionEvent);
                return X2;
            }
        });
        m1().E().observe(this, new Observer() { // from class: mc.h
            public /* synthetic */ h() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookDetailActivity.Y2(Function1.this, obj);
            }
        });
        m1().D().observe(this, new Observer() { // from class: mc.i
            public /* synthetic */ i() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookDetailActivity.Z2(Function1.this, obj);
            }
        });
        m1().C().observe(this, new Observer() { // from class: mc.j
            public /* synthetic */ j() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookDetailActivity.a3(Function1.this, obj);
            }
        });
        m1().F().observe(this, new Observer() { // from class: mc.m
            public /* synthetic */ m() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookDetailActivity.b3(Function1.this, obj);
            }
        });
        m1().B().observe(this, new Observer() { // from class: mc.n
            public /* synthetic */ n() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookDetailActivity.c3(Function1.this, obj);
            }
        });
        ReaderCommentViewModel I2 = I2();
        if (I2 != null && (B = I2.B()) != null) {
            B.observe(this, new Observer() { // from class: mc.o
                public /* synthetic */ o() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BookDetailActivity.d3(Function1.this, obj);
                }
            });
        }
        AppViewModel l12 = l1();
        if (l12 != null && (f02 = l12.f0()) != null) {
            f02.observe(this, new Observer() { // from class: mc.p
                public /* synthetic */ p() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BookDetailActivity.e3(Function1.this, obj);
                }
            });
        }
        AppViewModel l13 = l1();
        if (l13 == null || (g02 = l13.g0()) == null) {
            return;
        }
        g02.observe(this, new Observer() { // from class: mc.q
            public /* synthetic */ q() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookDetailActivity.f3(Function1.this, obj);
            }
        });
    }

    public final void J3(int score) {
        PostBookCommentFragment.q0(this, m1().getBookInfo(), score, this.commentString, new c());
    }

    public final void K3() {
        ac.a.u(this, "全部评论");
        BookInfo bookInfo = m1().getBookInfo();
        if (bookInfo != null) {
            CommentFragment.INSTANCE.b(this, bookInfo);
        }
    }

    public final void L3() {
        BookViewModel m12 = m1();
        BookInfo bookInfo = m1().getBookInfo();
        String sourceId = bookInfo != null ? bookInfo.getSourceId() : null;
        BookInfo bookInfo2 = m1().getBookInfo();
        BookViewModel.L(m12, sourceId, bookInfo2 != null ? bookInfo2.getSourceName() : null, false, 4, null);
    }

    public final void M3() {
        ReaderCommentViewModel I2 = I2();
        if (I2 != null) {
            BookInfo bookInfo = m1().getBookInfo();
            String sourceName = bookInfo != null ? bookInfo.getSourceName() : null;
            BookInfo bookInfo2 = m1().getBookInfo();
            I2.r(sourceName, bookInfo2 != null ? bookInfo2.getSourceId() : null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void N3(int rank, String category, int brType) {
        if (MiConfigSingleton.b2().y0()) {
            ((ActivityBookDetailBinding) a1()).bookRankView.setVisibility(8);
            return;
        }
        if (rank <= 0 || TextUtils.isEmpty(category)) {
            ((ActivityBookDetailBinding) a1()).bookRankView.setVisibility(8);
            return;
        }
        String N1 = MiConfigSingleton.b2().N1(this, brType);
        ((ActivityBookDetailBinding) a1()).bookRankView.setVisibility(0);
        ((ActivityBookDetailBinding) a1()).tvRankName.setText(category + N1 + "榜");
        ((ActivityBookDetailBinding) a1()).tvRanking.setText(ExtKt.c(" 第" + rank + "名"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void O3(BookInfo bookInfo) {
        int i10;
        BookInfo mBookInfo;
        BookInfo mBookInfo2;
        Float score;
        float floatValue = ((bookInfo == null || (score = bookInfo.getScore()) == null) ? 0.0f : score.floatValue()) / 10.0f;
        if (floatValue > 0.0f) {
            ThemeTextView themeTextView = ((ActivityBookDetailBinding) a1()).tvBookScore;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.CHINA, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(floatValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            themeTextView.setText(format);
            ((ActivityBookDetailBinding) a1()).tvBookScore.setPadding(0, 0, ConfigSingleton.i(4.0f), 0);
            ((ActivityBookDetailBinding) a1()).tvScoreTip.setText(getString(R.string.grade));
        } else {
            ((ActivityBookDetailBinding) a1()).tvBookScore.setText("");
            ((ActivityBookDetailBinding) a1()).tvBookScore.setPadding(0, 0, 0, 0);
            ((ActivityBookDetailBinding) a1()).tvScoreTip.setText(getString(R.string.empty_grade));
        }
        ImageView ivVote1 = ((ActivityBookDetailBinding) a1()).ivVote1;
        Intrinsics.checkNotNullExpressionValue(ivVote1, "ivVote1");
        Q3(ivVote1, floatValue, 0.0f, 1.4f);
        ImageView ivVote2 = ((ActivityBookDetailBinding) a1()).ivVote2;
        Intrinsics.checkNotNullExpressionValue(ivVote2, "ivVote2");
        Q3(ivVote2, floatValue, 2.4f, 3.4f);
        ImageView ivVote3 = ((ActivityBookDetailBinding) a1()).ivVote3;
        Intrinsics.checkNotNullExpressionValue(ivVote3, "ivVote3");
        Q3(ivVote3, floatValue, 4.4f, 5.4f);
        ImageView ivVote4 = ((ActivityBookDetailBinding) a1()).ivVote4;
        Intrinsics.checkNotNullExpressionValue(ivVote4, "ivVote4");
        Q3(ivVote4, floatValue, 6.4f, 7.4f);
        ImageView ivVote5 = ((ActivityBookDetailBinding) a1()).ivVote5;
        Intrinsics.checkNotNullExpressionValue(ivVote5, "ivVote5");
        Q3(ivVote5, floatValue, 8.4f, 9.4f);
        ThemeTextView themeTextView2 = ((ActivityBookDetailBinding) a1()).tvPopularityValue;
        Companion companion = INSTANCE;
        Integer clickCount = bookInfo != null ? bookInfo.getClickCount() : null;
        ThemeTextView tvPopularityUnit = ((ActivityBookDetailBinding) a1()).tvPopularityUnit;
        Intrinsics.checkNotNullExpressionValue(tvPopularityUnit, "tvPopularityUnit");
        themeTextView2.setText(companion.a(clickCount, tvPopularityUnit, ""));
        ThemeTextView themeTextView3 = ((ActivityBookDetailBinding) a1()).tvReadersCount;
        Integer readingCount = bookInfo != null ? bookInfo.getReadingCount() : null;
        ThemeTextView tvReadersCountUnit = ((ActivityBookDetailBinding) a1()).tvReadersCountUnit;
        Intrinsics.checkNotNullExpressionValue(tvReadersCountUnit, "tvReadersCountUnit");
        themeTextView3.setText(companion.a(readingCount, tvReadersCountUnit, "人"));
        if (!MiConfigSingleton.b2().p3()) {
            ((ActivityBookDetailBinding) a1()).bookCommentView.setVisibility(8);
            return;
        }
        ((ActivityBookDetailBinding) a1()).bookCommentView.setVisibility(0);
        ReaderCommentViewModel I2 = I2();
        Comment myComment = (I2 == null || (mBookInfo2 = I2.getMBookInfo()) == null) ? null : mBookInfo2.getMyComment();
        if (myComment != null) {
            i10 = myComment.getScore();
            ((ActivityBookDetailBinding) a1()).bookCommentStatus.setText(getString(R.string.mine) + getString(R.string.grade));
        } else {
            ((ActivityBookDetailBinding) a1()).bookCommentStatus.setText(getString(R.string.touch_to_comment));
            i10 = 0;
        }
        R3(i10);
        ReaderCommentViewModel I22 = I2();
        List<Comment> hotCommentList = (I22 == null || (mBookInfo = I22.getMBookInfo()) == null) ? null : mBookInfo.getHotCommentList();
        ViewGroup.LayoutParams layoutParams = ((ActivityBookDetailBinding) a1()).myCommentView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            List<Comment> list = hotCommentList;
            marginLayoutParams.bottomMargin = (list == null || list.isEmpty()) ? ConfigSingleton.i(16.0f) : ConfigSingleton.i(4.0f);
        }
        List<Comment> list2 = hotCommentList;
        if (list2 == null || list2.isEmpty()) {
            ((ActivityBookDetailBinding) a1()).llCommentNumber.setVisibility(8);
            ((ActivityBookDetailBinding) a1()).rvHotComment.setVisibility(8);
            ((ActivityBookDetailBinding) a1()).rvHotCommentDriver.setVisibility(8);
            ((ActivityBookDetailBinding) a1()).llWholeBookComment.setVisibility(8);
            return;
        }
        ((ActivityBookDetailBinding) a1()).llCommentNumber.setVisibility(0);
        ((ActivityBookDetailBinding) a1()).rvHotComment.setVisibility(0);
        ((ActivityBookDetailBinding) a1()).rvHotCommentDriver.setVisibility(0);
        ((ActivityBookDetailBinding) a1()).llWholeBookComment.setVisibility(0);
        ThemeTextView themeTextView4 = ((ActivityBookDetailBinding) a1()).tvCommentNumber;
        Integer nComments = bookInfo != null ? bookInfo.getNComments() : null;
        themeTextView4.setText(nComments + "条" + getString(R.string.reader_comment));
        F3(hotCommentList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P3() {
        if (m1().getBook() == null) {
            return;
        }
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        BookInfo bookInfo = m1().getBookInfo();
        if (M1.i0(bookInfo != null ? bookInfo.getSourceString() : null)) {
            ((ActivityBookDetailBinding) a1()).llAddBookshelf.setEnabled(false);
            ((ActivityBookDetailBinding) a1()).llAddBookshelf.setAlpha(0.4f);
            ((ActivityBookDetailBinding) a1()).ivAddBookshelfIcon.setImageResource(R.drawable.icon_info_in_bookrack);
            ((ActivityBookDetailBinding) a1()).tvAddBookshelfStatus.setText(getString(R.string.already_in_bookrack));
            return;
        }
        ((ActivityBookDetailBinding) a1()).llAddBookshelf.setEnabled(true);
        ((ActivityBookDetailBinding) a1()).llAddBookshelf.setAlpha(1.0f);
        ((ActivityBookDetailBinding) a1()).ivAddBookshelfIcon.setImageResource(R.drawable.icon_info_add_bookrack);
        ((ActivityBookDetailBinding) a1()).tvAddBookshelfStatus.setText(getString(R.string.add_bookstore));
    }

    public final void Q3(ImageView imageView, float score, float gradeOne, float gradeTwo) {
        if (score < 0.0f) {
            imageView.setImageResource(R.drawable.vote_star_grey);
            return;
        }
        if (score <= gradeOne) {
            imageView.setImageResource(R.drawable.vote_star_grey);
        } else if (score <= gradeTwo) {
            imageView.setImageResource(R.drawable.vote_star_half);
        } else {
            imageView.setImageResource(R.drawable.vote_star_red);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R3(int myCommentScore) {
        ((ActivityBookDetailBinding) a1()).ivMyCommentVote1.setImageResource(myCommentScore < 20 ? R.drawable.icon_post_comment_star : R.drawable.vote_star_red);
        ((ActivityBookDetailBinding) a1()).ivMyCommentVote2.setImageResource(myCommentScore < 40 ? R.drawable.icon_post_comment_star : R.drawable.vote_star_red);
        ((ActivityBookDetailBinding) a1()).ivMyCommentVote3.setImageResource(myCommentScore < 60 ? R.drawable.icon_post_comment_star : R.drawable.vote_star_red);
        ((ActivityBookDetailBinding) a1()).ivMyCommentVote4.setImageResource(myCommentScore < 80 ? R.drawable.icon_post_comment_star : R.drawable.vote_star_red);
        ((ActivityBookDetailBinding) a1()).ivMyCommentVote5.setImageResource(myCommentScore < 100 ? R.drawable.icon_post_comment_star : R.drawable.vote_star_red);
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        BookViewModel m12 = m1();
        Bundle extras = getIntent().getExtras();
        Serializable serializable = extras != null ? extras.getSerializable("INTENT_BOOK_INFO") : null;
        m12.N(serializable instanceof BookInfo ? (BookInfo) serializable : null);
        BookInfo bookInfo = m1().getBookInfo();
        if (TextUtils.isEmpty(bookInfo != null ? bookInfo.getSourceString() : null)) {
            t0.b(this, "获取书籍信息失败");
            finish();
        } else {
            J2();
            initView();
            n3();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n3() {
        y1(true, ((ActivityBookDetailBinding) a1()).loadingTip);
        L3();
        M3();
    }

    public final void o3() {
        if (m1().getBook() == null) {
            t0.b(this, "书籍加载中，请稍后");
            return;
        }
        ac.a.u(this, "加入书架");
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        Book book = m1().getBook();
        if (M1.i0(book != null ? book.getSourceString() : null)) {
            t0.b(this, "已在书架中！");
        } else {
            MiConfigSingleton.b2().M1().g(this, m1().getBook());
            t0.b(this, "已添加到书架！");
            EventManager V1 = MiConfigSingleton.b2().V1();
            Book book2 = m1().getBook();
            String sourceName = book2 != null ? book2.getSourceName() : null;
            Book book3 = m1().getBook();
            String sourceId = book3 != null ? book3.getSourceId() : null;
            BookInfo bookInfo = m1().getBookInfo();
            String recommendId = bookInfo != null ? bookInfo.getRecommendId() : null;
            BookInfo bookInfo2 = m1().getBookInfo();
            V1.g(3, sourceName, sourceId, recommendId, bookInfo2 != null ? bookInfo2.getRecommend() : null, "详情加书架");
        }
        P3();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @l Intent intent) {
        if (requestCode == 200) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BookDetailActivity$onActivityResult$1(intent, this, null), 3, null);
            if (resultCode == 205) {
                M3();
            }
        } else if (requestCode == 1004 && resultCode == -1) {
            ac.a.D(this, MiConfigSingleton.b2().G1().k("登录成功", requestCode));
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DialogFragment dialogFragment = this.bookChapterListDialogFragment;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        P3();
    }

    public final void p3() {
        if (m1().getBook() == null) {
            t0.b(this, "书籍加载中，请稍后");
            return;
        }
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        Book book = m1().getBook();
        MiReadingRecord J = M1.J(book != null ? book.getSourceString() : null);
        if (J != null) {
            this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = J.getChapterIndex();
            Integer contentPos = J.getContentPos();
            Intrinsics.checkNotNullExpressionValue(contentPos, "getContentPos(...)");
            this.contentPos = contentPos.intValue();
        }
        TTSReadManager.D(this, m1().getBook(), null, new Function0<Unit>() { // from class: com.martian.mibook.mvvm.book.activity.BookDetailActivity$onAudiobookClick$1
            public BookDetailActivity$onAudiobookClick$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                int i10;
                int i11;
                Book book2 = BookDetailActivity.this.m1().getBook();
                i10 = BookDetailActivity.this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;
                i11 = BookDetailActivity.this.contentPos;
                b.f(book2, i10, i11, true, null, 16, null);
            }
        }, 4, null);
    }

    public final void q3() {
        if (m1().getBook() == null) {
            t0.b(this, "书籍加载中，请稍后");
            return;
        }
        ac.a.u(this, "榜单");
        BookInfo bookInfo = m1().getBookInfo();
        if ((bookInfo != null ? bookInfo.getRankInfo() : null) != null) {
            w0();
            return;
        }
        if (m1().getBook() instanceof YWBook) {
            Book book = m1().getBook();
            Intrinsics.checkNotNull(book, "null cannot be cast to non-null type com.martian.mibook.lib.yuewen.response.YWBook");
            YWBook yWBook = (YWBook) book;
            kc.b.i(yWBook.getFreeType(), Integer.valueOf(yWBook.getBrType()), yWBook.getCategory(), "书籍详情-");
            return;
        }
        if (m1().getBook() instanceof TFBook) {
            Book book2 = m1().getBook();
            Intrinsics.checkNotNull(book2, "null cannot be cast to non-null type com.martian.free.response.TFBook");
            TFBook tFBook = (TFBook) book2;
            String freeType = tFBook.getFreeType();
            Intrinsics.checkNotNullExpressionValue(freeType, "getFreeType(...)");
            kc.b.i(Integer.parseInt(freeType), Integer.valueOf(tFBook.getBrType()), tFBook.getCategory(), "书籍详情-");
        }
    }

    public final void r3() {
        MiReadingRecord K;
        DialogFragment dialogFragment = this.bookChapterListDialogFragment;
        if (dialogFragment == null || !dialogFragment.isVisible()) {
            ac.a.u(this, "目录");
            if (m1().getBook() != null && (K = MiConfigSingleton.b2().M1().K(m1().getBook())) != null) {
                m1().O(K.getChapterIndex());
            }
            this.bookChapterListDialogFragment = BookChapterListFragment.INSTANCE.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    @SuppressLint({"NewApi"})
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        d.l2(this, ((ActivityBookDetailBinding) a1()).actionbarTopView);
        if (ConfigSingleton.D().y0() || MiConfigSingleton.b2().J2()) {
            ((ActivityBookDetailBinding) a1()).llAddBookshelf.setVisibility(8);
        } else {
            ((ActivityBookDetailBinding) a1()).rlMore.setVisibility(0);
        }
        ((ActivityBookDetailBinding) a1()).actionbarBack.setOnClickListener(new View.OnClickListener() { // from class: mc.c0
            public /* synthetic */ c0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.j3(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).tvActionbarMore.setOnClickListener(new View.OnClickListener() { // from class: mc.d0
            public /* synthetic */ d0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.k3(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).actionbarMore.setOnClickListener(new View.OnClickListener() { // from class: mc.e0
            public /* synthetic */ e0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookDetailActivity.l3(BookDetailActivity.this, view);
            }
        });
        ((ActivityBookDetailBinding) a1()).ivTopBg.setAlpha(ConfigSingleton.D().A0() ? 0.0f : 1.0f);
        ViewGroup.LayoutParams layoutParams = ((ActivityBookDetailBinding) a1()).llContent.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ConfigSingleton.i(44.0f) + d.H0(this);
        }
        ((ActivityBookDetailBinding) a1()).scrollViewContainer.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: mc.f0
            public /* synthetic */ f0() {
            }

            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                BookDetailActivity.m3(BookDetailActivity.this, view, i10, i11, i12, i13);
            }
        });
    }

    public final void s3() {
        ac.a.u(this, "最近上新");
        kc.b.B("新书", H2(), 203);
    }

    public final void t3() {
        ac.a.u(this, "点击阅读");
        TYBookItem tYBookItem = new TYBookItem();
        tYBookItem.convertYwBookItem(m1().getBook());
        BookInfo bookInfo = m1().getBookInfo();
        if (bookInfo != null) {
            tYBookItem.setContext(bookInfo.getContext());
            tYBookItem.setRecommend(bookInfo.getRecommend());
            tYBookItem.setRecommendId(bookInfo.getRecommendId());
            Float score = bookInfo.getScore();
            tYBookItem.setScore(score != null ? Integer.valueOf((int) score.floatValue()) : null);
            tYBookItem.setClickCount(bookInfo.getClickCount());
            tYBookItem.setReadingCount(bookInfo.getReadingCount());
            tYBookItem.setnComments(bookInfo.getNComments());
        }
        i.R(this, tYBookItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u3() {
        if (((ActivityBookDetailBinding) a1()).llRecommendMore.getVisibility() != 0) {
            return;
        }
        if (m1().getBook() == null) {
            t0.b(this, "书籍加载中，请稍后");
        } else {
            ac.a.u(this, "本书读者还喜欢-查看全部");
            AuthorBooksActivity.L2(this, m1().getBook(), AuthorBooksActivity.K, m1().getSeed());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v3() {
        NestedScrollView nestedScrollView = ((ActivityBookDetailBinding) a1()).scrollviewChapterContent;
        nestedScrollView.post(new Runnable() { // from class: mc.g0
            public /* synthetic */ g0() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                BookDetailActivity.w3(NestedScrollView.this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x3(List<? extends TYBookItem> bookList) {
        List<? extends TYBookItem> list = bookList;
        if (list == null || list.isEmpty()) {
            ((ActivityBookDetailBinding) a1()).llAuthorBooks.setVisibility(8);
            return;
        }
        ((ActivityBookDetailBinding) a1()).llAuthorBooksMore.setVisibility(bookList.size() >= 8 ? 0 : 8);
        if (this.authorBooksAdapter == null) {
            this.authorBooksAdapter = new GridBookAdapter();
            ((ActivityBookDetailBinding) a1()).rvAuthorBooks.setAdapter(this.authorBooksAdapter);
        }
        GridBookAdapter gridBookAdapter = this.authorBooksAdapter;
        if (gridBookAdapter != null) {
            gridBookAdapter.o(bookList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ce  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y3(com.martian.mibook.lib.model.data.abs.Book r11) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.book.activity.BookDetailActivity.y3(com.martian.mibook.lib.model.data.abs.Book):void");
    }
}
