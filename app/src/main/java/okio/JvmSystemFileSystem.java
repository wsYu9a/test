package okio;

import c7.g;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import t8.a;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\f\u0010!\u001a\u00020\n*\u00020\u0006H\u0002J\f\u0010\"\u001a\u00020\n*\u00020\u0006H\u0002¨\u0006#"}, d2 = {"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "()V", "appendingSink", "Lokio/Sink;", k.f18193y, "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", a.f30751f, "createDirectory", "dir", "mustCreate", "createSymlink", "delete", g.f1745c, "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "", "requireCreate", "requireExist", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class JvmSystemFileSystem extends FileSystem {
    private final void requireCreate(Path path) {
        if (exists(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void requireExist(Path path) {
        if (exists(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }

    @Override // okio.FileSystem
    @xi.k
    public Sink appendingSink(@xi.k Path r22, boolean mustExist) {
        Intrinsics.checkNotNullParameter(r22, "file");
        if (mustExist) {
            requireExist(r22);
        }
        return Okio.sink(r22.toFile(), true);
    }

    @Override // okio.FileSystem
    public void atomicMove(@xi.k Path source, @xi.k Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.FileSystem
    @xi.k
    public Path canonicalize(@xi.k Path r52) {
        Intrinsics.checkNotNullParameter(r52, "path");
        File canonicalFile = r52.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        Path.Companion companion = Path.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(canonicalFile, "canonicalFile");
        return Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
    }

    @Override // okio.FileSystem
    public void createDirectory(@xi.k Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        FileMetadata metadataOrNull = metadataOrNull(dir);
        if (metadataOrNull == null || !metadataOrNull.getIsDirectory()) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (mustCreate) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // okio.FileSystem
    public void createSymlink(@xi.k Path source, @xi.k Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.FileSystem
    public void delete(@xi.k Path r32, boolean mustExist) {
        Intrinsics.checkNotNullParameter(r32, "path");
        File file = r32.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + r32);
        }
        if (mustExist) {
            throw new FileNotFoundException("no such file: " + r32);
        }
    }

    @Override // okio.FileSystem
    @xi.k
    public List<Path> list(@xi.k Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<Path> list = list(dir, true);
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // okio.FileSystem
    @l
    public List<Path> listOrNull(@xi.k Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return list(dir, false);
    }

    @Override // okio.FileSystem
    @l
    public FileMetadata metadataOrNull(@xi.k Path r13) {
        Intrinsics.checkNotNullParameter(r13, "path");
        File file = r13.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (isFile || isDirectory || lastModified != 0 || length != 0 || file.exists()) {
            return new FileMetadata(isFile, isDirectory, null, Long.valueOf(length), null, Long.valueOf(lastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // okio.FileSystem
    @xi.k
    public FileHandle openReadOnly(@xi.k Path r42) {
        Intrinsics.checkNotNullParameter(r42, "file");
        return new JvmFileHandle(false, new RandomAccessFile(r42.toFile(), t.f11211k));
    }

    @Override // okio.FileSystem
    @xi.k
    public FileHandle openReadWrite(@xi.k Path r22, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter(r22, "file");
        if (mustCreate && mustExist) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
        }
        if (mustCreate) {
            requireCreate(r22);
        }
        if (mustExist) {
            requireExist(r22);
        }
        return new JvmFileHandle(true, new RandomAccessFile(r22.toFile(), "rw"));
    }

    @Override // okio.FileSystem
    @xi.k
    public Sink sink(@xi.k Path r32, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(r32, "file");
        if (mustCreate) {
            requireCreate(r32);
        }
        return Okio__JvmOkioKt.sink$default(r32.toFile(), false, 1, null);
    }

    @Override // okio.FileSystem
    @xi.k
    public Source source(@xi.k Path r22) {
        Intrinsics.checkNotNullParameter(r22, "file");
        return Okio.source(r22.toFile());
    }

    @xi.k
    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final List<Path> list(Path path, boolean z10) {
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(path.resolve(it));
            }
            CollectionsKt.sort(arrayList);
            return arrayList;
        }
        if (!z10) {
            return null;
        }
        if (file.exists()) {
            throw new IOException("failed to list " + path);
        }
        throw new FileNotFoundException("no such file: " + path);
    }
}
