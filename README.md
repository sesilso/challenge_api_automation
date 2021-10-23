# challenge_api_automation
Configuration file: 
serenity.properties

  api.key=ed590f7ea135949580a4536529cb1a1f (countrylayer.com key)
  url.get.all=http://api.countrylayer.com/v2/all
  url.get.by.code=http://api.countrylayer.com/v2/alpha/{code}
  url.add.country=http://api.countrylayer.com/v3/new

run command: 
*mvn clean verify*

test case scenario:
src/test/resources/features/postcodes/countryLayer.feature

Output report:
target/site/serenity/index.html
