package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* loaded from: classes.dex */
public class Transformations {

    /* renamed from: androidx.lifecycle.Transformations$1 */
    public class AnonymousClass1<X> implements Observer<X> {
        final /* synthetic */ Function val$mapFunction;

        public AnonymousClass1(Function function) {
            function = function;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable X x10) {
            MediatorLiveData.this.setValue(function.apply(x10));
        }
    }

    /* renamed from: androidx.lifecycle.Transformations$2 */
    public class AnonymousClass2<X> implements Observer<X> {
        LiveData<Y> mSource;
        final /* synthetic */ MediatorLiveData val$result;

        /* renamed from: androidx.lifecycle.Transformations$2$1 */
        public class AnonymousClass1<Y> implements Observer<Y> {
            public AnonymousClass1() {
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable Y y10) {
                mediatorLiveData.setValue(y10);
            }
        }

        public AnonymousClass2(MediatorLiveData mediatorLiveData) {
            mediatorLiveData = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable X x10) {
            LiveData<Y> liveData = (LiveData) Function.this.apply(x10);
            Object obj = this.mSource;
            if (obj == liveData) {
                return;
            }
            if (obj != null) {
                mediatorLiveData.removeSource(obj);
            }
            this.mSource = liveData;
            if (liveData != 0) {
                mediatorLiveData.addSource(liveData, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                    public AnonymousClass1() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public void onChanged(@Nullable Y y10) {
                        mediatorLiveData.setValue(y10);
                    }
                });
            }
        }
    }

    /* renamed from: androidx.lifecycle.Transformations$3 */
    public class AnonymousClass3<X> implements Observer<X> {
        boolean mFirstTime = true;

        public AnonymousClass3() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(X x10) {
            T value = MediatorLiveData.this.getValue();
            if (this.mFirstTime || ((value == 0 && x10 != null) || !(value == 0 || value.equals(x10)))) {
                this.mFirstTime = false;
                MediatorLiveData.this.setValue(x10);
            }
        }
    }

    private Transformations() {
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            boolean mFirstTime = true;

            public AnonymousClass3() {
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x10) {
                T value = MediatorLiveData.this.getValue();
                if (this.mFirstTime || ((value == 0 && x10 != null) || !(value == 0 || value.equals(x10)))) {
                    this.mFirstTime = false;
                    MediatorLiveData.this.setValue(x10);
                }
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            final /* synthetic */ Function val$mapFunction;

            public AnonymousClass1(Function function2) {
                function = function2;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x10) {
                MediatorLiveData.this.setValue(function.apply(x10));
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull Function<X, LiveData<Y>> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            LiveData<Y> mSource;
            final /* synthetic */ MediatorLiveData val$result;

            /* renamed from: androidx.lifecycle.Transformations$2$1 */
            public class AnonymousClass1<Y> implements Observer<Y> {
                public AnonymousClass1() {
                }

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable Y y10) {
                    mediatorLiveData.setValue(y10);
                }
            }

            public AnonymousClass2(MediatorLiveData mediatorLiveData2) {
                mediatorLiveData = mediatorLiveData2;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x10) {
                LiveData<Y> liveData2 = (LiveData) Function.this.apply(x10);
                Object obj = this.mSource;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.mSource = liveData2;
                if (liveData2 != 0) {
                    mediatorLiveData.addSource(liveData2, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        public AnonymousClass1() {
                        }

                        @Override // androidx.lifecycle.Observer
                        public void onChanged(@Nullable Y y10) {
                            mediatorLiveData.setValue(y10);
                        }
                    });
                }
            }
        });
        return mediatorLiveData2;
    }
}
