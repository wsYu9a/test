package i8;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes3.dex */
public class h {

    public class a extends z8.e {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            return false;
        }
    }

    public static void a(String str) {
        new a().a(str.replaceAll("__EVENT_TIME_START__", String.valueOf(System.currentTimeMillis())).replaceAll("__EVENT_TIME_END__", String.valueOf(System.currentTimeMillis())), null);
    }

    public static void b(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(str);
            }
        }
        list.clear();
    }
}
