package com.martian.mibook.mvvm.tts;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J/\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0014R\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R8\u0010\u0019\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0014R\b\u0012\u0004\u0012\u00028\u00000\u00000\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "observer", "", "observe", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V", "observeForever", "(Landroidx/lifecycle/Observer;)V", "removeObserver", "a", "value", "postValue", "(Ljava/lang/Object;)V", "setValue", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData$a;", "b", "(Landroidx/lifecycle/Observer;)Lcom/martian/mibook/mvvm/tts/NonStickyLiveData$a;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "observerMapping", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNonStickyLiveData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NonStickyLiveData.kt\ncom/martian/mibook/mvvm/tts/NonStickyLiveData\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,73:1\n215#2,2:74\n215#2,2:76\n*S KotlinDebug\n*F\n+ 1 NonStickyLiveData.kt\ncom/martian/mibook/mvvm/tts/NonStickyLiveData\n*L\n28#1:74,2\n39#1:76,2\n*E\n"})
/* loaded from: classes3.dex */
public final class NonStickyLiveData<T> extends MutableLiveData<T> {

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public final ConcurrentHashMap<Observer<? super T>, NonStickyLiveData<T>.a<T>> observerMapping = new ConcurrentHashMap<>();

    public final class a<T> implements Observer<T> {

        /* renamed from: b */
        @k
        public final Observer<? super T> f15000b;

        /* renamed from: c */
        public boolean f15001c;

        /* renamed from: d */
        public final /* synthetic */ NonStickyLiveData<T> f15002d;

        public a(@k NonStickyLiveData nonStickyLiveData, Observer<? super T> targetObserver) {
            Intrinsics.checkNotNullParameter(targetObserver, "targetObserver");
            this.f15002d = nonStickyLiveData;
            this.f15000b = targetObserver;
            this.f15001c = nonStickyLiveData.getValue() != null;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(T t10) {
            if (this.f15001c) {
                this.f15001c = false;
            } else {
                this.f15000b.onChanged(t10);
            }
        }
    }

    public final void a() {
        for (Map.Entry<Observer<? super T>, NonStickyLiveData<T>.a<T>> entry : this.observerMapping.entrySet()) {
            Observer<? super T> key = entry.getKey();
            entry.getValue();
            removeObserver(key);
        }
    }

    public final NonStickyLiveData<T>.a<T> b(Observer<? super T> observer) {
        NonStickyLiveData<T>.a<T> aVar = this.observerMapping.get(observer);
        if (aVar != null) {
            return aVar;
        }
        NonStickyLiveData<T>.a<T> aVar2 = new a<>(this, observer);
        this.observerMapping.put(observer, aVar2);
        return aVar2;
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@k LifecycleOwner owner, @k Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(owner, b(observer));
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(@k Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observeForever(b(observer));
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T value) {
        super.postValue(value);
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@k Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        NonStickyLiveData<T>.a<T> remove = this.observerMapping.remove(observer);
        if (remove != null) {
            super.removeObserver(remove);
            return;
        }
        for (Map.Entry<Observer<? super T>, NonStickyLiveData<T>.a<T>> entry : this.observerMapping.entrySet()) {
            Observer<? super T> key = entry.getKey();
            if (Intrinsics.areEqual(entry.getValue(), observer)) {
                this.observerMapping.remove(key);
            }
        }
        super.removeObserver(observer);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T value) {
        super.setValue(value);
    }
}
