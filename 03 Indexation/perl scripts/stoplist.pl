#!/usr/bin/perl
$texte = "";
$sum = -1;
$val = -1;
while(<>){
  if(/([0-9]+?\.[0-9]+?)\s(.+?)\s[0-9]*\.htm/){
    $val = $1;
    $mot = $2;
  }
  if($val==-1){
    if(/([0-9]+?)\s(.+?)\s[0-9]*\.htm/){
      $val = $1;
      $mot = $2;
    }
  }
  if($sum!=-1){
    if($curr ne $mot){
      $moyenne = $moyenne / $sum;
      $texte = $texte."$moyenne        $curr \n";
      $moyenne = $val;
      $sum = 1;
      $curr = $mot;
    } else {
      $moyenne = $moyenne + $val;
      $sum = $sum +1;
    }
  } else {
    $moyenne = $val;
    $sum = 1;
    $curr = $mot;
  }
  $val = -1;
}
print($texte);
