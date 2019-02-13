$numligne = 1;
while (defined($ligne=<>)) {		# on utilise l'operateur diamant,会从所有的输入从头读到尾
	print "$numligne \t $ligne";
	$numligne++; 	}
	
=pod
$numligne = 1;
while (defined($ligne=<STDIN>)) {	# lit la prochaine ligne
	print "$numligne \t $ligne";	# imprime le numero, suivi d'une
					# tabulation, suivi de la ligne
	$numligne++; 	}		# incremente le numero de ligne

##### Utilisation : TDPerl00_1.pl < sa_b.tei


$numligne = 1;
while (<>) {			# on utilise l'operateur diamant et la
				# variable implicite $_
 	print "$numligne \t $_";
	$numligne++; 	}

#### Utilisation : TDPerl00_1.pl sa_b.tei


use strict;
my $linecount = 1;
# read file
print $linecount++ . ': ' . $_ while(<>);
=cut
