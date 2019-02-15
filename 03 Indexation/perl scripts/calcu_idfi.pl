use POSIX;
system("touch iDFi.txt");
@taille = `ls ../BULLETINS/`;
$taille = @taille;
system("echo $taille");
while(<>){
  chomp;
  if(/  ([0-9]+?) .+/){
		$dfi = $1;
	}
  $idfi = log10($taille/$dfi);
  $_ =~ s/  [0-9]+? /$idfi /;

  $command = "echo \"$_\" >> idfi.txt";
  system($command);

}
#system("touch idfi.txt");
#system("echo $resultat >> idfi.txt");
