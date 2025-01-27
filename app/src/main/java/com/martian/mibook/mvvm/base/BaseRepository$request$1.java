package com.martian.mibook.mvvm.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.base.BaseRepository", f = "BaseRepository.kt", i = {}, l = {28}, m = "request", n = {}, s = {})
/* loaded from: classes3.dex */
public final class BaseRepository$request$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRepository$request$1(BaseRepository baseRepository, Continuation<? super BaseRepository$request$1> continuation) {
        super(continuation);
        this.this$0 = baseRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
