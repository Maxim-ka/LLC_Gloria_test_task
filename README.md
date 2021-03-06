#### Тестовое задание
Данный URL <https://beta.taxistock.ru/taxik/api/test/> 
возвращает JSON в след. виде:
```
{
 "cities":[
           {
            "city_id": 1,   
            "order": 0,   
            "city_name": "Москва",  
            "city_latitude": 55.75577164,  
            "city_longitude": 37.6177597,   
            "city_spn_latitude": 0.96495301,  
            "city_spn_longitude": 2.75756788,  
            "last_app_android_version": 7045,  
            "transfers": true,  
            "client_email_required": true,  
            "registration_promocode": true
           },
           …………
          ]
}
```

Нужно создать приложение, которое показывает список городов в табличном виде.
При выборе города из списка, на отдельном экране показать карту с маркером, указывающим
координаты города. Список городов должен обновляться при повторном заходе в
приложение, если приложение не было уничтожено операционной системой.

Обязательные условия:  
1. JSON модель города должна использоваться целиком (использовать все поля)
2. JSON должен загружаться в отдельном потоке
3. Показывать на экране индикатор в момент загрузки данных
4. Города должны быть отсортированы по полю order
5. Для iOS должен быть использован UICollectionView, для Android RecycleView

Приветствуется:
1. Решение с использованием паттернов программирования (VIPER, MVVM, RIB,
Android Architecture Components)
2. Код соответсвует принципам SOLID
3. Решение желательно запушить в github

-------------------
###### Примечание 
на 30.05.2019 поле order отсутвует в Json модели,
сортировку сделал по полю city_id.


