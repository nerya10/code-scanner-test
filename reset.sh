#!/bin/bash
BACKEND_URL="${BACKEND_URL:-https://scanner.piiano.io/api/app}"
BACKEND_AUTH_APP="${BACKEND_AUTH_APP:-https://auth.scanner.piiano.io/identity/resources/auth/v1/api-token}"

# Verify inputs.
if [ "$#" -lt 1 ]; then
  echo "Usage: $0 <projectId>"
  exit 1
fi

PROJECT_ID=$1

validate_response() {
  local response="$1"
  http_status=$(echo "$response" | grep -Fi HTTP/ | awk '{print $2}')
  body=$(echo "$response" | sed '1,/^\r$/d')
  
  if [ "$http_status" != "200" ]; then
      echo "[ ] Error: ${body}"
      exit 1
  fi
  echo "$body"
}

if [ -z "${PIIANO_CLIENT_SECRET:-}" ]; then
  echo "[ ] ERROR: The environment variable PIIANO_CLIENT_SECRET is not set."
  exit 1
fi

if [ -z "${PIIANO_CLIENT_ID:-}" ]; then
  echo "[ ] ERROR: The environment variable PIIANO_CLIENT_ID is not set."
  exit 1
fi

echo "[ ] Getting access token..."
ACCESS_TOKEN_RESPONSE=$(curl --silent --fail --location -X POST -H 'Content-Type: application/json' -d "{\"clientId\": \"${PIIANO_CLIENT_ID}\",\"secret\": \"${PIIANO_CLIENT_SECRET}\"}" "${BACKEND_AUTH_APP}")
response_body=$(validate_response "$ACCESS_TOKEN_RESPONSE")
ACCESS_TOKEN=$(echo "$ACCESS_TOKEN_RESPONSE" | jq -r '.accessToken')

echo "[ ] Reset project: ${PROJECT_ID}"
response=$(curl --silent --location -i -X POST \
            -H 'Content-Type: application/json' \
            -H "Authorization: Bearer ${ACCESS_TOKEN}" \
            "${BACKEND_URL}/projects/${PROJECT_ID}/reset")
response_body=$(validate_response "$response")
echo "[ ] Project reseted successfully."
