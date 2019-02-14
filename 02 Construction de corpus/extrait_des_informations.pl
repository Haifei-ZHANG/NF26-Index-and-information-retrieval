#!/usr/bin/perl

$texte_flag = 0;
$file = $ARGV[0];
$file =~ s/\.\.\/BULLETINS\///;
while(<>){
	unless(/"style32">BE France (\d+).*&nbsp;(\d+\/\d+\/\d+)/){
	    s/&nbsp;/ /g; s/&ecirc;/ê/g;
	#   &gt;
	    s/&ouml;/ö/g; s/&ucirc;/û/g; s/&egrave;/è/g; s/&icirc;/î/g;
	#    &lt;
	    s/&eacute;/é/g; s/&quot;/"/g; s/&agrave;/à/g; s/&acirc;/â/g; s/&iuml;/ï/g; s/&ocirc;/ô/g; s/&ccedil;/ç/g; s/&euml;/ë/g; s/&ugrave;/ù/g; s/&szlig;/ß/g; s/&uuml;/ü/g;
	#   && document.layers && layer != '';
	    s/&amp;/et/g; s/&deg;/°/g; s/&ograve;/ò/g; s/&ecirc;/ê/g; s/&#338;/Œ/g; s/&#8211/—/g; s/&#21;/--/g;
	}
	if(/<span class="style32">BE France (\d+)&nbsp; <\/span>/){  #extraire le numéro de bulletin
		$numero = $1;
	}
	if(/<span class="style42">&nbsp;&nbsp;(\d+\/\d+\/\d+)<\/span>/){  #extraire la data de bulletin
		$date = $1;
	}
	if(/<span class="style42">(.+)<br><\/span>/){  #extraire la rubrique de bulletin
		$rubrique = $1;
	}
	if(/<span class="style17">(.+)<\/span>/){  #extraire le titre de bulletin
		$titre = $1;
	}
	if($texte_flag){ #les trois if suivants ensenble pour extraire la texte(avec les information des images)
		chomp;
		$texte .= $_;
	}
	if(/<p class="style96"><span class="style95">/){  #début de texte
		chomp;
		$texte .= $_;
		$texte_flag = 1;
	}
	if(/<\/span><\/p><\/td>/){  #fin de texte
		$texte_flag = 0;
	}
	if(/<p class="style44"><span class="style85">(.+?)<\/span><\/p><\/td>/){  #extraire le contact de bulletin
		$contact = $1;
		$contact =~ s/<a href=.+?>|<\/a>|<br \/>//g;  #supprimer le lien
	}
}
#extraire des informations du texte
#@urlImages = ($texte =~ /<img src="(.+?)".+?>/g);
#@legendeImages = ($texte =~ /<span class="style21"><strong>(.+?)<\/strong>/g);
%images = ();
        while($texte =~ /<img src="(.+?)"(.*?)style88/g) {
            $url = $1;

            if ($2 =~ /<span class="style21"><strong>(.*?)<\/strong>/) {
                $legend = $1;
            } else {
                $legend = "";
            }
            $images{$url} = $legend;
        }

#Supprimer les balises et les espaces supplémentaires du texte
$texte =~ s/.+<p class="style96"><span class="style95">|<span class="style88">.+?>|<\/span><div.+?<img src.+?>|<span class="style21"><strong>.+?<\/span>|<\/div><span class="style95">|<a href=.+?>|<strong>|<\/strong>|<br \/>|<\/span><\/p><\/td>//g;
$texte =~ s/<br \/><br \/><\/span>|<br \/><br \/>|<\/div><span class="style95"><br \/>|<\/a>|<b>|<\/b>/ /g;

#Créer un bulletin d'information pour écrire dans un fichier XML
$bulletin = "	<bulletin>
		<fichier>$file</fichier>
		<numero>$numero</numero>
		<date>$date</date>
		<rubrique>$rubrique</rubrique>
		<titre>$titre</titre>
		<texte>$texte</texte>
		<images>\n";

$nombre_images = keys %images;
if (nombre_images > 0) {
	foreach my $image_url (keys %images) {
		$bulletin .= "			<image>
				<urlImage>$image_url</urlImage>
				<legendeImage>$images{$image_url}</legendeImage>
			</image>\n";
	}
	}
	

$bulletin .= "		</images>
		<contact>$contact</contact>
	</bulletin>";

$command = "cat >> corpus.XML << EOF
$bulletin
EOF";
system($command);
