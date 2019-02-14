#!/usr/bin/perl
opendir (DIR,$ARGV[0]) or die "can't open the directory!";
@dir = readdir DIR;
$is_first_fichier=0;
foreach $file (@dir) {

    if($file=~/[\d]+.htm/){
        $filename=$file;

        open(DATA,"<$ARGV[0]/$filename") or die "Can't open the file $filename";


        while(<DATA>) {
            if ($_ =~ /<p><span class="style32">BE France (\d+)&nbsp;.*style42">&nbsp;&nbsp;([\/\d]+)/) {
                $number = $1;
                $date = $2;
            }

            if ($_ =~ /<p class="style96"><span class="style42">(.+)<br><\/span><span class="style17">(.+)<\/span><\/p>/) {
                $rubrique = $1;
                $title = $2;
            }

            if ($_ =~ /<p class="style96"><span class="style95">(.*)/) {
                $texte_brut = $1;
                do {
                    $_ = <DATA>;
                    $texte_brut .= $_;
                } until ($_ =~ /(.*)<td width=133 valign=top bgcolor="#dae1e8" class="FWExtra2">/i)
            }

            if ($_ =~ /<p class="style44"><span class="style85">(.*)<\/span>/) {
                $contact = $1;
                $contact =~ s/<[^>]*>/ /g;
            }
        }
        close(DATA);

        # Check if variables are not empty
        if (!$texte_brut) {
            print "ERROR : no texte in file $filename";
        }
        if (!$title) {
            print "ERROR : no title in file $filename";
        }
        if (!$contact) {
            print "ERROR : no contact in file $filename";
        }
        if (!$number) {
            print "ERROR : no number in file $filename";
        }
        if (!$date) {
            print "ERROR : no date in file $filename";
        }
        if (!$rubrique) {
            print "ERROR : no rubrique in file $filename";
        }

        #extract the pure texte
        $texte_tmp=$texte_brut;
        $texte_tmp=~s/\n */ /g;
        $texte_tmp=~s/<span class="style88">[^<]*<\/span>//g;
        $texte_tmp=~s/<strong>[^<]*<\/strong>//g;  #delete the legendeImage in the brut texte
        $texte_tmp=~s/(<br *\/> *)+/ /g;
        $texte_tmp=~s/\n/ /g;
        $texte_tmp=~s/<[^>]*>//g;

        $texte_pure=$texte_tmp;

        # Remove new lines from texte et extract the images
        $texte_brut =~ s/\n/ /g;
        %images = ();
        while($texte_brut =~ /<img src="(.+?)"(.*?)style88/g) {
            $url = $1;

            if ($2 =~ /<span class="style21"><strong>(.*?)<\/strong>/) {
                $legend = $1;
            } else {
                $legend = "";
            }
            $images{$url} = $legend;
        }
        #input the result in forme XML in the file
        if($is_first_fichier==0){
            $is_first_fichier=1;
            print "<corpus>\n";
        }
        print "<bulletin>
<fichier>$filename</fichier>
<numero>$number</numero>
<date>$date</date>
<rubrique>$rubrique</rubrique>
<titre>$title</titre>
<texte>$texte_pure</texte>\n";

    $size_images = keys %images;
    if ($size_images > 0) {
        print "<images>\n";
        foreach my $image_url (keys %images) {
            print "<image>\n";
            print "<urlImage>$image_url</urlImage>\n";
            if ($images{$image_url} ne "") {
                print "<legendeImage>".$images{$image_url}."</legendeImage>\n";
            }
            print "</image>\n";
        }
        print "</images>\n";
    }

print
"<contact>$contact</contact>
</bulletin>\n";
    }
}
print "</corpus>\n";


