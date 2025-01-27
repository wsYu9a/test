package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes5.dex */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    public BasicTokenIterator(HeaderIterator headerIterator) {
        if (headerIterator == null) {
            throw new IllegalArgumentException("Header iterator must not be null.");
        }
        this.headerIt = headerIterator;
        this.searchPos = findNext(-1);
    }

    protected String createToken(String str, int i2, int i3) {
        return str.substring(i2, i3);
    }

    protected int findNext(int i2) throws ParseException {
        int findTokenSeparator;
        if (i2 >= 0) {
            findTokenSeparator = findTokenSeparator(i2);
        } else {
            if (!this.headerIt.hasNext()) {
                return -1;
            }
            this.currentHeader = this.headerIt.nextHeader().getValue();
            findTokenSeparator = 0;
        }
        int findTokenStart = findTokenStart(findTokenSeparator);
        if (findTokenStart < 0) {
            this.currentToken = null;
            return -1;
        }
        int findTokenEnd = findTokenEnd(findTokenStart);
        this.currentToken = createToken(this.currentHeader, findTokenStart, findTokenEnd);
        return findTokenEnd;
    }

    protected int findTokenEnd(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Token start position must not be negative: " + i2);
        }
        int length = this.currentHeader.length();
        do {
            i2++;
            if (i2 >= length) {
                break;
            }
        } while (isTokenChar(this.currentHeader.charAt(i2)));
        return i2;
    }

    protected int findTokenSeparator(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Search position must not be negative: " + i2);
        }
        boolean z = false;
        int length = this.currentHeader.length();
        while (!z && i2 < length) {
            char charAt = this.currentHeader.charAt(i2);
            if (isTokenSeparator(charAt)) {
                z = true;
            } else {
                if (!isWhitespace(charAt)) {
                    if (isTokenChar(charAt)) {
                        throw new ParseException("Tokens without separator (pos " + i2 + "): " + this.currentHeader);
                    }
                    throw new ParseException("Invalid character after token (pos " + i2 + "): " + this.currentHeader);
                }
                i2++;
            }
        }
        return i2;
    }

    protected int findTokenStart(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Search position must not be negative: " + i2);
        }
        boolean z = false;
        while (!z) {
            String str = this.currentHeader;
            if (str == null) {
                break;
            }
            int length = str.length();
            while (!z && i2 < length) {
                char charAt = this.currentHeader.charAt(i2);
                if (isTokenSeparator(charAt) || isWhitespace(charAt)) {
                    i2++;
                } else {
                    if (!isTokenChar(this.currentHeader.charAt(i2))) {
                        throw new ParseException("Invalid character before token (pos " + i2 + "): " + this.currentHeader);
                    }
                    z = true;
                }
            }
            if (!z) {
                if (this.headerIt.hasNext()) {
                    this.currentHeader = this.headerIt.nextHeader().getValue();
                    i2 = 0;
                } else {
                    this.currentHeader = null;
                }
            }
        }
        if (z) {
            return i2;
        }
        return -1;
    }

    @Override // org.apache.http.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        return this.currentToken != null;
    }

    protected boolean isHttpSeparator(char c2) {
        return HTTP_SEPARATORS.indexOf(c2) >= 0;
    }

    protected boolean isTokenChar(char c2) {
        if (Character.isLetterOrDigit(c2)) {
            return true;
        }
        return (Character.isISOControl(c2) || isHttpSeparator(c2)) ? false : true;
    }

    protected boolean isTokenSeparator(char c2) {
        return c2 == ',';
    }

    protected boolean isWhitespace(char c2) {
        return c2 == '\t' || Character.isSpaceChar(c2);
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        return nextToken();
    }

    @Override // org.apache.http.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        String str = this.currentToken;
        if (str == null) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        this.searchPos = findNext(this.searchPos);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
