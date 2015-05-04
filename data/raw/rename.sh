#!/bin/sh
for i in `seq 1871 2012`;
do
	mv BELTONZIPFDATA\ -\ $i.tsv Germany$i.tsv
done
