package b.i.a.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes4.dex */
class a implements XmlSerializer {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f5079a;

    /* renamed from: c, reason: collision with root package name */
    private int f5081c;

    /* renamed from: d, reason: collision with root package name */
    private Writer f5082d;

    /* renamed from: e, reason: collision with root package name */
    private OutputStream f5083e;

    /* renamed from: f, reason: collision with root package name */
    private CharsetEncoder f5084f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5086h;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f5080b = new char[8192];

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer f5085g = ByteBuffer.allocate(8192);

    static {
        String[] strArr = new String[64];
        strArr[34] = "&quot;";
        strArr[38] = "&amp;";
        strArr[60] = "&lt;";
        strArr[62] = "&gt;";
        f5079a = strArr;
    }

    a() {
    }

    private void a(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f5079a;
        char length2 = (char) strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i3 < i2) {
                    b(str, i3, i2 - i3);
                }
                i3 = i2 + 1;
                e(str2);
            }
            i2++;
        }
        if (i3 < i2) {
            b(str, i3, i2 - i3);
        }
    }

    private void b(String str, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i2 + i3;
            while (i2 < i4) {
                int i5 = i2 + 8192;
                b(str, i2, i5 < i4 ? 8192 : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.f5081c;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.f5081c;
        }
        str.getChars(i2, i2 + i3, this.f5080b, i6);
        this.f5081c = i6 + i3;
    }

    private void c(char[] cArr, int i2, int i3) throws IOException {
        String str;
        String[] strArr = f5079a;
        char length = (char) strArr.length;
        int i4 = i3 + i2;
        int i5 = i2;
        while (i2 < i4) {
            char c2 = cArr[i2];
            if (c2 < length && (str = strArr[c2]) != null) {
                if (i5 < i2) {
                    f(cArr, i5, i2 - i5);
                }
                i5 = i2 + 1;
                e(str);
            }
            i2++;
        }
        if (i5 < i2) {
            f(cArr, i5, i2 - i5);
        }
    }

    private void d(char c2) throws IOException {
        int i2 = this.f5081c;
        if (i2 >= 8191) {
            flush();
            i2 = this.f5081c;
        }
        this.f5080b[i2] = c2;
        this.f5081c = i2 + 1;
    }

    private void e(String str) throws IOException {
        b(str, 0, str.length());
    }

    private void f(char[] cArr, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i2 + i3;
            while (i2 < i4) {
                int i5 = i2 + 8192;
                f(cArr, i2, i5 < i4 ? 8192 : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.f5081c;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.f5081c;
        }
        System.arraycopy(cArr, i2, this.f5080b, i6, i3);
        this.f5081c = i6 + i3;
    }

    private void g() throws IOException {
        int position = this.f5085g.position();
        if (position > 0) {
            this.f5085g.flip();
            this.f5083e.write(this.f5085g.array(), 0, position);
            this.f5085g.clear();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        d(' ');
        if (str != null) {
            e(str);
            d(':');
        }
        e(str2);
        e("=\"");
        a(str3);
        d(Typography.quote);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f5086h) {
            e(" />\n");
        } else {
            e("</");
            if (str != null) {
                e(str);
                d(':');
            }
            e(str2);
            e(">\n");
        }
        this.f5086h = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        int i2 = this.f5081c;
        if (i2 > 0) {
            if (this.f5083e != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f5080b, 0, i2);
                CoderResult encode = this.f5084f.encode(wrap, this.f5085g, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        g();
                        encode = this.f5084f.encode(wrap, this.f5085g, true);
                    } else {
                        g();
                        this.f5083e.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f5082d.write(this.f5080b, 0, i2);
            this.f5082d.flush();
            this.f5081c = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f5084f = Charset.forName(str).newEncoder();
            this.f5083e = outputStream;
        } catch (IllegalCharsetNameException e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        } catch (UnsupportedCharsetException e3) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e3));
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        e(sb.toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f5086h) {
            e(">\n");
        }
        d(Typography.less);
        if (str != null) {
            e(str);
            d(':');
        }
        e(str2);
        this.f5086h = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f5086h) {
            e(">");
            this.f5086h = false;
        }
        c(cArr, i2, i3);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f5086h) {
            e(">");
            this.f5086h = false;
        }
        a(str);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f5082d = writer;
    }
}
