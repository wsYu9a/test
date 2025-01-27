package com.martian.apptask.g;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes2.dex */
public class h {

    static class a extends com.martian.libcomm.utils.e {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message msg) {
            return false;
        }
    }

    public static void a(String url) {
        new a().a(url.replaceAll("__EVENT_TIME_START__", String.valueOf(System.currentTimeMillis())).replaceAll("__EVENT_TIME_END__", String.valueOf(System.currentTimeMillis())), null);
    }

    public static void b(List<String> urls) {
        if (urls == null || urls.isEmpty()) {
            return;
        }
        for (String str : urls) {
            if (!TextUtils.isEmpty(str)) {
                a(str);
            }
        }
        urls.clear();
    }
}
