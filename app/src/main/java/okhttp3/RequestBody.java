package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: classes.dex */
public abstract class RequestBody {

    /* renamed from: okhttp3.RequestBody$1 */
    class AnonymousClass1 extends RequestBody {
        final /* synthetic */ ByteString val$content;

        AnonymousClass1(ByteString byteString) {
            byteString = byteString;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return byteString.size();
        }

        @Override // okhttp3.RequestBody
        @Nullable
        public MediaType contentType() {
            return MediaType.this;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(byteString);
        }
    }

    /* renamed from: okhttp3.RequestBody$2 */
    class AnonymousClass2 extends RequestBody {
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ int val$offset;

        AnonymousClass2(int i2, byte[] bArr, int i3) {
            i3 = i2;
            bArr = bArr;
            i2 = i3;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return i3;
        }

        @Override // okhttp3.RequestBody
        @Nullable
        public MediaType contentType() {
            return MediaType.this;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(bArr, i2, i3);
        }
    }

    /* renamed from: okhttp3.RequestBody$3 */
    class AnonymousClass3 extends RequestBody {
        final /* synthetic */ File val$file;

        AnonymousClass3(File file) {
            file = file;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return file.length();
        }

        @Override // okhttp3.RequestBody
        @Nullable
        public MediaType contentType() {
            return MediaType.this;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(file);
                bufferedSink.writeAll(source);
            } finally {
                Util.closeQuietly(source);
            }
        }
    }

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(@Nullable MediaType mediaType, ByteString byteString) {
        return new RequestBody() { // from class: okhttp3.RequestBody.1
            final /* synthetic */ ByteString val$content;

            AnonymousClass1(ByteString byteString2) {
                byteString = byteString2;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            return new RequestBody() { // from class: okhttp3.RequestBody.2
                final /* synthetic */ int val$byteCount;
                final /* synthetic */ byte[] val$content;
                final /* synthetic */ int val$offset;

                AnonymousClass2(int i32, byte[] bArr2, int i22) {
                    i3 = i32;
                    bArr = bArr2;
                    i2 = i22;
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i3;
                }

                @Override // okhttp3.RequestBody
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(bArr, i2, i3);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(@Nullable MediaType mediaType, File file) {
        if (file != null) {
            return new RequestBody() { // from class: okhttp3.RequestBody.3
                final /* synthetic */ File val$file;

                AnonymousClass3(File file2) {
                    file = file2;
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Source source = null;
                    try {
                        source = Okio.source(file);
                        bufferedSink.writeAll(source);
                    } finally {
                        Util.closeQuietly(source);
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
