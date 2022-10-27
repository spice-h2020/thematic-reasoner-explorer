# This script loads an RDF file <rdf_file_name> available in the working directory into a dataset with name <dataset_name> a dockerized fuseki endpoint
# ./run_fuseki_container.sh <rdf_file_name> <dataset_name>
docker run --rm -p 3030:3030 -v $(pwd):/usr/share/data atomgraph/fuseki --file=/usr/share/data/$1 /$2
