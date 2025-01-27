package y5;

/* loaded from: classes2.dex */
public final class w extends t {
    @Override // y5.t
    /* renamed from: q */
    public v k(t5.k kVar) {
        String str;
        String c10 = t.c(kVar);
        if (!c10.startsWith("smsto:") && !c10.startsWith("SMSTO:") && !c10.startsWith("mmsto:") && !c10.startsWith("MMSTO:")) {
            return null;
        }
        String substring = c10.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str = null;
        }
        return new v(substring, (String) null, (String) null, str);
    }
}
