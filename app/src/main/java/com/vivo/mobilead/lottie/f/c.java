package com.vivo.mobilead.lottie.f;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class c implements com.vivo.mobilead.lottie.e {

    /* renamed from: a */
    private static final Set<String> f29433a = new HashSet();

    @Override // com.vivo.mobilead.lottie.e
    public void a(String str) {
        b(str, null);
    }

    @Override // com.vivo.mobilead.lottie.e
    public void a(String str, Throwable th) {
        Set<String> set = f29433a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    @Override // com.vivo.mobilead.lottie.e
    public void b(String str) {
        a(str, null);
    }

    public void b(String str, Throwable th) {
        if (com.vivo.mobilead.lottie.b.f29112a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
