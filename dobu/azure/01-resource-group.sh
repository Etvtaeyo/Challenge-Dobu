#!/usr/bin/env bash
set -euo pipefail
: "${RESOURCE_GROUP:?Defina RESOURCE_GROUP}"
: "${LOCATION:?Defina LOCATION}"
az group create --name "$RESOURCE_GROUP" --location "$LOCATION"
