docker build -t alphamega89/preapply:v6 .
docker push alphamega89/preapply:v6 

cd kubernetes
k apply -f .

