package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import xi.k;

@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Okio {
    @k
    public static final Sink appendingSink(@k File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    @k
    public static final FileSystem asResourceFileSystem(@k ClassLoader classLoader) {
        return Okio__JvmOkioKt.asResourceFileSystem(classLoader);
    }

    @k
    @JvmName(name = "blackhole")
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @k
    public static final BufferedSink buffer(@k Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    @k
    public static final CipherSink cipherSink(@k Sink sink, @k Cipher cipher) {
        return Okio__JvmOkioKt.cipherSink(sink, cipher);
    }

    @k
    public static final CipherSource cipherSource(@k Source source, @k Cipher cipher) {
        return Okio__JvmOkioKt.cipherSource(source, cipher);
    }

    @k
    public static final HashingSink hashingSink(@k Sink sink, @k MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSink(sink, messageDigest);
    }

    @k
    public static final HashingSource hashingSource(@k Source source, @k MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSource(source, messageDigest);
    }

    public static final boolean isAndroidGetsocknameError(@k AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    @k
    public static final FileSystem openZip(@k FileSystem fileSystem, @k Path path) throws IOException {
        return Okio__JvmOkioKt.openZip(fileSystem, path);
    }

    @JvmOverloads
    @k
    public static final Sink sink(@k File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file);
    }

    @k
    public static final Source source(@k File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    public static final <T extends Closeable, R> R use(T t10, @k Function1<? super T, ? extends R> function1) {
        return (R) Okio__OkioKt.use(t10, function1);
    }

    @k
    public static final BufferedSource buffer(@k Source source) {
        return Okio__OkioKt.buffer(source);
    }

    @k
    public static final HashingSink hashingSink(@k Sink sink, @k Mac mac) {
        return Okio__JvmOkioKt.hashingSink(sink, mac);
    }

    @k
    public static final HashingSource hashingSource(@k Source source, @k Mac mac) {
        return Okio__JvmOkioKt.hashingSource(source, mac);
    }

    @JvmOverloads
    @k
    public static final Sink sink(@k File file, boolean z10) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z10);
    }

    @k
    public static final Source source(@k InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    @k
    public static final Sink sink(@k OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    @k
    public static final Source source(@k Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    @k
    public static final Sink sink(@k Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    @k
    @IgnoreJRERequirement
    public static final Source source(@k java.nio.file.Path path, @k OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }

    @k
    @IgnoreJRERequirement
    public static final Sink sink(@k java.nio.file.Path path, @k OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }
}
