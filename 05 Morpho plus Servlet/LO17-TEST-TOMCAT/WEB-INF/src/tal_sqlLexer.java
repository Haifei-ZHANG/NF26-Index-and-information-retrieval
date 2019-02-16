// $ANTLR 3.5.1 /volsme/users/lo17a042/Documents/TD7/tal_sql.g 2019-01-09 21:50:02

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class tal_sqlLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ANNEE=4;
	public static final int APRES=5;
	public static final int AVANT=6;
	public static final int BULLETIN=7;
	public static final int COUNT=8;
	public static final int DATE=9;
	public static final int ET=10;
	public static final int FICHIER=11;
	public static final int JOUR=12;
	public static final int MOIS=13;
	public static final int MOT=14;
	public static final int NUMERO=15;
	public static final int POINT=16;
	public static final int RUBRIQUE=17;
	public static final int SELECT=18;
	public static final int VAR=19;
	public static final int VARNUM=20;
	public static final int WS=21;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public tal_sqlLexer() {} 
	public tal_sqlLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public tal_sqlLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/volsme/users/lo17a042/Documents/TD7/tal_sql.g"; }

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:8: ( 'selection' | 'veux' | 'affich' | 'savoir' | 'voulais' | 'recherch' | 'donn' | 'souhait' | 'list' | 'aimerait' )
			int alt1=10;
			switch ( input.LA(1) ) {
			case 's':
				{
				switch ( input.LA(2) ) {
				case 'e':
					{
					alt1=1;
					}
					break;
				case 'a':
					{
					alt1=4;
					}
					break;
				case 'o':
					{
					alt1=8;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case 'v':
				{
				int LA1_2 = input.LA(2);
				if ( (LA1_2=='e') ) {
					alt1=2;
				}
				else if ( (LA1_2=='o') ) {
					alt1=5;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'a':
				{
				int LA1_3 = input.LA(2);
				if ( (LA1_3=='f') ) {
					alt1=3;
				}
				else if ( (LA1_3=='i') ) {
					alt1=10;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'r':
				{
				alt1=6;
				}
				break;
			case 'd':
				{
				alt1=7;
				}
				break;
			case 'l':
				{
				alt1=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:10: 'selection'
					{
					match("selection"); 

					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:22: 'veux'
					{
					match("veux"); 

					}
					break;
				case 3 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:29: 'affich'
					{
					match("affich"); 

					}
					break;
				case 4 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:38: 'savoir'
					{
					match("savoir"); 

					}
					break;
				case 5 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:47: 'voulais'
					{
					match("voulais"); 

					}
					break;
				case 6 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:57: 'recherch'
					{
					match("recherch"); 

					}
					break;
				case 7 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:68: 'donn'
					{
					match("donn"); 

					}
					break;
				case 8 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:75: 'souhait'
					{
					match("souhait"); 

					}
					break;
				case 9 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:85: 'list'
					{
					match("list"); 

					}
					break;
				case 10 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:3:92: 'aimerait'
					{
					match("aimerait"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "FICHIER"
	public final void mFICHIER() throws RecognitionException {
		try {
			int _type = FICHIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:6:9: ( 'article' )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:6:11: 'article'
			{
			match("article"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FICHIER"

	// $ANTLR start "COUNT"
	public final void mCOUNT() throws RecognitionException {
		try {
			int _type = COUNT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:9:7: ( 'nombre' | 'combien' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='n') ) {
				alt2=1;
			}
			else if ( (LA2_0=='c') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:9:9: 'nombre'
					{
					match("nombre"); 

					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:9:20: 'combien'
					{
					match("combien"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COUNT"

	// $ANTLR start "BULLETIN"
	public final void mBULLETIN() throws RecognitionException {
		try {
			int _type = BULLETIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:12:10: ( 'bulletin' )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:12:12: 'bulletin'
			{
			match("bulletin"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BULLETIN"

	// $ANTLR start "RUBRIQUE"
	public final void mRUBRIQUE() throws RecognitionException {
		try {
			int _type = RUBRIQUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:15:10: ( 'rubrique' )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:15:12: 'rubrique'
			{
			match("rubrique"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RUBRIQUE"

	// $ANTLR start "NUMERO"
	public final void mNUMERO() throws RecognitionException {
		try {
			int _type = NUMERO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:18:8: ( 'numero' | 'numéro' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='n') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='u') ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2=='m') ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3=='e') ) {
							alt3=1;
						}
						else if ( (LA3_3=='\u00E9') ) {
							alt3=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 3, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:18:10: 'numero'
					{
					match("numero"); 

					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:18:19: 'numéro'
					{
					match("numéro"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMERO"

	// $ANTLR start "MOT"
	public final void mMOT() throws RecognitionException {
		try {
			int _type = MOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:5: ( 'mot' | 'contenir' | 'parle' | 'sujet' | 'contenant' | 'évoqu' | 'traite' )
			int alt4=7;
			switch ( input.LA(1) ) {
			case 'm':
				{
				alt4=1;
				}
				break;
			case 'c':
				{
				int LA4_2 = input.LA(2);
				if ( (LA4_2=='o') ) {
					int LA4_7 = input.LA(3);
					if ( (LA4_7=='n') ) {
						int LA4_8 = input.LA(4);
						if ( (LA4_8=='t') ) {
							int LA4_9 = input.LA(5);
							if ( (LA4_9=='e') ) {
								int LA4_10 = input.LA(6);
								if ( (LA4_10=='n') ) {
									int LA4_11 = input.LA(7);
									if ( (LA4_11=='i') ) {
										alt4=2;
									}
									else if ( (LA4_11=='a') ) {
										alt4=5;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 11, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 10, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 9, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'p':
				{
				alt4=3;
				}
				break;
			case 's':
				{
				alt4=4;
				}
				break;
			case '\u00E9':
				{
				alt4=6;
				}
				break;
			case 't':
				{
				alt4=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:7: 'mot'
					{
					match("mot"); 

					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:15: 'contenir'
					{
					match("contenir"); 

					}
					break;
				case 3 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:28: 'parle'
					{
					match("parle"); 

					}
					break;
				case 4 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:37: 'sujet'
					{
					match("sujet"); 

					}
					break;
				case 5 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:45: 'contenant'
					{
					match("contenant"); 

					}
					break;
				case 6 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:57: 'évoqu'
					{
					match("évoqu"); 

					}
					break;
				case 7 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:21:65: 'traite'
					{
					match("traite"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOT"

	// $ANTLR start "DATE"
	public final void mDATE() throws RecognitionException {
		try {
			int _type = DATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:24:6: ( 'paru' | 'écrit' | 'publi' | 'date' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 'p':
				{
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='a') ) {
					alt5=1;
				}
				else if ( (LA5_1=='u') ) {
					alt5=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case '\u00E9':
				{
				alt5=2;
				}
				break;
			case 'd':
				{
				alt5=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:24:8: 'paru'
					{
					match("paru"); 

					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:24:15: 'écrit'
					{
					match("écrit"); 

					}
					break;
				case 3 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:24:23: 'publi'
					{
					match("publi"); 

					}
					break;
				case 4 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:24:31: 'date'
					{
					match("date"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATE"

	// $ANTLR start "ET"
	public final void mET() throws RecognitionException {
		try {
			int _type = ET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:27:4: ( 'et' | 'ou' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='e') ) {
				alt6=1;
			}
			else if ( (LA6_0=='o') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:27:6: 'et'
					{
					match("et"); 

					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:27:11: 'ou'
					{
					match("ou"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ET"

	// $ANTLR start "POINT"
	public final void mPOINT() throws RecognitionException {
		try {
			int _type = POINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:30:7: ( '.' )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:30:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POINT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:5: ( ( ' ' | '\\t' | '\\r' | 'je' | 'qui' | 'dont' ) | '\\n' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='\t'||LA8_0=='\r'||LA8_0==' '||LA8_0=='d'||LA8_0=='j'||LA8_0=='q') ) {
				alt8=1;
			}
			else if ( (LA8_0=='\n') ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:7: ( ' ' | '\\t' | '\\r' | 'je' | 'qui' | 'dont' )
					{
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:7: ( ' ' | '\\t' | '\\r' | 'je' | 'qui' | 'dont' )
					int alt7=6;
					switch ( input.LA(1) ) {
					case ' ':
						{
						alt7=1;
						}
						break;
					case '\t':
						{
						alt7=2;
						}
						break;
					case '\r':
						{
						alt7=3;
						}
						break;
					case 'j':
						{
						alt7=4;
						}
						break;
					case 'q':
						{
						alt7=5;
						}
						break;
					case 'd':
						{
						alt7=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}
					switch (alt7) {
						case 1 :
							// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:8: ' '
							{
							match(' '); 
							}
							break;
						case 2 :
							// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:13: '\\t'
							{
							match('\t'); 
							}
							break;
						case 3 :
							// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:20: '\\r'
							{
							match('\r'); 
							}
							break;
						case 4 :
							// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:27: 'je'
							{
							match("je"); 

							}
							break;
						case 5 :
							// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:34: 'qui'
							{
							match("qui"); 

							}
							break;
						case 6 :
							// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:42: 'dont'
							{
							match("dont"); 

							}
							break;

					}

					skip();
					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:33:62: '\\n'
					{
					match('\n'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "MOIS"
	public final void mMOIS() throws RecognitionException {
		try {
			int _type = MOIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:7: ( ( '01' | '02' | '03' | '04' | '05' | '06' | '07' | '08' | '09' | '10' | '11' | '12' ) )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:9: ( '01' | '02' | '03' | '04' | '05' | '06' | '07' | '08' | '09' | '10' | '11' | '12' )
			{
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:9: ( '01' | '02' | '03' | '04' | '05' | '06' | '07' | '08' | '09' | '10' | '11' | '12' )
			int alt9=12;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='0') ) {
				switch ( input.LA(2) ) {
				case '1':
					{
					alt9=1;
					}
					break;
				case '2':
					{
					alt9=2;
					}
					break;
				case '3':
					{
					alt9=3;
					}
					break;
				case '4':
					{
					alt9=4;
					}
					break;
				case '5':
					{
					alt9=5;
					}
					break;
				case '6':
					{
					alt9=6;
					}
					break;
				case '7':
					{
					alt9=7;
					}
					break;
				case '8':
					{
					alt9=8;
					}
					break;
				case '9':
					{
					alt9=9;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}
			else if ( (LA9_0=='1') ) {
				switch ( input.LA(2) ) {
				case '0':
					{
					alt9=10;
					}
					break;
				case '1':
					{
					alt9=11;
					}
					break;
				case '2':
					{
					alt9=12;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:10: '01'
					{
					match("01"); 

					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:16: '02'
					{
					match("02"); 

					}
					break;
				case 3 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:21: '03'
					{
					match("03"); 

					}
					break;
				case 4 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:26: '04'
					{
					match("04"); 

					}
					break;
				case 5 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:31: '05'
					{
					match("05"); 

					}
					break;
				case 6 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:36: '06'
					{
					match("06"); 

					}
					break;
				case 7 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:41: '07'
					{
					match("07"); 

					}
					break;
				case 8 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:46: '08'
					{
					match("08"); 

					}
					break;
				case 9 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:51: '09'
					{
					match("09"); 

					}
					break;
				case 10 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:56: '10'
					{
					match("10"); 

					}
					break;
				case 11 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:61: '11'
					{
					match("11"); 

					}
					break;
				case 12 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:36:66: '12'
					{
					match("12"); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOIS"

	// $ANTLR start "JOUR"
	public final void mJOUR() throws RecognitionException {
		try {
			int _type = JOUR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:39:6: ( ( '1' .. '9' ) | ( '1' .. '3' ) ( '0' .. '9' ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( ((LA10_0 >= '1' && LA10_0 <= '3')) ) {
				int LA10_1 = input.LA(2);
				if ( ((LA10_1 >= '0' && LA10_1 <= '9')) ) {
					alt10=2;
				}

				else {
					alt10=1;
				}

			}
			else if ( ((LA10_0 >= '4' && LA10_0 <= '9')) ) {
				alt10=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:39:8: ( '1' .. '9' )
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:39:19: ( '1' .. '3' ) ( '0' .. '9' )
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOUR"

	// $ANTLR start "ANNEE"
	public final void mANNEE() throws RecognitionException {
		try {
			int _type = ANNEE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:42:7: ( ( '1' .. '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:42:9: ( '1' .. '2' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' )
			{
			if ( (input.LA(1) >= '1' && input.LA(1) <= '2') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ANNEE"

	// $ANTLR start "AVANT"
	public final void mAVANT() throws RecognitionException {
		try {
			int _type = AVANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:45:7: ( 'avant' )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:45:9: 'avant'
			{
			match("avant"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AVANT"

	// $ANTLR start "APRES"
	public final void mAPRES() throws RecognitionException {
		try {
			int _type = APRES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:48:7: ( 'après' )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:48:9: 'après'
			{
			match("après"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "APRES"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:51:6: ( ( 'A' .. 'Z' | 'a' .. 'z' | '\\u00a0' .. '\\u00ff' ) ( ( 'a' .. 'z' ) | ( '0' .. '9' ) | '-' | ( '\\u00a0' .. '\\u00ff' ) )+ )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:51:8: ( 'A' .. 'Z' | 'a' .. 'z' | '\\u00a0' .. '\\u00ff' ) ( ( 'a' .. 'z' ) | ( '0' .. '9' ) | '-' | ( '\\u00a0' .. '\\u00ff' ) )+
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00A0' && input.LA(1) <= '\u00FF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:51:48: ( ( 'a' .. 'z' ) | ( '0' .. '9' ) | '-' | ( '\\u00a0' .. '\\u00ff' ) )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='-'||(LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'a' && LA11_0 <= 'z')||(LA11_0 >= '\u00A0' && LA11_0 <= '\u00FF')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00A0' && input.LA(1) <= '\u00FF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "VARNUM"
	public final void mVARNUM() throws RecognitionException {
		try {
			int _type = VARNUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:54:9: ( ( '0' .. '9' )+ )
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:54:11: ( '0' .. '9' )+
			{
			// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:54:11: ( '0' .. '9' )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VARNUM"

	@Override
	public void mTokens() throws RecognitionException {
		// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:8: ( SELECT | FICHIER | COUNT | BULLETIN | RUBRIQUE | NUMERO | MOT | DATE | ET | POINT | WS | MOIS | JOUR | ANNEE | AVANT | APRES | VAR | VARNUM )
		int alt13=18;
		alt13 = dfa13.predict(input);
		switch (alt13) {
			case 1 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:10: SELECT
				{
				mSELECT(); 

				}
				break;
			case 2 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:17: FICHIER
				{
				mFICHIER(); 

				}
				break;
			case 3 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:25: COUNT
				{
				mCOUNT(); 

				}
				break;
			case 4 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:31: BULLETIN
				{
				mBULLETIN(); 

				}
				break;
			case 5 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:40: RUBRIQUE
				{
				mRUBRIQUE(); 

				}
				break;
			case 6 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:49: NUMERO
				{
				mNUMERO(); 

				}
				break;
			case 7 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:56: MOT
				{
				mMOT(); 

				}
				break;
			case 8 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:60: DATE
				{
				mDATE(); 

				}
				break;
			case 9 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:65: ET
				{
				mET(); 

				}
				break;
			case 10 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:68: POINT
				{
				mPOINT(); 

				}
				break;
			case 11 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:74: WS
				{
				mWS(); 

				}
				break;
			case 12 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:77: MOIS
				{
				mMOIS(); 

				}
				break;
			case 13 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:82: JOUR
				{
				mJOUR(); 

				}
				break;
			case 14 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:87: ANNEE
				{
				mANNEE(); 

				}
				break;
			case 15 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:93: AVANT
				{
				mAVANT(); 

				}
				break;
			case 16 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:99: APRES
				{
				mAPRES(); 

				}
				break;
			case 17 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:105: VAR
				{
				mVAR(); 

				}
				break;
			case 18 :
				// /volsme/users/lo17a042/Documents/TD7/tal_sql.g:1:109: VARNUM
				{
				mVARNUM(); 

				}
				break;

		}
	}


	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA13_eotS =
		"\24\uffff\1\101\4\106\1\uffff\32\31\2\143\1\21\1\31\11\145\1\uffff\3\145"+
		"\1\106\1\uffff\1\106\25\31\1\176\5\31\1\uffff\1\21\1\uffff\1\101\4\31"+
		"\1\u008a\10\31\1\u008a\1\21\1\u0093\1\u008a\6\31\1\uffff\1\31\1\u0093"+
		"\4\31\1\u009f\3\31\1\176\1\uffff\4\31\1\u00a7\1\u00a8\2\31\1\uffff\6\31"+
		"\1\176\1\u0093\1\176\1\u0093\1\31\1\uffff\1\31\1\u008a\2\31\1\u008a\2"+
		"\31\2\uffff\2\31\1\u00b9\2\u00ba\3\31\1\176\1\31\2\u008a\1\31\1\u00c1"+
		"\2\31\2\uffff\1\u00b9\4\31\1\u008a\1\uffff\1\u008a\1\u00c8\1\176\1\31"+
		"\1\u00ca\1\u008a\1\uffff\1\176\1\uffff";
	static final String DFA13_eofS =
		"\u00cb\uffff";
	static final String DFA13_minS =
		"\1\11\17\55\2\uffff\2\55\1\61\4\60\1\uffff\1\154\1\166\1\165\1\152\2\165"+
		"\1\146\1\155\1\164\1\141\1\162\1\143\1\142\1\156\1\164\1\163\3\155\1\154"+
		"\1\164\1\162\1\142\1\157\1\162\1\141\3\55\1\151\11\60\1\uffff\4\60\1\uffff"+
		"\1\60\1\145\1\157\1\150\1\145\1\170\1\154\1\151\1\145\1\151\1\156\1\u00e8"+
		"\1\150\1\162\1\156\1\145\1\164\1\142\1\145\1\142\1\164\1\154\1\55\2\154"+
		"\1\161\2\151\1\uffff\1\55\1\uffff\1\60\1\143\1\151\1\141\1\164\1\55\1"+
		"\141\1\143\1\162\1\143\1\164\1\163\1\145\1\151\4\55\3\162\1\151\2\145"+
		"\1\uffff\1\145\1\55\1\151\1\165\2\164\1\60\1\164\1\162\1\151\1\55\1\uffff"+
		"\1\151\1\150\1\141\1\154\2\55\1\162\1\161\1\uffff\1\145\2\157\1\145\1"+
		"\156\1\164\4\55\1\145\1\uffff\1\151\1\55\1\164\1\163\1\55\1\151\1\145"+
		"\2\uffff\1\143\1\165\3\55\1\156\1\141\1\151\1\55\1\157\2\55\1\164\1\55"+
		"\1\150\1\145\2\uffff\1\55\1\162\3\156\1\55\1\uffff\3\55\1\164\2\55\1\uffff"+
		"\1\55\1\uffff";
	static final String DFA13_maxS =
		"\20\u00ff\2\uffff\2\u00ff\5\71\1\uffff\1\154\1\166\1\165\1\152\2\165\1"+
		"\146\1\155\1\164\1\141\1\162\1\143\1\142\1\156\1\164\1\163\2\155\1\156"+
		"\1\154\1\164\1\162\1\142\1\157\1\162\1\141\3\u00ff\1\151\11\71\1\uffff"+
		"\4\71\1\uffff\1\71\1\145\1\157\1\150\1\145\1\170\1\154\1\151\1\145\1\151"+
		"\1\156\1\u00e8\1\150\1\162\1\164\1\145\1\164\1\142\1\u00e9\1\142\1\164"+
		"\1\154\1\u00ff\1\165\1\154\1\161\2\151\1\uffff\1\u00ff\1\uffff\1\71\1"+
		"\143\1\151\1\141\1\164\1\u00ff\1\141\1\143\1\162\1\143\1\164\1\163\1\145"+
		"\1\151\4\u00ff\3\162\1\151\2\145\1\uffff\1\145\1\u00ff\1\151\1\165\2\164"+
		"\1\71\1\164\1\162\1\151\1\u00ff\1\uffff\1\151\1\150\1\141\1\154\2\u00ff"+
		"\1\162\1\161\1\uffff\1\145\2\157\1\145\1\156\1\164\4\u00ff\1\145\1\uffff"+
		"\1\151\1\u00ff\1\164\1\163\1\u00ff\1\151\1\145\2\uffff\1\143\1\165\3\u00ff"+
		"\1\156\2\151\1\u00ff\1\157\2\u00ff\1\164\1\u00ff\1\150\1\145\2\uffff\1"+
		"\u00ff\1\162\3\156\1\u00ff\1\uffff\3\u00ff\1\164\2\u00ff\1\uffff\1\u00ff"+
		"\1\uffff";
	static final String DFA13_acceptS =
		"\20\uffff\1\12\1\13\7\uffff\1\21\47\uffff\1\22\4\uffff\1\15\34\uffff\1"+
		"\11\1\uffff\1\14\30\uffff\1\7\13\uffff\1\1\10\uffff\1\10\13\uffff\1\16"+
		"\7\uffff\1\17\1\20\20\uffff\1\3\1\6\6\uffff\1\2\6\uffff\1\5\1\uffff\1"+
		"\4";
	static final String DFA13_specialS =
		"\u00cb\uffff}>";
	static final String[] DFA13_transitionS = {
			"\2\21\2\uffff\1\21\22\uffff\1\21\15\uffff\1\20\1\uffff\1\24\1\25\1\26"+
			"\1\30\6\27\7\uffff\32\31\6\uffff\1\3\1\11\1\10\1\5\1\16\4\31\1\22\1\31"+
			"\1\6\1\12\1\7\1\17\1\13\1\23\1\4\1\1\1\15\1\31\1\2\4\31\45\uffff\111"+
			"\31\1\14\26\31",
			"\1\31\2\uffff\12\31\47\uffff\1\33\3\31\1\32\11\31\1\34\5\31\1\35\5\31"+
			"\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\4\31\1\36\11\31\1\37\13\31\45\uffff\140"+
			"\31",
			"\1\31\2\uffff\12\31\47\uffff\5\31\1\40\2\31\1\41\6\31\1\44\1\31\1\42"+
			"\3\31\1\43\4\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\4\31\1\45\17\31\1\46\5\31\45\uffff\140"+
			"\31",
			"\1\31\2\uffff\12\31\47\uffff\1\50\15\31\1\47\13\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\10\31\1\51\21\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\16\31\1\52\5\31\1\53\5\31\45\uffff\140"+
			"\31",
			"\1\31\2\uffff\12\31\47\uffff\16\31\1\54\13\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\24\31\1\55\5\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\16\31\1\56\13\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\1\57\23\31\1\60\5\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\2\31\1\62\22\31\1\61\4\31\45\uffff\140"+
			"\31",
			"\1\31\2\uffff\12\31\47\uffff\21\31\1\63\10\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\23\31\1\64\6\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\24\31\1\65\5\31\45\uffff\140\31",
			"",
			"",
			"\1\31\2\uffff\12\31\47\uffff\4\31\1\66\25\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\24\31\1\67\5\31\45\uffff\140\31",
			"\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100",
			"\1\102\1\103\1\104\7\105",
			"\12\105",
			"\12\101",
			"\12\107",
			"",
			"\1\110",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\144",
			"\12\101",
			"\12\101",
			"\12\101",
			"\12\101",
			"\12\101",
			"\12\101",
			"\12\101",
			"\12\101",
			"\12\101",
			"",
			"\12\146",
			"\12\146",
			"\12\146",
			"\12\146",
			"",
			"\12\101",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164\5\uffff\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171\u0083\uffff\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\177\10\uffff\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"",
			"\12\u0085",
			"\1\u0086",
			"\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u0094",
			"\1\u0095",
			"\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"",
			"\1\u009a",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\12\101",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00a9",
			"\1\u00aa",
			"",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"\1\u00b0",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00b1",
			"",
			"\1\u00b2",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00b3",
			"\1\u00b4",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00b5",
			"\1\u00b6",
			"",
			"",
			"\1\u00b7",
			"\1\u00b8",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00bb",
			"\1\u00bd\7\uffff\1\u00bc",
			"\1\u00be",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00bf",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00c0",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00c2",
			"\1\u00c3",
			"",
			"",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00c4",
			"\1\u00c5",
			"\1\u00c6",
			"\1\u00c7",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\u00c9",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			"",
			"\1\31\2\uffff\12\31\47\uffff\32\31\45\uffff\140\31",
			""
	};

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( SELECT | FICHIER | COUNT | BULLETIN | RUBRIQUE | NUMERO | MOT | DATE | ET | POINT | WS | MOIS | JOUR | ANNEE | AVANT | APRES | VAR | VARNUM );";
		}
	}

}
