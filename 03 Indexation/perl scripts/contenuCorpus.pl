#!/usr/bin/perl
open(FIC1, "moyennesort.txt");
$val = -1;
$texte="";
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
  if($val > 0.762372386508878){
    $texte = $texte."$mot\n";
  }
  $val = -1;
}

print($texte);
