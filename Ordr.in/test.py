import requests

r = requests.get("https://r.ordr.in/rd/147", headers = {"X-NAAMA-CLIENT-AUTHENTICATION" : "id=\"Ht3zQjCa9aTZQpIRJgtjxsVXatrJlV1fGR0IttHOZK0\", version=\"1\""})
print r.status_code
print r.text