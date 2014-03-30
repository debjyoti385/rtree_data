for DIM in 2 3 5 7 10
	do 
	for DIST in 10 20 30 40 50 60 
		do
			e='java knn insert/insert.in 200000 '$DIM' '$DIST' 25 20000 5 > knn/knn_dim'$DIM'_dist'$DIST'.in' 
			echo $e
			eval $e
			e='./checkValid '$DIM' OTHER < knn/knn_dim'$DIM'_dist'$DIST'.in'
			echo $e
			eval $e
		done
	done
