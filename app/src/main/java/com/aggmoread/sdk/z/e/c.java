package com.aggmoread.sdk.z.e;

import android.text.TextUtils;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.p.a;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    public static class a implements a.g {

        /* renamed from: a */
        final /* synthetic */ String f6152a;

        public a(String str) {
            this.f6152a = str;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, e eVar) {
            d.a("RS_REPORT", "reportUrl %s", this.f6152a);
            d.a("RS_REPORT", "statusCode %s, e %s", Integer.valueOf(i10), eVar);
        }
    }

    private static void a(String str) {
        com.aggmoread.sdk.z.b.p.a.a(str, null, new a(str));
    }

    public static void a(List<String> list) {
        if (list == null || list.size() == 0) {
            d.c("RS_REPORT", "report urls is empty！");
            return;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10);
            if (!TextUtils.isEmpty(str)) {
                a(str);
            }
        }
    }
}
