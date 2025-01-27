package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean> {
    final MaybeSource<T> source;

    public static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super Boolean> downstream;
        Disposable upstream;

        public IsEmptyMaybeObserver(SingleObserver<? super Boolean> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(Boolean.TRUE);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t10) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(Boolean.FALSE);
        }
    }

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToMaybe
    public Maybe<Boolean> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmpty(this.source));
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new IsEmptyMaybeObserver(singleObserver));
    }
}
