# Springecom



#Insert dummy data into table from the data.sql

docker exec -i postgres-db psql -U testuser -d testdb < src/main/resources/data.sql

#git pull to pull from different repo and keep their change and overwrite ours
git remote add tutorial <giturl>
git pull tutorial main --allow-unrelated-histories
"git checkout --theirs ."

the above line only works when their is a conflict and git checkout will work, or else if its showing nothing to commit for "git status", then the latest change will not come.
use the below approach to fully replace the code with the latest one, 

git fetch tutorial
git reset --hard tutorial/main
git push origin main --force




# to up the docker server for postges, 
 docker compose up -d
 docker ps -> shows the details of running db 