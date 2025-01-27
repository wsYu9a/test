package com.vivo.mobilead.model;

import com.vivo.mobad.BuildConfig;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static String f29551a = "https://ssp.vivo.com.cn";

    /* renamed from: b */
    public static String f29552b = f29551a + BuildConfig.configUrl;

    /* renamed from: c */
    public static String f29553c = f29551a + "/api/v3/reqAd";

    /* renamed from: com.vivo.mobilead.model.a$a */
    public enum EnumC0603a {
        LOADED(1),
        SHOW(2),
        CLICK(3),
        STARTPLAY(5),
        PLAYEND(9);


        /* renamed from: a */
        int f29560a;

        EnumC0603a(int i2) {
            this.f29560a = i2;
        }

        public int a() {
            return this.f29560a;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((EnumC0603a) obj);
        }
    }

    public static void a(String str) {
        f29551a = str;
        f29552b = f29551a + BuildConfig.configUrl;
        f29553c = f29551a + "/api/v3/reqAd";
    }
}
