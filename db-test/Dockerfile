FROM mysql:latest

ENV SQL_FILE_PATH /data/import.sql

COPY ./populate.sql /data/import.sql

RUN chmod 644 /data/import.sql

RUN chmod +x /docker-entrypoint-initdb.d/import-database.sh

COPY import-database.sh /docker-entrypoint-initdb.d/import-database.sh

