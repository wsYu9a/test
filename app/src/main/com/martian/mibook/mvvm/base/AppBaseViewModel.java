package com.martian.mibook.mvvm.base;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.mvvm.base.BaseRepository;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.f;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.json.JSONException;
import retrofit2.HttpException;
import xi.k;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\b\u0010\tJl\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016\"\u0004\b\u0001\u0010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\f2'\u0010\u0015\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011¢\u0006\u0002\b\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J]\u0010\u001f\u001a\u00020\u001a2\u001c\u0010\u0015\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00192$\b\u0002\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0004¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001aH\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010.R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0-8\u0006¢\u0006\f\n\u0004\b0\u0010.\u001a\u0004\b1\u00102R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010.R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u001b0-8\u0006¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00102R\u001b\u00109\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u00108\u001a\u0004\b5\u0010\t¨\u0006:"}, d2 = {"Lcom/martian/mibook/mvvm/base/AppBaseViewModel;", "Lcom/martian/mibook/mvvm/base/BaseRepository;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "i", "()Lcom/martian/mibook/mvvm/base/BaseRepository;", "Lkotlinx/coroutines/CoroutineScope;", Constants.PARAM_SCOPE, "Lkotlin/coroutines/CoroutineContext;", f.X, "Lkotlinx/coroutines/CoroutineStart;", "start", "executeContext", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", e.f19025e, "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "c", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "Lkotlin/Function1;", "", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "error", "", "isLoading", "j", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Z)V", "onCleared", "()V", "", com.kwad.sdk.m.e.TAG, "(Ljava/lang/Throwable;)Lcom/martian/mibook/mvvm/net/ErrorResult;", "Lkotlinx/coroutines/CompletableJob;", "a", "Lkotlinx/coroutines/CompletableJob;", "mViewModelJob", "b", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_mLoadingLiveData", "d", "h", "()Landroidx/lifecycle/MutableLiveData;", "mLoadingLiveData", "_mErrorLiveData", "f", "g", "mErrorLiveData", "Lkotlin/Lazy;", "mDataRepository", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class AppBaseViewModel<T extends BaseRepository> extends AndroidViewModel {

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public final CompletableJob mViewModelJob;

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final CoroutineScope viewModelScope;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> _mLoadingLiveData;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Boolean> mLoadingLiveData;

    /* renamed from: e */
    @k
    public final MutableLiveData<ErrorResult> _mErrorLiveData;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mErrorLiveData;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy mDataRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBaseViewModel(@k Application application) {
        super(application);
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(application, "application");
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.mViewModelJob = Job$default;
        this.viewModelScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(Job$default));
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._mLoadingLiveData = mutableLiveData;
        this.mLoadingLiveData = mutableLiveData;
        MutableLiveData<ErrorResult> mutableLiveData2 = new MutableLiveData<>();
        this._mErrorLiveData = mutableLiveData2;
        this.mErrorLiveData = mutableLiveData2;
        this.mDataRepository = LazyKt.lazy(new Function0<T>(this) { // from class: com.martian.mibook.mvvm.base.AppBaseViewModel$mDataRepository$2
            final /* synthetic */ AppBaseViewModel<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AppBaseViewModel$mDataRepository$2(AppBaseViewModel<? extends T> this) {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final BaseRepository invoke() {
                return this.this$0.i();
            }
        });
    }

    public static /* synthetic */ Coroutine d(AppBaseViewModel appBaseViewModel, CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, CoroutineContext coroutineContext2, Function2 function2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i10 & 1) != 0) {
            coroutineScope = appBaseViewModel.viewModelScope;
        }
        CoroutineScope coroutineScope2 = coroutineScope;
        if ((i10 & 2) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        CoroutineContext coroutineContext3 = coroutineContext;
        if ((i10 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i10 & 8) != 0) {
            coroutineContext2 = Dispatchers.getMain();
        }
        return appBaseViewModel.c(coroutineScope2, coroutineContext3, coroutineStart2, coroutineContext2, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(AppBaseViewModel appBaseViewModel, Function1 function1, Function2 function2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
        }
        if ((i10 & 2) != 0) {
            function2 = new AppBaseViewModel$launch$1(null);
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        appBaseViewModel.j(function1, function2, z10);
    }

    @k
    public <T> Coroutine<T> c(@k CoroutineScope r82, @k CoroutineContext r92, @k CoroutineStart start, @k CoroutineContext executeContext, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r82, "scope");
        Intrinsics.checkNotNullParameter(r92, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(executeContext, "executeContext");
        Intrinsics.checkNotNullParameter(r12, "block");
        return Coroutine.INSTANCE.async(r82, r92, start, executeContext, r12);
    }

    public final ErrorResult e(Throwable th2) {
        return th2 instanceof ErrorResult ? (ErrorResult) th2 : th2 instanceof UnknownHostException ? new ErrorResult(-100002, "网络异常", null, 4, null) : th2 instanceof ConnectException ? new ErrorResult(-100002, "连接错误", null, 4, null) : th2 instanceof JSONException ? new ErrorResult(1000, "数据异常", null, 4, null) : th2 instanceof SocketTimeoutException ? new ErrorResult(1000, "连接超时", null, 4, null) : th2 instanceof HttpException ? new ErrorResult(1000, "网络错误", null, 4, null) : new ErrorResult(100001, "未知错误", null, 4, null);
    }

    @k
    public final T f() {
        return (T) this.mDataRepository.getValue();
    }

    @k
    public final MutableLiveData<ErrorResult> g() {
        return this.mErrorLiveData;
    }

    @k
    public final MutableLiveData<Boolean> h() {
        return this.mLoadingLiveData;
    }

    @k
    public abstract T i();

    public final void j(@k Function1<? super Continuation<? super Unit>, ? extends Object> r10, @k Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> error, boolean isLoading) {
        Intrinsics.checkNotNullParameter(r10, "block");
        Intrinsics.checkNotNullParameter(error, "error");
        d(this, null, null, null, null, new AppBaseViewModel$launch$2(r10, null), 15, null).onStart(Dispatchers.getMain(), new AppBaseViewModel$launch$3(isLoading, this, null)).onError(Dispatchers.getMain(), new AppBaseViewModel$launch$4(this, error, null)).onFinally(Dispatchers.getMain(), new AppBaseViewModel$launch$5(isLoading, this, null));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Job.DefaultImpls.cancel$default((Job) this.mViewModelJob, (CancellationException) null, 1, (Object) null);
    }
}
