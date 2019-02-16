grammar tal_sql;

SELECT : 'selection'|'veux'|'affich'|'savoir'|'voulais'|'recherch'|'donn'|'souhait'|'list'|'aimerait'
;

FICHIER : 'article'
;

COUNT : 'nombre' | 'combien'
;

BULLETIN : 'bulletin'
;

RUBRIQUE : 'rubrique' 
;

NUMERO : 'numero'|'numéro'
;

MOT : 'mot' | 'contenir' | 'parle'| 'sujet'|'contenant'|'évoqu'|'traite'
;

DATE : 'paru'|'écrit'|'publi'|'date'
;

ET : 'et'|'ou'
;

POINT : '.'
;
 
WS  : (' ' |'\t' | '\r' | 'je' | 'qui' | 'dont') {skip();} | '\n' 
;

MOIS 	: ('01'| '02'|'03'|'04'|'05'|'06'|'07'|'08'|'09'|'10'|'11'|'12')
;

JOUR	: ('1'..'9')|('1'..'3')('0'..'9')
;

ANNEE	: ('1'..'2')('0'..'9')('0'..'9')('0'..'9')
;

AVANT : 'avant'
;

APRES : 'après'
;

VAR 	: ('A'..'Z' | 'a'..'z'|'\u00a0'..'\u00ff')(('a'..'z')|('0'..'9')|'-'|('\u00a0'..'\u00ff'))+
;

VARNUM 	: ('0'..'9')+
;

listerequetes returns [String sql = ""]
	@init	{Arbre lr_arbre;}: 
		r = requete POINT
			{
				lr_arbre = $r.req_arbre;
				sql = lr_arbre.sortArbre();
			}
;

requete returns [Arbre req_arbre = new Arbre("")]
	@init {Arbre cs_arbre;} : 
		(SELECT 
			{
				req_arbre.ajouteFils(new Arbre("","select distinct"));
			} 
		|	{
				req_arbre.ajouteFils(new Arbre("","select distinct"));
			}
		)
		(| COUNT
			{
				req_arbre.ajouteFils(new Arbre("","count("));			
			}
		(FICHIER
			{
				req_arbre.ajouteFils(new Arbre("","tt.fichier)"));
				req_arbre.ajouteFils(new Arbre("","from public.titretexte tt"));
			}
		 | BULLETIN
			{
				req_arbre.ajouteFils(new Arbre("","tt.numero)"));
				req_arbre.ajouteFils(new Arbre("","from public.titretexte tt"));
			}
		)
		|(FICHIER
			{
				req_arbre.ajouteFils(new Arbre("","tt.fichier"));
				req_arbre.ajouteFils(new Arbre("","from public.titretexte tt"));
			}
		 | BULLETIN
			{
				req_arbre.ajouteFils(new Arbre("","tt.numero"));
				req_arbre.ajouteFils(new Arbre("","from public.titretexte tt"));
			}
		))
		cs = critere 
			{
				cs_arbre = $cs.crit_arbre;
				req_arbre.ajouteFils(cs_arbre);
			}
;

critere returns [Arbre crit_arbre = new Arbre("")]
	@init {Arbre ps_arbre, pn_arbre, pr_arbre, pd_arbre;} : 
		(MOT
			{			
				crit_arbre.ajouteFils(new Arbre("","where"));
			}
		ps = params 
			{
				ps_arbre = $ps.les_pars_arbre;
				crit_arbre.ajouteFils(ps_arbre);
			}
		| NUMERO
			{
				crit_arbre.ajouteFils(new Arbre("","where"));			
			}
		pn = parnums
			{
				pn_arbre = $pn.num_arbre;
				crit_arbre.ajouteFils(pn_arbre);		
			}
		| RUBRIQUE
			{
				crit_arbre.ajouteFils(new Arbre("","where"));			
			}
		pr = pararubs
			{
				pr_arbre = $pr.rub_arbre;
				crit_arbre.ajouteFils(pr_arbre);		
			}
		| DATE 	{
				crit_arbre.ajouteFils(new Arbre("",",public.date d where"));
			}
		 pd = pardate
			{			
				pd_arbre = $pd.dat_arbre;
				crit_arbre.ajouteFils(pd_arbre);	
				crit_arbre.ajouteFils(new Arbre("", "AND d.fichier=tt.fichier"));	
			}
			)
		(ET 	
			{			
			}
		(MOT
			{			

			}
		ps = params 
			{
				crit_arbre.ajouteFils(new Arbre("","AND"));
				ps_arbre = $ps.les_pars_arbre;
				crit_arbre.ajouteFils(ps_arbre);
			}
		| NUMERO
			{
		
			}
		pn = parnums
			{
				pn_arbre = $pn.num_arbre;
				crit_arbre.ajouteFils(pn_arbre);		
			}
		| RUBRIQUE
			{
		
			}
		pr = pararubs
			{
				crit_arbre.ajouteFils(new Arbre("","AND"));
				pr_arbre = $pr.rub_arbre;
				crit_arbre.ajouteFils(pr_arbre);		
			}
		| DATE 	{
				crit_arbre.ajouteFils(new Arbre("","intersect select distinct d.fichier from public.date d where"));
			}
		 pd = pardate
			{			
				pd_arbre = $pd.dat_arbre;
				crit_arbre.ajouteFils(pd_arbre);		
			}))*
		
;


pardate returns [Arbre dat_arbre = new Arbre("")]
	@init {Arbre pr1_arbre, pr2_arbre, pr3_arbre;} : 
	
		((pr1 = parajour
			{
				dat_arbre.ajouteFils(new Arbre("","d.jour"));	
				pr1_arbre = $pr1.lepar_jour_arbre;
				dat_arbre.ajouteFils(pr1_arbre);
			}
		| pr2 = paramois
			{
				dat_arbre.ajouteFils(new Arbre("","d.jour"));	
				pr2_arbre = $pr2.lepar_mois_arbre;
				dat_arbre.ajouteFils(pr2_arbre);
			})
		pr2 = paramois
			{
				pr2_arbre = $pr2.lepar_mois_arbre;
				dat_arbre.ajouteFils(new Arbre("", "AND d.mois"));
				dat_arbre.ajouteFils(pr2_arbre);
			}
		pr3 = parannee
			{
				pr3_arbre = $pr3.lepar_ann_arbre;
				dat_arbre.ajouteFils(new Arbre("", "AND d.annee"));
				dat_arbre.ajouteFils(pr3_arbre);
			})
		| (pr2 = paramois
			{
				pr2_arbre = $pr2.lepar_mois_arbre;
				dat_arbre.ajouteFils(new Arbre("", "d.mois"));
				dat_arbre.ajouteFils(pr2_arbre);
			}
		pr3 = parannee
			{
				pr3_arbre = $pr3.lepar_ann_arbre;
				dat_arbre.ajouteFils(new Arbre("", "AND d.annee"));
				dat_arbre.ajouteFils(pr3_arbre);
			})
		| pr3 = parannee
			{
				pr3_arbre = $pr3.lepar_ann_arbre;
				dat_arbre.ajouteFils(new Arbre("", "d.annee"));
				dat_arbre.ajouteFils(pr3_arbre);
			}
;

pararubs returns [Arbre rub_arbre = new Arbre("")]
	@init {Arbre pr1_arbre, pr2_arbre;} : 
		pr1 = pararub
			{
				rub_arbre.ajouteFils(new Arbre("","tt.rubrique"));	
				pr1_arbre = $pr1.lepar_rub_arbre;
				rub_arbre.ajouteFils(pr1_arbre);
			}
		(ET pr2 = pararub
			{
				pr2_arbre = $pr2.lepar_rub_arbre;
				rub_arbre.ajouteFils(new Arbre("", "OR tt.rubrique"));
				rub_arbre.ajouteFils(pr2_arbre);
			})*
;
parnums returns [Arbre num_arbre = new Arbre("")]
	@init {Arbre pn1_arbre, pn2_arbre;} : 
		pn1 = paramnum
			{
				num_arbre.ajouteFils(new Arbre("","tt.numero"));	
				pn1_arbre = $pn1.lepar_num_arbre;
				num_arbre.ajouteFils(pn1_arbre);
			}
		(ET pn2 = paramnum
			{
				pn2_arbre = $pn2.lepar_num_arbre;
				num_arbre.ajouteFils(new Arbre("", "OR tt.numero"));
				num_arbre.ajouteFils(pn2_arbre);
			})*
;

params returns [Arbre les_pars_arbre = new Arbre("")]
	@init	{Arbre par1_arbre, par2_arbre;} : 
		par1 = param 
			{
				les_pars_arbre.ajouteFils(new Arbre("","tt.mot"));
				par1_arbre = $par1.lepar_arbre;
				les_pars_arbre.ajouteFils(par1_arbre);
			}
		((ET{}|) par2 = param
			{
				par2_arbre = $par2.lepar_arbre;
			les_pars_arbre.ajouteFils(new Arbre("","intersect select distinct tt.fichier from public.titretexte tt where tt.mot"));
				les_pars_arbre.ajouteFils(par2_arbre);
			}
		)*
;

param returns [Arbre lepar_arbre = new Arbre("")] :
	a = VAR
		{ lepar_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
;

paramnum returns [Arbre lepar_num_arbre = new Arbre("")] :
	a = VARNUM
		{ lepar_num_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
	| a = MOIS
		{ lepar_num_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
	| a = JOUR
		{ lepar_num_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
	| a = ANNEE
		{ lepar_num_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
;

pararub returns [Arbre lepar_rub_arbre = new Arbre("")] :
		a = VAR
			{ lepar_rub_arbre.ajouteFils(new Arbre("like", "'\%"+a.getText()+"\%'"));}
		(a = VAR
			{ lepar_rub_arbre.ajouteFils(new Arbre("AND tt.rubrique like", "'\%"+a.getText()+"\%'"));}
		)*

;

parajour returns [Arbre lepar_jour_arbre = new Arbre("")] :
	a = JOUR
		{ lepar_jour_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
;

paramois returns [Arbre lepar_mois_arbre = new Arbre("")] :
	a = MOIS
		{ lepar_mois_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
;

parannee returns [Arbre lepar_ann_arbre = new Arbre("")] :
	a = ANNEE
		{ lepar_ann_arbre.ajouteFils(new Arbre("=", "'"+a.getText()+"'"));}
;