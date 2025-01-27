package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public final class ContentResolverCompat {

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
    }

    private ContentResolverCompat() {
    }

    @Nullable
    public static Cursor query(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2, @Nullable androidx.core.os.CancellationSignal cancellationSignal) {
        Object cancellationSignalObject;
        if (cancellationSignal != null) {
            try {
                cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
            } catch (Exception e10) {
                if (e10 instanceof OperationCanceledException) {
                    throw new androidx.core.os.OperationCanceledException();
                }
                throw e10;
            }
        } else {
            cancellationSignalObject = null;
        }
        return Api16Impl.query(contentResolver, uri, strArr, str, strArr2, str2, (CancellationSignal) cancellationSignalObject);
    }
}
