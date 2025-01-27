package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.CommentFrame;
import com.opos.exoplayer.core.metadata.id3.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a */
    public static final a.InterfaceC0417a f18309a = new a.InterfaceC0417a() { // from class: com.opos.exoplayer.core.c.i.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.metadata.id3.a.InterfaceC0417a
        public boolean a(int i2, int i3, int i4, int i5, int i6) {
            return i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2);
        }
    };

    /* renamed from: d */
    private static final Pattern f18310d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: b */
    public int f18311b = -1;

    /* renamed from: c */
    public int f18312c = -1;

    /* renamed from: com.opos.exoplayer.core.c.i$1 */
    static final class AnonymousClass1 implements a.InterfaceC0417a {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.metadata.id3.a.InterfaceC0417a
        public boolean a(int i2, int i3, int i4, int i5, int i6) {
            return i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2);
        }
    }

    private boolean a(String str, String str2) {
        if ("iTunSMPB".equals(str)) {
            Matcher matcher = f18310d.matcher(str2);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1), 16);
                    int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                    if (parseInt > 0 || parseInt2 > 0) {
                        this.f18311b = parseInt;
                        this.f18312c = parseInt2;
                        return true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    public boolean a() {
        return (this.f18311b == -1 || this.f18312c == -1) ? false : true;
    }

    public boolean a(int i2) {
        int i3 = i2 >> 12;
        int i4 = i2 & UnixStat.PERM_MASK;
        if (i3 <= 0 && i4 <= 0) {
            return false;
        }
        this.f18311b = i3;
        this.f18312c = i4;
        return true;
    }

    public boolean a(Metadata metadata) {
        for (int i2 = 0; i2 < metadata.a(); i2++) {
            Metadata.Entry a2 = metadata.a(i2);
            if (a2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) a2;
                if (a(commentFrame.f19132b, commentFrame.f19133c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
