package okio;

import com.tencent.open.SocialConstants;
import f.b.a.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\u0002\u0010\t\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\b¢\u0006\u0004\b\u0006\u0010\n\u001a\u001d\u0010\u0002\u001a\u00020\u0001*\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0002\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0001*\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u000b¢\u0006\u0004\b\u0006\u0010\u0011\u001a'\u0010\u0002\u001a\u00020\u0001*\u00020\u00122\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0004\b\u0002\u0010\u0016\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00122\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0004\b\u0006\u0010\u0017\"\u001e\u0010\u001a\u001a\u00020\f*\u00060\u0018j\u0002`\u00198@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ljava/io/OutputStream;", "Lokio/Sink;", "sink", "(Ljava/io/OutputStream;)Lokio/Sink;", "Ljava/io/InputStream;", "Lokio/Source;", SocialConstants.PARAM_SOURCE, "(Ljava/io/InputStream;)Lokio/Source;", "Ljava/net/Socket;", "(Ljava/net/Socket;)Lokio/Sink;", "(Ljava/net/Socket;)Lokio/Source;", "Ljava/io/File;", "", "append", "(Ljava/io/File;Z)Lokio/Sink;", "appendingSink", "(Ljava/io/File;)Lokio/Sink;", "(Ljava/io/File;)Lokio/Source;", "Ljava/nio/file/Path;", "", "Ljava/nio/file/OpenOption;", "options", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "isAndroidGetsocknameError", "(Ljava/lang/AssertionError;)Z", "okio"}, k = 5, mv = {1, 4, 0}, xs = "okio/Okio")
/* loaded from: classes5.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    @d
    public static final Sink appendingSink(@d File appendingSink) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(appendingSink, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(appendingSink, true));
    }

    public static final boolean isAndroidGetsocknameError(@d AssertionError isAndroidGetsocknameError) {
        Intrinsics.checkParameterIsNotNull(isAndroidGetsocknameError, "$this$isAndroidGetsocknameError");
        if (isAndroidGetsocknameError.getCause() == null) {
            return false;
        }
        String message = isAndroidGetsocknameError.getMessage();
        return message != null ? StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    @d
    @JvmOverloads
    public static final Sink sink(@d File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    @d
    public static final Sink sink(@d OutputStream sink) {
        Intrinsics.checkParameterIsNotNull(sink, "$this$sink");
        return new sink(sink, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i2, Object obj) throws FileNotFoundException {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    @d
    public static final Source source(@d InputStream source) {
        Intrinsics.checkParameterIsNotNull(source, "$this$source");
        return new source(source, new Timeout());
    }

    @d
    public static final Sink sink(@d Socket sink) throws IOException {
        Intrinsics.checkParameterIsNotNull(sink, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(sink);
        OutputStream outputStream = sink.getOutputStream();
        Intrinsics.checkExpressionValueIsNotNull(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new sink(outputStream, socketAsyncTimeout));
    }

    @d
    public static final Source source(@d Socket source) throws IOException {
        Intrinsics.checkParameterIsNotNull(source, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(source);
        InputStream inputStream = source.getInputStream();
        Intrinsics.checkExpressionValueIsNotNull(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new source(inputStream, socketAsyncTimeout));
    }

    @d
    @JvmOverloads
    public static final Sink sink(@d File sink, boolean z) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(sink, "$this$sink");
        return Okio.sink(new FileOutputStream(sink, z));
    }

    @d
    public static final Source source(@d File source) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(source, "$this$source");
        return Okio.source(new FileInputStream(source));
    }

    @d
    @IgnoreJRERequirement
    public static final Sink sink(@d Path sink, @d OpenOption... options) throws IOException {
        Intrinsics.checkParameterIsNotNull(sink, "$this$sink");
        Intrinsics.checkParameterIsNotNull(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(sink, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkExpressionValueIsNotNull(newOutputStream, "Files.newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }

    @d
    @IgnoreJRERequirement
    public static final Source source(@d Path source, @d OpenOption... options) throws IOException {
        Intrinsics.checkParameterIsNotNull(source, "$this$source");
        Intrinsics.checkParameterIsNotNull(options, "options");
        InputStream newInputStream = Files.newInputStream(source, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkExpressionValueIsNotNull(newInputStream, "Files.newInputStream(this, *options)");
        return Okio.source(newInputStream);
    }
}
