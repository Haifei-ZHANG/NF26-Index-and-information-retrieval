#!/usr/bin/perl
open(FIC1, $ARGV[0]);
open(FIC2, $ARGV[1]);
$texte ="";
%hash = ();
while(<FIC1>){
  if(/([0-9]\.[0-9]+?) .+/){
    $val = $1;
  }
  $cle = $_;
  $cle =~ s/([0-9]\.[0-9]*)//;
  $cle =~ s/\n//;
  $val =~ s/\s+//;
  $cle =~ s/\s+//;

  $hash{$cle} = $val;
}

while(<FIC2>){
  chomp;
  if(/([0-9]+?)\s(.+?)\s([0-9]*\.htm)/){
    $val = $1;
    $mot = $2;
    $fichier = $3;
  }
  $val = $hash{$mot}*$val;
  $texte = $texte."$val    $mot    $fichier\n";
}
print($texte);
