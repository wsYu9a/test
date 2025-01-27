package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a@\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"observe", "Landroidx/lifecycle/Observer;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "", "lifecycle-livedata-core-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LiveDataKt {
    @Deprecated(message = "This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"")
    @k
    @MainThread
    public static final <T> Observer<T> observe(@k LiveData<T> liveData, @k LifecycleOwner owner, @k Function1<? super T, Unit> onChanged) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        LiveDataKt$observe$wrappedObserver$1 liveDataKt$observe$wrappedObserver$1 = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            final /* synthetic */ Function1<T, Unit> $onChanged;

            /* JADX WARN: Multi-variable type inference failed */
            public LiveDataKt$observe$wrappedObserver$1(Function1<? super T, Unit> onChanged2) {
                onChanged = onChanged2;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t10) {
                onChanged.invoke(t10);
            }
        };
        liveData.observe(owner, liveDataKt$observe$wrappedObserver$1);
        return liveDataKt$observe$wrappedObserver$1;
    }
}
