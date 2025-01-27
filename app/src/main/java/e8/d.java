package e8;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Map;
import p3.f;
import p3.i;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a */
    public String f25781a;

    /* renamed from: b */
    public String f25782b;

    /* renamed from: c */
    public String f25783c;

    public d(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            if (TextUtils.equals(str, i.f29756a)) {
                this.f25781a = map.get(str);
            } else if (TextUtils.equals(str, i.f29758c)) {
                this.f25782b = map.get(str);
            } else if (TextUtils.equals(str, i.f29757b)) {
                this.f25783c = map.get(str);
            }
        }
    }

    public String a() {
        return this.f25783c;
    }

    public String b() {
        return this.f25782b;
    }

    public String c() {
        return this.f25781a;
    }

    @NonNull
    public String toString() {
        return "resultStatus={" + this.f25781a + "};memo={" + this.f25783c + "};result={" + this.f25782b + f.f29748d;
    }
}
