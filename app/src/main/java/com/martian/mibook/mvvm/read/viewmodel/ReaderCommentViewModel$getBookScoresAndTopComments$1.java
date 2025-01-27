package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.MiBookCommentItemList;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$getBookScoresAndTopComments$1", f = "ReaderCommentViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReaderCommentViewModel$getBookScoresAndTopComments$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sourceId;
    final /* synthetic */ String $sourceName;
    int label;
    final /* synthetic */ ReaderCommentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderCommentViewModel$getBookScoresAndTopComments$1(ReaderCommentViewModel readerCommentViewModel, String str, String str2, Continuation<? super ReaderCommentViewModel$getBookScoresAndTopComments$1> continuation) {
        super(2, continuation);
        this.this$0 = readerCommentViewModel;
        this.$sourceName = str;
        this.$sourceId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReaderCommentViewModel$getBookScoresAndTopComments$1(this.this$0, this.$sourceName, this.$sourceId, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Integer boxInt;
        Integer boxInt2;
        List<Comment> comments;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadingRepository f10 = this.this$0.f();
            String str = this.$sourceName;
            Intrinsics.checkNotNull(str);
            String str2 = this.$sourceId;
            Intrinsics.checkNotNull(str2);
            this.label = 1;
            obj = f10.h(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MiBookCommentItemList miBookCommentItemList = (MiBookCommentItemList) obj;
        BookInfo mBookInfo = this.this$0.getMBookInfo();
        if (mBookInfo != null) {
            if (miBookCommentItemList == null || (boxInt = miBookCommentItemList.getNComments()) == null) {
                boxInt = Boxing.boxInt(0);
            }
            mBookInfo.setNComments(boxInt);
            Comment comment = null;
            mBookInfo.setReadingCount(miBookCommentItemList != null ? miBookCommentItemList.getReadingCount() : null);
            mBookInfo.setClickCount(miBookCommentItemList != null ? Boxing.boxInt(miBookCommentItemList.getClickCount()) : null);
            mBookInfo.setScore(Boxing.boxFloat((miBookCommentItemList != null ? miBookCommentItemList.getScore() : 0.0f) * 10));
            if (miBookCommentItemList == null || (boxInt2 = miBookCommentItemList.getNStars()) == null) {
                boxInt2 = Boxing.boxInt(0);
            }
            mBookInfo.setNStars(boxInt2);
            mBookInfo.setHotCommentList(miBookCommentItemList != null ? miBookCommentItemList.getComments() : null);
            if (miBookCommentItemList != null && (comments = miBookCommentItemList.getComments()) != null) {
                Iterator<T> it = comments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (StringsKt.equals(MiConfigSingleton.b2().T1(), ((Comment) next).getCuid(), true)) {
                        comment = next;
                        break;
                    }
                }
                comment = comment;
            }
            mBookInfo.setMyComment(comment);
        }
        mutableLiveData = this.this$0._mBookScoresAndTopCommentsLiveData;
        mutableLiveData.postValue(this.this$0.getMBookInfo());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReaderCommentViewModel$getBookScoresAndTopComments$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
