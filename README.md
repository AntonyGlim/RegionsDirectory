# RegionsDirectory
Directory of Regions (REST Service)

REST-API  
(GET) - /getall - return full list of regions  
(GET) - /getbycode/78 - return {code=78; title="Санкт-Петербург"; iso="SPE"}  
(GET) - /getbytitle/Санкт-Петербург - return {code=78; title="Санкт-Петербург"; iso="SPE"}  
(GET) - /getbyiso/SPE - return {code=78; title="Санкт-Петербург"; iso="SPE"}  
...  

**Technologies:**
* Spring Boot  
* MyBatis  
* Spring Cache  
* H2  
* Docker  
