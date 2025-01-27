package com.vivo.mobilead.lottie.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private final List<String> f29394a;

    /* renamed from: b */
    private f f29395b;

    private e(e eVar) {
        this.f29394a = new ArrayList(eVar.f29394a);
        this.f29395b = eVar.f29395b;
    }

    public e(String... strArr) {
        this.f29394a = Arrays.asList(strArr);
    }

    private boolean b() {
        return this.f29394a.get(r0.size() - 1).equals("**");
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    public e a(f fVar) {
        e eVar = new e(this);
        eVar.f29395b = fVar;
        return eVar;
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f29394a.add(str);
        return eVar;
    }

    public f a() {
        return this.f29395b;
    }

    public boolean a(String str, int i2) {
        if (b(str)) {
            return true;
        }
        if (i2 >= this.f29394a.size()) {
            return false;
        }
        return this.f29394a.get(i2).equals(str) || this.f29394a.get(i2).equals("**") || this.f29394a.get(i2).equals("*");
    }

    public int b(String str, int i2) {
        if (b(str)) {
            return 0;
        }
        if (this.f29394a.get(i2).equals("**")) {
            return (i2 != this.f29394a.size() - 1 && this.f29394a.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean c(String str, int i2) {
        if (i2 >= this.f29394a.size()) {
            return false;
        }
        boolean z = i2 == this.f29394a.size() - 1;
        String str2 = this.f29394a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.f29394a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f29394a.get(i2 + 1).equals(str)) {
            return i2 == this.f29394a.size() + (-2) || (i2 == this.f29394a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i3 = i2 + 1;
        if (i3 < this.f29394a.size() - 1) {
            return false;
        }
        return this.f29394a.get(i3).equals(str);
    }

    public boolean d(String str, int i2) {
        return "__container".equals(str) || i2 < this.f29394a.size() - 1 || this.f29394a.get(i2).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f29394a);
        sb.append(",resolved=");
        sb.append(this.f29395b != null);
        sb.append('}');
        return sb.toString();
    }
}
