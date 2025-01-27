package k5;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

@p
@a5.a
@a5.c
/* loaded from: classes2.dex */
public final class b0 implements FilenameFilter {

    /* renamed from: a */
    public final Pattern f27621a;

    public b0(String str) {
        this(Pattern.compile(str));
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.f27621a.matcher(str).matches();
    }

    public b0(Pattern pattern) {
        this.f27621a = (Pattern) b5.u.E(pattern);
    }
}
