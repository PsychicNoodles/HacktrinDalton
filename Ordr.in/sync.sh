#!/bin/bash

if [$1 != ""]; then
	scp $1 gordie@compsci.dalton.org:public_html/trinity/$1
fi
