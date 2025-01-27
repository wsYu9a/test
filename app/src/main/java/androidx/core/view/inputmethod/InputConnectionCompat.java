package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class InputConnectionCompat {
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    /* renamed from: a */
    private static final String f2147a = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* renamed from: b */
    private static final String f2148b = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* renamed from: c */
    private static final String f2149c = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* renamed from: d */
    private static final String f2150d = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* renamed from: e */
    private static final String f2151e = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* renamed from: f */
    private static final String f2152f = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* renamed from: g */
    private static final String f2153g = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* renamed from: h */
    private static final String f2154h = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* renamed from: i */
    private static final String f2155i = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";

    /* renamed from: j */
    private static final String f2156j = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String k = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String l = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String m = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String n = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";

    /* renamed from: androidx.core.view.inputmethod.InputConnectionCompat$1 */
    class AnonymousClass1 extends InputConnectionWrapper {

        /* renamed from: a */
        final /* synthetic */ OnCommitContentListener f2157a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InputConnection inputConnection, boolean z, OnCommitContentListener onCommitContentListener) {
            super(inputConnection, z);
            onCommitContentListener = onCommitContentListener;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
            if (onCommitContentListener.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i2, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i2, bundle);
        }
    }

    /* renamed from: androidx.core.view.inputmethod.InputConnectionCompat$2 */
    class AnonymousClass2 extends InputConnectionWrapper {

        /* renamed from: a */
        final /* synthetic */ OnCommitContentListener f2158a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(InputConnection inputConnection, boolean z, OnCommitContentListener onCommitContentListener) {
            super(inputConnection, z);
            onCommitContentListener = onCommitContentListener;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (InputConnectionCompat.a(str, bundle, onCommitContentListener)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean a(@Nullable String str, @NonNull Bundle bundle, @NonNull OnCommitContentListener onCommitContentListener) {
        boolean z;
        ResultReceiver resultReceiver;
        ?? r0 = 0;
        r0 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals(f2147a, str)) {
            z = false;
        } else {
            if (!TextUtils.equals(f2148b, str)) {
                return false;
            }
            z = true;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(z ? n : m);
        } catch (Throwable th) {
            th = th;
            resultReceiver = 0;
        }
        try {
            Uri uri = (Uri) bundle.getParcelable(z ? f2150d : f2149c);
            ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z ? f2152f : f2151e);
            Uri uri2 = (Uri) bundle.getParcelable(z ? f2154h : f2153g);
            int i2 = bundle.getInt(z ? l : k);
            Bundle bundle2 = (Bundle) bundle.getParcelable(z ? f2156j : f2155i);
            if (uri != null && clipDescription != null) {
                r0 = onCommitContentListener.onCommitContent(new InputContentInfoCompat(uri, clipDescription, uri2), i2, bundle2);
            }
            if (resultReceiver != 0) {
                resultReceiver.send(r0, null);
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
            if (resultReceiver != 0) {
                resultReceiver.send(0, null);
            }
            throw th;
        }
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i2, @Nullable Bundle bundle) {
        boolean z;
        ClipDescription description = inputContentInfoCompat.getDescription();
        String[] contentMimeTypes = EditorInfoCompat.getContentMimeTypes(editorInfo);
        int length = contentMimeTypes.length;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z = false;
                break;
            }
            if (description.hasMimeType(contentMimeTypes[i3])) {
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 25) {
            return inputConnection.commitContent((InputContentInfo) inputContentInfoCompat.unwrap(), i2, bundle);
        }
        int a2 = EditorInfoCompat.a(editorInfo);
        if (a2 == 2) {
            z2 = true;
        } else if (a2 != 3 && a2 != 4) {
            return false;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(z2 ? f2150d : f2149c, inputContentInfoCompat.getContentUri());
        bundle2.putParcelable(z2 ? f2152f : f2151e, inputContentInfoCompat.getDescription());
        bundle2.putParcelable(z2 ? f2154h : f2153g, inputContentInfoCompat.getLinkUri());
        bundle2.putInt(z2 ? l : k, i2);
        bundle2.putParcelable(z2 ? f2156j : f2155i, bundle);
        return inputConnection.performPrivateCommand(z2 ? f2148b : f2147a, bundle2);
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull OnCommitContentListener onCommitContentListener) {
        if (inputConnection == null) {
            throw new IllegalArgumentException("inputConnection must be non-null");
        }
        if (editorInfo == null) {
            throw new IllegalArgumentException("editorInfo must be non-null");
        }
        if (onCommitContentListener != null) {
            return Build.VERSION.SDK_INT >= 25 ? new InputConnectionWrapper(inputConnection, false) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.1

                /* renamed from: a */
                final /* synthetic */ OnCommitContentListener f2157a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(InputConnection inputConnection2, boolean z, OnCommitContentListener onCommitContentListener2) {
                    super(inputConnection2, z);
                    onCommitContentListener = onCommitContentListener2;
                }

                @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
                    if (onCommitContentListener.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i2, bundle)) {
                        return true;
                    }
                    return super.commitContent(inputContentInfo, i2, bundle);
                }
            } : EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0 ? inputConnection2 : new InputConnectionWrapper(inputConnection2, false) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.2

                /* renamed from: a */
                final /* synthetic */ OnCommitContentListener f2158a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(InputConnection inputConnection2, boolean z, OnCommitContentListener onCommitContentListener2) {
                    super(inputConnection2, z);
                    onCommitContentListener = onCommitContentListener2;
                }

                @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                public boolean performPrivateCommand(String str, Bundle bundle) {
                    if (InputConnectionCompat.a(str, bundle, onCommitContentListener)) {
                        return true;
                    }
                    return super.performPrivateCommand(str, bundle);
                }
            };
        }
        throw new IllegalArgumentException("onCommitContentListener must be non-null");
    }
}
