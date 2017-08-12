#!/bin/bash

# Jill's MHN Server
curl -s -o output.json -X GET http://184.173.18.156/api/session/?api_key=a1500be66cd74841b6987dc2d1db81d4&limit=1000000 > output.json

#Leslie's MHN Server
curl -s -o output.json -X GET http://119.81.53.116/api/session/?api_key=d8f53abdc4c64778a67b81cd0e12d8f5&limit=1000000 >> output2.json
