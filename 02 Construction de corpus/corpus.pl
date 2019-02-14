#!/usr/bin/perl

my $dir = "../BULLETINS";
my $file;
my @dir;

# opendir (DIR, $dir) or die "can't open the directory!";
# @dir = readdir DIR;
@dir = `ls $dir`;
system("touch corpus.XML");
system("echo -n '<corpus>\n' >> corpus.XML");

$count = 1;
foreach $file (@dir) {
	if ( $file =~ /[0-9]*\.htm/) {
	#print "$file\n";
	$instruction = "perl extrait_des_informations.pl ../BULLETINS/$file";
	system($instruction);
	print $count++."\n";
	}
}

system("echo -n '</corpus>\n' >> corpus.XML");
