package androidx.constraintlayout.core.parser;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes.dex */
public class CLParser {
    static boolean DEBUG = false;
    private boolean hasComment = false;
    private int lineNumber;
    private String mContent;

    /* renamed from: androidx.constraintlayout.core.parser.CLParser$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = iArr;
            try {
                iArr[TYPE.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i10, TYPE type, boolean z10, char[] cArr) {
        CLElement allocate;
        if (DEBUG) {
            System.out.println("CREATE " + type + " at " + cArr[i10]);
        }
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[type.ordinal()]) {
            case 1:
                allocate = CLObject.allocate(cArr);
                i10++;
                break;
            case 2:
                allocate = CLArray.allocate(cArr);
                i10++;
                break;
            case 3:
                allocate = CLString.allocate(cArr);
                break;
            case 4:
                allocate = CLNumber.allocate(cArr);
                break;
            case 5:
                allocate = CLKey.allocate(cArr);
                break;
            case 6:
                allocate = CLToken.allocate(cArr);
                break;
            default:
                allocate = null;
                break;
        }
        if (allocate == null) {
            return null;
        }
        allocate.setLine(this.lineNumber);
        if (z10) {
            allocate.setStart(i10);
        }
        if (cLElement instanceof CLContainer) {
            allocate.setContainer((CLContainer) cLElement);
        }
        return allocate;
    }

    private CLElement getNextJsonElement(int i10, char c10, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\r' || c10 == ' ') {
            return cLElement;
        }
        if (c10 == '\"' || c10 == '\'') {
            return cLElement instanceof CLObject ? createElement(cLElement, i10, TYPE.KEY, true, cArr) : createElement(cLElement, i10, TYPE.STRING, true, cArr);
        }
        if (c10 == '[') {
            return createElement(cLElement, i10, TYPE.ARRAY, true, cArr);
        }
        if (c10 != ']') {
            if (c10 == '{') {
                return createElement(cLElement, i10, TYPE.OBJECT, true, cArr);
            }
            if (c10 != '}') {
                switch (c10) {
                    case '+':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return createElement(cLElement, i10, TYPE.NUMBER, true, cArr);
                    case ',':
                    case TTDownloadField.CALL_EVENT_CONFIG_GET_CLICK_BUTTON_TAG /* 58 */:
                        return cLElement;
                    case '/':
                        int i11 = i10 + 1;
                        if (i11 >= cArr.length || cArr[i11] != '/') {
                            return cLElement;
                        }
                        this.hasComment = true;
                        return cLElement;
                    default:
                        if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                            return createElement(cLElement, i10, TYPE.KEY, true, cArr);
                        }
                        CLElement createElement = createElement(cLElement, i10, TYPE.TOKEN, true, cArr);
                        CLToken cLToken = (CLToken) createElement;
                        if (cLToken.validate(c10, i10)) {
                            return createElement;
                        }
                        throw new CLParsingException("incorrect token <" + c10 + "> at line " + this.lineNumber, cLToken);
                }
            }
        }
        cLElement.setEnd(i10 - 1);
        CLElement container = cLElement.getContainer();
        container.setEnd(i10);
        return container;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i10 = 1;
        this.lineNumber = 1;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            char c10 = charArray[i11];
            if (c10 == '{') {
                break;
            }
            if (c10 == '\n') {
                this.lineNumber++;
            }
            i11++;
        }
        if (i11 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject allocate = CLObject.allocate(charArray);
        allocate.setLine(this.lineNumber);
        allocate.setStart(i11);
        int i12 = i11 + 1;
        CLElement cLElement = allocate;
        while (i12 < length) {
            char c11 = charArray[i12];
            if (c11 == '\n') {
                this.lineNumber += i10;
            }
            if (this.hasComment) {
                if (c11 == '\n') {
                    this.hasComment = z10;
                } else {
                    continue;
                    i12++;
                    i10 = 1;
                    z10 = false;
                }
            }
            if (cLElement == null) {
                break;
            }
            if (cLElement.isDone()) {
                cLElement = getNextJsonElement(i12, c11, cLElement, charArray);
            } else if (cLElement instanceof CLObject) {
                if (c11 == '}') {
                    cLElement.setEnd(i12 - 1);
                } else {
                    cLElement = getNextJsonElement(i12, c11, cLElement, charArray);
                }
            } else if (!(cLElement instanceof CLArray)) {
                boolean z11 = cLElement instanceof CLString;
                if (z11) {
                    long j10 = cLElement.start;
                    if (charArray[(int) j10] == c11) {
                        cLElement.setStart(j10 + 1);
                        cLElement.setEnd(i12 - 1);
                    }
                } else {
                    if (cLElement instanceof CLToken) {
                        CLToken cLToken = (CLToken) cLElement;
                        if (!cLToken.validate(c11, i12)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                        }
                    }
                    if ((cLElement instanceof CLKey) || z11) {
                        long j11 = cLElement.start;
                        char c12 = charArray[(int) j11];
                        if ((c12 == '\'' || c12 == '\"') && c12 == c11) {
                            cLElement.setStart(j11 + 1);
                            cLElement.setEnd(i12 - 1);
                        }
                    }
                    if (!cLElement.isDone() && (c11 == '}' || c11 == ']' || c11 == ',' || c11 == ' ' || c11 == '\t' || c11 == '\r' || c11 == '\n' || c11 == ':')) {
                        long j12 = i12 - 1;
                        cLElement.setEnd(j12);
                        if (c11 == '}' || c11 == ']') {
                            cLElement = cLElement.getContainer();
                            cLElement.setEnd(j12);
                            if (cLElement instanceof CLKey) {
                                cLElement = cLElement.getContainer();
                                cLElement.setEnd(j12);
                            }
                        }
                    }
                }
            } else if (c11 == ']') {
                cLElement.setEnd(i12 - 1);
            } else {
                cLElement = getNextJsonElement(i12, c11, cLElement, charArray);
            }
            if (cLElement.isDone() && (!(cLElement instanceof CLKey) || ((CLKey) cLElement).mElements.size() > 0)) {
                cLElement = cLElement.getContainer();
            }
            i12++;
            i10 = 1;
            z10 = false;
        }
        while (cLElement != null && !cLElement.isDone()) {
            if (cLElement instanceof CLString) {
                cLElement.setStart(((int) cLElement.start) + 1);
            }
            cLElement.setEnd(length - 1);
            cLElement = cLElement.getContainer();
        }
        if (DEBUG) {
            System.out.println("Root: " + allocate.toJSON());
        }
        return allocate;
    }
}
