# The-World-Of-My-Books

Android tabanlı dijital kütüphane uygulaması. Kütüphaneye kitap ekleme, çıkarma, güncelleme işlemleri yapılabilir. 
İstenilen kitaplar olarak ayrı bir kütüphane oluşturulur ve işlemler yapılabilir. Ek olarak kütüphanedeki kitaplara göre 
istatistikler oluşturulur.

## Kullanılan Teknolojiler

- JDK 11 
- Android Studio
- SQLite

## Ekran Görüntüleri

- **Giriş Ekranı**

![Login](https://user-images.githubusercontent.com/80527393/152342433-bdb28423-2cce-49e6-98b6-cd111a4206d2.png)

Program başladığında görülen ilk 
ekrandır. Bu ekranda kullanıcı girişi için 
Kullanıcı Adı ve Parola inputları 
bulunmaktadır. Kullanıcı bu inputlara
bilgilerini doldurup Giriş Yap butonuna 
basarak Ana Menüye giriş yapar. Eğer 
hatalı giriş ise tekrar denemesi için uyarı 
bildirimi gönderilir. Eğer kayıtlı değilse 
Kayıt Ol butonuna basarak kayıt olma 
ekranına ilerler. Alt kısımda programın 
ismi ve versiyonu görüntülenir.

- **Kayıt Ekranı**

![Register](https://user-images.githubusercontent.com/80527393/152342427-71ab3ac4-a234-4884-95ec-98eb3a7f9d2a.png)

Kayıt Ol ekranına Giriş 
ekranından girilir. Bu ekranda kayıt 
olmak için Ad-Soyad, Kullanıcı Adı ve 
Parola inputlar bulunmaktadır. Kullanıcı 
bu inputları doldurup Kayıt Ol butonuna 
basarak kayıt olur. Eğer boş veya hatalı 
girdi yaptığında uyarı bildirimi gönderilir

- **Ana Ekran**

![Main](https://user-images.githubusercontent.com/80527393/152342436-eef4a3c7-20e0-4d33-a0d6-fdefc2c1d45e.png)

Ana Menü Ekranına Giriş 
Ekranından girilir. Bu ekranda sahip 
olunan kitapların listelenmesi için 
ListView bulunur. İçerisinde kitapların 
No’su, ismi, yazarı, kategorisi ve 
okundu bilgisi yer almaktadır. 
ActionBar’ın sağında bulunan üç nokta 
ile kısa yollara ve istatistik ekranlarına 
gidilir. ListView’in altında 4 adet buton 
bulunur: Kitap Ekle butonu; Kitap Ekle
ekranına gider, Kitap Güncelle butonu; 
Kitap Güncelle ekranına gider, Alınacak 
Kitaplar butonu; Alınacak Kitaplar
ekrana gider. Kitap Sil butonu ise 
seçilen kitabı siler. Eğer seçilen bir 
kitap yok ise uyarı bildirimi gönderilir.

- **Kitap Ekleme Ekranı**

![AddBook](https://user-images.githubusercontent.com/80527393/152342424-d5c9426a-4834-4b20-baa3-419659d062f2.png)

Kitap Ekle ekranına Ana Menü 
ekranından ve Menü kısayollarından
girilir. Bu ekranda kitap eklemek için 
Kitap İsmi, Yazar, Kategori ve Sayfa 
Sayısı, Satın Alındı ve Okundu inputları 
bulunmaktadır. Kullanıcı bu inputları 
doldurup Kitap Ekle butonuna basarak 
kitap ekleyebilir. Eğer hatalı veya boş 
girdi yapıldığında uyarı mesajı 
gönderilir.

- **Kitap Güncelleme Ekranı**

![UpdateBook](https://user-images.githubusercontent.com/80527393/152342417-49cd0e28-eceb-4c28-b168-e36c5820c479.png)

Kitap Güncelle ekranına Ana 
Menü ekranından veya Alınacak 
Kitaplar ekranından kitap seçilip 
Güncelle butonuna basılarak girilir. 
Seçilen kitabın bilgileri inputlara 
otomatik olarak girilir. Kullanıcı 
değiştirmek istediği girdiyi 
değiştirerek Güncelle butonuna basar 
ve Ana Menü ekranına yönlendirilir. 
Eğer hatalı veya boş girdi varsa uyarı 
bildirimi gönderilir.

- **Alınacak Kitaplar Ekranı**

![TargetBook](https://user-images.githubusercontent.com/80527393/152342429-363396a7-12b5-474a-b62a-2910d311d0db.png)

Alınacak Kitaplar ekranına Ana 
Menü ve Menü kısayollarından girilir. 
Bu ekranda alınacak kitapların 
listelendiği ListView bulunur. 
İçerisinde kitapların No’su, ismi, 
yazarı, kategorisi ve okundu bilgisi yer 
almaktadır. ListView’in alt kısmında 3 
tane buton bulunmaktadır. Kitap 
Güncelle butonu seçilen kitabı 
güncellemek için Güncelleme 
Ekranına, Geri Dön butonu Ana Menü 
ekranına yönlendirir Kitap Sil butonu 
seçilen kitabı siler. Eğer Kitap 
Güncelle ve Kitap Sil butonlarına kitap 
seçilmeden basılırsa kitap seçilmesi 
için uyarı bildirimi gönderilir.

- **Menü Ekranı**

![Menu](https://user-images.githubusercontent.com/80527393/152342441-a3aeda84-c336-4e55-b134-9e844cbcd047.png)

Menü’ye, Ana Menü 
ekranında bulunan ActionBar’ın 
sağında 3 noktadan girilir. Bu menüde 
kısayollar ve İstatistik ekranına 
gitmek için kısımlar bulunur. Kitap 
Ekle kısmından Kitap Ekleme 
ekranına, Kütüphane kısmından Ana 
Menü ekranına (Yenilemek için), 
Alınacak Kitaplar kısmından Alınacak 
Kitaplar, İstatistik kısmından İstatistik 
ekranına yönlendirilir.

- **İstatistik Ekranı**

![Statistics](https://user-images.githubusercontent.com/80527393/152342428-baa03ec6-7bbf-424b-bb64-e678b0a542b0.png)

İstatistik ekranına Menü’deki 
İstatistik kısmından girilir. Bu ekranda 
kütüphanedeki kitapların verileri ile 
işlem yapılarak TextView’lerde 
gösterilir.




