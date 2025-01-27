package af;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static final int f166c = 9;

    /* renamed from: d, reason: collision with root package name */
    public static final String f167d = "x";

    /* renamed from: a, reason: collision with root package name */
    public final int f168a;

    /* renamed from: b, reason: collision with root package name */
    public final int f169b;

    public c(int i10, int i11) {
        this.f168a = i10;
        this.f169b = i11;
    }

    public int a() {
        return this.f169b;
    }

    public int b() {
        return this.f168a;
    }

    public c c(float f10) {
        return new c((int) (this.f168a * f10), (int) (this.f169b * f10));
    }

    public c d(int i10) {
        return new c(this.f168a / i10, this.f169b / i10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(9);
        sb2.append(this.f168a);
        sb2.append("x");
        sb2.append(this.f169b);
        return sb2.toString();
    }

    public c(int i10, int i11, int i12) {
        if (i12 % TinkerReport.KEY_APPLIED_VERSION_CHECK == 0) {
            this.f168a = i10;
            this.f169b = i11;
        } else {
            this.f168a = i11;
            this.f169b = i10;
        }
    }
}
