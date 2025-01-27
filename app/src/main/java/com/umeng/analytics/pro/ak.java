package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ak {

    /* renamed from: a */
    private String f23403a;

    /* renamed from: b */
    private ArrayList<al> f23404b = new ArrayList<>();

    public ak(String str) {
        this.f23403a = "";
        this.f23403a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f23403a.contains(",")) {
                String str = this.f23403a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String trim = str.trim();
                if (this.f23404b != null) {
                    this.f23404b.add(new al(trim));
                    return;
                }
                return;
            }
            for (String str2 : this.f23403a.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    String trim2 = str2.trim();
                    if (this.f23404b != null) {
                        this.f23404b.add(new al(trim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i10) {
        try {
            ArrayList<al> arrayList = this.f23404b;
            if (arrayList == null) {
                return false;
            }
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                al alVar = this.f23404b.get(i11);
                if (alVar != null && alVar.a(i10)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
