grammar Tal_simple;
NOM : 'Pierre' | 'Marie' | 'bananes' | 'pommes'
;
VERBE : 'mange' | 'mangent'
;
DET : 'des'
;
ADJ : 'vertes' | 'jaunes'
;
CONJ : 'et' | 'ou'
;
POINT : '.'
;
WS  : (' ' |'\t' | '\r') {skip();} | '\n'  ;

listephrases returns [String arbresort = ""]
@init        {Arbre p;}:
                t = phrase POINT
                {p = $t.phrase;
                arbresort = p.sortArbre();}
;

phrase returns [Arbre phrase = new Arbre("PHRASE")]
 @init       {
// on declare les variables de type arbre
// qui sont utilises dans cette regle
        Arbre gnc, gva;
        }:
        agnc = gn_c agva = gv
        {
                gnc = $agnc.gnc;
                gva = $agva.legv;
                phrase.ajouteFils(gnc);
                phrase.ajouteFils(gva);
        }
;
gn_c returns [Arbre gnc = new Arbre("GNC")]
 @init       {Arbre gn1, gn2;}: 
                agn1 = gn 
                {
                        gn1 = $agn1.legn;
                        gnc.ajouteFils(gn1);
                }
                (c = CONJ agn2 = gn
                {
                        gnc.ajouteFils(new Arbre("CONJ",$c.getText()));
                        gn2 =$agn2.legn;
                        gnc.ajouteFils(gn2);
                })*
;
gn returns [Arbre legn = new Arbre("GN")]:
        d=DET n1=NOM
        {
                legn.ajouteFils(new Arbre("DET",$d.getText()));
                legn.ajouteFils(new Arbre("NOM",$n1.getText()));
        }
        (a=ADJ
        {
                legn.ajouteFils(new Arbre("ADJ",$a.getText()));
        } )?
        | n2=NOM
        {
                legn.ajouteFils(new Arbre("NOM",$n2.getText()));
        }
;

gv returns [Arbre legv = new Arbre("GV")]
@init        {Arbre gnc;}:
        v=VERBE
        {
                legv.ajouteFils(new Arbre("VERBE",$v.getText()));
        }
        (agnc = gn_c
        {
                gnc = $agnc.gnc;
                legv.ajouteFils(gnc);
        })?
;




