package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class EditorInfoCompat {
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f2144a = new String[0];

    /* renamed from: b, reason: collision with root package name */
    private static final String f2145b = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2146c = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";

    @Deprecated
    public EditorInfoCompat() {
    }

    static int a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(f2145b);
        boolean containsKey2 = editorInfo.extras.containsKey(f2146c);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        return containsKey2 ? 2 : 0;
    }

    @NonNull
    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : f2144a;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f2144a;
        }
        String[] stringArray = bundle.getStringArray(f2145b);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(f2146c);
        }
        return stringArray != null ? stringArray : f2144a;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(f2145b, strArr);
        editorInfo.extras.putStringArray(f2146c, strArr);
    }
}
