Для запуска проекта:

Проект работает с PostgreSql.
Для работы с проектом необходимо создать базу данных sharebase в PostgreSql
listshares2.json должен находиться на диске d:\\listshares2.json
После скачивания папки вам нужно при помощи командной строки перейти в установленную папку и ввести

mvn clean package   - создается папка target с war файлом
mvn liquibase:update   - создается таблицы в БД

war файл помещаете в Tomcat и запускаете в браузере.

Вимоги до компонентів.
1) Реалізувати сервіс створення запису.
a) Сутність містить поля: Коментар,
ЄДРПОУ, кількість, загальна номінальна вартість, номінальна вартість, дата випуску, статус.
b) загальна номінальна вартість формується номінальна вартість * кількість.
c) Статус при створенні 'active'

2) Реалізувати сервіс редагування записe (всі зміни повинні записуватися в історію)
a) При зміні в історію має записатися ЄДРПОУ, назва поля яку змінено, старе значення поля, нове значення.

3) Реалізувати сервіс видалення запису (не фізично, при видаленні змінюється статус 'deleted')

4) Реалізувати сервіс отримання записів (можливість фільтрації по полях: статус, ЄДРПОУ, якщо фільтр не переданий віддавати весь список, пейджінація за замовчуванням 10 записів, якщо параметр не переданий явно)

5) Наповнення даними основної сутності при старті проекту з файлу json. Всі дані заповнити в довільній формі.
