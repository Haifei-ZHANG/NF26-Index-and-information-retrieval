while (<>){
	chomp;		# supprime le dernier caractère (retour chariot)
	s/>[^<]+</></g;	# élimine le texte placé entre deux balises
	s/></%/g;	# remplace >< par %
	s/ [^%]+%/%/g;	# élimine les attributs éventuels de la balise
	s/[\/<>\t]//g;	# élimine les caractères indésirables
			# en effet, seules les expressions >< on été remplacées
			# par %, mais les balises initiales <lisBibl> et
			# finales </listBilbl> ainsi que celles de début et
			# de fin de ligne n'ont pas ete traitées. Il reste
			# enfin toutes les "/balises" de fermeture.

	@liste=split(/%/);	# construit le tableau des balises
	foreach $i(@liste){
		$ind{$i} = 1;	# construit un tableau assoc. des balises
		}
	}
@res=sort keys %ind;	# trie les cles par ordre alphabetique
print"liste des balises triées : \n@res\n";

### Utilisation : TDPerl00_4.pl sa_b.tei


=pod
## ou encore
#!/usr/local/bin/perl

%tab;				#tableau associatif : cle = nom de balise, valeur = nb d'occurences

while ($ligne = <>)		# tant qu'il a encore une ligne dans le fichier passe en parametre d'appel de la fonction
{
  $ligne =~ s/>(.*?)</></g;	#retire tout le texte compris entre 2 balises
  $ligne =~ s/<\/(.+?)>//g;	# retire toutes les balises fermantes du texte
  $ligne =~ s/<(.+?)\s(.+?)>/<$1>/g; # retire toutes les balises epurees de leur eventuels arguments
  #print "$ligne\n";

  while ($ligne =~ /<(.+?)>/g) {	# lit tout ce aui se trouve entre chevron. Le ? permet de parcourir la ligne 1 balise a la fois
	$tab{$1}++;			# ajoute la cle dans la table des cles, si elle n'y est pas et incremente le compteur associe
  }
}

@cles = keys(%tab);		# recupere la liste des cles
@cles = sort (@cles);		# trie la liste des cles

foreach $elt (@cles) {		# affichage
	print "$elt \n";
}


# Solution proposee par Benjamin PIAT et Olivier HOAREAU

#! /usr/local/bin/perl -w

# on cree un tableau associatif contenant en cle les noms des balises rencontrees dans le
# fichier passe en argument.

# on va reperer pour chaque ligne du fichier les chaines de caracteres contenant
# l'expression '<nom_balise' (on bloque sur les caracteres '>', ' ', '/').

while(<>){
  while($_ =~ /<([^> \/]*)>/g){
      $tags{$1}=1;
  }
}

# attention : l'affichage tient compte de la casse, les majuscules
# sont donc classees avant les minuscules.
foreach $_ (sort keys(%tags)){
  print $_."\n";
}

#### Listing Propose par Degremont-Delaruelle
#!/usr/bin/perl -w
use strict;
my $data = join('', <>);
my %taglist = ();
# extract data
$taglist{$1}++ while ($data =~ /<(\w+)( .+?)?>/gs);
# print extracted list
print join("\n", sort(keys(%taglist))), "\n";

#### Solution proposée par Lefevre et Mantelet
#!/usr/bin/perl

while(<>){
	while (/<([^\/>\s\n]*)[^>]*>/g){
		$tab{$1}++;
	}
}
@balises = sort(keys(%tab));
print "Résultat:\n@balises";

=cut