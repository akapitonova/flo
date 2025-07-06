# Test project 'Flowershop'

Тестовый проект, в основе которого лежит Интернет-магазин цветов.

В проекте реализован необходимый функционал Интернет-магазина:
- Каталог товаров
- Корзина
- Оформление заказа
- Возможность регистрации на сайте
- Возможность поиска товара по наименованию и ценовому диапазону
- Есть отдельная страница для администрирования сайта с возможностью просмотра списка пользователей и редактированием заказов

---
 * Сборка на maven 4.0.0
 * Запуск с apache tomcat 8.5.68 
 * Обмен данными через ActiveMQ 5.13.0
 * База данных ~~in memory H2~~ postgresql
 * Миграция схемы БД с использованием liquibase 4.21.1
___
   
 * Реализован обмен данными при регистрации пользователя через JMS ActiveMQ (/src/main/java/com/kap/flowershop/back/controller/UserController.java#L117)
 * Реализован rest-service (post-запрос) с использованием jersey api (/src/main/java/com/kap/flowershop/front/rest/RestService.java)
 * Реализовано преобразование данных в xml посредством JAXB marshalling (/src/main/java/com/kap/flowershop/back/service/UserMarshallingService.java)
 * Реализован подход поднятия embeddedJms для unit-tests
 * Реализовано документирование restful api с помощью swagger (доступен по .../swagger.html)
 * Реализован аспектно-ориентированный подход к логированию операции добавления заказа (/src/main/java/com/kap/flowershop/back/service/aspect/CustomerOrderAspect.java)
 * Реализован retry при попытке создать заказ в БД (/src/main/java/com/kap/flowershop/back/service/CustomerOrderServiceImpl.java#L33)
 * Реализовано преобразование данных из dto в entity посредством mapstruct (/src/main/java/com/kap/flowershop/back/mapping)
 * Реализована работа с БД посредством JpaRepository (/src/main/java/com/kap/flowershop/back/repository)
 * Для поиска товара реализовано обращение к БД последством EntityManager (/src/main/java/com/kap/flowershop/back/dao)


Для простоты запуска использовался плагин SmartTomcat (указывается путь к серверу Tomcat, расположен в корне проекта).

~~Для запуска in memory H2 необходимо прописать ПОЛНЫЙ путь к файлу flowershop.mv.db в файле appContext.xml .~~

В папке META-INF/DataSource/Marshalling содержится информация о создаваемых пользователях (необходимо для работы JAX-WS), так же необходимо прописать ПОЛНЫЙ путь до этой папки

-Xlog:gc* - для логирования действий сборщика мусора
