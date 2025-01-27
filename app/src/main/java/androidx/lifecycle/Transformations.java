package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* loaded from: classes.dex */
public class Transformations {

    /* renamed from: androidx.lifecycle.Transformations$1 */
    static class AnonymousClass1<X> implements Observer<X> {

        /* renamed from: b */
        final /* synthetic */ Function f2648b;

        AnonymousClass1(Function function) {
            function = function;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable X x) {
            MediatorLiveData.this.setValue(function.apply(x));
        }
    }

    /* renamed from: androidx.lifecycle.Transformations$2 */
    static class AnonymousClass2<X> implements Observer<X> {

        /* renamed from: a */
        LiveData<Y> f2649a;

        /* renamed from: c */
        final /* synthetic */ MediatorLiveData f2651c;

        /* renamed from: androidx.lifecycle.Transformations$2$1 */
        class AnonymousClass1<Y> implements Observer<Y> {
            AnonymousClass1() {
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable Y y) {
                mediatorLiveData.setValue(y);
            }
        }

        AnonymousClass2(MediatorLiveData mediatorLiveData) {
            mediatorLiveData = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable X x) {
            LiveData<Y> liveData = (LiveData) Function.this.apply(x);
            Object obj = this.f2649a;
            if (obj == liveData) {
                return;
            }
            if (obj != null) {
                mediatorLiveData.removeSource(obj);
            }
            this.f2649a = liveData;
            if (liveData != 0) {
                mediatorLiveData.addSource(liveData, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                    AnonymousClass1() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public void onChanged(@Nullable Y y) {
                        mediatorLiveData.setValue(y);
                    }
                });
            }
        }
    }

    private Transformations() {
    }

    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1

            /* renamed from: b */
            final /* synthetic */ Function f2648b;

            AnonymousClass1(Function function2) {
                function = function2;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                MediatorLiveData.this.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }

    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull Function<X, LiveData<Y>> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2

            /* renamed from: a */
            LiveData<Y> f2649a;

            /* renamed from: c */
            final /* synthetic */ MediatorLiveData f2651c;

            /* renamed from: androidx.lifecycle.Transformations$2$1 */
            class AnonymousClass1<Y> implements Observer<Y> {
                AnonymousClass1() {
                }

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable Y y) {
                    mediatorLiveData.setValue(y);
                }
            }

            AnonymousClass2(MediatorLiveData mediatorLiveData2) {
                mediatorLiveData = mediatorLiveData2;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                LiveData<Y> liveData2 = (LiveData) Function.this.apply(x);
                Object obj = this.f2649a;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.f2649a = liveData2;
                if (liveData2 != 0) {
                    mediatorLiveData.addSource(liveData2, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        AnonymousClass1() {
                        }

                        @Override // androidx.lifecycle.Observer
                        public void onChanged(@Nullable Y y) {
                            mediatorLiveData.setValue(y);
                        }
                    });
                }
            }
        });
        return mediatorLiveData2;
    }
}
