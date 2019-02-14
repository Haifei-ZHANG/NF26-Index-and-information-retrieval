my $dir = "../BULLETINS";
my $file;
my @dir;

# opendir (DIR, $dir) or die "can't open the directory!";
# @dir = readdir DIR;
@dir = `ls $dir`;
# foreach $item (@dir){
#     print "$item\n";
# }
