package yi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Objects;
import org.mozilla.universalchardet.UniversalDetector;

/* loaded from: classes4.dex */
public final class e {
    public e() {
        throw new AssertionError("No instances allowed");
    }

    public static BufferedReader a(File file) throws IOException {
        return b(file, Charset.defaultCharset());
    }

    public static BufferedReader b(File file, Charset charset) throws IOException {
        Path path;
        InputStream newInputStream;
        Path path2;
        BufferedReader newBufferedReader;
        Objects.requireNonNull(charset, "defaultCharset must be not null");
        String b10 = UniversalDetector.b(file);
        if (b10 != null) {
            charset = Charset.forName(b10);
        }
        if (charset.name().contains("UTF")) {
            path = file.toPath();
            newInputStream = Files.newInputStream(path, new OpenOption[0]);
            return new BufferedReader(new InputStreamReader(new f(new BufferedInputStream(newInputStream)), charset));
        }
        path2 = file.toPath();
        newBufferedReader = Files.newBufferedReader(path2, charset);
        return newBufferedReader;
    }

    @Deprecated
    public static Reader c(File file) throws IOException {
        return d(file, Charset.defaultCharset());
    }

    @Deprecated
    public static Reader d(File file, Charset charset) throws IOException {
        return b(file, charset);
    }
}
