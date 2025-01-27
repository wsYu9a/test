package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class MessageCompat {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f1827a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1828b = true;

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22) {
            return message.isAsynchronous();
        }
        if (f1828b && i2 >= 16) {
            try {
                return message.isAsynchronous();
            } catch (NoSuchMethodError unused) {
                f1828b = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22) {
            message.setAsynchronous(z);
        } else {
            if (!f1827a || i2 < 16) {
                return;
            }
            try {
                message.setAsynchronous(z);
            } catch (NoSuchMethodError unused) {
                f1827a = false;
            }
        }
    }
}
