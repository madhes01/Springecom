# Springecom



#Insert dummy data into table from the data.sql
docker exec -i postgres-db psql -U testuser -d testdb < src/main/resources/data.sql