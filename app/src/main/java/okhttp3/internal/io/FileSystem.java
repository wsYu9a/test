package okhttp3.internal.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.sigmob.sdk.base.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/io/FileSystem;", "", "appendingSink", "Lokio/Sink;", k.f18193y, "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "sink", "size", "", "source", "Lokio/Source;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FileSystem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @xi.k
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @xi.k
    @JvmField
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion;", "", "()V", "SYSTEM", "Lokhttp3/internal/io/FileSystem;", "SystemFileSystem", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion$SystemFileSystem;", "Lokhttp3/internal/io/FileSystem;", "()V", "appendingSink", "Lokio/Sink;", k.f18193y, "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "sink", "size", "", "source", "Lokio/Source;", "toString", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            @xi.k
            public Sink appendingSink(@xi.k File r22) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r22, "file");
                try {
                    return Okio.appendingSink(r22);
                } catch (FileNotFoundException unused) {
                    r22.getParentFile().mkdirs();
                    return Okio.appendingSink(r22);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(@xi.k File r32) throws IOException {
                Intrinsics.checkNotNullParameter(r32, "file");
                if (!r32.delete() && r32.exists()) {
                    throw new IOException(Intrinsics.stringPlus("failed to delete ", r32));
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(@xi.k File directory) throws IOException {
                Intrinsics.checkNotNullParameter(directory, "directory");
                File[] listFiles = directory.listFiles();
                if (listFiles == null) {
                    throw new IOException(Intrinsics.stringPlus("not a readable directory: ", directory));
                }
                int length = listFiles.length;
                int i10 = 0;
                while (i10 < length) {
                    File file = listFiles[i10];
                    i10++;
                    if (file.isDirectory()) {
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        deleteContents(file);
                    }
                    if (!file.delete()) {
                        throw new IOException(Intrinsics.stringPlus("failed to delete ", file));
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(@xi.k File r22) {
                Intrinsics.checkNotNullParameter(r22, "file");
                return r22.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(@xi.k File r42, @xi.k File r52) throws IOException {
                Intrinsics.checkNotNullParameter(r42, "from");
                Intrinsics.checkNotNullParameter(r52, "to");
                delete(r52);
                if (r42.renameTo(r52)) {
                    return;
                }
                throw new IOException("failed to rename " + r42 + " to " + r52);
            }

            @Override // okhttp3.internal.io.FileSystem
            @xi.k
            public Sink sink(@xi.k File r52) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r52, "file");
                try {
                    return Okio__JvmOkioKt.sink$default(r52, false, 1, null);
                } catch (FileNotFoundException unused) {
                    r52.getParentFile().mkdirs();
                    return Okio__JvmOkioKt.sink$default(r52, false, 1, null);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(@xi.k File r32) {
                Intrinsics.checkNotNullParameter(r32, "file");
                return r32.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            @xi.k
            public Source source(@xi.k File r22) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r22, "file");
                return Okio.source(r22);
            }

            @xi.k
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    @xi.k
    Sink appendingSink(@xi.k File r12) throws FileNotFoundException;

    void delete(@xi.k File r12) throws IOException;

    void deleteContents(@xi.k File directory) throws IOException;

    boolean exists(@xi.k File r12);

    void rename(@xi.k File r12, @xi.k File r22) throws IOException;

    @xi.k
    Sink sink(@xi.k File r12) throws FileNotFoundException;

    long size(@xi.k File r12);

    @xi.k
    Source source(@xi.k File r12) throws FileNotFoundException;
}
