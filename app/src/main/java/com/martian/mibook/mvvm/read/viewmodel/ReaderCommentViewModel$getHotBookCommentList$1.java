package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.GetCommentByScoreParams;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$getHotBookCommentList$1", f = "ReaderCommentViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nReaderCommentViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReaderCommentViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$getHotBookCommentList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n1054#2:139\n*S KotlinDebug\n*F\n+ 1 ReaderCommentViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$getHotBookCommentList$1\n*L\n70#1:139\n*E\n"})
/* loaded from: classes3.dex */
public final class ReaderCommentViewModel$getHotBookCommentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetCommentByScoreParams $params;
    int label;
    final /* synthetic */ ReaderCommentViewModel this$0;

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n+ 2 ReaderCommentViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$getHotBookCommentList$1\n*L\n1#1,328:1\n71#2:329\n*E\n"})
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return ComparisonsKt.compareValues(Boolean.valueOf(StringsKt.equals(MiConfigSingleton.b2().T1(), ((Comment) t11).getCuid(), true)), Boolean.valueOf(StringsKt.equals(MiConfigSingleton.b2().T1(), ((Comment) t10).getCuid(), true)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderCommentViewModel$getHotBookCommentList$1(ReaderCommentViewModel readerCommentViewModel, GetCommentByScoreParams getCommentByScoreParams, Continuation<? super ReaderCommentViewModel$getHotBookCommentList$1> continuation) {
        super(2, continuation);
        this.this$0 = readerCommentViewModel;
        this.$params = getCommentByScoreParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReaderCommentViewModel$getHotBookCommentList$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        MutableLiveData mutableLiveData;
        List<Comment> commentList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            ReadingRepository f10 = this.this$0.f();
            Map<String, String> f11 = ExtKt.f(this.$params);
            this.label = 1;
            obj = f10.j(f11, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList = (MiBookGetCommentByScoreItemList) obj;
        Integer page = this.$params.getPage();
        List<Comment> list = null;
        if (page != null && page.intValue() == 0) {
            if (miBookGetCommentByScoreItemList != null && (commentList = miBookGetCommentByScoreItemList.getCommentList()) != null) {
                list = CollectionsKt.sortedWith(commentList, new a());
            }
        } else if (miBookGetCommentByScoreItemList != null) {
            list = miBookGetCommentByScoreItemList.getCommentList();
        }
        mutableLiveData = this.this$0._mBookHotCommentsLiveData;
        mutableLiveData.postValue(list);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReaderCommentViewModel$getHotBookCommentList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
