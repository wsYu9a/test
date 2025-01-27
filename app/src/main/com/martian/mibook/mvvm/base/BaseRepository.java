package com.martian.mibook.mvvm.base;

import kotlin.jvm.internal.Intrinsics;
import uc.f;
import xi.k;

/* loaded from: classes3.dex */
public abstract class BaseRepository {
    public final <T> T a(@k Class<T> tClass) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        return (T) f.f().h(tClass);
    }

    public final <T> T b(@k Class<T> tClass) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        return (T) f.f().j(tClass);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object c(@xi.k kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super uc.d<T>>, ? extends java.lang.Object> r7, @xi.k kotlin.coroutines.Continuation<? super T> r8) throws java.lang.Exception {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.martian.mibook.mvvm.base.BaseRepository$request$1
            if (r0 == 0) goto L13
            r0 = r8
            com.martian.mibook.mvvm.base.BaseRepository$request$1 r0 = (com.martian.mibook.mvvm.base.BaseRepository$request$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.martian.mibook.mvvm.base.BaseRepository$request$1 r0 = new com.martian.mibook.mvvm.base.BaseRepository$request$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3d
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.label = r3
            java.lang.Object r8 = r7.invoke(r0)
            if (r8 != r1) goto L3d
            return r1
        L3d:
            uc.d r8 = (uc.d) r8
            long r0 = r8.j()
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L58
            uc.f r7 = uc.f.f()
            long r0 = r8.j()
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r2
            r7.f30990c = r0
        L58:
            boolean r7 = r8.k()
            if (r7 == 0) goto L63
            java.lang.Object r7 = r8.g()
            return r7
        L63:
            com.martian.mibook.mvvm.net.ErrorResult r7 = new com.martian.mibook.mvvm.net.ErrorResult
            int r1 = r8.h()
            java.lang.String r2 = r8.i()
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.base.BaseRepository.c(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object d(@xi.k kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super uc.d<T>>, ? extends java.lang.Object> r9, @xi.k kotlin.coroutines.Continuation<? super uc.d<T>> r10) throws java.lang.Exception {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.martian.mibook.mvvm.base.BaseRepository$request2$1
            if (r0 == 0) goto L13
            r0 = r10
            com.martian.mibook.mvvm.base.BaseRepository$request2$1 r0 = (com.martian.mibook.mvvm.base.BaseRepository$request2$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.martian.mibook.mvvm.base.BaseRepository$request2$1 r0 = new com.martian.mibook.mvvm.base.BaseRepository$request2$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r10)
            goto L3d
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.label = r3
            java.lang.Object r10 = r9.invoke(r0)
            if (r10 != r1) goto L3d
            return r1
        L3d:
            uc.d r10 = (uc.d) r10
            if (r10 == 0) goto L5b
            long r0 = r10.j()
            r2 = 0
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 <= 0) goto L5a
            uc.f r9 = uc.f.f()
            long r0 = r10.j()
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r2
            r9.f30990c = r0
        L5a:
            return r10
        L5b:
            com.martian.mibook.mvvm.net.ErrorResult r9 = new com.martian.mibook.mvvm.net.ErrorResult
            r6 = 4
            r7 = 0
            r3 = 100001(0x186a1, float:1.40131E-40)
            java.lang.String r4 = "未知错误"
            r5 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.base.BaseRepository.d(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
