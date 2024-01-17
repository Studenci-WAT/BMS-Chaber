FROM mysql:latest

ENV SQL_FILE_PATH /data/import.sql

COPY ./populate.sql /data/import.sql

RUN chmod 644 /data/import.sql

COPY import-database.sh /docker-entrypoint-initdb.d/import-database.sh

