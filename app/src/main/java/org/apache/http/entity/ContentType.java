package org.apache.http.entity;

import com.baidu.mobads.sdk.internal.am;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.protocol.HTTP;

@Immutable
/* loaded from: classes5.dex */
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML;
    public static final ContentType APPLICATION_FORM_URLENCODED;
    public static final ContentType APPLICATION_JSON;
    public static final ContentType APPLICATION_OCTET_STREAM;
    public static final ContentType APPLICATION_SVG_XML;
    public static final ContentType APPLICATION_XHTML_XML;
    public static final ContentType APPLICATION_XML;
    public static final ContentType DEFAULT_BINARY;
    public static final ContentType DEFAULT_TEXT;
    public static final ContentType MULTIPART_FORM_DATA;
    public static final ContentType TEXT_HTML;
    public static final ContentType TEXT_PLAIN;
    public static final ContentType TEXT_XML;
    public static final ContentType WILDCARD;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;

    static {
        Charset charset = Consts.ISO_8859_1;
        APPLICATION_ATOM_XML = create("application/atom+xml", charset);
        APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", charset);
        APPLICATION_JSON = create(am.f5520d, Consts.UTF_8);
        ContentType create = create("application/octet-stream", (Charset) null);
        APPLICATION_OCTET_STREAM = create;
        APPLICATION_SVG_XML = create("application/svg+xml", charset);
        APPLICATION_XHTML_XML = create("application/xhtml+xml", charset);
        APPLICATION_XML = create("application/xml", charset);
        MULTIPART_FORM_DATA = create("multipart/form-data", charset);
        TEXT_HTML = create("text/html", charset);
        ContentType create2 = create("text/plain", charset);
        TEXT_PLAIN = create2;
        TEXT_XML = create("text/xml", charset);
        WILDCARD = create("*/*", (Charset) null);
        DEFAULT_TEXT = create2;
        DEFAULT_BINARY = create;
    }

    ContentType(String str, Charset charset) {
        this.mimeType = str;
        this.charset = charset;
    }

    public static ContentType create(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        if (lowerCase.length() == 0) {
            throw new IllegalArgumentException("MIME type may not be empty");
        }
        if (valid(lowerCase)) {
            return new ContentType(lowerCase, charset);
        }
        throw new IllegalArgumentException("MIME type may not contain reserved characters");
    }

    public static ContentType get(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        Header contentType;
        if (httpEntity != null && (contentType = httpEntity.getContentType()) != null) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return create(elements[0]);
            }
        }
        return null;
    }

    public static ContentType getOrDefault(HttpEntity httpEntity) throws ParseException {
        ContentType contentType = get(httpEntity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType parse(String str) throws ParseException, UnsupportedCharsetException {
        if (str == null) {
            throw new IllegalArgumentException("Content type may not be null");
        }
        HeaderElement[] parseElements = BasicHeaderValueParser.parseElements(str, (HeaderValueParser) null);
        if (parseElements.length > 0) {
            return create(parseElements[0]);
        }
        throw new ParseException("Invalid content type: " + str);
    }

    private static boolean valid(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\"' || charAt == ',' || charAt == ';') {
                return false;
            }
        }
        return true;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mimeType);
        if (this.charset != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(this.charset.name());
        }
        return sb.toString();
    }

    public static ContentType create(String str) {
        return new ContentType(str, null);
    }

    public static ContentType create(String str, String str2) throws UnsupportedCharsetException {
        return create(str, str2 != null ? Charset.forName(str2) : null);
    }

    private static ContentType create(HeaderElement headerElement) {
        String name = headerElement.getName();
        NameValuePair parameterByName = headerElement.getParameterByName("charset");
        return create(name, parameterByName != null ? parameterByName.getValue() : null);
    }
}
