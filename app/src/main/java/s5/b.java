package s5;

import b5.p;
import com.google.common.collect.ImmutableMap;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import e5.f1;
import java.util.Deque;

@a5.b
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public static final p f30601a = p.p("");

    public static int a(Deque<CharSequence> deque, CharSequence charSequence, int i10, ImmutableMap.b<String, PublicSuffixType> bVar) {
        int length = charSequence.length();
        char c10 = 0;
        int i11 = i10;
        while (i11 < length && (c10 = charSequence.charAt(i11)) != '&' && c10 != '?' && c10 != '!' && c10 != ':' && c10 != ',') {
            i11++;
        }
        deque.push(c(charSequence.subSequence(i10, i11)));
        if (c10 == '!' || c10 == '?' || c10 == ':' || c10 == ',') {
            String k10 = f30601a.k(deque);
            if (k10.length() > 0) {
                bVar.i(k10, PublicSuffixType.fromCode(c10));
            }
        }
        int i12 = i11 + 1;
        if (c10 != '?' && c10 != ',') {
            while (i12 < length) {
                i12 += a(deque, charSequence, i12, bVar);
                if (charSequence.charAt(i12) == '?' || charSequence.charAt(i12) == ',') {
                    i12++;
                    break;
                }
            }
        }
        deque.pop();
        return i12 - i10;
    }

    public static ImmutableMap<String, PublicSuffixType> b(CharSequence charSequence) {
        ImmutableMap.b builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            i10 += a(f1.d(), charSequence, i10, builder);
        }
        return builder.d();
    }

    public static CharSequence c(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
