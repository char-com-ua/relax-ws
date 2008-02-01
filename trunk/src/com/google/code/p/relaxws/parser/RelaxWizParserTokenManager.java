/* Generated By:JJTree&JavaCC: Do not edit this line. RelaxWizParserTokenManager.java */
package com.google.code.p.relaxws.parser;
import java.io.*;
import java.util.*;

public class RelaxWizParserTokenManager implements RelaxWizParserConstants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3fc0L) != 0L)
         {
            jjmatchedKind = 16;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0x400L) != 0L)
            return 1;
         if ((active0 & 0x3bc0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 1;
            return 1;
         }
         return -1;
      case 2:
         if ((active0 & 0x33c0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 2;
            return 1;
         }
         if ((active0 & 0x800L) != 0L)
            return 1;
         return -1;
      case 3:
         if ((active0 & 0x32c0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 3;
            return 1;
         }
         if ((active0 & 0x100L) != 0L)
            return 1;
         return -1;
      case 4:
         if ((active0 & 0x2c0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 4;
            return 1;
         }
         if ((active0 & 0x3000L) != 0L)
            return 1;
         return -1;
      case 5:
         if ((active0 & 0x2c0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 5;
            return 1;
         }
         return -1;
      case 6:
         if ((active0 & 0x240L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 6;
            return 1;
         }
         if ((active0 & 0x80L) != 0L)
            return 1;
         return -1;
      case 7:
         if ((active0 & 0x240L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 7;
            return 1;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 13:
         jjmatchedKind = 3;
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0xa00L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 123:
         return jjStopAtPos(0, 14);
      case 125:
         return jjStopAtPos(0, 15);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1040L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x80L);
      case 110:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 1);
         break;
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      case 112:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x180L);
      case 116:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(2, 11, 1);
         break;
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x2040L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      case 116:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(3, 8, 1);
         break;
      case 118:
         return jjMoveStringLiteralDfa4_0(active0, 0x80L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x200L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x80L);
      case 115:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(4, 13, 1);
         return jjMoveStringLiteralDfa5_0(active0, 0x40L);
      case 116:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(4, 12, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x80L);
      case 112:
         return jjMoveStringLiteralDfa6_0(active0, 0x40L);
      case 116:
         return jjMoveStringLiteralDfa6_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x40L);
      case 101:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(6, 7, 1);
         break;
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private final int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa8_0(active0, 0x40L);
      case 111:
         return jjMoveStringLiteralDfa8_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private final int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(8, 6, 1);
         break;
      case 110:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(8, 9, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 4;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if (curChar == 35)
                  {
                     if (kind > 20)
                        kind = 20;
                     jjCheckNAdd(3);
                  }
                  else if (curChar == 36)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAdd(1);
                  }
                  break;
               case 1:
                  if ((0x7ffe01000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(1);
                  break;
               case 2:
                  if (curChar != 35)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(3);
                  break;
               case 3:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(3);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 1:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(1);
                  break;
               case 3:
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 3;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 3;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 4 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\156\141\155\145\163\160\141\143\145", 
"\163\145\162\166\151\143\145", "\160\157\162\164", "\157\160\145\162\141\164\151\157\156", "\151\156", 
"\157\165\164", "\146\141\165\154\164", "\164\171\160\145\163", "\173", "\175", null, null, 
null, null, null, };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0x1ffc1L, 
};
static final long[] jjtoSkip = {
   0x10003eL, 
};
static final long[] jjtoSpecial = {
   0x100000L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[4];
private final int[] jjstateSet = new int[8];
protected char curChar;
public RelaxWizParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public RelaxWizParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 4; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
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

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100000600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
         }
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}