package com.martian.mibook.mvvm.ui.fragment;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.sigmob.sdk.videocache.sourcestorage.a;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1", f = "WebViewFragment.kt", i = {1, 1, 2}, l = {328, 332, 339}, m = "invokeSuspend", n = {"conn", a.f20681d, "bitmap"}, s = {"L$0", "I$0", "L$0"})
/* loaded from: classes3.dex */
public final class WebViewFragment$url2bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $url;
    int I$0;
    Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$1", f = "WebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$1 */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpURLConnection $conn;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpURLConnection httpURLConnection, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$conn = httpURLConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass1(this.$conn, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$conn.connect();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$2", f = "WebViewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$2 */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BufferedInputStream $bufferedInputStream;
        final /* synthetic */ InputStream $inputStream;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(BufferedInputStream bufferedInputStream, InputStream inputStream, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bufferedInputStream = bufferedInputStream;
            this.$inputStream = inputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass2(this.$bufferedInputStream, this.$inputStream, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$bufferedInputStream.close();
            this.$inputStream.close();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewFragment$url2bitmap$1(String str, Continuation<? super WebViewFragment$url2bitmap$1> continuation) {
        super(2, continuation);
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new WebViewFragment$url2bitmap$1(this.$url, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @xi.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@xi.k java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r0 = r7.L$0
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.io.IOException -> L1c
            r5 = r0
            goto L99
        L1c:
            r8 = move-exception
            goto L96
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L27:
            int r1 = r7.I$0
            java.lang.Object r3 = r7.L$0
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.io.IOException -> L1c
            goto L73
        L31:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.io.IOException -> L1c
            goto L51
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            java.net.URL r8 = new java.net.URL     // Catch: java.io.IOException -> L1c
            java.lang.String r1 = r7.$url     // Catch: java.io.IOException -> L1c
            r8.<init>(r1)     // Catch: java.io.IOException -> L1c
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.io.IOException -> L1c
            com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$conn$1 r6 = new com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$conn$1     // Catch: java.io.IOException -> L1c
            r6.<init>(r8, r5)     // Catch: java.io.IOException -> L1c
            r7.label = r4     // Catch: java.io.IOException -> L1c
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r7)     // Catch: java.io.IOException -> L1c
            if (r8 != r0) goto L51
            return r0
        L51:
            java.lang.String r1 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r1)     // Catch: java.io.IOException -> L1c
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch: java.io.IOException -> L1c
            int r1 = r8.getContentLength()     // Catch: java.io.IOException -> L1c
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.io.IOException -> L1c
            com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$1 r6 = new com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$1     // Catch: java.io.IOException -> L1c
            r6.<init>(r8, r5)     // Catch: java.io.IOException -> L1c
            r7.L$0 = r8     // Catch: java.io.IOException -> L1c
            r7.I$0 = r1     // Catch: java.io.IOException -> L1c
            r7.label = r3     // Catch: java.io.IOException -> L1c
            java.lang.Object r3 = kotlinx.coroutines.BuildersKt.withContext(r4, r6, r7)     // Catch: java.io.IOException -> L1c
            if (r3 != r0) goto L72
            return r0
        L72:
            r3 = r8
        L73:
            java.io.InputStream r8 = r3.getInputStream()     // Catch: java.io.IOException -> L1c
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> L1c
            r3.<init>(r8, r1)     // Catch: java.io.IOException -> L1c
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch: java.io.IOException -> L1c
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.io.IOException -> L1c
            com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$2 r6 = new com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1$2     // Catch: java.io.IOException -> L1c
            r6.<init>(r3, r8, r5)     // Catch: java.io.IOException -> L1c
            r7.L$0 = r1     // Catch: java.io.IOException -> L1c
            r7.label = r2     // Catch: java.io.IOException -> L1c
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r4, r6, r7)     // Catch: java.io.IOException -> L1c
            if (r8 != r0) goto L94
            return r0
        L94:
            r5 = r1
            goto L99
        L96:
            r8.printStackTrace()
        L99:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.ui.fragment.WebViewFragment$url2bitmap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Bitmap> continuation) {
        return ((WebViewFragment$url2bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
