package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.data.book.MiBookGetCommentByTimeItemList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.GetCommentByTimeParams;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$getBookCommentList$1", f = "ReaderCommentViewModel.kt", i = {}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_IS_IN_EXTERNAL_PUBLIC_DIR}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReaderCommentViewModel$getBookCommentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetCommentByTimeParams $params;
    int label;
    final /* synthetic */ ReaderCommentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderCommentViewModel$getBookCommentList$1(ReaderCommentViewModel readerCommentViewModel, GetCommentByTimeParams getCommentByTimeParams, Continuation<? super ReaderCommentViewModel$getBookCommentList$1> continuation) {
        super(2, continuation);
        this.this$0 = readerCommentViewModel;
        this.$params = getCommentByTimeParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReaderCommentViewModel$getBookCommentList$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadingRepository f10 = this.this$0.f();
            Map<String, String> f11 = ExtKt.f(this.$params);
            this.label = 1;
            obj = f10.g(f11, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MiBookGetCommentByTimeItemList miBookGetCommentByTimeItemList = (MiBookGetCommentByTimeItemList) obj;
        List<Comment> commentList = miBookGetCommentByTimeItemList != null ? miBookGetCommentByTimeItemList.getCommentList() : null;
        mutableLiveData = this.this$0._mBookCommentsLiveData;
        mutableLiveData.postValue(commentList);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReaderCommentViewModel$getBookCommentList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
