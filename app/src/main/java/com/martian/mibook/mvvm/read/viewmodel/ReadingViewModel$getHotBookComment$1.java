package com.martian.mibook.mvvm.read.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.GetCommentByScoreParams;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.repository.ReadingRepository;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.ArrayList;
import java.util.Collection;
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
@DebugMetadata(c = "com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel$getHotBookComment$1", f = "ReadingViewModel.kt", i = {}, l = {DownloadErrorCode.ERROR_CHECK_FILE_LENGTH_FAILED}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nReadingViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel$getHotBookComment$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1297:1\n766#2:1298\n857#2,2:1299\n1054#2:1301\n*S KotlinDebug\n*F\n+ 1 ReadingViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel$getHotBookComment$1\n*L\n1073#1:1298\n1073#1:1299,2\n1073#1:1301\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingViewModel$getHotBookComment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageSize;
    final /* synthetic */ GetCommentByScoreParams $params;
    int label;
    final /* synthetic */ ReadingViewModel this$0;

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n+ 2 ReadingViewModel.kt\ncom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel$getHotBookComment$1\n*L\n1#1,328:1\n1074#2,3:329\n*E\n"})
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return ComparisonsKt.compareValues(Boolean.valueOf(StringsKt.equals(MiConfigSingleton.b2().T1(), ((Comment) t11).getCuid(), true)), Boolean.valueOf(StringsKt.equals(MiConfigSingleton.b2().T1(), ((Comment) t10).getCuid(), true)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingViewModel$getHotBookComment$1(GetCommentByScoreParams getCommentByScoreParams, int i10, ReadingViewModel readingViewModel, Continuation<? super ReadingViewModel$getHotBookComment$1> continuation) {
        super(2, continuation);
        this.$params = getCommentByScoreParams;
        this.$pageSize = i10;
        this.this$0 = readingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingViewModel$getHotBookComment$1(this.$params, this.$pageSize, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        List<Comment> list;
        MutableLiveData mutableLiveData;
        List<Comment> commentList;
        List sortedWith;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            this.$params.setPageSize(this.$pageSize);
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
        ReadingViewModel readingViewModel = this.this$0;
        if (miBookGetCommentByScoreItemList != null && (commentList = miBookGetCommentByScoreItemList.getCommentList()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : commentList) {
                if (((Comment) obj2).getScore() > 60) {
                    arrayList.add(obj2);
                }
            }
            List take = CollectionsKt.take(arrayList, 3);
            if (take != null && (sortedWith = CollectionsKt.sortedWith(take, new a())) != null) {
                list = CollectionsKt.toMutableList((Collection) sortedWith);
                readingViewModel.G2(list);
                mutableLiveData = this.this$0._mHotCommentsLiveData;
                mutableLiveData.postValue(this.this$0.y0());
                return Unit.INSTANCE;
            }
        }
        list = null;
        readingViewModel.G2(list);
        mutableLiveData = this.this$0._mHotCommentsLiveData;
        mutableLiveData.postValue(this.this$0.y0());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingViewModel$getHotBookComment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
