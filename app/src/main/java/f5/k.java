package f5;

@a5.b(emulated = true)
@f
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a */
    public static final ThreadLocal<char[]> f25997a = new a();

    public class a extends ThreadLocal<char[]> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static char[] a() {
        return f25997a.get();
    }
}
