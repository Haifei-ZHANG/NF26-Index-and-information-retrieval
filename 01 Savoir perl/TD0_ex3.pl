$rech = shift(@ARGV);	# lit la premiere valeur de @ARGV et la
			# supprime du tableau
			# autrement l'instruction suivante lirait
			# le nom de balise donne comme argument comme
			# si c'etait un nom de fichier et generait un
			# message d'erreur
while(<>){
	while (/<$rech[^>]*>(.+?)<\/$rech>/g){
		print "$1\n";
		}
	}

=pod
$rech = $ARGV[0];	# saisit le premier argument de la ligne de commande
while ($ligne=<STDIN>) { 	#lit la prochaine ligne
	while ($ligne=~/<$rech[^>]*>(.+?)<\/$rech>/g){
# l'option g a la fin de la ligne permet de continuer la recherche
# de l'expression reguliere meme apres un premier succes
# cette option sera utile pour resoudre le probleme des <title> multiples
# sur une ligne.
# l'expression "[^>]*>" permet de traiter correctement les balises avec
# parametre (voir <title>, par exemple). L'expression ".+?" permet d'etre
# non-gourmand lorsqu'une balise apparait plusieurs fois (voir <title>).
 		print "$1\n";
		}
	}

#### Utilisation : TDPerl00_3.pl author <sa_b.tei


$rech = $ARGV[0];
while (defined($_=<STDIN>)) {
	while ($_=~/<$rech[^>]*>(.+?)<\/$rech>/g){
		print "$1\n";
		}
	}
#### Utilisation : TDPerl00_3.pl author <sa_b.tei


$rech = shift(@ARGV);	# lit la premiere valeur de @ARGV et la
			# supprime du tableau
			# autrement l'instruction suivante lirait
			# le nom de balise donne comme argument comme
			# si c'etait un nom de fichier et generait un
			# message d'erreur
while(<>)
	while (/<$rech[^>]*>(.+?)<\/$rech>/g){
		print "$1\n";
		}
	}
#### Utilisation : TDPerl00_3.pl author sa_b.tei

#### Listing Propose par Degremont-Delaruelle
#!/usr/bin/perl -w
use strict;
# fetch tag name
my $tagname;
$tagname = shift(@ARGV) or die("Usage: $0 tagname filename\n");
my $data = join('', <>);
# extract data
print "$2\n" while ($data =~ /<$tagname( .+?)?>(.*?)<\/$tagname>/sg);


=cut