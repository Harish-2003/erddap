/* Generated By:JavaCC: Do not edit this line. ExprParserTokenManager.java */
package dods.dap.parser;

public class ExprParserTokenManager implements ExprParserConstants {
  public java.io.PrintStream debugStream = System.out;

  public void setDebugStream(java.io.PrintStream ds) {
    debugStream = ds;
  }

  private final int jjStopStringLiteralDfa_0(int pos, long active0) {
    switch (pos) {
      case 0:
        if ((active0 & 0x400000L) != 0L) return 3;
        return -1;
      default:
        return -1;
    }
  }

  private final int jjStartNfa_0(int pos, long active0) {
    return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
  }

  private final int jjStopAtPos(int pos, int kind) {
    jjmatchedKind = kind;
    jjmatchedPos = pos;
    return pos + 1;
  }

  private final int jjStartNfaWithStates_0(int pos, int kind, int state) {
    jjmatchedKind = kind;
    jjmatchedPos = pos;
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      return pos + 1;
    }
    return jjMoveNfa_0(state, pos + 1);
  }

  private final int jjMoveStringLiteralDfa0_0() {
    switch (curChar) {
      case 33:
        return jjMoveStringLiteralDfa1_0(0x40L);
      case 38:
        return jjStopAtPos(0, 17);
      case 40:
        return jjStopAtPos(0, 18);
      case 41:
        return jjStopAtPos(0, 19);
      case 42:
        return jjStopAtPos(0, 15);
      case 44:
        return jjStopAtPos(0, 16);
      case 46:
        return jjStartNfaWithStates_0(0, 22, 3);
      case 58:
        return jjStopAtPos(0, 14);
      case 60:
        jjmatchedKind = 9;
        return jjMoveStringLiteralDfa1_0(0x400L);
      case 61:
        return jjStopAtPos(0, 5);
      case 62:
        jjmatchedKind = 7;
        return jjMoveStringLiteralDfa1_0(0x100L);
      case 91:
        return jjStopAtPos(0, 12);
      case 93:
        return jjStopAtPos(0, 13);
      case 123:
        return jjStopAtPos(0, 20);
      case 125:
        return jjStopAtPos(0, 21);
      case 126:
        return jjMoveStringLiteralDfa1_0(0x800L);
      default:
        return jjMoveNfa_0(0, 0);
    }
  }

  private final int jjMoveStringLiteralDfa1_0(long active0) {
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
    }
    switch (curChar) {
      case 61:
        if ((active0 & 0x40L) != 0L) return jjStopAtPos(1, 6);
        else if ((active0 & 0x100L) != 0L) return jjStopAtPos(1, 8);
        else if ((active0 & 0x400L) != 0L) return jjStopAtPos(1, 10);
        else if ((active0 & 0x800L) != 0L) return jjStopAtPos(1, 11);
        break;
      default:
        break;
    }
    return jjStartNfa_0(0, active0);
  }

  private final void jjCheckNAdd(int state) {
    if (jjrounds[state] != jjround) {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
    }
  }

  private final void jjAddStates(int start, int end) {
    do {
      jjstateSet[jjnewStateCnt++] = jjnextStates.get(start);
    } while (start++ != end);
  }

  private final void jjCheckNAddTwoStates(int state1, int state2) {
    jjCheckNAdd(state1);
    jjCheckNAdd(state2);
  }

  private final void jjCheckNAddStates(int start, int end) {
    do {
      jjCheckNAdd(jjnextStates.get(start));
    } while (start++ != end);
  }

  static final long[] jjbitVec0 = {0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL};

  private final int jjMoveNfa_0(int startState, int curPos) {
    int[] nextStates;
    int startsAt = 0;
    jjnewStateCnt = 22;
    int i = 1;
    jjstateSet[0] = startState;
    int j, kind = 0x7fffffff;
    for (; ; ) {
      if (++jjround == 0x7fffffff) ReInitRounds();
      if (curChar < 64) {
        long l = 1L << curChar;
        do {
          switch (jjstateSet[--i]) {
            case 0:
              if ((0x3ffa82000000000L & l) != 0L) {
                if (kind > 28) kind = 28;
                jjCheckNAdd(7);
              } else if (curChar == 34) {
                if (kind > 31) kind = 31;
                jjCheckNAddStates(0, 4);
              } else if (curChar == 46) jjCheckNAdd(3);
              if ((0x3ff000000000000L & l) != 0L) {
                if (kind > 24) kind = 24;
                jjCheckNAddStates(5, 7);
              } else if ((0x280000000000L & l) != 0L) jjCheckNAddStates(8, 10);
              else if (curChar == 37) {
                if (kind > 23) kind = 23;
                jjCheckNAdd(1);
              }
              break;
            case 1:
              if ((0x3ff802000000000L & l) == 0L) break;
              if (kind > 23) kind = 23;
              jjCheckNAdd(1);
              break;
            case 2:
              if (curChar == 46) jjCheckNAdd(3);
              break;
            case 3:
              if ((0x3ff000000000000L & l) == 0L) break;
              if (kind > 25) kind = 25;
              jjCheckNAddTwoStates(3, 4);
              break;
            case 5:
              if ((0x280000000000L & l) != 0L) jjCheckNAdd(6);
              break;
            case 6:
              if ((0x3ff000000000000L & l) == 0L) break;
              if (kind > 25) kind = 25;
              jjCheckNAdd(6);
              break;
            case 7:
              if ((0x3ffa82000000000L & l) == 0L) break;
              if (kind > 28) kind = 28;
              jjCheckNAdd(7);
              break;
            case 8:
              if ((0x280000000000L & l) != 0L) jjCheckNAddStates(8, 10);
              break;
            case 9:
              if ((0x3ff000000000000L & l) == 0L) break;
              if (kind > 24) kind = 24;
              jjCheckNAdd(9);
              break;
            case 10:
              if ((0x3ff000000000000L & l) != 0L) jjCheckNAddTwoStates(10, 11);
              break;
            case 11:
              if (curChar != 46) break;
              if (kind > 25) kind = 25;
              jjCheckNAddTwoStates(12, 4);
              break;
            case 12:
              if ((0x3ff000000000000L & l) == 0L) break;
              if (kind > 25) kind = 25;
              jjCheckNAddTwoStates(12, 4);
              break;
            case 13:
              if ((0x3ff000000000000L & l) == 0L) break;
              if (kind > 24) kind = 24;
              jjCheckNAddStates(5, 7);
              break;
            case 14:
              if (curChar != 34) break;
              if (kind > 31) kind = 31;
              jjCheckNAddStates(0, 4);
              break;
            case 15:
              if ((0xfffffffbffffffffL & l) != 0L) jjCheckNAddStates(11, 13);
              break;
            case 16:
              if (curChar == 34) jjCheckNAddStates(11, 13);
              break;
            case 18:
              if (curChar == 34 && kind > 28) kind = 28;
              break;
            case 19:
              if ((0xfffffffbffffffffL & l) == 0L) break;
              if (kind > 31) kind = 31;
              jjCheckNAddTwoStates(19, 21);
              break;
            case 20:
              if (curChar != 34) break;
              if (kind > 31) kind = 31;
              jjCheckNAddTwoStates(19, 21);
              break;
            default:
              break;
          }
        } while (i != startsAt);
      } else if (curChar < 128) {
        long l = 1L << (curChar & 077);
        do {
          switch (jjstateSet[--i]) {
            case 0:
              if ((0x7fffffe87fffffeL & l) != 0L) {
                if (kind > 28) kind = 28;
                jjCheckNAdd(7);
              }
              if ((0x7fffffe87fffffeL & l) != 0L) {
                if (kind > 23) kind = 23;
                jjCheckNAdd(1);
              }
              break;
            case 1:
              if ((0x7fffffe87fffffeL & l) == 0L) break;
              if (kind > 23) kind = 23;
              jjCheckNAdd(1);
              break;
            case 4:
              if ((0x2000000020L & l) != 0L) jjAddStates(14, 15);
              break;
            case 7:
              if ((0x7fffffe87fffffeL & l) == 0L) break;
              if (kind > 28) kind = 28;
              jjCheckNAdd(7);
              break;
            case 15:
              jjAddStates(11, 13);
              break;
            case 17:
              if (curChar == 92) jjstateSet[jjnewStateCnt++] = 16;
              break;
            case 19:
              if (kind > 31) kind = 31;
              jjAddStates(16, 17);
              break;
            case 21:
              if (curChar == 92) jjstateSet[jjnewStateCnt++] = 20;
              break;
            default:
              break;
          }
        } while (i != startsAt);
      } else {
        int i2 = (curChar & 0xff) >> 6;
        long l2 = 1L << (curChar & 077);
        do {
          switch (jjstateSet[--i]) {
            case 15:
              if ((jjbitVec0[i2] & l2) != 0L) jjAddStates(11, 13);
              break;
            case 19:
              if ((jjbitVec0[i2] & l2) == 0L) break;
              if (kind > 31) kind = 31;
              jjAddStates(16, 17);
              break;
            default:
              break;
          }
        } while (i != startsAt);
      }
      if (kind != 0x7fffffff) {
        jjmatchedKind = kind;
        jjmatchedPos = curPos;
        kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 22 - (jjnewStateCnt = startsAt))) return curPos;
      try {
        curChar = input_stream.readChar();
      } catch (java.io.IOException e) {
        return curPos;
      }
    }
  }

  static final ImmutableList<Integer> jjnextStates = ImmutableList.of(
    15, 17, 18, 19, 21, 9, 10, 11, 9, 10, 2, 15, 17, 18, 5, 6, 19, 21
  );
  private static final String jjstrLiteralImagesNull = "null";
  public static final ImmutableList<String> jjstrLiteralImages = ImmutableList.of(
    "", jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, "\75", "\41\75", "\76", "\76\75", "\74", "\74\75",
    "\176\75", "\133", "\135", "\72", "\52", "\54", "\46", "\50", "\51", "\173", "\175",
    "\56", jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull, jjstrLiteralImagesNull
  );
  static final ImmutableList<Long> jjtoToken = ImmutableList.of(
    0x93ffffe1L
  );
  private SimpleCharStream input_stream;
  private final int[] jjrounds = new int[22];
  private final int[] jjstateSet = new int[44];
  protected char curChar;

  public ExprParserTokenManager(SimpleCharStream stream) {
    if (SimpleCharStream.staticFlag)
      throw new Error(
          "ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
    input_stream = stream;
  }

  public ExprParserTokenManager(SimpleCharStream stream, int lexState) {
    this(stream);
    SwitchTo(lexState);
  }

  public void ReInit(SimpleCharStream stream) {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private final void ReInitRounds() {
    int i;
    jjround = 0x80000001;
    for (i = 22; i-- > 0; ) jjrounds[i] = 0x80000000;
  }

  public void ReInit(SimpleCharStream stream, int lexState) {
    ReInit(stream);
    SwitchTo(lexState);
  }

  public void SwitchTo(int lexState) {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError(
          "Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.",
          TokenMgrError.INVALID_LEXICAL_STATE);
    else curLexState = lexState;
  }

  private final Token jjFillToken() {
    Token t = Token.newToken(jjmatchedKind);
    t.kind = jjmatchedKind;
    String im = jjstrLiteralImages.get(jjmatchedKind);
    t.image = (jjstrLiteralImagesNull.equals(im)) ? input_stream.GetImage() : im;
    t.beginLine = input_stream.getBeginLine();
    t.beginColumn = input_stream.getBeginColumn();
    t.endLine = input_stream.getEndLine();
    t.endColumn = input_stream.getEndColumn();
    return t;
  }

  int curLexState = 0;
  int defaultLexState = 0;
  int jjnewStateCnt;
  int jjround;
  int jjmatchedPos;
  int jjmatchedKind;

  public final Token getNextToken() {
    int kind;
    Token specialToken = null;
    Token matchedToken;
    int curPos = 0;

    EOFLoop:
    for (; ; ) {
      try {
        curChar = input_stream.BeginToken();
      } catch (java.io.IOException e) {
        jjmatchedKind = 0;
        matchedToken = jjFillToken();
        return matchedToken;
      }

      try {
        input_stream.backup(0);
        while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
          curChar = input_stream.BeginToken();
      } catch (java.io.IOException e1) {
        continue EOFLoop;
      }
      jjmatchedKind = 0x7fffffff;
      jjmatchedPos = 0;
      curPos = jjMoveStringLiteralDfa0_0();
      if (jjmatchedKind != 0x7fffffff) {
        if (jjmatchedPos + 1 < curPos) input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken.get(jjmatchedKind >> 6) & (1L << (jjmatchedKind & 077))) != 0L) {
          matchedToken = jjFillToken();
          return matchedToken;
        } else {
          continue EOFLoop;
        }
      }
      int error_line = input_stream.getEndLine();
      int error_column = input_stream.getEndColumn();
      String error_after = null;
      boolean EOFSeen = false;
      try {
        input_stream.readChar();
        input_stream.backup(1);
      } catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
          error_line++;
          error_column = 0;
        } else error_column++;
      }
      if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
      }
      throw new TokenMgrError(
          EOFSeen,
          curLexState,
          error_line,
          error_column,
          error_after,
          curChar,
          TokenMgrError.LEXICAL_ERROR);
    }
  }
}
