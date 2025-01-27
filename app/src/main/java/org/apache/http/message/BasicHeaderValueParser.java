package org.apache.http.message;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

@Immutable
/* loaded from: classes5.dex */
public class BasicHeaderValueParser implements HeaderValueParser {
    public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
    private static final char PARAM_DELIMITER = ';';
    private static final char ELEM_DELIMITER = ',';
    private static final char[] ALL_DELIMITERS = {PARAM_DELIMITER, ELEM_DELIMITER};

    private static boolean isOneOf(char c2, char[] cArr) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c2 == c3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final HeaderElement[] parseElements(String str, HeaderValueParser headerValueParser) throws ParseException {
        if (str == null) {
            throw new IllegalArgumentException("Value to parse may not be null");
        }
        if (headerValueParser == null) {
            headerValueParser = DEFAULT;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return headerValueParser.parseElements(charArrayBuffer, new ParserCursor(0, str.length()));
    }

    public static final HeaderElement parseHeaderElement(String str, HeaderValueParser headerValueParser) throws ParseException {
        if (str == null) {
            throw new IllegalArgumentException("Value to parse may not be null");
        }
        if (headerValueParser == null) {
            headerValueParser = DEFAULT;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return headerValueParser.parseHeaderElement(charArrayBuffer, new ParserCursor(0, str.length()));
    }

    public static final NameValuePair parseNameValuePair(String str, HeaderValueParser headerValueParser) throws ParseException {
        if (str == null) {
            throw new IllegalArgumentException("Value to parse may not be null");
        }
        if (headerValueParser == null) {
            headerValueParser = DEFAULT;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return headerValueParser.parseNameValuePair(charArrayBuffer, new ParserCursor(0, str.length()));
    }

    public static final NameValuePair[] parseParameters(String str, HeaderValueParser headerValueParser) throws ParseException {
        if (str == null) {
            throw new IllegalArgumentException("Value to parse may not be null");
        }
        if (headerValueParser == null) {
            headerValueParser = DEFAULT;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return headerValueParser.parseParameters(charArrayBuffer, new ParserCursor(0, str.length()));
    }

    protected HeaderElement createHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        return new BasicHeaderElement(str, str2, nameValuePairArr);
    }

    protected NameValuePair createNameValuePair(String str, String str2) {
        return new BasicNameValuePair(str, str2);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (parserCursor != null) {
            ArrayList arrayList = new ArrayList();
            while (!parserCursor.atEnd()) {
                HeaderElement parseHeaderElement = parseHeaderElement(charArrayBuffer, parserCursor);
                if (parseHeaderElement.getName().length() != 0 || parseHeaderElement.getValue() != null) {
                    arrayList.add(parseHeaderElement);
                }
            }
            return (HeaderElement[]) arrayList.toArray(new HeaderElement[arrayList.size()]);
        }
        throw new IllegalArgumentException("Parser cursor may not be null");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (parserCursor != null) {
            NameValuePair parseNameValuePair = parseNameValuePair(charArrayBuffer, parserCursor);
            NameValuePair[] nameValuePairArr = null;
            if (!parserCursor.atEnd() && charArrayBuffer.charAt(parserCursor.getPos() - 1) != ',') {
                nameValuePairArr = parseParameters(charArrayBuffer, parserCursor);
            }
            return createHeaderElement(parseNameValuePair.getName(), parseNameValuePair.getValue(), nameValuePairArr);
        }
        throw new IllegalArgumentException("Parser cursor may not be null");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        return parseNameValuePair(charArrayBuffer, parserCursor, ALL_DELIMITERS);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (parserCursor != null) {
            int pos = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
                pos++;
            }
            parserCursor.updatePos(pos);
            if (parserCursor.atEnd()) {
                return new NameValuePair[0];
            }
            ArrayList arrayList = new ArrayList();
            while (!parserCursor.atEnd()) {
                arrayList.add(parseNameValuePair(charArrayBuffer, parserCursor));
                if (charArrayBuffer.charAt(parserCursor.getPos() - 1) == ',') {
                    break;
                }
            }
            return (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]);
        }
        throw new IllegalArgumentException("Parser cursor may not be null");
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArr) {
        boolean z;
        boolean z2;
        String substringTrimmed;
        char charAt;
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (parserCursor != null) {
            int pos = parserCursor.getPos();
            int pos2 = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            while (true) {
                z = true;
                if (pos >= upperBound || (charAt = charArrayBuffer.charAt(pos)) == '=') {
                    break;
                }
                if (isOneOf(charAt, cArr)) {
                    z2 = true;
                    break;
                }
                pos++;
            }
            z2 = false;
            if (pos == upperBound) {
                substringTrimmed = charArrayBuffer.substringTrimmed(pos2, upperBound);
                z2 = true;
            } else {
                substringTrimmed = charArrayBuffer.substringTrimmed(pos2, pos);
                pos++;
            }
            if (z2) {
                parserCursor.updatePos(pos);
                return createNameValuePair(substringTrimmed, null);
            }
            int i2 = pos;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                if (i2 >= upperBound) {
                    z = z2;
                    break;
                }
                char charAt2 = charArrayBuffer.charAt(i2);
                if (charAt2 == '\"' && !z3) {
                    z4 = !z4;
                }
                if (!z4 && !z3 && isOneOf(charAt2, cArr)) {
                    break;
                }
                z3 = !z3 && z4 && charAt2 == '\\';
                i2++;
            }
            while (pos < i2 && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
                pos++;
            }
            int i3 = i2;
            while (i3 > pos && HTTP.isWhitespace(charArrayBuffer.charAt(i3 - 1))) {
                i3--;
            }
            if (i3 - pos >= 2 && charArrayBuffer.charAt(pos) == '\"' && charArrayBuffer.charAt(i3 - 1) == '\"') {
                pos++;
                i3--;
            }
            String substring = charArrayBuffer.substring(pos, i3);
            if (z) {
                i2++;
            }
            parserCursor.updatePos(i2);
            return createNameValuePair(substringTrimmed, substring);
        }
        throw new IllegalArgumentException("Parser cursor may not be null");
    }
}
