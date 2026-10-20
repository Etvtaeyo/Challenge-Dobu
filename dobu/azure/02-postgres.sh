#!/usr/bin/env bash
set -euo pipefail
: "${RESOURCE_GROUP:?Defina RESOURCE_GROUP}"
: "${LOCATION:?Defina LOCATION}"
: "${POSTGRES_SERVER:?Defina POSTGRES_SERVER}"
: "${POSTGRES_DB:?Defina POSTGRES_DB}"
: "${POSTGRES_USER:?Defina POSTGRES_USER}"
: "${POSTGRES_PASSWORD:?Defina POSTGRES_PASSWORD como variável protegida}"

az postgres flexible-server create \
  --resource-group "$RESOURCE_GROUP" \
  --name "$POSTGRES_SERVER" \
  --location "$LOCATION" \
  --admin-user "$POSTGRES_USER" \
  --admin-password "$POSTGRES_PASSWORD" \
  --sku-name Standard_B1ms \
  --tier Burstable \
  --storage-size 32 \
  --version 16 \
  --yes

az postgres flexible-server db create \
  --resource-group "$RESOURCE_GROUP" \
  --server-name "$POSTGRES_SERVER" \
  --database-name "$POSTGRES_DB"
