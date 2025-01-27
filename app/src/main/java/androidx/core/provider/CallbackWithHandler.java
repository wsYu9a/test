package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

/* loaded from: classes.dex */
class CallbackWithHandler {

    @NonNull
    private final FontsContractCompat.FontRequestCallback mCallback;

    @NonNull
    private final Handler mCallbackHandler;

    /* renamed from: androidx.core.provider.CallbackWithHandler$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ Typeface val$typeface;

        public AnonymousClass1(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
            fontRequestCallback = fontRequestCallback;
            typeface = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            fontRequestCallback.onTypefaceRetrieved(typeface);
        }
    }

    /* renamed from: androidx.core.provider.CallbackWithHandler$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ int val$reason;

        public AnonymousClass2(FontsContractCompat.FontRequestCallback fontRequestCallback, int i10) {
            fontRequestCallback = fontRequestCallback;
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            fontRequestCallback.onTypefaceRequestFailed(i10);
        }
    }

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(int i10) {
        this.mCallbackHandler.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.2
            final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
            final /* synthetic */ int val$reason;

            public AnonymousClass2(FontsContractCompat.FontRequestCallback fontRequestCallback, int i102) {
                fontRequestCallback = fontRequestCallback;
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(i10);
            }
        });
    }

    private void onTypefaceRetrieved(@NonNull Typeface typeface) {
        this.mCallbackHandler.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.1
            final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
            final /* synthetic */ Typeface val$typeface;

            public AnonymousClass1(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface2) {
                fontRequestCallback = fontRequestCallback;
                typeface = typeface2;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(typeface);
            }
        });
    }

    public void onTypefaceResult(@NonNull FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = CalleeHandler.create();
    }
}
