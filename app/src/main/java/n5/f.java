package n5;

@a5.b
@b
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a */
    public final String f28778a;

    /* renamed from: b */
    public final int f28779b;

    public f(String str, int i10) {
        this.f28778a = str;
        this.f28779b = i10;
    }

    public static f a(String str) {
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char charAt = str.charAt(0);
        int i10 = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (charAt == '#') {
            str = str.substring(1);
        } else if (charAt != '0' || str.length() <= 1) {
            i10 = 10;
        } else {
            str = str.substring(1);
            i10 = 8;
        }
        return new f(str, i10);
    }
}
