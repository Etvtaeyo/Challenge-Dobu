# Infraestrutura Azure

## Ordem

```bash
az login
export RESOURCE_GROUP=rg-dobu
export LOCATION=brazilsouth
export POSTGRES_SERVER=dobu-postgres-<sufixo-unico>
export POSTGRES_DB=dobu
export POSTGRES_USER=dobuadmin
export POSTGRES_PASSWORD='<senha somente no terminal/secret variable>'
export APP_NAME=dobu-web-<sufixo-unico>

bash 01-resource-group.sh
bash 02-postgres.sh
bash 03-webapp.sh
```

No Azure DevOps, crie uma service connection e configure as variáveis secretas `DB_PASSWORD` e `AZURE_SERVICE_CONNECTION`. Configure também `DB_URL`, `DB_USERNAME`, `DB_DRIVER` e `DEMO_PASSWORD` como variáveis protegidas no App Service.
