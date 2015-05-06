#!/bin/bash
for i in `seq 1871 2012`; 
do
	lines=`cat ../data/raw/Germany$i.tsv | wc -l`
	((lines--))
	java JSONConverter Germany$i $lines
done

