package com.google.common.base;

import b5.g;
import b5.u;
import hf.e;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public abstract class CaseFormat extends Enum<CaseFormat> {
    private final b5.b wordBoundary;
    private final String wordSeparator;
    public static final CaseFormat LOWER_HYPHEN = new CaseFormat("LOWER_HYPHEN", 0, b5.b.q('-'), "-") { // from class: com.google.common.base.CaseFormat.1
        public AnonymousClass1(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_UNDERSCORE ? str.replace('-', '_') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? b5.a.j(str.replace('-', '_')) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return b5.a.g(str);
        }
    };
    public static final CaseFormat LOWER_UNDERSCORE = new CaseFormat("LOWER_UNDERSCORE", 1, b5.b.q('_'), e.f26694a) { // from class: com.google.common.base.CaseFormat.2
        public AnonymousClass2(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_HYPHEN ? str.replace('_', '-') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? b5.a.j(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return b5.a.g(str);
        }
    };
    public static final CaseFormat LOWER_CAMEL = new CaseFormat("LOWER_CAMEL", 2, b5.b.m('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.3
        public AnonymousClass3(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeFirstWord(String str) {
            return b5.a.g(str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    };
    public static final CaseFormat UPPER_CAMEL = new CaseFormat("UPPER_CAMEL", 3, b5.b.m('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.4
        public AnonymousClass4(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    };
    public static final CaseFormat UPPER_UNDERSCORE = new CaseFormat("UPPER_UNDERSCORE", 4, b5.b.q('_'), e.f26694a) { // from class: com.google.common.base.CaseFormat.5
        public AnonymousClass5(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_HYPHEN ? b5.a.g(str.replace('_', '-')) : caseFormat == CaseFormat.LOWER_UNDERSCORE ? b5.a.g(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return b5.a.j(str);
        }
    };
    private static final /* synthetic */ CaseFormat[] $VALUES = $values();

    /* renamed from: com.google.common.base.CaseFormat$1 */
    public enum AnonymousClass1 extends CaseFormat {
        public AnonymousClass1(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_UNDERSCORE ? str.replace('-', '_') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? b5.a.j(str.replace('-', '_')) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return b5.a.g(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$2 */
    public enum AnonymousClass2 extends CaseFormat {
        public AnonymousClass2(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_HYPHEN ? str.replace('_', '-') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? b5.a.j(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return b5.a.g(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$3 */
    public enum AnonymousClass3 extends CaseFormat {
        public AnonymousClass3(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeFirstWord(String str) {
            return b5.a.g(str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$4 */
    public enum AnonymousClass4 extends CaseFormat {
        public AnonymousClass4(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$5 */
    public enum AnonymousClass5 extends CaseFormat {
        public AnonymousClass5(String str, int i10, b5.b bVar, String str2) {
            super(str, i10, bVar, str2);
        }

        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_HYPHEN ? b5.a.g(str.replace('_', '-')) : caseFormat == CaseFormat.LOWER_UNDERSCORE ? b5.a.g(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return b5.a.j(str);
        }
    }

    public static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        public StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) u.E(caseFormat);
            this.targetFormat = (CaseFormat) u.E(caseFormat2);
        }

        @Override // com.google.common.base.Converter, b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            StringConverter stringConverter = (StringConverter) obj;
            return this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat);
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.sourceFormat);
            String valueOf2 = String.valueOf(this.targetFormat);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".converterTo(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // com.google.common.base.Converter
        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        @Override // com.google.common.base.Converter
        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }
    }

    private static /* synthetic */ CaseFormat[] $values() {
        return new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }

    public /* synthetic */ CaseFormat(String str, int i10, b5.b bVar, String str2, AnonymousClass1 anonymousClass1) {
        this(str, i10, bVar, str2);
    }

    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        char h10 = b5.a.h(str.charAt(0));
        String g10 = b5.a.g(str.substring(1));
        StringBuilder sb2 = new StringBuilder(String.valueOf(g10).length() + 1);
        sb2.append(h10);
        sb2.append(g10);
        return sb2.toString();
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb2 = null;
        int i10 = 0;
        int i11 = -1;
        while (true) {
            i11 = this.wordBoundary.o(str, i11 + 1);
            if (i11 == -1) {
                break;
            }
            if (i10 == 0) {
                sb2 = new StringBuilder(str.length() + (caseFormat.wordSeparator.length() * 4));
                sb2.append(caseFormat.normalizeFirstWord(str.substring(i10, i11)));
            } else {
                Objects.requireNonNull(sb2);
                sb2.append(caseFormat.normalizeWord(str.substring(i10, i11)));
            }
            sb2.append(caseFormat.wordSeparator);
            i10 = this.wordSeparator.length() + i11;
        }
        if (i10 == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        Objects.requireNonNull(sb2);
        sb2.append(caseFormat.normalizeWord(str.substring(i10)));
        return sb2.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    public String normalizeFirstWord(String str) {
        return normalizeWord(str);
    }

    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        u.E(caseFormat);
        u.E(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }

    private CaseFormat(String str, int i10, b5.b bVar, String str2) {
        super(str, i10);
        this.wordBoundary = bVar;
        this.wordSeparator = str2;
    }
}
