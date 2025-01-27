package com.martian.mibook.mvvm.read.viewmodel;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.data.book.CommentCount;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.GetCommentByScoreParams;
import com.martian.mibook.mvvm.net.request.GetCommentByTimeParams;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentDetail;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import com.umeng.analytics.pro.bt;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R%\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001e8\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\"R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020(0\u001e8\u0006¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010&R\"\u0010/\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\"R%\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001e8\u0006¢\u0006\f\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010&R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020(0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010\"R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020(0\u001e8\u0006¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b6\u0010&R\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010\"R\u001f\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u001e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b;\u0010&R\"\u0010C\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010J\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bE\u0010G\"\u0004\bH\u0010IR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010K\u001a\u0004\bP\u0010M\"\u0004\bQ\u0010OR$\u0010T\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010K\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR$\u0010W\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010K\u001a\u0004\bU\u0010M\"\u0004\bV\u0010OR$\u0010\\\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b>\u0010[¨\u0006^"}, d2 = {"Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/read/repository/ReadingRepository;", "<init>", "()V", "G", "()Lcom/martian/mibook/mvvm/read/repository/ReadingRepository;", "Lcom/martian/mibook/mvvm/net/request/GetCommentByScoreParams;", "params", "", "isLoadMore", "showLoading", "", "u", "(Lcom/martian/mibook/mvvm/net/request/GetCommentByScoreParams;ZZ)V", "Lcom/martian/mibook/mvvm/net/request/GetCommentByTimeParams;", "q", "(Lcom/martian/mibook/mvvm/net/request/GetCommentByTimeParams;ZZ)V", "", "sourceName", "sourceId", t.f11211k, "(Ljava/lang/String;Ljava/lang/String;)V", "", "cid", "page", "pageSize", "Lcom/martian/mibook/mvvm/read/comment/CommentDetail;", bt.aO, "(Ljava/lang/Integer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "h", "Landroidx/lifecycle/MutableLiveData;", "_mBookHotCommentsLiveData", "i", bt.aJ, "()Landroidx/lifecycle/MutableLiveData;", "mBookHotCommentsLiveData", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "j", "_mBookHotCommentsErrorLiveData", "k", "y", "mBookHotCommentsErrorLiveData", t.f11204d, "_mBookCommentsLiveData", "m", "x", "mBookCommentsLiveData", "n", "_mBookCommentsErrorLiveData", "o", IAdInterListener.AdReqParam.WIDTH, "mBookCommentsErrorLiveData", "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "p", "_mBookScoresAndTopCommentsLiveData", "B", "mBookScoresAndTopCommentsLiveData", "", "J", "v", "()J", "I", "(J)V", "lastRequestingBookScoresTime", "Lcom/martian/mibook/data/book/CommentCount;", "s", "Lcom/martian/mibook/data/book/CommentCount;", "()Lcom/martian/mibook/data/book/CommentCount;", "H", "(Lcom/martian/mibook/data/book/CommentCount;)V", "commentCount", "Ljava/lang/String;", "F", "()Ljava/lang/String;", "N", "(Ljava/lang/String;)V", ExifInterface.LONGITUDE_EAST, "M", "C", "K", "paragraphContent", "D", "L", "selectParagraphText", "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "(Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;)V", "mBookInfo", "CommentType", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderCommentViewModel extends BaseViewModel<ReadingRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<Comment>> _mBookHotCommentsLiveData;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<Comment>> mBookHotCommentsLiveData;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mBookHotCommentsErrorLiveData;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mBookHotCommentsErrorLiveData;

    /* renamed from: l */
    @k
    public final MutableLiveData<List<Comment>> _mBookCommentsLiveData;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<Comment>> mBookCommentsLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mBookCommentsErrorLiveData;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mBookCommentsErrorLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final MutableLiveData<BookInfo> _mBookScoresAndTopCommentsLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final MutableLiveData<BookInfo> mBookScoresAndTopCommentsLiveData;

    /* renamed from: r */
    public long lastRequestingBookScoresTime;

    /* renamed from: s, reason: from kotlin metadata */
    @l
    public CommentCount commentCount;

    /* renamed from: t */
    @l
    public String sourceName;

    /* renamed from: u, reason: from kotlin metadata */
    @l
    public String sourceId;

    /* renamed from: v, reason: from kotlin metadata */
    @l
    public String paragraphContent;

    /* renamed from: w */
    @l
    public String selectParagraphText;

    /* renamed from: x, reason: from kotlin metadata */
    @l
    public BookInfo mBookInfo;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "", "(Ljava/lang/String;I)V", "TYPE_PARAGRAPH", "TYPE_CHAPTER", "TYPE_BOOK_COMMENT", "TYPE_BOOK_DETAIL_HOT_COMMENT", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CommentType extends Enum<CommentType> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CommentType[] $VALUES;
        public static final CommentType TYPE_PARAGRAPH = new CommentType("TYPE_PARAGRAPH", 0);
        public static final CommentType TYPE_CHAPTER = new CommentType("TYPE_CHAPTER", 1);
        public static final CommentType TYPE_BOOK_COMMENT = new CommentType("TYPE_BOOK_COMMENT", 2);
        public static final CommentType TYPE_BOOK_DETAIL_HOT_COMMENT = new CommentType("TYPE_BOOK_DETAIL_HOT_COMMENT", 3);

        private static final /* synthetic */ CommentType[] $values() {
            return new CommentType[]{TYPE_PARAGRAPH, TYPE_CHAPTER, TYPE_BOOK_COMMENT, TYPE_BOOK_DETAIL_HOT_COMMENT};
        }

        static {
            CommentType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private CommentType(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<CommentType> getEntries() {
            return $ENTRIES;
        }

        public static CommentType valueOf(String str) {
            return (CommentType) Enum.valueOf(CommentType.class, str);
        }

        public static CommentType[] values() {
            return (CommentType[]) $VALUES.clone();
        }
    }

    public ReaderCommentViewModel() {
        MutableLiveData<List<Comment>> mutableLiveData = new MutableLiveData<>();
        this._mBookHotCommentsLiveData = mutableLiveData;
        this.mBookHotCommentsLiveData = mutableLiveData;
        MutableLiveData<ErrorResult> mutableLiveData2 = new MutableLiveData<>();
        this._mBookHotCommentsErrorLiveData = mutableLiveData2;
        this.mBookHotCommentsErrorLiveData = mutableLiveData2;
        MutableLiveData<List<Comment>> mutableLiveData3 = new MutableLiveData<>();
        this._mBookCommentsLiveData = mutableLiveData3;
        this.mBookCommentsLiveData = mutableLiveData3;
        MutableLiveData<ErrorResult> mutableLiveData4 = new MutableLiveData<>();
        this._mBookCommentsErrorLiveData = mutableLiveData4;
        this.mBookCommentsErrorLiveData = mutableLiveData4;
        MutableLiveData<BookInfo> mutableLiveData5 = new MutableLiveData<>();
        this._mBookScoresAndTopCommentsLiveData = mutableLiveData5;
        this.mBookScoresAndTopCommentsLiveData = mutableLiveData5;
    }

    @l
    /* renamed from: A, reason: from getter */
    public final BookInfo getMBookInfo() {
        return this.mBookInfo;
    }

    @k
    public final MutableLiveData<BookInfo> B() {
        return this.mBookScoresAndTopCommentsLiveData;
    }

    @l
    /* renamed from: C, reason: from getter */
    public final String getParagraphContent() {
        return this.paragraphContent;
    }

    @l
    /* renamed from: D, reason: from getter */
    public final String getSelectParagraphText() {
        return this.selectParagraphText;
    }

    @l
    /* renamed from: E, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: F, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: G */
    public ReadingRepository i() {
        return new ReadingRepository();
    }

    public final void H(@l CommentCount commentCount) {
        this.commentCount = commentCount;
    }

    public final void I(long j10) {
        this.lastRequestingBookScoresTime = j10;
    }

    public final void J(@l BookInfo bookInfo) {
        this.mBookInfo = bookInfo;
    }

    public final void K(@l String str) {
        this.paragraphContent = str;
    }

    public final void L(@l String str) {
        this.selectParagraphText = str;
    }

    public final void M(@l String str) {
        this.sourceId = str;
    }

    public final void N(@l String str) {
        this.sourceName = str;
    }

    public final void q(@k GetCommentByTimeParams params, boolean isLoadMore, boolean showLoading) {
        Intrinsics.checkNotNullParameter(params, "params");
        j(new ReaderCommentViewModel$getBookCommentList$1(this, params, null), new ReaderCommentViewModel$getBookCommentList$2(isLoadMore, this, null), showLoading);
    }

    public final void r(@l String str, @l String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.lastRequestingBookScoresTime + 20000 > System.currentTimeMillis()) {
            return;
        }
        this.lastRequestingBookScoresTime = System.currentTimeMillis();
        BaseViewModel.k(this, new ReaderCommentViewModel$getBookScoresAndTopComments$1(this, str, str2, null), null, false, 6, null);
    }

    @l
    /* renamed from: s, reason: from getter */
    public final CommentCount getCommentCount() {
        return this.commentCount;
    }

    @l
    public final Object t(@l Integer num, int i10, int i11, @k Continuation<? super CommentDetail> continuation) {
        if (num == null) {
            return null;
        }
        return f().i(num.intValue(), i10, i11, continuation);
    }

    public final void u(@k GetCommentByScoreParams params, boolean isLoadMore, boolean showLoading) {
        Intrinsics.checkNotNullParameter(params, "params");
        j(new ReaderCommentViewModel$getHotBookCommentList$1(this, params, null), new ReaderCommentViewModel$getHotBookCommentList$2(isLoadMore, this, null), showLoading);
    }

    /* renamed from: v, reason: from getter */
    public final long getLastRequestingBookScoresTime() {
        return this.lastRequestingBookScoresTime;
    }

    @k
    public final MutableLiveData<ErrorResult> w() {
        return this.mBookCommentsErrorLiveData;
    }

    @k
    public final MutableLiveData<List<Comment>> x() {
        return this.mBookCommentsLiveData;
    }

    @k
    public final MutableLiveData<ErrorResult> y() {
        return this.mBookHotCommentsErrorLiveData;
    }

    @k
    public final MutableLiveData<List<Comment>> z() {
        return this.mBookHotCommentsLiveData;
    }
}
