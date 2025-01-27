package com.martian.mibook.mvvm.tts;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0004J\u001f\u0010\u0010\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00000\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/martian/mibook/mvvm/tts/ServiceLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "observer", "", "observe", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V", "", "a", "(Landroidx/lifecycle/LifecycleOwner;)Z", "b", "removeObserver", "(Landroidx/lifecycle/Observer;)V", "removeObservers", "(Landroidx/lifecycle/LifecycleOwner;)V", "", "Lcom/martian/mibook/mvvm/tts/ServiceLiveData$a;", "Ljava/util/List;", "observers", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nServiceLiveData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServiceLiveData.kt\ncom/martian/mibook/mvvm/tts/ServiceLiveData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n288#2,2:50\n1855#2,2:52\n*S KotlinDebug\n*F\n+ 1 ServiceLiveData.kt\ncom/martian/mibook/mvvm/tts/ServiceLiveData\n*L\n16#1:50,2\n31#1:52,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ServiceLiveData<T> extends MutableLiveData<T> {

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public final List<ServiceLiveData<T>.a<T>> observers = new ArrayList();

    public final boolean a(@k LifecycleOwner owner) {
        T t10;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Iterator<T> it = this.observers.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = (T) null;
                break;
            }
            t10 = it.next();
            if (Intrinsics.areEqual(((a) t10).b(), owner)) {
                break;
            }
        }
        return t10 != null;
    }

    public final void b() {
        Iterator<ServiceLiveData<T>.a<T>> it = this.observers.iterator();
        while (it.hasNext()) {
            super.removeObserver(it.next().a());
        }
        this.observers.clear();
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@k LifecycleOwner owner, @k Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(owner, observer);
        this.observers.add(new a<>(this, observer, owner));
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@k Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.removeObserver(observer);
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (Intrinsics.areEqual(aVar.a(), observer)) {
                this.observers.remove(aVar);
                return;
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObservers(@k LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.removeObservers(owner);
        this.observers.clear();
    }

    public final class a<T> {

        /* renamed from: a */
        @k
        public final Observer<? super T> f15027a;

        /* renamed from: b */
        @l
        public final LifecycleOwner f15028b;

        /* renamed from: c */
        public final /* synthetic */ ServiceLiveData<T> f15029c;

        public a(@k ServiceLiveData serviceLiveData, @l Observer<? super T> observer, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.f15029c = serviceLiveData;
            this.f15027a = observer;
            this.f15028b = lifecycleOwner;
        }

        @k
        public final Observer<? super T> a() {
            return this.f15027a;
        }

        @l
        public final LifecycleOwner b() {
            return this.f15028b;
        }

        public /* synthetic */ a(ServiceLiveData serviceLiveData, Observer observer, LifecycleOwner lifecycleOwner, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(serviceLiveData, observer, (i10 & 2) != 0 ? null : lifecycleOwner);
        }
    }
}
