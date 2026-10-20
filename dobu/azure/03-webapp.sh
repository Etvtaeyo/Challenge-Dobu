#!/usr/bin/env bash
set -euo pipefail
: "${RESOURCE_GROUP:?Defina RESOURCE_GROUP}"
: "${LOCATION:?Defina LOCATION}"
: "${APP_NAME:?Defina APP_NAME}"
: "${POSTGRES_SERVER:?Defina POSTGRES_SERVER}"
: "${POSTGRES_DB:?Defina POSTGRES_DB}"
: "${POSTGRES_USER:?Defina POSTGRES_USER}"
: "${POSTGRES_PASSWORD:?Defina POSTGRES_PASSWORD como variável protegida}"

az appservice plan create \
  --resource-group "$RESOURCE_GROUP" \
  --name "${APP_NAME}-plan" \
  --location "$LOCATION" \
  --is-linux \
  --sku B1

az webapp create \
  --resource-group "$RESOURCE_GROUP" \
  --plan "${APP_NAME}-plan" \
  --name "$APP_NAME" \
  --runtime 'JAVA:21-java21'

az webapp config appsettings set \
  --resource-group "$RESOURCE_GROUP" \
  --name "$APP_NAME" \
  --settings \
    DB_URL="jdbc:postgresql://${POSTGRES_SERVER}.postgres.database.azure.com:5432/${POSTGRES_DB}?sslmode=require" \
    DB_DRIVER='org.postgresql.Driver' \
    DB_USERNAME="$POSTGRES_USER" \
    DB_PASSWORD="$POSTGRES_PASSWORD" \
    H2_CONSOLE_ENABLED='false' \
    DEMO_PASSWORD='configure-no-Azure-DevOps'
