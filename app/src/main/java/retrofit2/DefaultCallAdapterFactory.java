package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

/* loaded from: classes4.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {

    @Nullable
    private final Executor callbackExecutor;

    /* renamed from: retrofit2.DefaultCallAdapterFactory$1 */
    public class AnonymousClass1 implements CallAdapter<Object, Call<?>> {
        final /* synthetic */ Executor val$executor;
        final /* synthetic */ Type val$responseType;

        public AnonymousClass1(Type type, Executor executor) {
            parameterUpperBound = type;
            executor = executor;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return parameterUpperBound;
        }

        @Override // retrofit2.CallAdapter
        public Call<?> adapt(Call<Object> call) {
            Executor executor = executor;
            return executor == null ? call : new ExecutorCallbackCall(executor, call);
        }
    }

    public static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        /* renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1 */
        public class AnonymousClass1 implements Callback<T> {
            final /* synthetic */ Callback val$callback;

            public AnonymousClass1(Callback callback) {
                this.val$callback = callback;
            }

            public /* synthetic */ void lambda$onFailure$1(Callback callback, Throwable th2) {
                callback.onFailure(ExecutorCallbackCall.this, th2);
            }

            public /* synthetic */ void lambda$onResponse$0(Callback callback, Response response) {
                if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                    callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                } else {
                    callback.onResponse(ExecutorCallbackCall.this, response);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th2) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() { // from class: retrofit2.b

                    /* renamed from: c */
                    public final /* synthetic */ Callback f30419c;

                    /* renamed from: d */
                    public final /* synthetic */ Throwable f30420d;

                    public /* synthetic */ b(Callback callback, Throwable th22) {
                        callback = callback;
                        th2 = th22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this.lambda$onFailure$1(callback, th2);
                    }
                });
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() { // from class: retrofit2.a

                    /* renamed from: c */
                    public final /* synthetic */ Callback f30416c;

                    /* renamed from: d */
                    public final /* synthetic */ Response f30417d;

                    public /* synthetic */ a(Callback callback, Response response2) {
                        callback = callback;
                        response = response2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this.lambda$onResponse$0(callback, response);
                    }
                });
            }
        }

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        public void enqueue(Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new AnonymousClass1(callback));
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public Timeout timeout() {
            return this.delegate.timeout();
        }

        @Override // retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
                final /* synthetic */ Executor val$executor;
                final /* synthetic */ Type val$responseType;

                public AnonymousClass1(Type type2, Executor executor) {
                    parameterUpperBound = type2;
                    executor = executor;
                }

                @Override // retrofit2.CallAdapter
                public Type responseType() {
                    return parameterUpperBound;
                }

                @Override // retrofit2.CallAdapter
                public Call<?> adapt(Call<Object> call) {
                    Executor executor = executor;
                    return executor == null ? call : new ExecutorCallbackCall(executor, call);
                }
            };
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
