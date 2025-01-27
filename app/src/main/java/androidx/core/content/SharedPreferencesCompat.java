package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

@Deprecated
/* loaded from: classes.dex */
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {

        /* renamed from: a, reason: collision with root package name */
        private static EditorCompat f1675a;

        /* renamed from: b, reason: collision with root package name */
        private final Helper f1676b = new Helper();

        private static class Helper {
            Helper() {
            }

            public void apply(@NonNull SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (f1675a == null) {
                f1675a = new EditorCompat();
            }
            return f1675a;
        }

        @Deprecated
        public void apply(@NonNull SharedPreferences.Editor editor) {
            this.f1676b.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
