# RegionsDirectory
Directory of Regions (REST Service)

**Задание**  
Создать приложение используя Spring Boot реализующее справочник регионов (свойства: идентификатор, наименование, сокращённое наименование), предоставляющее REST-API на чтение и изменение справочника, справочник должен храниться в БД в качестве ORM необходимо использовать MyBatis.  
Преимуществом будет использование Spring Cache.  
Использовать встроенную БД и контейнер приложения.  

**Technologies:**
* Spring Boot  
* MyBatis  
* Spring Cache  
* H2 (именно ее я понял под "встроенной БД", хотя я бы  предпочел SQLite)  
* ~~Docker~~  

Согласно файла конфигурации приложение развернется на localhost:8191/regions
```
server.port=8191
server.servlet.context-path=/regions
```

**REST-API все ответы в формате JSON**  
**Получить список всех регионов**  
```
Type : GET
Endpoint : localhost:8191/regions/rest/v1/ 
Parameters : non
Response example : 
[
      {
      "id": 1,
      "code": 1,
      "title": "Республика Адыгея",
      "iso": "AD"
   },
      {
      "id": 2,
      "code": 2,
      "title": "Республика Башкортостан",
      "iso": "BA"
   },
      {
      "id": 3,
      "code": 3,
      "title": "Республика Бурятия",
      "iso": "BU"
   },
      {
      ...
   } 
]
```
**Получить конкретный регион по его коду**  
```
Type : GET
Endpoint : localhost:8191/regions/rest/v1/2
Parameters : int code 
Response example : 
{
   "id": 2,
   "code": 2,
   "title": "Республика Башкортостан",
   "iso": "BA"
}
```  
**Добавить регион в базу данных**  
```
Type : PUT
Endpoint : localhost:8191/regions/rest/v1/
Parameters : non
Body : 
{ 
   "code": 4,
   "title": "Республика Алтай",
   "iso": "AL"
}
Response example : 
{
   "id": 4,
   "code": 4,
   "title": "Республика Алтай",
   "iso": "AL"
}
```
**Обновить информацию о регионе (если записи с таким id нет в базе, она будет создана)**  
```
Type : PUT
Endpoint : localhost:8191/regions/rest/v1/2
Parameters : Long id
Body : 
{
   "code": 22,
   "title": "Республика Башкортостан 2",
   "iso": "BA 2"
}
Response example : 
{
   "id": 2,
   "code": 22,
   "title": "Республика Башкортостан 2",
   "iso": "BA 2"
}
```

**Spring Cache**  
Работу Spring Cache можно видеть по записям лога, так, вызвав метод findAll() класса RegionService мы увидим в логе примерно такую запись:
``` 
2020-02-06 12:36:29.141  INFO 22085 --- [nio-8191-exec-1] g.a.r.directory.services.RegionService   : findAll -> [Region(id=1, code=1, title=Республика Адыгея, iso=AD), Region(id=2, code=2, title=Республика Башкортостан, iso=BA), Region(id=3, code=3, title=Республика Бурятия, iso=BU)]
```  
Если вызывать метод повторно, то данной надписи в логе больше не появиться, что говорит нам о том, что данные больше не беруться из базы, но достаются из кэша  
**Что можно доработать**  
* Добавить проверку корректности данных  
* Добавить коды ошибок и исключения, которые будут отправляться пользователю.
