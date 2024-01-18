#!/bin/bash
set -e

echo 'Importowanie danych do bazy danych MySQL...'
mysql -u "$MYSQL_USER" -p"$MYSQL_PASSWORD" "$MYSQL_DATABASE" < "$SQL_FILE_PATH"