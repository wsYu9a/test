package com.opos.exoplayer.core.f.h;

import android.text.Layout;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private String f18765a;

    /* renamed from: b */
    private String f18766b;

    /* renamed from: c */
    private List<String> f18767c;

    /* renamed from: d */
    private String f18768d;

    /* renamed from: e */
    private String f18769e;

    /* renamed from: f */
    private int f18770f;

    /* renamed from: g */
    private boolean f18771g;

    /* renamed from: h */
    private int f18772h;

    /* renamed from: i */
    private boolean f18773i;

    /* renamed from: j */
    private int f18774j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private Layout.Alignment p;

    public b() {
        a();
    }

    private static int a(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.f18765a.isEmpty() && this.f18766b.isEmpty() && this.f18767c.isEmpty() && this.f18768d.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int a2 = a(a(a(0, this.f18765a, str, 1073741824), this.f18766b, str2, 2), this.f18768d, str3, 4);
        if (a2 == -1 || !Arrays.asList(strArr).containsAll(this.f18767c)) {
            return 0;
        }
        return (this.f18767c.size() * 4) + a2;
    }

    public b a(int i2) {
        this.f18770f = i2;
        this.f18771g = true;
        return this;
    }

    public b a(boolean z) {
        this.k = z ? 1 : 0;
        return this;
    }

    public void a() {
        this.f18765a = "";
        this.f18766b = "";
        this.f18767c = Collections.emptyList();
        this.f18768d = "";
        this.f18769e = null;
        this.f18771g = false;
        this.f18773i = false;
        this.f18774j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.p = null;
    }

    public void a(String str) {
        this.f18765a = str;
    }

    public void a(String[] strArr) {
        this.f18767c = Arrays.asList(strArr);
    }

    public int b() {
        int i2 = this.l;
        if (i2 == -1 && this.m == -1) {
            return -1;
        }
        return (this.m == 1 ? 2 : 0) | (i2 == 1 ? 1 : 0);
    }

    public b b(int i2) {
        this.f18772h = i2;
        this.f18773i = true;
        return this;
    }

    public b b(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public void b(String str) {
        this.f18766b = str;
    }

    public b c(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public void c(String str) {
        this.f18768d = str;
    }

    public boolean c() {
        return this.f18774j == 1;
    }

    public b d(String str) {
        this.f18769e = u.d(str);
        return this;
    }

    public boolean d() {
        return this.k == 1;
    }

    public String e() {
        return this.f18769e;
    }

    public int f() {
        if (this.f18771g) {
            return this.f18770f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public boolean g() {
        return this.f18771g;
    }

    public int h() {
        if (this.f18773i) {
            return this.f18772h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean i() {
        return this.f18773i;
    }

    public Layout.Alignment j() {
        return this.p;
    }

    public int k() {
        return this.n;
    }

    public float l() {
        return this.o;
    }
}
