#!/bin/bash

LANG=C
cat corpus.XML | segmente_TT.pl -f | sort | uniq -c > result2.txt
awk '$2 ~ /^[0-9]/ {next} {print}' result2.txt > result.txt
rm -rf result2.txt
awk '{print $2}' result.txt | uniq -c > DFi.txt
