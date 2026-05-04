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


 Option 1: Stop containers (keep them)

 docker compose stop


✅ Containers stop running
✅ Data, volumes, and containers remain
✅ You can restart with docker compose start or up -d


✅ Option 2: Stop and remove containers (recommended for dev)
docker compose down

✅ Stops containers
✅ Removes containers and networks
❌ Does not remove volumes by default (your DB data stays)

This is what most developers use routinely.

✅ Option 3: Stop and remove containers including volumes (⚠️ DATA LOSS)
docker compose down -v

❌ Deletes containers
❌ Deletes volumes (Postgres data, etc.)
❌ Deletes network

⚠️ Use only if you want a clean reset.

✅ If you are not in the compose file directory
Specify the compose file explicitly:
docker compose -f docker-compose.yml down

✅ Quick checks
See running containers
docker ps
See all containers (including stopped)
docker ps -a

✅ TL;DR (what you probably want)





















GoalCommandStop services safelydocker compose stopStop + clean containersdocker compose downFull reset (delete DB data)docker compose down -v