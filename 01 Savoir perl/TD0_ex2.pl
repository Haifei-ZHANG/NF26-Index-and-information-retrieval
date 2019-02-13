 $compteur = 0;
 while (<>) {		# on utilise l'operateur diamant et la variable $_
	if (/^<bibl/) { $compteur++;}	# teste si $_ debute par l'expression
				# reguliere <bibl et increment le compteur
	} print "il y a $compteur references\n";


=pod
while (defined($ligne=<STDIN>)) {	# lit la prochaine ligne
	if ($ligne=~/^<bibl/) {	# teste si la ligne debute par l'expression
				# reguliere <bibl
		$compteur++;	# oui, on increment le compteur
		}
	}
print "il y a $compteur références\n";	# imprime le resultat

#### Utilisation : TDPerl00_2.pl < sa_b.tei

#### Listing Propose par Degremont-Delaruelle
#!/usr/bin/perl -w
# the one-liner
print "nb de <bibl> : " . scalar( grep(/^<bibl.*>/, <>) ) . "\n";

=cut