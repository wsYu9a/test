package e2;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class c implements FileFilter {

    /* renamed from: a */
    public final /* synthetic */ b f25590a;

    public c(b bVar) {
        this.f25590a = bVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
