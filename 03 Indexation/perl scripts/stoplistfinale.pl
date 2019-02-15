#!/usr/bin/perl
$command = "perl ./stoplist.pl ponderation.txt | sort > moyennesort.txt";
system($command);

open(FIC1, "moyennesort.txt");
$val = -1;
while(<FIC1>){
  if(/([0-9]+?\.[0-9]+?)           (.*)/){
    $val = $1;
    $mot = $2;
  }
  if($val==-1){
    if(/([0-9]+?)           (.*)/){
      $val = $1;
      $mot = $2;
    }
  }
  if($val <= 0.762372386508878){
    $texte = $texte."$mot\n";
  } else {
    last;
  }
  $val = -1;
}

$command = "cat >> stoplist.txt <<EOF
$texte
EOF";
system($command)
