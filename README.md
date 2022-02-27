# Credit System

## Backend
Java Spring Boot  
PostgreSQL  
JPA  
JWT  
Mockito  
Swagger

## Frontend
ReactJS  
Redux  
Bootstrap

#

### Kredi Sistemi  
 Proje Konusu:  
Bir kredi başvuru sistemi için, kredi başvuru isteklerini alıp ilgili kriterlere göre müşteriye kredi
sonucunu dönen servisin içinde yer alacak restful bir uygulamanın Spring Boot framework kullanılarak
yazılması ve isteğe bağlı olarak önyüzünün yazılması
Gereksinimler:
1. Backend :  
○ Kullanıcıdan kimlik numarası, ad-soyad, aylık gelir ve telefon bilgileri alınarak, kimlik
numarasıyla daha önceden yazıldığı varsayılan kredi skoru servisine gidilir ve ilgili
kişiye ait kredi skoru alınarak aşağıdaki kurallara göre kullanıcıya kredi sonucu
gösterilir.
(Onay veya Red olarak iki seçenek olabilir.)
2. Frontend: (opsiyonel):  
○ Kimlik numarası, ad-soyad, aylık gelir ve telefon bilgileri form ile alınır ve kullanıcıya
kredi sonucu ve kredi limiti gösterilir.
(JavaScript, HTML, CSS en basit şekilde yeterlidir, isteğe bağlı olarak front-end
framework kullanılabilir. Arayüz tasarımı ve deneyimi size bırakılmıştır.)  

Kurallar:  
● Sisteme yeni kullanıcılar tanımlanabilir, mevcut müşteriler güncellenebilir veya silinebilir.  
● Kredi skoru 500’ün altında ise kullanıcı reddedilir. (Kredi sonucu: Red)  
● Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 5000 TL’nin altında ise
kullanıcının kredi başvurusu onaylanır ve kullanıcıya 10.000 TL limit atanır. (Kredi Sonucu:
Onay)  
● Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 5000 TL’nin üstünde ise
kullanıcının kredi başvurusu onaylanır ve kullanıcıya 20.000 TL limit atanır. (Kredi Sonucu:
Onay)  
● Kredi skoru 1000 puana eşit veya üzerinde ise kullanıcıya AYLIK GELİR BİLGİSİ * KREDİ
LİMİT ÇARPANI kadar limit atanır. (Kredi Sonucu: Onay)  
● Kredinin neticelenmesi sonucunda ilgili başvuru veritabanına kaydedilir. Daha sonrasında ise
ilgili telefon numarasına bilgilendirme SMS’i gönderilir ve endpoint’ten onay durum bilgisi (red
veya onay), limit bilgisi dönülür.  
● Gerçekleştirilmiş bir kredi başvurusu sadece kimlik numarası ile sorgulanabilir
Notlar: Kredi limit çarpanı varsayılan olarak 4’tür.  

Projeden Beklenenler:  
● Backend projesinin belirtilen kurallara göre doğru çalışır olmas.  
● Kodun kalitesine (Clean Code), mimarisine dikkat edilmesi (layere, hexagonal veya tercih
ettiğiniz başka bir mimari), yeni özellikler için geliştirmeye açık olması ve anlaşılabilir olması.
(SOLID principles)  
● REST convention’larına uygun olması  
● Exception durumlarının handle edilmesi  
● Test yazılması (Hem unit, hem integration testler)  
● Dokümantasyon(Swagger, OpenApi vb)  
● İlişkisel veri tabanı kullanımı (Postgresql veya istediğiniz başka bir teknoloji kullanabilirsiniz)  
● ORM kullanıcı (JPA/Hibernate veya istediğiniz başka bir teknoloji kullanabilirsiniz)  
● Readme.md dosyası oluşturulacaktır. (projeyi çalıştırmak için gerekli komutlarla birlikte, tercih
ettiğiniz yöntemler, teknolojiler, mimari yaklaşım ve bunları tercih etme sebeplerinizi belirtiniz.)  

Bonus
- Dockerfile hazırlanması
- Frontend projesinin çalışır olması
- Endpoint’ lerin secure olması (JWT veya istediğiniz başka bir teknoloji kullanabilirsiniz.)
- Circle CI ile build ve test case lerin çalıştırılması